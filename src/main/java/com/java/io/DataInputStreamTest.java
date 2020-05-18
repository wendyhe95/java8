package com.java.io;

import java.io.*;

/**
 * DataInputStream 和 DataOutputStream测试程序
 *
 * Created by wendyhe on 2019/8/15.
 */
public class DataInputStreamTest {

    private static final int LEN = 5;

    public static void main(String[] args){

        testDataOutputStream();


    }



    /**
     * DataOutputStream测试函数
     */
    private static void  testDataOutputStream(){

        try {

            File file = new File("file2.txt");
            DataOutputStream out = new DataOutputStream(new FileOutputStream(file));

            out.writeBoolean(true);
            out.writeByte((byte)0x41);
            out.writeChar((byte)0x4243);
            out.writeShort((byte)0x4445);
            out.writeInt(0x12345678);
            out.writeLong(0x0FEDCBA987654321L);
            out.writeUTF("abcdefghijklmnopqrstuvwxyz何95");

            out.close();


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * DataInputStream测试函数
     */
    private static void testDataInputStream(){

        try {

            File file = new File("file2.txt");
            DataInputStream in = new DataInputStream(new FileInputStream(file));

            System.out.printf("byteToHexString(0x8F):0x%s\n", byteToHexString((byte)0x8F));
            System.out.printf("charToHexString(0x8FCF):0x%s\n", charToHexString((char)0x8FCF));

            System.out.printf("readBoolean():%s\n", in.readBoolean());
            System.out.printf("readByte():0x%s\n", byteToHexString(in.readByte()));
            System.out.printf("readChar():0x%s\n", charToHexString(in.readChar()));
            System.out.printf("readShort():0x%s\n", shortToHexString(in.readShort()));
            System.out.printf("readInt():0x%s\n", Integer.toHexString(in.readInt()));
            System.out.printf("readLong():0x%s\n", Long.toHexString(in.readLong()));
            System.out.printf("readUTF():%s\n", in.readUTF());

            in.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    // 打印byte对应的16进制的字符串
    private static String byteToHexString(byte val) {
        return Integer.toHexString(val & 0xff);
    }

    // 打印char对应的16进制的字符串
    private static String charToHexString(char val) {
        return Integer.toHexString(val);
    }

    // 打印short对应的16进制的字符串
    private static String shortToHexString(short val) {
        return Integer.toHexString(val & 0xffff);
    }


}
