/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algebra;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author alexi
 */
public class Polinomio {
    private int grado;
    private ArrayList<Racional> coeficientes;
    
    
    public Polinomio(int grado){
        this.grado = grado;
    }
    
    public Polinomio(int grado, ArrayList<Racional> coeficientes){
        this.grado = grado;
        this.coeficientes = coeficientes;
    }
    
    public static Polinomio createPolinomioRandom(){
        Random rand = new Random();
        rand.ints();
        int grade = rand.nextInt(6);
        ArrayList<Racional> coef = new ArrayList<>();
        for(int i=0; i<=grade; i++)
            coef.add(new Racional(rand.nextInt(9)));
        return new Polinomio(grade, coef);
    }

    public int getGrado() {
        return grado;
    }

    public void setGrado(int grado) {
        this.grado = grado;
    }

    public ArrayList<Racional> getCoeficientes() {
        return coeficientes;
    }

    public void setCoeficientes(ArrayList<Racional> coeficientes) {
        this.coeficientes = coeficientes;
    }
    
    public void sumar(Polinomio p2){
        int diferencia = p2.grado - grado;
        if(diferencia <= 0)
            for(int i = 0; i<=p2.grado; i++)
                coeficientes.set(i, coeficientes.get(i).sumar(p2.coeficientes.get(i)));
        else{
            for(int i = 0; i<=grado; i++)
                coeficientes.set(i, coeficientes.get(i).sumar(p2.coeficientes.get(i)));
            for(int i = 0; i<diferencia; i++)
                coeficientes.add(p2.coeficientes.get(i));
            grado = p2.grado;
        }
    }
    
    public void restar(Polinomio p2){
        int diferencia = p2.grado - grado;
        if(diferencia <= 0)
            for(int i = 0; i<=p2.grado; i++)
                coeficientes.set(i, coeficientes.get(i).restar(p2.coeficientes.get(i)));
        else{
            for(int i = 0; i<=grado; i++)
                coeficientes.set(i, coeficientes.get(i).restar(p2.coeficientes.get(i)));
            for(int i = 0; i<diferencia; i++){
                Racional r=new Racional(0);
                coeficientes.add(r.restar(p2.coeficientes.get(i)));
            }
            grado = p2.grado;
        }
    }
    
    public void multiplicar(Polinomio p2){
        int gradoMax = grado + p2.grado;
        ArrayList<Racional> coef = new ArrayList<>();
        for(int  i=0; i<=gradoMax; i++){
            Racional r = new Racional(0);
            coef.add(r);
        }
        for(int i = 0; i<=grado; i++)
            for(int j = 0; j<=p2.grado; j++)
                coef.set(i+j, coef.get(i+j).sumar(coeficientes.get(i).multiplicarSinAfectar(p2.coeficientes.get(j))));
        coeficientes = coef;
        grado = gradoMax;
    }
    
    public void Division(Polinomio p2){
        
    } 
    
    public boolean comparar(Polinomio p2){
        if(grado!=p2.grado)
            return false;
        for(int i =0; i<=grado; i++)
            if(!coeficientes.get(i).comparar(p2.coeficientes.get(i)))
                return false;
        return true;
    }
    
    @Override
    public String toString(){
        String ret="";
        Racional r0 = new Racional(0);
        for(int i=grado; i>=0; i--){
            if(!coeficientes.get(i).comparar(r0)){
                if(i!=0){
                    ret+=coeficientes.get(i)+"x^"+i;
                    ret+=" + ";
                } else
                    ret += coeficientes.get(i) + "";
                
            }
        }
        return ret;
    }
}
