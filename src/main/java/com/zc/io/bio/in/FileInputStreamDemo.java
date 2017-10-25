package com.zc.io.bio.in;

import java.io.*;
import java.net.URL;

/**
 * Created by zengc on 2017/10/23.
 */
public class FileInputStreamDemo {
    public static void main(String[] args) throws IOException {
        readFileContent1();
        readFileContent2();
    }

    //从文件中读取文件中的文字
    public static void readFileContent1() throws IOException {
        URL resource = FileInputStreamDemo.class.getResource("/fileInputSteamDemo.txt");
        InputStream in=new FileInputStream(resource.getFile());
        int i=0;
        byte[] buf=new byte[1024];
        while ((i=in.read(buf))>0){
            System.out.println(new String(buf,0,i));
        }
        in.close();
    }

    public static void readFileContent2() throws IOException {
        URL resource = FileInputStreamDemo.class.getResource("/fileInputSteamDemo2.txt");
        File file=new File(resource.getPath());
        InputStream in=new FileInputStream(file);
        BufferedReader reader=new BufferedReader(new InputStreamReader(in));
        String line;
        while ((line=reader.readLine())!=null){
            System.out.println(line);
        }
    }

}
