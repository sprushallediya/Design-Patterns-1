# Design Patterns – Assignment 1 (Rushalle Diya S P)

## Objective
The goal of this assignment was to implement the **Adapter Pattern** using both **Object Adapter** and **Class Adapter** approaches to adapt a `SortedList` into a `SortedSet` interface.

---

## Project Structure

```
assignment01/
├── ClassAdapter.java
├── ObjectAdapter.java
├── SortedList.java
├── SortedSet.java
├── SampleComparable.java
├── Driver.java
├── Tester.java
```

---

## Part 1: Modifications as Instructed

### In `SortedList.java`
Added the following methods:
```java
@Override
public String toString() {
    return internalList.toString();
}

public List<E> asList() {
    return internalList;
}

public int size() {
    return internalList.size();
}
```

---

### In `SampleComparable.java`
Added the following method:
```java
public static void resetNEXT_ID() {
    NEXT_ID = 0;
}
```

---

## Part 2: Adapter Pattern Implementation

### Created the `SortedSet` Interface:
```java
public interface SortedSet<E extends Comparable<? super E>> {
    void add(E e);
    boolean contains(E e);
    boolean remove(E e);
    List<E> asList();
    int size();
}
```

---

### Implemented `ObjectAdapter.java`
- Uses **composition** to adapt a `SortedList` to the `SortedSet` interface.
- Internally holds an instance of `SortedList<E>` and forwards method calls.

---

### Implemented `ClassAdapter.java`
- Uses **inheritance** (extends `SortedList`) and implements `SortedSet`.
- Overrides the `add` method to ensure set behavior (no duplicates using `asList().contains(...)`).

---

## Testing

### `Driver.java`
- Confirms both adapters return correct results with:
  ```bash
  true
  true
  ```

### `Tester.java`
- Prints internal list, test values, and performs various list operations for debugging and verification.

---
