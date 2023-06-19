package fila;

import entidades.Mensagem;

public class FilaMensagens {
        public final int N=3;
        Mensagem dados[] = new Mensagem[N];
        int ini, fim, cont;

        public void init() {
            ini = fim = 0;
            cont=0;
        }
        public boolean isEmpty() {
            if (cont==0)
                return true;
            else
                return false;
        }
        public boolean isFull() {
            if (cont==N)
                return true;
            else
                return false;
        }
        public void enqueue(Mensagem elem) {
            if (isFull())
                System.out.println("Fila cheia");
            else {
                dados[fim] = elem;
                fim = (fim+1)%N;
                cont++;
            }
        }
        public Mensagem dequeue() {
            Mensagem elem = dados[ini];
            ini = (ini+1)%N;
            cont--;
            return elem;
        }
        public Mensagem first() {
            return dados[ini];
        }

    public int size(){
            return cont;
    }

}
