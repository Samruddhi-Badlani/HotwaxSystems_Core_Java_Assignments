
public class Sphere extends Circle{

	public Sphere(double radius) {
		super(radius);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public double area() {
		 
		double area = 0;
		area = 4 * Math.PI * getRadius() * getRadius();
		return area;
	}
	
	public double volume() {
		
		double volume = 0;
		volume = ((double)4/3) * Math.PI * getRadius() * getRadius() * getRadius();
		return volume;
	}
	
	@Override
	public void printDetails() {
		try {
			if(checkValidity(getRadius())) {
				System.out.println("Surface area of the sphere with radius : "+getRadius()+" = "+area());
				System.out.print("Volume of the sphere with radius : "+getRadius()+" = "+volume());
			}
			else {
				throw new InvalidInput("Radius cannot be negative");
			}
		}
		catch (InvalidInput e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	}
}
