package com.example.VersionControl;

import com.example.VersionControl.Exceptions.InvalidExpressionException;
import java.util.regex.Pattern;

public class ExpressionManager {
    public static Expression parse(String value) throws InvalidExpressionException{
        Expression exp = new Expression();
        for(var i : operators){
            if(value.contains(i)){
                exp.operator=i;
                break;
            }
        }
        if(exp.operator== null){
            throw new InvalidExpressionException("No operator found");
        }
        String[] split = value.split(Pattern.quote(exp.operator));
        try{
            exp.rhs = Float.parseFloat(split[0]);
        }catch(NumberFormatException nf){
            throw new InvalidExpressionException("Expected a number, found \""+split[0]+"\"");
        }
        exp.lhs = Float.parseFloat(split[1]);
        return exp;
    }
    private static String[] operators = new String[]{"+","-"};
    
}