/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dictionary;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Scanner;

/**
 *
 * @author Tommmm^^
 */
public class DictionaryManagement {
    Scanner sc = new Scanner(System.in);
     
    public void  insertFromCommandline(){                  
        String word_explain;
        String word_target;
        System.out.print("Nhập số lượng từ muốn thêm: ");
        int number = sc.nextInt();
        sc.nextLine() ;
        for (int i = 0; i < number; i++) {
            System.out.print("Nhập từ và nghĩa muốn thêm : ");
            word_target = sc.nextLine();
            word_explain = sc.nextLine();
            Dictionary.Words.add(new Word(word_target, word_explain));
         }    
    }
    public void insertFromFile() throws IOException{        //code them doc file
        Scanner inputDic = new Scanner(Paths.get("Dictionary.txt"));
        while(inputDic.hasNextLine()){
            String[] temp = inputDic.nextLine().split(":"); //them
            String tu = temp[0];
            String nghia = "";
            for (int i = 1; i < temp.length; i++){
                nghia +=temp[i];
            }
            Dictionary.Words.add(new Word(tu, nghia));
//            Dictionary.Words.add(new Word(temp[0], temp[1]));
        }
    }
    
    public void dictionaryLookup() { // tim kiem tu chinh xac
        System.out.print("Nhap tu muon tim kiem : ");
        String lookWord = sc.nextLine();
        int dem = 0;
        for (int i = 0; i < Dictionary.Words.size(); i++) {
            if (lookWord.equals(Dictionary.Words.get(i).getWord_target())) {
                System.out.println("Nghia cua tu la : "+Dictionary.Words.get(i).getWord_explain());
                dem++;
            }
        }
        if(dem == 0) System.out.println("Tu nay khong co trong tu dien");
    }
    public void dictionaryLookupPlus() {    //tim tu + goi ý 
        System.out.print("Nhap tu muon tim kiem : ");
        String lookWord = sc.nextLine();
        boolean check = false;
        for (int i = 0; i < Dictionary.Words.size(); i++) {
            String tmp = Dictionary.Words.get(i).getWord_target();
            if (tmp.contains (lookWord)){
                System.out.printf("%-10s%-20s%s\n", i + 1, Dictionary.Words.get(i).getWord_target(),
                            Dictionary.Words.get(i).getWord_explain());          
                //System.out.println (Dictionary.Words.get(i).getWord_explain());
                check = true;
                
            }                
        }
        if (!check){
            System.out.println(lookWord);
        }
    }
    public void addWord() {      //them tu
        Word addWord = new Word();
        System.out.println("Nhap tu muon them : ");
        addWord.setWord_target(sc.nextLine());
        System.out.println("Nhap nghia muon them : ");
        addWord.setWord_explain(sc.nextLine());
        Dictionary.Words.add(addWord);
        
    }
    public void deleteWord() { //xoa tu
        System.out.println("Nhap tu muon xoa :");
        String deleteWord = sc.nextLine();
        for (int i = 0; i < Dictionary.Words.size(); i++) {
            if (deleteWord.equalsIgnoreCase(Dictionary.Words.get(i).getWord_target())) {
                Dictionary.Words.remove(i);
            }
        }
   
    }
    public void repairWord() { // sua tu
       
        System.out.println("Nhap tu muốn sua : ");
        String str = sc.nextLine();
        for (int i = 0; i < Dictionary.Words.size(); i++) {
            if (str.equalsIgnoreCase(Dictionary.Words.get(i).getWord_target())) {
                System.out.print("Từ  : ");
                Dictionary.Words.get(i).setWord_target(sc.nextLine());
                System.out.print("Nghĩa : ");  
                Dictionary.Words.get(i).setWord_explain(sc.nextLine());
            }
        }
    }
     public void dictionaryExportToFile()  {
        try {
	      FileWriter write = new FileWriter("Dictionary.txt");
	     for (int i = 0; i < Dictionary.Words.size(); i++)
	             write.write(Dictionary.Words.get(i).getWord_target() + "\t" + Dictionary.Words.get(i).getWord_explain() + "\n");
	            write.close();
	        }
	        catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
    
}
    
    

