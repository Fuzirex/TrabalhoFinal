package model.linkedList;

import model.general.Contact;

import javax.swing.*;

public class LinkedList {

    private Node head;

    public LinkedList() {
    }

    public void insert(Contact contact) {
        if (head != null) {
            Node currentNode = head;

            while (currentNode.getNextNode() != null)
                currentNode = currentNode.getNextNode();

            currentNode.setNextNode(new Node(contact));
        } else {
            head = new Node(contact);
        }
    }

    public void remove(int indexToRemove) {
        if (head != null) {
            if (indexToRemove == 0)
                head = head.getNextNode();
            else {
                int index = 0;
                Node currentNode = head;
                Node previousNode = null;

                while (indexToRemove < index) {
                    if (currentNode == null) {
                        JOptionPane.showMessageDialog(null, "Item não encontrado.");
                        break;
                    }

                    previousNode = currentNode;
                    currentNode = currentNode.getNextNode();
                    index++;
                }

                if (currentNode != null)
                    previousNode.setNextNode(currentNode.getNextNode());
            }
        } else {
            JOptionPane.showMessageDialog(null, "A lista está vazia.");
        }
    }

    public Contact find(int indexToFind) {
        if (head != null) {
            int index = 0;
            Node currentNode = head;

            while (indexToFind < index) {
                if (currentNode == null) {
                    JOptionPane.showMessageDialog(null, "Item não encontrado.");
                    return null;
                }

                currentNode = currentNode.getNextNode();
                index++;
            }

            return currentNode.getContact();

        } else {
            JOptionPane.showMessageDialog(null, "A lista está vazia.");
            return null;
        }
    }

    public void update(int indexToUpdate, Contact newContact) {
        if (head != null) {
            int index = 0;
            Node currentNode = head;

            while (indexToUpdate < index) {
                if (currentNode == null) {
                    JOptionPane.showMessageDialog(null, "Item não encontrado.");
                    break;
                }

                currentNode = currentNode.getNextNode();
                index++;
            }

            if (currentNode != null)
                currentNode.setContact(newContact);

        } else {
            JOptionPane.showMessageDialog(null, "A lista está vazia.");
        }
    }

    public void showAll() {
        if (head != null) {
            StringBuilder sb = new StringBuilder();
            Node currentNode = head;

            do {
                Contact contact = currentNode.getContact();
                sb.append(String.format("Nome: %s --- Número: %s \n", contact.getName(), contact.getNumber()));
                currentNode = currentNode.getNextNode();
            } while (currentNode.getNextNode() != null);

            JOptionPane.showMessageDialog(null, sb.toString());

        } else {
            JOptionPane.showMessageDialog(null, "A lista está vazia.");
        }
    }

    public void sort() {
        if (head != null && head.getNextNode() != null) {
            boolean wasChanged;

            do {
                Node current = head;
                Node previous = null;
                Node next = head.getNextNode();
                wasChanged = false;

                while (next != null) {
                    if (current.getContact().getName().compareTo(next.getContact().getName()) > 0) {
                        wasChanged = true;

                        if (previous != null) {
                            Node sig = next.getNextNode();

                            previous.setNextNode(next);
                            next.setNextNode(current);
                            current.setNextNode(sig);
                        } else {
                            Node sig = next.getNextNode();

                            head = next;
                            next.setNextNode(current);
                            current.setNextNode(sig);
                        }

                        previous = next;
                        next = current.getNextNode();
                    } else {
                        previous = current;
                        current = next;
                        next = next.getNextNode();
                    }
                }
            } while (wasChanged);
        }
    }
}