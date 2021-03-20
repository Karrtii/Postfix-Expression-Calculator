import Calculator.*;

import java.util.ArrayList;
import java.util.Arrays;

public class MyCalc
{
  public static void main(String[] args)
  {
    Client client = new Client();

    Operand o1 = new Operand(3);
    Operand o2 = new Operand(4);
    Operand o3 = new Operand(7);
    Operator o4 = new Operator(Operation.MULTIPLICATION);
    Operand o5 = new Operand(2);
    Operator o6 = new Operator(Operation.DIVISION);
    Operator o7 = new Operator(Operation.SUBTRACTION);
    int number;
    number = client.evaluateExpression(new ArrayList<Token>(Arrays.asList(
        o1,
        o2,
        o3,
        o4,
        o5,
        o6,
        o7
    )));

    //the answer is -11
    System.out.println(number);
  }
}
