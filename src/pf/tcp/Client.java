package pf.tcp;

import java.io.IOException;
import java.net.Socket;

public class Client {
    public Client() throws IOException {
        System.out.println("Client started.");
        Socket socket = new Socket("localhost", 3000);
        System.out.println("Connected to server.");
    }
}
