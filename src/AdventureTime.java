import java.io.*;
import java.util.Scanner;

public class AdventureTime {


    public static void main(String[] args) throws IOException {
        int challengeOneAnswer = challengeOne("InputOneTwo.txt");
        System.out.println(challengeOneAnswer);
        int challengeTwoAnswer = challengeTwo("InputOneTwo.txt");
        System.out.println(challengeTwoAnswer);
        int challengeThreeAnswer = challengeThree("InputThreeFour.txt");
        System.out.println(challengeThreeAnswer);
        int challengeFourAnswer = challengeFour("InputThreeFour.txt");
        System.out.println(challengeFourAnswer);

        writeFileAllAnswers("AdventureTime.txt",challengeOneAnswer,challengeTwoAnswer,challengeThreeAnswer,challengeFourAnswer);
    }


    public static int challengeOne(String fileName) throws IOException {
        File file = new File(fileName);
        Scanner scanner = new Scanner(file);
        int a=0;
        int b=-1;
        while(scanner.hasNextLine()){
            int ok = scanner.nextInt();
            if(b==-1) {

            }else{
                if(ok>b) {
                    a++;
                }
            }
            b=ok;
        }
        return a;
    }


    public static int challengeTwo(String fileName) throws FileNotFoundException {
        File file = new File(fileName);
        Scanner scanner = new Scanner(file);
        int num1=0,num2=0,num3=0;
        int a=0;
        int b=0;
        int c=0;
        while(scanner.hasNextLine()){
            num1=num2;
            num2=num3;
            num3=scanner.nextInt();
            if(b>2){
                if(num1+num2+num3>a){
                    c++;
                }
                a = num1+num2+num3;
            }
            b++;
        }
        return c;
    }

    public static int challengeThree(String fileName) throws FileNotFoundException {
        File file = new File(fileName);
        Scanner scanner = new Scanner(file);
        int h=0,v=0;
        while(scanner.hasNextLine()){
            String ok = scanner.nextLine();
            String word="";
            int x=0;
            for(int i=0;i<ok.length();i++){
                if(ok.charAt(i)>='0'&&ok.charAt(i)<='9'){
                    x = x*10 + ok.charAt(i)-'0';
                }else if(ok.charAt(i)!=' '){
                    word+=ok.charAt(i);
                }
            }
            if(word.equals("forward")) h+=x;
            else if(word.equals("up")) v-=x;
            else if(word.equals("down")) v+=x;
        }
        return h*v;
    }


    public static int challengeFour(String filename) throws FileNotFoundException {
        File file = new File(filename);
        Scanner scanner = new Scanner(file);
        int h=0,v=0,aim=0;
        while(scanner.hasNextLine()){
            String ok = scanner.nextLine();
            String word = "";
            int x = 0;
            for(int i=0;i<ok.length();i++){
                if(ok.charAt(i)>='0'&&ok.charAt(i)<='9'){
                    x = x*10 + ok.charAt(i)-'0';
                }else if(ok.charAt(i)!=' '){
                    word += ok.charAt(i);
                }
            }
            if(word.equals("forward")){
                h+=x;
                v+=x*aim;
            }else if(word.equals("down")) aim+=x;
            else if(word.equals("up")) aim-=x;
        }
        return h*v;
    }

    private static void writeFileAllAnswers(String outPutFilename, int challengeOne, int challengeTwo, int challengeThree, int challengeFour) throws IOException {
        File file = new File(outPutFilename);
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
        bufferedWriter.write("Challenge 1: " + "\t" + challengeOne + "\n");
        bufferedWriter.write("Challenge 2: " + "\t" + challengeTwo + "\n");
        bufferedWriter.write("Challenge 3: " + "\t" + challengeThree + "\n");
        bufferedWriter.write("Challenge 4: " + "\t" + challengeFour + "\n");
        bufferedWriter.close();
    }

    private static int[] readFile(String inputFilename) throws FileNotFoundException {
        File file = new File(inputFilename);
        Scanner scanner = new Scanner(file);
        int numberOfLinesInFile = countLinesInFile(inputFilename);
        int[] data = new int[numberOfLinesInFile];
        int index = 0;
        while (scanner.hasNextLine()) {
            data[index++] = scanner.nextInt();
        }
        scanner.close();
        return data;
    }

    private static int countLinesInFile(String inputFilename) throws FileNotFoundException {
        File file = new File(inputFilename);
        Scanner scanner = new Scanner(file);
        int lineCount = 0;
        while (scanner.hasNextLine()) {
            lineCount++;
            scanner.nextLine();
        }
        scanner.close();
        return lineCount;
    }

}