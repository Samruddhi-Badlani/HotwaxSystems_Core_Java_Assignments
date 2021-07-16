
public class Triangle implements Shapes_2D{
	
	private double side1;
	private double side2;
	private double side3;
	
	public Triangle(double side1,double side2,double side3) {
		
		// TODO Auto-generated constructor stub
		try {
			if(side1<0||side2<0||side3<0) {
				throw new Invalid_Input("Sides of the triangle must be a positive value");
			}
		}
		catch(Invalid_Input e) {
			System.out.println(e.getMessage());
		}
		try{
			if(checkValidity(side1, side2, side3)) {
				this.side1 = side1;
				this.side2 = side2;
				this.side3 = side3;
			}
			else {
				throw new Invalid_Input("Enter the valid sides of the triangle");
			}
		}
		catch (Invalid_Input e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	}
	
	public boolean checkValidity(double side1,double side2,double side3) {
		
		boolean flag=false;
		if(side1+side2>side3&&side1+side3>side2&&side2+side3>side1) {
			flag=true;
		}
		return flag;
	}

	// To set the sides of the triangle
	public void setSide1(double side1) {
		this.side1 = side1;
	}
	
	
	public void setSide2(double side2) {
		this.side2 = side2;
	}
	

	public void setSide3(double side3) {
		this.side3 = side3;
	}
	
	

	// To get the sides of the triangle
	public double getSide1() {
		return side1;
	}
	
	public double getSide2() {
		return side2;
	}
	
	public double getSide3() {
		return side3;
	}
	
	@Override
	public double perimeter() {
		
		// TODO Auto-generated method stub
		double perimeter = 0;
		perimeter = side1 + side2 + side3;
		return perimeter;
	}

	@Override
	public double area() {
		
		// TODO Auto-generated method stub
		double area = 0;
		area = (side1+side2+side3)/2.0d;
	    area =  Math.sqrt(area* (area - side1) * (area - side2) * (area - side3));
		return area;
	}

	@Override
	public void printDetails() {
		
		// TODO Auto-generated method stub
		System.out.println("Perimeter of triangle with sides :"+side1+" "+side2+" "+side3+" = "+perimeter());
		System.out.println("Area of triangle with sides :"+side1+" "+side2+" "+side3+" = "+area());
	}

}
