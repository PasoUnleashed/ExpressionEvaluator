package com.example.VersionControl;

public class Expression {
    // left hand side of the expression >1 + 1
    public float lhs;
    // right hand side of the expression 1 + >1
    public float rhs;
    // operator of the expression 1 >+ 1
    public String operator;
    // calculates the result of the expression
    public String evaluate(){
        if(operator.equals("+")){
            float sum = (lhs+rhs);
            return Float.toString(sum);
        }
        return "Evaluation not implemented";
    }
}
