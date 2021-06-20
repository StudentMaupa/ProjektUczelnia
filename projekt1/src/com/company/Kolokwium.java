package com.company;

public class Kolokwium{

    private final int stres;
    private final int pozTrud;

    /**
     * Sprawdza wiedzę studenta zwiększa stres.
     */

    public Kolokwium(int data) {
        this.stres = (int) (Math.random() * 6+2);
        this.pozTrud = (int) (Math.random() * 70+20+data);
    }

    /**
     * Funkcja przeprowadzajaca kolokwium (dodaje tez stres i czy wyslac na poprawke)
     * @param studenci ineks studenta.
     * @return zwiekszenie stres,
     */


    public void checkStaty(Student[] studenci){
        for (Student student : studenci){
            student.dodajStres(stres);
            if (student.jakaWiedza() + student.jakieSzczescie() - student.jakiStres() >= pozTrud){
                student.dodajZal();
            }
            else{
                student.dodajPoprawke();
            }

        }
    }

    /**
     * Sprawdza wartosc stresu u studenta.
     * @return poziom sresu.
     */
    public int jakiStres(){
        return this.stres;
    }

    /**
     * Sprawdza poziom trudnosci kolokwium
     * @return poziom trudnosci kolokwium
     */
    public int jakiPozTrud(){
        return this.pozTrud;
    }
}
