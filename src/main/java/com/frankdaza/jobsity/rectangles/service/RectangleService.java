package com.frankdaza.jobsity.rectangles.service;

import com.frankdaza.jobsity.rectangles.domain.Line;
import com.frankdaza.jobsity.rectangles.domain.Rectangle;
import com.frankdaza.jobsity.rectangles.utils.Utilities;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RectangleService implements IRectangleService {

    private final LineService lineService;

    @Autowired
    public RectangleService(LineService lineService) {
        this.lineService = lineService;
    }

    @Override
    public boolean isInterception(Rectangle rectangle1, Rectangle rectangle2) {
        return rectangle1.getUpperLeft().getX() <= rectangle2.getLowerRight().getX()
                && rectangle2.getUpperLeft().getX() <= rectangle1.getLowerRight().getX();
    }

    @Override
    public boolean isContainment(Rectangle rectangle1, Rectangle rectangle2) {
        return rectangle1.getUpperLeft().getX() <= rectangle2.getUpperLeft().getX()
                && rectangle1.getUpperLeft().getY() >= rectangle2.getUpperLeft().getY()
                && rectangle1.getLowerRight().getX() >= rectangle2.getLowerRight().getX()
                && rectangle1.getLowerRight().getY() <= rectangle2.getLowerRight().getY();
    }

    @Override
    public boolean isAdjacencySubLine(Rectangle rectangle1, Rectangle rectangle2) {
        Line rectangle1TopLine = Utilities.getRectangleTopLine(rectangle1);
        Line rectangle1RightLine = Utilities.getRectangleRightLine(rectangle1);
        Line rectangle1BottomLine = Utilities.getRectangleBottomLine(rectangle1);
        Line rectangle1LeftLine = Utilities.getRectangleLeftLine(rectangle1);
        List<Line> rectangle1Lines = List.of(rectangle1TopLine, rectangle1RightLine, rectangle1BottomLine, rectangle1LeftLine);

        Line rectangle2TopLine = Utilities.getRectangleTopLine(rectangle2);
        Line rectangle2RightLine = Utilities.getRectangleRightLine(rectangle2);
        Line rectangle2BottomLine = Utilities.getRectangleBottomLine(rectangle2);
        Line rectangle2LeftLine = Utilities.getRectangleLeftLine(rectangle2);
        List<Line> rectangle2Lines = List.of(rectangle2TopLine, rectangle2RightLine, rectangle2BottomLine, rectangle2LeftLine);

        // I'm assuming that the adjacency sub-line only could be one
        int adjacencySubLineCounter = 0;

        for (Line rectangle1Line : rectangle1Lines) {
            for (Line rectangle2Line : rectangle2Lines) {
                if (lineService.isLine2SubLineOfLine1(rectangle1Line, rectangle2Line)) {
                    adjacencySubLineCounter++;
                }
            }
        }

        return adjacencySubLineCounter == 1;
    }
}
