import java.sql.SQLOutput;
import java.io.File;

public class Database {

    private String filename;
    private int rowWidth;
    private int recordCount;

    public Database(String filename, int rowWidth) {
        this.filename = filename;
        this.rowWidth = rowWidth;
        recordCount = getRecordCount();
    }

    /*public void appendRecord(String data) {
        //Adds a record to the end of the database
        if (data.length() > lineLength) {
            System.out.println("Could not append data. String too long.");
        } else {
            FileHandler.fileWrite(filename,-1, String.format("%1$-" + lineLength + "s", data)+ "\r\n");
            recordCount++;
        }

    }*/

    public void deleteRecord(int rowNumber) {
        //TODO: Replace the specified line with a rare character that will likely not show up anywhere else in the code
       /*
       //Deletes the file
       File myObj = new File("test.txt");
       if (myObj.delete()) {
           System.out.println("Deleted the file: " + myObj.getName());
       } else {
           System.out.println("Failed to delete the file.");
       }
        */
        FileHandler.writeLineAt("text.txt", "~~~~~~~~~~", rowNumber);

    }

    public String getRecord(int rowNumber) {
        //System.out.println(rowNumber * (rowWidth+1));
        return FileHandler.readLineAt(filename, (rowWidth+2) * (rowNumber));
    }

    public int getRecordCount() {
        //Goes through the files noting the number of lines via increments
        int count = 0;
        String record = getRecord(count);
        //Goes through the file
        while (record != null){
            count++;
            record = getRecord(count);
        }
        return count;
    }

    public boolean findRecord(String data) {

        String temp;
        for (int i = 0; i < recordCount; i++) {
            //Temporarily holds a line from the file
            temp = "";
            temp = FileHandler.readLineAt(filename, (rowWidth+2) * (i));
            //Compares the strings and evaluates whether they're the same
            if (data.equals(temp)){
                return true;
            }
        }
        return false;
    }

}
