import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StatsGUI extends JPanel implements ActionListener {

    private int[] fields;
    JLabel statsTitle;
    JButton back;
    JTable tableOfStats;

    JButton sortButton;

    JComboBox sortByWhat;

    JScrollPane scrollPaneForTable;

    public StatsGUI(int[] fields){
        Database database = new Database("USRGroundVehicles.txt", 75, new int[]{4, 4, 3, 3, 3, 3, 3, 4, 9, 9, 30});
        this.fields = fields;
        String[] columns = new String[] {
                "Hits", "Crits", "Zone Captures", "Assists", "Kills", "Air Kills", "Deaths", "Games Played", "RP", "SL", "Name"
        };
        String[][] dataForTable = new String[database.getRecordCount()][fields.length];

        for (int i = 0; i < database.getRecordCount(); i++) {
            dataForTable[i] = database.recordToArray(i);
        }


        statsTitle = new JLabel("Statistics");
        statsTitle.setFont(new Font("Consolas", Font.PLAIN,50));
        statsTitle.setBounds(475,50,500,100);
        //mainMenuTitle.setBorder(BorderFactory.createEmptyBorder(100,100,100,100));
        setLayout(null);

        back = new JButton("Back");
        back.setBounds(125,600,300,100);
        back.addActionListener(this);

        tableOfStats = new JTable(dataForTable,columns);
        tableOfStats.setBounds(125,150,1100,400);
        tableOfStats.setAutoCreateRowSorter(true);

        scrollPaneForTable = new JScrollPane(tableOfStats);
        scrollPaneForTable.setBounds(125,150,1100,400);

        sortButton = new JButton("Sort");
        sortButton.setBounds(525,600,300,100);

        sortByWhat = new JComboBox(columns);
        sortByWhat.setBounds(925,625,300,50);

        this.setBounds(0,0,1500,1500);


        this.add(statsTitle);
        this.add(back);
        this.add(scrollPaneForTable);
        this.add(sortButton);
        this.add(sortByWhat);

    }

    public void sort(){

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        switch (e.getActionCommand()){
            case "Back":
                MainFrame.navigate(3,0);
                break;

            case "Sort":
                sort();
                break;
        }

    }
}
