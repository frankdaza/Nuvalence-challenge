package com.frankdaza.jobsity.rectangles.service;

import com.frankdaza.jobsity.rectangles.domain.Rectangle;
import org.springframework.stereotype.Service;

@Service
public class RectangleService implements IRectangleService {
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
}
