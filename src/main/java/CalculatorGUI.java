import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorGUI extends JPanel implements ActionListener {

    JLabel calculatorTitle;
    JButton back;
    public CalculatorGUI(){

        calculatorTitle = new JLabel("Calculator");
        calculatorTitle.setFont(new Font("Consolas", Font.PLAIN,50));
        calculatorTitle.setBounds(475,150,500,100);
        //mainMenuTitle.setBorder(BorderFactory.createEmptyBorder(100,100,100,100));
        setLayout(null);

        back = new JButton("Back");
        back.setBounds(125,500,300,100);
        back.addActionListener(this);

        this.setBounds(0,0,1500,1500);


        this.add(calculatorTitle);
        this.add(back);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        switch (e.getActionCommand()){
            case "Back":
                MainFrame.navigate(2,0);
                break;

        }

    }
}
