
public class Circle implements Shapes2D{
	
	private double radius;
	
	public Circle(double radius) {
		
		// TODO Auto-generated constructor stub
		this.radius=radius;
		try {
			if(checkValidity(radius)) {
				this.radius=radius;
			}
			else {
				throw new InvalidInput("Negative radius is not valid input");
			}
		}
		catch (InvalidInput e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	}
	
	public boolean checkValidity(double radius) {
		
		boolean flag=false;
		if(radius>=0) {
			flag=true;
		}
		return flag;
	}
	//To set the radius of the circle
	public void setRadius(double radius) {
		
		this.radius = radius;
	}
	
	// To get the radius of the circle	
	public double getRadius() {
		
		return radius;
	}
	
	@Override
	public double perimeter() {
		
		// TODO Auto-generated method stub
		double perimeter = 2 * radius * Math.PI;
		return perimeter;
	}

	@Override
	public double area() {
		
		// TODO Auto-generated method stub
		double area = Math.PI * radius * radius;
		return area;
	}
	

	@Override
	public void printDetails() {
		
		// TODO Auto-generated method stub
		System.out.println("Circumference of the circle with radius = "+radius+" = "+perimeter());
		System.out.println("Area of the circle with radius = "+radius+" = "+area());
		
	}
	

}
