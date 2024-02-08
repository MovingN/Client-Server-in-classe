/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package client_server;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
/**
 *
 * @author utente
 */
public class Client {
    public static void main(String[] args) throws IOException{
         Socket clientSocket = new Socket("127.0.0.1", 8080);
        System.out.println("Client connesso al server \n");
        InputStream inputStream = clientSocket.getInputStream();
        OutputStream outputStream = clientSocket.getOutputStream();
        String messaggioInviato = "Ciao dal client! \n";
        outputStream.write(messaggioInviato.getBytes());
        while (true) {
            byte[] messaggioRicevuto = new byte[1024];
            int bytesLetti = inputStream.read(messaggioRicevuto);
            String messaggio = new String(messaggioRicevuto, 0, bytesLetti);
            System.out.println("Messaggio ricevuto dal server: " + messaggio + "\n");
            messaggio="FINE";
            if (messaggio.equals("FINE")) {
                System.out.println("Chiusura della connessione con il server \n");
                clientSocket.close();
                break;
            }
            messaggioInviato = "Risposta dal client: " + messaggio + "\n";
            outputStream.write(messaggioInviato.getBytes());
        }
    }
}
     

