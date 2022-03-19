package outs.Lives.Belarus;

import java.io.*;
import java.nio.file.Files;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static outs.Lives.Belarus.MethodsListFor10and11.*;

public class CheckOff {

    static EditServicesThread myThreadServices;
    static EditCoreThread myThreadCore;

    volatile public static int num = 0;
    volatile public static int filescount = 0;
    volatile public static int dirscount = 0;
    volatile public static int isPatched = 0;

    private static String WorkPath;
    private static Pattern pattern;
    private static Matcher matcher;

    private static int isPatchedTarget = 0;
    public static boolean isExist = false;
    private static boolean isTargetProgram;
    public static boolean isFound = false;
    public static boolean fr1 = false, fr2 = false, fr3 = false, se1 = false, se2 = false, se3 = false, se4 = false, se5 = false, se6 = false, se7 = false, co1 = false, co2 = false, co3 = false, co4 = false;
    


    public CheckOff(String workPath, FileChooser fc) throws Exception {
        long startTime = System.currentTimeMillis();
        WorkPath = workPath;
        System.out.println("Текущая папка: " + WorkPath);
        fc.dispose();
        if (!editFilesTarget(WorkPath)){
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            System.out.println("Целевая программа не нашла всех нужных методов или классов на своих местах, поэтому запущена программа общего поиска. Первый раз может занять до двух минут. Терпение...\n");
//            System.out.println(System.getProperty("java.class.path"));        //На будущее: получение пути из которого запущен jar
            num = 0;
            editFiles(WorkPath);
//            myThreadCore.join();
//            myThreadServices.join();
        }
        if (!isExist & !isFound & !isTargetProgram) {
            System.out.println("\nНе найдено файлов или методов для патча");
        }
        int patched;
        if (isTargetProgram){
            patched = isPatchedTarget;
        }else
            patched = isPatched;
        System.out.println("\nПропатчено методов: " + patched + " из 14");
        if (patched == 0){
            System.out.println("\nНеудачно! Не найдено ни одного соответствующего метода.");
        }else if (patched < 14 & patched > 0){
            System.out.println("\nПропатчено меньше методов, чем надо. Возможно не хватает каких-либо jar файлов.");
            System.out.println("\nГотово частично.");
        }else if (isTargetProgram){
            System.out.println("ГОТОВО! Отработала целевая программа.");
        }else {
            System.out.println("ГОТОВО! Отработала программа общего поиска.");
            System.out.println("Всего проверено " + filescount + " файлов в " + dirscount + " папках.");
        }
        long endTime = System.currentTimeMillis();
        System.out.println("Затрачено времени: " + (endTime - startTime)/1000 + " секунд");
        System.exit(0);
    }

    private static void editFiles(String path) throws Exception {

        myThreadServices = new EditServicesThread(WorkPath);
        myThreadServices.start();
        myThreadCore = new EditCoreThread(WorkPath);
        myThreadCore.start();
        editFilesFramework(path);
//        editFilesCore(path);
//        editFilesServices(path);
    }

    private static void editFilesFramework(String path) throws Exception {

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
                    if (fileEntry.getAbsolutePath().replace(WorkPath, "").toLowerCase().startsWith(File.separator + "framework")) {
                        if (!fr1) {
                            matcher = pattern.compile(frame1).matcher(resource);
                            if (matcher.find()) {
                                isFound = true;
                                fr1 = true;
                                resource = matcher.replaceAll(reframe1);
                                BufferedWriter smaliWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileEntry), "UTF-8"));
                                smaliWriter.write(resource);
                                smaliWriter.close();
                                isPatched++;
                                num++;
                                System.out.println("\n" + num + ". Метод checkCapability(Ljava/lang/String;I)Z найден и пропатчен в:\n\t" + fileEntry.getAbsolutePath());
                            }
                        }
                        if (!fr2) {
                            matcher = pattern.compile(frame2).matcher(resource);
                            if (matcher.find()) {
                                isFound = true;
                                fr2 = true;
                                resource = matcher.replaceAll(reframe2);
                                BufferedWriter smaliWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileEntry), "UTF-8"));
                                smaliWriter.write(resource);
                                smaliWriter.close();
                                isPatched++;
                                num++;
                                System.out.println("\n" + num + ". Метод checkCapability(Landroid/content/pm/PackageParser$SigningDetails;I)Z найден и пропатчен в:\n\t" + fileEntry.getAbsolutePath());
                            }
                        }
                        if (!fr3) {
                            matcher = pattern.compile(frame3).matcher(resource);
                            if (matcher.find()) {
                                isFound = true;
                                fr3 = true;
                                resource = matcher.replaceAll(reframe3);
                                BufferedWriter smaliWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileEntry), "UTF-8"));
                                smaliWriter.write(resource);
                                smaliWriter.close();
                                isPatched++;
                                num++;
                                System.out.println("\n" + num + ". Метод checkCapabilityRecover найден и пропатчен в:\n\t" + fileEntry.getAbsolutePath());
                            }
                        }
                    }
                }
            }
            if (fileEntry.isDirectory()){
                dirscount++;
                if (fileEntry.getAbsolutePath().replace(WorkPath, "").toLowerCase().startsWith(File.separator + "framework")){
                    editFilesFramework(fileEntry.getAbsolutePath());
                }
            }
        }
    }

    private static void editFilesCore(String path) throws IOException {

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
                    if (fileEntry.getAbsolutePath().replace(WorkPath, "").toLowerCase().startsWith(File.separator + "core-oj")) {
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
                if (fileEntry.getAbsolutePath().replace(WorkPath, "").toLowerCase().startsWith(File.separator + "core-oj")){
                    editFilesCore(fileEntry.getAbsolutePath());
                }
            }
        }
    }

    private static void editFilesServices(String path) throws IOException {

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
                    if (fileEntry.getAbsolutePath().replace(WorkPath, "").toLowerCase().startsWith(File.separator + "services")) {
                        if (!se1) {
                            matcher = pattern.compile(serv1).matcher(resource);
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
                            matcher = pattern.compile(serv2).matcher(resource);
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
                if (fileEntry.getAbsolutePath().replace(WorkPath, "").toLowerCase().startsWith(File.separator + "services")){
                    editFilesServices(fileEntry.getAbsolutePath());
                }
            }
        }
    }

    private static boolean editFilesTarget(String path){
        try {
            editFilesTargetFramework(path);
            editFilesTargetCore(path);
            editFilesTargetServices(path);
        }catch (Exception e) {
            System.out.println();
        }
        isTargetProgram = (isPatchedTarget == 14);
        return (isPatchedTarget == 14);
    }

    private static void editFilesTargetFramework(String path) throws Exception {
        File frameworkTarget = new File(path + "\\framework\\smali\\android\\content\\pm\\PackageParser$SigningDetails.smali");
        String resource = new String(Files.readAllBytes(frameworkTarget.toPath()), "UTF-8");
        matcher = pattern.compile(frame1).matcher(resource);
        if (matcher.find()) {
            resource = matcher.replaceAll(reframe1);
            BufferedWriter smaliWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(frameworkTarget), "UTF-8"));
            smaliWriter.write(resource);
            smaliWriter.close();
            isPatchedTarget++;
            num++;
            System.out.println(num +". Метод checkCapability(Ljava/lang/String;I)Z пропатчен!");
        }
        matcher = pattern.compile(frame2).matcher(resource);
        if (matcher.find()) {
            resource = matcher.replaceAll(reframe2);
            BufferedWriter smaliWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(frameworkTarget), "UTF-8"));
            smaliWriter.write(resource);
            smaliWriter.close();
            isPatchedTarget++;
            num++;
            System.out.println(num +". Метод checkCapability(Landroid/content/pm/PackageParser$SigningDetails;I)Z пропатчен!");
        }
        matcher = pattern.compile(frame3).matcher(resource);
        if (matcher.find()) {
            resource = matcher.replaceAll(reframe3);
            BufferedWriter smaliWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(frameworkTarget), "UTF-8"));
            smaliWriter.write(resource);
            smaliWriter.close();
            isPatchedTarget++;
            num++;
            System.out.println(num +". Метод checkCapabilityRecover(Landroid/content/pm/PackageParser$SigningDetails;I)Z пропатчен!");
        }
    }

    private static void editFilesTargetServices(String path) throws Exception {
        File servicesTarget;
        File[] f = (new File(path + "\\services")).listFiles();
        if (f.length > 1){
            servicesTarget = new File(path + "\\services\\smali_classes2\\com\\miui\\server\\SecurityManagerService.smali");
        }else
            servicesTarget = new File(path + "\\services\\smali\\com\\miui\\server\\SecurityManagerService.smali");
        String resource = new String(Files.readAllBytes(servicesTarget.toPath()), "UTF-8");
        matcher = pattern.compile(serv1).matcher(resource);
        if (matcher.find()) {
            resource = matcher.replaceAll(reserv1);
            BufferedWriter smaliWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(servicesTarget), "UTF-8"));
            smaliWriter.write(resource);
            smaliWriter.close();
            isPatchedTarget++;
            num++;
            System.out.println(num +". Метод checkAppSignature пропатчен!");
        }
        matcher = pattern.compile(serv3).matcher(resource);
        if (matcher.find()) {
            resource = matcher.replaceAll(reserv3);
            BufferedWriter smaliWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(servicesTarget), "UTF-8"));
            smaliWriter.write(resource);
            smaliWriter.close();
            isPatchedTarget++;
            num++;
            System.out.println(num +". Метод checkSysAppCrack пропатчен!");
        }
        matcher = pattern.compile(serv4).matcher(resource);
        if (matcher.find()) {
            resource = matcher.replaceAll(reserv4);
            BufferedWriter smaliWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(servicesTarget), "UTF-8"));
            smaliWriter.write(resource);
            smaliWriter.close();
            isPatchedTarget++;
            num++;
            System.out.println(num +". Метод checkSystemSelfProtection(Z)V пропатчен!");
        }

        servicesTarget = new File(path + "\\services\\smali\\com\\android\\server\\pm\\PackageManagerServiceUtils.smali");
        resource = new String(Files.readAllBytes(servicesTarget.toPath()), "UTF-8");
        matcher = pattern.compile(serv5).matcher(resource);
        if (matcher.find()) {
            resource = matcher.replaceAll(reserv5);
            BufferedWriter smaliWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(servicesTarget), "UTF-8"));
            smaliWriter.write(resource);
            smaliWriter.close();
            isPatchedTarget++;
            num++;
            System.out.println(num +". Метод compareSignatures пропатчен!");
        }
        matcher = pattern.compile(serv6).matcher(resource);
        if (matcher.find()) {
            resource = matcher.replaceAll(reserv6);
            BufferedWriter smaliWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(servicesTarget), "UTF-8"));
            smaliWriter.write(resource);
            smaliWriter.close();
            isPatchedTarget++;
            num++;
            System.out.println(num +". Метод matchSignaturesCompat пропатчен!");
        }
        matcher = pattern.compile(serv7).matcher(resource);
        if (matcher.find()) {
            resource = matcher.replaceAll(reserv7);
            BufferedWriter smaliWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(servicesTarget), "UTF-8"));
            smaliWriter.write(resource);
            smaliWriter.close();
            isPatchedTarget++;
            num++;
            System.out.println(num +". Метод matchSignaturesRecover пропатчен!");
        }

        servicesTarget = new File(path + "\\services\\smali\\com\\android\\server\\pm\\PackageManagerService.smali");
        resource = new String(Files.readAllBytes(servicesTarget.toPath()), "UTF-8");
        matcher = pattern.compile(serv2).matcher(resource);
        if (matcher.find()) {
            resource = matcher.replaceAll(reserv2);
            BufferedWriter smaliWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(servicesTarget), "UTF-8"));
            smaliWriter.write(resource);
            smaliWriter.close();
            isPatchedTarget++;
            num++;
            System.out.println(num +". Метод checkDowngrade пропатчен!");
        }
    }

    private static void editFilesTargetCore(String path) throws Exception {
        File coreTarget = new File(path + "\\core-oj\\smali\\java\\security\\Signature.smali");
        String resource = new String(Files.readAllBytes(coreTarget.toPath()), "UTF-8");
        matcher = pattern.compile(core2).matcher(resource);
        if (matcher.find()) {
            resource = matcher.replaceAll(recore2);
            BufferedWriter smaliWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(coreTarget), "UTF-8"));
            smaliWriter.write(resource);
            smaliWriter.close();
            isPatchedTarget++;
            num++;
            System.out.println(num +". Метод verify([B)Z пропатчен!");
        }
        matcher = pattern.compile(core3).matcher(resource);
        if (matcher.find()) {
            resource = matcher.replaceAll(recore3);
            BufferedWriter smaliWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(coreTarget), "UTF-8"));
            smaliWriter.write(resource);
            smaliWriter.close();
            isPatchedTarget++;
            num++;
            System.out.println(num +". Метод verify([BII)Z пропатчен!");
        }

        coreTarget = new File(path + "\\core-oj\\smali\\sun\\security\\util\\SignatureFileVerifier.smali");
        resource = new String(Files.readAllBytes(coreTarget.toPath()), "UTF-8");
        matcher = pattern.compile(core4).matcher(resource);
        if (matcher.find()) {
            resource = matcher.replaceAll(recore4);
            BufferedWriter smaliWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(coreTarget), "UTF-8"));
            smaliWriter.write(resource);
            smaliWriter.close();
            isPatchedTarget++;
            num++;
            System.out.println(num +". Метод verifyManifestHash(Ljava/util/jar/Manifest;Lsun/security/util/ManifestDigester;Ljava/util/List;)Z пропатчен!");
        }

        coreTarget = new File(path + "\\core-oj\\smali\\java\\security\\MessageDigest.smali");
        resource = new String(Files.readAllBytes(coreTarget.toPath()), "UTF-8");
        matcher = pattern.compile(core1).matcher(resource);
        if (matcher.find()) {
            resource = matcher.replaceAll(recore1);
            BufferedWriter smaliWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(coreTarget), "UTF-8"));
            smaliWriter.write(resource);
            smaliWriter.close();
            isPatchedTarget++;
            num++;
            System.out.println(num +". Метод isEqual([B[B)Z пропатчен!");
        }
    }
}
