package model.linkedList;

import model.general.Contact;

public class Node {

    private Contact contact;
    private Node nextNode;

    public Node() {}

    public Node(Contact contact) {
        this.contact = contact;
    }

    public Node(Contact contact, Node nextNode) {
        this.contact = contact;
        this.nextNode = nextNode;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    public Node getNextNode() {
        return nextNode;
    }

    public void setNextNode(Node nextNode) {
        this.nextNode = nextNode;
    }
}