package S7;

public class S7q9 {
    static Queue q = new Queue();
    static Node res;
    static Node first;
    public static void copy(Node head) {
        
        if (head == null) {
            
            return;
        }
        if (head == q.head) {
            first = head;
        }
        Node temp = head.link;
        Node newNode = new Node();
        newNode.data = head.data;
        head.link = newNode;
        
        head.link.link = temp;
        res = head;
        copy(head.link.link);
    }
    public static void main(String[] args) {
        
        q.push(1);
        q.push(2);
        q.push(3);
        q.push(4);
        q.push(5);
        q.display();
        System.out.println();
        copy(q.head);
        q.top = first;
        q.display();
    }
}
