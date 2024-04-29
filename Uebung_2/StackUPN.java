
import java.util.Stack;


public class StackUPN {

    private static boolean isOperand(String token) {
        try {
            Double.parseDouble(token);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }


    public static void main(String[] args) {

        In txt = new In("UPN_Zahlenfolge");
        Stack<Double> stack = new Stack<>();

        String UPN = txt.readLine();


            String[] tokens = UPN.split(" ");

            for (String token : tokens) {
                if (isOperand(token)) {
                    stack.push(Double.parseDouble(token));
                } else {
                    double operand2 = stack.pop();
                    double operand1 = stack.pop();

                    switch (token) {
                        case "+":
                            stack.push(operand1 + operand2);
                            break;
                        case "-":
                            stack.push(operand1 - operand2);
                            break;
                        case "*":
                            stack.push(operand1 * operand2);
                            break;
                        case "/":
                            stack.push(operand1 / operand2);
                            break;
                    }

                }
            }

            StdOut.print(stack.pop());
            StdOut.println();


        }


    }
