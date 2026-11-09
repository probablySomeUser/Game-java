import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Input{
    public Scanner reader = new Scanner(System.in);

    Input(Scanner scanner){
        this.reader = scanner;
    }

    Input(){
        
    }

    public int getInt(int min, int max, Scanner scanner){
        int answer;
        while (true) {
            try{
            TimeUnit.SECONDS.sleep(1);
            } catch(Exception e) {
                System.out.println("Hello");
            }
            try{
            answer = Integer.valueOf(scanner.nextLine());
            } catch(Exception e){
                System.out.println("That is not an integer, try again");
                continue;
            }
            if(min<= answer && answer<= max){
            return answer;
            }
            System.out.println("That is not an option, try again");
        }
    }

    public int getInt(int min, int max){
        return getInt(min, max,reader);
    }
    
    public int getOption(ArrayList<?> options,Scanner scanner){
        if(options.size()==0){
            return -1;
        }
        int n= options.size();
        for(int i = 0; i<n;i++){
            System.out.println(i+1 + ") " + options.get(i));
        }
        int answer = getInt(1, n, scanner)-1;
        return answer;
    }

    public int getOption(ArrayList<?> options){
        return getOption(options,reader);
    }
}