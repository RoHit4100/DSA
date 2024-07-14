class PermutationOfString{
    public static void main(String[] args){
        String str = "abc";
        permutation("", str);
    }

    static void permutation(String p, String up){
        if(up.isEmpty()){
            System.out.println(p);
            return;
        }

        char ch = up.charAt(0);
        // here we don't know how much recursion call will be at each level so thats why we are going to depend on the size of p string
        // so we will use the for loop until the size of the string.

        for(int i = 0; i <= p.length(); i++){
            String f = p.substring(0, i);
            String l = p.substring(i, p.length());
            permutation(f + ch + l, up.substring(1));
        }
    }
}