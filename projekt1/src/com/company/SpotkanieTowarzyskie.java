package com.company;

public class SpotkanieTowarzyskie extends ZdarzeniaLosowe{
    /**
*Zwieksza poziom stresu studenta.
* @param student  obiekt przechowujacy dane studenta.
     * @return poziom stesu studenta.
 */
    public void AddStres(Student student){
        super.addStres(-(int)(Math.random()*10+5), student);
    }
}

    
    