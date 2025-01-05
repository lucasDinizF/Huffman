public class MyFileP {
    private NoP primeiro;
    private NoP ultimo;
    public int count;

    public MyFileP(){
        this.primeiro = null;
        this.ultimo = null;
        this.count = 0;

    }

    public void Enqueue(char elemento, int prioridade){
        NoP novo = new NoP(elemento, prioridade);

        if (this.primeiro == null) {
            this.primeiro = novo;
            this.ultimo = novo;

        } else {
            NoP anterior = null;
            NoP atual = this.primeiro;
            while (atual != null && novo.compareTo(atual) >= 0) {
                anterior = atual;
                atual = atual.getProximo();

            }
            if (anterior == null) {
                novo.setProximo(this.primeiro);
                this.primeiro = novo;

            } else {
                anterior.setProximo(novo);
                novo.setProximo(atual);
                if (atual == null) {
                    this.ultimo = novo;

                }
            }
        }
        this.count++;

    }

    public void Enqueue(NoP elemento){
        NoP novo = new NoP(elemento.getPrioridade(), elemento.getEsquerda(), elemento.getDireita());

        if (this.primeiro == null) {
            this.primeiro = novo;
            this.ultimo = novo;

        } else {
            NoP anterior = null;
            NoP atual = this.primeiro;

            while (atual != null && novo.compareTo(atual) >= 0) {
                anterior = atual;
                atual = atual.getProximo();
            }

            if (anterior == null) {
                novo.setProximo(this.primeiro);
                this.primeiro = novo;

            } else {
                anterior.setProximo(novo);
                novo.setProximo(atual);
                if (atual == null) {
                    this.ultimo = novo;
                }
            }
        }
        count++;
    }

    public void show(){
        if (this.count == 0){
            System.out.println("[]");

        } else {
            NoP atual = primeiro;

            while (atual.getProximo() != null){
                System.out.print(atual.getElemento() + "(" + atual.getPrioridade() + ")" + ", ");
                atual = atual.getProximo();

            }

            System.out.println(atual.getElemento() + "(" + atual.getPrioridade() + ")");

        }

    }


    public int size(){
        return this.count;

    }

    public void clear(){
        this.primeiro = null;
        this.ultimo = null;
        this.count = 0;

    }

    public NoP Dequeue(){
        NoP novo = this.primeiro;

        if(count == 1){
            this.primeiro = null;

        }else {
            this.primeiro = this.primeiro.getProximo();
        }

        count--;

        return novo;
    }



    public NoP getAdd(int P){
        if(!(P >= 0 && P <= this.count)){
            throw new IllegalArgumentException("Posicao nao existe");

        }

        NoP aux = primeiro;

        for (int i = 0; i < P; i++){
            aux = aux.getProximo();

        }

        return aux;
    }

    public Object Search(int posicao){
        return getAdd(posicao).getElemento();

    }

    public Object Front(){
        return primeiro.getElemento();

    }
}