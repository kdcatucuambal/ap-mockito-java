package org.kcatucuamba.appmockito.examples.repositories;

import org.kcatucuamba.appmockito.examples.models.Exam;

import java.util.List;

public interface ExamRepository {

    List<Exam> findAll();

    Exam save(Exam exam);

}
