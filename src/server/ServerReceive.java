package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class ServerReceive extends Thread {

	Socket client;
	BufferedReader entree;
	String response, pseudo;
	PrintWriter out;

	public ServerReceive() {

	}

	public ServerReceive(Socket client) throws IOException {
		this.client = client;
	}


	@Override
	public void run() {
		try {
			// initialise le buffer pour les flux entrant du reseau
			entree = new BufferedReader(new InputStreamReader(
					client.getInputStream())); // client.getInputStream() le
			while (true) {

				String commande = entree.readLine(); // lire le pseudo du client
                System.out.println(commande);

				if (commande == null)
					break;

				// if (commande != null) {
                //
				// 	while (true) {
				// 	ServerResponse answer = new ServerResponse(this, client);
				// 	answer.start();
                //
				// 	response = message;
				// 	setResponse();
                //
				// } else
				// 	break;
			}

		} catch (Exception ex) {
			ex.printStackTrace();
			System.out.println(ex.getMessage());
		}
	}
}
