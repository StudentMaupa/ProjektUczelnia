package com.company;

import java.util.Scanner;


public class Student{

    private int wiedza = 0;
    private int szczescie = 0;
    private int umWsp = 0 ;
    private int stres = 0 ;
    private int zalKol = 0;
    private int zalDod = 0;
    private int iloscDod = 0;
    private int iloscPoprawek = 0;
    private boolean czyPoprawka = false;
    private int licznikWspSt = 0;

    /**
     * Przechowuje wartosci zmiennych charakteryzujacych studenta.
     * @param i indeks studenta, miejsce w tablicy
     * @return Statystyki studenta
     */


    public void stworzStudenta(int i)
    {
        System.out.println("Tworzenie studenta o indeksie " + i);
        Scanner in= new Scanner(System.in);

        int zmienna = 1000;
        do{
            System.out.print("Podaj wartosc wiedzy (0-100): ");
            zmienna=in.nextInt();
            if (zmienna > 100 || zmienna < 0){
                System.out.println("Wartosc poza zakresem!");
            }
        }while(zmienna > 100 || zmienna < 0);
        this.wiedza = zmienna;

        do{
            System.out.print("Podaj wartosc szczescia (0-20): ");
            zmienna=in.nextInt();
            if (zmienna > 20 || zmienna < 0) {
                System.out.println("Wartosc poza zakresem!");
            }
        }while(zmienna>20 || zmienna<0);
        this.szczescie = zmienna;

        do{
            System.out.print("Podaj wartosc umiejetnosci wspolpracy (0-50): ");
            zmienna=in.nextInt();
            if (zmienna > 50 || zmienna < 0) {
                System.out.println("Wartosc poza zakresem!");
            }
        }while(zmienna> 50 || zmienna<0);
        this.umWsp = zmienna;

        do{
            System.out.print("Podaj wartosc stresu (0-20): ");
            zmienna=in.nextInt();
            if (zmienna > 20 || zmienna < 0) {
                System.out.println("Wartosc poza zakresem! ");
            }
        }while(zmienna>20);
        this.stres = zmienna;

    }

    /**
     * Tworzenie studentow o losowych danych
     * @param i indeks studenta
     * @return Studenci o losowych parametrach.
     */
    public void stworzLosowegoStudenta(int i){
        for(int k = 0; k <= i;k++){
            this.wiedza= (int) (Math.random() * 50 +40);
            this.szczescie= (int) (Math.random() * 8+3 );
            this.stres= (int) (Math.random() * 8+3 );
            this.umWsp= (int) (Math.random() * 50 +20);
        }
    }

    /**
     * @return wiedza studenta.
     */
    public int jakaWiedza(){
       return this.wiedza;
    }

    /**
    * @return szczescie studentow
     */
    public int jakieSzczescie(){
        return this.szczescie;
    }

    /**
    * @return umiejętnosc wspolpracy studenta
     */
    public int jakaUmWsp(){
        return this.umWsp;
    }

    /**
    * @return poziom stresu studenta
     */
    public int jakiStres(){
        return this.stres;
    }
    /**
     * @return ilosc odbytych prac grupowych
     */
    public int ileWsp(){
        return this.licznikWspSt;
    }
    /**
     * @return ilosc dodatkow, ktore wylosowaly sie studentowi (wejsciowki i prace w grupach)
     */
    public int ileDod(){
        return this.iloscDod;
    }
    /**
     * @return ilosc zaliczonych kolokwiow
     */
    public int ileZalKol(){
        return this.zalKol;
    }
    /**
     * @return ilosc zaliczonych dodatkow
     */
    public int ileZalDod(){
        return this.zalDod;
    }
    /**
     * @return ilosc odbytych poprawek
     */
    public int ilePoprawek(){
        return iloscPoprawek;
    }
    /**
     * Zwieksza poziom wiedzy studenta.
     * @return poziom wiedzy studenta
     */
    public void dodajWiedza(int wiedza){
        this.wiedza += wiedza;
    }
    /**
     * Zwieksza ilosc zaliczonych kolokwiow
     * @return zaliczone kolokwia
     */
    public void dodajZal(){
        this.zalKol++;
    }
    /**
     * Zwieksza ilosc zaliczonych dodatkow
     * @return zaliczone dodatki
     */
    public void dodajZalDod(){
        this.zalDod++;
    }
    /**
     * Zwiększ ilosc wykonanych dodatkw
     * @return ilosc dodatkow
     */
    public void dodajDod(){
        this.iloscDod++;
    }

    /**
     * Zwisksza parametr stres u studenta
     * @param s wylosowana wartosc stresu u studenta
     * @return zwiekszony poziom stresu u studenta
     */
    public void dodajStres(int s){
        this.stres += s;
        if(this.stres < 0){
            this.stres = 0;
        }
    }

/**
 * Dzieki temu dziala wspolpraca
 */
    public void dodajWsp(){
        this.licznikWspSt+=2;
    }
    /**
     * Dzieki temu dziala poprawka
     */
    public void dodajPoprawke2(){
        this.iloscPoprawek++;
    }
    /**
     * Dzieki temu dziala poprawka
     */
    public void dodajPoprawke(){
        this.czyPoprawka = true;
    }
    /**
     * Dzieki temu dziala poprawka
     */
    public void usunPoprawke(){
        this.czyPoprawka = false;
    }
    /**
     * Dzieki temu dziala poprawka
     */
    public boolean statusPoprawki(){
        return this.czyPoprawka;
    }


}
