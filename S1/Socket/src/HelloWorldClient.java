import java.io.*;
import java.net.Socket;

public class HelloWorldClient {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        Socket socket = null;

        try {
            socket = new Socket("172.16.104.153", 12345);
            OutputStream out = socket.getOutputStream();
            DataOutputStream dos = new DataOutputStream(out);
            DataInputStream dis = new DataInputStream(socket.getInputStream());
            String message = "Hello World!";
            dos.writeUTF(message);;
        } catch (IOException e) {
            System.out.println("Houston tenemos un problema");
            System.out.println(e);
            throw new RuntimeException();
        }
    }
}