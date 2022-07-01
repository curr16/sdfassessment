package assessment.task02.server;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerApp {

    private static int port = 80;

    public static void main(String[] args){

        String serverHost = args[0];
        String serverPort = args[1];
        
        try {
            System.out.printf("Server Started at %s\n");
        
            ServerSocket server = new ServerSocket(Integer.parseInt(serverPort, serverHost));
            Socket sock = server.accept();

            OutputStream os = sock.getOutputStream();
            ObjectOutputStream dos = new ObjectOutputStream(os);
            InputStream is = sock.getInputStream();
            ObjectInputStream dis = new ObjectInputStream(is);

            String requestFromClient = dis.readUTF();
            System.out.printf("Received request from client : %s\n ", requestFromClient);  
            
            is.close();
            os.close();

            sock.close();
        } catch (NumberFormatException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } 
    }   

}