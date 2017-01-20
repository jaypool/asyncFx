package sample;

import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class Controller {

    @FXML private Label Lbl1;
    @FXML private Label Lbl2;
    @FXML private Label Lbl3;

    @FXML private Button Btn1;
    @FXML private Button Btn2;
    @FXML private Button Btn3;

    @FXML protected void changeLbl1(ActionEvent actionEvent) {

        Task<Void> task = new Task<Void>() {
            @Override
            protected Void call() throws InterruptedException {
                updateMessage("Task one: busy..");
                Thread.sleep(3000);
                updateMessage("Task one: still busy..");
                Thread.sleep(5000);
                updateMessage("Task one: still not done...");
                Thread.sleep(4000);
                updateMessage("Task one: Done!");
                return null;
            }
        };
        Btn1.setDisable(true);
        Lbl1.textProperty().bind(task.messageProperty());

        task.setOnSucceeded(e -> {
            Lbl1.textProperty().unbind();
            // now this message will be displayed
            Lbl1.setText("Task one: Action completed succesfully");
            Btn1.setDisable(false);
        });

        Thread thread = new Thread(task);
        thread.setDaemon(true);
        thread.start();

    }

    @FXML protected void changeLbl2(ActionEvent actionEvent) {
        Task<Void> task = new Task<Void>() {
            @Override
            protected Void call() throws InterruptedException {
                updateMessage("Task two: busy..");
                Thread.sleep(3000);
                updateMessage("Task two: still busy..");
                Thread.sleep(5000);
                updateMessage("Task two: still not done...");
                Thread.sleep(4000);
                updateMessage("Task two: Done!");
                return null;
            }
        };
        Btn2.setDisable(true);
        Lbl2.textProperty().bind(task.messageProperty());

        task.setOnSucceeded(e -> {
            Lbl2.textProperty().unbind();
            // now this message will be displayed
            Lbl2.setText("Task two: Action completed succesfully");
            Btn2.setDisable(false);
        });

        Thread thread = new Thread(task);
        thread.setDaemon(true);
        thread.start();
    }

    @FXML protected void changeLbl3(ActionEvent actionEvent) {
        Task<Void> task = new Task<Void>() {
            @Override
            protected Void call() throws InterruptedException {
                updateMessage("Task three: busy..");
                Thread.sleep(3000);
                updateMessage("Task three: still busy..");
                Thread.sleep(5000);
                updateMessage("Task three: still not done...");
                Thread.sleep(4000);
                updateMessage("Task three: Done!");
                return null;
            }
        };
        Btn3.setDisable(true);
        Lbl3.textProperty().bind(task.messageProperty());

        task.setOnSucceeded(e -> {
            Lbl3.textProperty().unbind();
            // now this message will be displayed
            Lbl3.setText("Task three: Action completed succesfully");
            Btn3.setDisable(false);
        });

        Thread thread = new Thread(task);
        thread.setDaemon(true);
        thread.start();
    }

}
