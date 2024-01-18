package com.frankdaza.nuvalence.rectangles.service;

import com.frankdaza.nuvalence.rectangles.domain.Line;

public interface ILineService {

    /**
     * Verify if two lines are equals.
     * @param line1 Line 1
     * @param line2 Line 2
     * @return true if the lines are equals, false otherwise.
     */
    boolean isLine1EqualsLine2(Line line1, Line line2);


    /**
     * Verify if line 2 is sub-line of line 1.
     * @param line1 Line 1
     * @param line2 Line 2
     * @return true if line 2 is sub-line of line 1, false otherwise.
     */
    boolean isLine2SubLineOfLine1(Line line1, Line line2);


    /**
     * Verify if line 2 is partial sub-line of line 1.
     * @param line1 Line 1
     * @param line2 Line 2
     * @return true if line 2 is partial sub-line of line 1, false otherwise.
     */
    boolean isLine2PartialSubLineOfLine1(Line line1, Line line2);
}
