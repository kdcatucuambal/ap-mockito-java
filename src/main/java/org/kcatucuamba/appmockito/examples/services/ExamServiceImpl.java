package org.kcatucuamba.appmockito.examples.services;

import org.kcatucuamba.appmockito.examples.models.Exam;
import org.kcatucuamba.appmockito.examples.repositories.ExamRepository;
import org.kcatucuamba.appmockito.examples.repositories.QuestionRepository;

import java.util.List;
import java.util.Optional;

public class ExamServiceImpl implements ExamService {

    private final ExamRepository examRepository;
    private final QuestionRepository questionRepository;


    public ExamServiceImpl(ExamRepository repository, QuestionRepository questionRepository) {
        this.examRepository = repository;
        this.questionRepository = questionRepository;
    }


    @Override
    public Exam findExamByName(String name) {
        return examRepository.findAll()
                .stream()
                .filter(exam -> exam.getName().equals(name))
                .findFirst()
                .orElse(null);
    }

    @Override
    public Exam findExamByNameWithQuestions(String name) {
        Optional<Exam> examOptional = Optional.ofNullable(findExamByName(name));
        Exam exam = null;
        if (examOptional.isPresent()) {
            exam = examOptional.orElseThrow();
            List<String> questions = questionRepository.findQuestionsByExamId(exam.getId());
            exam.setQuestions(questions);
        }
        return exam;
    }

    @Override
    public Exam save(Exam exam) {

        if (!exam.getQuestions().isEmpty()) {
            questionRepository.save(exam.getQuestions());
        }
        return examRepository.save(exam);
    }
}
