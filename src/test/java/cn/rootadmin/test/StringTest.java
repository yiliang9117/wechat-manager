package cn.rootadmin.test;

public class StringTest {
	
	
	public static void main(String[] args) {
		String httpUrl = "http://127.0.0.1:81";


		
		String[] split = httpUrl.split("/");
		
		if (split.length>3) {
			String string = split[0]+"//"+split[1]+split[2];
			System.out.println(string);
		}
		
		
	}

}
