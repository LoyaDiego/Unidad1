package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.VBox;

public class Controller {
    @FXML VBox vbox;
    @FXML TextField txtmensaje;

    public void enter(KeyEvent event){
        if (event.getCode() == KeyCode.ENTER){
            Label label=new Label("Tu: "+txtmensaje.getText());
            vbox.getChildren().add(label);

            String respuesta= chatBot(txtmensaje.getText().toLowerCase());
            Label label2=new Label(respuesta);
            vbox.getChildren().add(label2);
        }
    }
    boolean pidiopieza=false;
    public String chatBot (String mensaje) {
        String respuesta = "No entendi pero la tuya por si acaso";
        if (mensaje.contains("hola")) {
            respuesta = ("El pana: Hola,en que le puedo ayudar?");
        } else if (mensaje.contains("pieza")) {
            respuesta = ("El pana: Escriba marca modelo y cual pieza necesita");
            pidiopieza = true;
        }else if (pidiopieza){
            String[] datos=mensaje.split(" ");
            String modelo=datos[1];
            int indice1= mensaje.indexOf (modelo)+(modelo.length());
            int indice2=mensaje.length();
            String pieza=mensaje.substring(indice1,indice2);
            respuesta = ("El pana: la pieza "+ pieza+" del auto "+datos[0]+" "+datos[1]+ " si la tenemos en existencia");
        }
        return respuesta;

    }
}
