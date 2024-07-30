package Strivers.StacksAndQueues.Conversions;

import java.util.Stack;

public class InfixToPostAndPreFix {
    public static void main(String[] args) {
        // infix == a + b * c
        // postfix == abc*+
        System.out.println(convert(new Stack<Character>(), "a+b*c", ""));

        // to convert infix to prefix
        // u have to reverse the given string, and the replace all the ( brackets with ), and vise versa
        // and then call the convert function but with controlled conditions, where the priority will not be <= here
        // it will be strictly < and rest will be the same.
        System.out.println(convertToPrefix(new Stack<Character>(), "a+b*c", ""));
    }

    static String convertToPrefix(Stack<Character> stack, String eq, String ans){
        StringBuilder reversed = new StringBuilder();
        for (int i = eq.length() - 1; i >= 0; i--) {
            char ch = eq.charAt(i);
            if (ch == '(') {
                reversed.append(')');
            } else if (ch == ')') {
                reversed.append('(');
            } else {
                reversed.append(ch);
            }
        }
        eq = reversed.toString();

        // Convert reversed infix to postfix
        StringBuilder postfix = new StringBuilder(convertControlled(stack, eq, ans));

        // Reverse postfix to get prefix
        return postfix.reverse().toString();
    }

    static String convertControlled(Stack<Character> stack, String eq, String ans){
        // now I have to convert string into postfix
        int i = 0;
        while (i < eq.length()){
            char ch = eq.charAt(i);
            // first I have to check whether the current character is digit or letter
            if(Character.isLetterOrDigit(ch)){
                ans += ch;
            }else if(ch == '('){ // here I check whether the stack is empty or the current
                // character is (
                // if these is true then just add it into the stack
                stack.push(ch);
            }else if(ch == ')'){
                // here if it is closing bracket then I have to remove all the elements till the opening brackets
                while (!stack.isEmpty() && stack.peek() != '('){
                    ans += stack.pop();
                }
                // in the end just remove the opening brackets also
                if(!stack.isEmpty() && stack.peek() == '('){
                    stack.pop();
                }
            }else{
                // now check the priority of operators, in control environment
                // if priority of current character is less than the operator present in the stack then remove all the
                // element until the priority of current character becomes greater than the first element of the stack
                while(!stack.isEmpty() && priority(ch) <= priority(stack.peek())){
                    ans += stack.pop();
                }
                stack.push(ch);
            }
            i++;
        }

        // in the end just remove all the elements present in the stack
        while (!stack.isEmpty()){
            ans += stack.pop();
        }
        return ans;
    }


    static String convert(Stack<Character> stack, String eq, String ans){
        // here I have to check whether all the rules written below are true,
        /*
            Start with an empty stack and an empty output.
            Scan the infix expression from left to right.
            Append operands (variables and constants) directly to the output.
            Push operators onto the stack, but pop from the stack to the output any operators that have higher or equal precedence.
            Pop all remaining operators from the stack to the output at the end.
         */
        int i = 0; // to traverse into the string.
        while (i < eq.length()){
            char c = eq.charAt(i);

            // first condition will be to check whether the current item is operand or not
            if(Character.isLetterOrDigit(c)){
                ans += c;
            } else if(c == '('){
                // here I am going to push the open bracket
                stack.push(c);
            } else if(c == ')'){
                // and when I am going to encounter close bracket, then all the elements which are present till
                // that point those elements will be popped out
                while(!stack.isEmpty() && stack.peek() != '('){
                    ans += stack.pop();
                }
                // in the end pop the opening bracket also
                if (!stack.isEmpty() && stack.peek() == '(') {
                    stack.pop();
                }
            } else {
                // now I have to check the priority of the operator
                while(!stack.isEmpty() && priority(c) <= priority(stack.peek())){
                    ans += stack.pop();
                }
                stack.push(c);
            }
            i++;
        }
        // Pop all the operators left in the stack
        while(!stack.isEmpty()){
            ans += stack.pop();
        }
        return ans;
    }


    static int priority(char ch){
        if(ch == '^'){
            return 3;
        }else if(ch == '*' || ch == '/'){
            return 2;
        }else if(ch == '+' || ch == '-'){
            return 1;
        }
        return -1;
    }

}
