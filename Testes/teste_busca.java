package p1;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random random = new Random();

        // Testar desempenho da BinaryTree (busca)
        BinaryTree binaryTree = new BinaryTree();
        testSearchPerformance(binaryTree, random, 100);
        testSearchPerformance(binaryTree, random, 500);
        testSearchPerformance(binaryTree, random, 1000);
        testSearchPerformance(binaryTree, random, 10000);
        testSearchPerformance(binaryTree, random, 20000);
        testSearchPerformance(binaryTree, random, 50000);

        System.out.println("-----------------------------------");

        // Testar desempenho da AVLTree (busca)
        AVLTree avlTree = new AVLTree();
        testSearchPerformance(avlTree, random, 100);
        testSearchPerformance(avlTree, random, 500);
        testSearchPerformance(avlTree, random, 1000);
        testSearchPerformance(avlTree, random, 10000);
        testSearchPerformance(avlTree, random, 20000);
        testSearchPerformance(avlTree, random, 50000);
    }

    private static void testSearchPerformance(BinaryTree tree, Random random, int size) {
        // Adiciona elementos à árvore
        for (int i = 0; i < size; i++) {
            tree.add(random.nextInt(1000000));
        }

        long startTime = System.currentTimeMillis();

        // Executa buscas aleatórias
        for (int i = 0; i < size; i++) {
            tree.contemNode (random.nextInt(1000000));
        }

        long endTime = System.currentTimeMillis();

        System.out.println(tree.getClass().getSimpleName() + " (Busca) - " + size + " elementos: " + (endTime - startTime) + " ms");
    }

    private static void testSearchPerformance(AVLTree tree, Random random, int size) {
        // Adiciona elementos à árvore AVL
        for (int i = 0; i < size; i++) {
            tree.adicionar(random.nextInt(1000000));
        }

        long startTime = System.currentTimeMillis();

        // Executa buscas aleatórias
        for (int i = 0; i < size; i++) {
            tree.busca(random.nextInt(1000000));
        }

        long endTime = System.currentTimeMillis();

        System.out.println(tree.getClass().getSimpleName() + " (Busca) - " + size + " elementos: " + (endTime - startTime) + " ms");
    }
}

