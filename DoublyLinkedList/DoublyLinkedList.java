/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment2;
import java.util.Iterator;

public class DoublyLinkedList<E> {

	int size;
	Node<E> firstNode;
	Node<E> lastNode;
	
	public DoublyLinkedList() {
		size = 0;
		firstNode = null;
		lastNode = null;
	}
	
	// Problem 1 (15 pts)
	// Fill in the method below to add a new node at the given index with the given element.
	// If index is out of bounds, you must throw an IndexOutOfBoundsException.
	// You must appropriately update all next and prev's.
	// You must appropriately update the firstNode and lastNode.
	// Hint: It's recommended that you use if statements to split into four or five different cases.
    public void add(int index, E element) {
        Node<E> newNode = new Node<E>(element, null, null);
        if (index < 0 || index > size){
            throw new IndexOutOfBoundsException ("Invalid index");
        } else if (firstNode == null){ //empty node
            firstNode = newNode;
            lastNode = newNode;
            size++;
        }  else if (index == 0) { //first node
            newNode.next = firstNode;
            firstNode.prev = newNode;
            firstNode = newNode;
            size++;
        } else if (index == size){ //last node
            newNode.prev = lastNode;
            lastNode.next = newNode;
            lastNode = newNode;
            size++;
        } else {
            Node<E> current = firstNode;
            for (int i = 1; i < index; i++) {
                current = current.next;
            }
            newNode.next = current.next;
            current.next = newNode;
            newNode.prev = current;
            newNode.next.prev = newNode;
            size++;
	}
    }
    
    public void add(E element) {
    	add(size, element);
    }
	
    // Problem 2 (15 pts)
 	// Fill in the method below to remove a new node at the given index.
 	// If index is out of bounds, you must throw an IndexOutOfBoundsException.
 	// You must appropriately update all next and prev's.
 	// You must appropriately update the firstNode and lastNode.
 	// Hint: It's recommended that you use if statements to split into four or five different cases.
	public E remove(int index) {
            if (index < 0 || index >= size){
                throw new IndexOutOfBoundsException ("Invalid index");
            }  else if (index == 0) {
                E current = firstNode.element;
                firstNode = firstNode.next;
//               firstNode.prev = null;
                size--;
                return current;
            } else if (index == size-1){
                E current = lastNode.element;
                lastNode = lastNode.prev;
                lastNode.next = null;
                size--;
                return current;
            } else {
                Node<E> current = firstNode;
                for (int k=0; k<index; k++){
                    current = current.next;
                }
                Node<E> previous = current.prev;
                Node<E> next = current.next;
                previous.next = current.next;
                next.prev = previous;
                size--;
                return current.element;
            } 
	}
	
	public E get(int index) {
		return getNode(index).element;
	}
	
	public E set(int index, E element) {
		Node<E> tempNode = getNode(index);
		E oldValue = tempNode.element;
		tempNode.element = element;
		return oldValue;
	}
	
	// Problem 3 (10 pts)
	// Fill in the getNode, getNodeFromFront, and getNodeFromBack methods below to return the node at the given index.
	// The getNodeFromFront method starts from firstNode going forward.
	// The getNodeFromBack method starts from the lastNode going backwards.
	// The getNode method calls the getNodeFromFront method if index < size / 2 and it calls the getNodeFromBack method otherwise.
	// If index is out of bounds, you must throw an IndexOutOfBoundsException.
	public Node<E> getNode(int index){
            if(index <0 || index >= size){
                throw new IndexOutOfBoundsException ("Invalid index");
            } else if (index < size/2){
                Node a = getNodeFromFront(index);
                return a;
            } else {
                Node b = getNodeFromBack(index);
                return b;
            }
	}

	private Node<E> getNodeFromFront(int index) {
            Node<E> current = firstNode;
            for (int k=0; k<index; k++){
                current = current.next;
            }
            return current;
            
	}
	
	private Node<E> getNodeFromBack(int index) {
            Node<E> current = lastNode;
            for (int k=size-1; k>index; k--){
                current = current.prev;
            }
            return current;
            
	}
	
	
	// Problem 4 (5 pts)
	// Fill in the frontIsValid and backIsValid methods below to further test that you implemented your DoublyLinkedList properly.
	// The frontIsValid method checks that if you go backwards through the DoublyLinkedList, then you will eventually end with firstNode's element.
	// The frontIsValid method must use the backwardIterator to iterate going backward over the elements in the list.
	// The backIsValid method checks that if you go forwards through the DoublyLinkedList, then you will eventually end with lastNode's element.
	// The backIsValid method must use the forwardIterator to iterate going forward over the elements in the list.
	// Both methods return true if size == 0.
	public boolean frontIsValid() {
            Iterator<E> tmpNode = backwardIterator();
            E curElement = null;
            while(tmpNode.hasNext()){
                curElement = tmpNode.next();
            }
            if (curElement == firstNode.element){
                return true;
            } else if (size == 0){
                return true;
            } else 
                return false;
        }
	
	public boolean backIsValid() {
            Iterator<E> tmpNode = forwardIterator();
            E curElement = null;
            while(tmpNode.hasNext()){
                curElement = tmpNode.next();
            }
            if (curElement == lastNode.element){
                return true;
            } else if (size == 0){
                return true;
            } else 
                return false;
        }

	// helper methods
	public int size() {
		return size;
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	public String toString() {
		StringBuilder builder = new StringBuilder("start");
		Node<E> currentNode = firstNode;
		for(int i = 0; i < size; i++) {
			builder.append(" <-> [");
			builder.append(currentNode.element);
			builder.append("]");
			currentNode = currentNode.next;
		}
		builder.append(" <-> end");
		
		return builder.toString();
	}
	
	// methods to add, get, and remove from front and back
	public void addToFront(E element) {
		add(0, element);
	}
	
	public void addToBack(E element) {
		add(size, element);
	}
	
	public E getFront() {
		return get(0);
	}
	
	public E getBack() {
		return get(size - 1);
	}
	
	public E removeFromFront() {
		return remove(0);
	}
	
	public E removeFromBack() {
		return remove(size - 1);
	}

	// get forward and backward iterators
	public Iterator<E> forwardIterator(){
		return new ForwardIterator<E>(firstNode);
	}
	
	public Iterator<E> backwardIterator(){
		return new BackwardIterator<E>(lastNode);
	}
	
}



