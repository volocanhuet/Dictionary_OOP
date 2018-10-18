package dictionary;

import static dictionary.Dictionary.Words;
import java.io.*;
import java.nio.file.Paths;
import java.util.*;
import javax.swing.DefaultListModel;

public class DictionaryManagement extends Dictionary{
    Scanner sc = new Scanner(System.in);
     public int getSize(){
        return Dictionary.Words.size();
    }
    public void insertFromFile() throws IOException{        //code them doc file
        Scanner inputDic = new Scanner(Paths.get("dictionary3k.txt"));
        while(inputDic.hasNextLine()){
            String[] temp = inputDic.nextLine().split(" "); //them
            String tu = temp[0];
            String nghia = "";
            for (int i = 1; i < temp.length; i++){
                nghia =nghia + temp[i] + " ";
            }
            Dictionary.Words.add(new Word(tu, nghia));  //add từ vào arratlist để làm
        }
    }
    public void dictionaryLookup(String lookWord, DefaultListModel<String> a) {
        a.clear();
        boolean check = false;
        for (int i = 0; i < Dictionary.Words.size(); i++) {
            if (Dictionary.Words.get(i).getWord_target().indexOf(lookWord)==0){
                a.addElement(Dictionary.Words.get(i).getWord_target());
                check = true;
            }
        }
        if (!check){
            a.addElement(lookWord);
        }
    }
    public void deleteWordFrame(String deleteWord ) throws IOException {//xoa tu
            
        for (int i = 0; i < Dictionary.Words.size(); i++) {
            if (deleteWord.equalsIgnoreCase(Dictionary.Words.get(i).getWord_target())) {
                Dictionary.Words.remove(i);
            }
        }
        dictionaryExportToFile();
    }
    
    public void repairWordFrame(String str, String eng, String viet) { // sua tu
        Word reWord = new Word(eng, viet);
        for (int i = 0; i < Dictionary.Words.size(); i++) {
            if (str.equalsIgnoreCase(Dictionary.Words.get(i).getWord_target())) {
                Words.remove(i);
                Words.add(i, reWord);
            }
        }
    }
    
    public void dictionaryExportToFile() throws IOException  {     //thuc hien tren file
        
            try {
                PrintWriter write;
                write = new PrintWriter("Dictionary3k.txt");
                for (int i = 0; i < Dictionary.Words.size(); i++)
                    write.println(Dictionary.Words.get(i).getWord_target() + " " + Dictionary.Words.get(i).getWord_explain() );
                    write.close();
                }
	    catch (IOException e) {
	    }
    } 
    
}
