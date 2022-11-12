package ru.job4j.oop;

import org.assertj.core.data.Percentage;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

class PointTest {

    @Test
    public void when00to20then2() {
        Point point = new Point(0, 0);
        Point point1 = new Point(2, 0);
        point.distance(point1);
        double expected = 2;
        assertThat(point.distance(point1)).isEqualTo(expected);
    }

    @Test
    public void when05to00then5() {
        Point point = new Point(0, 5);
        Point point1 = new Point(0, 0);
        point.distance(point1);
        double expected = 5;
        assertThat(point.distance(point1)).isEqualTo(expected);
    }

    @Test
    public void when10to60then5() {
        Point point = new Point(1, 0);
        Point point1 = new Point(6, 0);
        point.distance(point1);
        double expected = 5;
        assertThat(point.distance(point1)).isEqualTo(expected);
    }

    @Test
    public void when02to22then2() {
        Point point = new Point(0, 2);
        Point point1 = new Point(2, 2);
        point.distance(point1);
        double expected = 2;
        assertThat(point.distance(point1)).isEqualTo(expected);
    }

    @Test
    public void when000to111then1dot7() {
        Point first = new Point(0, 0, 0);
        Point second = new Point(1, 1, 1);
        first.distance3d(second);
        double expected = 1.7;
        assertThat(first.distance3d(second)).isCloseTo(expected, Percentage.withPercentage(99));
    }
    @Test
    public void when000to100then1() {
        Point first = new Point(0, 0, 0);
        Point second = new Point(0, 2, 0);
        first.distance3d(second);
        double expected = 2;
        assertThat(first.distance3d(second)).isCloseTo(expected, Percentage.withPercentage(99));
    }
}
