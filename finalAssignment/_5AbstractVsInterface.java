package in.code.finalAssignment;

//Interface:
//	-SRS ,100% abstraction, contract between client and service provider
//	-implements
//	-by default methods are public abstract
//	-by default variables are public static final
//	-have to intialize variables at the time of declaration only
//	-can't have constructor inside interface
//	-used to achieve multiple inheritance
//	-can't write static and instance block
//	
//	interface:
interface IStudent {
	int ID = 23;

	String course();

	double exam();
}

//abstract class:
//	-may or may not achieve 100% abstraction it upto you
//	-extends
//	-methods inside abstract class need not be public abstract 
//	-variable need not be public static final
//	-can have constructor inside abstract class
//	-can write static and instance block
//	
abstract class AbsStudent {
	int id;
	int rollNo;

	abstract String course();

	abstract String exam();

	public void display() {
		System.out.println("hello");
	}
}

public class _5AbstractVsInterface {
	public static void main(String[] args) {

	}
}
