package com.lanou.project.chanyouji.utils;

/**
 * Created by lanouhn on 16/9/1.
 */

import android.content.Context;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * 文件的管理工具类
 */
public class FileUtils {


    public static String file_name = "local_file";

    /**
     * 把一个字符串存成一个文件
     */
    public static void saveDataToFile(Context context, String data){
        FileOutputStream fileOutputStream;
        BufferedWriter writer;
        try {
            //打开文件的输出流
            //默认存储在files下
            //文件名,  文件的模式
            fileOutputStream = context.openFileOutput(file_name,
                    //文件存储模式   覆盖MODE_PRIVATE   追加MODE_APPEND 在文件内容后面添加内容
                    Context.MODE_PRIVATE);
            //OutputStreamWriter输出流写入类
            writer = new BufferedWriter(new OutputStreamWriter(fileOutputStream));

            //写入数据
            writer.write(data);

            //关闭相关流
            writer.close();
            fileOutputStream.close();


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    /**
     * 文件的读取
     * @param context
     * @param fileName
     * @return
     */
    public static String readFile(Context context, String fileName){

        FileInputStream stream;
        BufferedReader reader;

        //存储最后读出来的结果
        StringBuilder stringBuilder = new StringBuilder();

        try {
            //获取对应的文件流
            stream = context.openFileInput(fileName);
            //实例化 BufferedReader
            reader = new BufferedReader(
                    new InputStreamReader(stream));
            //每次读取一行的结果
            String lineStr = "";
            //循环读取存储
            while ( (lineStr = reader.readLine()) != null){
                stringBuilder.append(lineStr);
            }

            //关闭流
            stream.close();
            reader.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stringBuilder.toString();
    }
}
