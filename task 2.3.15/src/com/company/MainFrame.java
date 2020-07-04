package com.company;

import ru.vsu.cs.util.ArrayUtils;
import ru.vsu.cs.util.JTableUtils;
import ru.vsu.cs.util.SwingUtils;


import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.company.QueueOwn;


public class MainFrame extends JFrame {
    private InputArray inputArray = new InputArray("window");
    private WorkWithFile workWithFile = new WorkWithFile();

    private JPanel Panel;
    private JPanel mainPanel;
    private JButton runButtonJava;
    private JButton runButtonOwn;
    private JButton saveOutputButton;
    private JButton saveInputButton;
    private JButton loadButton;
    private JButton randomButton;
    private JTable inputTable;
    private JTable outputTable;

    public MainFrame() {
        this.setTitle("SearchPrimeNumber");
        this.setContentPane(mainPanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);

        JTableUtils.initJTableForArray(inputTable, 40, false, false, false, true);
        JTableUtils.initJTableForArray(outputTable, 40, false, false, false, false);

        inputTable.setRowHeight(25);
        outputTable.setRowHeight(25);

        JTableUtils.writeArrayToJTable(inputTable, new int[][]{
                {4, -25, 7, -30, 80, 75, 3, -8, 15, 0, 57, -8}

        });
        loadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                JFileChooser fileOpen = new JFileChooser();
                fileOpen.setAcceptAllFileFilterUsed(false);
                FileNameExtensionFilter filter = new FileNameExtensionFilter("File(.txt)", "txt");
                fileOpen.addChoosableFileFilter(filter);
                int ret = fileOpen.showDialog(null, "Открыть файл");

                try {
                    if (ret == JFileChooser.APPROVE_OPTION) {
                        File file = fileOpen.getSelectedFile();
                        String nameFile = file.getPath();

                        List<List<String>> workingListString = inputArray.toTwoDimensionalListString(workWithFile.fileToString(nameFile));
                        List<List<Integer>> workingListInteger = new ArrayList<>(converterStringToInteger(workingListString));
                        int[] workingListIntegerArr = separationPartArray(workingListInteger, 0);

                        JTableUtils.writeArrayToJTable(inputTable, workingListIntegerArr);

                    }
                } catch (FileNotFoundException ex) {
                    ex.printStackTrace();
                /*} catch (Exception e) {
                    SwingUtils.showErrorMessageBox(e);*/
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Ошибка! Проверьте правильность введённых данных", "Output", JOptionPane.PLAIN_MESSAGE);
                }
            }

        });
        randomButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    int[] arr = ArrayUtils.createRandomIntArray(inputTable.getColumnCount(), -1000, 1000);
                    JTableUtils.writeArrayToJTable(inputTable, arr);

                } catch (Exception e) {
                    SwingUtils.showErrorMessageBox(e);
                }
            }
        });
        saveInputButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                JFileChooser fileChooserSave = new JFileChooser();
                if (fileChooserSave.showSaveDialog(Panel) == JFileChooser.APPROVE_OPTION) {
                    try {
                        int[] arr = JTableUtils.readIntArrayFromJTable(inputTable);
                        String file = fileChooserSave.getSelectedFile().getPath();
                        if (!file.toLowerCase().endsWith(".txt")) {
                            file += ".txt";
                        }

                        workWithFile.saveArrayToFile(arr, file);
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "Ошибка! Проверьте правильность введённых данных", "Output", JOptionPane.PLAIN_MESSAGE);
                    }
                }
            }
        });
        saveOutputButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                JFileChooser fileChooserSave = new JFileChooser();
                if (fileChooserSave.showSaveDialog(Panel) == JFileChooser.APPROVE_OPTION) {
                    try {
                        int[] arr = JTableUtils.readIntArrayFromJTable(outputTable);
                        String file = fileChooserSave.getSelectedFile().getPath();
                        if (!file.toLowerCase().endsWith(".txt")) {
                            file += ".txt";
                        }
                        workWithFile.saveArrayToFile(arr, file);
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "Ошибка! Проверьте правильность введённых данных", "Output", JOptionPane.PLAIN_MESSAGE);
                    }
                }
            }
        });
        runButtonOwn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    int[] workingArr = JTableUtils.readIntArrayFromJTable(inputTable);

                    QueueOwn<Integer> queueOwn = converterIntArrToQueueOwn(workingArr);
                    queueOwn = LogicWorkOwn.sortingWithConservationOrder(queueOwn);

                    JTableUtils.writeArrayToJTable(outputTable, converterQueueOwnToIntArr(queueOwn));
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Ошибка! Проверьте правильность введённых данных", "Output", JOptionPane.PLAIN_MESSAGE);
                }
                /*} catch (Exception e) {
                    SwingUtils.showErrorMessageBox(e);*/
            }
        });
        runButtonJava.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    int[] workingArr = JTableUtils.readIntArrayFromJTable(inputTable);

                    Queue<Integer> queue = converterIntArrToQueueJava(workingArr);
                    queue = LogicWorkJava.sortingWithConservationOrder(queue);

                    JTableUtils.writeArrayToJTable(outputTable, converterQueueJavaToIntArr(queue));
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Ошибка! Проверьте правильность введённых данных", "Output", JOptionPane.PLAIN_MESSAGE);
                }
                /*} catch (Exception e) {
                    SwingUtils.showErrorMessageBox(e);*/
            }
        });

    }

    public List<List<Integer>> converterStringToInteger(List<List<String>> list) {
        List<Integer> lineInteger = new ArrayList<>();
        List<List<Integer>> newList = new ArrayList<>();
        for (List<String> strings : list) {
            for (String string : strings) {
                lineInteger.add(inputArray.checkInt(string));
            }
            newList.add(lineInteger);
            lineInteger = new ArrayList<>();
        }
        return newList;
    }

    public int[] separationPartArray(List<List<Integer>> IntegerArr, int num) {

        if (Errors.workingListIntegerRedundant(IntegerArr)) {
            return new int[]{};
        }

        int[] listIntegerArr = new int[IntegerArr.get(num).size()];
        for (int i = 0; i < IntegerArr.get(num).size(); i++) {
            listIntegerArr[i] = IntegerArr.get(num).get(i);
        }
        return listIntegerArr;
    }

    public int[] converterQueueOwnToIntArr(QueueOwn<Integer> queue) throws Exception {
        int[] ints = new int[queue.getCount()];
        for (int i = 0; queue.getCount() > 0; i++) {
            ints[i] = queue.get();
        }

        return ints;
    }

    public int[] converterQueueJavaToIntArr(Queue<Integer> queue) throws Exception {

        List<Integer> lists = new ArrayList<>();

        while (queue.peek() != null) {
            lists.add(queue.poll());
        }
        int[] ints = new int[lists.size()];
        for (int i = 0; i < lists.size(); i++) {
            ints[i] = lists.get(i);
        }

        return ints;
    }

    public QueueOwn<Integer> converterIntArrToQueueOwn(int[] ints) {
        QueueOwn<Integer> queue = new QueueOwn<Integer>();
        for (int i = 0; i < ints.length; i++) {
            queue.add(ints[i]);
        }
        return queue;
    }

    public Queue<Integer> converterIntArrToQueueJava(int[] ints) {
        Queue<Integer> queue = new LinkedList<Integer>();
        for (int i = 0; i < ints.length; i++) {
            queue.add(ints[i]);
        }
        return queue;
    }

}

