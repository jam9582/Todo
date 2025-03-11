package main.java;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {
    private ObservableList<String> toDoItems;
    private ListView<String> listView;

    @Override
    public void start(Stage primaryStage) {
        // 할 일 목록 초기화
        toDoItems = FXCollections.observableArrayList();
        listView = new ListView<>(toDoItems);

        // 입력 필드 & 버튼 생성
        TextField inputField = new TextField();
        inputField.setPromptText("할 일을 입력하세요...");
        Button addButton = new Button("추가");
        Button deleteButton = new Button("삭제");

        // 버튼 이벤트 추가
        addButton.setOnAction(e -> addToDoItem(inputField));
        deleteButton.setOnAction(e -> deleteToDoItem());

        // UI 배치
        VBox layout = new VBox(10, inputField, addButton, listView, deleteButton);
        layout.setStyle("-fx-padding: 10px;");

        // 씬 설정
        Scene scene = new Scene(layout, 300, 400);
        primaryStage.setTitle("To-Do List");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    // 할 일 추가 메서드
    private void addToDoItem(TextField inputField) {
        String text = inputField.getText().trim();
        if (!text.isEmpty()) {
            toDoItems.add(text);
            inputField.clear();
        }
    }

    // 선택한 할 일 삭제 메서드
    private void deleteToDoItem() {
        String selectedItem = listView.getSelectionModel().getSelectedItem();
        if (selectedItem != null) {
            toDoItems.remove(selectedItem);
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}


