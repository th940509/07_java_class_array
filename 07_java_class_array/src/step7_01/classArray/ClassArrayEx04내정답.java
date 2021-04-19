package step7_01.classArray;
//2021/04/16 18:08 ~ 18:14
//2021/04/19 13:59 ~ 14:05
import java.util.Scanner;

class User1_1{
	
	String id; 
	int money;
	
}


public class ClassArrayEx04내정답 {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		
		final int MAX_NUM = 3;
		
		User1_1[] user1 = new User1_1[MAX_NUM];
		
		for (int i=0; i<MAX_NUM; i++) {
			user1[i] = new User1_1();
		}
		
		user1[0].id = "qwer1234";
		user1[0].money = 1000;
		
		user1[1].id = "asdf1234";
		user1[1].money = 2000;
		
		int userCnt = 2;
		
		for (int i = 0; i < userCnt; i ++) {
			System.out.println(user1[i].id + " " + user1[i].money);
		} 
		
		User1_1 temp = user1[1]; // temp에 user1[1]의 링크(주소) 공유
		temp.id = "zxcv1234";
		System.out.println("=====================================");
		
		for (int i = 0; i < userCnt; i ++) {
			System.out.println(user1[i].id + " " + user1[i].money);
		}

		scan.close();


	}

}
//qwer1234 1000
//asdf1234 2000
//================================
//qwer1234 1000
//zxcv1234 2000
