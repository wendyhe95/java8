package com.java.io;

import java.io.*;

/**
 *
 * FileDescriptor 测试程序
 *
 * Created by wendyhe on 2019/7/16.
 */
public class FileDescriptorTest {

    private static final String FileName = "file1.txt";
    private static final String OutText = "Hi FileDescriptor";

    public static void main(String[] args){

        testWrite();
        testRead();

        testStandFD();
        //System.out.println(OutText);


    }


    /**
     * FileDescriptor.out 的测试程序
     *
     * 该程序的效果 等价于 System.out.println(OutText);
     */
    private static void testStandFD(){

        // 创建FileDescriptor.out 对应的PrintStream
        PrintStream out = new PrintStream(new FileOutputStream(FileDescriptor.out));
        // 在屏幕上输出“Hi FileDescriptor”
        out.println(OutText);
        out.close();


    }



    /**
     * FileDescriptor写入示例程序
     *
     * (01) 为了说明，"通过文件名创建FileOutputStream"与“通过文件描述符创建FileOutputStream”对象是等效的
     * (02) 该程序会在“该源文件”所在目录新建文件"file.txt"，并且文件内容是"Aa"。
     */
    private static  void testWrite(){

        try {

            // 新建文件“file.txt”对应的FileOutputStream对象
            FileOutputStream out1 = new FileOutputStream(FileName);
            // 获取文件“file.txt”对应的“文件描述符”
            FileDescriptor fdout = out1.getFD();
            // 根据“文件描述符”创建“FileOutputStream”对象
            FileOutputStream out2 = new FileOutputStream(fdout);

            out1.write('A');
            out2.write('a');

            if (fdout!=null)
                System.out.printf("fdout(%s) is %s\n",fdout, fdout.valid());

            out1.close();
            out2.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    /**
     * FileDescriptor读取示例程序
     *
     * 为了说明，"通过文件名创建FileInputStream"与“通过文件描述符创建FileInputStream”对象是等效的
     */
    private static void testRead(){

        try {

            // 新建文件“file.txt”对应的FileInputStream对象
            FileInputStream in1 = new FileInputStream(FileName);
            // 获取文件“file.txt”对应的“文件描述符”
            FileDescriptor fdin = in1.getFD();
            // 根据“文件描述符”创建“FileInputStream”对象
            FileInputStream in2 = new FileInputStream(fdin);


            System.out.println("in1.read: " + (char)in1.read());
            System.out.println("in2.read: " + (char)in2.read());

            if(fdin != null)
                System.out.printf("fdin(%s) is %s\n",fdin,fdin.valid());

            in1.close();
            in2.close();


        } catch (Exception e) {
            e.printStackTrace();
        }

    }





}
