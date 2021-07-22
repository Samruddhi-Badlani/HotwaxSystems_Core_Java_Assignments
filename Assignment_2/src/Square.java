
public class Square implements Shapes2D {
	
	private double side;  // Side of the square
	
	
	public Square(double side) {

		// TODO Auto-generated constructor stub
		try {
			if(checkValidity(side)) {
				this.side=side;
			}
			else {
				this.side = side;
				throw new InvalidInput("side of square cannot be negative");
			}
		}
		catch (InvalidInput e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	}
	
	// Checks the validity of the input number
	public boolean checkValidity(double side) {
			
		boolean flag=false;
		if(side>=0) {
			flag=true;
		}
		return flag;
	}
	// To set the side of square
	public void setSide(double side) {
		
		this.side = side;
	}
	
	// To get the side of the square
	public double getSide() {
		
		return side;
	}
	
	// Give the perimeter of the square
	@Override
	public double perimeter() {
		
		double perimeter=0;
		perimeter = 4*side;
		return perimeter;
	}
	
	// Give the area of the square
	@Override
	public double area() {
		
		double area=0;
		area = side*side;
		return area;
	}
	
	// Print the output as per the given format
	@Override
	public void printDetails() {
		
		System.out.println("Perimeter of the square with side "+this.side+" "+" = "+this.perimeter());
		System.out.println("Area of the square with side "+this.side+"  = "+this.area());
	}
}
