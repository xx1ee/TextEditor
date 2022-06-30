import java.util.Locale;

class Seven {
    public static SeptenaryStringFunction fun = (s1, s2, s3, s4, s5, s6, s7) -> {return (s1 + s2 + s3 + s4 + s5 + s6 + s7).toUpperCase();};
    //String val = fun.apply(String s1, String s2, String s3, String s4, String s5, String s6, String s7);
}

@FunctionalInterface
interface SeptenaryStringFunction {
    String apply(String s1, String s2, String s3, String s4, String s5, String s6, String s7);
}