package step7_01.classArray;
//2021/04/21 15:35 ~ 16:49
import java.util.Scanner;

class Subject_2{
	String name;
	int score;
}

class Student_2{
	Subject_2[] subjects;
	String name;
}



public class ClassArrayEx08_내정답 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		// # 학생 추가 삭제 컨트롤러
		//   => 컨트롤러를 완성해 아래 3개의 정보를 추가하시오.
		//   김철수 : 과목3개 수학 50 국어50 영어 60 
		//   이만수 : 과목2개 수학 20 국어 30 
		//   이영희 : 과목1개 수학 100
		
		Student_2 [] stdList = new Student_2[3]; 
		int stdCnt = 0;	// 학생 수
		
		while (true) {
			
			for(int i=0; i<stdCnt; i++) {
				System.out.println("[" + (i+1) + "]" + stdList[i].name + "학생 >>>");
				if(stdList[i].subjects != null) {
					for(int j=0; j<stdList[i].subjects.length; j++) {
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
			
			if		(choice == 1) {//학생추가
				System.out.print("이름 입력: ");
				String name = scan.next();
				
				stdList[stdCnt] = new Student_2();
				stdList[stdCnt].name = name;
				stdCnt ++;
				
			}
			
			else if (choice == 2) {//과목추가
				for(int i=0; i <stdCnt; i++) {
					System.out.println("["+(i+1)+"]" + stdList[i].name);
				}
				System.out.print("학생 선택: ");
				int select = scan.nextInt();
				select--;
				
				System.out.print("과목 입력: ");
				String subject = scan.next();
				
				if(stdList[select].subjects == null) {
					stdList[select].subjects = new Subject_2[1];
					
					stdList[select].subjects[0] = new Subject_2();
					stdList[select].subjects[0].name = subject;
				}
				else {
					int size = stdList[select].subjects.length; 
					
					Subject_2[] temp = stdList[select].subjects;
					stdList[select].subjects = new Subject_2[size + 1];
					
					for(int i=0; i <size; i++) {
						stdList[select].subjects[i] = temp[i];
					}
					stdList[select].subjects[size] = new Subject_2();
					stdList[select].subjects[size].name = subject;
					
					temp = null;
				}
			}
			
			else if (choice == 3) {//성적추가
				for(int i=0; i<stdCnt; i++) {
					System.out.println("[" + (i+1) + "]" + stdList[i].name);
				}
				System.out.print("학생 선택: ");
				int select = scan.nextInt();
				select --;
				
				if(stdList[select].subjects != null) {
					for(int i=0; i<stdList[select].subjects.length; i++) {
						System.out.println("[" + (i+1) + "]" + stdList[select].subjects[i].name);
					}
				}
				
				System.out.print("과목선택: ");
				int num = scan.nextInt();
				num --;
				
				System.out.print("성적입력: ");
				int score = scan.nextInt();
				
				stdList[select].subjects[num].score = score;
			}
			
			else if (choice == 4) {
				System.out.println("종료");
				break;
			}
			
		}
		scan.close();

	}

}
