package Calculator;

import Stack.EmptyListException;
import Stack.LinkedStack;

public class CalculatorVisitor implements Visitor, Calculator
{
  private LinkedStack<Token> tokenStack;

  public CalculatorVisitor()
  {
    this.tokenStack = new LinkedStack<Token>();
  }

  public void pushOperand(Operand operand)
  {
    tokenStack.push(operand);
  }

  private int popping() throws MalformedExpressionException
  {
    if (!tokenStack.isEmpty())
    {
      var first = tokenStack.pop();
      if (first instanceof Operand) {
        return ((Operand) first).getValue();
      }
    }
    else
    {
      throw new MalformedExpressionException("Malformed");
    }
    return 0;
  }

  public void performOperation(Operation operation) throws MalformedExpressionException
  {
    if(tokenStack.isEmpty())
    {
      throw new MalformedExpressionException("It is empty");
    }
    int result;

    var second = popping();
    var first = popping();

    switch (operation)
    {
      case ADDITION:
        result = first + second;
        break;
      case SUBTRACTION:
        result = first - second;
        break;
      case MULTIPLICATION:
        result = first * second;
        break;
      case DIVISION:
        result = first / second;
        break;
      default:
        result = 0;
        break;
    }

    tokenStack.push(new Operand(result));
  }

  @Override public int getResult() throws MalformedExpressionException
  {
    var result = popping();
    if(!tokenStack.isEmpty())
    {
      throw new MalformedExpressionException("Malformed");
    }
    else
    {
      return result;
    }
  }

  @Override public void visit(Operand operand)
  {
    pushOperand(operand);
  }

  @Override public void visit(Operator operator)
  {
    try
    {
      performOperation(operator.getOperation());
    } catch (MalformedExpressionException e)
    {
      e.getMessage();
    }
  }

}
