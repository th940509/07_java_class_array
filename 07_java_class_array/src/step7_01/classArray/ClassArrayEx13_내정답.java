package step7_01.classArray;

import java.util.Scanner;


//class StudentEx_1{
//	
//	String id = "";
//	String pw = "";
//	
//	void set_data(String id , String  pw) {
//		this.id = id; 
//		this.pw = pw;
//	}
//	
//	
//	void print_data() {
//		System.out.println("이름 : " + id + " 비밀번호 : " + pw);
//	}
//	
//}
//
//class Manager_1{
//	
//	StudentEx_1 [] list = null;
//	int stdCnt = 0;
//	
//	void add_StudentEx(StudentEx_1 st) {  // 1번째 / list 배열에 id, pw 저장
//	 
//		if (stdCnt == 0) {
//			list = new StudentEx_1[1];
//		}
//		else if (stdCnt > 0) {
//			StudentEx_1 [] temp = list;
//			list = new StudentEx_1[stdCnt +1]; // 
//			for(int i=0; i<stdCnt; i++) {
//				list[i] = temp[i];
//			}
//			temp = null;
//		}
//		list[stdCnt] = st; // list[0]번 째에 st(temp)의 주소(링크) 공유
//		stdCnt ++;
//	}
//	
//	StudentEx_1 remove_StudentEx (int index) {
//		StudentEx_1 del_st = list[index]; // 링크 공유
//		if(stdCnt == 1) {
//			list = null;
//		}
//		
//	
//	
//	int check_id(StudentEx_1 st) {
//		int check = -1;
//		for(int i=0; i<stdCnt; i++) {
//			if(list[i].id.equals(st.id)) {
//				check = i;
//				break;
//			}
//		}
//		return check;	
//	}
//	
//	void print_StudentEx() { //list 배열에 저장되어있는 id,pw 출력 기능 메서드
//		for(int i=0; i<stdCnt; i++) {
//			list[i].print_data();
//		}
//	}	
//	
//	String out_data() {}
//	
//	void sort_data() {}
//	
//	void load_StudentEx (StudentEx_1 [] temp , int count) {}
//	
//}


//public class ClassArrayEx13_내정답 {
//
//	public static void main(String[] args) {
//		
//		Scanner scan = new Scanner(System.in);
//		
//		Manager_1 manager = new Manager_1();
//		
//		while (true) {
//			
//			System.out.println("1.가입 2.탈퇴 3.정렬 4.출력 5.저장 6.로드 7.종료");
//			int sel = scan.nextInt();
//			
//			/*
//			 * [1] 가입하기 : ID 중복검사 구현
//			 * [2] 탈퇴하기 : ID를 입력받아 탈퇴
//			 * [3] 정렬하기 : 이름을 국어사전 순으로 정렬
//			 * [4] 출력하기 : 데이터들을 화면에 출력
//			 * [5] 저장하기 : 아래와 같은 형식으로 저장
//			 * [6] 불러오기 : 파일에 저장된 내용을 불러오기
//			 * [7] 종료하기 : 반복문을 종료
//			 * 
//			 * 			예) 
//			 * 			2				// 회원 수
//			 *			qwer,1234		// id,pw	
//			 *			abcd,1111		// id, pw
//			 */
//			
/// 		if		(sel == 1) { // 가입 check_id, add_StudentEx 메서드 사용
//				StudentEx_1 temp = new StudentEx_1(); // temp에 StudentEx_1 객체 대입
//				System.out.print("[가입] id 입력 >> ");
//				temp.id = scan.next(); 
//				int check = manager.check_id(temp);
//				
//				if(check == -1) {
//					System.out.print("[가입] pw 입력 >> ");
//					temp.pw = scan.next();
//					manager.add_StudentEx(temp);
//					System.out.println(temp.id + "님 가입을 환영합니다!");
//				}
//				else {
//					System.out.println("중복 아이디 입니다!");
//				}
//			}
//			
//			else if (sel == 2) { // 탈퇴
//				manager.print_StudentEx();
//				StudentEx_1 temp = new StudentEx_1();
//				System.out.print("[탈퇴] id 입력>> ");
//				temp.id = scan.next();
//				int check = manager.check_id(temp);
//				
//				if(check == -1) {
//					System.out.println("없는 아이디 입니다.");
//				}
//				else {
//					
//				}
//				
//			}
//			else if (sel == 3) {}
//			else if (sel == 4) {}
//			else if (sel == 5) {}
//			else if (sel == 6) {}
//			else if (sel == 7) { 
//				break; 
//			}
//			
//		}
//
//	}
//
//}
