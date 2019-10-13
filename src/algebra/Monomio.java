/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algebra;

import java.util.regex.Pattern;

/**
 *
 * @author alexi
 */
public class Monomio {
    private Racional coeficiente;
    private int grado;

    Monomio(String cad){
        Pattern pat = Pattern.compile("[(][0-9]*/[1-9][0-9]*[)][a-z]^[1-12]");
        String numero;
        for(char c: cad.toCharArray()){
            
        }
    }
    
    Monomio(Racional r, int grad){
        coeficiente = r;
        grado = grad;
    }
    
    
    Monomio sumarMonomios(Monomio mono){
        return new Monomio(coeficiente.sumar(mono.coeficiente), grado);
    }
    
    Monomio restarMonomios(Monomio mono){
        return new Monomio(coeficiente.restar(mono.coeficiente), grado);
    }
    
    Monomio multiplicarMonomios(Monomio mono){
        return new Monomio(coeficiente.multiplicar(mono.coeficiente), grado+mono.grado);
    }
    
    Monomio multiplicarMonomios(int a){
        return new Monomio(coeficiente.multiplicar(a), grado+1);
    }
    
    Monomio dividirMonomio(Monomio mono){
        return new Monomio(coeficiente.dividir(mono.coeficiente), grado-mono.grado);
    }
    
    Monomio dividirMonomio(int a){
        return new Monomio(coeficiente.dividir(a), grado-1);
    }
    
    boolean compararMonomio(Monomio mono){
        return coeficiente.comparar(mono.coeficiente);
    }
    
    public Racional getCoeficiente(){
        return coeficiente;
    }
 
    @Override
    public String toString(){
        coeficiente.reducir();
        return coeficiente +"x^" +grado;
    }
}
