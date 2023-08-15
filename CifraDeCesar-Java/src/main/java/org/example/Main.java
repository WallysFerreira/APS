package org.example;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    static String texto_original, texto_encriptado;
    static int rotacao = 0;
    static boolean opcao;
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

        // Criar janela para pedir valor de rotação
        JFrame dialogFrame = new JFrame("Rotacao");
        JDialog rotacaoDialog = new JDialog(dialogFrame);
        rotacaoDialog.setSize(200, 130);
        JTextField rotacaoInput = new JTextField();
        JButton confirmarBotao = new JButton("Confirmar");
        rotacaoDialog.add(rotacaoInput);
        rotacaoDialog.add(confirmarBotao);
        rotacaoDialog.setLayout(null);
        rotacaoInput.setBounds(50,0,100, 30);
        confirmarBotao.setBounds(50, 50, 100, 50);

        // Guardar string original e abrir dialog da rotação quando clicar em encriptar
        encriptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                texto_original = input.getText();
                opcao = false;
                rotacaoDialog.setVisible(true);
            }
        });

        // Fechar dialog da rotação e guardar valor da rotação quando clicar em confirmar
        confirmarBotao.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                rotacao = Integer.parseInt(rotacaoInput.getText());
                rotacaoDialog.setVisible(false);
                if (opcao) {
                    decriptar();
                } else {
                    encriptar();
                }
                output.setText(texto_encriptado);
            }
        });

        decriptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                texto_original = input.getText();
                opcao = true;
                rotacaoDialog.setVisible(true);
            }
        });

        areaInput.setBounds(20,50,450,100);
        areaBotoes.setBounds(100, 190, 300, 50);
        areaOutput.setBounds(20, 260, 450, 100);
        mainFrame.add(areaInput);
        mainFrame.add(areaBotoes);
        mainFrame.add(areaOutput);
        mainFrame.setLayout(null);
        mainFrame.setVisible(true);
    }

    public static void encriptar() {
        texto_encriptado = "";

        for (int i = 0; i < texto_original.length(); i++) {
            int char_original = texto_original.charAt(i);
            char char_encriptado = (char) (char_original + rotacao);

            texto_encriptado = texto_encriptado + char_encriptado;
        }
    }

    public static void decriptar() {
        // texto_original é a mensagem encriptada e texto_encriptado é a mensagem decriptada
        texto_encriptado = "";

        for (int i = 0; i < texto_original.length(); i++) {
            int char_original = texto_original.charAt(i);
            char char_decriptado = (char) (char_original - rotacao);

            texto_encriptado = texto_encriptado + char_decriptado;
        }
    }
}