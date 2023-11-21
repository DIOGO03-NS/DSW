import java.util.ArrayList;
import java.util.Random;
public class Teste {
    public static void main(String[] args) {
        Random rand = new Random();
        NoArvore arvore = new NoArvore();
         
        for(int i = 0; i < 100; i++){
            arvore.Insere(arvore, rand.nextInt(100));
        }

        ArrayList<Integer> lista = new ArrayList<Integer>();
        ArrayList<Integer> lista2 = new ArrayList<Integer>();
        
        arvore.infixa(arvore);
        System.out.println();

        lista = arvore.passo1(arvore, lista);
        lista2 = arvore.passo2(lista, lista2);
        arvore = arvore.passo3(lista2);

        for(int i = 0; i < 20; i++){
            arvore.Insere(arvore, rand.nextInt(100));
        }

        lista = arvore.passo1(arvore, lista);
        lista2 = arvore.passo2(lista, lista2);
        arvore = arvore.passo3(lista2);

        arvore.infixa(arvore);
    }
}
