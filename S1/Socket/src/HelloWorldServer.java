import java.io.DataInputStream;
import java.net.ConnectException;
import java.net.ServerSocket;
import java.net.Socket;

public class HelloWorldServer {
    public static void main(String[] args) {
        try{
            ServerSocket serverSocket = new ServerSocket(12345);
            Socket s =  serverSocket.accept();
            DataInputStream dis = new DataInputStream(s.getInputStream());
            String paraula = dis.readUTF();
            System.out.println("He rebut pel socket: " + paraula);
            serverSocket.close();
        }
        catch(ConnectException ce){
            System.out.println("Problema de xarxa");
            throw new RuntimeException(ce);
        }
        catch(Exception e){
            System.out.println("Problema desconegut");
            throw new RuntimeException(e);
        }
    }
}