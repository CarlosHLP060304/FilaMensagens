package entidades;

public class Menu {
    public String criaMenu(){
        String aux = "";
        aux += "Digite 0 para encerrar o programa\n"+
                "Digite 1 recebimento de mensagem\n"+
                "Digite 2 atendimento de mensagem\n"+
                "Digite 3 para recebimento e encaminhamento de resolucao\n";
        return aux;
    }
}
