package org.kcatucuamba.appmockito.examples.models;

import junit.framework.Assert;
import org.junit.jupiter.api.Test;


class ExamTest {

    @Test
    void testExam() {
        Exam exam = new Exam(5L, "Math");
        Assert.assertNotNull(exam);
    }

}
