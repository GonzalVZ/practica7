package com.iescelia;

import java.io.IOException;
import java.util.Scanner;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class PrimaryController {
    @FXML
    TextArea salida;

    @FXML
    TextField eliminar;

    @FXML
    private void anadirDispositivo() throws IOException {
        App.setRoot("anadirDispositivo");
    }

    public void verTodos() throws IOException {
        int id = 1, salir = 0;

        do {
            Dispositivo dis = new Dispositivo(id);
            salir = dis.load();
            if (salir == 0) {
                salida.appendText(dis.toString() + "\n");
            }
            id++;
        } while (salir == 0);

    }

    public void eliminado() throws IOException{
        
     int id = Integer.parseInt(eliminar.getText());
        Dispositivo dis = new Dispositivo(id)
            
               dis.delete();
              
            
        
    }

}
