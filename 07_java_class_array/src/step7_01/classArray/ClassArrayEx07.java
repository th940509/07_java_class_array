package step7_01.classArray;

//# 클래스 배열 응용

class Subject{
	
	String name;
	int score;
	
}


class Student{
	
	Subject[] subjects;	// Subject 객체를 담을 클래스 배열
	String name;
	
}


public class ClassArrayEx07 {

	public static void main(String[] args) {

		Student[] st = new Student[3]; // Student 클래스의 배열(0-2)생성
		
		st[0] = new Student(); //  new Student (st[0])의 객체 생성
		st[0].subjects = new Subject[3]; // st[0].subjects 현재 null인 상태 , 0번째 객체에 subject 배열 (0-2) 생성
		
		for (int i = 0; i < 3; i++) {
			st[0].subjects[i] = new Subject();
		} // Subject 배열의 객체 생성
		
		st[1] = new Student();
		st[1].subjects =new Subject[2];
		st[1].subjects[0] = new Subject();
		st[1].subjects[1] = new Subject();
		
		st[2] = new Student();
		st[2].subjects = new Subject[1];
		st[2].subjects[0] = new Subject();

	}

}
