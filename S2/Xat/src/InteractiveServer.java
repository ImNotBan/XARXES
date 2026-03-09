import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class InteractiveServer {

    public static void main(String[] args) {
        System.out.println("Hello soc l'InteractiveServer");

        try (ServerSocket ss = new ServerSocket(2234)) {
            System.out.println("Esperant client");

            while (true) {
                try (Socket s = ss.accept();
                     DataInputStream din = new DataInputStream(s.getInputStream());
                     DataOutputStream dout = new DataOutputStream(s.getOutputStream())) {

                    System.out.println("Established connection");

                    String liniaLlegida = "";

                    while (!liniaLlegida.equals("FI")) {
                        liniaLlegida = din.readUTF();
                        System.out.println("He llegit: " + liniaLlegida);

                        String liniaTransformada = liniaLlegida.toUpperCase();
                        dout.writeUTF(liniaTransformada);
                        dout.flush();
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}