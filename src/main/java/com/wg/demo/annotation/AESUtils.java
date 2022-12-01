package com.wg.demo.annotation;

import org.apache.commons.lang3.StringUtils;
import sun.misc.BASE64Encoder;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * @Author : dongpo
 */
public class AESUtils {
    //调用获取任务列表接口
    private static final String url = "https://test-crm.com/openapi/v1/task/getTasks?companyId=8888&pageNum=1&pageSize=10";
    private static final String APP_KEY = "BB1w85jIgRA52nSp";
    private static final String APP_SECRET = "sxJTHsBDPPpFqaW3rj31yMWoX9vW8u";
    static final String sendMsgFlag = "true";
    public static void main(String[] args) {

        String result = AESUtils.sendGet(url, APP_KEY, APP_SECRET);
        System.out.print( result);
        String date = toGMTString(new Date());
        System.out.println("datetime: "+date);
        String strto = APP_KEY + "\n" + date;
        System.out.println("appkey: "+APP_KEY);
        System.out.println("sign: "+HMACSha1(strto, APP_SECRET));
        System.out.println(StringUtils.equalsIgnoreCase(sendMsgFlag, "true"));
        System.out.println(StringUtils.equalsIgnoreCase(sendMsgFlag, "false"));

    }

    public static String sendGet(String url, String ak_id, String ak_secret) {
        HttpURLConnection conn = null;
        PrintWriter out = null;
        InputStream in = null;
        String result = "";
        try {
            String newURL = getNewUrlByUrlEncodeParam(url);
            URL realUrl = new URL(newURL);

            String date = toGMTString(new Date());
            String strto = APP_KEY + "\n" + date;
            String sign = HMACSha1(strto, ak_secret); //生成sign

            System.out.println(sign);
//            conn = (HttpURLConnection) realUrl.openConnection();
//            conn.setRequestMethod("GET");
//            conn.setRequestProperty("accept", "application/json;charset=utf-8");
//            conn.setRequestProperty("content-type", "application/json;charset=utf-8");
//            conn.setRequestProperty("datetime", date);
//            conn.setRequestProperty("appkey", ak_id);
//            conn.setRequestProperty("sign", sign);
//
//            conn.connect();
//            int rc = conn.getResponseCode();
//            if (rc == 200) {
//                in = conn.getInputStream();
//            } else {
//                in = conn.getErrorStream();
//            }
//            result = changeInputStream(in, "UTF-8");
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            closeConnection(conn, out, in);
        }
        return result;
    }

    private static void closeConnection(HttpURLConnection conn, Writer out, InputStream in) {
        try {
            if (conn != null) {
                conn.disconnect();
            }
            if (out != null) {
                out.close();
            }
            if (in != null) {
                in.close();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private static String changeInputStream(InputStream inputStream,
                                            String encode) {

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] data = new byte[1024];
        int len = 0;
        String result = "";
        if (inputStream != null) {
            try {
                while ((len = inputStream.read(data)) != -1) {
                    byteArrayOutputStream.write(data, 0, len);
                }
                result = new String(byteArrayOutputStream.toByteArray(), encode);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    public static String HMACSha1(String strto, String key) {
        String result;
        try {
            SecretKeySpec signingKey = new SecretKeySpec(key.getBytes(), "HmacSHA1");
            Mac mac = Mac.getInstance("HmacSHA1");
            mac.init(signingKey);
            byte[] rawHmac = mac.doFinal(strto.getBytes());
            result = (new BASE64Encoder()).encode(rawHmac);
        } catch (Exception e) {
            throw new Error("Failed to generate HMAC : " + e.getMessage());
        }
        return result;
    }

    public static String toGMTString(Date date) {
        SimpleDateFormat df = new SimpleDateFormat("E, dd MMM yyyy HH:mm:ss z", Locale.UK);
        df.setTimeZone(new java.util.SimpleTimeZone(0, "GMT"));
        return df.format(date);

    }

    private static String getNewUrlByUrlEncodeParam(String url) throws UnsupportedEncodingException {
        StringBuilder urlForEncode = new StringBuilder();
        @SuppressWarnings("unused")
        String newURL = "";
        if (url.contains("=")){
            String[] urlBeforeEncode = url.split("=");
            for (int i = 1; i < urlBeforeEncode.length; i++) {
                if (urlBeforeEncode[i].contains("&")){
                    String[] parmsplit = urlBeforeEncode[i].split("&");
                    URLEncoder.encode(parmsplit[0], "utf-8");
                    urlBeforeEncode[i] = parmsplit[0] + "&" + parmsplit[1];
                }
                if (i == urlBeforeEncode.length - 1) {
                    urlBeforeEncode[i] =  URLEncoder.encode(urlBeforeEncode[i], "utf-8");
                }
                urlForEncode = urlForEncode.append(urlBeforeEncode[i]);
                if (i != urlBeforeEncode.length -1 ) {
                    urlForEncode = urlForEncode.append("=");
                }
            }
            newURL = urlBeforeEncode[0] + "=" + urlForEncode.toString();

        }
        return url;
    }

}
