/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import algebra.*;
import java.io.IOException;
/**
 *
 * @author Hot Cakes
 */
public class Test2Controller implements Initializable {
    private Button suma;
    private Button div;
    private Button mult;
    public Button salir;
    public Button newPoli;
    public Button btnDerivada;
    public Button btnIntegral;
    private Button resta;
    private BorderPane Bp;
    private Button teof;
    Polinomio pol1 = Polinomio.createPolinomioRandom();
    Polinomio pol2 = Polinomio.createPolinomioRandom();
    
    @FXML
    public void restaClicked(){
        try {
           FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Resta.fxml"));
           Parent root1 = (Parent) fxmlLoader.load();
           
           Resta windowResta = fxmlLoader.getController();
           windowResta.setPolis(pol1, pol2);
           
           Stage stage = new Stage();
           stage.initModality(Modality.APPLICATION_MODAL);
           stage.setTitle("Resta");
           stage.setScene(new Scene(root1));  
           stage.show();

       } 
       catch (Exception e) {
           System.out.println("nope");
       }
    }
    
    @FXML
    public void multClicked(){
        try {
           FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Multiplicacion.fxml"));
           Parent root1 = (Parent) fxmlLoader.load();
           
           Multiplicacion windowMult = fxmlLoader.getController();
           windowMult.setPolis(pol1, pol2);
           
           Stage stage = new Stage();
           stage.initModality(Modality.APPLICATION_MODAL);
           stage.setTitle("Multiplicacion");
           stage.setScene(new Scene(root1));  
           stage.show();

       } 
       catch (Exception e) {
           System.out.println("nope");
       }
    }
    
    @FXML
    public void divClicked(){
        try {
           FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Division.fxml"));
           Parent root1 = (Parent) fxmlLoader.load();
           
           Division windowDivision = fxmlLoader.getController();
           windowDivision.setPolis(pol1, pol2);
           
           Stage stage = new Stage();
           stage.initModality(Modality.APPLICATION_MODAL);
           stage.setTitle("Division");
           stage.setScene(new Scene(root1));  
           stage.show();

       } 
       catch (Exception e) {
           System.out.println("nope");
       }
    }
    
    public void salirClicked(){
        System.out.println("salir");   
        Stage stage = (Stage) salir.getScene().getWindow();
        stage.close();        
    }
    
    public void newPoliClicked(){
        System.out.println("Nuevos Polinomios generados...");
        pol1 = Polinomio.createPolinomioRandom();
        pol2 = Polinomio.createPolinomioRandom();
    }
    
    @FXML
    public void teofClicked(){
        try {
           FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("TeoremaFund.fxml"));
           Parent root1 = (Parent) fxmlLoader.load();
           
           TeoremaFundController windowResta = fxmlLoader.getController();
          windowResta.setPolis(pol1);
           
           Stage stage = new Stage();
           stage.initModality(Modality.APPLICATION_MODAL);
           stage.setTitle("Raices");
           stage.setScene(new Scene(root1));  
           stage.show();

       } 
       catch (IOException e) {
           System.out.println(e.getMessage());
       }
    }
    
   @FXML
   void sumaClicked(ActionEvent event){
       try {
           FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Suma.fxml"));
           Parent root1 = (Parent) fxmlLoader.load();
           
           Suma windowSuma = fxmlLoader.getController();
           windowSuma.setPolis(pol1, pol2);
           
           Stage stage = new Stage();
           stage.initModality(Modality.APPLICATION_MODAL);
           stage.setTitle("Suma");
           stage.setScene(new Scene(root1));  
           stage.show();

       } 
       catch (Exception e) {
           System.out.println("nope");
       }
   }
   
   @FXML
   void btnDerivadaClicked(){
       try {
           FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Derivada.fxml"));
           Parent root1 = (Parent) fxmlLoader.load();
           
           DerivadaController windowDerivada = fxmlLoader.getController();
           windowDerivada.setPoli(pol1);
           
           Stage stage = new Stage();
           stage.initModality(Modality.APPLICATION_MODAL);
           stage.setTitle("Derivada");
           stage.setScene(new Scene(root1));  
           stage.show();

       } 
       catch (Exception e) {
           System.out.println("nope");
       }
   }
   
   @FXML
   void btnIntegralClicked(){
       try {
           FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Integral.fxml"));
           Parent root1 = (Parent) fxmlLoader.load();
           
           IntegralController windowIntegral = fxmlLoader.getController();
           windowIntegral.setPoli(pol1);
           
           Stage stage = new Stage();
           stage.initModality(Modality.APPLICATION_MODAL);
           stage.setTitle("Derivada");
           stage.setScene(new Scene(root1));  
           stage.show();

       } 
       catch (Exception e) {
           System.out.println("nope");
       }
   }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
