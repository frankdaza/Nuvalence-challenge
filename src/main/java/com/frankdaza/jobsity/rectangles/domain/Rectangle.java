package com.frankdaza.jobsity.rectangles.domain;

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
}
