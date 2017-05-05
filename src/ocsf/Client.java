package ocsf;

import java.io.IOException;
import java.util.Scanner;

import com.lloseng.ocsf.client.ObservableClient;

/**
 * This is class to be an client that connects to server and sends String.
 * 
 * @author Vittunyuta Maeprasart
 *
 */
public class Client extends ObservableClient {

	/**
	 * Initialize this client what host server address and port to connect.
	 * 
	 * @param host
	 *            is address of host server
	 * @param port
	 *            is port of server.
	 */
	public Client(String host, int port) {
		super(host, port);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.lloseng.ocsf.client.ObservableClient#handleMessageFromServer(java.
	 * lang.Object)
	 */
	@Override
	protected void handleMessageFromServer(Object message) {
		// print message from the server.
		System.out.println(message);
		
	}

	/**
	 * open to the connectionto the server
	 */
	public void run() {
		try {
			openConnection();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * run the client
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Client client = new Client("10.2.12.83", 5001);
		Scanner sc = new Scanner(System.in);
		client.run();
		try {
			while (client.isConnected()) {
				String input = sc.nextLine();
				if (input.equalsIgnoreCase("quit")) {
					client.closeConnection();
					System.out.println("Disconnected.");;
				} else{
					client.sendToServer(input);}

			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
