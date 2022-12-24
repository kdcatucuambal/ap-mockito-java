package org.kcatucuamba.appmockito.examples.repositories;

import org.kcatucuamba.appmockito.examples.models.Exam;

import java.util.Arrays;
import java.util.List;

public class ExamRepositoryImpl implements ExamRepository {

    @Override
    public List<Exam> findAll() {

        return Arrays.asList(
                new Exam(5L, "Math"),
                new Exam(6L, "Physics"),
                new Exam(7L, "Chemistry")
        );

    }

    @Override
    public Exam save(Exam exam) {
        return null;
    }

}
