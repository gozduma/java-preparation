package test;

public class Recursia {
    public static boolean isPalindromeRec(String str, String str2) {
        if (str.length() <= 1)
            return false;

        if (str2.charAt(0) != str.charAt(0))
            return false;

        return isPalindromeRec(str.substring(),str2);
    }
}
class Tee{
    public static void main(String[] args) {
        boolean a =Recursia.isPalindromeRec("sssssssssssssddd", "d");
        System.out.println(a);
    }
}
