import java.util.Scanner;
import java.util.stream.Gatherer.Integrator;
import java.util.ArrayList;
class InputTest{
    public static void getIntTest(Input reader, int min, int max, String input, int expectation){
        Scanner scanner = new Scanner(input);
        int result = reader.getInt(min,max,scanner);
        if(result == expectation){
            System.out.println("Pass");
        } else{
            System.out.println("Fail");
        }
    }
    
    public static void getOptionTest(Input reader, ArrayList<?> options,String input, Object expectation){
        Scanner scanner = new Scanner(input);
        Object result = reader.getOption(options,scanner);
        if(result.equals(expectation)){
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }
    }

    
    public static void main(){
        Input testReader = new Input();
        System.out.println("Testing getInt");
        getIntTest(testReader,1,5,"3",3);
        getIntTest(testReader,-4,0,"-1",-1);
        getIntTest(testReader,0,5,"-1\nHello\n3",3);
        System.out.println("Testing getOption");
        ArrayList<Integer> numbers = new ArrayList<Integer>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        getOptionTest(testReader, numbers, "1", 0);
        getOptionTest(testReader, numbers, "2", 1);
        getOptionTest(testReader, numbers, "4\n2", 1);
        ArrayList<String> text = new ArrayList<>();
        text.add("First");
        text.add("Second");
        text.add("Third");
        text.add("Fourth");
        getOptionTest(testReader, text, "4", 3);
        getOptionTest(testReader, text, "Hello\n0\n2", 1);
    }

}