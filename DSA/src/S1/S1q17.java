package S1;



public class S1q17 {
    
    static int result = 0;
    
    static void f(String s, int y) {
        System.out.println(s);
        switch (s) {
            case "+x*x":
                result += y*y;
                break;
            case "-x*x":
                result += - (y*y);
                break;
            case "+x/x":
                result += y/y;
                break;
            case "-x/x":
                result += - (y/y);
                break;
            case "-x":
                result += -y;
                break;
            case "+x":
                result += +y;
                break;
            default:
                for (int i = s.length()-1; i>=0; i--) {
                    if (s.charAt(i) == '+') {
                        f(s.substring(0, i), y);
                        f(s.substring(i, s.length()), y);
                        break;
                    } else if (s.charAt(i) == '-') {
                        
                        f(s.substring(0, i), y);
                        
                        f(s.substring(i, s.length()), y);
                        
                        break;
                    }
                }
                break;
        }
        System.out.println(result);
    }
    
    public static void main(String[] args) {
        int y = 2;
        String s = "+x*x-x+x-x-x+x/x";
        f(s, y);
        
    }
}
