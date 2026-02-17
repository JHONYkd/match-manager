package match_manager.modelo;

public class Participante {
   private long id;
   private String nome;
   private Posicao posicao;


   public long getId() {
       return id;
   }
   public void setId(long id) {
       this.id = id;
   }

   public String getNome() {
       return nome;
   }
   public void setNome(String nome) {
       this.nome = nome;
   }

   public Posicao getPosicao() {
       return posicao;
   }
   public void setPosicao(Posicao posicao) {
       this.posicao = posicao;
   }


}
