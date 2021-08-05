package Client;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;

public class ClientListener implements Runnable{

    private BufferedReader bfR;
    private Socket clientSocket;

    public ClientListener (Socket cSocket) {
        this.clientSocket = cSocket;
    }

    @Override
    public void run() {

        try {
            while (true) {
                bfR = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                System.out.println(bfR.readLine());
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

}
