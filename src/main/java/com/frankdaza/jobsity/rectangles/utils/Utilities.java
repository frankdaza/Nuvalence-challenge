package com.frankdaza.jobsity.rectangles.utils;

import com.frankdaza.jobsity.rectangles.domain.Line;
import com.frankdaza.jobsity.rectangles.domain.Point;
import com.frankdaza.jobsity.rectangles.domain.Rectangle;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

public class Utilities {

    static public BigDecimal getSlopeFromLine(Point point1, Point point2) {
        BigDecimal numerator = new BigDecimal(String.valueOf(point2.getY() - point1.getY()));
        BigDecimal denominator = new BigDecimal(String.valueOf(point2.getX() - point1.getX()));

        if (denominator.equals(BigDecimal.ZERO)) {
            return new BigDecimal(String.valueOf(Long.MAX_VALUE));
        }

        return numerator.divide(denominator, RoundingMode.HALF_UP);
    }

    static public Line getRectangleTopLine(Rectangle rectangle) {
        Point pointTopLeft = rectangle.getUpperLeft();
        Point pointTopRight = new Point(rectangle.getLowerRight().getX(), rectangle.getUpperLeft().getY());
        return new Line(pointTopLeft, pointTopRight);
    }

    static public Line getRectangleRightLine(Rectangle rectangle) {
        Point pointTopRight = new Point(rectangle.getLowerRight().getX(), rectangle.getUpperLeft().getY());
        Point pointBottomRight = rectangle.getLowerRight();
        return new Line(pointTopRight, pointBottomRight);
    }

    static public Line getRectangleBottomLine(Rectangle rectangle) {
        Point pointBottomLeft = new Point(rectangle.getUpperLeft().getX(), rectangle.getLowerRight().getY());
        Point pointBottomRight = rectangle.getLowerRight();
        return new Line(pointBottomLeft, pointBottomRight);
    }

    static public Line getRectangleLeftLine(Rectangle rectangle) {
        Point pointTopLeft = rectangle.getUpperLeft();
        Point pointBottomLeft = new Point(rectangle.getUpperLeft().getX(), rectangle.getLowerRight().getY());
        return new Line(pointTopLeft, pointBottomLeft);
    }

    static public List<Line> getRectangleSideLines(Rectangle rectangle) {
        Line rectangleTopLine = Utilities.getRectangleTopLine(rectangle);
        Line rectangleRightLine = Utilities.getRectangleRightLine(rectangle);
        Line rectangleBottomLine = Utilities.getRectangleBottomLine(rectangle);
        Line rectangleLeftLine = Utilities.getRectangleLeftLine(rectangle);
        return List.of(rectangleTopLine, rectangleRightLine, rectangleBottomLine, rectangleLeftLine);
    }
}
