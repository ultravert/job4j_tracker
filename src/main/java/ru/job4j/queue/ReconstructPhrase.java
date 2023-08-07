package ru.job4j.queue;

import java.util.Deque;
import java.util.Iterator;

public class ReconstructPhrase {

    private final Deque<Character> descendingElements;

    private final Deque<Character> evenElements;

    public ReconstructPhrase(Deque<Character> descendingElements, Deque<Character> evenElements) {
        this.descendingElements = descendingElements;
        this.evenElements = evenElements;
    }

    private String getEvenElements() {
        StringBuilder rsl = new StringBuilder();
        int count = 0;
        Iterator<Character> iterator = evenElements.iterator();
        while (iterator.hasNext()) {
            if (count % 2 == 0) {
                rsl = rsl.append(iterator.next());
            } else {
                iterator.next();
            }
            count++;
        }
        return rsl.toString();
    }

    private String getDescendingElements() {
        StringBuilder rsl = new StringBuilder();
        Iterator<Character> iterator = descendingElements.descendingIterator();
        while (iterator.hasNext()) {
            rsl = rsl.append(iterator.next());
        }
        return rsl.toString();
    }

    public String getReconstructPhrase() {
        return getEvenElements() + getDescendingElements();
    }
}