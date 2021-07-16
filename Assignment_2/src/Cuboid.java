
public class Cuboid extends Rectangle {
	
	private double height;

	public Cuboid(double length, double breadth,double height) {
		super(length, breadth);
		this.height = height;
		try {
			if(checkValidity(length, breadth,height)){
				
				this.height = height;
			}
			else {
				throw new Invalid_Input("Cuboid dimensions cannot be negative");
			}
		}
		catch (Invalid_Input e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		// TODO Auto-generated constructor stub
	}
	
	public boolean checkValidity(double length, double breadth,double height) {
		
		// TODO Auto-generated method stub
		return super.checkValidity(length, breadth) && height >=0;
	}
	
	
	public double getHeight() {
		
		return height;
	}
	
	
	public void setHeight(double height) {
		
		this.height = height;
	}
	
	
	@Override
	public double perimeter() {
		
		double perimeter = 0;
		perimeter = 4*(getBreadth() + getLength() + getHeight());
		return perimeter;
	}
	
	@Override
	public double area() {
		
		double surface_area = 0;
		surface_area = 2 * (getLength() * getBreadth() + getBreadth() * getHeight() + getHeight() * getLength());
		return surface_area;
	}
	
	public double volume() {
		
		double volume = 0;
		volume = getLength() * getBreadth() * getHeight();
		return volume;
	}
	
	@Override
	public void printDetails() {
		
		System.out.println("Perimeter of the cuboid with dimensions : length = "+getLength()+" breadth = "+getBreadth()+" height = "+
			getHeight()	+" = "+perimeter());
		
		System.out.println("Volume of the cuboid with dimensions : length = "+getLength()+" breadth = "+getBreadth()+" height = "+
				getHeight()	+" = "+volume());
			
	}

}
