import java.io.IOException;
import java.io.RandomAccessFile;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;

public class FileHandler {

    public static String fileRead(String fileName, int start, int length) {
        //gets String from point
        try (RandomAccessFile rf = new RandomAccessFile(fileName, "rws")) {
            rf.seek(start);
            if (length == 0) {
                //Whole line
                String read = rf.readLine();
                return read;
            } else {
                //Specific length, using a string builder to omit carriage returns
                StringBuilder output = new StringBuilder();

                for (int i = 0; i < length; i++) {
                    char nextC = (char) rf.read();

                    if (Character.toString(nextC).equals("\r")) {
                        i++;
                    } else {
                        output.append(nextC);
                    }
                }
                return output.toString();
            }
        } catch (IOException e) {
            System.out.println("Random read error!");
            return null;
        }
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

    //TODO - FIX
    public static void randomWrite(String fileName, int start, String text) {
        //Writes into text file
        try (RandomAccessFile rf = new RandomAccessFile(fileName, "rws")) {
            rf.seek(start == -1 ? rf.length() : start);
            for (int i = 0; i < text.length(); i++) {
                rf.write(text.charAt(i));
            }


        } catch (IOException e) {
            System.out.println("Oopsy poopsy");
        }
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
