import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InvertedIndexSolution {
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
        System.out.println(invertedIndex(test));
    }

    public static Map<String, List<Integer>> invertedIndex(String string) {
        String[] lines = string.split("\\n");
        Map<String, List<Integer>> invertedIndex = new HashMap<>();
        int i = 0;
        for (String line : lines) {
            String[] words = line.replaceAll("[^a-zA-Z ]", " ").split("\\s+");
            for (String s : words) {
            	System.out.println(s);
                if (invertedIndex.containsKey(s)) {
                    invertedIndex.get(s).add(i);
                } else {
                    List<Integer> list = new ArrayList<>();
                    list.add(i);
                    invertedIndex.put(s, list);
                }
            }
            i++;
        }
        return invertedIndex;
    }
}
