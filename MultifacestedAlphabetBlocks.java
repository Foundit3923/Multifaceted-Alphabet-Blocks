
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
        
        /*
        Create three HashMaps: one for the list of words; one to count the max occurence of each letter; and one to count the
        maximum number of times any letter occurs in the same word as another letter
        */
        HashMap<Long, String> realWords = new HashMap<>();
        HashMap<String, Integer> alphabet = new HashMap<>();
        HashMap<Integer, String> co = new HashMap<>();
        
        ArrayList<ArrayList<String>> allBlocks = new ArrayList<ArrayList<String>>();
        ArrayList<String> blocks = new ArrayList<>();
       
        String fileName = "real_words.txt";
        
        String line = "";
        
        /*
        Set up FileReader and BufferedReader
        */
            FileReader fileReader = new FileReader(fileName);
            
            BufferedReader bufferedReader = new BufferedReader(fileReader);
        /*
        Set every letter of the alphabet as a key with the value 0 in HashMap alphabet.
        */
        alphabet = fillAlphabet(alphabet);   
            
        /*
        Set every word in the file as a value in realWords and their numbered order as the key
        */
        realWords = fillRealWords(realWords, bufferedReader);
           
        /*
        Count the max number of times any given letter occurs in the words stored in realWords
        */
        alphabet = countOccurences(realWords, alphabet);
        
        /*
        Print results
        */
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
            //check if occurence value is higher in 'a' or 'liw'. If 'liw', update 'a'.
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
    public static HashMap<String, Integer> fillAlphabet(HashMap<String, Integer> a){
        for(char letter = 'a'; letter <= 'z'; letter++){
            String l = Character.toString(letter);
            a.put(l, 0);
        }
        return a;
    }
    public static HashMap<Long, String> fillRealWords(HashMap<Long, String> rw, BufferedReader br){
    long count = 0;
            do{          
                rw.put(count, line);
               // System.out.println(realWords.get(count) + ": " + count);
                count++;
            }
            while((line = bufferedReader.readLine()) != null);
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

    

