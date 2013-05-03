package parkmice;

import java.math.BigDecimal;
import java.text.NumberFormat;
public class ParkMiceBlueprint 
{
    public static final double GROWTH_RATE = 0.20; /**the 20% a week the mice population takes to grow*/ 
    public static final double ONE_MOUSE_AREA = 0.01; /**this is in square feet*/
    public static final int TOTAL_PARK_AREA = 36590000; /**about 3.659E7, this is also in square feet*/
    public static final double DEATH_RATE = 0.05; /**this is a 5% weekly death of the mouse population*/
    public int INITIAL_POPULATION = 10; /** this is the assumed starting mouse population*/
    int WEEKS_COUNT = 0;
    double POPULATION = INITIAL_POPULATION;
    double TOTAL_MOUSE_AREA = POPULATION * ONE_MOUSE_AREA;
    double NEW_MICE, NEW_MICE_AREA, DEAD_MICE, DEAD_MICE_AREA;
    NumberFormat nf = NumberFormat.getInstance();
    
    public void writeoutput()
    {
        System.out.print("The total area of Central Park is: " + nf.format(Math.round(TOTAL_PARK_AREA) ));
        System.out.println(" sq ft.");
        System.out.println("The estimated population of mouse in Central Park is 10 mice");      
        System.out.println("If Central Park starts with a mouse population of " 
                + INITIAL_POPULATION + " mice,");
        System.out.println("With a mice growth rate of 20% weekly, and mice death rate of 5% weekly,"); 
        System.out.print("after " + CalculateWeeks() + " weeks,");
        System.out.println("the final mouse population will be " + nf.format(BigDecimal.valueOf(Math.ceil(POPULATION))));

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

    public int CalculateWeeks()
{
    while (TOTAL_MOUSE_AREA < TOTAL_PARK_AREA)
        {
            NEW_MICE = POPULATION * GROWTH_RATE;
            DEAD_MICE = POPULATION * DEATH_RATE;
            NEW_MICE_AREA = NEW_MICE * ONE_MOUSE_AREA;
            DEAD_MICE_AREA = DEAD_MICE * ONE_MOUSE_AREA;
            POPULATION = POPULATION + NEW_MICE - DEAD_MICE;
            TOTAL_MOUSE_AREA = TOTAL_MOUSE_AREA + NEW_MICE_AREA - DEAD_MICE_AREA;
            WEEKS_COUNT++;
            int WeeksCalculated = WEEKS_COUNT;
        }
    return WEEKS_COUNT;
}
}
