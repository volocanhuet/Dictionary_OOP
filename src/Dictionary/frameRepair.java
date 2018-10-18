
package dictionary;

import java.awt.event.ActionEvent;
import java.io.IOException;
import javax.swing.*;

public class frameRepair extends DictionaryManagement{
    @SuppressWarnings("empty-statement")
    private final JFrame reFrame = new JFrame();
    private JButton okButton;
    private JButton cancelButton;
    private JLabel Eng,Vie;
    private JLabel wordDic;
    public JTextField engText, vieText;
    private JTextField wordOld;
    @SuppressWarnings("empty-statement")
    public void repair(){   
        // init
        engText = new JTextField();
        vieText = new JTextField();
        wordOld = new JTextField();
        okButton = new JButton("OK");
        cancelButton = new JButton("Cancel");;
        Eng = new JLabel("English");
        Vie = new JLabel("Vietnam");
        wordDic = new JLabel("Word");
        okButton.setBounds(115,220,80,30);
        cancelButton.setBounds(210,220,80,30);

        vieText.setBounds(75, 50, 200, 30);
        engText.setBounds(75, 15, 200, 30);
        wordOld.setBounds(75, 90, 200, 30);
        Eng.setBounds(10, 5, 50, 50);
        Vie.setBounds(10, 40, 70, 50);
        wordDic.setBounds(10, 75, 50, 50);
        
        reFrame.add(wordDic);
        reFrame.add(wordOld);
        reFrame.add(Eng);
        reFrame.add(Vie);
        reFrame.add(engText);
        reFrame.add(vieText);
        reFrame.add(okButton);
        reFrame.add(cancelButton);
        reFrame.setTitle("Repair Your Word");
        reFrame.setSize(300, 300);
        reFrame.setLocation(500, 200);
        reFrame.setResizable(false);  
        reFrame.setLayout(null);
        reFrame.setVisible(true);  
        // action
        cancelButton.addActionListener((ActionEvent e) -> {//nut thoat
            reFrame.setVisible(false);
        });
        okButton.addActionListener((ActionEvent e) -> { //nut ok de sua tu
            super.repairWordFrame(wordOld.getText(),engText.getText(), vieText.getText());
            reFrame.setVisible(false);
            try {
                dictionaryExportToFile();
            } catch (IOException ex) {
            }
        });
    }
}
