package pl.bbaran.youdigitalproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.bbaran.youdigitalproject.model.Word;

@Repository
public interface WordsRepository extends JpaRepository<Word, Long> {
    long countByWord(String word);
}
