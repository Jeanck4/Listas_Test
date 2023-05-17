
public class NoLista<T> {

    private T info;
    private NoLista<T> proximo;
    private int numeroDeOcorrencias;

    public void aumentarOcorrencia() {
        this.numeroDeOcorrencias++;
    }

    public int getNumeroDeOcorrencias() {
        return numeroDeOcorrencias;
    }

    public void setNumeroDeOcorrencias(int numeroDeOcorrencias) {
        this.numeroDeOcorrencias = numeroDeOcorrencias;
    }

    public T getInfo() {
        return info;
    }

    public void setInfo(T info) {
        this.info = info;
    }

    public NoLista<T> getProximo() {
        return (NoLista<T>) this.proximo;
    }

    public void setProximo(NoLista<T> proximo) {
        this.proximo = proximo;
    }
}
