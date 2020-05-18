package com.java.io.ObjectStream;

import java.io.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * ObjectInputStream 和 ObjectOutputStream 测试程序
 *
 * 序列化的演示测试程序
 *
 * 注意：通过ObjectInputStream, ObjectOutputStream操作的对象，必须是实现了Serializable或Externalizable序列化接口的类的实例。
 *
 * Created by wendyhe on 2019/7/9.
 */
public class ObjectStreamTest {
    
    private static final String TMP_FILE = "box.tmp";
    
    public static void main(String[] args){

        // 将“对象”通过序列化保存
        testWrite();
        // 将序列化的“对象”读出来
        testRead();
    
    }




    /**
     * ObjectOutputStream 测试函数
     *
     * 将Box对象通过序列化，保存到文件中
     *
     */
    private static void testWrite() {

        try {

            // 获取文件TMP_FILE对应的对象输出流。
            // ObjectOutputStream中，只能写入“基本数据”或“支持序列化的对象”
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(TMP_FILE));

            out.writeBoolean(true);
            out.writeByte(65);
            out.writeChar('a');
            out.writeInt(20131015);
            out.writeFloat(3.14F);
            out.writeDouble(1.414D);

            // 写入HashMap对象
            HashMap map = new HashMap();
            map.put("one", "red");
            map.put("two", "green");
            map.put("three", "blue");
            out.writeObject(map);

            // 写入自定义的Box对象，Box实现了Serializable接口
            Box box = new Box("desk", 80, 48);
            // 将box对象写入到对象输出流out中，即相当于将对象保存到文件TMP_FILE中
            out.writeObject(box);

            out.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    /**
     * ObjectInputStream 测试函数
     *
     * 从文件中读取出“序列化的Box对象”
     *
     */
    private static void testRead() {

        try {

            // 获取文件TMP_FILE对应的对象输入流。
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(TMP_FILE));

            System.out.printf("boolean:%b\n" , in.readBoolean());
            System.out.printf("byte:%d\n" , (in.readByte()&0xff));
            System.out.printf("char:%c\n" , in.readChar());
            System.out.printf("int:%d\n" , in.readInt());
            System.out.printf("float:%f\n" , in.readFloat());
            System.out.printf("double:%f\n" , in.readDouble());

            // 读取HashMap对象
            HashMap map = (HashMap) in.readObject();
            Iterator iter = map.entrySet().iterator();

            while (iter.hasNext()) {

                Map.Entry entry = (Map.Entry)iter.next();
                System.out.printf("%-3s -- %s\n" , entry.getKey(), entry.getValue());

            }

            //从对象输入流中，读取先前保存的box对象。Box实现了Serializable接口
            Box box = (Box) in.readObject();
            System.out.println("box: " + box);

            in.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }




}
