package com.company;

public class PomocNaukowa extends ZdarzeniaLosowe {

    /**
* Zwiększa wartość wiedzy studenta.
* @param student obiekt przechowujacy dane studenta.
 */
    public void addWiedza(Student student){
        super.addWiedza((int) (Math.random() * 10 + 5), student);

    }
}
