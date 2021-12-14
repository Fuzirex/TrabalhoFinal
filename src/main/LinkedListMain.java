package main;

import model.general.Contact;
import model.linkedList.LinkedList;

public class LinkedListMain {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        list.insert(new Contact("Matheus", "40028922"));
        list.insert(new Contact("Yan", "40028922"));
        list.insert(new Contact("Ana", "40028922"));
        list.insert(new Contact("Beatriz", "40028922"));
        list.insert(new Contact("Pedro", "40028922"));
        list.insert(new Contact("Marcelo", "40028922"));
        list.insert(new Contact("Willian", "40028922"));
        list.insert(new Contact("Ziggi", "40028922"));
        list.insert(new Contact("Lucas", "40028922"));
        list.insert(new Contact("Dina", "40028922"));

        list.showAll();
        list.sort();
        list.showAll();
    }
}
