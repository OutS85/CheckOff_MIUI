package outs.Lives.Belarus.CheckOff;

import java.io.*;
import java.nio.file.Files;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static outs.Lives.Belarus.CheckOff.CheckOff.*;
import static outs.Lives.Belarus.CheckOff.MethodsListNew.*;

public class EditMiuiServicesThread extends Thread {

    private Pattern pattern;
    private Matcher matcher;

    private static String workspace;

    public EditMiuiServicesThread(String path) { workspace = path; }

    @Override
    public void run() {

        try {
            editFilesMiuiServices(workspace);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void editFilesMiuiServices(String path) throws IOException
    {
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
                    if (fileEntry.getAbsolutePath().replace(workspace, "").toLowerCase().startsWith(File.separator + "miui-services")) {
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
                    }
                }
            }
            if (fileEntry.isDirectory()){
                dirscount++;
                if (fileEntry.getAbsolutePath().replace(workspace, "").toLowerCase().startsWith(File.separator + "miui-services")){
                    editFilesMiuiServices(fileEntry.getAbsolutePath());
                }
            }
        }

    }
}
