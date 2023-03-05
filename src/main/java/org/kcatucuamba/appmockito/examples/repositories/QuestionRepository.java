package org.kcatucuamba.appmockito.examples.repositories;

import java.util.List;

public interface QuestionRepository {
    List<String> findQuestionsByExamId(Long id);

    void save(List<String> questions);
}
