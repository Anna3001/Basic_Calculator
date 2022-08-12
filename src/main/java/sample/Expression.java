package sample;

import java.util.Stack;

public class Expression {

    public static int evaluate(String expression) {

        char[] symbolsOfExpr = expression.toCharArray();
        Stack<Integer> numbers = new Stack<Integer>();
        Stack<Character> operators = new Stack<Character>();

        for (int i = 0; i < symbolsOfExpr.length; i++) {

            if (symbolsOfExpr[i] == ' ') {
                continue;
            }

            if (symbolsOfExpr[i] >= '0' && symbolsOfExpr[i] <= '9') {

                StringBuffer stringBuffer = new StringBuffer();

                while (symbolsOfExpr[i] >= '0' && symbolsOfExpr[i] <= '9') {

                    stringBuffer.append(symbolsOfExpr[i++]);

                    if(i == symbolsOfExpr.length) {
                        break;
                    }
                }

                numbers.push(Integer.parseInt(stringBuffer.toString()));

            } else if (symbolsOfExpr[i] == '-' || symbolsOfExpr[i] == '+' || symbolsOfExpr[i] == '*' || symbolsOfExpr[i] == '/') {

                while (!operators.empty() && hasPrecedence(symbolsOfExpr[i], operators.peek())) {
                    numbers.push(applyOperator(operators.pop(), numbers.pop(), numbers.pop()));
                }

                operators.push(symbolsOfExpr[i]);
            }
        }

        while (!operators.empty()) {
            numbers.push(applyOperator(operators.pop(), numbers.pop(), numbers.pop()));
        }

        return numbers.pop();
    }

    public static boolean hasPrecedence(char oper1, char oper2) {

        if((oper1 == '*' || oper1 == '/') && (oper2 == '+' || oper2 == '-')) {
            return false;
        } else
            return true;
    }

    public static int applyOperator(char oper, int nb2, int nb1) {

        switch (oper)
        {
            case '+':
                return nb1 + nb2;
            case '-':
                return nb1 - nb2;
            case '*':
                return nb1 * nb2;
            case '/':
                if (nb2 == 0)
                    throw new UnsupportedOperationException("CANNOT DIVIDE BY ZERO!");
                return nb1 / nb2;
        }
        return 0;
    }
}