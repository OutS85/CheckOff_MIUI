package outs.Lives.Belarus;

import java.io.*;
import java.nio.file.Files;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static outs.Lives.Belarus.CheckOff.*;
import static outs.Lives.Belarus.MethodsListNew.*;

public class EditCoreThread extends Thread{

    private Pattern pattern;
    private Matcher matcher;

    private static String workspace;

    public EditCoreThread(String path){
        workspace = path;
    }

    @Override
    public void run(){

        try {
            editFilesCore(workspace);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void editFilesCore(String path) throws IOException {

        if (androidVersion != 12){
            if (isPatched == 14) {
                return;
            }
        }else if (isPatched == 15){
            return;
        }
        File[] f = (new File(path)).listFiles();
        for (File fileEntry : f) {
            if (fileEntry.isFile()){
                filescount++;
                if (fileEntry.getAbsolutePath().toLowerCase().endsWith(".smali")) {
                    isExist = true;
                    String resource = new String(Files.readAllBytes(fileEntry.toPath()), "UTF-8");
                    if (fileEntry.getAbsolutePath().replace(workspace, "").toLowerCase().startsWith(File.separator + "core-oj")) {
                        if (!co1) {
                            matcher = pattern.compile(core1).matcher(resource);
                            if (matcher.find()) {
                                isFound = true;
                                co1 = true;
                                resource = matcher.replaceAll(recore1);
                                BufferedWriter smaliWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileEntry), "UTF-8"));
                                smaliWriter.write(resource);
                                smaliWriter.close();
                                isPatched++;
                                num++;
                                System.out.println("\n" + num +". Метод isEqual найден и пропатчен в:\n\t" + fileEntry.getAbsolutePath());
                            }
                        }
                        if (!co2) {
                            matcher = pattern.compile(core2).matcher(resource);
                            if (matcher.find()) {
                                isFound = true;
                                co2 = true;
                                resource = matcher.replaceAll(recore2);
                                BufferedWriter smaliWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileEntry), "UTF-8"));
                                smaliWriter.write(resource);
                                smaliWriter.close();
                                isPatched++;
                                num++;
                                System.out.println("\n" + num +". Метод verify([B)Z найден и пропатчен в:\n\t" + fileEntry.getAbsolutePath());
                            }
                        }
                        if (!co3) {
                            matcher = pattern.compile(core3).matcher(resource);
                            if (matcher.find()) {
                                isFound = true;
                                co3 = true;
                                resource = matcher.replaceAll(recore3);
                                BufferedWriter smaliWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileEntry), "UTF-8"));
                                smaliWriter.write(resource);
                                smaliWriter.close();
                                isPatched++;
                                num++;
                                System.out.println("\n" + num +". Метод verify([BII)Z найден и пропатчен в:\n\t" + fileEntry.getAbsolutePath());
                            }
                        }
                        if (!co4) {
                            matcher = pattern.compile(core4).matcher(resource);
                            if (matcher.find()) {
                                isFound = true;
                                co4 = true;
                                resource = matcher.replaceAll(recore4);
                                BufferedWriter smaliWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileEntry), "UTF-8"));
                                smaliWriter.write(resource);
                                smaliWriter.close();
                                isPatched++;
                                num++;
                                System.out.println("\n" + num +". Метод verifyManifestHash найден и пропатчен в:\n\t" + fileEntry.getAbsolutePath());
                            }
                        }
                    }
                }
            }
            if (fileEntry.isDirectory()){
                dirscount++;
                if (fileEntry.getAbsolutePath().replace(workspace, "").toLowerCase().startsWith(File.separator + "core-oj")){
                    editFilesCore(fileEntry.getAbsolutePath());
                }
            }
        }
    }
}
