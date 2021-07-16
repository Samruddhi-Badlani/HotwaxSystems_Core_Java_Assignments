
public class Rectangle implements Shapes_2D {
	
	private double length; // Length of the rectangle
	private double breadth; // Breadth of the rectangle
	
	public Rectangle(double length,double breadth) {

		// TODO Auto-generated constructor stub
		try {
			if(checkValidity(length, breadth)) {
				this.length=length;
				this.breadth=breadth;
			}
			else {
				throw new Invalid_Input("Negative inputs are not valid");
			}
		}
		catch (Invalid_Input e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	
	}
	
	public boolean checkValidity(double length,double breadth) {
		
		boolean flag = false;
		if(length>=0&&breadth>=0)
			flag = true;
		return flag;
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
