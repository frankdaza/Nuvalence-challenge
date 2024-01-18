package com.frankdaza.nuvalence.rectangles.domain;

import java.util.Objects;

public class Rectangle {
        private Point upperLeft;
        private Point lowerRight;

        public Rectangle(Point upperLeft, Point lowerRight) {
                this.upperLeft = upperLeft;
                this.lowerRight = lowerRight;
        }

        public Point getUpperLeft() {
                return upperLeft;
        }

        public void setUpperLeft(Point upperLeft) {
                this.upperLeft = upperLeft;
        }

        public Point getLowerRight() {
                return lowerRight;
        }

        public void setLowerRight(Point lowerRight) {
                this.lowerRight = lowerRight;
        }

        @Override
        public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;
                Rectangle rectangle = (Rectangle) o;
                return Objects.equals(upperLeft, rectangle.upperLeft) && Objects.equals(lowerRight, rectangle.lowerRight);
        }

        @Override
        public int hashCode() {
                return Objects.hash(upperLeft, lowerRight);
        }
}
