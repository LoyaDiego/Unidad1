package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Controller {
    @FXML
    TextField txtFrase;
    @FXML
    Label lblRes;
    @FXML
    ComboBox combobox;
    @FXML protected void initialize(){
        combobox.getItems().addAll("Char At","Ends With","compareTo","EqualsIgnoreCase",
                "IndexOf","LastIndexOf","Replace","ReplaceFirst", "Split", "StartsWith","Substring");
    }

    public void evento(ActionEvent event){
        String texto=txtFrase.getText();
        switch (combobox.getSelectionModel().getSelectedIndex()){
            case 0:{
                char res=texto.charAt(2);
                lblRes.setText(res+"");
                break;

            }
            case 1:{
                boolean res=texto.endsWith("ota");
                lblRes.setText(res+"");
                break;
            }
            case 2:{
                int res=texto.compareTo("b");
                lblRes.setText(res+"");
                break;
            }
            case 3:{
                boolean res=texto.equalsIgnoreCase("HolA");
                lblRes.setText(res+"");

                break;
            }
            case 4:{
                int res=texto.indexOf('e');
                lblRes.setText(res+"");
                break;
            }
            case 5:{
                int res=texto.lastIndexOf('e');
                lblRes.setText(res+"");
                break;
            }
            case 6:{
                String res=texto.replace('a','e');
                lblRes.setText(res);
                break;
            }
            case 7:{
                String res=texto.replaceFirst("a","e");
                lblRes.setText(res);

                break;
            }
            //solo logre que funcionara con una oracion de 4 palabras
            case 8:{
                int x=0;
                String[] pa=new String[10];
                String[] res=texto.split(" ");
                for (String palabra: res){
                    pa[x]=palabra;
                    x++;
               }
                lblRes.setText(pa[0]+","+pa[1]+","+pa[2]+","+pa[3]);
                break;
            }
            case 9:{
                boolean res=texto.startsWith("buenas");
                lblRes.setText(res+"");
                break;
            }
            case 10:{
                String res=texto.substring(0,6);
                lblRes.setText(res);
                break;
            }
        }
    }
}
