import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ValidadorHtml {

    PilhaLista<String> pilha = new PilhaLista<>();
    ListaEncadeada<String> tagsEncontradas = new ListaEncadeada<>();
    ListaEncadeada<String> tagsFinaisInexperadas = new ListaEncadeada<>();
    String[] singleton = { "<area>", "<base>", "<br>", "<col>", "<embed>", "<hr>", "<img>", "<input>",
            "<link>", "<meta>", "<param>", "<source>", "<track>", "<wbr>" };

    /**
     * MÉTODO BUFFER: responsável por ler o código html e colocar as tags em uma
     * pilha.
     */
    public void buffer() {
        String str = "";

        try {
            BufferedReader in = new BufferedReader(new FileReader("src/test.html"));
            while ((str = in.readLine()) != null) {
                if (!str.isEmpty()) {
                    str += " ";
                    verificarLinha(str);
                }
            }
            in.close();
        } catch (IOException e) {
            throw new ErroNaLeituraException();
        }
    }

    public void verificarLinha(String linha) {

        boolean tagFinal = false;
        String str = "";
        for (int i = 0; i < linha.length(); i++) {
            tagFinal = false;
            if (linha.charAt(i) == '<') {
                str = "";
                for (int j = i; j < linha.length(); j++) {
                    if (linha.charAt(j) == ' ') {
                        str += '>';
                        pilha.push(str);
                        pop(str, tagFinal);
                        str = "";
                        break;
                    }
                    if (linha.charAt(j) != '/') {
                        str += linha.charAt(j);
                    } else {
                        tagFinal = true;
                    }
                    if (linha.charAt(j) == '>') {
                        if (!tagFinal) {
                            pilha.push(str);
                        }
                        pop(str, tagFinal);
                        str = "";
                        break;
                    }
                }

            }
        }
        // verificar se o código está bem formatado, sem sim, a lista deve estar vazia
        if (pilha.estaVazia()) {
            System.out.println("Código está bem formatado");
        } else {

        }
    }

    public void pop(String elemento, boolean tagFinal) {

        if (pilha.peek() != null) {
            if (elemento.equals(pilha.peek()) && tagFinal) {
                pilha.pop();
                if (tagsEncontradas.buscar(elemento) != null) {
                    tagsEncontradas.buscar(elemento).aumentarOcorrencia();

                } else {
                    tagsEncontradas.inserir(elemento);
                    tagsEncontradas.buscar(elemento).aumentarOcorrencia();
                }
                return;
            } else if (tagFinal) {

                if (tagsFinaisInexperadas.buscar(elemento) != null) {
                    tagsFinaisInexperadas.buscar(elemento).aumentarOcorrencia();

                } else {
                    tagsFinaisInexperadas.inserir(elemento);
                    tagsFinaisInexperadas.buscar(elemento).aumentarOcorrencia();
                }
            }
            for (String singleton : this.singleton) {

                if (singleton.equals(elemento)) {
                    pilha.pop();
                    if (tagsEncontradas.buscar(elemento) != null) {
                        tagsEncontradas.buscar(elemento).aumentarOcorrencia();
                    } else {
                        tagsEncontradas.inserir(elemento);
                        tagsEncontradas.buscar(elemento).aumentarOcorrencia();
                    }
                    return;
                }
            }

        }

    }

    public static void main(String[] args) {
        ValidadorHtml c1 = new ValidadorHtml();
        c1.buffer();
        // System.out.println(c1.pilha.toString());
        System.out.println(c1.tagsEncontradas.toString());
        System.out.println(c1.tagsFinaisInexperadas.toString());
    }

}
