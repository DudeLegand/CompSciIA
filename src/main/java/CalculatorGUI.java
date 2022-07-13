import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorGUI extends JPanel implements ActionListener {

    private int[] fields;
    JLabel calculatorTitle;
    JButton back;
    JButton calculate;
    JComboBox whatVehicle;
    JRadioButton calculateAverage;
    JRadioButton calculateEstimate;
    ButtonGroup averageOrEstimate;
    public CalculatorGUI(int[] fields){

        calculatorTitle = new JLabel("Calculator");
        calculatorTitle.setFont(new Font("Consolas", Font.PLAIN,50));
        calculatorTitle.setBounds(475,50,500,100);
        //mainMenuTitle.setBorder(BorderFactory.createEmptyBorder(100,100,100,100));
        setLayout(null);

        back = new JButton("Back");
        back.setBounds(125,600,300,100);
        back.addActionListener(this);

        calculate = new JButton("Calculate");
        calculate.setBounds(525,600,300,100);
        calculate.addActionListener(this);

        Database database = new Database("USRGroundVehicles.txt", 75, new int[]{4, 4, 3, 3, 3, 3, 3, 4, 9, 9, 30});
        this.fields = fields;
        String[] vehicles = new String[database.getRecordCount()];
        String[][] dataForTable = new String[database.getRecordCount()][fields.length];

        for (int i = 0; i < database.getRecordCount(); i++) {
            dataForTable[i] = database.recordToArray(i);
            vehicles[i] = dataForTable[i][10];
        }

        whatVehicle = new JComboBox(vehicles);
        whatVehicle.setBounds(125,300,300,50);



        this.setBounds(0,0,1500,1500);


        this.add(calculatorTitle);
        this.add(back);
        this.add(calculate);
        this.add(whatVehicle);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        switch (e.getActionCommand()){
            case "Back":
                MainFrame.navigate(2,0);
                break;

            case "Calculate":

                break;

        }

    }
}
