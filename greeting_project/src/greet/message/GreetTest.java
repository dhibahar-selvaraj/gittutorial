package greet.message;

class Person{
	private int age;
	private String name;
	private char gender;
	private String email;
	public Person(int age,String name,char gender,String email){
		this.age=(age>=1 && age<=80)?age:0;
		this.name=name.matches("^[a-zA-Z\\s]+")?name:" ";
		this.gender=(gender=='m'||gender=='f')?gender:' ';
		this.email=email.matches(".+\\@.+\\..+")?email:" ";
		if(this.age==0||this.gender==' '|| this.name==" "
				||this.email==" ") {
			System.out.println("something wrong in this");
		}
	}
	
	
	@Override
	public String toString() {
		return "Person [age=" + age + ", name=" + name + ", gender=" + gender + ", email=" + email + "]";
	}


	public void print() {
		System.out.println("name is  :"+name);
		System.out.println("age is   :"+age);
		System.out.println("gender is:"+gender);
		System.out.println("email is:"+email);
		System.out.println("------------------------");
	}
}

public class GreetTest {
	
	public static void main(String[] args) {
		Person p1=new Person(1,"rio",'m',"rio@gmail.com");
		Person p2=new Person(2,"rahu",'m',"rahu@gmail.com");
		Person p3=new Person(3,"roy",'f',"roy@gmail.com");
		Person p4=new Person(4,"levi",'f',"levi@gmail.com");
		System.out.println(p1);
		System.out.println(p2);
		System.out.println(p3);
		System.out.println(250%124);
		p1.print();p2.print();p3.print();p4.print();
	}

}
