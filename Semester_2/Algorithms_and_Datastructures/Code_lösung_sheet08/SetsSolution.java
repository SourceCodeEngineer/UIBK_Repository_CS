import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public final class SetsSolution {
    public static void main(String[] args) {
        final Set<Integer> emptySet = new HashSet<>();
        final Set<Integer> set1 = new HashSet<>(Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9));
        final Set<Integer> set2 = new HashSet<>(Arrays.asList(0, 1, 2));
        final Set<Integer> set3 = new HashSet<>(Arrays.asList(2, 3, 4));
        final Set<Integer> set4 = new HashSet<>(Arrays.asList(10, 11, 12));

        System.out.println("Intersections");
        System.out.println(intersection(emptySet, set1));
        System.out.println(intersection(set1, set2));
        System.out.println(intersection(set2, set3));
        System.out.println(intersection(set1, set4));

        System.out.println("Unions");
        System.out.println(union(emptySet, set1));
        System.out.println(union(set1, set2));
        System.out.println(union(set2, set3));
        System.out.println(union(set1, set4));

        System.out.println("Differences");
        System.out.println(difference(emptySet, set1));
        System.out.println(difference(set1, emptySet));
        System.out.println(difference(set1, set2));
        System.out.println(difference(set2, set1));
        System.out.println(difference(set2, set3));
        System.out.println(difference(set3, set2));
        System.out.println(difference(set1, set4));
        System.out.println(difference(set4, set1));

        System.out.println("Symmetric differences");
        System.out.println(symmetricDifference(emptySet, set1));
        System.out.println(symmetricDifference(set1, set2));
        System.out.println(symmetricDifference(set2, set3));
        System.out.println(symmetricDifference(set3, set1));
        System.out.println(symmetricDifference(set3, set4));
        System.out.println(symmetricDifference(set1, set4));
    }

    // do not change the input sets
    public static Set<Integer> intersection(final Set<Integer> set1, final Set<Integer> set2) {
        Set<Integer> intersection = new HashSet<>();
        for (Integer x : set1) {
            if (set2.contains(x)) {
                intersection.add(x);
            }
        }
        return intersection;
    }

    // do not change the input sets
    public static Set<Integer> union(final Set<Integer> set1, final Set<Integer> set2) {
        Set<Integer> union = new HashSet<>();
        for (Integer x : set1) {
            union.add(x);
        }
        for (Integer x : set2) {
            union.add(x);
        }
        return union;
        // alternatively: union.addAll(set1); union.addAll(set2);
    }

    // do not change the input sets
    public static Set<Integer> difference(final Set<Integer> set1, final Set<Integer> set2) {
        Set<Integer> difference = new HashSet<>();
        for (Integer x : set1) {
            if (!set2.contains(x)) {
                difference.add(x);
            }
        }
        return difference;
        // alternatively: create copy of set1 and remove every item in set2 from copy
    }

    // do not change the input sets
    public static Set<Integer> symmetricDifference(final Set<Integer> set1, final Set<Integer> set2) {
        return difference(union(set1, set2), intersection(set1, set2));
    }
}
