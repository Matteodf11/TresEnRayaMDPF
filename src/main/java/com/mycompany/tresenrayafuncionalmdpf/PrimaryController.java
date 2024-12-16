package com.mycompany.tresenrayafuncionalmdpf;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

public class PrimaryController implements Initializable {

    @FXML
    private Button botonarribaizquierda;
    @FXML
    private Button botonarribacentro;
    @FXML
    private Button botonarribaderecha;
    @FXML
    private Button botoncentroizquierda;
    @FXML
    private Button botoncentro;
    @FXML
    private Button botoncentroderecha;
    @FXML
    private Button botonabajoizquierda;
    @FXML
    private Button botonabajocentro;
    @FXML
    private Button botonabajoderecha;
    @FXML
    private Button botonlimpiar;
    @FXML
    private Button botoniniciar;

    private String turno = "X";
    @FXML
    private GridPane tablero;
    @FXML
    private Label jugadorx;
    @FXML
    private Label jugadoro;
    @FXML
    private TextField puntuacionx;
    @FXML
    private TextField puntuaciono;

    static Button botones[] = new Button[9];

    static int posibilidadesdeganar[][] = {
        {1, 2, 3},
        {4, 5, 6},
        {7, 8, 9},
        {1, 4, 7},
        {2, 5, 8},
        {3, 6, 9},
        {1, 5, 9},
        {3, 5, 7}

    };

    private void cambiarTurno() {
        turno = (turno.equals("X")) ? "O" : "X";
        if (turno.equals("X")) {
            jugadorx.setTextFill(Color.GREEN);
            jugadoro.setTextFill(Color.BLACK);
        } else {
            jugadoro.setTextFill(Color.GREEN);
            jugadorx.setTextFill(Color.BLACK);
        }
    }

    @FXML
    private void handleButtonClicked(ActionEvent event) {
        Button button = (Button) event.getSource();
        if (button.getText().isEmpty()) {
            button.setText(turno);
            cambiarTurno();
            ganador();

        }
    }

    @FXML
    private void handleResetButtonClicked() {
        tablero.getChildren().forEach((Node button) -> {
            if (button instanceof Button) {
                ((Button) button).textProperty().setValue("");
            }
            puntuaciono.setText("0");
            puntuacionx.setText("0");
        });
    }

    @FXML
    private void handleStartButtonClicked(ActionEvent event) {
        habilitarbotones();
        tablero.getChildren().forEach((Node button) -> {
            button.disableProperty().setValue(Boolean.FALSE);
            if (button instanceof Button) {
                ((Button) button).textProperty().setValue("");
            }
        });

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        deshabilitarbotones();
        jugadorx.setTextFill(Color.GREEN);
        botones[0] = botonarribaizquierda;
        botones[1] = botonarribacentro;
        botones[2] = botonarribaderecha;
        botones[3] = botoncentroizquierda;
        botones[4] = botoncentro;
        botones[5] = botoncentroderecha;
        botones[6] = botonabajoizquierda;
        botones[7] = botonabajocentro;
        botones[8] = botonabajoderecha;

    }

    public void deshabilitarbotones() {
        tablero.getChildren().forEach((Node button) -> {
            button.disableProperty().setValue(Boolean.TRUE);

        });
    }

    public void habilitarbotones() {
        tablero.getChildren().forEach((Node button) -> {
            button.disableProperty().setValue(Boolean.FALSE);
        });
    }

    public void ganador() {
        for (int i = 0; i < posibilidadesdeganar.length; i++) {
            if (botones[posibilidadesdeganar[i][0] - 1].getText().equals("X")
                    && botones[posibilidadesdeganar[i][1] - 1].getText().equals("X")
                    && botones[posibilidadesdeganar[i][2] - 1].getText().equals("X")) {
                
                
                int puntuacion = Integer.parseInt(puntuacionx.getText());
                puntuacion++;
                puntuacionx.setText(puntuacion+"");
                deshabilitarbotones();

            }
            if (botones[posibilidadesdeganar[i][0] - 1].getText().equals("O")
                    && botones[posibilidadesdeganar[i][1] - 1].getText().equals("O")
                    && botones[posibilidadesdeganar[i][2] - 1].getText().equals("O")) {

                int puntuacion = Integer.parseInt(puntuaciono.getText());
                puntuacion++;
                puntuaciono.setText(puntuacion+"");
                deshabilitarbotones();
            }
            
        }

    }
}
