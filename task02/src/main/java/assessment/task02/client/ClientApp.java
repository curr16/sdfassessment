package assessment.task02.client;

import java.io.Console;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import java.net.Socket;
import java.net.UnknownHostException;

public class ClientApp {
	private int port = 80;
	private String host = "task02.chuklee.com";

	private Socket sock;
	private InputStream is;
	private ObjectInputStream ois;
	private OutputStream os;
	private ObjectOutputStream oos;

	public ClientApp(String[] args){
		if (args.length > 0){
			String terms[] = args[0].split(":");
			this.port = Integer.parseInt(terms[1]);
		}
	}

	public void start() throws UnknownHostException, IOException{
			try{
			System.out.printf("Connecting to %s on port %d...\n", host, port);
			Socket sock = new Socket(host, port);
			System.out.println("Connected");

			String requestFromServer = dis.readUTF();
            System.out.printf("Received request from client : %s\n ", requestFromServer);
 
			initializeStreams(sock);
			Console cons = System.console();

			String input = cons.readLine(">");
			write(input);

			String response = read();
			System.out.println(response);

			close();
			sock.close();
		} catch (IOException ex){
			System.err.println(ex);
			ex.printStackTrace();
		}
	}

	private void initializeStreams(Socket sock) throws IOException {
		os = sock.getOutputStream();
		oos = new ObjectOutputStream(os);
		is = sock.getInputStream();
		ois = new ObjectInputStream(is);
	}

	private String read() throws IOException {
		return ois.readUTF();
	}

	private void write(String out) throws IOException {
		oos.writeUTF(out);
		oos.flush();
	}

	private void close() throws IOException {
		is.close();
		os.close();
	}

}