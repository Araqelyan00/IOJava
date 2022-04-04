package problem1;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        File file = new File("Hello.txt");
        if (!file.exists()) {
            file.createNewFile();
        }
        FileWriter fileWriter = new FileWriter(file);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        bufferedWriter.write("Hello world, hello darkness my old friend hello hello");
        bufferedWriter.flush();
        bufferedWriter.close();

            String line;
            int count = 0;
            int numOfHelloWords = 0;

            //Opens a file in read mode
            FileReader fileReader = new FileReader(file);
            BufferedReader br = new BufferedReader(fileReader);

            //Gets each line till end of file is reached
            while((line = br.readLine()) != null) {
                //Splits each line into words
                String[] words;
                words = line.split(" ");
                //Counts each word
                count = count + words.length;
                for (String s: words){
                    if (s.equals("hello") || s.equals("Hello")){
                        numOfHelloWords++;
                    }
                }
            }


            System.out.println("Number of hello in given file: " + numOfHelloWords);
            br.close();
        }
}
