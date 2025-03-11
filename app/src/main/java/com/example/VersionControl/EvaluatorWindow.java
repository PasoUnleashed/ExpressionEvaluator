package com.example.VersionControl;

import com.example.VersionControl.Exceptions.InvalidExpressionException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class EvaluatorWindow{
    public JButton evaluateButton;
    public JTextField expressionText;
    public JLabel outputLabel;
    
    public EvaluatorWindow(){
        
        evaluateButton = new JButton("Click me!");
        outputLabel = new JLabel("Answer here");
        expressionText = new JTextField("Expression Goes Here");
        evaluateButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    Expression exp = ExpressionManager.parse(expressionText.getText());
                    System.out.println(exp.rhs);
                    System.out.println(exp.operator);
                    System.out.println(exp.lhs);
                    outputLabel.setText(exp.evaluate() );
                }catch (InvalidExpressionException ex){
                    outputLabel.setText(ex.getMessage());
                }catch(Exception ep){
                    outputLabel.setText("Unknown Exception");
                }
                
            }
            
        });
    }
    
    public void evaluate(){
        
    }
}