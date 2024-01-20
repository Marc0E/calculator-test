import java.util.Stack;

public class Test {

  public static void main(String[] args) {
    String[] tokens = new String[]{"21", "+", "1", "+", "3", "*", "25"};
    System.out.println(evalRPN(tokens));
  }

  private static int evalRPN(String[] tokens) {
    int returnValue = 0, a = 0, b =0;
    String number = "";
    String operators = "+-*/";
    Stack<String> stack = new Stack<String>();
    Stack<String> stack2 = new Stack<>();
    for (String t : tokens) {
      if (!operators.contains(t)) { //push to stack if it is a number
        stack.push(t);
      } else if(stack.size() > 1){//pop numbers from stack if it is an operator
         a = Integer.valueOf(stack.pop());
         b = Integer.valueOf(stack.pop());
        switch (stack2.pop()) {
          case "+":
            stack.push(String.valueOf(a + b));
            stack2.push(t);
            break;
          case "-":
            stack.push(String.valueOf(b - a));
            stack2.push(t);
            break;
          case "*":
            stack.push(String.valueOf(a * b));
            stack2.push(t);
            break;
          case "/":
            stack.push(String.valueOf(b / a));
            stack2.push(t);
            break;
        }
      }else{
        stack2.push(t);
      }
    }
    a = Integer.valueOf(stack.pop());
    b = Integer.valueOf(stack.pop());
    switch (stack2.pop()) {
      case "+":
        stack.push(String.valueOf(a + b));
        break;
      case "-":
        stack.push(String.valueOf(b - a));
        break;
      case "*":
        stack.push(String.valueOf(a * b));
        break;
      case "/":
        stack.push(String.valueOf(b / a));
        break;
    }
    returnValue = Integer.valueOf(stack.pop());
    return returnValue;
  }
}
