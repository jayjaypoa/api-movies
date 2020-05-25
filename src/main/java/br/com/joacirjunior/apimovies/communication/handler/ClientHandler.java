package br.com.joacirjunior.apimovies.communication.handler;

import br.com.joacirjunior.apimovies.communication.handler.impl.ClientHandlerImpl;
import com.google.inject.ImplementedBy;

import java.net.Socket;

@ImplementedBy(ClientHandlerImpl.class)
public interface ClientHandler extends Runnable {
    void setClientSocket(Socket clientSocket);
}
