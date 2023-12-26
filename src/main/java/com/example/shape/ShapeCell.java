package com.example.shape;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ListCell;
import javafx.scene.paint.Color;

class ShapeCell extends ListCell<Shape> {// класс Product

    @Override

    public void updateItem(Shape item, boolean empty) {

        super.updateItem(item, empty);

        if (item != null) {

            Canvas cnv=new Canvas();

            cnv.setHeight(60);// задание размера элемента отображения

            cnv.setWidth(100);

            GraphicsContext gc=cnv.getGraphicsContext2D();

            Shape item1=(Shape)item.clone();//текущая фигура из списка ObservableList

            item1.draw(gc,0,0,Color.BLACK,0,Color.BLACK); // ее отрисовка на канве

            setGraphic(cnv); //установка канвы вместо cell

        }

    }

}