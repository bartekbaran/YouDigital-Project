package pl.bbaran.youdigitalproject.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.bbaran.youdigitalproject.model.Word;
import pl.bbaran.youdigitalproject.repository.WordsRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class WordService {
    private final WordsRepository wordsRepository;

    public List<Word> getWords() {
        return wordsRepository.findAll();
    }

    public Word getSingleWord(long id) {
        return wordsRepository.findById(id).orElseThrow(NullPointerException::new);
    }

    public Word addWord(Word word) {
        return wordsRepository.save(word);
    }

    public void deleteWordById(long checkedId) {
        wordsRepository.deleteById(checkedId);
    }

    public long countByWord(String word) {
        return wordsRepository.countByWord(word);
    }
}
