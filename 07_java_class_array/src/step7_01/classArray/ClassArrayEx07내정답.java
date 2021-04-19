package step7_01.classArray;
//2021/04/16 18:33 ~ 
//# 클래스 배열 응용

class Subject_1{
	
	String name;
	int score;
	
}


class Student_1{
	
	Subject_1[] subjects;	// Subject 객체를 담을 클래스 배열
	String name;
	
}


public class ClassArrayEx07내정답 {

	public static void main(String[] args) {

		Student_1[] st = new Student_1[3]; // 클래스 배열 생성
		
		st[0] = new Student_1();
		st[0].subjects = new Subject_1[3];
		
		for (int i = 0; i < 3; i++) {
			st[0].subjects[i] = new Subject_1(); 
		}
		
		st[1] = new Student_1();
		st[1].subjects =new Subject_1[2];
		st[1].subjects[0] = new Subject_1();
		st[1].subjects[1] = new Subject_1();
		
		st[2] = new Student_1();
		st[2].subjects = new Subject_1[1];
		st[2].subjects[0] = new Subject_1();

	}

}
