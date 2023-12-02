package S4;

public class Queue {
    
    public class EmptyQueueException extends Exception {
        public EmptyQueueException() {
            super("The queue is empty");
        }
    }
    public class FullQueueException extends Exception {
        public FullQueueException() {
            super("The queue is empty");
        }
    }
    
    public int front,rear;
    private int size = 5;
    private int number;
    Object[] elements;
    public Queue() {
        front = 0;
        rear = -1;
        elements = new Object[size];
    }

    public Queue(int len) {
        front = 0;
        rear = -1;
        size = len;
        elements = new Object[size];
    }

    public int getNumber() {
        return number;
    }

    public int getSize() {
        return size;
    }

    public boolean isFull() {
            return number == size;
    }

    public boolean isEmpty() {
        return number == 0;
    }

     public Object deQueue() throws EmptyQueueException {
        if (isEmpty()) {
            throw new EmptyQueueException();
        }
        Object obj = elements[front];
        number--;
        if (this.isEmpty()) {
            rear = -1;
            front = 0;
        }
        else {
            front++;
        }
        return obj;

    }
   
    private void shift() {
        int n = rear - front + 1;
        for (int i = front; i<+rear; i++) {
            elements[i-1] = elements[i];
            elements[i] = null;
            front --;
            rear--;
        }
    }
   
    public void inQueue(Object data) throws FullQueueException{
        if (isFull()) {
            throw new FullQueueException();
        }
        if (rear == size-1) {
             int n = rear - front+1;
             for (int i = 1; i<n; i++) {
                 shift();
             }
        }
        if (this.isEmpty()) {
            System.out.print(1);
            rear = 0;
        }
        else {
            rear++;
            elements[rear] = data;
            number++;
        }  
        
    }
    
}

