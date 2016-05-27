/**
 * Server class
 * Implementation of a simple chat service in java
 *
 * @author Bhaskar
 */
import java.io.*;
import java.net.*;
public class MyServer implements Runnable {
    Socket socket;
    public MyServer(Socket i) {
        socket = i;
    }
    public void run() {
        try {
            System.out.println("Client connected ->" + socket.getRemoteSocketAddress().toString());
            BufferedReader keyRead = new BufferedReader(new InputStreamReader(System.in));
            OutputStream ostream = socket.getOutputStream();
            PrintWriter pwrite = new PrintWriter(ostream, true);
            InputStream istream = socket.getInputStream();
            BufferedReader receiveRead = new BufferedReader(new InputStreamReader(istream));
            String receiveMessage, sendMessage;
            while (true) {
                if ((receiveMessage = receiveRead.readLine()) != null) {
                    System.out.println(receiveMessage);
                    if (receiveMessage.equals("BYE")) {
                        System.out.println(socket.getRemoteSocketAddress().toString() + " ended the chat session");
                        break;
                    }
                }
                sendMessage = "Server->" + keyRead.readLine();
                pwrite.println(sendMessage);
                pwrite.flush();
            }
        } catch (Exception e) {
            System.out.println("Connection aborted..");
        }
    System.out.println("Client "+socket.getRemoteSocketAddress().toString()+" disconnected..");
    }
}
