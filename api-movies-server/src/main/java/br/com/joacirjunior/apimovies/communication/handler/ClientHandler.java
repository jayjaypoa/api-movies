package br.com.joacirjunior.apimovies.communication.handler;

import br.com.joacirjunior.apimovies.communication.handler.impl.ClientHandlerImpl;
import com.google.inject.ImplementedBy;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.net.Socket;

@ImplementedBy(ClientHandlerImpl.class)
public interface ClientHandler {
    void processAndReply(Socket connection, BufferedReader input, BufferedOutputStream output) throws IOException;
}
