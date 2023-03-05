package org.kcatucuamba.appmockito.examples.services;

import org.kcatucuamba.appmockito.examples.models.Exam;

import java.util.List;

public class Data {

    public final static List<Exam> EXAMS =  List.of(
            new Exam(5L, "Math"),
            new Exam(6L, "Physics"),
            new Exam(7L, "Chemistry")
    );

    public final static List<Exam> EXAMS_ID_NULL =  List.of(
            new Exam(null, "Math"),
            new Exam(null, "Physics"),
            new Exam(null, "Chemistry")
    );

    public final static List<String> QUESTIONS = List.of(
            "A + B ?",
            "A - B ?",
            "A * B ?",
            "A / B ?"
    );

    public final static Exam EXAM = new Exam(null, "Programming");

}
