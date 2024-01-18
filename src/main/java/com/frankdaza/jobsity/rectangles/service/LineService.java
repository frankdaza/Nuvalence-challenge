package com.frankdaza.jobsity.rectangles.service;

import com.frankdaza.jobsity.rectangles.domain.Line;
import com.frankdaza.jobsity.rectangles.utils.Utilities;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class LineService implements ILineService {
    @Override
    public boolean isLine1EqualsLine2(Line line1, Line line2) {
        return line1.getPoint1().getX() == line2.getPoint1().getX()
                && line1.getPoint1().getY() == line2.getPoint1().getY()
                && line1.getPoint2().getX() == line2.getPoint2().getX()
                && line1.getPoint2().getY() == line2.getPoint2().getY();
    }

    @Override
    public boolean isLine2SubLineOfLine1(Line line1, Line line2) {
        if (isLine1EqualsLine2(line1, line2)) {
            return false;
        }

        BigDecimal slopeLine1 = Utilities.getSlopeFromLine(line1.getPoint1(), line1.getPoint2());
        BigDecimal slopeLine2 = Utilities.getSlopeFromLine(line2.getPoint1(), line2.getPoint2());

        if (!slopeLine1.equals(slopeLine2)) {
            return false;
        }

        return line1.getPoint1().getX() <= line2.getPoint1().getX()
                && line1.getPoint1().getY() >= line2.getPoint1().getY()
                && line1.getPoint2().getX() >= line2.getPoint2().getX()
                && line1.getPoint2().getY() <= line2.getPoint2().getY();
    }

    @Override
    public boolean isLine2PartialSubLineOfLine1(Line line1, Line line2) {
        if (isLine1EqualsLine2(line1, line2)) {
            return false;
        }

        BigDecimal slopeLine1 = Utilities.getSlopeFromLine(line1.getPoint1(), line1.getPoint2());
        BigDecimal slopeLine2 = Utilities.getSlopeFromLine(line2.getPoint1(), line2.getPoint2());

        if (!slopeLine1.equals(slopeLine2)) {
            return false;
        }

        // Check if line2 is a vertical line
        if (line2.getPoint1().getX() == line2.getPoint2().getX()) {
            // Check if x-coordinates are the same for both lines
            return line1.getPoint1().getX() == line2.getPoint1().getX();
        }

        // Check if line2 is a horizontal line
        if (line2.getPoint1().getY() == line2.getPoint2().getY()) {
            // Check if y-coordinates are the same for both lines
            return line1.getPoint1().getY() == line2.getPoint1().getY();
        }

        return false;
    }
}
