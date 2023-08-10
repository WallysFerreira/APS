package org.example;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        JFrame mainFrame = new JFrame("Cifra de Cesar");
        mainFrame.setSize(490, 464);

        // Area para usuario inserir input
        JPanel areaInput = new JPanel();
        JTextArea input = new JTextArea();
        input.setRows(8);
        input.setColumns(38);
        areaInput.add(input);

        // Area para selecionar opcoes
        JPanel areaBotoes = new JPanel();
        JButton encriptar = new JButton("Encriptar");
        JButton decriptar = new JButton("Decriptar");
        areaBotoes.add(encriptar);
        areaBotoes.add(decriptar);

        // Area para mostrar input
        JPanel areaOutput = new JPanel();
        JTextArea output = new JTextArea();
        output.setRows(8);
        output.setColumns(38);
        areaOutput.add(output);

        areaInput.setBounds(20,50,450,100);
        areaBotoes.setBounds(100, 190, 300, 50);
        areaOutput.setBounds(20, 260, 450, 100);
        mainFrame.add(areaInput);
        mainFrame.add(areaBotoes);
        mainFrame.add(areaOutput);
        mainFrame.setLayout(null);
        mainFrame.setVisible(true);
    }
}