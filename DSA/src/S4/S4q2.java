package S4;

public class S4q2 {
    int front;
    int rear;
    int size = 5;
    int number = 0;
    int[] elements;
    public S4q2(int len) {
        front = 0;
        rear = -1;
        size = len;
        elements = new int[size];
    }
    
    public boolean isFull() {
        return number == size;
    }
    public boolean isEmpty() {
        return number == 0;
    }
    public void insert(int value) {
        if (isFull()) {
            System.out.println("queue is full !");
        }
        else {
            rear++;
            number++;
            elements[rear] = value;
        }
    }
    public int poll() {
        int result = elements[0];
        int temp = 0;
        int index = 0;
        for (int i = 0; i<size; i++) {
            if (elements[i] > result) {
                result = elements[i];
                index = i;
            }
        }
        elements[index] = 0;
        for (int i = index; i<size-1; i++) {
            elements[i] = elements[i+1];
        }
        elements[size-1] = 0;
        return result;
    }
    public int peek() {
        int copy = 0;
        for (int i = 0; i<size; i++) {
            if (elements[i] > copy) {
                copy = elements[i];
            }
        }
        return copy;
    }
    public void delete(int index) {
        int temp = 0;
        for (int i = size-1; i> index; i--) {
            temp = elements[i-1];
            elements[i-1] = elements[i];
        }
    }
}
