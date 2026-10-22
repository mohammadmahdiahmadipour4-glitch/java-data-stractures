package DoublyLinkedList;

public class DoublyLinkedList<E> {
    
    private static class Node<E> {
        private E element; 
        private Node<E> prev; 
        private Node<E> next; 
        
        public Node(E e, Node<E> p, Node<E> n) {
            element = e;
            prev = p;
            next = n;
        }
        public E getElement() { return element; }
        public Node<E> getPrev() { return prev; }
        public Node<E> getNext() { return next; }
        public void setPrev(Node<E> p) { prev = p; }
        public void setNext(Node<E> n) { next = n; }
    }
    
    private Node<E> header;  
    private Node<E> trailer; 
    private int size;
    
    public DoublyLinkedList() {
        header = new Node<>(null, null, null); 
        trailer = new Node<>(null, header, null); 
        header.setNext(trailer); 
        size = 0;
    }
    
    public int size() { return size; }
    public boolean isEmpty() { return size == 0; }
    
    public void addFirst(E e) {
        addBetween(e, header, header.getNext());
    }
    
    public void addLast(E e) {
        addBetween(e, trailer.getPrev(), trailer);
    }
    
    public E removeFirst() {
        if (isEmpty()) return null;
        return remove(header.getNext());
    }
    
    public E removeLast() {
        if (isEmpty()) return null;
        return remove(trailer.getPrev());
    }
    
    private void addBetween(E e, Node<E> p, Node<E> n) {
        Node<E> newNode = new Node<>(e, p, n);
        p.setNext(newNode);
        n.setPrev(newNode);
        size++;
    }
    
    private E remove(Node<E> node) {
        Node<E> p = node.getPrev();
        Node<E> n = node.getNext();
        p.setNext(n);
        n.setPrev(p);
        size--;
        return node.getElement();
    }
    
    public void print() {
        if (size == 0) {
            System.out.println("empty");
            return;
        }
        Node<E> curr = header.getNext();
        while (curr != trailer) {
            System.out.print(curr.getElement() + " ");
            curr = curr.getNext();
        }
        System.out.println();
    }
    
    public void moveBetween(E v1, E v2) {
        DoublyLinkedList<E> list2 = new DoublyLinkedList<>();
        
        Node<E> curr = header.getNext();
        boolean find1 = false;
        
        while (curr != trailer) {
            if (curr.getElement().equals(v1)) {
                find1 = true;
                curr = curr.getNext(); 
                break;
            }
            curr = curr.getNext();
        }
        
        if (find1) {
            while (curr != trailer && !curr.getElement().equals(v2)) {
                list2.addLast(curr.getElement());
                Node<E> temp = curr;
                curr = curr.getNext();
                remove(temp); 
            }
        }
        
        System.out.println("list 1:");
        this.print();
        
        System.out.println("list 2:");
        list2.print();
    }

    public static void main(String[] args) {
        DoublyLinkedList<Integer> myList = new DoublyLinkedList<>();
        
        myList.addLast(10);
        myList.addLast(20);
        myList.addLast(30);
        myList.addLast(40);
        myList.addLast(50);
        myList.addLast(60);
        myList.addLast(70);
        
        myList.print();
        
        myList.removeFirst();
        myList.removeLast();
        
        myList.print();
        
        System.out.println("--- moving ---");
        myList.moveBetween(20, 60);
    }
}
