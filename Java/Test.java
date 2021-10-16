public class Test {
    public static void main(String[] args) {
        
        
    }

    public static int fact(int num){
        if(num == 0) return num;

        return num*fact(num-1);
    }
}
