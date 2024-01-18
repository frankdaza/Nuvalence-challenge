package com.frankdaza.jobsity.rectangles.service;

import com.frankdaza.jobsity.rectangles.domain.Rectangle;

public interface IRectangleService {

    /**
     * Verify if two rectangles are intersected.
     * @param rectangle1 Rectangle 1
     * @param rectangle2 Rectangle 2
     * @return true if the rectangles are intersected, false otherwise.
     */
    boolean isInterception(Rectangle rectangle1, Rectangle rectangle2);

    /**
     * Verify if one rectangle is contained in another.
     * @param rectangle1 Rectangle 1
     * @param rectangle2 Rectangle 2
     * @return true if the rectangle 2 is contained in rectangle 1, false otherwise.
     */
    boolean isContainment(Rectangle rectangle1, Rectangle rectangle2);

    /**
     * Verify if two rectangles are adjacent with one sub-line.
     * @param rectangle1 Rectangle 1
     * @param rectangle2 Rectangle 2
     * @return true if the rectangles are adjacent with one sub-line, false otherwise.
     */
    boolean isAdjacencySubLine(Rectangle rectangle1, Rectangle rectangle2);
}
