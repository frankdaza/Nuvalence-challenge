package com.frankdaza.jobsity.rectangles.utils;

import com.frankdaza.jobsity.rectangles.domain.Line;
import com.frankdaza.jobsity.rectangles.domain.Point;
import com.frankdaza.jobsity.rectangles.domain.Rectangle;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;

@DisplayName("Utilities Test")
@SpringBootTest
public class UtilitiesTest {

    @DisplayName("should create two points and the slope should be 1")
    @Test
    public void getSlope() {
        Point point1 = new Point(1, 2);
        Point point2 = new Point(3, 4);
        BigDecimal slope = Utilities.getSlopeFromLine(point1, point2);
        Assertions.assertEquals(BigDecimal.valueOf(1), slope);
    }

    @DisplayName("should get the top side line of a rectangle")
    @Test
    public void getRectangleTopLine() {
        Rectangle rectangle = new Rectangle(new Point(1, 7), new Point(5, 1));
        Line rectangleTopLine = Utilities.getRectangleTopLine(rectangle);
        Point pointTopRight = new Point(5, 7);
        Assertions.assertEquals(pointTopRight, rectangleTopLine.getPoint2());
    }

    @DisplayName("should get the right side line of a rectangle")
    @Test
    public void getRectangleRightLine() {
        Rectangle rectangle = new Rectangle(new Point(1, 7), new Point(5, 1));
        Line rectangleRightLine = Utilities.getRectangleRightLine(rectangle);
        Point pointTopRight = new Point(5, 7);
        Assertions.assertEquals(pointTopRight, rectangleRightLine.getPoint1());
    }

    @DisplayName("should get the bottom side line of a rectangle")
    @Test
    public void getRectangleBottomLine() {
        Rectangle rectangle = new Rectangle(new Point(1, 7), new Point(5, 1));
        Line rectangleBottomLine = Utilities.getRectangleBottomLine(rectangle);
        Point pointBottomLeft = new Point(1, 1);
        Assertions.assertEquals(pointBottomLeft, rectangleBottomLine.getPoint1());
    }

    @DisplayName("should get the left side line of a rectangle")
    @Test
    public void getRectangleLeftLine() {
        Rectangle rectangle = new Rectangle(new Point(1, 7), new Point(5, 1));
        Line rectangleLeftLine = Utilities.getRectangleLeftLine(rectangle);
        Point pointBottomLeft = new Point(1, 1);
        Assertions.assertEquals(pointBottomLeft, rectangleLeftLine.getPoint2());
    }

    @DisplayName("should create a rectangle and get the side lines of a rectangle")
    @Test
    public void getRectangleSideLines() {
        Rectangle rectangle = new Rectangle(new Point(1, 7), new Point(5, 1));
        List<Line> rectangleSideLines = Utilities.getRectangleSideLines(rectangle);
        Line rectangleTopLine = Utilities.getRectangleTopLine(rectangle);
        Line rectangleRightLine = Utilities.getRectangleRightLine(rectangle);
        Line rectangleBottomLine = Utilities.getRectangleBottomLine(rectangle);
        Line rectangleLeftLine = Utilities.getRectangleLeftLine(rectangle);
        Assertions.assertEquals(rectangleTopLine, rectangleSideLines.getFirst());
        Assertions.assertEquals(rectangleRightLine, rectangleSideLines.get(1));
        Assertions.assertEquals(rectangleBottomLine, rectangleSideLines.get(2));
        Assertions.assertEquals(rectangleLeftLine, rectangleSideLines.getLast());
    }
}
