package rms;

import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import java.io.*;
import java.net.InetSocketAddress;

public class Main {
    public static void main(String[] args) throws Exception {
        HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);
        server.createContext("/api/menu", new MenuHandler());
        server.createContext("/api/order", new OrderHandler());
        server.setExecutor(null);
        server.start();
        System.out.println("Server started on port 8080");
    }
}