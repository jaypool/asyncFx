package sample;

import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class Controller {

    @FXML private Label Lbl1;
    @FXML private Label Lbl2;
    @FXML private Label Lbl3;

    @FXML protected void changeLbl1(ActionEvent actionEvent) {

        Task<Void> task = new Task<Void>() {
            @Override
            protected Void call() throws InterruptedException {
                updateMessage("Task one: busy..");
                Thread.sleep(3000);
                updateMessage("Task one: still busy..");
                Thread.sleep(5000);
                updateMessage("Task one: still not done...");
                Thread.sleep(3000);
                updateMessage("Task one: Done!");
                return null;
            }
        };
        Lbl1.textProperty().bind(task.messageProperty());

        task.setOnSucceeded(e -> {
            Lbl1.textProperty().unbind();
            // now this message will be displayed
            Lbl1.setText("Task one: Action completed succesfully");
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
                Thread.sleep(3000);
                updateMessage("Task two: Done!");
                return null;
            }
        };
        Lbl2.textProperty().bind(task.messageProperty());

        task.setOnSucceeded(e -> {
            Lbl2.textProperty().unbind();
            // now this message will be displayed
            Lbl2.setText("Task two: Action completed succesfully");
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
                Thread.sleep(3000);
                updateMessage("Task three: Done!");
                return null;
            }
        };
        Lbl3.textProperty().bind(task.messageProperty());

        task.setOnSucceeded(e -> {
            Lbl3.textProperty().unbind();
            // now this message will be displayed
            Lbl3.setText("Task three: Action completed succesfully");
        });

        Thread thread = new Thread(task);
        thread.setDaemon(true);
        thread.start();
    }

}
