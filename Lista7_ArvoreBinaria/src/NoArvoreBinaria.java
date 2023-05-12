public class NoArvoreBinaria<T> {

    private T info;
    private NoArvoreBinaria<T> esquerda;
    private NoArvoreBinaria<T> direta;

  

    public NoArvoreBinaria(T info) {
        this.info = info;
        esquerda = null;
        direta = null;
    }

    public NoArvoreBinaria(T info, NoArvoreBinaria<T> esq, NoArvoreBinaria<T> dir) {
        this.info = info;
        esquerda = esq;
        direta = dir;

    }

    public T getInfo() {
        return info;
    }

    public void setInfo(T info) {
        this.info = info;
    }

    public NoArvoreBinaria<T> getEsquerda() {
        return esquerda;
    }

    public void setEsquerda(NoArvoreBinaria<T> esquerda) {
        this.esquerda = esquerda;
    }

    public NoArvoreBinaria<T> getDireta() {
        return direta;
    }

    public void setDireta(NoArvoreBinaria<T> direta) {
        this.direta = direta;
    }

}
