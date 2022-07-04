import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StatsGUI extends JPanel implements ActionListener {

    JLabel statsTitle;
    JButton back;

    public StatsGUI(){

        statsTitle = new JLabel("Statistics");
        statsTitle.setFont(new Font("Consolas", Font.PLAIN,50));
        statsTitle.setBounds(475,150,500,100);
        //mainMenuTitle.setBorder(BorderFactory.createEmptyBorder(100,100,100,100));
        setLayout(null);

        back = new JButton("Back");
        back.setBounds(125,500,300,100);
        back.addActionListener(this);

        this.setBounds(0,0,1500,1500);


        this.add(statsTitle);
        this.add(back);

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
