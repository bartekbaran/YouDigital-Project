package pl.bbaran.youdigitalproject.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.bbaran.youdigitalproject.model.Word;
import pl.bbaran.youdigitalproject.service.WordService;

import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class WordController {

    private final WordService wordService;

    @PostMapping("/add")
    public Word addWord(@RequestBody Word word) {
        return wordService.addWord(word);
    }

    @DeleteMapping("/words/{id}")
    public void deleteWordById(@PathVariable long id) {
        wordService.deleteWordById(id);
    }

    @GetMapping("/words/count/{word}")
    public long countByWord(@PathVariable String word) {
        return wordService.countByWord(word);
    }

    @GetMapping("/words/unique")
    public List<Word> findDistinctByWord() {
        List<Word> words = getWords().stream().distinct().collect(Collectors.toList());
        return words;
    }

    // Dodatkowe na potrzeby debugowania
    @GetMapping("/words")
    public List<Word> getWords() {
        return wordService.getWords();
    }

    @GetMapping("/words/{id}")
    public Word getSingleWord(@PathVariable long id) {
        return wordService.getSingleWord(id);
    }
}
