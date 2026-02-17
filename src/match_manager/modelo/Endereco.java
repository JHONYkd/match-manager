package match_manager.modelo;

public class Endereco {
    private long id;
    private String Estabelecimento;
    private String link;
    private String endereco;


    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    public String getEstabelecimento() {
        return Estabelecimento;
    }
    public void setEstabelecimento(String Estabelecimento) {
        this.Estabelecimento = Estabelecimento;
    }

    public String getLink() {
        return link;
    }
    public void setLink(String link) {
        this.link = link;
    }

    public String getEndereco() {
        return endereco;
    }
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }


}
