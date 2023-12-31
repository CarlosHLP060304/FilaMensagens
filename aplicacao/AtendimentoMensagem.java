//Carlos Henrique Lins Ponchirolli
//Leonardo Arantes Bianchini Gomes 

package aplicacao;


import fila.FilaMensagens;
import entidades.Mensagem;
import entidades.Menu;

import static javax.swing.JOptionPane.*;
import static java.lang.Integer.parseInt;

public class AtendimentoMensagem {
        public static void main(String[] args){
            Menu menu =new Menu();
            FilaMensagens filaReclamacao = new FilaMensagens();
            FilaMensagens filaSugestao = new FilaMensagens();
            FilaMensagens filaResolucao= new FilaMensagens();
            int opcao;
            do {
                opcao = Integer.parseInt(showInputDialog(null,menu.criaMenu(),
                        "Sistema de recebimento de mensagens".toUpperCase(),1));
                switch (opcao){
                    case 0:
                        if(filaReclamacao.isEmpty() && filaSugestao.isEmpty() && filaResolucao.isEmpty()){
                            showMessageDialog(null,"Fechando sistema...");
                            opcao =-1;

                        }else{
                            showMessageDialog(null, "Ainda ha processos a serem finalizados!");
                        }
                        break;
                    case 1:
                        String nome = showInputDialog(null,"Digite seu nome:");
                        String contato = showInputDialog(null,"Digite seu email ou telefone");
                        int motivo = Integer.parseInt(showInputDialog("Motivo de contato (Digite 1 para reclamacao e 2 para sugestao)"));
                        String descricao = showInputDialog("Digite uma mensagem (deve conter a descricao do problema ou da sugestao)");
                        Mensagem mensagem = new Mensagem(nome,contato,motivo,descricao);
                        if(mensagem.getMotivo() == 1){
                            filaReclamacao.enqueue(mensagem);
                            showMessageDialog(null,"Mensagem adicionada lista de reclamacoes!");
                        }else if (mensagem.getMotivo() == 2){
                            filaSugestao.enqueue(mensagem);
                            showMessageDialog(null,"Mensagem adicionada a  lista de sugestoes!");
                        }
                        break;
                    case 2:
                        int resposta = parseInt(showInputDialog(null, "Digite 1 para responder uma reclamacao." +
                                "\nDigite 2 para responder uma sugestao."));

                        if(resposta == 1){
                            if(!filaReclamacao.isEmpty()){
                                Mensagem primeira_reclamacao = filaReclamacao.dequeue();
                                String lista_reclamacao = "Reclamacao: ".toUpperCase() +"\n"+ primeira_reclamacao;
                                int atendimento = parseInt(showInputDialog(lista_reclamacao + "\nPara responder a reclamacao"+
                                        " imediatamente, digite 1.\n" +
                                        "Para responder enviar a reclamacao para outro setor, digite 2."));
                                if(atendimento == 1){
                                    showMessageDialog(null, "Enviada resposta para cliente:" +
                                            " sua solicitacao ja foi resolvida. Obrigado!!!");
                                } else if (atendimento == 2) {
                                    showMessageDialog(null, "Enviada resposta para cliente:" +
                                            " sua mensagem em breve sera respondida...");
                                    filaResolucao.enqueue(primeira_reclamacao);
                                }
                            }else{
                                showMessageDialog(null,"Lista de reclamacao vazia!!!");
                            }
                        }else if(resposta == 2){
                            if(!filaSugestao.isEmpty()){
                                Mensagem primeira_sugestao = filaSugestao.dequeue();
                                String lista_reclamacao = "Reclamacao: ".toUpperCase() +"\n"+ primeira_sugestao;
                                int atendimento = parseInt(showInputDialog(lista_reclamacao + "\nPara responder a sugestao"+
                                        " imediatamente digite 1.\n" +
                                        "Para responder enviar a reclamacao para outro setor, digite 2."));
                                if(atendimento == 1){
                                    showMessageDialog(null, "Enviada resposta para cliente:" +
                                            " sua solicitacao ja foi resolvida. Obrigado!!!");
                                } else if (atendimento == 2) {
                                    showMessageDialog(null, "Enviada resposta para cliente:" +
                                            " sua mensagem em breve sera respondida...");
                                    filaResolucao.enqueue(primeira_sugestao);
                                }
                            }else
                                showMessageDialog(null,"Lista de sugestao vazia!!!");
                        }
                        break;

                    case 3:
                        if(!filaResolucao.isEmpty()){
                            String mensagem_resolucao = "Mensagens pendentes: ";
                            
                            for (int i = 0; i < filaResolucao.size() ; i++) {
                                mensagem_resolucao += "\n" + filaResolucao.dequeue().toString();
                            }
                 
                            showMessageDialog(null, mensagem_resolucao);
                            showMessageDialog(null, "Enviada resposta para cliente: sua "+
                                    "solicitacao ja foi resolvida pelo setor responsavel. Obrigado!!!");

                        }else {
                            showMessageDialog(null,"Nenhuma mensagem foi enviada para a fila de resolucao!!!");
                        }

                        break;

                    default:
                        showMessageDialog(null,"Digite a opcao novamente!");
                        opcao = 0;
                }
            }while(opcao>=0 && opcao<=3);

        }
    }



