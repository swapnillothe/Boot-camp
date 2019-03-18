package day1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RectangleTest {

    @Test
    void calculateAreaShouldReturnTheArea() throws Exception {
        Rectangle rectangle = new Rectangle(new Dimension(4.0), new Dimension(8.0));
        assertEquals(32.0, rectangle.calculateArea());
    }

    @Test
    void shouldGiveThePerimeterOfTheRectangle() throws Exception {
        Rectangle rectangle = new Rectangle(new Dimension(3.0), new Dimension(2.0));
        assertEquals(10.0, rectangle.calculatePerimeter());
    }
}
