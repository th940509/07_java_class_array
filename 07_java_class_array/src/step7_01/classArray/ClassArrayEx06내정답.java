package step7_01.classArray;
//2021/04/16 18:25 ~ 18:32
class Member_1{
	
	String name;
	int num;
	
}


class MemberManager_1{

	Member_1[] memberList = new Member_1[3]; // 클래스배열 생성

}


public class ClassArrayEx06내정답 {

	public static void main(String[] args) {

		MemberManager_1 mg = new MemberManager_1();	//클래스 선언
		Member_1 m1 = new Member_1(); //클래스 선언
		mg.memberList[0] = m1; // memberList9[0]에만 Member_1 클래스 대입
		m1.name = "김철수"; // memberList[0].name = 김철수 /  memberList[0].num = 1001
		m1.num = 1001;
		
		m1 = new Member_1();
		mg.memberList[1] = m1;
		m1.name = "이만수"; // 이만수/1002
		m1.num = 1002;
		
		m1 = new Member_1();
		mg.memberList[2] = m1;
		m1.name = "박영희"; // 박영희/1003
		m1.num = 1003;
		
		for (int i = 0; i < mg.memberList.length; i++) {
			System.out.println("num : " + mg.memberList[i].num);
			System.out.println("name : " + mg.memberList[i].name);
			System.out.println(); 
		}
		
		Member_1 temp = mg.memberList[1];
		System.out.println(temp.name);

	}

}
// num: 1001
// name: 김철수
// num: 1002
// name: 이만수
// num: 1003
// name: 박영희
// 이만수
