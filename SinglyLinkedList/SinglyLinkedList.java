public class SinglyLinkedList<E>{
    private static class Node<E> {
        private E element; 
        private Node<E> next ;

        public Node(E e , Node<E> n ) {
            element = e ; 
            next = n ; 
        }
        public E getElement(){return element ; }
        public Node<E> getNext(){ return next ; }
        public void setNext(Node<E> n ) { next = n ;}

    }
    private Node<E> head = null ; 
    private Node<E> tail = null ; 
    private int size =0 ; 

    public SinglyLinkedList() {}
    public int size() {return size;}
    public boolean isEmpty(){ return size==0 ;}
    
    public E first(){
        if(isEmpty()){return null;}
        return head.getElement();
    }
    public E last(){
        if (isEmpty()) {return null;} ; 
        return tail.getElement();
    }
    public void addFirst(E e){
        head = new Node<E>(e , head) ; 
        if (isEmpty()) {
            tail = head ; 
        }
        size++ ; 
    }
    public void addLast(E e){
        Node<E> newlast = new Node<E>(e , null);
        if (isEmpty()){
            head = newlast;
        }
        else{
            tail.setNext(newlast);
        }
        tail = newlast; 
        size++;
    }
    public E removeFirst(){
        if (isEmpty()){ return null ;}
        E answer = head.getElement() ; 
        head = head.getNext() ;
        size--;
        if (isEmpty()){tail = null;}
        return answer ; 
    }
    public void repDelete() {
    if (size <= 1) {
        return; 
    }
    Node<E> current = head;
    while (current != null) {
        Node<E> runner = current;
        while (runner.getNext() != null) {
            if (current.getElement().equals(runner.getNext().getElement())) {
                
                Node<E> duplicate = runner.getNext();
                System.out.println(duplicate.getElement() + " was repeated and deleted.");
                runner.setNext(duplicate.getNext()); 
                size--;
                if (duplicate == tail) {
                    tail = runner;
                }
            } else {
                runner = runner.getNext();
            }
        }
        current = current.getNext(); 
    }
    System.out.println("Search is ended.");
    }
    
    public E removeLast() {
        if (isEmpty()) return null;
        if (size == 1) return removeFirst(); 
        
        Node<E> current = head;
        while (current.getNext() != tail) {
            current = current.getNext();
        }
        
        E answer = tail.getElement();
        tail = current;       
        tail.setNext(null);   
        size--;
        return answer;
    }

    
    public void printList() {
        if (isEmpty()) {
            System.out.println("list is empty");
            return;
        }
        Node<E> current = head;
        while (current != null) {
            System.out.print(current.getElement() + " -> ");
            current = current.getNext();
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
        
        list.addFirst(12);
        list.addLast(20);
        list.addLast(12); 
        list.addLast(35);
        list.addLast(20);
        list.addLast(50);
        
        System.out.println("list:");
        list.printList();
        
        
        list.repDelete();
        
        System.out.println("after delete reps:");
        list.printList();
        
        
        list.removeFirst();
        list.removeLast();
        
        System.out.println("final:");
        list.printList();
    }

}