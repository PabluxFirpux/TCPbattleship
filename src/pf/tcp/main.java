package pf.tcp;

import java.io.IOException;
import java.util.Scanner;

public class main {
    public static void main(String[] args) throws IOException {
        System.out.println("Server or client?");
        System.out.println("1. Server");
        System.out.println("2. Client");
        System.out.println("3. Exit");
        Scanner scanner = new Scanner(System.in);
        int res = scanner.nextInt();
        if (res == 1) {
            Server server = new Server();
        } else if (res == 2) {
            Client client = new Client();
        } else if (res == 3) {
            System.exit(0);
        } else {
            System.out.println("Invalid input.");
        }
    }
}
