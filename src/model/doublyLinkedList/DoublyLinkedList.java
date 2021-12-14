package model.doublyLinkedList;

import model.general.Contact;
import model.linkedList.Node;

import javax.swing.*;

public class DoublyLinkedList {

    private DoublyNode head;

    public DoublyLinkedList() {}

    public void insert(Contact contact) {
        if (head != null) {
            DoublyNode currentNode = head;

            while (currentNode.getNextNode() != null)
                currentNode = currentNode.getNextNode();

            DoublyNode newNode = new DoublyNode(contact);

            currentNode.setNextNode(newNode);
            newNode.setPreviousNode(currentNode);

        } else {
            head = new DoublyNode(contact);
        }
    }

    public void remove(int indexToRemove) {
        if (head != null) {
            if (indexToRemove == 0) {
                head = head.getNextNode();
                head.setPreviousNode(null);
            } else {
                int index = 0;
                DoublyNode currentNode = head;

                while (indexToRemove < index) {
                    if (currentNode == null) {
                        JOptionPane.showMessageDialog(null, "Item não encontrado.");
                        break;
                    }

                    currentNode = currentNode.getNextNode();
                    index++;
                }

                if (currentNode != null) {
                    DoublyNode previousNode = currentNode.getPreviousNode();
                    DoublyNode nextNode = currentNode.getNextNode();

                    previousNode.setNextNode(nextNode);
                    nextNode.setPreviousNode(previousNode);
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "A lista está vazia.");
        }
    }

    public Contact find(int indexToFind) {
        if (head != null) {
            int index = 0;
            DoublyNode currentNode = head;

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
            DoublyNode currentNode = head;

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
            DoublyNode currentNode = head;

            do {
                sb.append(String.format("Nome: %s --- Número: %s \n"));
                currentNode = currentNode.getNextNode();
            } while (currentNode.getNextNode() != null);

            JOptionPane.showMessageDialog(null, sb.toString());

        } else {
            JOptionPane.showMessageDialog(null, "A lista está vazia.");
        }
    }
}