package modelo;

import java.time.LocalDateTime;

public class Evento {
    private long id;
    private LocalDateTime datahora;
    private long custo;
    private Endereco local;
    private ParticipacaoEvento participante;

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    public LocalDateTime getDatahora() {
        return datahora;
    }
    public void setDatahora(LocalDateTime datahora) {
        this.datahora = datahora;
    }

    public long getCusto() {
        return custo;
    }
    public void setCusto(long custo) {
        this.custo = custo;
    }

    public Endereco getLocal() {
        return local;
    }
    public void setLocal(Endereco local) {
        this.local = local;
    }

    public ParticipacaoEvento getParticipante() {
        return participante;
    }
    public void setParticipante(ParticipacaoEvento participante) {
        this.participante = participante;
    }



}
