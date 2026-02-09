import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.io.IOException;

public class HelloWorldServer {
    public static void main(String[] args) throws IOException {

        int port = 12345;

        try (ServerSocket serverSocket = new ServerSocket(port)) {

            Socket server = serverSocket.accept();

            System.out.println("Client connected " + server.getInetAddress());

            DataInputStream dis = new DataInputStream(server.getInputStream());
            DataOutputStream dos = new DataOutputStream(server.getOutputStream());


        }
    }
}
