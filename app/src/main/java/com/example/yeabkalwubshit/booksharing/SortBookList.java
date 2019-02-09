
import java.util.*;
import java.io.*;


/* Write a method that takes (ArrayList) and a (Search Text) 
 * Return a new array sorted by the Least Common Subsequence
 * 
 */

class SortBookList {
  
  
  
  public static void main(String[] args) {
    
    int lcsTest = getLCS("hello", "");
    
    System.out.println(lcsTest);
    
    ArrayList<String> bookList = new ArrayList<String> (Arrays.asList("Iliad", "Odyssey", "Dante", "Red Riding Hood", "Random Book"));

	//Edits
    
    sortBookList(bookList, "Dan");
    
    System.out.println(bookList);
    
    for (String string : bookList) {
      
      int lcs = getLCS(string, "Dan");
      
      System.out.println(string + " = " + lcs);
      
    }
    
    
  }
  
  static void sortBookList (ArrayList<String> bookList, String search) {
    
    
    //search is the user text searched for 
  
    
    Collections.sort(bookList, new Comparator<String>() {
      
      public int compare (String s1, String s2) {
        
        int lX = getLCS(s1, search);
        int lY = getLCS(s2, search);
        
        return lX-lY;
        
      }
      
      
      
    });
    
 }
        
 
  
  public static int getLCS(String string1, String string2) {
    
    int rowLength = string1.length() + 1;
    
    int colLength = string2.length() + 1;
    
    int[][] table = new int[rowLength][colLength];
    
    string1 = string1.toLowerCase();
    string2 = string2.toLowerCase();
    
    for (int i = 1; i < rowLength; i++) {
      
      for (int j = 1; j < colLength; j++) {
        
        /*String newStringA = new String();
        newStringA = newStringA.valueOf(string1.charAt(i-1));
        
        newStringA = newStringA.toLowerCase();
        
        String newStringB = new String();
        newStringB = newStringB.valueOf(string2.charAt(j-1));
        
        newStringB = newStringB.toLowerCase();
        */
        
        
        if (string1.charAt(i-1) == string2.charAt(j-1)) {
          
          table[i][j] = table[i-1][j-1] + 1;
          
        } else {
          
          table[i][j] = Math.max(table[i][j-1], table[i-1][j]);
        
      }
      
      
      }
    
    
  }
    
    return table[rowLength-1][colLength - 1];
  }
  
  
  
  
  
  
  
  
  
  
  
}
