import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenuGUI extends JPanel implements ActionListener {

    private final int MAIN_MENU_BUTTON = 0;

    JButton toScreenReader;
    JButton toCalculator;
    JButton toStats;
    JMenuBar mainMenuBar;
    JLabel mainMenuTitle;


    public MainMenuGUI(){

        //GridLayout layout = new GridLayout(0,2);

        mainMenuTitle = new JLabel("Grind Calculator");
        mainMenuTitle.setFont(new Font("Consolas", Font.PLAIN,50));
        mainMenuTitle.setBounds(475,50,500,100);
        //mainMenuTitle.setBorder(BorderFactory.createEmptyBorder(100,100,100,100));
        setLayout(null);

        mainMenuBar = new JMenuBar();



        toScreenReader = new JButton("Screen Reader");
        toScreenReader.setBounds(125,600,300,100);
        toScreenReader.addActionListener(this);

        toCalculator = new JButton("Calculator");
        toCalculator.setBounds(525,600,300,100);
        toCalculator.addActionListener(this);

        toStats = new JButton("Stats");
        toStats.setBounds(925,600,300,100);
        toStats.addActionListener(this);

        this.setBounds(0,0,1500,1500);

        this.add(mainMenuTitle);
        this.add(toScreenReader);
        this.add(toCalculator);
        this.add(toStats);

        //setLayout(layout);
    }


    @Override
    public void actionPerformed(ActionEvent e) {

        switch (e.getActionCommand()){
            case "Screen Reader":
                MainFrame.navigate(0,1);
                break;

            case "Calculator":
                MainFrame.navigate(0,2);
                break;

            case "Stats":
                MainFrame.navigate(0,3);
                break;
        }

    }
}
