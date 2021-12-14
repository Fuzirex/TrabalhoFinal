package model.linkedList;

import model.general.Contact;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class LinkedList {

    private Node head;

    public LinkedList() {}

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

                while (index < indexToRemove) {
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
            Node currentNode = head;

            if (head.getContact().getName().toLowerCase().contains(name.toLowerCase()))
                contacts.add(head.getContact());

            while (currentNode.getNextNode() != null) {
                currentNode = currentNode.getNextNode();

                if (currentNode.getContact().getName().toLowerCase().contains(name.toLowerCase()))
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
            Node currentNode = head;

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
            Node currentNode = head;
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
            Node currentNode = head;

            do {
                System.out.println(String.format("Nome: %s --- Número: %s", currentNode.getContact().getName(), currentNode.getContact().getNumber()));
                currentNode = currentNode.getNextNode();
            } while(currentNode != null);
        }
    }

    // Sorts #####################################################################

    public void bubbleSort() {
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

    public void mergeSort() {
        mergeSort(head);
    }

    private Node mergeSort(Node h) {
        // Base case : if head is null
        if (h == null || h.getNextNode() == null) {
            return h;
        }

        // get the middle of the list
        Node middle = getMiddle(h);
        Node nextofmiddle = middle.getNextNode();

        // set the next of middle Node to null
        middle.setNextNode(null);

        // Apply mergeSort on left list
        Node left = mergeSort(h);

        // Apply mergeSort on right list
        Node right = mergeSort(nextofmiddle);

        // Merge the left and right lists
        Node sortedlist = sortedMerge(left, right);

        return sortedlist;
    }

    private Node sortedMerge(Node a, Node b) {
        Node result = null;
        /* Base cases */
        if (a == null)
            return b;
        if (b == null)
            return a;

        /* Pick either a or b, and recur */
        if (a.getContact().getName().compareTo(b.getContact().getName()) <= 0) {
            result = a;
            result.setNextNode(sortedMerge(a.getNextNode(), b));
        } else {
            result = b;
            result.setNextNode(sortedMerge(a, b.getNextNode()));
        }

        return result;
    }

    // Utility function to get the middle of the linked list
    private static Node getMiddle(Node head) {
        if (head == null)
            return head;

        Node slow = head, fast = head;

        while (fast.getNextNode() != null && fast.getNextNode().getNextNode() != null) {
            slow = slow.getNextNode();
            fast = fast.getNextNode().getNextNode();
        }

        return slow;
    }
}