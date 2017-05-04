/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analizadorjava;

import java.io.File;
import java.util.concurrent.CountDownLatch;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

/**
 *
 * @author mextest
 */
public class Sounds extends Application {

    String wrong = "src/resources/WrongBuzzer.mp3";
    String correct = "src/resources/CorrectBuzzer.mp3";
    Media hit;
    public static final CountDownLatch latch = new CountDownLatch(1);
    public static Sounds clase = null;

    /**
     * @param args the command line arguments
     */
    public void correct() {
        hit = new Media(new File(correct).toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(hit);
        mediaPlayer.play();
    }

    public void worng() {
        hit = new Media(new File(wrong).toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(hit);
        mediaPlayer.play();
    }

    @Override
    public void start(Stage stage) throws Exception {
      //  worng();
       /* BorderPane pane = new BorderPane();
        Scene scene = new Scene(pane, 500, 500);
        stage.setScene(scene);

        Label label = new Label("Hello");
        pane.setCenter(label);

        stage.show();*/
    }

    public static void main(String[] args) {
        Application.launch(args);
        
    }

    public static Sounds waitForSound() {
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return clase;
    }

    public static void setSound(Sounds sound0) {
        clase = sound0;
        latch.countDown();
    }

    public Sounds() {
        setSound(this);
    }
}
