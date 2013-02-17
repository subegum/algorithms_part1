import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 *
 */

/**
 * @author adrian
 *
 */
public class Deque<Item> implements Iterable<Item> {
  private int N;
  public Node first;
  private Node last;
  
  private class Node {
    private Item item;
    private Node next;
    public Node(Item item){
      this.item = item;
      this.next = null;
    }
  }
  
  // construct an empty deque
  public Deque(){
    N = 0;
    first = last = null;
  }

  // is the deque empty?
  public boolean isEmpty(){
    return size() == 0;
  }

  // return the number of items on the deque
  public int size(){
    return N;
  }

  // insert the item at the front
  public void addFirst(Item item) {
    if(item == null)
      throw new java.lang.NullPointerException();
    
    Node node = new Node(item);
    Node oldfirst = first;
    
    first = node;
    first.next = oldfirst;
    
    N++;
  }

  // insert the item at the end
  public void addLast(Item item){
    if(item == null)
      throw new java.lang.NullPointerException();
  }

  // delete and return the item at the front
  public Item removeFirst(){
    if(size() <= 0)
      throw new java.lang.UnsupportedOperationException();
    return null;
  }
  // delete and return the item at the end
  public Item removeLast(){
    if(size() <= 0)
      throw new java.lang.UnsupportedOperationException();
    return null;
  }
  
  public String toString(){
    StringBuilder sb = new StringBuilder();
    Node current = first;
    while(current != null){
      sb.append(current.item+" ");
      current = current.next;
    }
    return sb.toString();
  }
  
  // return an iterator over items in order from front to end
  public Iterator<Item> iterator(){
    return new LinkedListIterator();
  }
  private class LinkedListIterator implements Iterator<Item> {
    private Node current = first;

    public LinkedListIterator(){
      current = first;
    }
    /* (non-Javadoc)
     * @see java.util.Iterator#hasNext()
     */
    @Override
    public boolean hasNext() {
      return current != null;
    }

    /* (non-Javadoc)
     * @see java.util.Iterator#next()
     */
    @Override
    public Item next() {
      if (!hasNext()) 
        throw new NoSuchElementException();
      Item item = current.item;
      current = current.next;
      return item;
    }

    /* (non-Javadoc)
     * @see java.util.Iterator#remove()
     */
    @Override
    public void remove() {
      throw new UnsupportedOperationException();
    }
    
  }
}