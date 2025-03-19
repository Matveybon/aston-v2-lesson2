public class Main {
    public static void main(String[] args) {
        // Пример использования MyArrayList с QuickSort
        MyArrayList arrayList = new MyArrayList();
        arrayList.add(3);
        arrayList.add(1);
        arrayList.add(4);
        arrayList.add(2);
        arrayList.add(5);
        System.out.println("ArrayList before QuickSort:");
        arrayList.printList();
        arrayList.quickSort();
        System.out.println("ArrayList after QuickSort:");
        arrayList.printList();

        // Пример использования MyLinkedList с MergeSort
        MyLinkedList linkedList = new MyLinkedList();
        linkedList.add(3);
        linkedList.add(1);
        linkedList.add(4);
        linkedList.add(2);
        linkedList.add(5);
        System.out.println("LinkedList before MergeSort:");
        linkedList.printList();
        linkedList.mergeSort();
        System.out.println("LinkedList after MergeSort:");
        linkedList.printList();
    }
}
