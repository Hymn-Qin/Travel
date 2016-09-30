package com.lanou.project.chanyouji.utils;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by lanouhn on 16/9/18.
 */
public class HTTP {

    public static String getData(String string){
        String result="";

        try {
            URL url=new URL(string);
            HttpURLConnection connection= (HttpURLConnection) url.openConnection();
            if (connection.getResponseCode()==HttpURLConnection.HTTP_OK){
                InputStream inputStream=connection.getInputStream();
                BufferedReader reader=new BufferedReader(new InputStreamReader(inputStream));
                String lineStr="";
                while((lineStr=reader.readLine())!=null){
                    result+=lineStr;
                }

                    inputStream.close();
                reader.close();
                connection.disconnect();
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }

    public static Bitmap getImage(String string){
        Bitmap bitmap=null;
        try {
            URL url=new URL(string);
            HttpURLConnection connection= (HttpURLConnection) url.openConnection();
            if (connection.getResponseCode()==HttpURLConnection.HTTP_OK){
                InputStream inputStream=connection.getInputStream();
                bitmap= BitmapFactory.decodeStream(inputStream);
                inputStream.close();
                connection.disconnect();
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bitmap;
    }
}
