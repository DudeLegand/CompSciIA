import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ScreenReaderGUI extends JPanel implements ActionListener {

    JLabel screenReaderTitle;
    JButton back;
    JToggleButton turnSROnOrOff;
    JDialog areYouSure;
    JLabel textInDialog1;
    JLabel textInDialog2;
    JButton yesDialog;
    JButton noDialog;

    public ScreenReaderGUI(){



        screenReaderTitle = new JLabel("Screen Reader");
        screenReaderTitle.setFont(new Font("Consolas", Font.PLAIN,50));
        screenReaderTitle.setBounds(475,150,500,100);
        //mainMenuTitle.setBorder(BorderFactory.createEmptyBorder(100,100,100,100));
        setLayout(null);

        back = new JButton("Back");
        back.setBounds(125,500,300,100);
        back.addActionListener(this);

        turnSROnOrOff = new JToggleButton("Off");
        turnSROnOrOff.setBounds(525,500,300,100);
        turnSROnOrOff.addActionListener(this);

        areYouSure = new JDialog();
        areYouSure.setModal(true);
        areYouSure.setTitle("Are you sure?");
        areYouSure.setBounds(0,0,500,500);
        areYouSure.setResizable(false);
        areYouSure.setLayout(null);

        textInDialog1 = new JLabel("Are you sure you want to");
        textInDialog1.setFont(new Font("Consolas", Font.PLAIN,15));
        textInDialog1.setBounds(140,30,300,300);
        textInDialog2 = new JLabel("turn on the Screen reader?");
        textInDialog2.setFont(new Font("Consolas", Font.PLAIN,15));
        textInDialog2.setBounds(130,50,300,300);

        noDialog = new JButton("No");
        noDialog.setBounds(30,300,100,50);
        noDialog.addActionListener(this);
        yesDialog = new JButton("Yes");
        yesDialog.setBounds(350,300,100,50);
        yesDialog.addActionListener(this);

        areYouSure.add(textInDialog1);
        areYouSure.add(textInDialog2);
        areYouSure.add(noDialog);
        areYouSure.add(yesDialog);

        areYouSure.setVisible(false);



        this.setBounds(0,0,1500,1500);


        this.add(screenReaderTitle);
        this.add(back);
        this.add(turnSROnOrOff);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        switch (e.getActionCommand()){
            case "Back":
                MainFrame.navigate(1,0);
                break;

            case "Off":
            case "On":
                if(turnSROnOrOff.isSelected()) {
                    turnSROnOrOff.setText("On");
                    areYouSure.setVisible(true);

                }else {
                    turnSROnOrOff.setText("Off");
                }
                break;
            case "Yes":
                areYouSure.setVisible(false);
                ScreenReader screenReader = new ScreenReader();
                screenReader.partOfScreen();
                screenReader.textFromImage();
                //screenReader.deleteFile();
                break;
            case "No":
                areYouSure.setVisible(false);
                turnSROnOrOff.setText("Off");
                turnSROnOrOff.setSelected(false);

        }

    }
}
