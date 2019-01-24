package client;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

// Thread pour envoyer
class ClientSend extends Thread {

	BufferedReader buffer = null;
	Socket so = null;
	PrintWriter sortie = null;
	String chaine;

	public ClientSend(Socket so) {
		this.so = so;
	}

	public void run() {
		try {
			buffer = new BufferedReader(new InputStreamReader(System.in));
			sortie = new PrintWriter(so.getOutputStream(), true);

			while (true) {

				System.out.println(this.so);

				chaine = buffer.readLine();
				sortie.println(chaine);
				// on écrit la chaine dans le canal de sortie

				if (chaine.equals("/quit"))
					break;

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
