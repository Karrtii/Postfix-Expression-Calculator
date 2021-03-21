package Calculator;

import org.junit.Rule;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class ClientTest
{
  private Client client;

  @BeforeEach
  private void setUp()
  {
    client = new Client();
  }

  //when the arraylist is empty, should return zero with message "Malformed exception"
  @Test
  public void zeroEvaluateExpression()
  {
    assertEquals(0, client.evaluateExpression(new ArrayList<Token>(Arrays.asList())));
  }

  //when there is only one operand in the arraylist
  @Test
  public void onlyOneOperandEvaluateExpression()
  {

    assertEquals(1, client.evaluateExpression(new ArrayList<Token>(Arrays.asList(new Operand(1)))));
  }

  //when there is only one operator in the arraylist, should return zero with message "Malformed exception"
  @Test
  public void onlyOneOperatorEvaluateExpression()
  {
    assertEquals(0, client.evaluateExpression(new ArrayList<Token>(Arrays.asList(new Operator(Operation.SUBTRACTION)))));
  }

  //when there are many operands in the arraylist, should return zero with message "Malformed exception"

  @Test
  public void onlyManyOperandsEvaluateExpression()
  {
    assertEquals(0, client.evaluateExpression(new ArrayList<Token>(Arrays.asList(new Operand(1), new Operand(2)))));
  }

  //when there are many operators in the arraylist, should return zero with message "Malformed exception"
  @Test
  public void onlyManyOperatorsEvaluateExpression()
  {
    assertEquals(0, client.evaluateExpression(new ArrayList<Token>(Arrays.asList(new Operator(Operation.SUBTRACTION), new Operator(Operation.MULTIPLICATION)))));
  }

  //normal evaluating a postfix expression
  @Test
  public void evaluateExpression()
  {
    Operand o1 = new Operand(3);
    Operand o2 = new Operand(4);
    Operand o3 = new Operand(7);
    Operator o4 = new Operator(Operation.MULTIPLICATION);
    Operand o5 = new Operand(2);
    Operator o6 = new Operator(Operation.DIVISION);
    Operator o7 = new Operator(Operation.SUBTRACTION);

    assertEquals(-11, client.evaluateExpression(new ArrayList<Token>(Arrays.asList(
        o1,
        o2,
        o3,
        o4,
        o5,
        o6,
        o7))));
  }
}