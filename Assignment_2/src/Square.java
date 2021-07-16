
public class Square implements Shapes_2D {
	
	private double side;  // Side of the square
	public Square(double side) {

		// TODO Auto-generated constructor stub
		this.side=side;
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
