/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculator;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

/**
 *
 * @author Dennis
 */
public class FXMLDocumentController implements Initializable {
  
    @FXML
    private TextField textField;
    
    @FXML
    private Button maximizeButton;
    
    @FXML
    private ListView listView;
    
    @FXML
    private AnchorPane anchorPane;
    
    private Processor processor = new Processor();
    boolean calculationDone = false;
    
    @FXML
    private void exitCalculator(){
        System.exit(1);
    }
    
    @FXML
    private void button1(){
        if(calculationDone){
            textField.setText("");
            calculationDone = false;
        }
        textField.setText(textField.getText() + "1");
    }
          
    @FXML
    private void button2(){
        if(calculationDone){
            textField.setText("");
            calculationDone = false;
        }
        textField.setText(textField.getText() + "2");
    }
    
    @FXML
    private void button3(){
        if(calculationDone){
            textField.setText("");
            calculationDone = false;
        }
        textField.setText(textField.getText() + "3");
    }
    
    @FXML
    private void button4(){
        if(calculationDone){
            textField.setText("");
            calculationDone = false;
        }
        textField.setText(textField.getText() + "4");
    }
    
    @FXML
    private void button5(){
        if(calculationDone){
            textField.setText("");
            calculationDone = false;
        }
        textField.setText(textField.getText() + "5");
    }
    
    @FXML
    private void button6(){
        if(calculationDone){
            textField.setText("");
            calculationDone = false;
        }
        textField.setText(textField.getText() + "6");
    }
    
    @FXML
    private void button7(){
        if(calculationDone){
            textField.setText("");
            calculationDone = false;
        }
        textField.setText(textField.getText() + "7");
    }
    
    @FXML
    private void button8(){
        if(calculationDone){
            textField.setText("");
            calculationDone = false;
        }
        textField.setText(textField.getText() + "8");
    }
    
    @FXML
    private void button9(){
        if(calculationDone){
            textField.setText("");
            calculationDone = false;
        }
        textField.setText(textField.getText() + "9");
    }
    
    @FXML
    private void button0(){
        if(calculationDone){
            textField.setText("");
            calculationDone = false;
        }
        textField.setText(textField.getText() + "0");
    }
    
    @FXML
    private void buttonPlus(){
        if(calculationDone){
            textField.setText("");
            calculationDone = false;
        }
        textField.setText(textField.getText() + "+");
    }
    
    @FXML
    private void buttonMinus(){
        if(calculationDone){
            textField.setText("");
            calculationDone = false;
        }
        textField.setText(textField.getText() + "-");
    }
    
    @FXML
    private void buttonDevide(){
        if(calculationDone){
            textField.setText("");
            calculationDone = false;
        }
        textField.setText(textField.getText() + "/");
    }
    
    @FXML
    private void buttonMultiply(){
        if(calculationDone){
            textField.setText("");
            calculationDone = false;
        }
        textField.setText(textField.getText() + "x");
    }
    
    @FXML
    private void buttonDot(){
        if(calculationDone){
            textField.setText("");
            calculationDone = false;
        }
        textField.setText(textField.getText() + ".");
    }
    
    @FXML
    private void buttonEquals(){
        calculationDone = true;
        String calculation = textField.getText();
        String answer = processor.calculateString(calculation);
        textField.setText(answer);
    }
    
    @FXML
    private void buttonClear(){
        textField.setText("");
    }
    
    @FXML
    private void buttonMaximize(){
        if(maximizeButton.getText().equals(">")){
            maximizeButton.setText("<");
            listView.setVisible(false);
        }
        else{
            maximizeButton.setText(">");
            listView.setVisible(true);
        }
    }
    
    @FXML
    private void save(){
        
    }
    
    @FXML
    private void load(){
        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        textField.setText("");
    }    
    
}
