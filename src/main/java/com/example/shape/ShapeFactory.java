package com.example.shape;

import javafx.scene.paint.Color;

import java.util.HashMap;
import java.util.Map;

public class ShapeFactory {
    public static HashMap<Integer, Shape> shapeMap;

    public ShapeFactory() {
        shapeMap = new HashMap<>();
        shapeMap.put(0, new Square(Color.RED, 75));
        shapeMap.put(1, new Triangle(Color.GREEN, 100, 100));
        shapeMap.put(2, new Rectangle(Color.BLUE, 100, 75));
    }

    public  Shape createShape(int index) {
        return shapeMap.get(index);
    }

    public Map<Integer, Shape> getMap() {
        return shapeMap;
    }
}
