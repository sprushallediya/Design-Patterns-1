package assignment01;

import java.util.List;

public class ClassAdapter<E extends Comparable<? super E>> extends SortedList<E> implements SortedSet<E> {

    @Override
    public void add(E e) {
        if (asList().stream().noneMatch(existing -> existing.equals(e))) {
            super.add(e);
        }
    }

    @Override
    public boolean contains(E e) {
        return super.contains(e);
    }

    @Override
    public boolean remove(E e) {
        return super.remove(e);
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public List<E> asList() {
        return super.asList();
    }

    @Override
    public int size() {
        return super.size();
    }
}
