package in.code.finalAssignment;

import java.util.Scanner;

interface Shapes {
	void input();
	float area();
	float perimeter();
	void disp(Shapes s);
}

class Rectangle implements Shapes {
	float length;
	float breadth;

	public void input() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the length of Rectangle");
		length = sc.nextFloat();
		System.out.println("Enter the breadth of Rectangle");
		breadth = sc.nextFloat();
	}

	@Override
	public float area() {
		return length * breadth;

	}

	@Override
	public float perimeter() {
		return (float)(1.0 / 2.0) * length * breadth;

	}

	@Override
	public void disp(Shapes s) {
		System.out.println("area of rectangle is : " + s.area());
		System.out.println("perimeter of rectangle is : " + s.perimeter());
	}
}

class Circle implements Shapes {
	float radius;
	final float pi = 3.14f;

	public void input() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the radius of Cirlce");
		radius = sc.nextFloat();
	}

	@Override
	public float area() {
		return radius * radius;
	}

	@Override
	public float perimeter() {
		return 2 * pi * radius;
	}

	@Override
	public void disp(Shapes s) {
		System.out.println("area of circle is : " + s.area());
		System.out.println("perimeter of circle is : " + s.perimeter());
	}
}

class Geometry {
	public void permit(Shapes s) {
		s.input();
		s.disp(s);
	}
}

public class _1Polymorphism {
	public static void main(String[] args) {
		Rectangle r = new Rectangle();
		Circle c = new Circle();
		Geometry g = new Geometry();
		g.permit(r);
		g.permit(c);
	}
}
