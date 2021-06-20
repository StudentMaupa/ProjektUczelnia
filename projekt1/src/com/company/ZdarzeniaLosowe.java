package com.company;

public abstract class ZdarzeniaLosowe{

    /** Dodaje stres studentowi.
     * @param x ilosc stresu.
     * @param student obiekt przechowujący dane studenta.
     * @return zwiększony stres.
     */
    public void addStres(int x, Student student){
        student.dodajStres(x);
    }

    /**
     *
    * @param x ilosc stres.
    * @param student obiekt przechowujacy dane studenta.
     *return zwiekszona wiedza.
     */
    public void addWiedza(int x, Student student){
        student.dodajWiedza(x);
    }

    /**
     * Testuje studentow.
     * @param s indeks studenta.
     * @return wynik testowania studentow.
     */
    public void wspolpraca2studentow(Student[] s){
        int trudnosc = s[0].jakaWiedza() + s[1].jakaWiedza() ;
        s[1].dodajDod();
        s[0].dodajDod();
        if (s[1].jakaWiedza()+s[0].jakaWiedza()-s[1].jakiStres()-s[0].jakiStres()+s[1].jakieSzczescie()
                +s[0].jakieSzczescie()
                +2*s[1].jakaUmWsp()+2*s[0].jakaUmWsp() > trudnosc){
            s[1].dodajZalDod();
            s[0].dodajZalDod();
        }
    }

}
