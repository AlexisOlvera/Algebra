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
    private ArrayList<Monomio> terminos;
    private ArrayList<Double> terminosD;
    private final Racional racional0 = new Racional(0, 1);
    
    
    public Polinomio(int grado){
        this.grado = grado;
    }
    
    public Polinomio(int grado, ArrayList<Monomio> terminos){
        this.grado = grado;
        this.terminos = terminos;
    }
    
    public Polinomio(ArrayList<Monomio> terminos){
        this.terminos = terminos;
    }
    
    public static Polinomio createPolinomioRandom(int gradoMax){
        Random rand = new Random();
        rand.ints();
        int grade;
        if(gradoMax>2)
            grade = rand.nextInt(gradoMax-2)+2;
        else
            grade = rand.nextBoolean()?1:2;
        ArrayList<Monomio> coef = new ArrayList<>();
        int den, num;
        for(int i=0; i<=grade; i++){
            num=rand.nextBoolean()?rand.nextInt(8)+1:-(rand.nextInt(8)+1);
            den=rand.nextInt(8)+1;
            coef.add(new Monomio(new Racional(num, den), i));
        }
        return new Polinomio(grade, coef);
    }

    public int getGrado() {
        return grado;
    }

    public void setGrado(int grado) {
        this.grado = grado;
    }

    public ArrayList<Monomio> getterminos() {
        return terminos;
    }

    public void setterminos(ArrayList<Monomio> terminos) {
        this.terminos = terminos;
    }
    
    public Polinomio sumar(Polinomio p2){
        ArrayList<Monomio> coe=new ArrayList<>();
        int grad=grado;
        for(Monomio p:terminos)
            coe.add(p);
        int diferencia = p2.grado - grado;
        if(diferencia <= 0)
            for(int i = 0; i<=p2.grado; i++)
                coe.set(i, coe.get(i).sumarMonomios(p2.terminos.get(i)));
        else{
            for(int i = 0; i<=grado; i++)
                coe.set(i, coe.get(i).sumarMonomios(p2.terminos.get(i)));
            for(int i = grado+1; i<=p2.grado; i++)
                coe.add(p2.terminos.get(i));
            grad = p2.grado;
        }
        return new Polinomio(grad, coe);
    }
    
    public Polinomio restar(Polinomio p2){
        ArrayList<Monomio> coe=new ArrayList<>();
        int grad=grado;
        for(Monomio p:terminos)
            coe.add(p);
        int diferencia = p2.grado - grado;
        if(diferencia <= 0)
            for(int i = 0; i<=p2.grado; i++)
                coe.set(i, terminos.get(i).restarMonomios(p2.terminos.get(i)));
        else{
            for(int i = 0; i<=grado; i++)
                coe.set(i, terminos.get(i).restarMonomios(p2.terminos.get(i)));
            for(int i = grado+1; i<=p2.grado; i++){
                Monomio r=new Monomio(racional0,i);
                coe.add(r.restarMonomios(p2.terminos.get(i)));
            }
            grad = p2.grado;
        }
        return new Polinomio(grad, coe);
    }
    
    public Polinomio multiplicar(Polinomio p2){
        int gradoMax = grado + p2.grado;
        ArrayList<Monomio> coef = new ArrayList<>();
        for(int  i=0; i<=gradoMax; i++){
            Monomio r = new Monomio(racional0,i);
            coef.add(r);
        }
        for(int i = 0; i<=grado; i++)
            for(int j = 0; j<=p2.grado; j++)
                coef.set(i+j, coef.get(i+j).sumarMonomios(terminos.get(i).multiplicarMonomios(p2.terminos.get(j))));
        return new Polinomio(gradoMax, coef);
    }
    
    public Polinomio Division(Polinomio p2){
        
        return null;
    } 
    
    public boolean comparar(Polinomio p2){
        if(grado!=p2.grado)
            return false;
        for(int i =0; i<=grado; i++)
            if(!terminos.get(i).compararMonomio(p2.terminos.get(i)))
                return false;
        return true;
    }
    
    @Override
    public String toString(){
        String ret="";
        for(int i=grado; i>=0; i--){
            if(terminos.get(i).getCoeficiente().aDecimales()!=0.0){
                if(i!=0){
                    ret+=setPrecision(terminos.get(i).getCoeficiente().aDecimales(),3)+"x^"+i;
                    ret+=" + ";
                } else
                    ret += setPrecision(terminos.get(i).getCoeficiente().aDecimales(), 3)+ "";
                
            }
        }
        return ret;
    }
    
    public String toStringBonito(){
        String ret="";
        Monomio r0 = new Monomio(racional0,1);
        for(int i=grado; i>=0; i--){
            if(!terminos.get(i).compararMonomio(r0)){
                if(i!=0){
                    ret+=terminos.get(i);
                    ret+=" + ";
                } else
                    ret += terminos.get(i) + "";
                
            }
        }
        return ret;
    }
    
    public ArrayList<Double> toArrayDouble(){
        ArrayList<Double> ret = new ArrayList<>();
        for(Monomio r: terminos)
            ret.add(r.getCoeficiente().aDecimales());
        return ret;
    }
    
    public boolean compararD(Polinomio p2){
        if(grado!=p2.grado)
            return false;
        for(int i =0; i<=grado; i++)
            if(!terminosD.get(i).equals(p2.terminosD.get(i)))
                return false;
        return true;
    }
    
    public String toStringD(){
        String ret="";
        Double r0 = 0.0;
        for(int i=grado; i>=0; i--){
            if(!terminosD.get(i).equals(r0)){
                if(i!=0){
                    ret+=setPrecision(terminosD.get(i), 3)+"x^"+i;
                    ret+=" + ";
                } else
                    ret += terminosD.get(i) + "";   
            }
        }
        return ret;
    }
    
    public boolean compararDoubles(Polinomio p){
        if(p.grado != grado)
            return false;
        terminosD = this.toArrayDouble();
        for(int i =0; i<=grado; i++)
            if(p.terminosD.get(i)>terminosD.get(i)+0.3 ||p.terminosD.get(i)<terminosD.get(i)-0.3)
                return false;
        return true;
    }
    
    
    double[] DivisionSint(double coef[], int grado){
        int indice = 0;
        double resul = 0, sumando = 0, coef1[] = new double[coef.length];
        ArrayList <Integer> divisores = new ArrayList<>();
        
        for(int i = 1; i <= Math.abs(coef[grado]); i++){
            if(Math.abs(coef[grado])%i == 0){
                divisores.add(i);
                divisores.add(-1);
            }
        }
        for(int i = 0; i<divisores.size(); i++){
            for(int g = 0; g<coef.length;g++){
                if(g == 0){
                    sumando = divisores.get(i).doubleValue()*coef[g];
                    coef1[g] = coef[g];
                }else{
                    resul = coef[g] + sumando;
                    coef1[g] = resul;
                    sumando = resul*divisores.get(i).doubleValue();
                }  
            }
            if(resul == 0){
                indice = i;
                break;
            }
        }
        coef1[coef.length-1] = divisores.get(indice);
        
        return coef1;
    }
    
    public Polinomio derivada(){
        ArrayList<Monomio> aux = new ArrayList<>();
        for(int  i=0; i<grado; i++){
            Monomio r = new Monomio(terminos.get(i+1).getCoeficiente().multiplicar(i+1),i);
            aux.add(r);
        }
        return new Polinomio(grado-1, aux);
    }
    
    public Polinomio integral(){
        ArrayList<Monomio> aux = new ArrayList<>();
        aux.add(new Monomio(racional0, 1));
        for(int  i=0; i<=grado; i++){
            Monomio r = new Monomio(terminos.get(i).getCoeficiente().dividir(i+1),i+1);
            aux.add(r);
        }
        return new Polinomio(grado+1, aux);
    }
    
    private static String setPrecision(double amt, int precision){
        return String.format("%." + precision + "f", amt);
    }
    
    public ArrayList<Complejo> calcularRaices(){
        ArrayList<Complejo> ret = new ArrayList<>();
        ArrayList<Double> dobles = toArrayDouble();
        switch(grado){
            case 1:
                ret.add(new Complejo((float) (dobles.get(0)/dobles.get(1)), 0.0f));
                ret.add(new Complejo(0.0f, 0.0f));
                break;
            case 2:
                double real = -dobles.get(1)/(2*dobles.get(2));
                double imaginario = Math.sqrt(Math.abs(Math.pow(dobles.get(1), 2)-4*dobles.get(2)*dobles.get(0)))/(2*dobles.get(2));
                ret.add(new Complejo(real, imaginario));
                ret.add(new Complejo(real, -imaginario));
                break;
            default:
                ret.add(new Complejo(0.0f, 0.0f));
                ret.add(new Complejo(0.0f, 0.0f));
                break;
        }
        return ret;
    }

        
}
