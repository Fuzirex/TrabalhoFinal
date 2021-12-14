package controller;

import model.doublyLinkedList.DoublyLinkedList;
import model.general.Contact;
import model.linkedList.LinkedList;

import javax.swing.*;
import java.util.List;

public class DoublyLinkedListAgendaController {

    private DoublyLinkedList contacts;

    public DoublyLinkedListAgendaController() {
        this.contacts = new DoublyLinkedList();
        contacts.insert(new Contact("Matheus", "123"));
        contacts.insert(new Contact("Ana", "123"));
        contacts.insert(new Contact("Marcelo", "123"));

    }

    public void run() {
        while (true) {
            Integer menuItem = Integer.valueOf(JOptionPane.showInputDialog(getMenuItens()));

            switch (menuItem) {
                case 1:
                    String name = JOptionPane.showInputDialog("Nome do contato:");
                    String number = JOptionPane.showInputDialog("Telefone do contato:");
                    contacts.insert(new Contact(name, number));
                    break;

                case 2:
                    find();
                    break;

                case 3:
                    removeContact();
                    break;

                case 4:
                    contacts.showAll();
                    break;

                case 0:
                    System.exit(0);
                    break;
            }
        }
    }

    private String getMenuItens() {
        StringBuilder sb = new StringBuilder();

        sb.append("1 - Inserir contato\n");
        sb.append("2 - Localizar contato\n");
        sb.append("3 - Remover contato\n");
        sb.append("4 - Ver todos os contatos\n");
        sb.append("0 - Sair");


        return sb.toString();
    }

    private void removeContact() {
        contacts.remove(Integer.valueOf(JOptionPane.showInputDialog("Posição do contato")));
    }

    private void find() {
        String nameToFind = JOptionPane.showInputDialog("Nome do contato:");
        List<Contact> result = contacts.findByName(nameToFind);
        StringBuilder sb = new StringBuilder();

        if(result != null && !result.isEmpty()) {
            for (Contact c : result)
                sb.append(String.format("Nome: %s --- Número: %s \n", c.getName(), c.getNumber()));

            JOptionPane.showMessageDialog(null, sb.toString());
        } else {
            JOptionPane.showMessageDialog(null, "Item não encontrado.");
        }
    }
}
