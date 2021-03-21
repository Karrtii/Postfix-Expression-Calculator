package Stack;

import java.util.EmptyStackException;

public class LinkedStack<T> implements Stack<T>
{

  private LinkedList<T> list;

  public LinkedStack()
  {
    this.list = new LinkedList<T>();
  }

  @Override public boolean isEmpty()
  {
    if (list.isEmpty())
    {
      return true;
    }
    else
    {return false;}
  }

  @Override public void push(T elm)
  {
    list.addToFront(elm);
  }

  @Override public T pop() throws EmptyStackException
  {
    if (isEmpty())
    {
      throw new EmptyStackException();
    }

    try
    {
      return list.removeFirst();
    }
    catch(EmptyListException e)
    {
      System.out.println("Stack is empty");
    }
    return null;
  }
}
