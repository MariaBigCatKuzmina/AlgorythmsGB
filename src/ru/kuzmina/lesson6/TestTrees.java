package ru.kuzmina.lesson6;

import java.util.Random;

public class TestTrees {
    public static Tree<Integer> createRandomTree(int maxLevel, int maxValue, int minValue) {
        Tree<Integer> tree = new TreeImpl<>(maxLevel);
        Random rnd = new Random();
        int val = rnd.nextInt(maxValue);
        while (tree.add(val)){
            val = rnd.nextInt(maxValue * 2) + minValue;
        }
        return tree;
    }

    public static void main(String[] args) {

        Tree<Integer>[] trees = new Tree[20];
        int imbalancedCount = 0;

        for (int i = 0; i < 20; i++) {
            trees[i] = createRandomTree(4, 25, -25);
            if (!trees[i].isBalanced()) {
                imbalancedCount++;
            }
            System.out.println("=========== tree № " + (i + 1));
            trees[i].display();

        }
        System.out.printf("Несбалансированных деревьев: %d процентов" , (imbalancedCount / (trees.length - 1) * 100));


    }
}
