package com.maincore;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        List<Double> nominaly = new ArrayList<>();
        double suma = 0;
        double sumaCen = 0;
        Scanner sc = new Scanner(System.in);
        boolean tillStatus = true;
        boolean userPayStatus = true;
        double userCashSuma = 0;
        String wynik = "Wydano: ";



        nominaly.add(10.0);
        nominaly.add(20.0);
        nominaly.add(50.0);
        nominaly.add(10.0);
        nominaly.add(20.0);
        nominaly.add(0.10);
        nominaly.add(0.10);
        nominaly.add(0.50);
        nominaly.add(2.0);
        nominaly.add(2.0);
        nominaly.add(1.0);
        nominaly.add(0.001);

        for (Double nominal : nominaly) {
            suma += nominal;
        }
        System.out.println((suma));

        while (tillStatus) {
            System.out.println("Podaj Cene towaru: ");
            double userPick = Double.valueOf(sc.nextLine());
            if (userPick > 0) {
                sumaCen += userPick;
            } else if (userPick < 0) {
                System.out.println("Podano błędną cene");
            } else if (userPick == 0) {
                tillStatus = false;
            }
        }

        if(sumaCen > 0){
            System.out.println("Do zapłaty: " +sumaCen);
        }
        else System.out.println("Błędne dane");

        while (userPayStatus && sumaCen > 0){
            System.out.println("Podaj nominały, jakim chcesz zapłacić: ");
            double userCash = Double.valueOf(sc.nextLine());

            if(userCash > 0){
                userCashSuma += userCash;
            }
            else if (userCash < 0){
                System.out.println("Wporwadź poprawny nominał!");
            }
            else if(userCash == 0){
                userPayStatus = false;
            }
        }

        double restCashCount = userCashSuma - sumaCen;

        for(int i = 0; (i < nominaly.size()) && (restCashCount > 0.00); i++){
         if(restCashCount >= nominaly.get(i)){
             int temp = (int)Math.floor(restCashCount/nominaly.get(i));
             wynik += nominaly.get(i) + "PLN " +temp + "\n";
             restCashCount = (double) Math.round(100*(restCashCount-(temp*nominaly.get(i))))/100;
         }
        }
        System.out.println(wynik);
    }
}
