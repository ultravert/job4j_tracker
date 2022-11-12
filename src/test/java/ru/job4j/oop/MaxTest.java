package ru.job4j.oop;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

class MaxTest {

    @Test
    void when10and11then11() {
        int first = 10;
        int second = 11;
        int rsl = Max.max(first, second);
        int expected = 11;
        assertThat(rsl).isEqualTo(expected);
    }

    @Test
    void when1and2and2() {
        int first = 1;
        int second = 2;
        int third = 2;
        int rsl = Max.max(first, second, third);
        int expected = 2;
        assertThat(rsl).isEqualTo(expected);

    }

    @Test
    void when3and5and7and7() {
        int first = 3;
        int second = 5;
        int third = 7;
        int fourth = 7;
        int rsl = Max.max(first, second, third, fourth);
        int expected = 7;
        assertThat(rsl).isEqualTo(expected);
    }
}