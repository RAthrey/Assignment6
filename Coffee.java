/*
 * Class: CMSC203 22502 
 * Instructor: David Kuijt
 * Description: Make a coffee class
 * Due: 12/15/2024
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming  
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Rohith Athrey
*/
public class Coffee extends Beverage {
	private boolean extraShot;  
    private boolean extraSyrup;
    public final double EXTRA_SHOT_COST = 0.50;
    public final double EXTRA_SYRUP_COST = 0.50;
    public Coffee(String name, SIZE size, boolean extraShot, boolean extraSyrup) {
        super(name, size, TYPE.COFFEE);
        this.extraShot = extraShot;
        this.extraSyrup = extraSyrup;
    }
    @Override
    public String toString() {
		String coffee = getName() + " " + getSize();
		if (getExtraShot() == true) {
			coffee += " Extra Shot";
		} 
		if (getExtraSyrup() == true) {
			coffee += " Extra Syrup";
		}
		coffee += " $" + calcPrice();
		return coffee;
	}
    
    @Override
    public double calcPrice() {
        double price = addSizePrice();
        if (extraShot) {
        	price += EXTRA_SHOT_COST;
        }
        if (extraSyrup) {
        	price += EXTRA_SYRUP_COST;
        }
        return price;
    }
    
    public boolean getExtraShot() {
        return extraShot;
    }

    public void setExtraShot(boolean extraShot) {
        this.extraShot = extraShot;
    }

    public boolean getExtraSyrup() {
        return extraSyrup;
    }

    public void setExtraSyrup(boolean extraSyrup) {
        this.extraSyrup = extraSyrup;
    }
    @Override
	public boolean equals(Object obj) {
		Coffee coffee = (Coffee) obj;
		if (super.equals(coffee) && extraShot == coffee.getExtraShot() && extraSyrup == coffee.getExtraSyrup()) {
			return true;
		}
		return false;
	}
}