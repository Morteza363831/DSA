package S7;

public class S7q8 {
    public void circular(DescQueue dq1) {
        Node head = dq1.first;
        
        Node temp = head;
        while (temp != null) {
            if (temp.next == null) {
                temp.next = head;
                head.pre = temp;
            }
        }
        dq1.first = head;
    }
    public static void main(String[] args) {
        
    }
}
