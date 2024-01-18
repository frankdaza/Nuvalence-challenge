package com.frankdaza.jobsity.rectangles.service;

import com.frankdaza.jobsity.rectangles.domain.Point;
import com.frankdaza.jobsity.rectangles.domain.Rectangle;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@DisplayName("Rectangle Service Test")
@SpringBootTest
public class RectangleServiceTest {

    private final RectangleService rectangleService;

    @Autowired
    public RectangleServiceTest(RectangleService rectangleService) {
        this.rectangleService = rectangleService;
    }

    @DisplayName("should create two rectangles and the interception should be true - case 1")
    @Test
    public void interceptionIsTrueCase1() {
        Rectangle rectangle1 = new Rectangle(new Point(1, 3), new Point(3, 1));
        Rectangle rectangle2 = new Rectangle(new Point(2, 4), new Point(4, 1));
        Assertions.assertTrue(rectangleService.isInterception(rectangle1, rectangle2));
    }

    @DisplayName("should create two rectangles and the interception should be true - case 2")
    @Test
    public void interceptionIsTrueCase2() {
        Rectangle rectangle1 = new Rectangle(new Point(1, 6), new Point(9, 2));
        Rectangle rectangle2 = new Rectangle(new Point(5, 3), new Point(8, 1));
        Assertions.assertTrue(rectangleService.isInterception(rectangle1, rectangle2));
    }

    @DisplayName("should create two rectangles and the interception should be false - case 1")
    @Test
    public void interceptionIsFalseCase1() {
        Rectangle rectangle1 = new Rectangle(new Point(1, 3), new Point(3, 1));
        Rectangle rectangle2 = new Rectangle(new Point(4, 6), new Point(6, 4));
        Assertions.assertFalse(rectangleService.isInterception(rectangle1, rectangle2));
    }

    @DisplayName("should create two rectangles and the interception should be false - case 2")
    @Test
    public void interceptionIsFalseCase2() {
        Rectangle rectangle1 = new Rectangle(new Point(2, 5), new Point(6, 3));
        Rectangle rectangle2 = new Rectangle(new Point(-5, 5), new Point(-2, 2));
        Assertions.assertFalse(rectangleService.isInterception(rectangle1, rectangle2));
    }

    @DisplayName("should create two rectangles and the containment should be true - case 1")
    @Test
    public void containmentIsTrueCase1() {
        Rectangle rectangle1 = new Rectangle(new Point(1, 6), new Point(7, 2));
        Rectangle rectangle2 = new Rectangle(new Point(2, 5), new Point(6, 3));
        Assertions.assertTrue(rectangleService.isContainment(rectangle1, rectangle2));
    }

    @DisplayName("should create two rectangles and the containment should be false and the intersection should be false - case 1")
    @Test
    public void containmentIsFalseCase1() {
        Rectangle rectangle1 = new Rectangle(new Point(-2, 5), new Point(2, 2));
        Rectangle rectangle2 = new Rectangle(new Point(3, 4), new Point(8, 2));
        Assertions.assertFalse(rectangleService.isContainment(rectangle1, rectangle2));
        Assertions.assertFalse(rectangleService.isInterception(rectangle1, rectangle2));
    }

    @DisplayName("should create two rectangles the containment should be false and the intersection should be true - case 2")
    @Test
    public void containmentIsFalseCase2() {
        Rectangle rectangle1 = new Rectangle(new Point(-2, 5), new Point(5, 1));
        Rectangle rectangle2 = new Rectangle(new Point(3, 4), new Point(9, 2));
        Assertions.assertFalse(rectangleService.isContainment(rectangle1, rectangle2));
        Assertions.assertTrue(rectangleService.isInterception(rectangle1, rectangle2));
    }

    @DisplayName("should create two rectangles and the adjacency with sub-line should be true - case 1")
    @Test
    public void adjacencyWithSubLineIsTrueCase1() {
        Rectangle rectangle1 = new Rectangle(new Point(1, 7), new Point(5, 1));
        Rectangle rectangle2 = new Rectangle(new Point(5, 5), new Point(8, 3));
        Assertions.assertTrue(rectangleService.isAdjacencySubLine(rectangle1, rectangle2));
    }

    @DisplayName("should create two rectangles and the adjacency with sub-line should not be true - case 1")
    @Test
    public void adjacencyWithSubLineIsFalseCase1() {
        Rectangle rectangle1 = new Rectangle(new Point(1, 7), new Point(5, 1));
        Rectangle rectangle2 = new Rectangle(new Point(5, 7), new Point(8, 1));
        Assertions.assertFalse(rectangleService.isAdjacencySubLine(rectangle2, rectangle1));
    }

    @DisplayName("should create two rectangles and the adjacency with proper sub-line should be true - case 1")
    @Test
    public void adjacencyWithProperSubLineIsTrueCase1() {
        Rectangle rectangle1 = new Rectangle(new Point(1, 6), new Point(4, 1));
        Rectangle rectangle2 = new Rectangle(new Point(4, 6), new Point(6, 1));
        Assertions.assertTrue(rectangleService.isAdjacencyProper(rectangle1, rectangle2));
    }

    @DisplayName("should create two rectangles and the adjacency with proper sub-line should not be true - case 1")
    @Test
    public void adjacencyWithProperSubLineIsFalseCase1() {
        Rectangle rectangle1 = new Rectangle(new Point(1, 6), new Point(4, 1));
        Rectangle rectangle2 = new Rectangle(new Point(4, 8), new Point(7, 4));
        Assertions.assertFalse(rectangleService.isAdjacencyProper(rectangle2, rectangle1));
    }

    @DisplayName("should create two rectangles and the partial adjacency should be true - case 1")
    @Test
    public void partialAdjacencyIsTrueCase1() {
        Rectangle rectangle1 = new Rectangle(new Point(-3, 4), new Point(4, 1));
        Rectangle rectangle2 = new Rectangle(new Point(2, 6), new Point(8, 4));
        Assertions.assertTrue(rectangleService.isPartialAdjacency(rectangle1, rectangle2));
    }
}
