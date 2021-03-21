package Stack;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListTest
{
  private LinkedList<Integer> linkedList;

  @BeforeEach
  public void setUp()
  {
    linkedList = new LinkedList<Integer>();
  }

  @Test
  public void zeroIsEmpty()
  {
    assertEquals(true, linkedList.isEmpty());
  }

  @Test
  public void oneIsEmpty()
  {
    linkedList.addToFront(1);
    assertEquals(false, linkedList.isEmpty());
  }

  @Test
  public void manyIsEmpty()
  {
    linkedList.addToFront(1);
    linkedList.addToFront(2);
    assertEquals(false, linkedList.isEmpty());
  }

  @Test
  public void zeroSize()
  {
    assertEquals(0, linkedList.size());
  }

  @Test
  public void oneSize()
  {
    linkedList.addToFront(1);
    assertEquals(1, linkedList.size());
  }

  @Test
  public void manySize()
  {
    linkedList.addToFront(1);
    linkedList.addToFront(2);
    assertEquals(2, linkedList.size());
  }

  @Test
  public void zeroAddToFrontAndRemoveFirst() throws EmptyListException
  {
    linkedList.addToFront(null);
    assertEquals(null, linkedList.removeFirst());
  }

  @Test
  public void oneAddToFrontAndRemoveFirst() throws EmptyListException
  {
    linkedList.addToFront(1);
    assertEquals(1, linkedList.removeFirst());
  }

  @Test
  public void manyAddToFrontAndRemoveFirst() throws EmptyListException
  {
    linkedList.addToFront(1);
    linkedList.addToFront(2);
    assertEquals(2, linkedList.removeFirst());
    assertEquals(1, linkedList.removeFirst());

  }

  @Test
  public void exceptionRemoveFirst() throws EmptyListException
  {
    Assertions.assertThrows(EmptyListException.class, () ->
        {
          linkedList.removeFirst();
        }
        );
  }

}