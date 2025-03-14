package com.example.VersionControl;

import com.example.VersionControl.Exceptions.InvalidExpressionException;
import java.util.regex.Pattern;

public class ExpressionManager {
    public static Expression parse(String value) throws InvalidExpressionException{
        Expression exp = new Expression();
        // find which operator
        for(var i : operators){
            if(value.contains(i)){
                exp.operator=i;
                break;
            }
        }
        // no operator was found
        if(exp.operator== null){
            throw new InvalidExpressionException("No operator found");
        }
        
        // split around operator making "1 + 1" = new String[] {1, 1}
        String[] split = value.split(Pattern.quote(exp.operator));
        // set the left hand side of the expression
        try{
            exp.lhs = Float.parseFloat(split[0]);
        }catch(NumberFormatException nf){
            throw new InvalidExpressionException("LHS: Expected a number, found \""+split[0]+"\"");
        }
        // set the right hand side of the expression
        exp.lhs = Float.parseFloat(split[1]);
        return exp;
    }
    private static String[] operators = new String[]{"+","-"};
    
}