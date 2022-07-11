import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StatsGUI extends JPanel implements ActionListener {

    private int[] fields;
    JLabel statsTitle;
    JButton back;
    JTable tableOfStats;

    JScrollPane scrollPaneForTable;

    public StatsGUI(int[] fields){
        Database database = new Database("USRGroundVehicles.txt", 70, new int[]{4, 4, 3, 3, 3, 3, 3, 9, 9, 30});
        this.fields = fields;
        String[] columns = new String[] {
                "Hits", "Crits", "Zone Captures", "Assists", "Kills", "Air Kills", "Deaths", "RP", "SL", "Name"
        };
        String[] dataFromRow;
        String[][] dataForTable = new String[fields.length][database.getRecordCount()];

        for (int i = 0; i < database.getRecordCount(); i++) {
            for (int j = 0; j < fields.length - 1; j++) {
                dataFromRow = database.recordToArray(i);
                dataForTable[i][j] = dataFromRow[j];
            }
        }


        statsTitle = new JLabel("Statistics");
        statsTitle.setFont(new Font("Consolas", Font.PLAIN,50));
        statsTitle.setBounds(475,150,500,100);
        //mainMenuTitle.setBorder(BorderFactory.createEmptyBorder(100,100,100,100));
        setLayout(null);

        back = new JButton("Back");
        back.setBounds(125,500,300,100);
        back.addActionListener(this);

        tableOfStats = new JTable(dataForTable,columns);
        tableOfStats.setBounds(125,300,500,200);

        scrollPaneForTable = new JScrollPane(tableOfStats);
        scrollPaneForTable.setBounds(125,300,1000,200);

        this.setBounds(0,0,1500,1500);


        this.add(statsTitle);
        this.add(back);
        this.add(scrollPaneForTable);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        switch (e.getActionCommand()){
            case "Back":
                MainFrame.navigate(3,0);
                break;

        }

    }
}
