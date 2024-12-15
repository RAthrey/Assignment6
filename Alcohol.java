/*
 * Class: CMSC203 22502 
 * Instructor: David Kuijt
 * Description: Make a alcohol class
 * Due: 12/15/2024
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming  
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Rohith Athrey
*/

public class Alcohol extends Beverage {
    private final double WEEKEND_COST = 0.60;
    private boolean offeredOnWeekend;
    
    public Alcohol(String name, SIZE size) {
        super(name, size, TYPE.ALCOHOL);
    }
    
    public Alcohol(String name, SIZE size, boolean offeredOnWeekend) {
        super(name, size, TYPE.ALCOHOL);
        this.offeredOnWeekend = offeredOnWeekend;
    }

    @Override
    public double calcPrice() {
        double price = addSizePrice();
        if (offeredOnWeekend) { 
        	price += WEEKEND_COST;
        }
        return price;
    }

    @Override
    public String toString() {
    	String alcohol = getName() + " " + getSize();
		if (offeredOnWeekend == true) {
			alcohol += " Purchased on Weekend,";
		}
		alcohol += " $" + calcPrice();
		return alcohol;
    }
    @Override
    public boolean equals(Object obj) {
    	Alcohol alcohol = (Alcohol) obj;
		if (super.equals(alcohol) && alcohol.getOfferedOnWeekend() == offeredOnWeekend) {
			return true;
		}
		return false;
    }

    public boolean getOfferedOnWeekend() {
        return offeredOnWeekend;
    }

    public void setOfferedOnWeekend(boolean offeredOnWeekend) {
        this.offeredOnWeekend = offeredOnWeekend;
    }
}
