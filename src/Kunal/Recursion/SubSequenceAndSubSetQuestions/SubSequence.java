package Kunal.Recursion.SubSequenceAndSubSetQuestions;

import java.util.ArrayList;
import java.util.List;


class SubSequence{
    public static void main(String[] args) {
        String str = "abc";

        subSequence("", str);
        System.out.println(subSequence2("", str));
        subSequenceWithAscii("", str);
    }

    static void subSequence(String p, String up){
        if(up.isEmpty()){
            if(p.isEmpty()){
                return;
            }
            System.out.println(p);
            return;
        }


        char ch = up.charAt(0);
        
        subSequence(p + ch, up.substring(1));
        subSequence(p, up.substring(1));
    }


    static List<String> subSequence2(String p, String up){
        if(up.isEmpty()){
            List<String> ls = new ArrayList<>();
            if(!p.isEmpty()){
                ls.add(p);
            }
            return ls;
        }


        char ch = up.charAt(0);
        
        List<String> left = subSequence2(p + ch, up.substring(1));
        List<String> right = subSequence2(p, up.substring(1));
        left.addAll(right);
        return left;
    }

    static void subSequenceWithAscii(String p, String up){
        if(up.isEmpty()){
            if(p.isEmpty()){
                return;
            }
            System.out.println(p);
            return;
        }


        char ch = up.charAt(0);
        
        subSequenceWithAscii(p + ch, up.substring(1));
        subSequenceWithAscii(p + (ch + 0), up.substring(1));
        subSequenceWithAscii(p, up.substring(1));
    }
}