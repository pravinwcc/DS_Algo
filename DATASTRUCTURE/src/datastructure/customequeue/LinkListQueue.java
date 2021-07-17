package datastructure.customequeue;

import java.util.LinkedList;

public class LinkListQueue<E> {

    LinkedList<E> newLinkList = new LinkedList<E>();

    public <T> void enqueue(E data) {
        newLinkList.add(data);
    }

    public void dequeue() {
        if(!newLinkList.isEmpty())
            newLinkList.remove(0);

    }

    public void displayQueue() {
        newLinkList.iterator();
        for(Object obj:newLinkList){
        	System.out.println(obj);
        }
        
    }

    public boolean isEmpty(){
        return newLinkList.isEmpty();
    }

}
