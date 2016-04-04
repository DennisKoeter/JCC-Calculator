/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculator;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Dennis
 */
public class Processor {
    private List<Character> signs;
    private List<Double> numbers;
    private ObservableList<String> oList;
    DecimalFormat df;
    
    public Processor(){
        oList = FXCollections.observableArrayList();
        df = new DecimalFormat("####################.####################");
    }
    
    public ObservableList returnList(){
        oList.add("----------------------------------------------------------------------");
        return oList;
    }
    
    public void clearList(){
        oList.clear();
    }
    
    public String calculateString(String input){
        oList.add(input);
            int plus = 0;
            int minus = 0;
            int multiply = 0;
            int divide = 0;
            int root = 0;
            int power = 0;
            int next = -1;
            String temp = "";
            String before = "";
            String after = "";
            String calculation = "";
            
            //setting up lists
            signs = updateSigns(input);
            numbers = updateNumbers(input, signs);
            
            //returning final value
            int operators = signs.size();
            if(operators == 0){
                return input;
            }
            
            //commence calculations!
            for(int i = 0; i < operators; i++){
                plus = signs.indexOf('+');
                minus = signs.indexOf('-');
                multiply = signs.indexOf('x');
                divide = signs.indexOf('/');
                root = signs.indexOf('v');
                power = signs.indexOf('^');

                if ((root != -1 && power != -1) || root != -1 || power != -1)
                {
                    if (root > -1 && power > -1) next = Math.min(root, power);
                    else next = Math.max(root, power);
                }
                else if ((multiply != -1 && divide != -1) || multiply != -1 || divide != -1)
                {
                    if (multiply > -1 && divide > -1) next = Math.min(multiply, divide);
                    else next = Math.max(multiply, divide);
                }
                else if (((plus != -1 && minus != -1) || plus != -1 || minus != -1) && next == -1)
                {
                    if (plus > -1 && minus > -1) next = Math.min(plus, minus);
                    else next = Math.max(plus, minus);
                }
                
                calculation = df.format(numbers.get(next)) 
                        + String.valueOf(signs.get(next)) 
                        + df.format(numbers.get(next + 1));
                
                temp = df.format(compute(calculation));
                
                before = "";
                
                for(int j = 0; j < next; j++){
                    before += df.format(numbers.get(j));
                    before += String.valueOf(signs.get(j));
                }

                if (signs.size() > next + 1)
                {
                    after = String.valueOf(signs.get(next + 1));

                    for (int k = next + 2; k < numbers.size(); k++)
                    {
                        after += df.format(numbers.get(k));
                        if (signs.size() > k) after += String.valueOf(signs.get(k));
                    }
                }
                else
                {
                    after = "";
                }

                //cleaning up code for next iteration
                temp = before + temp + after;
                oList.add(temp);

                signs = updateSigns(temp);
                numbers = updateNumbers(temp, signs);

                if (numbers == null || numbers.size() == 1) return temp;

                next = -1;
            }
            
            return null;
        }
    
    private List<Character> updateSigns(String input){
        signs = new ArrayList<Character>();
        for(Character c : input.toCharArray()){
            if(c == '+' || c == '-' || c == '/' || c == 'x' || c == '^' || c == 'v') signs.add(c);
        }
        
        return signs;
    }
    
    private List<Double> updateNumbers(String input, List<Character> l){
        numbers = new ArrayList<Double>();
        for (int i = 0; i < l.size(); i++){
            numbers.add(Double.parseDouble(input.substring(0, input.indexOf(l.get(i)))));
            input = input.substring(input.indexOf(signs.get(i)) + 1);
        }
        numbers.add(Double.parseDouble(input));
        
        return numbers;
    }
    
    private double compute(String input)
        {
            double answer = 0.0;

            if (input.contains("+")) answer = add(input);
            if (input.contains("-")) answer = subtract(input);
            if (input.contains("x")) answer = multiply(input);
            if (input.contains("/")) answer = divide(input);
            if (input.contains("v")) answer = root(input);
            if (input.contains("^")) answer = power(input);

            return answer;
        }

        private static double add(String input)
        {
            int plus = input.indexOf('+');
            return Double.parseDouble(input.substring(0, plus)) + Double.parseDouble(input.substring(plus + 1));
        }

        private static double subtract(String input)
        {
            int minus = input.indexOf('-');
            return Double.parseDouble(input.substring(0, minus)) - Double.parseDouble(input.substring(minus + 1));
        }

        private static double multiply(String input)
        {
            int multiply = input.indexOf('x');
            return Double.parseDouble(input.substring(0, multiply)) * Double.parseDouble(input.substring(multiply + 1));
        }

        private static double divide(String input)
        {
            int divide = input.indexOf('/');
            return Double.parseDouble(input.substring(0, divide)) / Double.parseDouble(input.substring(divide + 1));
        }
        
        private static double root(String input)
        {
            int root = input.indexOf('v');
            return Math.pow(Double.parseDouble(input.substring(root + 1)), 1 / Double.parseDouble(input.substring(0, root)));
        }
        
        private static double power(String input)
        {
            int power = input.indexOf('^');
            return Math.pow(Double.parseDouble(input.substring(0, power)), Double.parseDouble(input.substring(power + 1)));
        }
}
