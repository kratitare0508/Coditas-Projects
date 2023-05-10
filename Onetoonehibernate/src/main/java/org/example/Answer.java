package org.example;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="answer")
public class Answer {
    @Id
    private int answerId;
    private String answer;
@OneToOne(mappedBy = "answer")
    public Question getQ() {
        return q;
    }

    public void setQ(Question q) {
        this.q = q;
    }

    @OneToOne
    private Question q;

    public Answer(int answerId, String answer) {
        this.answerId = answerId;
        this.answer = answer;
    }
     public Answer()
    {
    super();
    }

    public int getAnswerId() {
        return answerId;
    }

    public void setAnswerId(int answerId) {
        this.answerId = answerId;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }




}