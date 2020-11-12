package pl.qubiak.qa.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.qubiak.qa.Model.Answer;

@Repository
public interface AnswerRepository extends CrudRepository<Answer, Long> {
}
