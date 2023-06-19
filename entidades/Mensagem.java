package entidades;

public class Mensagem {
    private String nome;
    private String contato; //email/telefone
    private int motivo;
    private String descricao;


    public Mensagem(String nome,String comunicacao,int motivo,String descricao) {
        this.nome = nome;
        this.descricao = descricao;
        this.contato = comunicacao;
        this.motivo = motivo;
    }

    public int getMotivo() {
        return motivo;
    }

    public String toString(){
        String aux = "Informacoes da mensagem:\n";
        aux += "1.Nome: " + nome + "\n"+
                "2.Contato: " + contato + "\n"+
                "3.Motivo: " + motivo + "\n"+
                "4.Descricao: " + descricao;
        return aux;
    }
}
