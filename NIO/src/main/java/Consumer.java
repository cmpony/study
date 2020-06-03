import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Consumer {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("127.0.0.1",8080);
            Scanner sc = new Scanner(System.in);
            while (sc.hasNext()) {
                String next = sc.next();
                socket.getOutputStream().write(next.getBytes());
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block 
            e.printStackTrace(); 
        }
    } 
} 