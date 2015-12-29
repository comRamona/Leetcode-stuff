/**
 * Created by rama on 29/12/15.
 */
public class CountOnes {
    /**
     * Calculate the numbers of  one's in numbers less or equal to n
     * <p>
     * 1) separate the n to two parts. considering n is `abc`
     * <p>
     * 2) at first, we seprate it to `ab` & `c`, then,
     * c == 0,  the # of `1` appears in uints is  "ab * 1"
     * c == 1,  the # of `1` appears in units is  "ab * 1 + 0 + 1" (0 means the number after `c`)
     * c > 1 ,  the # of `1` appears in units is  "(ab+1)*1"
     * <p>
     * 3) at second, we seprate it to `a` & `bc`, then,
     * b == 0,  the # of `1` appears in tens is  "a * 10"
     * b == 1,  the # of `1` appears in tens is  "a * 10 + c + 1" (`c` means the number after `b`)
     * b > 1 ,  the # of `1` appears in tens is  "(a+1)*10"
     * <p>
     * 4) at thrid, we seprate it to `` & `abc`, then,
     * a == 0,  the # of `1` appears in tens is  "0 * 100" ( 0 menas the number before `a`)
     * a == 1,  the # of `1` appears in tens is  "0 * 100 + bc + 1" (`bc` means the number after `a`)
     * a > 1 ,  the # of `1` appears in tens is  "(0+1)*100"
     * <p>
     * <p>
     * For some examples:
     * 0) n = 5,   we have (0+1)*1 = 1 digit 1
     * 1) n = 53,  we have  (5+1)*1  + (0+1)*10   = 16  digit 1
     * 2) n = 20,  we have     (2*1) + (0+1)*10   = 12  digit 1
     * 3) n = 21,  we have (2*1+0+1) + (0+1)*10   = 13  digit 1
     * 4) n = 13,  we have   (1+1)*1 + (0*10+3+1) = 6   digit 1
     * 5) n = 109, we have  (10+1)*1 + (1*10) + (0*100 + 09 + 1) = 31 digit 1
     * <p>
     * Converting the ideas to code as below:
     */
    public static int countDigitOne(int n) {
        long base = 1, left = n, right = 0, currDigit = 0;
        int numOfOne = 0;
        while (left > 0) {
            currDigit = left % 10;
            left = left / 10;

            if (currDigit == 0) {
                numOfOne += (left * base);
            } else if (currDigit == 1) {
                numOfOne += (left * base + right + 1);
            } else {
                numOfOne += ((left + 1) * base);
            }

            right = right + currDigit * base;
            base *= 10;
        }
        return numOfOne;
    }

    public static void main(String[] args) {
        countDigitOne(824883294);
    }
}