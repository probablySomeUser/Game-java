public class Utils{
    public static int moduloRepresentative(int integer, int minimum, int maximum){
        int range = maximum-minimum;
        int firstRep = integer % range;
        return firstRep+minimum;
    }
}