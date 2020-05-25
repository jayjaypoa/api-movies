package br.com.joacirjunior.apimovies;

import br.com.joacirjunior.apimovies.communication.handler.impl.ClientHandlerImpl;
import br.com.joacirjunior.apimovies.util.ApiMoviesConfig;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


public class MultiThreadServer {

    public static void main(String[] args) {
        ServerSocket server = null;
        try {

            // server socket configuration
            server = new ServerSocket(ApiMoviesConfig.getPortNumber());
            server.setReuseAddress(ApiMoviesConfig.isAllowedAddressReuse());

            while (true) {
                // accept the new connection
                Socket client = server.accept();
                System.out.println("New client connected - IP : " + client.getInetAddress().getHostAddress());
                // start the background thread for these proccessment
                new Thread(new ClientHandlerImpl(client)).start();
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (server != null) {
                try {
                    server.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("Finished");
        }
    }

}
