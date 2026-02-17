package match_manager;

import com.sun.net.httpserver.HttpServer;
import match_manager.controladores.EventoController;

import java.io.IOException;
import java.net.InetSocketAddress;

public class Main {
    public static void main(String[] args) throws IOException {
        HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);
        server.setExecutor(null);
        new EventoController(server);
        server.start();
        System.out.println("Servidor iniciado na porta 8080");

    }
}