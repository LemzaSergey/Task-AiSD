package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import com.company.Tariffs;

public class Main {

    public static void main(String[] args) {
        Locale.setDefault(Locale.ROOT);
        TariffsForDirections t1 = new TariffsForDirections(7, "ru", 5);
        TariffsForDirections t2 = new TariffsForDirections(1, "ua", 9);
        //Tariffs plan = new Tariffs(t1);
        //TariffsForDirections.printTariffsForDirections(t1);
        //Tariffs.printTariffs(plan);
        //List<TariffsForDirections> tariffsPlan = new ArrayList<>();
        //tariffsPlan.add(t1);
        List<TariffsForDirections> tariffsPlan = new ArrayList<>();
        tariffsPlan = Tariffs.addTariffs(t1, tariffsPlan);
        tariffsPlan = Tariffs.addTariffs(t2, tariffsPlan);
        tariffsPlan = Tariffs.removeTariffs(tariffsPlan,0);
        //tariffsPlan = Tariffs.removeTariffs(tariffsPlan,0);
        tariffsPlan = Tariffs.setTariffs(t2,tariffsPlan,0);
        Tariffs.printTariffs(tariffsPlan, 0);


        if (args.length > 0) {
            switch (args[0]) {
                case "-window":
                    new MainFrame();
                    break;

                default:
                    System.exit(-13);
            }
        }else
        {
            System.exit(-15);
        }
    }
}
