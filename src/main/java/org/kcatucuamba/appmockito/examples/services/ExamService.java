package org.kcatucuamba.appmockito.examples.services;

import org.kcatucuamba.appmockito.examples.models.Exam;

public interface ExamService {

    Exam findExamByName(String name);

    Exam findExamByNameWithQuestions(String name);

    Exam save(Exam exam);



}
