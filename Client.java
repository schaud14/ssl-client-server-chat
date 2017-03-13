import javax.net.ssl.*;
import java.io.*;

public class Client 
{
    public static void main(String[] arstring) 
    {
        String toServer=null;
        int choice;
        try 
        {   
            //int sslport = Integer.parseInt(argv[5]);
            //String domain = argv[4];
            int sslport = 5481;
            String domain = "bingsuns.binghamton.edu";

            SSLSocketFactory sslsocketfactory = (SSLSocketFactory) SSLSocketFactory.getDefault();
            SSLSocket sslsocket = (SSLSocket) sslsocketfactory.createSocket("bingsuns.binghamton.edu", 5481);

            System.out.println("Connected to " + domain + " at port " + sslport);

            BufferedReader inputFromUser = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter outputToServer = new BufferedWriter(new OutputStreamWriter(sslsocket.getOutputStream()));

            while (true)
            {
                do
                {
                    System.out.println("\nSelect a Choice:\n1. Send data to Server\n2. Exit");
                    System.out.print("Enter Choice: ");
                    choice = Integer.parseInt(inputFromUser.readLine());
                } while (choice < 1 || choice > 2);
                System.out.print("Enter Data: ");
                
                switch(choice)
                {
                    case 1:
                    {
                        toServer = inputFromUser.readLine();
                        if (toServer != null)
                        {
                            outputToServer.write(toServer + '\n');
                            outputToServer.flush();
                            toServer =null;
                        }
                        else
                        {
                            System.out.println("Enter data to send");
                        }
                        break;
                    }
                    case 2:
                    {
                        outputToServer.write("Closing the Connection.\n");
                        outputToServer.flush();
                        sslsocket.close();
                        System.exit(0);
                        break;
                    }
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