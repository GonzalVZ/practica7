package com.iescelia;

import java.io.IOException;
import java.util.Scanner;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class AnadirDispositivoController {
    @FXML
    TextField txtMarca, txtModelo;

    @FXML
    private void guardar() throws IOException {
        String marca = txtMarca.getText();
        String modelo = txtModelo.getText();

        Dispositivo dis = new Dispositivo(marca, modelo, true);
        int b = dis.save();

        if (b == 0) {
            System.out.println("Todo correcto!");

        } else {
            System.out.println("Halgo ha salido mal");
        }

        App.setRoot("primary");
    }
}