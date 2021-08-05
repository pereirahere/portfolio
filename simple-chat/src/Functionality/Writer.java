package Functionality;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class Writer {

    private BufferedWriter bfW;

    public Writer() {

    }

    public void write (Socket socket, String msg) throws IOException {

        bfW = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        bfW.write(msg);
        bfW.newLine();
        bfW.flush();

    }

}
