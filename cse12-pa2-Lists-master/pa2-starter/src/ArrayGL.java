public class ArrayGL<E> implements MyList<E> {

    E[] elements;
    int size;

    public ArrayGL(E[] initialElements) {
        this.elements = initialElements;
        this.size = initialElements.length;
    }

    // Fill in all required methods here
    public E[] toArray() {
        E[] clonedArray = this.elements.clone();
        return clonedArray;
    }

    @SuppressWarnings("unchecked")
    public void transformAll(MyTransformer mt) {
        for (int i = 0; i < this.elements.length; i++) {
            if (this.elements[i] != null) {
                this.elements[i] = (E) mt.transformElement(this.elements[i]);
            }
        }
    }

    @SuppressWarnings("unchecked")
    public void chooseAll(MyChooser mc) {
        int count = 0;
        for (E element: this.elements) {
            if (element != null && mc.chooseElement(element)) {
                count ++;
            }
        }
        E[] newElementArr = (E[]) new Object[count];
        int index = 0;
        for (E element: this.elements) {
            if (element != null && mc.chooseElement(element)) {
                newElementArr[index] = element;
                index ++;
            }
        }
        this.elements = newElementArr;
    }

    public boolean isEmpty() {
        return this.elements.length == 0;
    }
}