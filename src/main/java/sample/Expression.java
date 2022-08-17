package sample;

import java.util.Stack;

public class Expression {
    private static double result;
    private static boolean isOperator;

    public static Double evaluate(String expression) {

        char[] symbolsOfExpr = expression.toCharArray();
        Stack<Double> numbers = new Stack<Double>();
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

                numbers.push(Double.valueOf(stringBuffer.toString()));

                isOperator = false;
            } else if (symbolsOfExpr[i] == '-' || symbolsOfExpr[i] == '+' || symbolsOfExpr[i] == '*' || symbolsOfExpr[i] == '/') {
                if(!isOperator) {
                    while (!operators.empty() && hasPrecedence(symbolsOfExpr[i], operators.peek())) {
                        if (!numbers.empty()) {
                            if ((result = applyOperator(operators.pop(), numbers.pop(), numbers.pop())) != 0) {
                                if (result < 10000000.0) {
                                    numbers.push(result);
                                } else if (result == 10000002.0) {
                                    return 10000002.0;
                                } else {
                                    return 10000000.0;
                                }
                            }
                        }
                    }
                } else {
                    return 10000001.0;
                }
                operators.push(symbolsOfExpr[i]);
                isOperator = true;
            }
        }

        if(numbers.size() == 1){
            return 10000001.0;
        }

            while (!operators.empty()) {
                if(!numbers.empty()) {
                    if ((result = applyOperator(operators.pop(), numbers.pop(), numbers.pop())) != 0) {
                        if (result < 10000000.0) {
                            numbers.push(result);
                        } else if (result == 10000002.0) {
                            return 10000002.0;
                        } else {
                            return 10000000.0;
                        }
                    }
                }
            }


        if(!numbers.empty()) {
            return numbers.pop();
        } else {
            return 10000000.0;
        }
    }

    public static boolean hasPrecedence(char oper1, char oper2) {

        if((oper1 == '*' || oper1 == '/') && (oper2 == '+' || oper2 == '-')) {
            return false;
        } else
            return true;
    }

    public static double applyOperator(char oper, Double nb2, Double nb1) {

        if(nb1 > 10000 || nb2 > 10000) {
            return 10000002.0;
        }

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