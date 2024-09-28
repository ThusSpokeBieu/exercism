import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.Collectors;

class ParallelLetterFrequency {

    private final String[] texts;

    ParallelLetterFrequency(String[] texts) {
        this.texts = texts;
    }

    Map<Character, Integer> countLetters() {
        Map<Character, Integer> frequencyMap = new ConcurrentHashMap<>();
      try (ExecutorService executor = Executors.newVirtualThreadPerTaskExecutor()) {

        List<Future<Map<Character, Integer>>> futures = Arrays.stream(texts)
            .map(text -> executor.submit(() -> countLettersInText(text)))
            .toList();

        for (Future<Map<Character, Integer>> future : futures) {
            Map<Character, Integer> localCount = future.get();
            localCount.forEach((key, value) ->
                frequencyMap.merge(key, value, Integer::sum));
        }
      } catch (ExecutionException | InterruptedException e) {
          throw new RuntimeException(e);
      }

      return frequencyMap;
    }

    private Map<Character, Integer> countLettersInText(String text) {
        return text.toLowerCase()
            .chars()
            .mapToObj(c -> (char) c)
            .filter(Character::isLetter)
            .collect(Collectors.toConcurrentMap(
                c -> c,
                c -> 1,
                Integer::sum));
    }


}
