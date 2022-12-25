package test;
import java.util.HashMap;
import java.util.Map;
public class map {
    public static void main(String[] args) {
        Map <Integer, String> passport = new HashMap<Integer,String>();
        passport.put(424224, "Ламонов С.А.");
        passport.put(124222, "Газуев А.Е.");
        passport.put(337337, "Шурышкин П.Ш.");
        System.out.println(passport);
        System.out.println(passport.get(337337));
        System.out.println(passport.entrySet());
        System.out.println(passport.keySet());
        System.out.println(passport.values());
    }
}

