/*
 * Class: CMSC203 22502 
 * Instructor: David Kuijt
 * Description: Make a smoothie class
 * Due: 12/15/2024
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming  
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Rohith Athrey
*/
public class Smoothie extends Beverage{
	private final double PROTEIN_COST = 1.50;
    private final double FRUIT_COST = 0.50;
    private int numberOfFruits;
    private boolean proteinAdded;
    public Smoothie(String name, SIZE size, int numberOfFruits, boolean proteinAdded) {
        super(name, size, TYPE.SMOOTHIE);
        this.numberOfFruits = numberOfFruits;
        this.proteinAdded = proteinAdded;
    }

    @Override
    public double calcPrice() {
        double price = addSizePrice();
        price += numberOfFruits * FRUIT_COST;
        if (proteinAdded) {
        	price += PROTEIN_COST;
        }
        return price;
    }
    
    @Override
    public String toString() {
		String smoothie = getName() + " " + getSize();
		if (proteinAdded == true)
			smoothie += " Protein Powder";
		smoothie += " " + getNumberOfFruits() + " $" + calcPrice();
		return smoothie;
	}
    @Override
    public boolean equals(Object obj) {
    	Smoothie smoothie= (Smoothie) obj;
		if (super.equals(smoothie) && smoothie.getProteinAdded() == proteinAdded && smoothie.getNumberOfFruits() == numberOfFruits) {
			return true;
		}
		return false;
	}
    public int getNumberOfFruits() {
        return numberOfFruits;
    }

    public void setNumberOfFruits(int numberOfFruits) {
        this.numberOfFruits = numberOfFruits;
    }

    public boolean getProteinAdded() {
        return proteinAdded;
    }

    public void setProteinAdded(boolean proteinAdded) {
        this.proteinAdded = proteinAdded;
    }
	

}
