package com.company;

public class Poprawa extends Kolokwium{

    public Poprawa (int data){
        super(data);

    }

    public void testPoprawki(){
            System.out.println("Poprawka: " + this.jakiStres() + " " + this.jakiPozTrud() );
        }


    /**
     * Sprawdza czy student ma przypisany termin poprawki, jezeli tak to ją przeprowadza.
     * @param studenci obiekt przechowujacy dane studenta.
     * @return wynik poprawki
     */
    public void checkZaliczoneKolokwia(Student[] studenci){
        for (Student student : studenci){
            if (student.statusPoprawki()){
                student.dodajPoprawke2();
                if (student.jakaWiedza() + student.jakieSzczescie() - student.jakiStres() >= this.jakiPozTrud()){
                    student.dodajZal();
                }
                student.usunPoprawke();
            }
        }
    }
}