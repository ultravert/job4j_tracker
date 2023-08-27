package ru.job4j.hmap;

import java.util.*;

public class AnalyzeByMap {
    public static double averageScore(List<Pupil> pupils) {
        double sum = 0;
        int count = 0;
        for (Pupil pupil : pupils) {
            for (Subject subj : pupil.subjects()) {
                sum += subj.score();
                count++;
            }
        }
        return sum / count;
    }

    public static List<Label> averageScoreByPupil(List<Pupil> pupils) {
        List<Label> rsl = new ArrayList<>();
        for (Pupil pupil : pupils) {
            double sum = 0;
            int count = 0;
            for (Subject subj : pupil.subjects()) {
                sum += subj.score();
                count++;
            }
            sum /= count;
            rsl.add(new Label(pupil.name(), sum));
        }
        return rsl;
    }

    public static List<Label> averageScoreBySubject(List<Pupil> pupils) {
        Map<String, Integer> temp = new LinkedHashMap<>();
        int count = 0;
        for (Pupil pupil : pupils) {
            for (Subject subj : pupil.subjects()) {
                temp.put(subj.name(), temp.getOrDefault(subj.name(), 0) + subj.score());
            }
            count++;
        }
        List<Label> rsl = new ArrayList<>();
        for (String name : temp.keySet()) {
            int score = temp.get(name) / count;
            rsl.add(new Label(name, score));
        }
        return rsl;
    }

    public static Label bestStudent(List<Pupil> pupils) {
        double sum = 0;
        List<Label> rsl = new ArrayList<>();
        for (Pupil pupil : pupils) {
            for (Subject subj : pupil.subjects()) {
                sum += subj.score();
            }
            rsl.add(new Label(pupil.name(), sum));
            sum = 0;
        }
        rsl.sort(Comparator.naturalOrder());
        return rsl.get(rsl.size() - 1);
    }

    public static Label bestSubject(List<Pupil> pupils) {
        Map<String, Integer> temp = new LinkedHashMap<>();
        for (Pupil pupil : pupils) {
            for (Subject subj : pupil.subjects()) {
                temp.put(subj.name(), temp.getOrDefault(subj.name(), 0) + subj.score());
            }
        }
        List<Label> rsl = new ArrayList<>();
        for (String name : temp.keySet()) {
            int score = temp.get(name);
            rsl.add(new Label(name, score));
        }
        rsl.sort(Comparator.naturalOrder());
        return rsl.get(temp.size() - 1);
    }
}