import java.util.Comparator;

public class DLL<T> {
    private DLLNode<T> head;
    private DLLNode<T> current;
    private Comparator<T> comparator;

    public DLL() {
        head = current = null;
    }
    public DLL(Comparator<T> comparator) {
        head = current = null;
        this.comparator = comparator;
    }
    public boolean empty() {
        return head == null;
    }
    public boolean last() {
        return current.next == null;
    }
    public boolean first() {
        return current.previous == null;
    }
    public boolean full() {
        return false;
    }
    public void findFirst() {
        current = head;
    }
    public void findNext() {
        current = current.next;
    }
    public void findPrevious() {
        current = current.previous;
    }
    public T retrieve() {
        return current.data;
    }
    public void update(T val) {
        current.data = val;
    }
    public void insert(T val) {
        DLLNode<T> tmp = new DLLNode<T>(val);
        if(empty()) {
            current = head = tmp;
        }
        else {
            tmp.next = current.next;
            tmp.previous = current;
            if(current.next != null)
                current.next.previous = tmp;
            current.next = tmp;
            current = tmp;
        }
    }
    public void remove() {
        if(current == head) {
            head = head.next;
            if(head != null)
                head.previous = null;
        }
        else {
            current.previous.next = current.next;
            if(current.next != null)
                current.next.previous = current.previous;
        }
        if(current.next == null)
            current = head;
        else
            current = current.next;
    }
    public void removeBetween(T e1, T e2) {
        if (empty()) {
            return; // No nodes to remove
        }

        DLLNode<T> node = head;

        // Traverse the list and remove nodes with data between e1 and e2
        while (node != null) {
            // Check if the node's data is between e1 and e2
            if (comparator.compare(node.data, e1) > 0 && comparator.compare(node.data, e2) < 0) {
                // Remove the node
                DLLNode<T> nextNode = node.next; // Store next node for iteration

                // Update the previous node's next link
                if (node.previous != null) {
                    node.previous.next = node.next;
                } else {
                    // If we're removing the head, update the head reference
                    head = node.next;
                }

                // Update the next node's previous link
                if (node.next != null) {
                    node.next.previous = node.previous;
                }

                // Move to the next node
                node = nextNode;
            } else {
                // Move to the next node if no removal
                node = node.next;
            }
        }

        // After removing, set the current node to head
        current = head;
    }
}
