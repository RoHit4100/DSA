
class ProductsOfDigits{
    public static void main(String[] args){
        System.out.println(getProduct(55));
    }
    
    static int getProduct(int n){
        if(n % 10 == n){
            return n;
        }

        return (n % 10) * getProduct(n / 10);
    }
}