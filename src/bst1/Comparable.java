package bst1;

public interface Comparable<T> 
{
    public int compareTo(T other);

    default boolean greaterThan(T other) { return compareTo(other) >  0; }
    default boolean lessThan   (T other) { return compareTo(other) <  0; }
    default boolean equal      (T other) { return compareTo(other) == 0; }
}
