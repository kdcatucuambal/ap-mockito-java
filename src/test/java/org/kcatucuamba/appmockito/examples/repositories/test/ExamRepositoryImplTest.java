package org.kcatucuamba.appmockito.examples.repositories.test;

import junit.framework.Assert;
import org.junit.jupiter.api.Test;
import org.kcatucuamba.appmockito.examples.models.Exam;
import org.kcatucuamba.appmockito.examples.repositories.ExamRepositoryImpl;

import java.util.List;

public class ExamRepositoryImplTest {
    @Test
    public void findAll() {
        ExamRepositoryImpl repository = new ExamRepositoryImpl();
        List<Exam> exams = repository.findAll();
        Assert.assertNotNull(exams);
        Assert.assertEquals(3, exams.size());
    }
}
