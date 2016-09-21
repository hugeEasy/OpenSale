package test1;

import com.hu.api.controller.Test1;

public class Test_autowired {

	public static void main(String args[]){
		Test1 stu = new Test1();
		String sr = stu.getStudent();
		System.out.println(sr);
	}
}
