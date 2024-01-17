package com.frankdaza.jobsity.rectangles.service;

import com.frankdaza.jobsity.rectangles.domain.Rectangle;
import org.springframework.stereotype.Service;

@Service
public class RectangleService {

    public boolean isInterception(Rectangle rectangle1, Rectangle rectangle2) {
        return rectangle1.getUpperLeft().getX() <= rectangle2.getLowerRight().getX()
                && rectangle2.getUpperLeft().getX() <= rectangle1.getLowerRight().getX();
    }
}
