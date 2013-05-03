import java.util.Scanner;
import java.math.BigDecimal;// This section of the api allows us to see numbers without typical exponetials //
import java.text.NumberFormat;//Format Number appearance

public class ParkMice 
{
    public static final double GROWTH_RATE = 0.20; /**the 20% a week the mice population takes to grow*/ 
    public static final double ONE_MOUSE_AREA = 0.01; /**this is in square feet*/
    public static final int TOTAL_PARK_AREA = 36590000; /**about 3.659E7, this is also in square feet*/
    public static final double DEATH_RATE = 0.05; /**this is a 5% weekly death of the mouse population*/
    public static void main (String [] args) 
    {
        System.out.print("The total area of Central Park is: " + Math.round(TOTAL_PARK_AREA) );
        System.out.println(" sq ft.");
        System.out.println("Please enter the estimated amount of mice inside of Central Park:"); 
        Scanner keyboard = new Scanner(System.in); 
        int INITIAL_POPULATION = keyboard.nextInt();
        
/** <-------------------Everything above this text is the roots to the original program------------------------------>*/
 
        int WEEKS_COUNT = 0;
        double POPULATION = INITIAL_POPULATION;
        NumberFormat nf = NumberFormat.getInstance();
        double TOTAL_MOUSE_AREA = POPULATION * ONE_MOUSE_AREA;
        double NEW_MICE, NEW_MICE_VOLUME, DEAD_MICE, DEAD_MICE_VOLUME;
        while (TOTAL_MOUSE_AREA < TOTAL_PARK_AREA)
        {
            NEW_MICE = POPULATION * GROWTH_RATE;
            DEAD_MICE = POPULATION * DEATH_RATE;
            NEW_MICE_VOLUME = NEW_MICE * ONE_MOUSE_AREA;
            DEAD_MICE_VOLUME = DEAD_MICE * ONE_MOUSE_AREA;
            POPULATION = POPULATION + NEW_MICE - DEAD_MICE;
            TOTAL_MOUSE_AREA = TOTAL_MOUSE_AREA + NEW_MICE_VOLUME - DEAD_MICE_VOLUME;
            WEEKS_COUNT++;
            
            
        }
        System.out.println("If Central Park starts with a mouse population of " 
                + INITIAL_POPULATION + " mice,");
        System.out.println("With a mice growth rate of 20% weekly, and mice death rate of 5% weekly,"); 
        System.out.print("after " + WEEKS_COUNT + " weeks,");
        System.out.println("the final mice population will be " + nf.format(BigDecimal.valueOf(Math.ceil(POPULATION))));
         if (TOTAL_MOUSE_AREA > TOTAL_PARK_AREA)
        {
            System.out.println("Since we are calculating population every full weeks, the live mice "
                    + "will overflow the park area with ");
            
            System.out.print(nf.format(Math.ceil(TOTAL_MOUSE_AREA - (TOTAL_PARK_AREA))));
            System.out.println(" extra mice.");
        }
         else
         {
             System.out.println("the entire " + nf.format(TOTAL_PARK_AREA) + " will be exactly filled by live mice.");
         }
        System.out.println("We must call a massive extermination team right away before the mice infest the city!!");                   
    }
}
