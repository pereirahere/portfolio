package Functionality;

import Server.Server;

import java.io.IOException;
import java.net.Socket;
import java.util.HashMap;

public class CommandHandler {

    private Writer writer;
    private Server server;

    public CommandHandler(Server server) {
        this.writer = new Writer();
        this.server = server;
    }

    public void dealWithCmd(Socket cSocket, String[] msgArr) throws IOException, InterruptedException {

        if (msgArr.length <= 2) {
            writer.write(cSocket, "YOU DID NOT SPECIFY A COMMAND; TRY \"cmd h\" FOR ALL COMMANDS AVAILABLE;");
            return;
        }
        
        switch (msgArr[2]){
            case "h":
                cmdHelp(cSocket, msgArr);
                break;
            case "l":
                cmdList(cSocket);
                break;
            case "w":
                cmdWhisper(cSocket, msgArr);
                break;
            case "n":
                cmdName(cSocket, msgArr);
                break;
            case "c":
                cmdClear(cSocket);
                break;
            case "r":
                System.out.println("here ill change rooms");
                break;
            case "rl":
                System.out.println("here ill show rooms");
                break;
            case "q":
                System.out.println("here ill quit the chat");
                break;
            default:
                writer.write(cSocket, "COMMAND DOES NOT EXIST; TRY \"cmd h\" FOR ALL COMMANDS AVAILABLE;");
                break;

        }

    }

    private void cmdClear(Socket cSocket) throws IOException, InterruptedException {
        for (int i = 0; i <= 20; i++) {
            writer.write(cSocket, " ");
            Thread.sleep(10);
        }
    }

    private void cmdHelp(Socket cSocket, String[] msgArr) throws IOException, InterruptedException {
        writer.write(cSocket, "\"cmd w nickname\" TO SEND A MESSAGE TO A SPECIFIC USER;");
        Thread.sleep(10);
        writer.write(cSocket, "\"cmd l\" TO CHECK USERS ONLINE ON MAIN ROOM;");
        Thread.sleep(10);
        writer.write(cSocket, "\"cmd c\" TO CLEAR YOUR CHAT;");
        Thread.sleep(10);
        writer.write(cSocket, "\"cmd n nickname\" TO CHANGE YOUR NICKNAME;");
        Thread.sleep(10);
        writer.write(cSocket, "\"cmd rl roomname\" TO CHECK AVAILABLE ROOMS;");
        Thread.sleep(10);
        writer.write(cSocket, "\"cmd r roomname\" TO CHANGE TO A SPECIFIC ROOM;");
        Thread.sleep(10);
        writer.write(cSocket, "\"cmd q\" TO QUIT THE CHAT;");
    }

    private void cmdWhisper(Socket cSocket, String[] msgArr) throws IOException {

        if (msgArr.length <= 3) {
            writer.write(cSocket, "USER TO WHISPER PARAMETER IS EMPTY;");
            return;
        }

        if (!server.getSocketNickMap().containsKey(msgArr[3])) {
            writer.write(cSocket, "USER YOU'RE TRYING TO WHISPER DOES NOT EXIST;");
            return;
        }

        Socket sToWhisper = server.getSocketNickMap().get(msgArr[3]);
        StringBuffer sb = new StringBuffer();

        for (int i = 4; i < msgArr.length; i++) {
            sb.append(msgArr[i]);
            sb.append(" ");
        }

        String msgToSend = "Whisper@ " + msgArr[0] + " " + sb.toString();
        writer.write(sToWhisper, msgToSend);
        return;
    }

    private void cmdList(Socket clientSocket) throws IOException {

        for (HashMap.Entry<String, Socket> entry : server.getSocketNickMap().entrySet()) {

            String nickName = entry.getKey();
            writer.write(clientSocket, nickName);

            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

    }

    private void cmdName(Socket clientSocket, String[] msgArr) {

        String oldNickName = msgArr[0].replace(":", "");
        ;
        System.out.println(server.getSocketNickMap().containsKey(oldNickName));
        String newNickname = msgArr[3];

        server.getSocketNickMap().remove(oldNickName);
        server.getSocketNickMap().put(newNickname, clientSocket);

    }


}
