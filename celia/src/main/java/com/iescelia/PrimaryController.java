package com.iescelia;

import java.nio.file.*;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class PrimaryController {

    @FXML
    TextArea salida;

    @FXML
    TextField eliminar, txtid, busco;

    @FXML
    private void anadirDispositivo() throws IOException {
        App.setRoot("anadirDispositivo");
    }

    @FXML
    private void anadirOrdenador() throws IOException {
        App.setRoot("anadirOrdenador");
    }

    public void verTodos() throws IOException {
        int id = 1, salir = 0;
        salida.setText(null);
        do {
            Dispositivo d = new Dispositivo(id);
            salir = d.load();
            if (salir == 0) {
                if (d.getTipo() == 2) { // El dispositivo es un ordenador
                    Ordenador o = new Ordenador(id);
                    o.load();
                    salida.appendText(o.toString() + "\n");
                } else if (d.getTipo() == 3) { // El dispositivo es una impresora
                    Impresora i = new Impresora(id);
                    i.load();
                    salida.appendText(i.toString() + "\n");
                } else { // El dispositivo es un dispositivo genérico (ya está cargado)
                    salida.appendText(d.toString() + "\n");
                }

            }
            id++;
        } while (salir == 0);

    }

    public void buscar() throws IOException {
        try {
            int id = Integer.parseInt(busco.getText());
            Dispositivo dis = new Dispositivo(id);
            dis.load();
            salida.setText(dis.toString() + "\n");

        } catch (NumberFormatException e) {
            salida.appendText("ID inválido. Introduce un número válido.\n");
        }
    }

    public void eliminado() throws IOException {
        try {
            int id = Integer.parseInt(eliminar.getText());
            Dispositivo dis = new Dispositivo(id);
            dis.delete();

        } catch (NumberFormatException e) {
            salida.appendText("ID inválido. Introduce un número válido.\n");
        }
    }

    public void botonEstado() throws IOException {
        try {
            int id = Integer.parseInt(txtid.getText());
            Dispositivo dis = new Dispositivo(id);
            dis.cambioEstado();

        } catch (NumberFormatException e) {
            salida.appendText("ID inválido. Introduce un número válido.\n");
        }
    }

    public void eliminarTodo() throws IOException {
        File fichero = new File("Dispositivo.bin");
        File fichero1 = new File("Ordenador.bin");

        try {
            fichero.delete();
            fichero1.delete();
        } catch (Exception e) {

        }

    }

}
