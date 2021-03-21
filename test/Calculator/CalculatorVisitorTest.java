package Calculator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.EmptyStackException;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorVisitorTest
{
  CalculatorVisitor visitor;


  @BeforeEach
  private void setUp()
  {
    visitor = new CalculatorVisitor();
  }

  @Test
  public void zeroPushOperandAndGetResult() throws MalformedExpressionException
  {
    visitor.pushOperand(null);

    assertEquals(0, visitor.getResult());
  }

  @Test
  public void onePushOperandAndGetResult() throws MalformedExpressionException
  {
    visitor.pushOperand(new Operand(1));

    assertEquals(1, visitor.getResult());
  }

  @Test
  public void manyPushOperandAndGetResult() throws MalformedExpressionException
  {
    visitor.pushOperand(new Operand(1));
    visitor.pushOperand(new Operand(2));
    visitor.performOperation(Operation.ADDITION);

    assertEquals(3, visitor.getResult());
  }

  @Test
  public void exceptionGetResult() throws MalformedExpressionException
  {
    visitor.pushOperand(new Operand(1));
    visitor.pushOperand(new Operand(2));

    Assertions.assertThrows(MalformedExpressionException.class, () ->
        {
          visitor.getResult();
        }
    );
  }

  @Test
  public void nullPerformOperation() throws MalformedExpressionException
  {
    visitor.pushOperand(new Operand(1));
    visitor.pushOperand(new Operand(2));

    Assertions.assertThrows(NullPointerException.class, () ->
        {
          visitor.performOperation(null);
        }
    );
  }

  @Test
  public void emptyListPerformOperation() throws MalformedExpressionException
  {
    Assertions.assertThrows(MalformedExpressionException.class, () ->
        {
          visitor.performOperation(Operation.ADDITION);
        }
    );
  }

  @Test
  public void onlyOneOperandPerformOperation() throws MalformedExpressionException
  {
    visitor.pushOperand(new Operand(1));

    Assertions.assertThrows(MalformedExpressionException.class, () ->
        {
          visitor.performOperation(Operation.ADDITION);
        }
    );
  }

  @Test
  public void manyPerformOperation() throws MalformedExpressionException
  {
    visitor.pushOperand(new Operand(1));
    visitor.pushOperand(new Operand(2));
    visitor.performOperation(Operation.ADDITION);

    assertEquals(3, visitor.getResult());
  }


}