package at.ac.uibk.pm.gXX.zidUsername.sheet10.ex02;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ListSet<T> {

    private List<T> elements = null;

    private int s = 0;

    public ListSet() {
        elements = new ArrayList<>();
    }

    private ListSet(List<T> elements) {
        this.elements = elements;
    }

    public void add(Object element) {
        if (!contains(element)) {
            elements.add((T) element);
            s++;
        }
    }

    public void addAll(Collection<T> elements) {
        elements.addAll(elements);
        s += this.elements.size();
    }

    public boolean isEmpty() {
        return elements == null;
    }

    public boolean contains(Object element) {
        for (T t : elements) {
            if (element == t) {
                return true;
            }
        }
        return false;
    }

    public String toString() {
        String result = "";
        for (int i = 0; i < elements.size(); i++) {
            result += elements.remove(i);
            result += " ";
        }
        return result;
    }

    public ListSet<T> clone() {
        return new ListSet<>(elements);
    }

    public void removeAll(Collection<T> toRemove) {
        elements.clear();
    }

    public int size() {
        return s;
    }


}
