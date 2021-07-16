
public class Rectangle implements Shapes_2D {
	
	private double length; // Length of the rectangle
	private double breadth; // Breadth of the rectangle
	
	public Rectangle(double length,double breadth) {

		// TODO Auto-generated constructor stub
		this.length=length;
		this.breadth=breadth;
	}
	
	// To set the length of the rectangle
	public void setLength(double length) {
		this.length = length;
	}
	
	// To set the breadth of the rectangle
	public void setBreadth(double breadth) {
		this.breadth = breadth;
	}
	
	// To get the length of the rectangle
	public double getLength() {
		return length;
	}
	
	// To get the breadth of the rectangle
	public double getBreadth() {
		return breadth;
	}
	
	// Give the perimeter of the rectangle
	@Override
	public double perimeter() {
		
		double perimeter=0;
		perimeter = 2*(length+breadth);
		return perimeter;
	}
	
	// Give the area of the square
	@Override
	public double area() {
		
		double area=0;
		area = length*breadth;
		return area;
	}
	
	// Print the output as per the given format
	@Override
	public void printDetails() {
		
		System.out.println("Perimeter of the rectangle with the dimensions  length = "+this.length+" breadth = "+this.breadth+" = "+this.perimeter());
		System.out.println("Area of the rectangle with the dimensions length= "+this.length+" breadth = "+this.breadth+"  = "+this.area());
	}
}
