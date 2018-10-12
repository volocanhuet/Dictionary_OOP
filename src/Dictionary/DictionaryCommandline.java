/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dictionary;

import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Tommmm^^
 */
public class DictionaryCommandline {    
    Scanner sc = new Scanner(System.in);
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
    public void  dictionaryAdvanced() throws IOException {   //them ham dictionaryAdvanced nhap cac yeu cau
        Dict.insertFromFile();
        
            System.out.println("1  Tra tu");
            System.out.println("2  Tra tu nang cao");
            System.out.println("3  Them tu");
            System.out.println("4  Sua tu");
            System.out.println("5 Xoa tu ");
            System.out.println("6. In tu ");
            System.out.print("Moi ban nhap lua chon : ");
            int luaChon = sc.nextInt();
            
             

            switch (luaChon) {
                case 1:
                    Dict.dictionaryLookup();
                    break;
                case 2:
                    Dict.dictionaryLookupPlus();
                    break;
                case 3:
                    Dict.addWord();
                    break;
                case 4:
                    Dict.repairWord();
                    break;
                case 5:
                    Dict.deleteWord();
                case 6 : 
                    showAllWords();
                 default :
                     System.out.println("Ban da thoat");
                      System.exit(0);
                     
           
                   
            }
          

        } 
    
    public static void main(String[] args)throws IOException {     // ham main goi ham dictionaryAdvanced va ham dictionaryBasic
       DictionaryCommandline dictCom = new DictionaryCommandline();
        dictCom.dictionaryAdvanced();
        

        
     }
}
