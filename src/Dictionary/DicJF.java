
package dictionary;

import java.awt.event.*;
import com.sun.speech.freetts.*;
import static dictionary.Dictionary.Words;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class DicJF extends DictionaryManagement implements ActionListener {
    private JFrame frame ;
    private JButton exitButton;
    private JButton dichButton;
    private JButton PhatAmButton;
    private JButton XoaTuButton;
    private JButton ThemTuButton;
    private JButton SuaTuButton;
    private JTextField input;
    public JTextArea output;
    private JList dicList;
    private final DefaultListModel<String> readJL = new DefaultListModel<>();
    public final void Init() throws IOException{
        frame = new JFrame();        
        
        SuaTuButton = new JButton("Sửa Từ");
        SuaTuButton.setBounds(200, 190, 90, 30);
        exitButton = new JButton("Thoát");       //thoat
        exitButton.setBounds(200, 250, 90, 30);
        dichButton = new JButton("Dịch");       // dich
        dichButton.setBounds(200, 30, 90, 30);
        PhatAmButton = new JButton("Phát Âm");  // phat am
        PhatAmButton.setBounds(200, 70, 90, 30);
        XoaTuButton = new JButton("Xóa Từ");    // xoa tu
        XoaTuButton.setBounds(200, 110, 90, 30);
        ThemTuButton = new JButton("Thêm Từ");  //them tu
        ThemTuButton.setBounds(200, 150, 90, 30);
        input = new JTextField("");             //input
        input.setBounds(10, 20, 170, 50);
        dicList = new JList();                  //goi y
        dicList.setBounds(10, 80, 170, 240 );   
        output = new JTextArea();               //output
        output.setBounds(310, 20, 170,300);
        frame.setTitle("Dictionary");
        readFile();                     //doc vao file
        dicList.setModel(readJL);       //
        frame.setSize(500, 400);        //
        frame.setLocation(400, 200);    //set frame 
        frame.setLayout(null);          //
        frame.setVisible(true);         //
        frame.setResizable(false);      //
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);     
        frame.add(output);          //   add vao frame hien ra man hinh                                      
        frame.add(dicList);         //
        frame.add(input);           //
        frame.add(ThemTuButton);    //            
        frame.add(XoaTuButton);     //
        frame.add(PhatAmButton);    //
        frame.add(dichButton);      //
        frame.add(exitButton);      //    
        frame.add(SuaTuButton);     //
    }
    public void speak(String word){
        Voice voice;
        VoiceManager vm = VoiceManager.getInstance();
        voice = vm.getVoice("kevin16");
        voice.setRate((float)190.0);
        voice.allocate();
        try{
            voice.speak(word);
        }catch (Exception e){}
    }
    public void Action(){
        exitButton.addActionListener(this);
        dichButton.addActionListener(this); 
        PhatAmButton.addActionListener(this);
        ThemTuButton.addActionListener(this);
        XoaTuButton.addActionListener(this);
        SuaTuButton.addActionListener(this);
        dicList.addMouseListener(new ActionJList(dicList));
    }
    @Override
    public void actionPerformed(ActionEvent e) {    //xu ly khi nhan vao nut 
        JButton press = (JButton) e.getSource();
        if (press == dichButton){
            dictionaryLookup(input.getText(), readJL);      //ham lookup 
        }
        if (press == PhatAmButton){
            speak(input.getText());
        }
        if (press == exitButton){
            System.exit(0);
        }
        if (press == ThemTuButton){
            frameAdd ad = new frameAdd();
            ad.addWord();
        }
        if (press == XoaTuButton){
            try {
                frameDel de = new frameDel();
                de.delete();
            } catch (IOException ex) {
                Logger.getLogger(DicJF.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (press == SuaTuButton){
            frameRepair re = new frameRepair();
            re.repair();
        }
        
    }
    public void readFile() throws IOException{        //doc dau vao file = insertFromFile
        super.insertFromFile();
    }   

    class ActionJList extends MouseAdapter{ //ob check con tro chuot
        protected JList list;
        public ActionJList(JList l){
        list = l;       
        }
        @Override
        public void mouseClicked(MouseEvent e){
            int Index =0;
            boolean check =false;
            if(e.getClickCount() == 1){
            int index = list.locationToIndex(e.getPoint());
            ListModel dlm = list.getModel();
            Object item = dlm.getElementAt(index);
            list.ensureIndexIsVisible(index);
            for(int i=0;i<Words.size();++i)
                if(item.equals(Words.get(i).getWord_target())){
                    Index=i;
                    check = true;
                    break;
                }
                output.setText(Words.get(Index).getWord_explain());
            }
            if (check == false){
                output.setText(input.getText());
            }
        }
    }
    public DicJF() throws IOException{
        
        Init();
        Action();
    }
    public static void main(String[] args) throws IOException{
        DicJF dicJF = new DicJF();
    }
    //    public void getList(){                  //viet ra cas tu trong ArrayList Words
//        for (int i = 0 ; i < Words.size(); i++){
//            readJL.addElement(Words.get(i).getWord_target());
//        }
//    }
    
}
