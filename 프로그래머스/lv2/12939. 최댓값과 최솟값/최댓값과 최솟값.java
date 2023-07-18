import java.util.*;
class Solution {
    public String solution(String s) {
        String[] numberArray = s.split(" ");   
        int arrayLength = numberArray.length;
        int min = firstNumber(numberArray);
        int max = firstNumber(numberArray);
        
        for(int index = 1; index < arrayLength; index++){
            int number = Integer.parseInt(numberArray[index]);
            if(min > number) min = number;
            if(max < number) max = number;
        }
        
        return min + " " + max;
    }
    
    public Integer firstNumber(String[] numberArray){
        if(numberArray.length == 0 )return null;
        else return Integer.parseInt(numberArray[0]);
    }
}