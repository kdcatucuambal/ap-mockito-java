package org.kcatucuamba.appmockito.examples.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.kcatucuamba.appmockito.examples.models.Exam;
import org.kcatucuamba.appmockito.examples.repositories.ExamRepository;
import org.kcatucuamba.appmockito.examples.repositories.QuestionRepository;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.stubbing.Answer;

import java.util.Collections;
import java.util.List;

import static org.mockito.ArgumentMatchers.isNull;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class ExamServiceImplTest {

    @Mock
    ExamRepository examRepository;

    @Mock
    QuestionRepository questionRepository;
    @InjectMocks
    ExamServiceImpl service;

    // Execute before each test
    @BeforeEach
    void setUp() {
        //MockitoAnnotations.openMocks(this);
        //This is the mock, we are mocking the ExamRepository
        // repository = mock(ExamRepository.class);
        //questionRepository = mock(QuestionRepository.class);
        //service = new ExamServiceImpl(repository, questionRepository);
    }


    @Test
    void findExamByName() {
        //We are telling the mock to return the list of exams when the method findAll is called
        Mockito.when(examRepository.findAll()).thenReturn(Data.EXAMS);
        Exam examFound = service.findExamByName("Math");
        assertNotNull(examFound);
        assertEquals(5L, examFound.getId());
        assertEquals("Math", examFound.getName());
    }

    @Test
    void findExamByNameEmptyList() {
        List<Exam> exams = Collections.emptyList();
        //We are telling the mock to return the list of exams when the method findAll is called
        Mockito.when(examRepository.findAll()).thenReturn(exams);
        Exam examFound = service.findExamByName("Math");
        assertNull(examFound);
    }

    @Test
    void testQuestionsByName() {

        Mockito.when(examRepository.findAll()).thenReturn(Data.EXAMS);
        Mockito.when(questionRepository.findQuestionsByExamId(Mockito.anyLong())).thenReturn(Data.QUESTIONS);

        Exam examFound = service.findExamByNameWithQuestions("Physics");

        assertEquals(4, examFound.getQuestions().size());
        assertTrue(examFound.getQuestions().contains("A + B ?"));
    }

    @Test
    void testQuestionsByNameVerify() {

        Mockito.when(examRepository.findAll()).thenReturn(Data.EXAMS);
        Mockito.when(questionRepository.findQuestionsByExamId(Mockito.anyLong())).thenReturn(Data.QUESTIONS);

        Exam examFound = service.findExamByNameWithQuestions("Physics");

        assertEquals(4, examFound.getQuestions().size());
        assertTrue(examFound.getQuestions().contains("A + B ?"));

        //Verify that the method findAll from the repository was called
        Mockito.verify(examRepository).findAll();
        //Verify that the method findQuestionsByExamId from the questionRepository was called
        Mockito.verify(questionRepository).findQuestionsByExamId(Mockito.anyLong());
    }


    @Test
    void testNoExistsExamVerify() {

        Mockito.when(examRepository.findAll()).thenReturn(Collections.emptyList());
        //Mockito.when(questionRepository.findQuestionsByExamId(Mockito.anyLong())).thenReturn(Data.QUESTIONS);

        Exam examFound = service.findExamByNameWithQuestions("Physics");

        assertNull(examFound);
        Mockito.verify(examRepository).findAll();
        Mockito.verify(questionRepository, Mockito.never()).findQuestionsByExamId(Mockito.anyLong());

    }

    @Test
    void testSaveExam() {

        //Given
        Exam newExam = Data.EXAM;
        newExam.setQuestions(Data.QUESTIONS);

        Mockito.when(examRepository.save(Mockito.any(Exam.class))).then(new Answer<Exam>() {
            Long sequence = 8L;

            @Override
            public Exam answer(InvocationOnMock invocation) throws Throwable {
                Exam exam = invocation.getArgument(0);
                exam.setId(sequence++);
                return exam;
            }
        });


        //When
        Exam exam = service.save(newExam);

        //Then
        assertNotNull(exam);
        assertEquals(8L, exam.getId());
        assertEquals("Programming", exam.getName());

        Mockito.verify(examRepository).save(Mockito.any(Exam.class));

        Mockito.verify(questionRepository).save(Mockito.anyList());
    }

    @Test
    void testHandlerException() {
        Mockito.when(examRepository.findAll()).thenReturn(Data.EXAMS_ID_NULL);
        Mockito.when(questionRepository.findQuestionsByExamId(isNull()))
                .thenThrow(IllegalArgumentException.class);

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            service.findExamByNameWithQuestions("Physics");
        });

        assertEquals(IllegalArgumentException.class, exception.getClass());

        verify(examRepository).findAll();
        verify(questionRepository).findQuestionsByExamId(isNull());


    }
}