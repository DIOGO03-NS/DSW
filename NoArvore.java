import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class NoArvore {
    private int info;
    private NoArvore direita;
    private NoArvore esquerda;

    public NoArvore(){
        this.direita = null;
        this.esquerda = null;
    }

    public NoArvore search(NoArvore tree, int valor){
        if(tree == null){
            return null;
        }else if(tree.info > valor){
            return(search(tree.esquerda, valor));
        }else if(tree.info < valor){
            return(search(tree.direita, valor));
        }else return tree;
    }

    public NoArvore InsereRaiz(NoArvore tree, int valor){
        tree.info = valor;
        tree.direita = null;
        tree.esquerda = null;

        return tree;
    }

    public NoArvore Insere(NoArvore tree, int valor){
        if(tree == null){
            tree = new NoArvore();
            tree.info = valor;
            tree.direita = null;
            tree.esquerda = null;
        }else if(valor < tree.info){
            tree.esquerda = Insere(tree.esquerda, valor);
        }else tree.direita = Insere(tree.direita, valor);
        return tree;
    }

    public NoArvore Retira(NoArvore tree, int valor){
        if(tree == null){
            System.out.println("ELEMENTO NÃO ENCONTRADO" + valor);
            return null;
        }else if(tree.info > valor){
            tree.esquerda = Retira(tree.esquerda, valor);
        }else if(tree.info < valor){
            tree.direita = Retira(tree.direita, valor);
        }else{
            if((tree.esquerda == null) && (tree.direita == null)){
                tree = null;
            }else if(tree.esquerda == null){
                NoArvore novo = tree;
                tree = tree.direita;
            }else if(tree.direita == null){
                NoArvore novo = tree;
                tree = tree.esquerda;
            }else{
                NoArvore novo = tree.esquerda;
                while(novo.direita != null){
                    novo = novo.direita;
                }
                tree.info = novo.info;
                novo.info = valor;
                tree.esquerda = Retira(tree.esquerda, valor);
            }
        }
        return tree;
    }

    public void prefixa(NoArvore tree){
        if(tree == null){
            return;
        }else{
            System.out.print(tree.info + ", ");
            tree.prefixa(tree.esquerda);
            tree.prefixa(tree.direita);
        }

    }

    public void infixa(NoArvore tree){
        if(tree == null){
            return;
        }else{
            tree.infixa(tree.esquerda);
            System.out.print(tree.info + ", ");
            tree.infixa(tree.direita);
            //System.out.println(tree.info);
        }
    }

    public void posfixa(NoArvore tree){
        if(tree == null){
            return;
        }else{
            tree.posfixa(tree.direita);
           // System.out.println(tree.info);
            tree.posfixa(tree.esquerda);
            System.out.print(tree.info + ", ");
        }
    }

        
    public void byLevel(NoArvore root){
        Queue<NoArvore> level  = new LinkedList<>();
        level.add(root);
        while(!level.isEmpty()){
            NoArvore no = level.poll();
            System.out.print(no.info + ", ");
            if(no.esquerda!= null)
            level.add(no.esquerda);
            if(no.direita!= null)
            level.add(no.direita);
        }
    }

    //dsw
    public ArrayList<Integer> passo1(NoArvore arvore, ArrayList<Integer> lista){
        if(arvore == null){
            return lista;
        }else{
            passo1(arvore.esquerda, lista);
            lista.add(arvore.info);
            passo1(arvore.direita, lista);
            return lista;
        }
    }

    public ArrayList<Integer> passo2(ArrayList<Integer> lista,ArrayList<Integer> lista2){
        if(!lista.isEmpty()){
            while(lista.size() > 1){
                int no1 = lista.get(0);
                lista.remove(0);
                int no2 = lista.get(0);
                lista.remove(0);

                lista2.add(no2);
                lista2.add(no1);
            }
        }
        return lista2;
    }

    public NoArvore passo3(ArrayList<Integer> lista){
        NoArvore arvore = new NoArvore();
        if(lista.isEmpty()){
            return arvore;
        }else{
            arvore.InsereRaiz(arvore, lista.get(0));

            while(!lista.isEmpty()){
                arvore.Insere(arvore, lista.get(0));
                lista.remove(0);
            }
            return arvore;
        }
        
        
    }

    public int getInfo() {
        return this.info;
    }

    public void setInfo(int info) {
        this.info = info;
    }

    public NoArvore getDireita() {
        return this.direita;
    }

    public void setDireita(NoArvore direita) {
        this.direita = direita;
    }

    public NoArvore getEsquerda() {
        return this.esquerda;
    }

    public void setEsquerda(NoArvore esquerda) {
        this.esquerda = esquerda;
    }


    
}


