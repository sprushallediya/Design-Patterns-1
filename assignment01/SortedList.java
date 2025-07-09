package assignment01;

import java.util.ArrayList;
import java.util.List;

public class SortedList<E extends Comparable<? super E>> {
    private List<E> internalList = new ArrayList<>();

    public void add(E e) {
        int index = binarySearchInsertIndex(internalList, e);
        internalList.add(index, e);
    }

    // ✅ Fix: Insert new element before elements >= e
    private int binarySearchInsertIndex(List<E> list, E e) {
        int left = 0, right = list.size();
        while (left < right) {
            int mid = (left + right) / 2;
            if (list.get(mid).compareTo(e) >= 0) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    // ✅ Needed for Tester.java test cases
    public int binarySearchHigh(List<E> list, E e) {
        return binarySearchInsertIndex(list, e);
    }

    int binarySearchLow(List<E> list, E e) {
        int left = 0, right = list.size() - 1;
        int result = -1;

        while (left <= right) {
            int mid = (left + right) / 2;
            int cmp = list.get(mid).compareTo(e);

            if (cmp > 0) {
                right = mid - 1;
            } else {
                if (cmp == 0) result = mid;
                left = mid + 1;
            }
        }

        if (result != -1) {
            while (result - 1 >= 0 && list.get(result - 1).equals(e)) {
                result--;
            }
            return result;
        } else {
            return -left - 1;
        }
    }

    public boolean contains(E e) {
        return binarySearchLow(internalList, e) >= 0;
    }

    public boolean remove(E e) {
        int index = binarySearchLow(internalList, e);
        if (index >= 0) {
            internalList.remove(index);
            return true;
        }
        return false;
    }

    public List<E> asList() {
        return internalList;
    }

    public int size() {
        return internalList.size();
    }

    public String toString() {
        return internalList.toString();
    }
}
