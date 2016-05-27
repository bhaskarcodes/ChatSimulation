/**
 * 
 * Implementation of a simple chat service in java
 * This class assigns a thread per client request.
 * @author Bhaskar
 */
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
public class ServerDriver   //new multithreaded server   
{
   int i;
    public static void main(String[] args )
   {  
      try
      {  
         int i = 1;
         ServerSocket s = new ServerSocket(Integer.parseInt(args[0]));
         System.out.println("Server ready");
         while (true)
         {
            Socket socket = s.accept();
            System.out.println("Connection Estabished.");
            System.out.println("Client no ->" + i);
            Runnable r = new MyServer(socket);
            Thread t = new Thread(r);
            t.start();
            i++;
         }
      }
      catch (IOException e)
      {  
         e.printStackTrace();
      }
   }
}
