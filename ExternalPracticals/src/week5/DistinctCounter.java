package week5;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class DistinctCounter {
    // data = [] - List<> data = new ArrayList<>();
    // data = set() - Set<> data = new TreeSet<>();
    // data = set() - Set<> data = new HashSet<>();
    // data = {} - Map<Integer, String> data = new HashMap<>();

    private Set<String> distinct = new TreeSet<>();

    public void add(String s) {
        distinct.add(s);
    }

    public int getDistinctCount() {
        return distinct.size();
    }

    public String[] getStrings() {
        return distinct.toArray(new String[0]);
    }

}
