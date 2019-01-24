package client;

import java.io.ObjectInputStream;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.Socket;



//Thread pour recevoir
class ClientReceive extends Thread {

	Socket so = null;
	BufferedReader entree;
	ObjectInputStream entreeObject = null;

	public ClientReceive(Socket so) {
		this.so = so;
	}

	public void run() {
		try {
			entree = new BufferedReader(new InputStreamReader(so.getInputStream()));
			while (true) {
				String response = entree.readLine();

				if (response == null) {
					so.close();
					break;
				}

				System.out.println("Réponse du serveur : " + response);
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
