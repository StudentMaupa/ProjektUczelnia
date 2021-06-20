package com.company;

public class Wejsciowka extends Kolokwium{

    public Wejsciowka (int data){
        super(data);
    }

    /**
    * Sprawdza statystyki studenta oraz zmienia ilosc zaliczonych dodatkow.
    * @param student obiekt przechowujacy dane studenta.
     */
    public void checkStaty(Student student){
            student.dodajStres(this.jakiStres());
            student.dodajDod();
            if (student.jakaWiedza() + student.jakieSzczescie() - student.jakiStres() >= this.jakiPozTrud()){
                student.dodajZalDod();

            }



    }
}