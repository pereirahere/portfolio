package Server;

import Functionality.CommandHandler;
import Functionality.Writer;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {

    private final int PORT = 14532;
    private ServerSocket serverSocket;
    private Socket clientSocket;
    private ArrayList<Socket> clientSocketArray;
    private HashMap<String, Socket> socketNickMap;
    private ExecutorService cachedExec;
    private Writer writer;
    private CommandHandler cmdHandler;

    public Server() throws IOException {

        serverSocket = new ServerSocket(PORT);
        clientSocketArray = new ArrayList<>();
        socketNickMap = new HashMap<>();

        cachedExec = Executors.newCachedThreadPool();
        writer = new Writer();
        cmdHandler = new CommandHandler(this);

        serverComm();

    }

    public void serverComm() throws IOException {

        while (true) {

            System.out.println("WAITING FOR NEXT CLIENT CONNECTION;");
            clientSocket = serverSocket.accept();
            clientSocketArray.add(clientSocket);

            cachedExec.submit(new ServerListener(clientSocket, this));

            try {
                Thread.sleep(10);
            } catch (Exception ex) {
                ex.printStackTrace();
            }

        }

    }

    public void serverBroadcast(String msg, Socket clientSocket) throws IOException, InterruptedException {

        String[] msgArr = msg.split(" ");

        if(msgArr.length <= 1) {
            writer.write(clientSocket, "YOU DID NOT TYPE ANYTHING;");
            return;
        }

        if (msgArr[1].equals("cmd")) {
            cmdHandler.dealWithCmd(clientSocket, msgArr);
            return;
        }

        try {
            for (Socket cSocket : clientSocketArray) {
                if (cSocket.equals(clientSocket)) {
                    continue;
                }
                writer.write(cSocket, msg);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    public void registerSocketName(Socket cSocket, String msg) throws IOException, InterruptedException {
        String[] msgArr = msg.split(" ");
        socketNickMap.put(msgArr[0], cSocket);
        serverBroadcast(msg, cSocket);
    }

    
    // GETTERS&SETTERS

    public HashMap<String, Socket> getSocketNickMap() {
        return socketNickMap;
    }

}
