package Stack;

public class LinkedList<T> implements List<T>
{
  private Node<T> head;
  private int size;

  public LinkedList()
  {
    head = null;
    size = 0;
  }
    @Override public boolean isEmpty()
  {
    if (head == null)
    {
      return true;
    }
    else
    {
      return false;
    }
  }

  @Override public int size()
  {
    return size;
  }

  @Override public void addToFront(T data)
  {
    Node<T> newNode = new Node<T>(data);
    newNode.setNext(head);
    head = newNode;
    size++;
  }

  @Override public T removeFirst() throws EmptyListException
  {
    if(isEmpty())
    {
      throw new EmptyListException("Stack.List is empty");
    }

    var result = head.getData();
    head = head.getNext();
    size--;

    return result;
  }
}
