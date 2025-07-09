package assignment01;

import java.util.List;

public class ObjectAdapter<E extends Comparable<? super E>> implements SortedSet<E> {
    private SortedList<E> adaptee;

    public ObjectAdapter(SortedList<E> adapteeIn) {
        adaptee = adapteeIn;
    }

    @Override
    public void add(E e) {
        if (adaptee.asList().stream().noneMatch(existing -> existing.equals(e))) {
            adaptee.add(e);
        }
    }

    @Override
    public boolean contains(E e) {
        return adaptee.contains(e);
    }

    @Override
    public boolean remove(E e) {
        return adaptee.remove(e);
    }

    @Override
    public String toString() {
        return adaptee.toString();
    }

    @Override
    public List<E> asList() {
        return adaptee.asList();
    }

    @Override
    public int size() {
        return adaptee.size();
    }
}
