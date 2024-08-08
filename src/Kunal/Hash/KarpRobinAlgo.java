package Kunal.Hash;

public class KarpRobinAlgo {
    // this algorithm is used for string matching

    public static void main(String[] args) {
        String a = "rohit";
        String b = "krushnarohitsharadalaxman";
        int len = a.length();
        int hashA = a.hashCode();
        boolean found = false;
        for(int i = 0; i < b.length() - len; i++){
            String temp = b.substring(i , i +  len);
            int hashCode = temp.hashCode();
            // if sometimes hashcode is same then I have to check for the string as well, by checking whether the given
            // string and found string is same or not
            if(hashCode == hashA && a.equals(temp)){
                found = true;
                break;
            }
        }
        System.out.println(found);
    }
}
