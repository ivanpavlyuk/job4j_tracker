package ru.job4j.map;

import java.util.*;

public class AnalyzeByMap {
    public static double averageScore(List<Pupil> pupils) {
        int count = 0;
        double rsl = 0;
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                rsl += subject.score();
                count++;
            }
        }
        return rsl / count;
    }

    public static List<Label> averageScoreByPupil(List<Pupil> pupils) {
        List<Label> list = new ArrayList<>();
        for (Pupil pupil : pupils) {
            int count = 0;
            double rsl = 0;
            for (Subject subject : pupil.subjects()) {
                rsl += subject.score();
                count++;
            }
            list.add(new Label(pupil.name(), rsl / count));
        }
        return list;
    }

    public static List<Label> averageScoreBySubject(List<Pupil> pupils) {
        HashMap<String, Integer> map = new LinkedHashMap<>();
        List<Label> list = new ArrayList<>();
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                if (!map.containsKey(subject.name())) {
                    map.put(subject.name(), 0);
                }
                map.put(subject.name(), map.get(subject.name()) + subject.score());
            }
        }
        for (String key : map.keySet()) {
            list.add(new Label(key, (double) map.get(key) / pupils.size()));
        }
        return list;
    }

    public static Label bestStudent(List<Pupil> pupils) {
        List<Label> list = new ArrayList<>();
        for (Pupil pupil : pupils) {
            int rsl = 0;
            for (Subject subject : pupil.subjects()) {
                rsl += subject.score();
            }
            list.add(new Label(pupil.name(), rsl));
        }
        list.sort(Comparator.naturalOrder());
        return list.get(list.size() - 1);
    }

    public static Label bestSubject(List<Pupil> pupils) {
        HashMap<String, Integer> map = new LinkedHashMap<>();
        List<Label> list = new ArrayList<>();
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                map.merge(subject.name(), subject.score(), Integer::sum);
            }
        }
        for (String key : map.keySet()) {
            list.add(new Label(key, map.get(key)));
        }
        list.sort(Comparator.naturalOrder());
        return list.get(list.size() - 1);
    }
}