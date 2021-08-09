package pacotes;

public class main {
    public static void main(String[] args) {

        ListaCircular<String> lista = new ListaCircular<String>();

        System.out.println(lista.isEmpty());
        lista.add("teste1");
        lista.add("teste2");
        lista.add("teste3");
        lista.add("teste4");
        lista.add("teste5");
        System.out.println(lista);
        System.out.println(lista.size());
        System.out.println(lista.isEmpty());

        System.out.println(lista.get(0));
        System.out.println(lista.get(1));
        System.out.println(lista.get(2));
        System.out.println(lista.get(3));
        System.out.println(lista.get(4));

        lista.remove(2);
        System.err.println(lista);
    }
}
