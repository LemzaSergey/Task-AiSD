/*30.Отсортировать студентов так, чтобы сначала сортировка шла по курсу,
затем по группе и только потом по фамилии (для этого необходимо соответствующим образом
реализовать интерфейс Comparable<Student> для класса Student).
*/

package com.company;

import ru.vsu.cs.util.SwingUtils;

import javax.swing.*;
import java.util.Locale;

public class Main {


    public static void main(String[] args) throws Exception {
        Locale.setDefault(Locale.ROOT);

        if (args.length > 0) {
            switch (args[0]) {
                case "-window":
                    JFrame MainFrame = null;
                    SwingUtils.setDefaultFont("Arial", 18);
                    MainFrame = new MainFrame();
                    MainFrame.setSize(1100, 600);
                    MainFrame.setVisible(true);
                    break;

                default:
                    System.exit(-13);
            }
        } else {
            System.exit(-15);
        }

    }
}