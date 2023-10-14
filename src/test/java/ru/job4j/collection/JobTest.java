package ru.job4j.collection;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class JobTest {
    @Test
    void whenJobAscByName() {
        List<Job> jobs = Arrays.asList(
                new Job("Fix bug", 2),
                new Job("Write test", 3),
                new Job("Find bug", 1),
                new Job("X task", 0)
        );
        List<Job> expected = Arrays.asList(
                new Job("Find bug", 1),
                new Job("Fix bug", 2),
                new Job("Write test", 3),
                new Job("X task", 0)
        );
        jobs.sort(new JobAscByName());
        assertThat(jobs).isEqualTo(expected);
    }

    @Test
    void whenJobDescByName() {
        List<Job> jobs = Arrays.asList(
                new Job("Fix bug", 2),
                new Job("Write test", 3),
                new Job("Find bug", 1),
                new Job("X task", 0)
        );
        List<Job> expected = Arrays.asList(
                new Job("X task", 0),
                new Job("Write test", 3),
                new Job("Fix bug", 2),
                new Job("Find bug", 1)
        );
        jobs.sort(new JobDescByName());
        assertThat(jobs).isEqualTo(expected);
    }

    @Test
    void whenJobAscByPriority() {
        List<Job> jobs = Arrays.asList(
                new Job("Fix bug", 2),
                new Job("Write test", 3),
                new Job("Find bug", 1),
                new Job("X task", 0)
        );
        List<Job> expected = Arrays.asList(
                new Job("X task", 0),
                new Job("Find bug", 1),
                new Job("Fix bug", 2),
                new Job("Write test", 3)
        );
        jobs.sort(new JobAscByPriority());
        assertThat(jobs).isEqualTo(expected);
    }

    @Test
    void whenJobDescByPriority() {
        List<Job> jobs = Arrays.asList(
                new Job("Fix bug", 2),
                new Job("Write test", 3),
                new Job("Find bug", 1),
                new Job("X task", 0)
        );
        List<Job> expected = Arrays.asList(
                new Job("Write test", 3),
                new Job("Fix bug", 2),
                new Job("Find bug", 1),
                new Job("X task", 0)
        );
        jobs.sort(new JobDescByPriority());
        assertThat(jobs).isEqualTo(expected);
    }

    @Test
    public void whenComparatorDescByNameAndPriority() {
        Comparator<Job> cmpNamePriority = new JobDescByName().thenComparing(new JobDescByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl).isLessThan(0);
    }

    @Test
    public void whenComparatorAscByNameAndPriority() {
        Comparator<Job> cmpNamePriority = new JobAscByName().thenComparing(new JobAscByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl).isGreaterThan(0);
    }
}