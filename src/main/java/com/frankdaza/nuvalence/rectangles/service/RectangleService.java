package com.frankdaza.nuvalence.rectangles.service;

import com.frankdaza.nuvalence.rectangles.domain.Line;
import com.frankdaza.nuvalence.rectangles.domain.Rectangle;
import com.frankdaza.nuvalence.rectangles.utils.Utilities;
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
        List<Line> rectangle1Lines = Utilities.getRectangleSideLines(rectangle1);
        List<Line> rectangle2Lines = Utilities.getRectangleSideLines(rectangle2);

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

    @Override
    public boolean isAdjacencyProper(Rectangle rectangle1, Rectangle rectangle2) {
        List<Line> rectangle1Lines = Utilities.getRectangleSideLines(rectangle1);
        List<Line> rectangle2Lines = Utilities.getRectangleSideLines(rectangle2);

        // I'm assuming that the proper adjacency sub-line only could be one
        int adjacencyProperSubLineCounter = 0;

        for (Line rectangle1Line : rectangle1Lines) {
            for (Line rectangle2Line : rectangle2Lines) {
                if (lineService.isLine1EqualsLine2(rectangle1Line, rectangle2Line)) {
                    adjacencyProperSubLineCounter++;
                }
            }
        }

        return adjacencyProperSubLineCounter == 1;
    }

    @Override
    public boolean isPartialAdjacency(Rectangle rectangle1, Rectangle rectangle2) {
        List<Line> rectangle1Lines = Utilities.getRectangleSideLines(rectangle1);
        List<Line> rectangle2Lines = Utilities.getRectangleSideLines(rectangle2);

        // I'm assuming that the partial adjacency sub-line only could be one
        int partialAdjacencySubLineCounter = 0;

        for (Line rectangle1Line : rectangle1Lines) {
            for (Line rectangle2Line : rectangle2Lines) {
                if (lineService.isLine2PartialSubLineOfLine1(rectangle1Line, rectangle2Line)) {
                    partialAdjacencySubLineCounter++;
                }
            }
        }

        return partialAdjacencySubLineCounter == 1;
    }

    @Override
    public boolean hasAdjacency(Rectangle rectangle1, Rectangle rectangle2) {
        return isAdjacencySubLine(rectangle1, rectangle2)
                || isAdjacencyProper(rectangle1, rectangle2)
                || isPartialAdjacency(rectangle1, rectangle2);
    }
}
