package ru.job4j.tracker;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ItemDescByNameTest {

    @Test
    void whenItemAscByName() {
        List<Item> items = Arrays.asList(
                new Item(3, "Feodor"),
                new Item(2, "Vitaliy"),
                new Item(1, "Mihail")
        );
        List<Item> expected = Arrays.asList(
                new Item(2, "Vitaliy"),
                new Item(1, "Mihail"),
                new Item(3, "Feodor")
        );
        items.sort(new ItemDescByName());
        assertThat(items).isEqualTo(expected);
    }
}