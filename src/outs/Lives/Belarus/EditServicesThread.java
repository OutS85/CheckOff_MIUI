package outs.Lives.Belarus;

import java.io.*;
import java.nio.file.Files;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static outs.Lives.Belarus.CheckOff.*;
import static outs.Lives.Belarus.MethodsListFor10and11.*;

public class EditServicesThread extends Thread {

    private Pattern pattern;
    private Matcher matcher;

    private String workspace;

    public EditServicesThread(String path){
        workspace = path;
    }

    @Override
    public void run(){

        try {
            editFilesServices(workspace);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void editFilesServices(String path) throws IOException {

        if (isPatched == 14){
            return;
        }
        File[] f = (new File(path)).listFiles();
        for (File fileEntry : f) {
            if (fileEntry.isFile()){
                filescount++;
                if (fileEntry.getAbsolutePath().toLowerCase().endsWith(".smali")) {
                    isExist = true;
                    String resource = new String(Files.readAllBytes(fileEntry.toPath()), "UTF-8");
                    if (fileEntry.getAbsolutePath().replace(workspace, "").toLowerCase().startsWith(File.separator + "services")) {
                        if (!se1) {
                            matcher = Pattern.compile(serv1).matcher(resource);
                            if (matcher.find()) {
                                isFound = true;
                                se1 = true;
                                resource = matcher.replaceAll(reserv1);
                                BufferedWriter smaliWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileEntry), "UTF-8"));
                                smaliWriter.write(resource);
                                smaliWriter.close();
                                isPatched++;
                                num++;
                                System.out.println("\n" + num +". Метод checkAppSignature найден и пропатчен в:\n\t" + fileEntry.getAbsolutePath());
                            }
                        }
                        if (!se2) {
                            matcher = Pattern.compile(serv2).matcher(resource);
                            if (matcher.find()) {
                                isFound = true;
                                se2 = true;
                                resource = matcher.replaceAll(reserv2);
                                BufferedWriter smaliWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileEntry), "UTF-8"));
                                smaliWriter.write(resource);
                                smaliWriter.close();
                                isPatched++;
                                num++;
                                System.out.println("\n" + num +". Метод checkDowngrade найден и пропатчен в:\n\t" + fileEntry.getAbsolutePath());
                            }
                        }
                        if (!se3) {
                            matcher = pattern.compile(serv3).matcher(resource);
                            if (matcher.find()) {
                                isFound = true;
                                se3 = true;
                                resource = matcher.replaceAll(reserv3);
                                BufferedWriter smaliWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileEntry), "UTF-8"));
                                smaliWriter.write(resource);
                                smaliWriter.close();
                                isPatched++;
                                num++;
                                System.out.println("\n" + num +". Метод checkSysAppCrack найден и пропатчен в:\n\t" + fileEntry.getAbsolutePath());
                            }
                        }
                        if (!se4) {
                            matcher = pattern.compile(serv4).matcher(resource);
                            if (matcher.find()) {
                                isFound = true;
                                se4 = true;
                                resource = matcher.replaceAll(reserv4);
                                BufferedWriter smaliWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileEntry), "UTF-8"));
                                smaliWriter.write(resource);
                                smaliWriter.close();
                                isPatched++;
                                num++;
                                System.out.println("\n" + num +". Метод checkSystemSelfProtection найден и пропатчен в:\n\t" + fileEntry.getAbsolutePath());
                            }
                        }
                        if (!se5) {
                            matcher = pattern.compile(serv5).matcher(resource);
                            if (matcher.find()) {
                                isFound = true;
                                se5 = true;
                                resource = matcher.replaceAll(reserv5);
                                BufferedWriter smaliWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileEntry), "UTF-8"));
                                smaliWriter.write(resource);
                                smaliWriter.close();
                                isPatched++;
                                num++;
                                System.out.println("\n" + num +". Метод compareSignatures найден и пропатчен в:\n\t" + fileEntry.getAbsolutePath());
                            }
                        }
                        if (!se6) {
                            matcher = pattern.compile(serv6).matcher(resource);
                            if (matcher.find()) {
                                isFound = true;
                                se6 = true;
                                resource = matcher.replaceAll(reserv6);
                                BufferedWriter smaliWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileEntry), "UTF-8"));
                                smaliWriter.write(resource);
                                smaliWriter.close();
                                isPatched++;
                                num++;
                                System.out.println("\n" + num +". Метод matchSignaturesCompat найден и пропатчен в:\n\t" + fileEntry.getAbsolutePath());
                            }
                        }
                        if (!se7) {
                            matcher = pattern.compile(serv7).matcher(resource);
                            if (matcher.find()) {
                                isFound = true;
                                se7 = true;
                                resource = matcher.replaceAll(reserv7);
                                BufferedWriter smaliWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileEntry), "UTF-8"));
                                smaliWriter.write(resource);
                                smaliWriter.close();
                                isPatched++;
                                num++;
                                System.out.println("\n" + num +". Метод matchSignaturesRecover найден и пропатчен в:\n\t" + fileEntry.getAbsolutePath());
                            }
                        }
                    }
                }
            }
            if (fileEntry.isDirectory()){
                dirscount++;
                if (fileEntry.getAbsolutePath().replace(workspace, "").toLowerCase().startsWith(File.separator + "services")){
                    editFilesServices(fileEntry.getAbsolutePath());
                }
            }
        }
    }
}
