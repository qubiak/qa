package pl.qubiak.qa.Sorting;

import pl.qubiak.qa.Model.Question;

import java.util.Comparator;

public class SortByCounter implements Comparator<Question> {

    public int compare(Question a, Question b) {
        return b.getCounter() - a.getCounter();
    }
}
    

