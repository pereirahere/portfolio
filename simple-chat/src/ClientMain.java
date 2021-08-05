import Client.Client;

public class ClientMain {

    public static void main(String[] args) {

        try {
            Client client = new Client();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

}
