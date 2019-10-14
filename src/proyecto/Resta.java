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
        ArrayList<Monomio> coef = new ArrayList<>();
        if(grad0.getText().isEmpty())coef.add(new Monomio(new Racional(0,1),0)); else coef.add(new Monomio(getRac(grad0),0));
        if(grad1.getText().isEmpty())coef.add(new Monomio(new Racional(0,1),1)); else coef.add(new Monomio(getRac(grad1),1));
        if(grad2.getText().isEmpty())coef.add(new Monomio(new Racional(0,1),2)); else coef.add(new Monomio(getRac(grad2),2));
        if(grad3.getText().isEmpty())coef.add(new Monomio(new Racional(0,1),3)); else coef.add(new Monomio(getRac(grad3),3));
        if(grad4.getText().isEmpty())coef.add(new Monomio(new Racional(0,1),4)); else coef.add(new Monomio(getRac(grad4),4));
        if(grad5.getText().isEmpty())coef.add(new Monomio(new Racional(0,1),5)); else coef.add(new Monomio(getRac(grad5),5));
        if(grad6.getText().isEmpty())coef.add(new Monomio(new Racional(0,1),6)); else coef.add(new Monomio(getRac(grad6),6));
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
        Polinomio polInput = new Polinomio(grado, coef);
        
        Polinomio  resta = pol1.restar(pol2);
        
        System.out.println("Input: ");
        System.out.println(polInput.toStringBonito());
        System.out.println("Correcto: ");
        System.out.println(resta.toStringBonito());
        if(resta.comparar(polInput))
                labelRespuesta.setText("Correcto");
        else
                 labelRespuesta.setText("La respuesta correcta es " + resta.toStringBonito());
        System.out.println("Correcto?"+resta.comparar(polInput));
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
        
    private Racional getRac(TextField txtField){
        String inputString = txtField.getText();
        String[] str = inputString.split("/", 2);
        return new Racional(Integer.parseInt(str[0]),Integer.parseInt(str[1]));
    }    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
