package com.company;
//Copyright <2021> <Milosz Wozniak, Stanislaw Kotowski>

/**
 * Program jest symulacja uczelni, na ktorej studenci zaliczaja kolokwia, maja mozlwiosc poprawienia ich,
 * a po drodze spotykaja ich zdarzenia losowe. Na koniec program podsumowuje wyniki studentow i wyswietla raport
 * ilu studentwo zaliczylo semestr.
 *
 *
 */

import java.util.Scanner;



public class Main {
    /**
     * Tworzy uczelnie, tworzy studenatow, wyznacza dlugosc semestru, symuluje przebieg semestru.
     * @param args argument- nieuzywany
     * @return losowi studenci,daty kolokwiow, daty zdarzen losowych
     */
    public static void main(String[] args) {

        Uczelnia uczelnia = new Uczelnia();
        uczelnia.losowanieZdarzen();
        int dlugoscSemestru = uczelnia.jakaDlugoscSem();
        int k = 0;
        int l = 0;
        int najblizszeKolokwium = uczelnia.szukajKolokwium(k);
        int najblizszaPoprawka = uczelnia.szukajPoprawki(k);
        k++;
        l++;
        int ilu;
        int iluLosowych;
        System.out.println("Witaj na uczelni! Mozesz stworzyc studentow recznie lub wygenerowac ich ilosc.");
        System.out.print("Minimalnie lacznie musi byc 4 studentow i musi to byc parzysta ilosc," +
                " aby praca w grupie mogla funkcjonowac poprawnie. \nIlu studentow chcesz dodac recznie?\n> ");

        Scanner scan = new Scanner(System.in);
        String iluString = scan.nextLine();
        ilu = Integer.parseInt(iluString);
        System.out.print("Ilu bedzie losowych studentow? \n> ");
        iluLosowych = Integer.parseInt(scan.nextLine());
        Student[] studenci = new Student[ilu+iluLosowych];

        for (int i = 0; i < ilu+iluLosowych; i++) {

            studenci[i] = new Student();
            if (i < ilu) {
                studenci[i].stworzStudenta(i);
            }
            else {
                studenci[i].stworzLosowegoStudenta(i);
            }
        }

        //test losowania kolokwiow
        //uczelnia.terminyKolokwiowTest();
        uczelnia.statystykistudentow(studenci);
        //symulacja semestru
        for (int data = 1; data <= dlugoscSemestru; data++) {


            if ((data > najblizszeKolokwium) && (k < uczelnia.ileKolokwiow())) {
                najblizszeKolokwium = uczelnia.szukajKolokwium(k);
                k++;
            }
            if (data == najblizszeKolokwium) {

                Kolokwium kolokwium = new Kolokwium(data);
                kolokwium.checkStaty(studenci);

            } else
                uczelnia.losowanieZdarzenLosowych(studenci, data);

            if ((data > najblizszaPoprawka) && (l < uczelnia.ileKolokwiow())) {
                najblizszaPoprawka = uczelnia.szukajPoprawki(l);
                l++;
            }
            if (data == najblizszaPoprawka) {
                Poprawa poprawka = new Poprawa(data);
                poprawka.checkZaliczoneKolokwia(studenci);
            }
        }
        // Czas na sprawdzenie statystyk, np. ilu studentow zdalo
        uczelnia.statystykistudentow(studenci);
        uczelnia.koniecSem(studenci);
   }
}
