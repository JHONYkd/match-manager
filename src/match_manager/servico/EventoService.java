package match_manager.servico;

import match_manager.modelo.Evento;
import match_manager.repositorio.EventoRepositorio;

import java.time.LocalDateTime;
import java.util.List;

/**
 * TODO: Adicionar novas funcoes no match_manager.servico
 * <p>
 * Adicionar novo participante no evento
 * Remover participante
 * Dividir o custo do evento por todos os participantes
 */
public class EventoService {
    private final EventoRepositorio eventoRepositorio;

    public EventoService() {
        this.eventoRepositorio = new EventoRepositorio();
    }

    // TODO: Corrigir escrita do nome da funcao
    public void ctiarEvento(Evento evento) {
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

    // TODO: Atualizar precisa seguir as mesmas regras que a criacao do evento
    public void atualizarEvento(Evento evento) {
        if (evento.getId() <= 0) {
            throw new IllegalArgumentException("Id nao encontrado");
        }
        eventoRepositorio.atualizar(evento);
    }

    public void removerEvento(long id) {
        eventoRepositorio.delete(id);
    }

}
