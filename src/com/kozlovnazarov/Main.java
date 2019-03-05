package com.kozlovnazarov;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import javafx.scene.control.SelectionMode;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("editor");
        primaryStage.setScene(new Scene(root, 966, 503));
        Scene scene = primaryStage.getScene();
        // ===================================================================
        /* read file on program starts */
        ListView listView = (ListView<String>) scene.lookup("#RawList");
        listView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        Path htmlDocPath = Paths.get("src/com/kozlovnazarov/document.html");
        Charset charset = Charset.forName("UTF-8");
        try {
            List<String> lines = Files.readAllLines(htmlDocPath, charset);
            for (String line : lines) {
                System.out.println(line);
            }
            ObservableList<String> list = (ObservableList<String>) FXCollections.observableArrayList(lines);
            listView.setItems(list);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        // ===================================================================
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }

}
