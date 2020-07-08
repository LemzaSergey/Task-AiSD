/*6.Для массива/списка целых чисел найти все пары чисел, которые в сумме дают S (S задается пользователем).
Алгоритм должен работать за время O(n*log(n)).
*/

package com.company;

import java.util.Locale;

public class Main {

    public static void main(String[] args) {
        Locale.setDefault(Locale.ROOT);

        if (args.length > 0) {
            switch (args[0]) {
                case "-window":
                    new MainFrame();
                    break;

                default:
                    System.exit(-13);
            }
        } else {
            System.exit(-15);
        }

    }
}