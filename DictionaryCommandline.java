/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dictionary;

import java.io.IOException;

/**
 *
 * @author Tommmm^^
 */
public class DictionaryCommandline {                                
    static DictionaryManagement Dict = new DictionaryManagement();
     public void showAllWords() {                                    //show tất cả cá từ trong file
        int size = Dict.getSize();
        System.out.printf("%-10s%-20s%s\n","STT","English","Viet");
        for(int i = 0 ; i < size ; i++) {          
            System.out.printf("%-10s%-20s%s\n", i + 1, Dictionary.Words.get(i).getWord_target(),
                   Dictionary.Words.get(i).getWord_explain());          
        }
    }
     public void dictionaryBasic() {                                  //them ham dictionaryBasic
         Dict.insertFromCommandline();                                                
         showAllWords();                                              
         
     }
    public void  dictionaryAdvanced() throws IOException {   //them ham dictionaryAdvanced
         Dict.insertFromFile();                               
//         showAllWords();    
//         Dict.repairWord();
//         showAllWords();
//         Dict.dictionaryLookup();
         Dict.addWord();
         showAllWords();
         
         

     }
    
    
      public static void main(String[] args)throws IOException {     // ham main goi ham dictionaryAdvanced va ham dictionaryBasic
        
        Dict.insertFromFile();//trung anh code
        DictionaryManagement dict1 = new DictionaryManagement();
        while(true){
            dict1.dictionaryLookupPlus();
            dict1.deleteWord();
        }
        
     }
}
