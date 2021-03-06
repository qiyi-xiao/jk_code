package com.jk.code.week2;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

// 创建了一个固定大小的线程池处理请求
public class q6 {

    private static final ExecutorService EXECUTOR = new ThreadPoolExecutor(
            10,
            20,
            30,
            TimeUnit.SECONDS,
            new LinkedBlockingDeque<>());


    public static void main(String[] args) throws IOException {

        final ServerSocket serverSocket = new ServerSocket(8801);
        while (true) {
            try {
                final Socket socket = serverSocket.accept();
                EXECUTOR.execute(() -> service(socket));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    private static void service(Socket socket) {
        try {
//            Thread.sleep(5);
            PrintWriter printWriter = new PrintWriter(socket.getOutputStream(), true);
            printWriter.println("HTTP/1.1 200 OK");
            printWriter.println("Content-Type:text/html;charset=utf-8");
            String body = "hello,nio";
            printWriter.println("Content-Length:" + body.getBytes().length);
            printWriter.println();
            printWriter.write(body);
            printWriter.close();
            socket.close();
        } catch (IOException e) { // | InterruptedException e) {
            e.printStackTrace();
        }
    }
}