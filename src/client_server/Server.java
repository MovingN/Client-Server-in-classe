package client_server;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author utente
 */
public class Server extends Thread{

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8080);
        System.out.println("Server in ascolto \n");
        // Attesa di un client
        Socket clientSocket = serverSocket.accept();
        System.out.println("Client connesso! \n");
        new Thread(() -> {
     while (true) {
            try {
                // Creazione di stream di input e output per la comunicazione
                InputStream inputStream = clientSocket.getInputStream();
                OutputStream outputStream = clientSocket.getOutputStream();
                while (true) {
                    // Ricezione messaggio dal client
                    byte[] messaggioRicevuto = new byte[1024];
                    int bytesLetti = inputStream.read(messaggioRicevuto);
                    String messaggio = new String(messaggioRicevuto, 0, bytesLetti);
                    // Elaborazione del messaggio
                    System.out.println("Messaggio ricevuto dal client: " + messaggio +"\n");
                    
                    if (messaggio.equals("FINE")) {
                        // Chiusura della connessione
                        System.out.println("Chiusura della connessione con il client\n");
                        clientSocket.close();
                        break;
                    }

                    // Invio messaggio al client
                    String messaggioInviato = "Risposta dal server: " + messaggio + "\n";
                    outputStream.write(messaggioInviato.getBytes());
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        }).start();
    }
}
