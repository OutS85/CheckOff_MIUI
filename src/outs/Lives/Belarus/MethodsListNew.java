package outs.Lives.Belarus;

public class MethodsListNew
{
    public static final String frame1 = "( checkCapability\\(Ljava/lang/String;I\\)Z[\\s\\S]+?)end method";
    public static final String reframe1 = " checkCapability(Ljava/lang/String;I)Z\n.registers 4\n.param p2    # I\n.annotation build Landroid/content/pm/PackageParser\\$SigningDetails\\$CertCapabilities;\n.end annotation\n.end param\nconst/4 v0, 0x1\nreturn v0\n.end method";
    public static final String frame2 = "( checkCapability\\(Landroid/content/pm/PackageParser\\$SigningDetails;I\\)Z[\\s\\S]+?)end method";
    public static final String reframe2 = " checkCapability(Landroid/content/pm/PackageParser\\$SigningDetails;I)Z\n.registers 4\n.param p2    # I\n.annotation build Landroid/content/pm/PackageParser\\$SigningDetails\\$CertCapabilities;\n.end annotation\n.end param\nconst/4 v0, 0x1\nreturn v0\n.end method";
    public static final String frame3 = "( checkCapabilityRecover\\(Landroid/content/pm/PackageParser\\$SigningDetails;I\\)Z[\\s\\S]+?)end method";
    public static final String reframe3 = " checkCapabilityRecover(Landroid/content/pm/PackageParser\\$SigningDetails;I)Z\n.registers 4\n.param p2    # I\n.annotation build Landroid/content/pm/PackageParser\\$SigningDetails\\$CertCapabilities;\n.end annotation\n.end param\n.annotation system Ldalvik/annotation/Throws;\nvalue = {\nLjava/security/cert/CertificateException;\n}\n.end annotation\nconst/4 v0, 0x1\nreturn v0\n.end method";

    public static final String serv1 = "( checkAppSignature\\(\\[Landroid/content/pm/Signature;Ljava/lang/String;Z\\)Z[\\s\\S]+?)end method";
    public static final String reserv1 = " checkAppSignature([Landroid/content/pm/Signature;Ljava/lang/String;Z)Z\n.registers 5\nconst/4 v0, 0x1\nreturn v0\n.end method";
    public static final String serv2 = "( checkDowngrade\\(Landroid/content/pm/PackageParser\\$Package;Landroid/content/pm/PackageInfoLite;\\)V[\\s\\S]+?)end method";
    public static final String serv21 = "( checkDowngrade\\(Lcom/android/server/pm/parsing/pkg/AndroidPackage;Landroid/content/pm/PackageInfoLite;\\)V[\\s\\S]+?)end method";
    public static final String reserv2 = " checkDowngrade(Landroid/content/pm/PackageParser\\$Package;Landroid/content/pm/PackageInfoLite;)V\n.registers 9\n.annotation system Ldalvik/annotation/Throws;\nvalue = {\nLcom/android/server/pm/PackageManagerException;\n}\n.end annotation\nreturn-void\n.end method";
    public static final String reserv21 = " checkDowngrade(Lcom/android/server/pm/parsing/pkg/AndroidPackage;Landroid/content/pm/PackageInfoLite;)V\n.registers 9\n.annotation system Ldalvik/annotation/Throws;\nvalue = {\nLcom/android/server/pm/PackageManagerException;\n}\n.end annotation\nreturn-void\n.end method";
    public static final String serv3 = "( checkSysAppCrack\\(\\)Z[\\s\\S]+?)end method";
    public static final String reserv3 = " checkSysAppCrack()Z\n.registers 2\nconst/4 v0, 0x1\nreturn v0\n.end method";
    public static final String serv4 = "( checkSystemSelfProtection\\(Z\\)V[\\s\\S]+?)end method";
    public static final String reserv4 = " checkSystemSelfProtection(Z)V\n.registers 3\nreturn-void\n.end method";
    public static final String serv5 = "( compareSignatures\\(\\[Landroid/content/pm/Signature;\\[Landroid/content/pm/Signature;\\)I[\\s\\S]+?)end method";
    public static final String reserv5 = " compareSignatures([Landroid/content/pm/Signature;[Landroid/content/pm/Signature;)I\n.registers 10\nconst/4 v1, 0x0\nreturn v1\n.end method";
    public static final String serv6 = "( matchSignaturesCompat\\(Ljava/lang/String;Lcom/android/server/pm/PackageSignatures;Landroid/content/pm/PackageParser\\$SigningDetails;\\)Z[\\s\\S]+?)end method";
    public static final String reserv6 = " matchSignaturesCompat(Ljava/lang/String;Lcom/android/server/pm/PackageSignatures;Landroid/content/pm/PackageParser\\$SigningDetails;)Z\n.locals 11\nconst/4 v0, 0x0\nreturn v0\n.end method";
    public static final String serv7 = "( matchSignaturesRecover\\(Ljava/lang/String;Landroid/content/pm/PackageParser\\$SigningDetails;Landroid/content/pm/PackageParser\\$SigningDetails;I\\)Z[\\s\\S]+?)end method";
    public static final String reserv7 = " matchSignaturesRecover(Ljava/lang/String;Landroid/content/pm/PackageParser\\$SigningDetails;Landroid/content/pm/PackageParser\\$SigningDetails;I)Z\n.locals 4\n.param p3    # I\n.annotation build Landroid/content/pm/PackageParser\\$SigningDetails\\$CertCapabilities;\n.end annotation\n.end param\nconst/4 v0, 0x0\nreturn v0\n.end method";

    public static final String core1 = "( isEqual\\(\\[B\\[B\\)Z[\\s\\S]+?)end method";
    public static final String recore1 = " isEqual([B[B)Z\n.registers 3\nconst/4 v0, 0x1\nreturn v0\n.end method";
    public static final String core2 = "( verify\\(\\[B\\)Z[\\s\\S]+?)end method";
    public static final String recore2 = " verify([B)Z\n.registers 3\n.annotation system Ldalvik/annotation/Throws;\nvalue = {\nLjava/security/SignatureException;\n}\n.end annotation\nconst/4 v0, 0x1\nreturn v0\n.end method";
    public static final String core3 = "( verify\\(\\[BII\\)Z[\\s\\S]+?)end method";
    public static final String recore3 = " verify([BII)Z\n.registers 5\n.annotation system Ldalvik/annotation/Throws;\nvalue = {\nLjava/security/SignatureException;\n}\n.end annotation\nconst/4 v0, 0x1\nreturn v0\n.end method";
    public static final String core4 = "( verifyManifestHash\\(Ljava/util/jar/Manifest;Lsun/security/util/ManifestDigester;Ljava/util/List;\\)Z[\\s\\S]+?)end method";
    public static final String recore4 = " verifyManifestHash(Ljava/util/jar/Manifest;Lsun/security/util/ManifestDigester;Ljava/util/List;)Z\n.registers 16\n.annotation system Ldalvik/annotation/Signature;\nvalue = {\n\"(\",\n\"Ljava/util/jar/Manifest;\",\n\"Lsun/security/util/ManifestDigester;\",\n\"Ljava/util/List<\",\n\"Ljava/lang/Object;\",\n\">;)Z\"\n}\n.end annotation\n.annotation system Ldalvik/annotation/Throws;\nvalue = {\nLjava/io/IOException;,\nLjava/security/SignatureException;\n}\n.end annotation\nconst/4 v0, 0x1\nreturn v0\n.end method";
}
