package Client;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    private final int PORT = 14532;
    private String nickname;
    private Socket clientSocket;

    private Thread writerT;
    private Thread listenerT;
    private Scanner scanner;

    public Client () throws IOException {

        System.out.println("PLEASE INSERT YOUR NAME: ");
        scanner = new Scanner(System.in);
        nickname = scanner.nextLine();

        clientSocket = new Socket("localhost", PORT);

        writerT = new Thread(new ClientWriter(clientSocket, nickname));
        listenerT = new Thread(new ClientListener(clientSocket));
        scanner = new Scanner(System.in);

        clientComm();
    }

    public void clientComm() {
        writerT.start();
        listenerT.start();
    }

}
