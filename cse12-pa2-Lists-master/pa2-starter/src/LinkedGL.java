public class LinkedGL<E> implements MyList<E> {

    class Node {
        E value;
        Node next;

        public Node(E value, Node next) {
            this.value = value;
            this.next = next;
        }
    }

    Node front;
    int size;

    public LinkedGL(E[] contents) {
        // Fill in this constructor
        this.front = new Node(null, null);
        this.size = 0;
        Node currentNode = this.front;
        for (E element: contents) {
            currentNode.next = new Node(element, null);
            currentNode = currentNode.next;
            this.size ++;
        }
    }

    // Fill in all methods
    @SuppressWarnings("unchecked")
    public E[] toArray() {
        E[] clonedArray = (E[]) (new Object[this.size]);
        Node currentNode = this.front;
        for (int i = 0; i < this.size; i++) {
            clonedArray[i] = currentNode.next.value;
            currentNode = currentNode.next;
        }
        return clonedArray;
    }

    @SuppressWarnings("unchecked")
    public void transformAll(MyTransformer mt) {
        Node currentNode = this.front;
        while (currentNode.next != null) {
            if (currentNode.next.value != null) {
                currentNode.next.value = (E)(mt.transformElement(currentNode.next.value));
            }
            currentNode = currentNode.next;
        }
    }

    @SuppressWarnings("unchecked")
    public void chooseAll(MyChooser mc) {
        Node currentNode = this.front;
        while (currentNode.next != null) {
            if (currentNode.next.value != null && mc.chooseElement(currentNode.next.value)) {
                currentNode = currentNode.next;
            } else {
                currentNode.next = currentNode.next.next;
                this.size --;
            }
        }
    }

    public boolean isEmpty() {
        return this.size == 0;
    }
}