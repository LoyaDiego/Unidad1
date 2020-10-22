package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Controller {
@FXML
    TextArea txtreceta,txtingredientes,txtpreparacion,txtpreguntas;
@FXML protected void initialize (){
    try {
        File f = new File("./src/sample/Receta.txt");
        BufferedReader br = new BufferedReader((new FileReader(f)));
        String texto=" ";
        while ((texto=br.readLine())!=null){
            txtreceta.appendText("\n"+texto);
        }
    }catch (Exception e){
        System.out.println(e.getMessage());
    }
}
public void procesar (ActionEvent event){
    String[] arreglolineas=txtreceta.getText().split("\n");

    boolean encontro=false;
    boolean encontro1=true;
    for (int x=0;x<arreglolineas.length;x++){
        if (encontro){
            txtpreparacion.appendText("\n"+arreglolineas[x]);
        }
        if (arreglolineas[x].contains("***")){
            encontro=true;
        }
    }
    for (int x=0;x<arreglolineas.length;x++){
            if (encontro1){
                txtingredientes.appendText("\n"+arreglolineas[x]);
            }
            if (arreglolineas[x].contains("***")){
                encontro1=false;
            }
    }
    String[] arregloingredientes=txtingredientes.getText().split("\n");
    String[] cont= new String[arregloingredientes.length];
    int[] parte1=new int[arregloingredientes.length];
    int a=0;
    for (int x=0;x<arregloingredientes.length;x++){
        if (arregloingredientes[x].contains("chile")){
            cont[x]=(arregloingredientes[x]);
            String[] partes= cont[x].split(" ");
            parte1[x]= Integer.parseInt(partes[0]);
            a=a+parte1[x];
        }
    }
    txtpreguntas.appendText(a+" Gramos de chiles en total");

    String[] arreglopasos=txtpreparacion.getText().split("\n");
    String[] cont1= new String[arreglopasos.length];
    for (int x=0;x<11;x++){
        cont1[x]=arreglopasos[x];
    }
    txtpreguntas.appendText("\n\nEl paso numero 4 es:\n "+cont1[10]);

    txtpreguntas.appendText("\n\nLos ingredientes asados son: ");
    for (int x=0;x<arregloingredientes.length;x++){

        if (arregloingredientes[x].contains("asad")){
            txtpreguntas.appendText("\n"+arregloingredientes[x]);
        }
    }
//No logre esta parte, si me pudiera dar un tip me gustaria mucho
    int n=40;
    String[] cont2= new String[1000];
    int[] parte2=new int[1000];
    int[] rep=new int[1000];
    for (int x=0;x<arregloingredientes.length;x++){
        if (arregloingredientes[x].contains(" ")) {
            cont2[x] = (arregloingredientes[x]);
            String[] partes = cont2[x].split(" ");
            parte2[x] = Integer.parseInt(partes[0]);
            rep[x]= (n*(Integer.parseInt(partes[0])))/60;
            System.out.println(rep[x]);
            String cambio= arregloingredientes[x].replaceFirst(partes[x], String.valueOf((rep[x])));
            System.out.println(cambio);
        }
    }
}
}
