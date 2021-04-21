package step7_01.classArray;
import java.util.Scanner;

class Subject8{
	
	String name;
	int score;

}


class Student8{
	
	Subject8[] subjects;
	String name;

}


public class ClassArrayEx08_정답예시 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		// # 학생 추가 삭제 컨트롤러
		//   => 컨트롤러를 완성해 아래 3개의 정보를 추가하시오.
		//   김철수 : 과목3개 수학 50 국어50 영어 60 
		//   이만수 : 과목2개 수학 20 국어 30 
		//   이영희 : 과목1개 수학 100
		
		Student8[] stdList = new Student8[3]; // Student8 클래스 배열 생성
		int stdCnt = 0;	// 학생 수
		
		while (true) {
			
			for (int i=0; i<stdCnt; i++) {
				System.out.println("[" + (i+1) + "]" + stdList[i].name + "학생>>>");
				if (stdList[i].subjects != null) {
					for (int j=0; j<stdList[i].subjects.length; j++) {
						System.out.println("[" + (j+1) + "]" + stdList[i].subjects[j].name + "과목 = " + stdList[i].subjects[j].score + "점");
					}
				}
				System.out.println();
			}
			
			System.out.println("[1]학생 추가하기");		// 이름 입력받아 추가
			System.out.println("[2]과목 추가하기");		// 이름과 과목 입력받아 추가
			System.out.println("[3]성적 추가하기");		// 이름과 과목 그리고 성적 입력받아 추가
			System.out.println("[4]종료하기");
			int choice = scan.nextInt();
			
			if (choice == 1) { // 학생 추가하기
				
				System.out.print("이름 입력 : "); //이소영
				String name = scan.next();
				
				stdList[stdCnt] = new Student8(); // stdList[0]에 Student8의 객체를 대입.
				stdList[stdCnt].name = name; // stdList[0].name = 이소영;
				stdCnt++; // 0+1 =1
				
			}
			else if (choice == 2) { // 과목 추가하기
				
				for (int i=0; i<stdCnt; i++) {
					System.out.println("[" + (i+1) + "]" + stdList[i].name); //[1] 이소영
				}
				System.out.print("학생 선택 : "); // 1 선택
				int select = scan.nextInt();
				select--; // select => 1-1 = 0
				
				System.out.print("과목 입력 : "); // 1. 수학
				String subject = scan.next(); 
				
				if (stdList[select].subjects == null) { // stdList[0].subjects == null일때 (과목 처음 입력 시)
					
					stdList[select].subjects = new Subject8[1]; // 배열 생성
					
					stdList[select].subjects[0] = new Subject8(); // 객체 대입
					stdList[select].subjects[0].name = subject; // 수학을 name에 대입 -> stdList[0].subjects[0].name = 수학
					
				}
				else {
					
					int size = stdList[select].subjects.length; // size는 1 (77번줄에 1 배열 생성)
					
					Subject8[] temp = stdList[select].subjects; // temp에 링크 공유
					stdList[select].subjects = new Subject8[size + 1]; // stdList[0].subjects 에 subject8[2] 배열 생성 
					
					for(int i=0; i<size; i++) { // size =1, i=0일때만 성립
						stdList[select].subjects[i] = temp[i]; // stdList[0].subjects[0] 에 위의 temp[0]의 값 대입
					}
					
					stdList[select].subjects[size] = new Subject8(); // stdList[0].subject[1] = Subject8의 객체 대입
					stdList[select].subjects[size].name = subject; // stdList[0].subjects[1].name = (75번줄 null이 아닐때, 추가로 입력한 과목의 이름 대입)
					
					temp = null; // temp배열 초기화
					
				}
			}
			else if (choice == 3) { // 성적 추가하기
				
				for (int i=0; i<stdCnt; i++) { // stdCnt = 1, i=0일때만 성립
					System.out.println("[" + (i+1) + "]" + stdList[i].name); // [1] 이소영
				}
				System.out.print("학생 선택 : ");
				int select = scan.nextInt(); // 1선택
				select--; // select => 1-1 = 0
				
				if (stdList[select].subjects != null) {  //stdList[0].subjects의 배열의 값이 null이 아닐때 (위의 과목 이름이 입력되어 있는 경우 null이 아님)
					for (int i=0; i<stdList[select].subjects.length; i++) { //stdList[0].subjects.length = 1, i=0일때만 성립
						System.out.println("[" + (i+1) + "]" + stdList[select].subjects[i].name); // [1] 수학(stdList[0].subjects[0].name)
					}
				}
				
				System.out.print("과목 선택 : "); // 1선택
				int num = scan.nextInt();
				num--; // num => 1-1 = 0
				
				System.out.print("성적 입력 : "); // 90점
				int score = scan.nextInt(); // score = 90;
				
				stdList[select].subjects[num].score = score; // 90을 score에 대입 -> stdList[0].subjects[0].score = 90
				
			}
			else if (choice == 4) {
				System.out.println("종료");
				break;
			}
		
		}

		scan.close();

	}

}
