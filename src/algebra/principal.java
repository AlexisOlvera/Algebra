package algebra;
import java.util.ArrayList;
import java.util.Scanner;

public class principal {
    String soluciones[];
    
    void inicio(){
        while(true){
            int grado;
            Scanner teclita = new Scanner(System.in);

            System.out.println("Ingrese el grado de la ecuación a resolver :");
            grado = teclita.nextInt();
            soluciones = new String[grado];
            double coef[] = new double[grado+1];
            for(int i = 0; i <= grado; i++){
                if(i == grado){
                    System.out.println("Ingrese el término independiente");
                }else{
                    System.out.println("Ingrese el coeficiente del término con grado "+(grado-i)+".");
                }
                coef[i] = teclita.nextDouble();
            }
            soluciones = resuelveEc(coef, grado);
            for(int i = 0; i<grado; i++){
                System.out.println("Raiz "+(i+1)+" = "+soluciones[i]+".\n");
            }
        }
        
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
        ArrayList <setNum> divisores = new ArrayList<>();
        
        for(int i = 1; i <= Math.abs(coef[grado]); i++){
            if(Math.abs(coef[grado])%i == 0){
                setNum set = new setNum();
                set.setNumero(i);
                divisores.add(set);
                
                setNum set1 =  new setNum();
                set1.setNumero(-i);
                divisores.add(set1);
            }
        }
        for(int i = 0; i<divisores.size(); i++){
            for(int g = 0; g<coef.length;g++){
                if(g == 0){
                    sumando = divisores.get(i).getNumero()*coef[g];
                    coef1[g] = coef[g];
                }else{
                    resul = coef[g] + sumando;
                    coef1[g] = resul;
                    sumando = resul*divisores.get(i).getNumero();
                }  
            }
            if(resul == 0){
                indice = i;
                break;
            }
        }
        coef1[coef.length-1] = divisores.get(indice).getNumero();
        
        return coef1;
    }
    
}