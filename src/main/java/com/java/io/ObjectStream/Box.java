package com.java.io.ObjectStream;

import java.io.Serializable;

/**
 * Created by wendyhe on 2019/7/9.
 */
public class Box  implements Serializable{

    private int width;
    private int height;
    private String name;

    public Box(String name, int width, int height) {
        this.name = name;
        this.width = width;
        this.height = height;
    }

    @Override
    public String toString() {
        return "["+name+": ("+width+", "+height+") ]";
    }
}

