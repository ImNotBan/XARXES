import java.io.DataInputStream;
import java.net.ConnectException;
import java.net.ServerSocket;
import java.net.Socket;

public class InteractiveServer {

    public static void main(String[] args) {
        int port = 12345;

        try (ServerSocket ss = new ServerSocket(port)){

            System.out.println("Servidor escoltant al port: " + port);

            while(true){
                String msg = i
            }
        }
    }
}