package greet.message;
public class java2 {

	public static void main(String[] args) {
		smartphone sp =new smartphone();
		sp.dial();
		sp.dial((byte)250);
		sp.dial(1.2f);
		sp.dial(12,12);
		sp.dial(123456789L,(byte)12);
		sp.dial((short)250,138767667L);

	}
	

}

class phone{}
class smartphone extends phone{
	void dial() {
		System.out.println("no value");
	}
	void dial(int a) {
		System.out.println("int"+a);
	}
	void dial(byte a) {
		System.out.println("byte"+a);
	}
	void dial(float a) {
		System.out.println("float"+a);
	}
	void dial(long a,long b) {
		System.out.println("long"+a+" long"+b);
	}
	void dial(long a,byte b) {
		System.out.println("long"+a+" byte"+b);
	}
	void dial(short a,long b) {
		System.out.println("short"+a+" long"+b);
	}
}
