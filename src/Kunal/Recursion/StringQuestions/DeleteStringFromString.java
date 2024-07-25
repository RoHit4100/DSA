
class DeleteStringFromString{
    public static void main(String[] args){
        String str = "hello apple rohit";
        System.out.println(removeAppNotApple(str));
        skipApple("", str);

    }

    static void skipApple(String p, String up){
        if(up.isEmpty()){
            System.out.println(p);
            return;
        }

        if(up.startsWith("apple")){
            skipApple(p, up.substring(5));
        }else{
            skipApple(p + up.charAt(0), up.substring(1));
        }
    }

    static String removeApple(String str){
        if(str.isEmpty()){
            return "";
        }

        if(str.startsWith("apple")){
            return removeApple(str.substring(5));
        }else{
            return str.charAt(0) + removeApple(str.substring(1));
        }
    }

    static String removeAppNotApple(String str){
        if(str.isEmpty()){
            return "";
        }

        if(str.startsWith("app") && !str.startsWith("apple")){
            return removeApple(str.substring(3));
        }else{
            return str.charAt(0) + removeAppNotApple(str.substring(1));
        }
    }
}