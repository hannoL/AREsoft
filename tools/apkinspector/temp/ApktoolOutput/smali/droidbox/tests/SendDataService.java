package droidbox.tests; class SendDataService {/*

.class public Ldroidbox/tests/SendDataService;
.super Landroid/app/Service;
.source "SendDataService.java"


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 15
    invoke-direct {p0}, Landroid/app/Service;-><init>()V

    #p0=(Reference);
    return-void
.end method


# virtual methods
.method public onBind(Landroid/content/Intent;)Landroid/os/IBinder;
    .locals 1
    .parameter "arg0"

    .prologue
    .line 47
    const/4 v0, 0x0

    #v0=(Null);
    return-object v0
.end method

.method public onCreate()V
    .locals 9

    .prologue
    .line 20
    invoke-super {p0}, Landroid/app/Service;->onCreate()V

    .line 21
    const-string v7, "Test"

    #v7=(Reference);
    const-string v8, "[*] SendDataService()"

    #v8=(Reference);
    invoke-static {v7, v8}, Landroid/util/Log;->v(Ljava/lang/String;Ljava/lang/String;)I

    .line 23
    const/4 v4, 0x0

    .line 24
    .local v4, url:Ljava/net/URL;
    #v4=(Null);
    const/4 v6, 0x0

    .line 27
    .local v6, urlConnection:Ljava/net/HttpURLConnection;
    :try_start_0
    #v6=(Null);
    new-instance v5, Ljava/net/URL;

    #v5=(UninitRef);
    const-string v7, "http://pjlantz.com/data.php?data=Hello"

    invoke-direct {v5, v7}, Ljava/net/URL;-><init>(Ljava/lang/String;)V
    :try_end_0
    .catch Ljava/net/MalformedURLException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_1

    .line 28
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

    .line 29
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

    .line 30
    .local v3, rd:Ljava/io/BufferedReader;
    #v3=(Reference);
    const-string v2, ""

    .line 31
    .local v2, line:Ljava/lang/String;
    :cond_0
    #v2=(Reference);
    invoke-virtual {v3}, Ljava/io/BufferedReader;->readLine()Ljava/lang/String;

    move-result-object v2

    if-nez v2, :cond_0

    .line 32
    invoke-virtual {v3}, Ljava/io/BufferedReader;->close()V

    .line 33
    invoke-virtual {v6}, Ljava/net/HttpURLConnection;->disconnect()V
    :try_end_1
    .catch Ljava/net/MalformedURLException; {:try_start_1 .. :try_end_1} :catch_3
    .catch Ljava/io/IOException; {:try_start_1 .. :try_end_1} :catch_2

    move-object v4, v5

    .line 42
    .end local v2           #line:Ljava/lang/String;
    .end local v3           #rd:Ljava/io/BufferedReader;
    .end local v5           #url:Ljava/net/URL;
    .restart local v4       #url:Ljava/net/URL;
    :goto_0
    #v0=(Conflicted);v1=(Conflicted);v2=(Conflicted);v3=(Conflicted);v4=(Reference);v5=(Conflicted);
    return-void

    .line 34
    :catch_0
    #v0=(Uninit);v1=(Uninit);v2=(Uninit);v3=(Uninit);v4=(Null);v6=(Null);
    move-exception v7

    move-object v1, v7

    .line 36
    .local v1, e:Ljava/net/MalformedURLException;
    :goto_1
    #v0=(Conflicted);v1=(Reference);v2=(Conflicted);v3=(Conflicted);v4=(Reference);v6=(Reference);
    invoke-virtual {v1}, Ljava/net/MalformedURLException;->printStackTrace()V

    goto :goto_0

    .line 37
    .end local v1           #e:Ljava/net/MalformedURLException;
    :catch_1
    #v0=(Uninit);v1=(Uninit);v2=(Uninit);v3=(Uninit);v4=(Null);v6=(Null);
    move-exception v7

    move-object v1, v7

    .line 39
    .local v1, e:Ljava/io/IOException;
    :goto_2
    #v0=(Conflicted);v1=(Reference);v2=(Conflicted);v3=(Conflicted);v4=(Reference);v6=(Reference);
    invoke-virtual {v1}, Ljava/io/IOException;->printStackTrace()V

    goto :goto_0

    .line 37
    .end local v1           #e:Ljava/io/IOException;
    .end local v4           #url:Ljava/net/URL;
    .restart local v5       #url:Ljava/net/URL;
    :catch_2
    #v1=(Uninit);v4=(Null);v5=(Reference);v7=(Conflicted);
    move-exception v7

    #v7=(Reference);
    move-object v1, v7

    #v1=(Reference);
    move-object v4, v5

    .end local v5           #url:Ljava/net/URL;
    .restart local v4       #url:Ljava/net/URL;
    #v4=(Reference);
    goto :goto_2

    .line 34
    .end local v4           #url:Ljava/net/URL;
    .restart local v5       #url:Ljava/net/URL;
    :catch_3
    #v1=(Uninit);v4=(Null);v7=(Conflicted);
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

*/}
