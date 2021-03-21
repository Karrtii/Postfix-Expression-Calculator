package Stack;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.EmptyStackException;

import static org.junit.jupiter.api.Assertions.*;

class LinkedStackTest
{
  private LinkedStack<Integer> linkedStack;

  @BeforeEach
  public void setUp()
  {
    linkedStack = new LinkedStack<Integer>();
  }

  @Test
  public void zeroIsEmpty()
  {
    assertEquals(true, linkedStack.isEmpty());
  }

  @Test
  public void oneIsEmpty()
  {
    linkedStack.push(1);
    assertEquals(false, linkedStack.isEmpty());
  }

  @Test
  public void manyIsEmpty()
  {
    linkedStack.push(1);
    linkedStack.push(2);
    assertEquals(false, linkedStack.isEmpty());
  }

  @Test
  public void zeroPushAndPop()
  {
    linkedStack.push(null);
    assertEquals(null, linkedStack.pop());
  }

  @Test
  public void onePushAndPop()
  {
    linkedStack.push(1);
    assertEquals(1, linkedStack.pop());
  }

  @Test
  public void manyPushAndPop()
  {
    linkedStack.push(1);
    linkedStack.push(2);
    assertEquals(2, linkedStack.pop());
    assertEquals(1, linkedStack.pop());
  }

  @Test
  public void exceptionPop() throws EmptyStackException
  {
    Assertions.assertThrows(EmptyStackException.class, () ->
        {
          linkedStack.pop();
        }
    );
  }
}