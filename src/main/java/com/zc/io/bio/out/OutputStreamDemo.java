package com.zc.io.bio.out;

import java.io.*;
import java.net.URL;

/**
 * Created by zengc on 2017/10/23.
 */
public class OutputStreamDemo {
    public static void main(String[] args) throws IOException {
        writeFile();
    }

    public static void writeFile() throws IOException {
        URL resource = OutputStreamDemo.class.getResource("/outputStreamDemo1.txt");
        File file=null;
        if (resource==null){
            file=new File(OutputStreamDemo.class.getResource("/").getPath()+"/outputStreamDemo1.txt");
        }
        if (!file.exists()){
            file.createNewFile();
        }
        OutputStream out=new FileOutputStream(file);
        String content="在Java类库中，IO部分的内容是很庞大的，因为它涉及的领域很广泛:标准输入输出，文件的操作，网络上的数据流，字符串流，对象流，zip文件流。";
        out.write(content.getBytes());
        String content2="输入流: 程序可以从中读取数据的流。\n";
        out.write(content2.getBytes());
        out.flush();
        out.close();
    }
}
