package br.com.joacirjunior.apimovies.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;


/**
 *
 * ATTENTION : THIS PROJECT AND THIS CLASS IS JUST FOR TEST THE SERVER RESPONSE.
 *
 * THIS PROJECT DONT LOOK FOR HAVE A GOOD PRACTICES LIKE  DESIGN PATTERN OR A UNIT TESTS COVERAGE.
 * THE ONLY OBJECTIVE IS CALL THE SERVER PROJECT (api-movies-server).
 *
 */
public class ApiMoviesClientApplication {

    public static void main(String[] args) {
        String host = "127.0.0.1";
        int port = 32000;
        try (Socket socket = new Socket(host, port)) {
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            Scanner scanner = new Scanner(System.in);
            String line = null;
            while (!"exit".equalsIgnoreCase(line)) {
                System.out.println("\nInput the query to send : ");
                line = scanner.nextLine();
                out.println(line);
                out.flush();
                System.out.println("Server replied : " + in.readLine());
            }
            scanner.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
