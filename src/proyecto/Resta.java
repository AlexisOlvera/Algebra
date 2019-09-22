/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.*;
import javafx.stage.Stage;
import algebra.*;
import java.util.ArrayList;

/**
 * FXML Controller class
 *
 * @author Hot Cakes
 */
public class Resta implements Initializable {
    public Polinomio pol1,pol2;
    
    @FXML
    private Label labelRespuesta;

    @FXML
    private TextField grad0;

    @FXML
    private TextField grad1;

    @FXML
    private Button confirmar;

    @FXML
    private TextField grad2;

    @FXML
    private TextField grad3;

    @FXML
    public Button salir;

    @FXML
    private TextField grad4;

    @FXML
    private TextField grad5;

    @FXML
    private TextField grad6;

    @FXML
    private Label labelPol1;

    @FXML
    private Label labelPol2;
    
    public void confirmarClicked(){
        ArrayList<Double> coef = new ArrayList<>();
        if(grad0.getText().isEmpty())coef.add(0.0);else coef.add(Double.parseDouble(grad0.getText()));
        if(grad1.getText().isEmpty())coef.add(0.0);else coef.add(Double.parseDouble(grad1.getText()));
        if(grad2.getText().isEmpty())coef.add(0.0);else coef.add(Double.parseDouble(grad2.getText()));
        if(grad3.getText().isEmpty())coef.add(0.0);else coef.add(Double.parseDouble(grad3.getText()));
        if(grad4.getText().isEmpty())coef.add(0.0);else coef.add(Double.parseDouble(grad4.getText()));
        if(grad5.getText().isEmpty())coef.add(0.0);else coef.add(Double.parseDouble(grad5.getText()));
        if(grad6.getText().isEmpty())coef.add(0.0);else coef.add(Double.parseDouble(grad6.getText()));
        int grado;
        if (!grad6.getText().isEmpty())
            grado = 6;
        else if (!grad5.getText().isEmpty())
            grado = 5;
        else if (!grad4.getText().isEmpty())
            grado = 4;
        else if (!grad3.getText().isEmpty())
            grado = 3;
        else if (!grad2.getText().isEmpty())
            grado = 2;
        else if (!grad1.getText().isEmpty())
            grado = 1;
        else 
            grado = 0;
        
        
        System.out.println(coef + ":" +grado);
        char ass = '1';
        Polinomio polInput = new Polinomio(grado, coef, ass);
        
        Polinomio  resta = pol1.restar(pol2);
        
        System.out.println(polInput.toStringD());
        System.out.println(resta.toStringBonito());
        if(resta.compararDoubles(polInput))
                labelRespuesta.setText("Correcto");
        else
                 labelRespuesta.setText("La respuesta correcta es " + resta.toStringBonito());
        
        System.out.println(polInput.toStringD());
    }
    
    public void salirClicked(){
     System.out.println("salir");   
     Stage stage = (Stage) salir.getScene().getWindow();
     stage.close();

     }
        
    
    public void setPolis(Polinomio pol1, Polinomio pol2){
        this.pol1 = pol1;
        this.pol2 = pol2;
        labelPol1.setText(this.pol1.toStringBonito());
        labelPol2.setText(this.pol2.toStringBonito());
    }
        
        
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
