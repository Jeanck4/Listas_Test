public class ArvoreBinaria<T> {

    private NoArvoreBinaria<T> raiz;


    public ArvoreBinaria(){
        raiz = null;
    }

    public NoArvoreBinaria <T> getRaiz(){
        return raiz;
    }

    public boolean estaVazia() {
        if (raiz == null) {
            return true;
        }
            return false;
        
    }

    public boolean pertence(T info) {  // método publico
        return pertence(raiz, info);
    }

    public boolean pertence(NoArvoreBinaria<T> no, T info) {
        if (no == null) {
            return false;

        } else {
            return (no.getInfo().equals(info) ||
                    pertence(no.getEsquerda(), info) ||
                    pertence(no.getDireta(), info)); // Pré ordem

            /*
             * return pertence(no.getEsquerda(), info) ||
             * (no.getInfo().equals(info) ||
             * pertence(no.getDireta(), info)); simétrica
             */

            /*
             * return * (no.getInfo().equals(info) ||
             * pertence(no.getDireta(), info));
             * (no.getEsquerda(), info); Pós ordem
             */

        }

    }

    @Override
    public String toString() { // método publico

        return arvorePre(raiz);
    }

    public String arvorePre(NoArvoreBinaria<T> x) {
        if (x == null) {
            return "<>";

        } else {

            return "<" +
                    arvorePre(x.getEsquerda()) +
                    arvorePre(x.getDireta()) +
                    ">";

        }
    }

    public int contadorNo() { // método publico
        return contadorNo(raiz);

    }

    public int contadorNo(NoArvoreBinaria<T> x) {
        if (x == null) {
            return 0;

        } else {

            return 1 +
                    contadorNo(x.getEsquerda()) +
                    contadorNo(x.getDireta());
        }
    }


    public void setRaiz(NoArvoreBinaria<T> raiz) {
        this.raiz = raiz;
    }

}
