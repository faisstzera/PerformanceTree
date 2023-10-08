package p1;

public class Main {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();

        // Adicionar elementos à árvore
        tree.add(1);
        tree.add(2);
        tree.add(3);
        tree.add(4);
        tree.add(5);

        // Chamar funções de percurso sem passar a raiz como parâmetro
        System.out.println("Em ordem:");
        tree.percorrerEmOrdem(tree.root);

        System.out.println("\nPré-ordem:");
        tree.percorrerPreOrdem(tree.root);

        System.out.println("\nPós-ordem:");
        tree.percorrerPosOrdem(tree.root);

        // Outras operações na árvore, como remover um elemento
        tree.remover(3);

        // Chamar as funções de percurso novamente após a modificação da árvore
        System.out.println("\nEm ordem após a remoção:");
        tree.percorrerEmOrdem(tree.root);
        System.out.println("\n-----------------------------------");

        AVLTree avlTree = new AVLTree();

        // Adicionar elementos à árvore AVL
        avlTree.adicionar(1);
        avlTree.adicionar(2);
        avlTree.adicionar(3);
        avlTree.adicionar(4);
        avlTree.adicionar(5);

        avlTree.percorrerEmOrdem();

        System.out.println("\n");

        // Chamar a função de busca
        AVLTree.Node encontrado = avlTree.busca(3);
        System.out.println("Elemento encontrado: " + (encontrado != null ? encontrado.valor : "Não encontrado"));

        // Outras operações na árvore AVL, como remover um elemento
        avlTree.apagar(3);

        AVLTree.Node encontrado2 = avlTree.busca(3);
        System.out.println("Elemento encontrado: " + (encontrado2 != null ? encontrado2.valor : "Não encontrado"));

        System.out.println("\n");

        avlTree.percorrerEmOrdem();

    }
}
