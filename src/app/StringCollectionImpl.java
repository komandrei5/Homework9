package app;

public class StringCollectionImpl implements StringCollection {
    private String[] array;
    private int size;

    public StringCollectionImpl() {
        array = new String[10];
        size = 0;
    }

    @Override
    public boolean add(String o) {
        return add(size, o);
    }

    @Override
    public boolean add(int index, String o) {
        if (index < 0 || index > size) {
            return false;
        }
        if (size == array.length) {
            resizeArray();
        }
        for (int i = size; i > index; i--) {
            array[i] = array[i - 1];
        }
        array[index] = o;
        size++;
        return true;
    }

    @Override
    public boolean delete(String o) {
        for (int i = 0; i < size; i++) {
            if (array[i].equals(o)) {
                System.arraycopy(array, i + 1, array, i, size - i - 1);
                array[size - 1] = null;
                size--;
                return true;
            }
        }
        return false;
    }

    @Override
    public String get(int index) {
        if (index < 0 || index >= size) {
            return null;
        }
        return array[index];
    }

    @Override
    public boolean contain(String o) {
        for (int i = 0; i < size; i++) {
            if (array[i].equals(o)) {
                System.out.println("Contains element: " + o);
                return true;
            }
        }
        System.out.println("Not contains element: " + o);
        return false;
    }

    @Override
    public boolean equals(StringCollection str) {
        if (size != str.size()) {
            System.out.println("Collections have different sizes");
            return false;
        }
        for (int i = 0; i < size; i++) {
            if (!array[i].equals(str.get(i))) {
                System.out.println("Element at index " + i + " is different: " + array[i] + " vs " + str.get(i));
                return false;
            }
        }
        System.out.println("Collections are equal");
        return true;
    }

    @Override
    public boolean clear() {
        for (int i = 0; i < size; i++) {
            array[i] = null;
        }
        size = 0;
        return true;
    }

    @Override
    public int size() {
        return size;
    }

    private void resizeArray() {
        int newCapacity = array.length * 2;
        String[] newArray = new String[newCapacity];
        for (int i = 0; i < size; i++) {
            newArray[i] = array[i];
        }
        array = newArray;
    }
}
