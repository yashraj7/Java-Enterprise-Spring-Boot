package in.code.finalAssignment;

//constructor is a specialized method same name as class name, automatically initialized when object is created ,
//with no return type .
class Parent {
	public Parent() {
		System.out.println("parent constructor");
	}
}

class child extends Parent {
	public child() {
		super();
		System.out.println("child constructor");

	}
}

public class _2Constructor {

	public static void main(String[] args) {
		child c = new child();
	}

}
