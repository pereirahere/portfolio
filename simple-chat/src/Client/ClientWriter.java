package Client;

import Functionality.Writer;
import Server.Server;

import java.io.BufferedWriter;
import java.net.Socket;
import java.util.Scanner;

public class ClientWriter implements Runnable {

    private Socket clientSocket;
    private String nickname;
    private String[] msgArr;
    private Scanner scanner;
    private Writer writer;

    public ClientWriter(Socket cSocket, String name) {
        this.clientSocket = cSocket;
        this.nickname = name;
        this.scanner = new Scanner(System.in);
        this.writer = new Writer();
    }

    @Override
    public void run() {

        try {

            String send = nickname + " JUST ENTERED THE CHAT;";
            System.out.println("YOU ARE NOW ONLINE, " + nickname + ". " + "TYPE \"cmd h\" TO CHECK ALL COMMANDS AVAILABLE;");
            writer.write(clientSocket, send);

            while (true) {

                send = nickname + ": " + scanner.nextLine();
                writer.write(clientSocket, send);

                msgArr = send.split(" ");

                if (msgArr.length >= 3) {
                    if ((msgArr[1] + " " + msgArr[2]).equals("cmd n")){
                        String oldNickname = nickname;
                        changeName(send);
                        send = oldNickname + " CHANGED HIS NICKNAME TO: " + nickname;
                        writer.write(clientSocket, send);
                    }
                }

            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    public void changeName(String send) {
        if (msgArr.length <= 3) {
            System.out.println("NEW NICKNAME PARAMETER DOES NOT EXIST;");
            return;
        }
        nickname = msgArr[3];
        System.out.println("NAME CHANGED TO: " + nickname);
    }

}
