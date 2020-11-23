package pl.qubiak.qa.Sorting;

import pl.qubiak.qa.Model.QuestionAnswer.Question;

import java.util.Comparator;

public class SortByCounter implements Comparator<Question> {

    public int compare(Question a, Question b) {
        return b.getLike_counter() - a.getLike_counter();
    }
}
    

