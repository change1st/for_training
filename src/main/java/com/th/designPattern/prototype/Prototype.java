package com.th.designPattern.prototype;

import com.th.designPattern.CNFException;

import java.io.*;

/**
 * Created by tianhui on 16/9/7.
 * 原型模式
 */
public class Prototype implements Cloneable, Serializable {

    private static final long serialVersionUID = 1L;

    private String str;

    private SerializableObject obj;

    public Object clone() throws CNFException{
        try {
            Prototype prototype = (Prototype) super.clone();
            return prototype;
        } catch (CloneNotSupportedException e) {
            throw new CNFException();
        }
    }

    public Object deepClone() throws IOException, ClassNotFoundException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
        objectOutputStream.writeObject(this);

        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
        ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
        return objectInputStream.readObject();
    }

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }

    public SerializableObject getObj() {
        return obj;
    }

    public void setObj(SerializableObject obj) {
        this.obj = obj;
    }
}
