package main.parte02_main;

import model.general.Contact;
import model.linkedList.LinkedList;

import java.util.Random;

public class SortLinkedListMain {
    public static void main(String[] args) {
        // Atividade parte 02 - Ordenação em Listas Encadeadas

        Random rd = new Random();
        LinkedList listBubbleSort = new LinkedList();
        LinkedList listMergeSort = new LinkedList();

        for (int i = 0; i < 10000; i++)
            listBubbleSort.insert(new Contact("Contato" + Math.abs(rd.nextInt()), "999999999"));

        for (int i = 0; i < 10000; i++)
            listMergeSort.insert(new Contact("Contato" + Math.abs(rd.nextInt()), "999999999"));

        // Bubble Sort
        long start = System.currentTimeMillis();
        listBubbleSort.bubbleSort();
        long end = System.currentTimeMillis();
        System.out.println("Bubble Sort: " + (end - start) + "ms");

        // Merge Sort
        long start2 = System.currentTimeMillis();
        listBubbleSort.mergeSort();
        long end2 = System.currentTimeMillis();
        System.out.println("Merge Sort: " + (end2 - start2) + "ms");
    }
}
