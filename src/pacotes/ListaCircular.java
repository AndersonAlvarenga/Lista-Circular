package pacotes;

public class ListaCircular<T> {

    private No<T> cabeca;
    private No<T> calda;
    private int tamanho;


    public ListaCircular() {
        this.cabeca = null;
        this.calda = null;
        this.tamanho = 0;
    }

    public void add(T conteudo) {
        No<T> novoNo = new No<T>(conteudo);
        if (tamanho == 0) {
            cabeca = novoNo;
            calda = novoNo;
            calda.setProximoNo(calda);
        } else {
            cabeca.setProximoNo(novoNo);
            cabeca = novoNo;
            cabeca.setProximoNo(calda);
        }
        this.tamanho++;
    }

    public void remove(int index) {
        validaIndex(index);
        if (isEmpty()) {
            System.err.println("A lista esta vazia");
            return;
        }
        No<T> noAux = getNo(index);
        if (size() == 1) {
            this.cabeca = null;
            this.calda = null;
        } else {
            if (index == size() - 1) {
                No<T> noAnterior = this.getNo(index - 1);
                noAnterior.setProximoNo(calda);
                this.cabeca = noAnterior;
            } else {
                if (index == 0) {
                    calda = getNo(index + 1);
                    cabeca.setProximoNo(calda);
                } else {
                    No<T> noAnterio = getNo(index - 1);
                    No<T> proximoNo = getNo(index + 1);
                    noAnterio.setProximoNo(proximoNo);
                }
            }
        }
        this.tamanho--;
    }

    public T get(int index) {
        return getNo(index).getConteudo();
    }

    private No<T> getNo(int index) {
        validaIndex(index);
        if (this.tamanho == 0) {
            System.err.println("A lista está vazia");
            return null;
        }
        No<T> noAux = calda;
        for (int i = 0; i < index; i++) {
            noAux = noAux.getProximoNo();
        }
        return noAux;
    }

    private void validaIndex(int index) {
        if (index > size()-1) {
            throw new IndexOutOfBoundsException("Index maior que o tamanho da lista");
        }
    }

    public boolean isEmpty() {
        return tamanho == 0 ? true : false;
    }

    public int size() {
        return tamanho;
    }

    @Override
    public String toString() {
        String srt = "";
        No<T> noAux = calda;
        for (int i = 0; i < tamanho; i++) {
            srt += "Conteudo: " + noAux.getConteudo() + "---------->";
            noAux=noAux.getProximoNo();
        }
        srt += "retorna ao inicio";
        return srt;
    }
}
