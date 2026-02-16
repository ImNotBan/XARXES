import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class InteractiveServer {

    public static void main(String[] args) {

        System.out.println("Welcome to Interactive Server");

        try {
            System.out.println("Esperant al client...");
            ServerSocket ss = new ServerSocket(3455);

            while (true) {
                Socket s = ss.accept();
                System.out.println("Connectat!");

                DataInputStream dis = new DataInputStream(s.getInputStream());
                DataOutputStream dos = new DataOutputStream(s.getOutputStream());

                String linia = "";
                String transformaçao;

                while (!linia.equals("FI")) {
                    linia = dis.readUTF();
                    System.out.println("He puto llegit: " + linia);

                    if (linia.equals("FI")) {
                        // no retornem res si és FI; tanquem i esperem el següent client
                        break;
                    }

                    transformaçao = linia.toUpperCase();
                    dos.writeUTF(transformaçao);
                    dos.flush();
                }

                // Tanquem la connexió d'aquest client
                dis.close();
                dos.close();
                s.close();

                System.out.println("Connexió tancada. Esperant el següent client...");
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
