import javax.net.ssl.*;
import java.io.*;

public class Server 
{
    public static void main(String[] arstring) 
    {
        try 
        {
            int sslport = 5481;
            SSLServerSocketFactory sslserversocketfactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
            SSLServerSocket sslserversocket = (SSLServerSocket) sslserversocketfactory.createServerSocket(5481);
            
            System.out.println("Waiting for Client to Connect on port "+ sslport);
            SSLSocket sslsocket = (SSLSocket) sslserversocket.accept();
            System.out.println("Client Connected at port " + sslport);
         
            BufferedReader inputFromClient = new BufferedReader(new InputStreamReader(sslsocket.getInputStream()));

            String fromClient = null;
            while ((fromClient = inputFromClient.readLine()) != null) 
            {
                if (fromClient.equals("Closing the Connection"))
                {
                    System.out.println("Connection Closed by Client.");
                    sslsocket.close();
                    System.exit(0);    
                }
                else
                {
                    System.out.println("Data Received: " + fromClient + "\n" + "Length of Data: " + fromClient.length());
                    System.out.flush();
                }
            }
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }
        //sslsocket.close();
    }
}