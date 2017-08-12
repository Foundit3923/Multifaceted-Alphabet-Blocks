
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multifacested.alphabet.blocks;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
/**
 *
 * @author Michael Olson
 */
public class MultifacestedAlphabetBlocks {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        
        HashMap<Long, String> realWords = new HashMap<>();
        HashMap<String, Integer> alphabet = new HashMap<>();
        HashMap<Integer, String> co = new HashMap<>();
        
        ArrayList<ArrayList<String>> allBlocks = new ArrayList<ArrayList<String>>();
        ArrayList<String> blocks = new ArrayList<>();
        
       
        
        String fileName = "real_words.txt";
        
        String line = "";
        
        
        for(char letter = 'A'; letter <= 'Z'; letter++){
            String l = Character.toString(Character.toLowerCase(letter));
            alphabet.put(l, 0);
        }

            FileReader fileReader = new FileReader(fileName);
            
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            
            long count = 0;
            do{
          
                realWords.put(count, line);
               // System.out.println(realWords.get(count) + ": " + count);
                count++;
            }
            while((line = bufferedReader.readLine()) != null);
           alphabet = countOccurences(realWords, alphabet);
           
           for(String s : alphabet.keySet()){
               String key = s.toString();
               String value = alphabet.get(s).toString();
               System.out.println(key + ": " + value);
           }
            
        }
    public static HashMap<String, Integer> countOccurences(HashMap<Long, String> rw, HashMap<String,Integer> a){
        //count letter occurences
        for(long l = 0; l < rw.size(); l++){
            String word = rw.get(l);
            HashMap<String, Integer> liw = new HashMap<>();
          //  System.out.println(word + ": " + l);
            char[] charWord = word.toCharArray();
            for(int i = 0; i< charWord.length; i++){
                char c = charWord[i];
                String s = Character.toString(c);
                
                if(liw.containsKey(s)){
                    liw.put(s, liw.get(s) + 1);
                }
                else{
                    liw.put(s, 1);
                }
            }
            //check if occurence value is higher in a or liw. If liw, update a.
             for(char letter = 'A'; letter <= 'Z'; letter++){
            String s = Character.toString(Character.toLowerCase(letter));
            if(liw.containsKey(s)){
                if(a.get(s) < liw.get(s)){
                     a.put(s, liw.get(s));
                }
               
            }
        }
        }
        return a;
    }
    /*public ArrayList<ArrayList<String>> makeBoxes(ArrayList<ArrayList<String>> ab, ArrayList<String> b, HashMap<String, Integer> a){
        for(char letter = 'a'; letter <= 'z'; letter++){
            for(int i = 0; i < a.get(Character.toString(letter));i++){
                b.add(Character.toString(letter));
            }
            ab.add(b);
        }
    }*/
    }

    

