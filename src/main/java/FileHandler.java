import java.io.IOException;
import java.io.RandomAccessFile;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;

public class FileHandler {

    public FileHandler(){

    }

    public static String randomRead(String fileName, int start, int len){
        try (RandomAccessFile rf = new RandomAccessFile("N:\\Computers\\Yr 12\\!Files!\\" + fileName + ".txt", "rws")){
            rf.seek(start);
            char letter = (char)rf.read();
            String lettter = String.valueOf(letter);
            //System.out.println(letter);
            return lettter;
        }
        catch (IOException e){
            e.printStackTrace();
        }
        return "@";
    }


    public static long getRandomLength(String fileName) {
        //Returns length of a file

        try (RandomAccessFile rf = new RandomAccessFile(fileName, "rws")) {
            return rf.length();
        } catch (IOException e) {
            System.out.println("Oopsy poopsy");
            return 0;
        }
    }

    public static void randomWrite(String fileName, int start, String text) {
        //Writes into text file
        try (RandomAccessFile rf = new RandomAccessFile(fileName, "rws")) {
            rf.seek(start);
            for (int i = 0; i < text.length(); i++) {
                rf.write(text.charAt(i));
            }

        } catch (IOException e) {
            System.out.println("Oopsy poopsy");
        }
    }

    public static void appendLine(String fileName, String data) {
        // write text to end of the file
        boolean append = true;
        try (PrintWriter pr = new PrintWriter(new FileWriter(fileName, append))) {
            pr.println(data);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String readLineAt(String fileName, int start) {
        // grab the line from position "start" in the file
        try (RandomAccessFile rf = new RandomAccessFile(fileName, "rws")) {
            rf.seek(start);
            String answer = rf.readLine();
            return answer;
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


    public static void writeLineAt(String fileName, String data, int start) {
        // overwrite a line from position "start" in the file
        // doesn't check that the start position is actually
        // the beginning of the file. This will not behave well
        // unless every line is the same length


        try (RandomAccessFile rf = new RandomAccessFile(fileName, "rws")) {
            rf.seek(start);
            rf.writeBytes(data);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static int countLines(String fileName) {
        // return the number of lines in the file
        int count = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line = br.readLine();
            while (line != null) {
                count++;
                System.out.println(line);
                line = br.readLine();
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return count;
    }

}
