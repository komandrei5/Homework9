package app;

public interface StringCollection {
    boolean add(String o);
    boolean add(int index, String o);
    boolean delete(String o);
    String get(int index);
    boolean contain(String o);
    boolean equals(StringCollection str);
    boolean clear();
    int size();
}
