public class MyLinkedList {
    private Node head;
    private int size;

    private class Node {
        Object data;
        Node next;

        Node(Object data) {
            this.data = data;
            this.next = null;
        }
    }

    public MyLinkedList() {
        head = null;
        size = 0;
    }

    public void add(Object item) {
        Node newNode = new Node(item);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        size++;
    }

    public void remove(Object item) {
        if (head == null) return;

        if (head.data.equals(item)) {
            head = head.next;
            size--;
            return;
        }

        Node current = head;
        while (current.next != null && !current.next.data.equals(item)) {
            current = current.next;
        }

        if (current.next != null) {
            current.next = current.next.next;
            size--;
        }
    }

    public Object get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of range");
        }

        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.data;
    }

    public int size() {
        return size;
    }

    // Сортировка слиянием (MergeSort)
    public void mergeSort() {
        head = mergeSortRec(head);
    }

    private Node mergeSortRec(Node node) {
        if (node == null || node.next == null) {
            return node;
        }

        Node middle = getMiddle(node);
        Node nextToMiddle = middle.next;
        middle.next = null;

        Node left = mergeSortRec(node);
        Node right = mergeSortRec(nextToMiddle);

        return merge(left, right);
    }

    private Node merge(Node left, Node right) {
        if (left == null) return right;
        if (right == null) return left;

        if (((Comparable) left.data).compareTo(right.data) <= 0) {
            left.next = merge(left.next, right);
            return left;
        } else {
            right.next = merge(left, right.next);
            return right;
        }
    }

    private Node getMiddle(Node node) {
        if (node == null) return node;
        Node slow = node;
        Node fast = node.next;

        while (fast != null) {
            fast = fast.next;
            if (fast != null) {
                slow = slow.next;
                fast = fast.next;
            }
        }
        return slow;
    }

    // Метод для вывода элементов
    public void printList() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }
}
