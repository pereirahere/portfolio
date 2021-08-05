import Server.Server;

public class ServerMain {

    public static void main(String[] args) {

        try {
            Server server = new Server();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

}
