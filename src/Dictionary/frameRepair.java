
package dictionary;

import java.awt.event.ActionEvent;
import javax.swing.*;

public class frameRepair extends DictionaryManagement{
    @SuppressWarnings("empty-statement")
    public void repair(){
        JFrame delFrame = new JFrame();
        JButton okButton;
        JButton cancelButton;
        JLabel Eng,Vie,tWord;
        JTextField engText, vieText;
        // init
        engText = new JTextField();
        vieText = new JTextField();
        okButton = new JButton("OK");
        cancelButton = new JButton("Cancel");;
        Eng = new JLabel("English");
        Vie = new JLabel("Vietnam");
        okButton.setBounds(115,220,80,30);
        cancelButton.setBounds(210,220,80,30);
        Eng.setBounds(10, 5, 50, 50);
        engText.setBounds(75, 15, 200, 30);
        Vie.setBounds(10, 40, 70, 50);
        vieText.setBounds(75, 50, 200, 30);
        
        delFrame.add(Eng);
        delFrame.add(Vie);
        delFrame.add(engText);
        delFrame.add(vieText);
        delFrame.add(okButton);
        delFrame.add(cancelButton);
        delFrame.setTitle("Repair Your Word");
        delFrame.setSize(300, 300);
        delFrame.setLocation(500, 200);
        delFrame.setResizable(false);  
        delFrame.setLayout(null);
        delFrame.setVisible(true);  
        // action
        cancelButton.addActionListener((ActionEvent e) -> {
            delFrame.setVisible(false);
        });
        okButton.addActionListener((ActionEvent e) -> {
            
            delFrame.setVisible(false);
        });
    }
}
