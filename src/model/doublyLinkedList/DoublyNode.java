package model.doublyLinkedList;

import model.general.Contact;
import model.linkedList.Node;

public class DoublyNode {

    private Contact contact;
    private DoublyNode previousNode;
    private DoublyNode nextNode;

    public DoublyNode() {}

    public DoublyNode(Contact contact) {
        this.contact = contact;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    public DoublyNode getPreviousNode() {
        return previousNode;
    }

    public void setPreviousNode(DoublyNode previousNode) {
        this.previousNode = previousNode;
    }

    public DoublyNode getNextNode() {
        return nextNode;
    }

    public void setNextNode(DoublyNode nextNode) {
        this.nextNode = nextNode;
    }
}