import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class HowlerClient {
    public static void main(String[] args) {
        try{
            Socket s = new Socket("localhost", 3455);

            DataInputStream dis = new DataInputStream(s.getInputStream());
            DataOutputStream dos = new DataOutputStream(s.getOutputStream());

            Scanner sc = new Scanner(System.in);

            String msgConsola = "";
            String msgRebut;

            System.out.println("Klk escriu que li paso a l'altre");
            System.out.println("Si acabes fins la polla escriu exactament 'FI' ");

            while(!msgConsola.equals("FI")){
                msgConsola = sc.nextLine();

                dos.writeUTF(msgConsola);
                dos.flush();

                msgRebut = dis.readUTF();
                System.out.println("Hem puto rebut aquesta merda: " + msgRebut);
            }

            dis.close();
            dos.close();
            s.close();

        } catch (Exception e){
            System.out.println(e);
        }
    }
}
