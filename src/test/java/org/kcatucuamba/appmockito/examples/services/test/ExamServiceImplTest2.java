package org.kcatucuamba.appmockito.examples.services.test;

import junit.framework.Assert;
import org.junit.jupiter.api.Test;
import org.kcatucuamba.appmockito.examples.models.Exam;
import org.kcatucuamba.appmockito.examples.repositories.ExamRepositoryImpl;
import org.kcatucuamba.appmockito.examples.services.ExamServiceImpl;

import java.util.List;

public class ExamServiceImplTest2 {

    @Test
    void findAllExams() {
        ExamRepositoryImpl repository = new ExamRepositoryImpl();
        List<Exam> exams = repository.findAll();
        Assert.assertNotNull(exams);
        Assert.assertEquals(3, exams.size());
    }
}
