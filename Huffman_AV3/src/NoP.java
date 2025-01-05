public class NoP implements Comparable<NoP> {
    private char elemento;
    private NoP proximo;
    private int prioridade;
    private NoP esquerda;
    private NoP direita;

    public NoP(int prioridade, NoP direita, NoP esquerda) {
        this.elemento = '\0';
        this.proximo = null;
        this.prioridade = prioridade;
        this.esquerda = esquerda;
        this.direita = direita;

    }

    public NoP(char elemento, Integer prioridade) {
        this.elemento = elemento;
        this.prioridade = prioridade;
        this.proximo = null;
        this.direita = null;
        this.esquerda = null;

    }

    public boolean leaf(){
        return this.esquerda == null && this.direita == null;

    }

    public Character getElemento() {
        return elemento;
    }

    public NoP getProximo() {
        return proximo;
    }

    public void setProximo(NoP proximo) {
        this.proximo = proximo;
    }

    public int getPrioridade() {
        return prioridade;
    }

    public NoP getEsquerda() {
        return esquerda;
    }

    public NoP getDireita() {
        return direita;
    }

    @Override
    public int compareTo(NoP o) {
        if (this.prioridade != o.prioridade) {
            return Integer.compare(this.prioridade, o.prioridade);
        } else {
            if (this.elemento == '\0' && o.elemento != '\0') {
                return 1;

            } else if (this.elemento != '\0' && o.elemento == '\0') {
                return -1;

            } else{
                return Character.compare(this.elemento, o.elemento);
            }
        }
    }
}