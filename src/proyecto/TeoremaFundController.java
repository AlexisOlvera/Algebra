/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto;

import algebra.Polinomio;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Hot Cakes
 */
public class TeoremaFundController implements Initializable {
    public Polinomio pol1,pol2;
    @FXML
    public Button salir1, confirmar;
     @FXML
    private Label labelRespuesta, labelPol1;

    @FXML
    private TextField x1, x2, x3, x4, x5, x6;
    
    public void confirmarClicked(){
        ArrayList<String> s = new ArrayList<>();
        if(!x1.getText().isEmpty()) s.add(x1.getText());
        if(!x2.getText().isEmpty()) s.add(x2.getText());
        if(!x3.getText().isEmpty()) s.add(x3.getText());
        if(!x4.getText().isEmpty()) s.add(x4.getText());
        if(!x5.getText().isEmpty()) s.add(x5.getText());
        if(!x6.getText().isEmpty()) s.add(x6.getText());
        
        String[] res = pol1.teorema();
        int contador=0;
        for(String s1: res){
            for(String s2: s){
                if(s1.equals(s2)){
                    contador++;
                    s2 = "a";
                }
            }
        }
        if(contador==pol1.getGrado())
            labelRespuesta.setText("Correcto");
        else
                 labelRespuesta.setText("La respuesta correcta es: " +  Arrays.toString(res));
        
    }
    
    public void salirClicked(){
       
     System.out.println("salir");   
     Stage stage = (Stage) salir1.getScene().getWindow();
     stage.close();

     }
    
    public void setPolis(Polinomio pol1){
        this.pol1 = pol1;
        labelPol1.setText(this.pol1.toStringBonito());
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
