package com.ksnietka.Parsing;

import com.ksnietka.DataStructures.stacks.SimpleStack;
//Easy algorithm to parsing simple algebraic expression without operator priority
public class DikstraParsing {
    Double parse (String expression) {
        final SimpleStack<String> operators = new SimpleStack<>(10);
        final SimpleStack<Double> vals = new SimpleStack<>(10);

        final String[] strings = expression
                .replace(" ", "")
                .split("");

        for (String s: strings) {
            if (s.equals("("));
            else if (s.equals("+") || s.equals("-") || s.equals("/") || s.equals("*")) operators.push(s);
            else if (s.equals(")")) {
                Double value = vals.pop();
                final String operator = operators.pop();
                if(operator.equals("+")) value = value + vals.pop();
                if(operator.equals("-")) value = vals.pop() - value;
                if(operator.equals("*")) value = vals.pop() * value;
                if(operator.equals("/")) value = vals.pop() / value;
                vals.push(value);

            } else {
                vals.push(Double.valueOf(s));
            }
        }
        return vals.pop();
    }

    public static void main(String[] args) {
        System.out.println(new DikstraParsing().parse("( ( 1 + 2 ) * ( 5 - 1 ) )"));
    }
}
