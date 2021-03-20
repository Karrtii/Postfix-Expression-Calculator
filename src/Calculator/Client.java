package Calculator;

import java.util.ArrayList;

public class Client
{
  private CalculatorVisitor calculator;

  public Client()
  {
    calculator = new CalculatorVisitor();
  }

  public int evaluateExpression(ArrayList<Token> tokenList)
  {

    for (int i = 0; i < tokenList.size(); i++)
    {
      tokenList.get(i).accept(calculator);
    }

    try
    {
      var result = calculator.getResult();
      return result;
    } catch (MalformedExpressionException e)
    {
      System.out.println("Malformed exception");
      return 0;
    }
  }
}
