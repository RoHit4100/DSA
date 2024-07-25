class DeleteCharacter{
    public static void main(String[] args){
        String str = "sharadau";
        System.out.println("After removing a from this string " + remove(str, "", 0));
        System.out.println(remove(str));
        skip("", str);
    }

    static String remove(String str, String ans, int index){
        if(str.length() == index){
            return ans;
        }

        char ch = str.charAt(index);
        if(ch == 'a'){
            return ans + remove(str, ans, index + 1);
        }else{
            return ans + ch + remove(str, ans, index + 1);
        }
    }

    static String remove(String str){
        if(str.isEmpty()){
            return "";
        }

        char ch = str.charAt(0);
        if(ch == 'a'){
            return remove(str.substring(1));
        }else{
            return ch + remove(str.substring(1));
        }
    }


    static void skip(String p, String up){
        if(up.isEmpty()){
            System.out.println(p);
            return;
        }

        char ch = up.charAt(0);
        if(ch == 'a'){
            skip(p, up.substring(1));
        }else{
            skip(p + ch, up.substring(1));
        }
    }
}