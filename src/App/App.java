package App;

import java.time.LocalDate;
import java.util.Date;

import View.*;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//new DangNhapView();
		System.out.print(LocalDate.now());
		long millis=System.currentTimeMillis();  
		java.util.Date date=new java.util.Date(millis);  
		System.out.println(date); 
	}

}
