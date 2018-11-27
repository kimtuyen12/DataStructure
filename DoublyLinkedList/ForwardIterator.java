/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment2;
import java.util.Iterator;

public class ForwardIterator<E> implements Iterator<E>{

	Node<E> nextNode;
	
	public ForwardIterator(Node<E> startNode){
		nextNode = startNode;
	}
	
	@Override
	public boolean hasNext() {
		return nextNode != null;
	}

	@Override
	public E next() {
		E element = nextNode.element;
		nextNode = nextNode.next;
		
		return element;
	}

}

