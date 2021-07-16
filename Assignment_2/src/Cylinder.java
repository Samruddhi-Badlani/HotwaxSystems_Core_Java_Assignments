
public class Cylinder extends Circle {

	
	private double height;
	
	public Cylinder(double radius,double height) {
		
		// TODO Auto-generated constructor stub
		super(radius);
		this.height = height;
		try {
		if(checkValidity(radius, height)) {
			this.height = height;
		}
		else {
			throw new Invalid_Input("dimensions of cylinder cannot be negative");
		}
		}
		catch (Invalid_Input e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		
	}
	
	public double getHeight() {
		return height;
	}
	
	public void setHeight(double height) {
		this.height = height;
	}
	
	public boolean checkValidity(double radius,double height) {
		boolean flag=false;
		flag = checkValidity(getRadius()) && height >= 0;
		return flag;
	}
	
	@Override
	public double area() {
		double area = 0;
		area = 2 * Math.PI * getRadius() * getRadius() + 2 * Math.PI * getRadius() * getHeight();
		return area;
	}

	public double volume() {
		
		double volume = 0;
		volume = Math.PI * getHeight() * getRadius() * getRadius();
		return volume;
	}
	
	@Override 
	public void printDetails() {
		
		System.out.println("Total surface area of cylinder with radius : "+getRadius()+" and height :"+
	getHeight()+" = "+area());
		System.out.println("Volumeof cylinder with radius : "+getRadius()+" and height :"+
				getHeight()+" = "+volume());
		
	}
}
