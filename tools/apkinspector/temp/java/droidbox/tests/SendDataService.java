// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   SendDataService.java

package droidbox.tests;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;
import java.io.*;
import java.net.*;

public class SendDataService extends Service
{

    public SendDataService()
    {
    }

    public IBinder onBind(Intent intent)
    {
        return null;
    }

    public void onCreate()
    {
        super.onCreate();
        int i = Log.v("Test", "[*] SendDataService()");
        URL url = new URL("http://pjlantz.com/data.php?data=Hello");
        HttpURLConnection httpurlconnection = (HttpURLConnection)url.openConnection();
        java.io.InputStream inputstream = httpurlconnection.getInputStream();
        InputStreamReader inputstreamreader = new InputStreamReader(inputstream);
        BufferedReader bufferedreader;
        for(bufferedreader = new BufferedReader(inputstreamreader); bufferedreader.readLine() != null;);
        bufferedreader.close();
        httpurlconnection.disconnect();
        URL url1 = url;
_L1:
        return;
        Object obj;
        obj;
_L3:
        ((MalformedURLException) (obj)).printStackTrace();
          goto _L1
        obj;
_L2:
        ((IOException) (obj)).printStackTrace();
          goto _L1
        obj;
        URL url2 = url;
          goto _L2
        obj;
        URL url3 = url;
          goto _L3
    }
}
