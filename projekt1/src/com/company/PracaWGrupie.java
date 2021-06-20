package com.company;

public class PracaWGrupie extends ZdarzeniaLosowe{
    private static int licznikWsp = 0;
    private Student[] studentGr = new Student[2];


    /**
     *Dobiera studentow w pary i testuje ich.
    * @param studenci obiekt przechowujacy dane studenta.
    */
    public void wspolpraca(Student[] studenci){
        //dobieranie studentow
        if (studenci.length % 2 == 0 && studenci.length > 2) {
            for (int k = 0; k < studentGr.length; k++) {
                for (int i = 0; i < studenci.length; i++) {
                    if (studenci[i].ileWsp() <= licznikWsp) {
                        studenci[i].dodajWsp();
                        studentGr[k] = studenci[i];
                        break;
                    }
                }
            }
            //glowne wydarzenie, testowanie studentow
            super.wspolpraca2studentow(studentGr);
            licznikWsp++;
        }
    }
}