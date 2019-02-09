import java.util.*;
import java.io.*;
import java.text.*; //Text from the SimpleDateFormat

class DateUtility {
  
  
  
  public static void test() {
    
    getDate("01/23/1984");

    ArrayList<String> stringDates = new ArrayList<String>(Arrays.asList("04/28/2018", "09/21/2080", "12/03/2004", "03/20/1943", "02/23/2019", "03/18/2005", "04/05/2080"));

    System.out.println("The dates unsorted: ");
    System.out.println();

    ArrayList<Date> datesUnsorted = new ArrayList<Date>();

    for (String unsortedStringDate : stringDates) {

	datesUnsorted.add(getDate(unsortedStringDate));


    }

    for (Date unsortedDate : datesUnsorted) {

	System.out.println("> " + unsortedDate + " <");

    }

   

    ArrayList<Date> datesSorted = sortDates(stringDates);

    System.out.println("The dates sorted: ");
    System.out.println();

    for (Date date : datesSorted) {

      System.out.println("> " + date + " <");

    }
    
    
  }
  
  public static Date getDate(String userText) {
    
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/dd/yyyy");
    
    Date userDate = new Date();
    
    try {
      
      userDate = simpleDateFormat.parse(userText);
      
      
      
    } catch (Exception exception) {
      
      System.out.println("Something went wrong..." + exception);
      
      
    }

    ArrayList<Date> dates = new ArrayList<Date>();

    dates.add(userDate);

    Date today = new Date();
    dates.add(today);

    Collections.sort(dates);

    //if (dates.get(0) == userDate) System.out.println("You have entered into the past!");

    //if (dates.get(0) == today) System.out.println("You have entered into the future!");


    //System.out.println("Your new date is: " + userDate);
    
   
    
    return userDate;
    
  }
  
  public static ArrayList<Date> sortDates(ArrayList<String> dateTexts) {
    
    ArrayList<Date> dates = new ArrayList<Date>();
    
    for (String dateElement : dateTexts) {
      
      dates.add(getDate(dateElement));
      
    }
    
    Collections.sort(dates);
    
    return dates;
    }
  
  
  
  
}
