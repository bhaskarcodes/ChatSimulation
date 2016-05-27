/**
 * Client class
 * Implementation of a simple chat service in java
 *
 * @author Bhaskar
 */
import java.io.*;
import java.net.*;
class MyClient {
    public static void main(String[] args) throws Exception {
        Socket socket = new Socket(args[0], Integer.parseInt(args[1])); 
        //args[0]->localhost & args[1] = port no (eg. 3333)
        BufferedReader messageRead = new BufferedReader(new InputStreamReader(System.in));
        OutputStream ostream = socket.getOutputStream();
        PrintWriter pwrite = new PrintWriter(ostream, true);
        InputStream istream = socket.getInputStream();
        BufferedReader receiveRead = new BufferedReader(new InputStreamReader(istream));
        System.out.println("Start the chat..type your message and press Enter");
        String receiveMessage, sendMessage;
      while (true) {
          sendMessage = messageRead.readLine();
            if (sendMessage.equals("BYE"))
            {
                pwrite.println("Client("+socket.getLocalAddress().toString()+") "+sendMessage);
                socket.close();
                System.out.println("Chat session ended.. Bye!");
                break;
            }
            pwrite.println("Client("+socket.getLocalAddress().toString()+") "+sendMessage);
            pwrite.flush();
            if ((receiveMessage = receiveRead.readLine()) != null) {
                System.out.println(receiveMessage);
            }
        }
    }
}
