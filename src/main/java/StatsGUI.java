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

        this.fields = fields;
        String[] columns = new String[] {
                "Hits", "Crits", "Zone Captures", "Assists", "Kills", "Air Kills", "Deaths", "RP", "SL", "Name"
        };

        Object[][] data = new Object[][] {
                {1, 40, 40, 40, 40, 1, 40, 40, 40, 40},
                {2, 70, 70, 70, 70, 2, 70, 70, 70, 70},
                {3, 60, 60, 60, 60, 3, 60, 60, 60, 60},
        };

        statsTitle = new JLabel("Statistics");
        statsTitle.setFont(new Font("Consolas", Font.PLAIN,50));
        statsTitle.setBounds(475,150,500,100);
        //mainMenuTitle.setBorder(BorderFactory.createEmptyBorder(100,100,100,100));
        setLayout(null);

        back = new JButton("Back");
        back.setBounds(125,500,300,100);
        back.addActionListener(this);

        tableOfStats = new JTable(data,columns);
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
