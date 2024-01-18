package com.frankdaza.nuvalence.rectangles.service;

import com.frankdaza.nuvalence.rectangles.domain.Line;
import com.frankdaza.nuvalence.rectangles.domain.Point;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@DisplayName("Line Service Test")
@SpringBootTest
public class LineServiceTest {

    private final LineService lineService;

    @Autowired
    public LineServiceTest(LineService lineService) {
        this.lineService = lineService;
    }

    @DisplayName("should create two lines and the line1 should be equals to line2")
    @Test
    public void isLine1EqualsLine2() {
        Point point1Line1 = new Point(1, 2);
        Point point2Line1 = new Point(3, 4);
        Line line1 = new Line(point1Line1, point2Line1);

        Point point1Line2 = new Point(1, 2);
        Point point2Line2 = new Point(3, 4);
        Line line2 = new Line(point1Line2, point2Line2);

        Assertions.assertTrue(lineService.isLine1EqualsLine2(line1, line2));
    }

    @DisplayName("should create two lines and the line1 should not be equals to line2")
    @Test
    public void isLine1NotEqualsLine2() {
        Point point1Line1 = new Point(1, 2);
        Point point2Line1 = new Point(3, 4);
        Line line1 = new Line(point1Line1, point2Line1);

        Point point1Line2 = new Point(1, 2);
        Point point2Line2 = new Point(3, 5);
        Line line2 = new Line(point1Line2, point2Line2);

        Assertions.assertFalse(lineService.isLine1EqualsLine2(line1, line2));
    }

    @DisplayName("should create two lines and the line2 should be sub-line of line1")
    @Test
    public void isLine2SubLineOfLine1() {
        Point point1Line1 = new Point(1, 6);
        Point point2Line1 = new Point(7, 2);
        Line line1 = new Line(point1Line1, point2Line1);

        Point point1Line2 = new Point(2, 5);
        Point point2Line2 = new Point(6, 3);
        Line line2 = new Line(point1Line2, point2Line2);

        Assertions.assertTrue(lineService.isLine2SubLineOfLine1(line1, line2));
    }

    @DisplayName("should create two lines and the line2 should not be sub-line of line1 - case 1")
    @Test
    public void isLine2NotSubLineOfLine1Case1() {
        Point point1Line1 = new Point(1, 6);
        Point point2Line1 = new Point(7, 2);
        Line line1 = new Line(point1Line1, point2Line1);

        Point point1Line2 = new Point(2, 5);
        Point point2Line2 = new Point(6, 4);
        Line line2 = new Line(point1Line2, point2Line2);

        Assertions.assertFalse(lineService.isLine2SubLineOfLine1(line1, line2));
    }

    @DisplayName("should create two lines and the line2 should not be sub-line of line1 - case 2")
    @Test
    public void isLine2NotSubLineOfLine1Case2() {
        Point point1Line1 = new Point(1, 1);
        Point point2Line1 = new Point(7, 6);
        Line line1 = new Line(point1Line1, point2Line1);

        Point point1Line2 = new Point(3, 1);
        Point point2Line2 = new Point(9, 7);
        Line line2 = new Line(point1Line2, point2Line2);

        Assertions.assertFalse(lineService.isLine2SubLineOfLine1(line1, line2));
    }

    @DisplayName("should create two vertical lines lines and the line2 should be partial sub-line of line1 - case 1")
    @Test
    public void isLine2PartialSubLineOfLine1Case1() {
        Point point1Line1 = new Point(5, 5);
        Point point2Line1 = new Point(5, 1);
        Line line1 = new Line(point1Line1, point2Line1);

        Point point1Line2 = new Point(5, 7);
        Point point2Line2 = new Point(5, 3);
        Line line2 = new Line(point1Line2, point2Line2);

        Assertions.assertTrue(lineService.isLine2PartialSubLineOfLine1(line1, line2));
    }

    @DisplayName("should create two horizontal lines lines and the line2 should be partial sub-line of line1 - case 2")
    @Test
    public void isLine2PartialSubLineOfLine1Case2() {
        Point point1Line1 = new Point(1, 3);
        Point point2Line1 = new Point(5, 3);
        Line line1 = new Line(point1Line1, point2Line1);

        Point point1Line2 = new Point(4, 3);
        Point point2Line2 = new Point(8, 3);
        Line line2 = new Line(point1Line2, point2Line2);

        Assertions.assertTrue(lineService.isLine2PartialSubLineOfLine1(line1, line2));
    }

    @DisplayName("should create two vertical lines and the line2 should not be partial sub-line of line1 - case 1")
    @Test
    public void isLine2NotPartialSubLineOfLine1Case1() {
        Point point1Line1 = new Point(3, 6);
        Point point2Line1 = new Point(3, 1);
        Line line1 = new Line(point1Line1, point2Line1);

        Point point1Line2 = new Point(6, 6);
        Point point2Line2 = new Point(6, 1);
        Line line2 = new Line(point1Line2, point2Line2);

        Assertions.assertFalse(lineService.isLine2PartialSubLineOfLine1(line1, line2));
    }

    @DisplayName("should create two horizontal lines and the line2 should not be partial sub-line of line1 - case 2")
    @Test
    public void isLine2NotPartialSubLineOfLine1Case2() {
        Point point1Line1 = new Point(1, 3);
        Point point2Line1 = new Point(7, 3);
        Line line1 = new Line(point1Line1, point2Line1);

        Point point1Line2 = new Point(1, 5);
        Point point2Line2 = new Point(7, 5);
        Line line2 = new Line(point1Line2, point2Line2);

        Assertions.assertFalse(lineService.isLine2PartialSubLineOfLine1(line1, line2));
    }
}
