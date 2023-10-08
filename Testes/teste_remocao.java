package p1;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random random = new Random();

        // Testar desempenho da BinaryTree (exclusão)
        BinaryTree binaryTree = new BinaryTree();
        testRemovalPerformance(binaryTree, random, 100);
        testRemovalPerformance(binaryTree, random, 500);
        testRemovalPerformance(binaryTree, random, 1000);
        testRemovalPerformance(binaryTree, random, 10000);
        testRemovalPerformance(binaryTree, random, 20000);
        testRemovalPerformance(binaryTree, random, 50000);

        System.out.println("-----------------------------------");

        // Testar desempenho da AVLTree (exclusão)
        AVLTree avlTree = new AVLTree();
        testRemovalPerformance(avlTree, random, 100);
        testRemovalPerformance(avlTree, random, 500);
        testRemovalPerformance(avlTree, random, 1000);
        testRemovalPerformance(avlTree, random, 10000);
        testRemovalPerformance(avlTree, random, 20000);
        testRemovalPerformance(avlTree, random, 50000);
    }

    private static void testRemovalPerformance(BinaryTree tree, Random random, int size) {
        // Adiciona elementos à árvore
        for (int i = 0; i < size; i++) {
            tree.add(random.nextInt(1000000));
        }

        long startTime = System.currentTimeMillis();

        // Executa remoções aleatórias
        for (int i = 0; i < size; i++) {
            tree.remover(random.nextInt(1000000));
        }

        long endTime = System.currentTimeMillis();

        System.out.println(tree.getClass().getSimpleName() + " (Exclusão) - " + size + " elementos: " + (endTime - startTime) + " ms");
    }

    private static void testRemovalPerformance(AVLTree tree, Random random, int size) {
        // Adiciona elementos à árvore AVL
        for (int i = 0; i < size; i++) {
            tree.adicionar(random.nextInt(1000000));
        }

        long startTime = System.currentTimeMillis();

        // Executa exclusões aleatórias
        for (int i = 0; i < size; i++) {
            tree.apagar(random.nextInt(1000000));
        }

        long endTime = System.currentTimeMillis();

        System.out.println(tree.getClass().getSimpleName() + " (Exclusão) - " + size + " elementos: " + (endTime - startTime) + " ms");
    }
}