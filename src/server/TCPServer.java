package server;

import java.net.*;
import java.util.*;
import java.io.*;

public class TCPServer {

	public static void main(String args[]) {
		int port;
		ServerSocket ecoute;
		Socket so = null;

		if (args.length == 1) {
			try {
				port = Integer.parseInt(args[0]);

				ecoute = new ServerSocket(port);
				System.out.println("Serveur en attente de connection ...");

				while (true) {
					so = ecoute.accept(); // accepter la connexion d'un client

					ServerReceive receiving = new ServerReceive(so);
					// ServerSend sending = new ServerSend(so);

					receiving.start();
					// sending.start();

				}
			} catch (IOException e) {
				e.printStackTrace();
				System.out.println("Listen :" + e.getMessage());
			}
		}
	}

}
