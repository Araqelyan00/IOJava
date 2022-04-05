package problem1;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        File file = new File("Hello.txt");
        File outputFile = new File("OutputFile.txt");
        if (!file.exists()) {
            file.createNewFile();
        }
        FileWriter fileWriter = new FileWriter(file);

        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        bufferedWriter.write("Hello world, hello darkness my old friend hello hello\n" +
                "Hello darling.\n" +
                "Hello hello");
        bufferedWriter.flush();
        bufferedWriter.close();
        BufferedWriter bf = new BufferedWriter(new FileWriter(outputFile));

            String line;
            int count = 0;


            //Opens a file in read mode
            FileReader fileReader = new FileReader(file);
            BufferedReader br = new BufferedReader(fileReader);

            //Gets each line till end of file is reached
            while((line = br.readLine()) != null) {
                int numOfHelloWords = 0;
                count ++;
                String[] words;
                words = line.split(" ");
                for (String s: words){
                    if (s.equals("hello") || s.equals("Hello")){
                        numOfHelloWords++;
                    }
                }

                bf.write("In line : " + count +" - " + numOfHelloWords);
                bf.newLine();
                //System.out.println("In line" + count +" - " + numOfHelloWords);

            }

            bf.flush();
            bf.close();
            br.close();
        }
}
