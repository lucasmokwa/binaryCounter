import java.util.*;


// Count the number of subsequent 1 in the binary representation of an input int
public class binaryCounter {

    private static String convertBinary(int number){
        //We will use a stack to store the divisions necessary to convert the base 
        Stack<Character> stack = new Stack<Character>();
        
        int n = number;
        int mod;
        while(n >0){
            mod = n%2;
            if(mod == 0){
                stack.push('0');
            }else{
                stack.push('1');
            }
            n /=2;
        }
        
        char[] charArray = new char[stack.size()];
        int i =0;
        while(!stack.isEmpty()){
            charArray[i++] = stack.pop();
        }
        
        return String.copyValueOf(charArray);
    }
    private static int countConsecutive(String inputString, char target){
        int finalCounter = 0;
        int tryCounter = 0;
        
        int n = inputString.length();
        
        //check for index of target, for existence of it in string
        //otherwise skips for loop
        if(inputString.indexOf(target)>=0){
            
            for(int i =0; i<n; i++){
                if (inputString.charAt(i)==target){
                    tryCounter++;
                }else {
                    if(tryCounter>finalCounter){
                        finalCounter = tryCounter;
                    }
                    tryCounter = 0;
                    
                }
            }
            
            //if the last char is the target
            //we can have last tryCounter > finalCounter
            if(tryCounter>finalCounter){
                finalCounter = tryCounter;
            }
        }
        
        return finalCounter;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        
        String binaryNumber = convertBinary(n);
        int consecutiveOnes = countConsecutive(binaryNumber,'1');

        System.out.println(consecutiveOnes);
        
        scanner.close();
    }
}


