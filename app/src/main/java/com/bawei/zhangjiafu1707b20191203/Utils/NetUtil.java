package com.bawei.zhangjiafu1707b20191203.Utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.util.Log;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * 张家辅
 * 2019年12月3日
 * 网络工具类
 */
public class NetUtil {
    //使用单例模式封装网络工具类
    private static  NetUtil netUtil = new NetUtil();

    private NetUtil() {
    }

    public static NetUtil getInstance() {
        return netUtil;
    }

//判断网络状态
    public boolean has(Context context){
        //创建网络管理类对象
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        //获取网络信息
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        //判断网络是否正常
        if(activeNetworkInfo!=null&&activeNetworkInfo.isAvailable()){
            //正常返回true
            return true;
        }else {
            //异常返回false
            return false;
        }
    }


    //h获取字符串的方法
    @SuppressLint("StaticFieldLeak")
    public void getjson(final String strUrl, final Datat datat){
        new AsyncTask<Void, Void, String>() {
            @Override
            protected void onPostExecute(String s) {
                datat.get(s);
            }

            @Override
            protected String doInBackground(Void... voids) {
                InputStream inputStream = null;
                String ioString = null;
                try {
                    //创建远程连接对象
                    URL url = new URL(strUrl);
                    //创建连接管理对象
                    HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                    //设置请求方式
                    httpURLConnection.setRequestMethod("GET");
                    //设置读取超时
                    httpURLConnection.setReadTimeout(5000);
                    //设置连接超时
                    httpURLConnection.setConnectTimeout(5000);
                    //开启
                    httpURLConnection.connect();
                    //判断网络状态是否正常
                    if(httpURLConnection.getResponseCode()==200){
                        //请求成功
                        Log.i("xxx","网络请求成功");
                        inputStream = httpURLConnection.getInputStream();
                       ioString= getIoString(inputStream);
                    }else {
                        //请求失败
                        Log.i("xxx","网络请求失败");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }finally {
                    //关流
                    if(inputStream!=null){
                        try {
                            inputStream.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
                //返回
                return ioString;
            }
        }.execute();
    }
    //封装将io流转换成字符串的方法
    public String getIoString(InputStream inputStream) throws IOException {
        String s = null;
        byte[] bytes = new byte[1024];
        int len=-1;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        while ((len=inputStream.read(bytes))!=-1){
            byteArrayOutputStream.write(bytes,0,len);
        }
        byte[] bytes1 = byteArrayOutputStream.toByteArray();
        s = new String(bytes1);
        return s;
    }

    public interface  Datat{
        void get(String str);
    }

}
