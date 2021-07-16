
public class Cube extends Square {

	public Cube(double side) {
		super(side);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public double perimeter() {
		
		double perimeter = 0;
		perimeter = 12*getSide();
		return perimeter;
	}
	
	@Override
	public double area() {
		
		double surface_area = 0;
		surface_area = 6 * getSide() * getSide();
		return surface_area;
	}
	
	public double volume() {
		
		double volume = 0;
		volume = getSide() * getSide() * getSide();
		return volume;
	}
	
	@Override
	public void printDetails() {
		try {
			if(checkValidity(getSide())) {
				System.out.println("Perimeter of the cube with side = "+getSide()+" = "+perimeter());
				System.out.println("Volume of the cube with side = "+getSide()+" = "+volume());
			}
			else {
				throw new Invalid_Input("Cube side cannot be negative");
			}
		}
		catch (Invalid_Input e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		
	}

}
