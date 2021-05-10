/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package translatewords;

/**
 *
 * @author lenovo
 */
import java.io.*;
import java.util.*;
import com.opencsv.CSVWriter;

public class TranslateWords {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        
        BufferedReader r1=new BufferedReader(new FileReader("C:\\Users\\lenovo\\OneDrive\\Desktop\\TranslateWordsChallenge\\t8.shakespeare.txt"));
        FileWriter w1=new FileWriter("C:\\Users\\lenovo\\OneDrive\\Desktop\\TranslateWordsChallenge\\t8.shakespeare.translated.txt");
        
        BufferedReader r3=new BufferedReader(new FileReader("C:\\Users\\lenovo\\OneDrive\\Desktop\\TranslateWordsChallenge\\french_dictionary.csv"));
        
        CSVWriter w2=new CSVWriter(new FileWriter("C:\\Users\\lenovo\\OneDrive\\Desktop\\TranslateWordsChallenge\\frequency.csv"));
        String li2[]={"English Word","French Word","Frequency"};
        w2.writeNext(li2);
        String line=r1.readLine();
        String line1="";
        LinkedHashMap<String, Integer> map=new LinkedHashMap<String,Integer>();
        LinkedHashMap<String, String> map1=new LinkedHashMap<String,String>();
        while((line1=r3.readLine())!=null){
            String[] toFrench=line1.split(",");
            map1.put(toFrench[0],toFrench[1]);
        }
        while(line!=null){
            String[] c=line.split(" ");
            for(String c1:c){ 
                StringBuffer c4=new StringBuffer(), c3=new StringBuffer();
                String c2="";
                for(int i=0;i<c1.length();i++){
                    if(Character.isAlphabetic(c1.charAt(i))||Character.isDigit(c1.charAt(i))){
                        c4.append(c1.charAt(i));
                    }
                    else
                        c3.append(c1.charAt(i));
                    
                }
//                c1=c1.replaceAll("[^A-Za-z0-9]","");
                c2=c4.toString();
                if(c2.matches("[a-z]+")){
                
                if(map1.containsKey(c2)){
                    if(map.containsKey(c2)){
                       map.put(c2,map.get(c2)+1);
                       
                    }
                    else
                        map.put(c2,1);
                c2=map1.get(c2);
                }}
                else if(c2.matches("[A-Z]+")){
                c2=c2.toLowerCase();
                if(map1.containsKey(c2)){
                    if(map.containsKey(c2)){
                       map.put(c2,map.get(c2)+1);
                       
                    }
                    else
                        map.put(c2,1);
                   
                   c2=map1.get(c2);
                   
                }
                c2=c2.toUpperCase();
                }
                else{
                    c2=c2.toLowerCase();
                    if(map1.containsKey(c2)){
                    if(map.containsKey(c2)){
                       map.put(c2,map.get(c2)+1);
                       
                    }
                    else
                        map.put(c2,1);
                    
                    c2=map1.get(c2);
                    
                }
                    if(c2.length()>1)
                    c2=c2.substring(0,1).toUpperCase()+c2.substring(1);
                    else
                        c2=c2.toUpperCase();
                }
                
            w1.write(c2+c3+" ");
            }
            w1.write("\n");
            line=r1.readLine();
        }
        for(Map.Entry<String,Integer> e:map.entrySet()){
            String li[]={e.getKey(),map1.get(e.getKey()),Integer.toString(e.getValue())};
            w2.writeNext(li);
        }
        r1.close();
        r3.close();
        w1.close();
        w2.close();
                 
        
      double currentMemory = ( (double)((double)(Runtime.getRuntime().totalMemory()/1024)/1024))- ((double)((double)(Runtime.getRuntime().freeMemory()/1024)/1024));
      System.out.println(currentMemory);
        
    }
    
}
