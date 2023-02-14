import java.util.*;

public class UniqueCharacterCountSolution {
    static class WordCountPair implements Comparable<WordCountPair> {
        String word;
        Integer distinctCharacters;

        public WordCountPair(String word, Integer distinctCharacters) {
            this.word = word;
            this.distinctCharacters = distinctCharacters;
        }

        @Override
        public String toString() {
            return word + " " + distinctCharacters;
        }

        @Override
        public int compareTo(WordCountPair o) {
            if (this.distinctCharacters > o.distinctCharacters) {
                return -1;
            } else if (this.distinctCharacters.equals(o.distinctCharacters)){
                return 0;
            }
            return 1;
        }
    }

    public static void main(String[] args) {
        String test = """
                Lorem ipsum dolor sit amet, consectetur adipiscing elit.
                Etiam ullamcorper consectetur orci, vel vehicula magna euismod nec.
                Etiam lacus felis, porttitor non lorem in, posuere rutrum ipsum.
                Etiam varius pellentesque sapien tempus finibus.
                Vestibulum rutrum, lacus et egestas faucibus, justo velit dignissim purus, a tempor ex velit at felis.
                Suspendisse et libero feugiat, vestibulum ex a, volutpat neque.
                In et molestie enim.
                Suspendisse tincidunt fringilla libero, ut hendrerit magna sagittis nec.
                Cras sodales augue dui, vitae rutrum ipsum consectetur eget.
                Aliquam erat volutpat.
                Vestibulum sed laoreet ante.
                Quisque hendrerit tincidunt sodales.
                Vivamus vel eros sodales, feugiat lectus et, vehicula ante.
                """;
        System.out.println(wordsSortedByDistinctCharacters(test));
    }

    //solution assumes uppercase letters are distinct from lowercase letters
    public static List<WordCountPair> wordsSortedByDistinctCharacters(String string) {
        String[] words = string.replaceAll("[^a-zA-Z ]", " ").split("\\s+");
        Set<String> distinctWords = new HashSet<>(List.of(words));
        Map<String, Set<Character>> wordUniqueCharsMap = new HashMap<>(); // maps a word to its set of unique characters
        for (String s : distinctWords) {
            wordUniqueCharsMap.put(s, new HashSet<>());
            char[] chars = s.toCharArray();
            for (char c : chars) {
                wordUniqueCharsMap.get(s).add(c);
            }
        }
        List<WordCountPair> wordUniqueCharsCountPairs = new ArrayList<>();
        for (String s : distinctWords) {
            //take size of set of unique characters to get number of unique characters
            wordUniqueCharsCountPairs.add(new WordCountPair(s, wordUniqueCharsMap.get(s).size()));
        }
        wordUniqueCharsCountPairs.sort(WordCountPair::compareTo);
        return wordUniqueCharsCountPairs;
    }
}
