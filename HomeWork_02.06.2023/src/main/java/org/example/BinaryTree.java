package org.example;

import java.awt.*;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Pattern;

public class BinaryTree {
    private Node root;

    private class Node {
        private int data;
        private Node left;
        private Node right;

        public Node(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }

    public BinaryTree() {
        root = null;
    }

    public void insert(int data) {
        root = insertNode(root, data);
    }

    private Node insertNode(Node root, int data) {
        if (root == null) {
            root = new Node(data);
            return root;
        }

        if (data < root.data) {
            root.left = insertNode(root.left, data);
        } else if (data > root.data) {
            root.right = insertNode(root.right, data);
        }

        return root;
    }

    public boolean search(int data) {
            return searchNode(root, data);
    }

    private boolean searchNode(Node root, int data) {
        if (root == null) {
            return false;
        }

        if (data == root.data) {
            return true;
        } else if (data < root.data) {
            return searchNode(root.left, data);
        } else {
            return searchNode(root.right, data);
        }
    }

    public void inorderTraversal() {
        inorder(root);
    }

    private void inorder(Node root) {
        if (root != null) {
            inorder(root.left);
            System.out.print(root.data + " ");
            inorder(root.right);
        }
    }

    public void printTree() {
        printTree(root, 0);
    }

    private void printTree(Node root, int level) {
        if (root == null) {
            return;
        }

        printTree(root.right, level + 1);

        if (level != 0) {
            for (int i = 0; i < level - 1; i++) {
                System.out.print("|\t");
            }
            System.out.println("|----" + root.data);
        } else {
            System.out.println(root.data);
        }

        printTree(root.left, level + 1);
    }

    public void preorderTraversal() {
        preorder(root);
    }

    private void preorder(Node root) {
        if (root != null) {
            System.out.print(root.data + " ");
            preorder(root.left);
            preorder(root.right);
        }
    }

    public void postorderTraversal() {
        postorder(root);
    }

    private void postorder(Node root) {
        if (root != null) {
            postorder(root.left);
            postorder(root.right);
            System.out.print(root.data + " ");
        }
    }
    private static void findNumber(BinaryTree tree){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Выбери какое число найти: ");
        int number = 0;
        try{
            number = scanner.nextInt();
        }catch (InputMismatchException e){
            System.out.println("Обибка попробуй снова.");
            findNumber(tree);
        }
        System.out.println("Результат поиска: " + tree.search(number));
    }


    public static void main(String[] args) {

        BinaryTree tree = new BinaryTree();
        Scanner scanner = new Scanner(System.in);
        String choice;
        boolean exit = true;
        tree.insert(50);
        tree.insert(30);
        tree.insert(20);
        tree.insert(40);
        tree.insert(70);
        tree.insert(60);
        tree.insert(80);
        while (exit){
            System.out.println("---------------------------------------------------------");
            System.out.println("A -> Графическое отображение дерева.");
            System.out.println("B -> Симметричный обход дерева. ");
            System.out.println("C -> Прямой обход дерева. ");
            System.out.println("D -> Обратный обход дерева. ");
            System.out.println("E -> Поиск числа.");
            System.out.println("Z -> Выход.");
            System.out.println("---------------------------------------------------------");

            System.out.print("Выбери то что хочешь сделать: ");
            choice = scanner.nextLine();
            if (choice.equals(choice.toLowerCase())){
                choice = choice.toUpperCase();
            }
            switch (choice) {
                case "A":
                    System.out.println("\nГрафическое отображение дерева:");
                    tree.printTree();
                    break;
                case "B":
                    System.out.println("\nСимметричный обход дерева: ");
                    tree.inorderTraversal();
                    System.out.println();
                    break;
                case "C":
                    System.out.println("\nПрямой обход дерева: ");
                    tree.preorderTraversal();
                    System.out.println();
                    break;
                case "D":
                    System.out.println("\nОбратный обход дерева: ");
                    tree.postorderTraversal();
                    System.out.println();
                    break;
                case "E":
                    findNumber(tree);
                    break;
                case "Z":
                    System.out.println("See you next time!");
                    System.out.println("\t(^_^)");
                    exit = false;
                    break;
            }
        }
    }
}
