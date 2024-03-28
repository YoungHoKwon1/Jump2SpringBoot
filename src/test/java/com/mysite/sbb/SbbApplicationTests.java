package com.mysite.sbb;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.mysite.sbb.answer.Answer;
import com.mysite.sbb.question.Question;
import com.mysite.sbb.question.QuestionRepository;
import com.mysite.sbb.question.QuestionService;

@SpringBootTest
class SbbApplicationTests {

    @Autowired
    // private QuestionRepository questionRepository;
    private QuestionService questionService;

    // @Transactional
    // @Transactional 애너테이션을 사용하면 메서드가 종료될 때까지 DB 세션이 유지된다
    @Test
    void testJpa() {
        // Optional<Question> oq = this.questionRepository.findById(2);
        // assertTrue(oq.isPresent());
        // Question q = oq.get();

        // List<Answer> answerList = q.getAnswerList();

        // assertEquals(1, answerList.size());
        // assertEquals("네 자동으로 생성됩니다.", answerList.get(0).getContent());

        // test data 300개 생성
        for (int i = 1; i <= 300; i++) {
            String subject = String.format("test data:[%03d]", i);
            String content = "내용 무";
            this.questionService.create(subject, content, null);
        }
    }
}
