package outs.Lives.Belarus.CheckOff;

import java.io.*;
import java.nio.file.Files;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static outs.Lives.Belarus.CheckOff.CheckOff.*;
import static outs.Lives.Belarus.CheckOff.MethodsListNew.*;

public class EditMiuiFrameworkThread extends Thread{

    private Pattern pattern;
    private Matcher matcher;

    private static String workspace;

    public EditMiuiFrameworkThread(String path) { workspace = path; }

    @Override
    public void run() {
        try {
            editFilesMiuiFramework(workspace);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void editFilesMiuiFramework(String path) throws IOException
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
                    if (fileEntry.getAbsolutePath().replace(workspace, "").toLowerCase().startsWith(File.separator + "miui-framework")) {
                        if (!se51) {
                            matcher = pattern.compile(serv5).matcher(resource);
                            if (matcher.find()) {
                                isFound = true;
                                se51 = true;
                                resource = matcher.replaceAll(reserv5);
                                BufferedWriter smaliWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileEntry), "UTF-8"));
                                smaliWriter.write(resource);
                                smaliWriter.close();
                                isPatched++;
                                num++;
                                System.out.println("\n" + num + ". Метод compareSignatures([Landroid/content/pm/Signature;[Landroid/content/pm/Signature;)I найден и пропатчен в:\n\t" + fileEntry.getAbsolutePath());
                            }
                        }
                    }
                }
            }
            if (fileEntry.isDirectory()){
                dirscount++;
                if (fileEntry.getAbsolutePath().replace(workspace, "").toLowerCase().startsWith(File.separator + "miui-framework")){
                    editFilesMiuiFramework(fileEntry.getAbsolutePath());
                }
            }
        }
    }
}

