package com.example.shape;

import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable, EventHandler<MouseEvent> {
    public ListView listview;
    public Canvas canvas;
    public ColorPicker colorPicker;
    public ObservableList<Shape> content;
    public ComboBox<Integer> widhtStroke;
    public Label figure;
    GraphicsContext gc;
    public ColorPicker strokeColor;
    @FXML
    TextField textX;
    @FXML
    TextField textY;
    private ShapeFactory shapeFactory;

    public void initialize(URL location, ResourceBundle resource) {
        shapeFactory  = new ShapeFactory();
        gc = canvas.getGraphicsContext2D();
        content = FXCollections.observableArrayList();
        for (int i=0; i<shapeFactory.getMap().size();i++){
            content.add(shapeFactory.createShape(i));
        }
        ObservableList<Integer> strokeOptions = FXCollections.observableArrayList(0, 1, 2, 3, 4, 5, 6, 7, 8);
        widhtStroke.setItems(strokeOptions);
        listview.setItems(content);
        listview.setCellFactory(list -> new ShapeCell());
        canvas.setOnMouseClicked(this::handle);
    }

    public void onClear(ActionEvent actionEvent) {
        GraphicsContext graphicsContext = canvas.getGraphicsContext2D();
        graphicsContext.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
    }

    @Override
    public void handle(MouseEvent event) {
        int x = (int) (event.getX()/1.2);
        int y = (int) (event.getY()/1.2);
        int index = listview.getSelectionModel().getSelectedIndex();
        Shape shape = content.get(index);
        shape.draw(gc, x, y, colorPicker.getValue(), widhtStroke.getValue(), strokeColor.getValue());
        figure.setText("Фигура:  " + shape);
    }
}