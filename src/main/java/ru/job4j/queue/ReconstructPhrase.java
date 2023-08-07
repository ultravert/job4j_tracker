package ru.job4j.queue;

import java.util.Deque;

public class ReconstructPhrase {

    private final Deque<Character> descendingElements;

    private final Deque<Character> evenElements;

    public ReconstructPhrase(Deque<Character> descendingElements, Deque<Character> evenElements) {
        this.descendingElements = descendingElements;
        this.evenElements = evenElements;
    }

    private String getEvenElements() {
        StringBuilder rsl = new StringBuilder();
        for (int i = 0; i < evenElements.size(); i++) {
            if (i % 2 == 0) {
                rsl = rsl.append(evenElements.pollFirst());
                evenElements.offer(evenElements.peekFirst());
            } else {
                evenElements.offer(evenElements.peekFirst());
                evenElements.pollFirst();
            }
        }
        return rsl.toString();
    }

    private String getDescendingElements() {
        StringBuilder rsl = new StringBuilder();
        for (int i = 0; i < descendingElements.size(); i++) {
            rsl = rsl.append(descendingElements.pollLast());
            descendingElements.addFirst(descendingElements.peekLast());
        }
        return rsl.toString();
    }

    public String getReconstructPhrase() {
        return getEvenElements() + getDescendingElements();
    }
}