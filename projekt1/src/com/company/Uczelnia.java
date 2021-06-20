package com.company;
import java.util.Arrays;

public class Uczelnia{

    private final int dlugoscSemestru = 150;
    private int zdalo = 0;
    private int nieZdalo = 0;
    private final int ileKolokwiow = 5;
    int[] terminyKolokwiow = new int[ileKolokwiow];
    int[] terminyPoprawek = new int[ileKolokwiow];

    public int ileKolokwiow(){
        return ileKolokwiow;
    }

    /**
     * Losuje terminy kolokwiow i poprawy
     * @return Termin kolokwium i poprawy
     */
    public void losowanieZdarzen(){
        for (int i = 0; i < ileKolokwiow; i++) {
            terminyKolokwiow[i] = (int) (Math.random() * 140 +2); //140 bo poprawka musi odbyc sie w czasie semestru,
                                                                    // +2 bo semestr zaczyna sie od 1

            //zapobieganie powtarzaniu sie kolokwiow
            for (int y = 0 ; y < i; y++) {
                if (terminyKolokwiow[y] == terminyKolokwiow[i]) {
                    terminyKolokwiow[i] = (int) (Math.random() * 140 + 2);
                }
            }
        }

        Arrays.sort(terminyKolokwiow);

        //stworzenie terminow poprawek
        int k = 0;
        for (int i : terminyKolokwiow){
            terminyPoprawek[k] = i+7;
            k++;
        }

    }

    /**
     * Losuje terminy zdarzen losowych
     * @param studenci Tablica przechowujaca wszystkich studentow
     * @param data Data
     * @return Daty poszczególnych zdarzen losowych.
     */
    public void losowanieZdarzenLosowych(Student[] studenci, int data) {
        for (int i = 0; i < studenci.length; i++){
            // mamy 7/13 szansy na to ze cos sie stanie, 6/13 na brak
            int liczba = (int) (Math.random() * 13);
            switch (liczba) {
                case 1:
                    PracaWGrupie praca = new PracaWGrupie();
                    praca.wspolpraca(studenci);

                    break;
                case 2:
                case 3:
                    Wejsciowka wejsciowka = new Wejsciowka(data);
                    wejsciowka.checkStaty(studenci[i]);

                    break;
                case 4:
                case 5:
                    PomocNaukowa pomocnaukowa = new PomocNaukowa();
                    pomocnaukowa.addWiedza(studenci[i]);

                    break;

                case 6:
                case 7:
                    SpotkanieTowarzyskie spotkanie = new SpotkanieTowarzyskie();
                    spotkanie.AddStres(studenci[i]);

                    break;
            }
        }
    }

    /**
     * Wyswietla statystyki studetow
     * @param studenci tablica przechowująca poszczegolnych studentow.
     * @return statystyki studentow
     */
    public void statystykistudentow(Student[] studenci){
        System.out.println("Statystyki studentow [wiedza/szczescie/UmWsp/Stres]");
        int i = 0;
        for (Student student : studenci){
            System.out.println("Student["+i+"]: ["+student.jakaWiedza()+"/"+student.jakieSzczescie()+"/"
                    +student.jakaUmWsp()+"/"+student.jakiStres()+"]");
            i++;
        }
    }

    /**
     * Zlicza zdane kolokwia i dodatki przez studentow i je wyswietla.
     * @param studenci tablica przechowujaca poszczegolnych studentow.
     * @return liczba studentow, ktorzy zaliczyli semestr.
     */
    public void koniecSem(Student[] studenci){

        for (int w = 0; w < studenci.length; w++){
            Student student = studenci[w];
            if ((ileKolokwiow == student.ileZalKol()) && ( (student.ileDod()) *0.5 < student.ileZalDod() ))
            {
                zdalo++;
            }
            else{
                nieZdalo++;
            }
            System.out.print("Student["+w+"]: \nZaliczone kolokwia: "+student.ileZalKol()
                +" Ilosc poprawek: " + student.ilePoprawek());
            System.out.println(" Ilosc zaliczonych wejsciowek i prac w grupie: "+student.ileZalDod()+"/"+
                    student.ileDod());
        }

        System.out.println("Liczba studentow, ktora zdala semestr: " + zdalo);
        System.out.println("Liczba studentow, ktora nie zdala semestr: " + nieZdalo);
    }

    /**
    * @return dlugosc semestru
     */
    public int jakaDlugoscSem(){
        return dlugoscSemestru;
    }

    /**
    * Wyszukuje terminy kolokwiów
    * @param x miejsce w tablicy
    * @return data kolokwium
     */
    public int szukajKolokwium(int x){
        return terminyKolokwiow[x];
    }

    /**
    * Wyszukuje terminy poprawki
* @param x miejsce w tablicy
* @return termin poprawy
     */
    public int szukajPoprawki(int x){
        return terminyPoprawek[x];
    }

    /**
     * Wyswietla terminy kolokwiow
     */
    public void terminyKolokwiowTest() {
        System.out.println("Rozmiar: " + terminyKolokwiow.length);
        for (int i : terminyKolokwiow) {
            System.out.print(" " + i);
        }
    }
}

/*       Zapobieganie powtarzaniu sie kolokwiow     for (int y = 0; y < i; y++){
                if (terminyKolokwiow[y] == terminyKolokwiow[i]) {
                    terminyKolokwiow[i] = (int) (Math.random() * 150);
                }
            }*/

      /*  //sprawdzenie jak dziala losowanie
        System.out.println("Rozmiar: " + terminyKolokwiow.length);
        for (int i : terminyKolokwiow){
            System.out.println(" " + i);
        }*/
