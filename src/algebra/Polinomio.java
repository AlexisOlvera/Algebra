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
    private ArrayList<Double> coeficientesD;
    
    
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
        int den;
        for(int i=0; i<=grade; i++){
            den=rand.nextInt(8);
            coef.add(new Racional(den, 1));
        }
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
    
    public Polinomio sumar(Polinomio p2){
        ArrayList<Racional> coe=new ArrayList<>();
        int grad=grado;
        for(Racional p:coeficientes)
            coe.add(p);
        int diferencia = p2.grado - grado;
        if(diferencia <= 0)
            for(int i = 0; i<=p2.grado; i++)
                coe.set(i, coe.get(i).sumar(p2.coeficientes.get(i)));
        else{
            for(int i = 0; i<=grado; i++)
                coe.set(i, coe.get(i).sumar(p2.coeficientes.get(i)));
            for(int i = grado+1; i<=p2.grado; i++)
                coe.add(p2.coeficientes.get(i));
            grad = p2.grado;
        }
        return new Polinomio(grad, coe);
    }
    
    
    public Polinomio restar(Polinomio p2){
        ArrayList<Racional> coe=new ArrayList<>();
        int grad=grado;
        for(Racional p:coeficientes)
            coe.add(p);
        int diferencia = p2.grado - grado;
        if(diferencia <= 0)
            for(int i = 0; i<=p2.grado; i++)
                coe.set(i, coeficientes.get(i).restar(p2.coeficientes.get(i)));
        else{
            for(int i = 0; i<=grado; i++)
                coe.set(i, coeficientes.get(i).restar(p2.coeficientes.get(i)));
            for(int i = grado+1; i<=p2.grado; i++){
                Racional r=new Racional(0,1);
                coe.add(r.restar(p2.coeficientes.get(i)));
            }
            grad = p2.grado;
        }
        return new Polinomio(grad, coe);
    }
    
    public Polinomio multiplicar(Polinomio p2){
        int gradoMax = grado + p2.grado;
        ArrayList<Racional> coef = new ArrayList<>();
        for(int  i=0; i<=gradoMax; i++){
            Racional r = new Racional(0,1);
            coef.add(r);
        }
        for(int i = 0; i<=grado; i++)
            for(int j = 0; j<=p2.grado; j++)
                coef.set(i+j, coef.get(i+j).sumar(coeficientes.get(i).multiplicar(p2.coeficientes.get(j))));
        return new Polinomio(gradoMax, coef);
    }
    
    public Polinomio Division(Polinomio p2){
        
        return null;
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
        Racional r0 = new Racional(0,1);
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
    
    public String toStringBonito(){
        String ret="";
        for(int i=grado; i>=0; i--){
            if(coeficientes.get(i).aDecimales()!=0.0){
                if(i!=0){
                    ret+=coeficientes.get(i).aDecimales()+"x^"+i;
                    ret+=" + ";
                } else
                    ret += coeficientes.get(i).aDecimales()+ "";
                
            }
        }
        return ret;
    }
    
    public ArrayList<Double> toArrayDouble(){
        ArrayList<Double> ret = new ArrayList<>();
        for(Racional r: coeficientes)
            ret.add(r.aDecimales());
        return ret;
    }
    
    public ArrayList<Double> obtnerRaices(){
        ArrayList<Double> Reales = new ArrayList<>();
        ArrayList<Double> Imaginarias = new ArrayList<>();
        switch(grado){
            case 1:
                System.out.println(coeficientes.get(0).dividir(coeficientes.get(1)));
                Reales.add(coeficientes.get(0).dividir(coeficientes.get(1)).aDecimales());
                break;
            case 2:
                Racional discriminante = coeficientes.get(1).cuadrado().restar(coeficientes.get(0).multiplicar(coeficientes.get(2)).multiplicar(4));
                if(discriminante.esPositivo()){
                    Reales.add((-coeficientes.get(1).aDecimales()+Math.sqrt(discriminante.aDecimales()))/coeficientes.get(2).aDecimales()*2.0);
                    Reales.add((-coeficientes.get(1).aDecimales()-Math.sqrt(discriminante.aDecimales()))/coeficientes.get(2).aDecimales()*2.0);
                    Imaginarias.add(0.0);
                    Imaginarias.add(0.0);
                } else{
                    Imaginarias.add(discriminante.aDecimales()/(coeficientes.get(2).aDecimales()*2));
                    Imaginarias.add(-discriminante.aDecimales()/(coeficientes.get(2).aDecimales()*2));
                    Reales.add(-coeficientes.get(1).aDecimales()/(coeficientes.get(2).aDecimales()*2));
                    Reales.add(-coeficientes.get(1).aDecimales()/(coeficientes.get(2).aDecimales()*2));
                }
                break;
            default:
                   Reales = DivisionSint();
        }
        
        for(Double a:Reales)
            System.out.println(a.toString());
        for(Double a:Imaginarias)
            System.out.println(a.toString());
        return Reales;
    }       
        
    public ArrayList<Double>DivisionSint(){
        int indice, contador=grado;
        double resul, sumando;
        ArrayList<Double> Soluciones=new ArrayList<>();
        ArrayList<Double> arrayAux = toArrayDouble();
        while(contador>1){
                indice=0;
                resul=0.0;
                sumando=0.0;
                ArrayList <Integer> divisores = new ArrayList<>();
                 ArrayList<Double> coef1 = new ArrayList<>();
                 for(int i=0; i<contador; i++)
                     coef1.add(0.0);
                for(int i = 1; i <= Math.abs(arrayAux.get(contador)); i++){
                    if(Math.abs(arrayAux.get(contador))%i == 0){
                        divisores.add(i);
                        divisores.add(-1);
                    }
                }
                for(int i = 0; i<divisores.size(); i++){
                    for(int g = 0; g<contador;g++){
                        if(g == 0){
                            sumando = divisores.get(i)*arrayAux.get(g);
                            coef1.set(g, arrayAux.get(g));
                        }else{
                            resul = arrayAux.get(g)+ sumando;
                            coef1.set(g, resul);
                            sumando = resul*divisores.get(i);
                        }  
                    }
                    if(resul == 0){
                        indice = i;
                        break;
                    }
                }
                Soluciones.add(divisores.get(indice).doubleValue());
                arrayAux = (ArrayList<Double>) coef1.clone();
                contador--;
            }
        
        return Soluciones;
    }
        
    public Polinomio(int grado, ArrayList<Double> coeficientes, char ops){
        System.out.println("Construyendo Polinomio Double");
        this.grado = grado;
        this.coeficientesD = coeficientes;
    }
    
    public boolean compararD(Polinomio p2){
        if(grado!=p2.grado)
            return false;
        for(int i =0; i<=grado; i++)
            if(!coeficientesD.get(i).equals(p2.coeficientesD.get(i)))
                return false;
        return true;
    }
    
    public String toStringD(){
        String ret="";
        Double r0 = 0.0;
        for(int i=grado; i>=0; i--){
            if(!coeficientesD.get(i).equals(r0)){
                if(i!=0){
                    ret+=coeficientesD.get(i)+"x^"+i;
                    ret+=" + ";
                } else
                    ret += coeficientesD.get(i) + "";   
            }
        }
        return ret;
    }
    
    public boolean compararDoubles(Polinomio p){
        if(p.grado != grado)
            return false;
        coeficientesD = this.toArrayDouble();
        for(int i =0; i<=grado; i++)
            if(p.coeficientesD.get(i)>coeficientesD.get(i)+0.3 ||p.coeficientesD.get(i)<coeficientesD.get(i)-0.3)
                return false;
        return true;
    }
    
    String soluciones[];
    public String[] teorema(){
        soluciones = new String[grado];
        double[] coe = new double[grado+1];
        for (int i = 0; i <= grado; i++) {
           coe[i] = coeficientes.get(i).aDecimales();
        }
         return resuelveEc(coe, grado);
    }
    
    
    String[] resuelveEc(double coef[], int grado){
        double divSint[] = null;
        switch(grado){
            case 1:
                soluciones[0] = -(coef[1])/coef[0]+"";
                break;
            case 2:
                Double discriminante = Math.pow(coef[1], 2) - 4*coef[0]*coef[2];
                if(discriminante >= 0){
                    soluciones[0] = ((-coef[1])+Math.sqrt(discriminante))/(2*coef[0])+"";
                    soluciones[1] = ((-coef[1])-Math.sqrt(discriminante))/(2*coef[0])+"";
                }else{
                    soluciones[0] = ""+(-coef[1])/2*coef[0]+"+("+Math.sqrt(-discriminante)/2*coef[0]+")i";
                    soluciones[1] = ""+(-coef[1])/2*coef[0]+"-("+Math.sqrt(-discriminante)/2*coef[0]+")i";
                }
                break;
            default:
                double coef1[] = new double[grado];
                if(coef[grado] == 0){
                    soluciones[grado-1] = 0.0+"";
                    for(int i = 0; i<grado; i++){
                        coef1[i] = coef[i];
                    }
                }else{
                    divSint = DivisionSint(coef, grado);
                    soluciones[grado-1] = divSint[coef.length-1]+"";
                    for(int i = 0; i<grado; i++){
                        coef1[i] = divSint[i];
                    }
                }
                resuelveEc(coef1, grado-1);
                break;  
        }
        return soluciones;
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
        ArrayList<Racional> aux = new ArrayList<>();
        for(int i=1; i<=grado; i++){
            aux.add(coeficientes.get(i).multiplicar(i));
        }
        return new Polinomio(grado-1, aux);
    }
    
    public Polinomio integral(){
        ArrayList<Racional> aux = new ArrayList<>();
        aux.add(new Racional(0, 1));
        for(int i=1; i<=grado; i++){
            aux.add(coeficientes.get(i).dividir(i));
        }
        return new Polinomio(grado, aux);
    }
    

        
}
