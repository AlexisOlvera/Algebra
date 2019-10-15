/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algebra;

/**
 *
 * @author alexi
 */
public class Complejo {
    private double real, imaginario;
    public Complejo(double r, double i){
        real = r;
        imaginario = i;
    }
    
    public static Complejo sumar(Complejo com1, Complejo com2){
        return new Complejo(com1.real + com2.real, com1.imaginario + com2.imaginario);
    }
    
    public boolean equals(Complejo com){
        return (imaginario>com.imaginario-0.1 && imaginario<com.imaginario+0.1) &&(real>com.real-0.1 && real<com.real+0.1);
    }
    
    @Override
    public String toString(){
        return "x= " + real + " + " + imaginario + "i";
    }
}
