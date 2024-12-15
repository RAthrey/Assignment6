/*
 * Class: CMSC203 22502 
 * Instructor: David Kuijt
 * Description: Make a beverage class
 * Due: 12/15/2024
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming  
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Rohith Athrey
*/
public abstract class Beverage {
	private String name;
    public TYPE type;
    public SIZE size;
    public final double BASE_PRICE = 2.0;
    public final double SIZE_PRICE = 0.5;
    public Beverage(String name, SIZE size, TYPE type) {
        this.name = name;
        this.type = type;
        this.size = size;
    }
    public abstract double calcPrice();
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TYPE getType() {
        return type;
    }

    public void setType(TYPE type) {
        this.type = type;
    }

    public SIZE getSize() {
        return size;
    }

    public void setSize(SIZE size) {
        this.size = size;
    }
    public String ToString() {
		return name + " " + size;
	}
    @Override
    public boolean equals(Object obj) {
    	Beverage beverage = (Beverage) obj;
		if (name.equals(beverage.getName()) && type.equals(beverage.getType()) && size.equals(beverage.getSize())) {
			return true;
		}
		return false;
	}
    public double addSizePrice() {
        switch (size) {
            case MEDIUM:
                return BASE_PRICE + SIZE_PRICE;
            case LARGE:
                return BASE_PRICE + 2 * SIZE_PRICE;
            case SMALL:
            	return BASE_PRICE;
            default:
                return BASE_PRICE;
        }
    }
    
}
