package p1;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Random random = new Random();

        // Testar desempenho da BinaryTree
        BinaryTree binaryTree = new BinaryTree();
        testPerformance(binaryTree, random, 100);
        testPerformance(binaryTree, random, 500);
        testPerformance(binaryTree, random, 1000);
        testPerformance(binaryTree, random, 10000);
        testPerformance(binaryTree, random, 20000);

        System.out.println("-----------------------------------");

        // Testar desempenho da AVLTree
        AVLTree avlTree = new AVLTree();
        testPerformance(avlTree, random, 100);
        testPerformance(avlTree, random, 500);
        testPerformance(avlTree, random, 1000);
        testPerformance(avlTree, random, 10000);
        testPerformance(avlTree, random, 20000);
    }

    private static void testPerformance(BinaryTree tree, Random random, int size) {
        long startTime = System.currentTimeMillis();

        for (int i = 0; i < size; i++) {
            tree.add(random.nextInt(1000000)); // Adiciona números aleatórios à árvore
        }

        long endTime = System.currentTimeMillis();

        System.out.println(tree.getClass().getSimpleName() + " - " + size + " elementos: " + (endTime - startTime) + " ms");
    }

    private static void testPerformance(AVLTree tree, Random random, int size) {
        long startTime = System.currentTimeMillis();

        Set<Integer> uniqueValues = new HashSet<>();
        while (uniqueValues.size() < size) {
            uniqueValues.add(random.nextInt(1000000));
        }

        for (int value : uniqueValues) {
            tree.adicionar(value);
        }

        long endTime = System.currentTimeMillis();

        System.out.println(tree.getClass().getSimpleName() + " - " + size + " elementos: " + (endTime - startTime) + " ms");
    }

}
