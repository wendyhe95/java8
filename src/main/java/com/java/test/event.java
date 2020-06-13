package com.java.test;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 * Created by wendyhe on 2018/8/2.
 */
public class event extends JFrame implements ActionListener{
    JPanel mp=null;
    JButton  bt1=null;
    JButton  bt2=null;

    public  static  void main(String[] args){
        event e =new  event();
    }

    public event(){

        mp=new JPanel();
        bt1=new JButton("black");
        bt2=new JButton("red");

        this.add(bt1, BorderLayout.NORTH);
        mp.setBackground(Color.YELLOW);
        this.add(mp);
        this.add(bt2, BorderLayout.SOUTH);

        Demo demo=new Demo();
        bt1.addActionListener(demo);
        bt2.addActionListener(demo);


        //注册监听
        bt1.addActionListener(this);
        //指定action命令
        bt1.setActionCommand("a");
        bt2.addActionListener(this);
        bt2.setActionCommand("b");

        this.setSize(200,200);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);




    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //判断哪个按钮被click
        if(e.getActionCommand().equals("a")){
            System.out.println("click black button");
            mp.setBackground(Color.BLACK);
        }else{
            System.out.println("click red button");
            mp.setBackground(Color.RED);
        }

    }


    class  Demo implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getActionCommand().equals("a")){
                System.out.println("Demo  black");
            }else {
                System.out.println("Demo  red");
            }

        }
    }

}

