package outs.Lives.Belarus;

public class MethodsListOld {

    public static final String frame1 = "(\\.method public checkCapability\\(Ljava/lang/String;I\\)Z[\\s\\S]+?)end method";
    public static final String reframe1 = ".method public checkCapability(Ljava/lang/String;I)Z\n.registers 4\n.param p2    # I\n.annotation build Landroid/content/pm/PackageParser\\$SigningDetails\\$CertCapabilities;\n.end annotation\n.end param\nconst/4 v0, 0x1\nreturn v0\n.end method";
    public static final String frame2 = "(\\.method public checkCapability\\(Landroid/content/pm/PackageParser\\$SigningDetails;I\\)Z[\\s\\S]+?)end method";
    public static final String reframe2 = ".method public checkCapability(Landroid/content/pm/PackageParser\\$SigningDetails;I)Z\n.registers 4\n.param p2    # I\n.annotation build Landroid/content/pm/PackageParser\\$SigningDetails\\$CertCapabilities;\n.end annotation\n.end param\nconst/4 v0, 0x1\nreturn v0\n.end method";
    public static final String frame3 = "(\\.method public checkCapabilityRecover\\(Landroid/content/pm/PackageParser\\$SigningDetails;I\\)Z[\\s\\S]+?)end method";
    public static final String reframe3 = ".method public checkCapabilityRecover(Landroid/content/pm/PackageParser\\$SigningDetails;I)Z\n.registers 4\n.param p2    # I\n.annotation build Landroid/content/pm/PackageParser\\$SigningDetails\\$CertCapabilities;\n.end annotation\n.end param\n.annotation system Ldalvik/annotation/Throws;\nvalue = {\nLjava/security/cert/CertificateException;\n}\n.end annotation\nconst/4 v0, 0x1\nreturn v0\n.end method";

    public static final String serv1 = "(\\.method private checkAppSignature\\(\\[Landroid/content/pm/Signature;Ljava/lang/String;Z\\)Z[\\s\\S]+?)end method";
    public static final String reserv1 = ".method private checkAppSignature([Landroid/content/pm/Signature;Ljava/lang/String;Z)Z\n.registers 5\nconst/4 v0, 0x1\nreturn v0\n.end method";
    public static final String serv2 = "(\\.method private static checkDowngrade\\(Landroid/content/pm/PackageParser\\$Package;Landroid/content/pm/PackageInfoLite;\\)V[\\s\\S]+?)end method";
    public static final String reserv2 = ".method private static checkDowngrade(Landroid/content/pm/PackageParser\\$Package;Landroid/content/pm/PackageInfoLite;)V\n.registers 9\n.annotation system Ldalvik/annotation/Throws;\nvalue = {\nLcom/android/server/pm/PackageManagerException;\n}\n.end annotation\nreturn-void\n.end method";
    public static final String serv3 = "(\\.method private checkSysAppCrack\\(\\)Z[\\s\\S]+?)end method";
    public static final String reserv3 = ".method private checkSysAppCrack()Z\n.registers 2\nconst/4 v0, 0x1\nreturn v0\n.end method";
    public static final String serv4 = "(\\.method private checkSystemSelfProtection\\(Z\\)V[\\s\\S]+?)end method";
    public static final String reserv4 = ".method private checkSystemSelfProtection(Z)V\n.registers 3\nreturn-void\n.end method";
    public static final String serv5 = "(\\.method public static compareSignatures\\(\\[Landroid/content/pm/Signature;\\[Landroid/content/pm/Signature;\\)I[\\s\\S]+?)end method";
    public static final String reserv5 = ".method public static compareSignatures([Landroid/content/pm/Signature;[Landroid/content/pm/Signature;)I\n.registers 10\nconst/4 v1, 0x0\nreturn v1\n.end method";
    public static final String serv6 = "(\\.method private static matchSignaturesCompat\\(Ljava/lang/String;Lcom/android/server/pm/PackageSignatures;Landroid/content/pm/PackageParser\\$SigningDetails;\\)Z[\\s\\S]+?)end method";
    public static final String reserv6 = ".method private static matchSignaturesCompat(Ljava/lang/String;Lcom/android/server/pm/PackageSignatures;Landroid/content/pm/PackageParser\\$SigningDetails;)Z\n.locals 11\nconst/4 v0, 0x0\nreturn v0\n.end method";
    public static final String serv7 = "(\\.method private static matchSignaturesRecover\\(Ljava/lang/String;Landroid/content/pm/PackageParser\\$SigningDetails;Landroid/content/pm/PackageParser\\$SigningDetails;I\\)Z[\\s\\S]+?)end method";
    public static final String reserv7 = ".method private static matchSignaturesRecover(Ljava/lang/String;Landroid/content/pm/PackageParser\\$SigningDetails;Landroid/content/pm/PackageParser\\$SigningDetails;I)Z\n.locals 4\n.param p3    # I\n.annotation build Landroid/content/pm/PackageParser\\$SigningDetails\\$CertCapabilities;\n.end annotation\n.end param\nconst/4 v0, 0x0\nreturn v0\n.end method";

    public static final String core1 = "(\\.method public static isEqual\\(\\[B\\[B\\)Z[\\s\\S]+?)end method";
    public static final String recore1 = ".method public static isEqual([B[B)Z\n.registers 3\nconst/4 v0, 0x1\nreturn v0\n.end method";
    public static final String core2 = "(\\.method public final verify\\(\\[B\\)Z[\\s\\S]+?)end method";
    public static final String recore2 = ".method public final verify([B)Z\n.registers 3\n.annotation system Ldalvik/annotation/Throws;\nvalue = {\nLjava/security/SignatureException;\n}\n.end annotation\nconst/4 v0, 0x1\nreturn v0\n.end method";
    public static final String core3 = "(\\.method public final verify\\(\\[BII\\)Z[\\s\\S]+?)end method";
    public static final String recore3 = ".method public final verify([BII)Z\n.registers 5\n.annotation system Ldalvik/annotation/Throws;\nvalue = {\nLjava/security/SignatureException;\n}\n.end annotation\nconst/4 v0, 0x1\nreturn v0\n.end method";
    public static final String core4 = "(\\.method private verifyManifestHash\\(Ljava/util/jar/Manifest;Lsun/security/util/ManifestDigester;Ljava/util/List;\\)Z[\\s\\S]+?)end method";
    public static final String recore4 = ".method private verifyManifestHash(Ljava/util/jar/Manifest;Lsun/security/util/ManifestDigester;Ljava/util/List;)Z\n.registers 16\n.annotation system Ldalvik/annotation/Signature;\nvalue = {\n\"(\",\n\"Ljava/util/jar/Manifest;\",\n\"Lsun/security/util/ManifestDigester;\",\n\"Ljava/util/List<\",\n\"Ljava/lang/Object;\",\n\">;)Z\"\n}\n.end annotation\n.annotation system Ldalvik/annotation/Throws;\nvalue = {\nLjava/io/IOException;,\nLjava/security/SignatureException;\n}\n.end annotation\nconst/4 v0, 0x1\nreturn v0\n.end method";

}
