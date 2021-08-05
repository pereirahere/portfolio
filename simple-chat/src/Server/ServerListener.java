package Server;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;

public class ServerListener implements Runnable {

    private Socket clientSocket;
    private Server server;
    private BufferedReader bfR;

    private boolean isRegistered;

    public ServerListener(Socket cSocket, Server server) {
        this.clientSocket = cSocket;
        this.server = server;
        this.isRegistered = false;
    }

    @Override
    public void run() {

        while (true) {

            try {

                bfR = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

                if(!isRegistered) {
                    server.registerSocketName(clientSocket, bfR.readLine());
                    isRegistered = true;
                }

                server.serverBroadcast(bfR.readLine(), clientSocket);

            } catch (Exception ex) {
                ex.printStackTrace();
            }

        }

    }

}


