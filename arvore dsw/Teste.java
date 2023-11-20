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
        
        lista = arvore.passo1(arvore, lista);
        lista = arvore.passo2(lista);
        arvore = arvore.passo3(lista);

        for(int i = 0; i < 20; i++){
            arvore.Insere(arvore, rand.nextInt(100));
        }

        lista = arvore.passo1(arvore, lista);
        lista = arvore.passo2(lista);
        arvore = arvore.passo3(lista);
    }
}
