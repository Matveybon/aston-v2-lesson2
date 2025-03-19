import java.util.Arrays;

public class MyArrayList {
    private Object[] array;
    private int size;

    public MyArrayList() {
        array = new Object[10]; // начальный размер массива
        size = 0;
    }

    public void add(Object item) {
        if (size == array.length) {
            array = Arrays.copyOf(array, array.length * 2);
        }
        array[size] = item;
        size++;
    }

    public void remove(Object item) {
        int index = -1;
        for (int i = 0; i < size; i++) {
            if (array[i].equals(item)) {
                index = i;
                break;
            }
        }
        if (index != -1) {
            for (int i = index; i < size - 1; i++) {
                array[i] = array[i + 1];
            }
            array[size - 1] = null;
            size--;
        }
    }

    public Object get(int index) {
        if (index >= 0 && index < size) {
            return array[index];
        } else {
            throw new IndexOutOfBoundsException("Index out of range");
        }
    }

    public int size() {
        return size;
    }

    // Быстрая сортировка
    public void quickSort() {
        quickSortRec(0, size - 1);
    }

    private void quickSortRec(int low, int high) {
        if (low < high) {
            int pivotIndex = partition(low, high);
            quickSortRec(low, pivotIndex - 1);
            quickSortRec(pivotIndex + 1, high);
        }
    }

    private int partition(int low, int high) {
        Object pivot = array[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (((Comparable) array[j]).compareTo(pivot) <= 0) {
                i++;
                Object temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
        Object temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;
        return i + 1;
    }

    // Метод для вывода элементов
    public void printList() {
        for (int i = 0; i < size; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
}

