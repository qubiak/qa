package pl.qubiak.qa.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.qubiak.qa.Model.Question;


@Repository
public interface QuestionRepository extends CrudRepository<Question, Long> {

}
