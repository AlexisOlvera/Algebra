/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto;

import algebra.Polinomio;
import java.net.URL;
import java.util.ArrayList;
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
 * @author alexis&friends
 */
public class IntegralController implements Initializable {
    public Polinomio pol1;
    
     @FXML
    public Button salir;
    @FXML
    public Label labelPol1;
    @FXML
    public Label labelPol2;
    
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
    private TextField grad4;

    @FXML
    private TextField grad5;

    @FXML
    private TextField grad6;
    
     @FXML
    private TextField grad7;

    public void confirmarClicked(){
        ArrayList<Double> coef = new ArrayList<>();
        if(grad0.getText().isEmpty())coef.add(0.0);else coef.add(Double.parseDouble(grad0.getText()));
        if(grad1.getText().isEmpty())coef.add(0.0);else coef.add(Double.parseDouble(grad1.getText()));
        if(grad2.getText().isEmpty())coef.add(0.0);else coef.add(Double.parseDouble(grad2.getText()));
        if(grad3.getText().isEmpty())coef.add(0.0);else coef.add(Double.parseDouble(grad3.getText()));
        if(grad4.getText().isEmpty())coef.add(0.0);else coef.add(Double.parseDouble(grad4.getText()));
        if(grad5.getText().isEmpty())coef.add(0.0);else coef.add(Double.parseDouble(grad5.getText()));
       if(grad6.getText().isEmpty())coef.add(0.0);else coef.add(Double.parseDouble(grad6.getText()));
       if(grad7.getText().isEmpty())coef.add(0.0);else coef.add(Double.parseDouble(grad7.getText()));
        int grado;
        if (!grad7.getText().isEmpty())
            grado = 7;
        else if (!grad6.getText().isEmpty())
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
        
        
       Polinomio der = pol1.integral();
        
        
        System.out.println(polInput.toStringD());
        System.out.println(pol1.toStringBonito());
        if(der.compararDoubles(polInput))
                labelRespuesta.setText("Correcto");
        else
                 labelRespuesta.setText("La respuesta correcta es " + der.toStringBonito());
        //if(sonIguales(polSuma, polInput))
        //  labelRespuesta.setText("Correcto");
        //else 
        //  labelRespuesta.setText("La respuesta correcta es " + polSuma);
        //Pero de mientras
        
    }
    
    public void salirClicked(){
         System.out.println("salir");   
         Stage stage = (Stage) salir.getScene().getWindow();
         stage.close();

     }
    
    
    //Este método se llama antes de inicializar la Scene
    public void setPoli(Polinomio pol1){
        this.pol1 = pol1;
        labelPol1.setText(this.pol1.toStringBonito());
        
//        System.out.println("Polinomio 1:  "+pol1.toString());
//        System.out.println("Polinomio 2:  "+pol2.toString());
//        
//        try {System.out.println("Polinomio 1b: "+pol1.toStringBonito()); }
//            catch (Exception e) {System.out.println("polinomio 1 bonito no generado");}
//        try {System.out.println("Polinomio 2b: "+pol2.toStringBonito()); }
//            catch (Exception e) {System.out.println("polinomio 2 bonito no generado");}
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
