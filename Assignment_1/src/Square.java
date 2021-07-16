
public class Square implements Shapes_2D {
	private double side;
	public Square(double side) {
		// TODO Auto-generated constructor stub
		this.side=side;
	}
	public void setSide(double side) {
		this.side = side;
	}
	public double getSide() {
		return side;
	}
	@Override
	public double perimeter() {
		double perimeter=0;
		perimeter = 4*side;
		return perimeter;
	}
	@Override
	public double area() {
		double area=0;
		area = side*side;
		return area;
	}
	public void printDetais() {
		System.out.println("Perimeter of the square with side "+this.side+" "+" = "+this.perimeter());
		System.out.println("Area of the square with side "+this.side+"  = "+this.area());
	}
}
