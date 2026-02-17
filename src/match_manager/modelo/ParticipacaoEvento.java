package match_manager.modelo;

public class ParticipacaoEvento {
    long id;
    private Evento evento;
    private Participante participante;
    private Posicao posicao;
    private boolean pago;

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    public Evento getEvento() {
        return evento;
    }
    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    public Participante getParticipante() {
        return participante;
    }
    public void setParticipante(Participante participante) {
        this.participante = participante;
    }

    public Posicao getPosicao() {
        return posicao;
    }
    public void setPosicao(Posicao posicao) {
        this.posicao = posicao;
    }

    public boolean isPago() {
        return pago;
    }
    public void setPago(boolean pago) {
        this.pago = pago;
    }

}
