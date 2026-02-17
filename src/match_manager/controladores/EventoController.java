package match_manager.controladores;

import com.sun.net.httpserver.HttpServer;
import match_manager.servico.EventoService;

import java.util.ArrayList;

public class EventoController {
//    private EventoService eventoService = new EventoService();

    public EventoController(HttpServer server) {
        iniciarServer(server);
    }

    private void iniciarServer(HttpServer server) {
        server.createContext("/eventos")
                .setHandler(exchange -> {
                    // TODO: Diferenciar as acoes por metodo HTTP
                    System.out.println("Metodo HTTP utilizado: " + exchange.getRequestMethod());

                    exchange.sendResponseHeaders(200, 0);
                    var eventos = new ArrayList<>();

                    // TODO: Estudar sobre serializacao - Trocar toString para a serializacao certa
                    // Serializacao padrao do REST: JSON
                    // Pesquisar sobre bibliotecas de serializacao: Jackson, Gson, outros

                    exchange.getResponseBody().write(eventos.toString().getBytes());
                    exchange.getResponseBody().close();
                });

    }

}
