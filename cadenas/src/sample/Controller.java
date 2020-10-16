package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Controller {
@FXML
Label lbllineas;
@FXML
    TextArea txtreceta;
@FXML protected void initialize(){
    try {
        File f=new File("./src/sample/archivo.txt");
        BufferedReader br=new BufferedReader((new FileReader(f)));
        String texto="";
        while ((texto=br.readLine())!=null){
            txtreceta.appendText("\n"+texto);
        }
    }catch (Exception e){
        System.out.println(e.getMessage());
    }
}

public void procesar(ActionEvent event){
    String[] arreglolinas=txtreceta.getText().split("\n");
    lbllineas.setText("Lineas: "+arreglolinas.length);
    boolean encontro=false;
    for (int x=0; x<arreglolinas.length;x++){
        if (arreglolinas[x].contains("queso")){
            String[] arreglo2=arreglolinas[x].split(" ");
            System.out.println(arreglo2[0]);
        }
        if (arreglolinas[x].contains("manzanas")) {
            String[] arr2 = arreglolinas[x].split(" ");
            System.out.println("manzanas: " + arr2[0]);
        }
        if (encontro){
            System.out.println(arreglolinas[x]);
            }
        if (arreglolinas[x].contains("***")) {
                encontro=true;

            }
    }
}
}
