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
public class Racional {
    int a;
    
     public Racional(int a){
         this.a = a;
     }
    
    public Racional sumar(Racional r){
        a+=r.a;
        return new Racional(a);
    }
    
    public Racional restar(Racional r){
        a-=r.a;
        return this;
    }
    
    public Racional multiplicar(Racional r){
        a=a*r.a;
        return this;
    }
    
    public Racional dividir(Racional r){
        a/=r.a;
        return this;
    }
    
    public boolean comparar(Racional r){
        return a==r.a;
    }
    
    public Racional sumarSinAfectar(Racional r2){
        return new Racional(a + r2.a);
    }
    
    public Racional multiplicarSinAfectar(Racional r2){
        return new Racional(a * r2.a);
    }
    
    @Override
    public String toString(){
        return a+"";
    }
    
    
}
