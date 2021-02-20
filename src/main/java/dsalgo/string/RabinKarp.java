package dsalgo.string;

public class RabinKarp {
    // d is the number of characters in the alphabet
    public final static int d = 256;

    public static void main(String[] args) {
        String txt = "piyush dubey is piyush ";
        String pat = "piyush";

        // A prime number
        int q = 101;

        // Function Call
        search(pat, txt, q);
    }

    private static void search(String pat, String txt, int q) {
        int m = pat.length();
        int n = txt.length();
        int p = 0; //hash of pattern
        int t = 0; // hash of text
        int h = 1;

        for(int i=0;i<m-1;i++){
            h = (h*d)%q;
        }

        for(int i=0;i<m;i++){
            p = (p*d + pat.charAt(i))%q;
            t = (t*d + txt.charAt(i))%q;
        }

        for(int i=0;i<=n-m;i++){
            if(p == t){
                for(int j=0;j<m;j++){
                    if(txt.charAt(i+j) != pat.charAt(j)){
                        break;
                    }else {
                        if(j == m-1){
                            System.out.println("pat found at :"+i);
                        }
                    }
                }
            }
            if(i<n-m)
            t = (d*(t-(txt.charAt(i)*h)) + txt.charAt(i+m))%q;
           if(t<0){
                t = t+q; //-55%101 = 46 but in programming language -55%101=-55 so to compensate that we add 101 to negative number
            }
        }
    }
}
