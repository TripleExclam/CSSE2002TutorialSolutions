package week5;

import java.lang.reflect.Array;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class DistinctCounter {

    private Set<String> distinct = new TreeSet<>();

    public void add(String s) {
        distinct.add(s);
    }

    public int getDistinctCount() {
        return distinct.size();
    }

    public String[] getStrings() {
        return distinct.toArray(new String[] {});
    }

}
