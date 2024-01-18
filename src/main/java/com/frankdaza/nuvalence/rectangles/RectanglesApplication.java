package com.frankdaza.nuvalence.rectangles;

import com.frankdaza.nuvalence.rectangles.jframe.RectanglesDrawing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RectanglesApplication {

    public static void main(String[] args) {
        RectanglesDrawing rectanglesDrawing = new RectanglesDrawing();
        SpringApplication.run(RectanglesApplication.class, args);
    }

}
