package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.Scanner;

public class MainFrame extends JFrame {
    private JPanel panelMain;
    private JButton jButtonEnterArray;
    private JButton jButtonFromFile;
    private JButton jButtonToFile;
    private JTextArea textArea;
    private JTextArea jTextAreaOutput;
    private JLabel inputSLabel;
    private JLabel inputArrayLabel;
    private JTextField textField;
    private JScrollPane jScrollPanelOutput;

    public MainFrame() {
        this.setTitle("Search for pairs of numbers");
        this.setContentPane(panelMain);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);

        jButtonEnterArray.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    String inputString = textArea.getText();
                    int s = Integer.parseInt(textField.getText());
                    jTextAreaOutput.setText(Logic.findPairString(inputString, s));

                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Ошибка! Неверные входные данные или пар нет. Проверьте правильность введённых данных", "Output", JOptionPane.PLAIN_MESSAGE);
                }
            }
        });

        jButtonFromFile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                JFileChooser jFileChooser = new JFileChooser();

                if (jFileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                    try {
                        FileReader fr = new FileReader(jFileChooser.getSelectedFile());
                        Scanner scn = new Scanner(fr);
                        StringBuilder str = new StringBuilder();
                        while (scn.hasNextLine()) {
                            str.append(scn.nextLine());
                        }
                        textArea.setText(String.valueOf(str));

                    /*} catch (Exception e) {
                        System.out.println("Error: " + e);
                    }*/
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "Ошибка! Проверьте правильность введённых данных", "Output", JOptionPane.PLAIN_MESSAGE);
                    }
                }
            }
        });

        jButtonToFile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String text = textArea.getText();
                String result = jTextAreaOutput.getText();

                JFileChooser jFileChooser = new JFileChooser();

                if (jFileChooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
                    try (FileWriter fw = new FileWriter(jFileChooser.getSelectedFile())) {
                        fw.write(text);
                        fw.write("\n");
                        fw.write(result);
                    /*} catch (Exception e) {
                        System.out.println("Save file error");
                    }*/
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "Ошибка! Проверьте правильность введённых данных", "Output", JOptionPane.PLAIN_MESSAGE);
                    }
                }

            }
        });
    }

}
