package pf.tcp;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public Server() throws IOException {
        ServerSocket serverSocket = new ServerSocket(3000);
        System.out.println("Server started.");
        Socket socket = serverSocket.accept();
        System.out.println("Client connected.");
    }

}
