package app;

public class Main {
    public static void main(String[] args) {
        StringCollection collection = new StringCollectionImpl();

        collection.add("Hi");
        collection.add("World");
        collection.add(1, "?????");
        int size = collection.size();
        System.out.println("Size: " + size);
        System.out.println(collection.get(1));
        System.out.println(collection.get(2));
        collection.delete("World");
        System.out.println(collection.get(1));
        collection.contain("Hi");
        collection.contain("1");
        collection.equals(collection);
        collection.clear();
        size = collection.size();
        System.out.println("Size: " + size);
    }
}
