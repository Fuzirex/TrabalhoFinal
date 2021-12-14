package model.doublyLinkedList;

import model.general.Contact;
import model.linkedList.Node;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

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

                while (index < indexToRemove) {
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

            while (index < indexToFind) {
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

    public List<Contact> findByName(String name) {
        if (head != null) {
            List<Contact> contacts = new ArrayList<>();
            DoublyNode currentNode = head;

            if(head.getContact().getName().toLowerCase().contains(name.toLowerCase()))
                contacts.add(head.getContact());

            while (currentNode.getNextNode() != null) {
                currentNode = currentNode.getNextNode();

                if(currentNode.getContact().getName().toLowerCase().contains(name.toLowerCase()))
                    contacts.add(currentNode.getContact());
            }

            return contacts;

        } else {
            JOptionPane.showMessageDialog(null, "A lista está vazia.");
            return null;
        }
    }

    public void update(int indexToUpdate, Contact newContact) {
        if (head != null) {
            int index = 0;
            DoublyNode currentNode = head;

            while (index < indexToUpdate) {
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
            int index = 0;

            do {
                Contact contact = currentNode.getContact();
                sb.append(String.format("%s -> Nome: %s --- Número: %s \n", index, contact.getName(), contact.getNumber()));
                currentNode = currentNode.getNextNode();
                index++;
            } while (currentNode != null);

            JOptionPane.showMessageDialog(null, sb.toString());

        } else {
            JOptionPane.showMessageDialog(null, "A lista está vazia.");
        }
    }

    public void listAll() {
        if(head != null) {
            DoublyNode currentNode = head;

            do {
                System.out.println(String.format("Nome: %s --- Número: %s", currentNode.getContact().getName(), currentNode.getContact().getNumber()));
                currentNode = currentNode.getNextNode();
            } while(currentNode != null);
        }
    }
}