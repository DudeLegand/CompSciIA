import javax.swing.*;
import java.awt.*;

//Main Frame the creates all the panels and hides the one you don't need

public class MainFrame extends JFrame{
    private static JPanel[] allPanels;

    public MainFrame(){
        allPanels = new JPanel[4];
        allPanels[0] = new MainMenuGUI();
        allPanels[1] = new ScreenReaderGUI();
        allPanels[2] = new CalculatorGUI(new int[]{4, 4, 3, 3, 3, 3, 3, 4,9, 9, 30});
        allPanels[3] = new StatsGUI(new int[]{4, 4, 3, 3, 3, 3, 3, 4, 9, 9, 30});
        for (JPanel panel :
                allPanels) {
            this.add(panel);
            panel.setVisible(false);
        }

        this.getContentPane().setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));

        allPanels[0].setVisible(true);
        this.setBounds(0,0,1500,1500);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);

        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setResizable(false);
    }

    public static void navigate(int panelToHide, int panelToShow){
        allPanels[panelToHide].setVisible(false);
        allPanels[panelToShow].setVisible(true);
    }


}
