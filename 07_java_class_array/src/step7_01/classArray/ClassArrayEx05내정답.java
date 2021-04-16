package step7_01.classArray;
//2021/04/16 18:15 ~ 18:24
import java.util.Scanner;

class User2_1 {
	
	String id;
	int money;
	
}


public class ClassArrayEx05내정답 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		final int MAX_NUM = 100;	
		User2_1[] user2 = new User2_1[MAX_NUM];	//클래스 배열 생성
		
		for (int i = 0; i < MAX_NUM; i++) {
			user2[i] = new User2_1(); //클래스 값 대입
		}
		
		int usrCnt = 0;
		
		while (true) {
			
			System.out.println("1.회원가입");
			System.out.println("2.탈퇴");
			System.out.println("3.출력");
			System.out.println("4.종료");
			int sel = scan.nextInt();
			
			if (sel == 1) {
				System.out.println("이름을 입력하세요 ");
				user2[usrCnt].id = scan.next(); // user2[0].id = 이소영
				System.out.println("금액을입력하세요 ");
				user2[usrCnt].money = scan.nextInt(); // user2[0].money = 10000
				usrCnt++; // 0+1 = 1
			}
			else if (sel == 2) {
				System.out.println("인덱스를 입력하세요 ");
				int index = scan.nextInt(); // index = 0
				for (int i = index; i < usrCnt - 1; i++) { // i=0; i <1-1; i++ (성립하지않음)
					user2[i] = user2[i + 1];
				}
				usrCnt--; // index가 0일경우 / usrCnt = 0
			}
			else if (sel == 3) {
				for (int i = 0; i < usrCnt; i++) { // i=0; i<1; i++ (i=0일때만 성립)
					System.out.println(user2[i].id + user2[i].money); // user2[0].id + user2[0].money ->  이소영 + 10000 출력
				}
			}
			else if (sel == 4) {
				break;
			}		
			
		}

		scan.close();
		
	}

}
