package com.jk.code.week1;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @description:
 * @author: junmo
 * @create: 2021-05-09 11:50
 **/

public class MyClassLoader extends ClassLoader {

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {

        final String className = "Hello";
        final String methodName = "hello";

        MyClassLoader myClassLoader = new MyClassLoader();
        Class<?> aClass = myClassLoader.loadClass(className);

        for (Method m: aClass.getDeclaredMethods()) {
            System.out.println(aClass.getSimpleName() + "." + m.getName());
        }

        Object o = aClass.getDeclaredConstructor().newInstance();

        Method method = aClass.getMethod(methodName);
        method.invoke(o);
    }



    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        String replacePath = name.replace(".", "/");
        final String suffix = ".xlass";
        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream(replacePath + suffix);
        try {
            int length = inputStream.available();
            byte[] bytes = new byte[length];
            inputStream.read(bytes);
            //转换
            byte[] classBytes = decode(bytes);
            //定义类
            return defineClass(name, classBytes, 0 , classBytes.length);
        } catch (IOException e) {
            throw new ClassNotFoundException(name, e);
        }


    }

//    解码
    private static byte[] decode(byte[] bytes){
        byte[] bytes1 = new byte[bytes.length];
        for (int i = 0; i < bytes.length; i++) {
            bytes1[i] = (byte)(255 - bytes[i]);
        }
        return bytes1;
    }

    private static void close(Closeable res){
        if (res == null){
            return;
        }
        try {
            res.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
