package servico;

import modelo.Evento;
import repositorio.EventoRepositorio;

import java.time.LocalDateTime;
import java.util.List;

public class EventoService {
    private final EventoRepositorio eventoRepositorio;
    public EventoService() {
        this.eventoRepositorio = new EventoRepositorio();
    }
        public void ctiarEvento (Evento evento) {
        if (evento == null) {
            throw new IllegalArgumentException("Evento nao pode ser nulo");
        }

        if (evento.getDatahora() == null) {
            throw new IllegalArgumentException("Evento data nao pode ser nula");
        }

        if (evento.getDatahora().isBefore(LocalDateTime.now())) {
            throw new IllegalArgumentException("Evento nao pode acontecer no passado");
        }

        if (evento.getCusto() <= 0) {
            throw new IllegalArgumentException("Evento custo nao pode ser zero ou negativo");
        }

        if (evento.getLocal() == null || evento.getLocal().getId() <= 0) {
            throw new IllegalArgumentException("evento precisa de um local");
        }

        eventoRepositorio.salvar(evento);

        }

        public Evento buscarEventoPorId(long id) {
            if (id <= 0) {
                throw new IllegalArgumentException("Id nao pode ser negativo");
            }

            Evento evento = eventoRepositorio.BuscarPorId(id);

            if (evento == null) {
                throw new IllegalArgumentException("Evento nao pode ser encontrado");
            }
            return evento;
        }

        public List<Evento> listarTodos() {
        return eventoRepositorio.listarTodos();
        }

        public void atualizarEvento (Evento evento) {
        if (evento.getId() <= 0) {
            throw new IllegalArgumentException("Id nao encontrado");
        }
        buscarEventoPorId(evento.getId());
        eventoRepositorio.atualizar(evento);
        }

        public void removerEvento (long id) {
        buscarEventoPorId(id);
        
        eventoRepositorio.delete(id);
        }

}
