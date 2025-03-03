package com.iescelia;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class AnadirOrdenadorController {

    @FXML
    TextField txtMarca1, txtModelo1, ram, procesador, tamDisco, tipoDisco;

    @FXML
    private void guardar1() throws IOException {
        String marca = txtMarca1.getText();
        String modelo = txtModelo1.getText();
        int ram1 = Integer.parseInt(ram.getText());
        String procesador1 = procesador.getText();
        int tamDisco1 = Integer.parseInt(tamDisco.getText());
        int tipoDisco1 = Integer.parseInt(tipoDisco.getText());
        Ordenador or = new Ordenador(marca, modelo, true, ram1, procesador1, tamDisco1,
                tipoDisco1);
        int b = or.save();

        if (b == 0) {
            System.out.println("Todo correcto!");

        } else {
            System.out.println("Halgo ha salido mal");
        }

        App.setRoot("primary");
    }

}
