
public class ListaEncadeada<T> {

    private NoLista<T> primeiro;

    public ListaEncadeada() {
        this.primeiro = null;
    }

    public NoLista<T> getPrimeiro() {
        return (NoLista<T>) primeiro;
    }

    public void inserir(T info) {
        NoLista<T> novo = new NoLista<>();
        novo.setInfo(info);
        novo.setProximo(this.primeiro);
        this.primeiro = novo;
    }

    public boolean estaVazia() {
        if (primeiro == null) {
            return true;
        }

        return false;
    }

    public NoLista<T> buscar(T info) {
        NoLista<T> p = primeiro;

        while (p != null) {
            if (p.getInfo().equals(info)) {
                return p;
            }
            p = p.getProximo();
        }
        return null;
    }

    public void retirar(T info) {

        NoLista<T> anterior = null;
        NoLista<T> p = primeiro;

        while (p != null && (p.getInfo() != info)) {
            anterior = p;
            p = p.getProximo();
        }

        if (p != null) {
            if (p == primeiro) {
                this.primeiro = p.getProximo();
            } else {
                anterior.setProximo(p.getProximo());
            }

        }

    }

    public int obterComprimento() {
        int contador = 0;
        NoLista<T> p = primeiro;

        while (p != null) {
            p = p.getProximo();
            contador++;
        }

        return contador;
    }

    public NoLista<T> obterNo(int no) {
        int contador = 0;
        NoLista<T> p = primeiro;

        if (no > -1) {
            while (p != null) {
                if (contador == no) {
                    return p;
                }
                p = p.getProximo();
                contador++;
            }
        }

        throw new IndexOutOfBoundsException("Valor não encontrado");

    }

    public String toString() {
        StringBuilder str = new StringBuilder();
        NoLista<T> p = primeiro;

        while (p != null) {
            str.append(p.getNumeroDeOcorrencias());
            str.append(p.getInfo());

            if (p.getProximo() != null) {
                str.append(", ");
            }
            p = p.getProximo();
        }
        return str.toString();
    }

    public void contadorTags() {
        this.primeiro.setNumeroDeOcorrencias(this.primeiro.getNumeroDeOcorrencias() + 1);
    }

}
