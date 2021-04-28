package step7_01.classArray;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;

class StudentVO{
	
	String id = "";
	String pw = "";
	
	void set_data(String id , String  pw) {
		this.id = id; 
		this.pw = pw;
	}
	
	void print_data() {
		System.out.println("이름 : " + id + " 비밀번호 : " + pw);
	}
	
}


class StudentManager{
	
	ArrayList<StudentVO> studentList = new ArrayList<StudentVO>(); // arrayList 생성
	
	void add_student(StudentVO st) {
		studentList.add(st); // id, pw (temp)를 studentList에 add 메서드를 사용하여 저장.
	}
	
	
	StudentVO remove_student(int index) {
		StudentVO del_st = studentList.get(index); // get 메서드로 index 값 얻은 후 del_st에 대입
		studentList.remove(index); // index위치 remove 메서드로 삭제
		return del_st; // del_st 값 반환
	}
	
	
	int check_id(StudentVO st) { // temp 대입
		int check = -1;
		for (int i = 0; i < studentList.size(); i++) { // 처음 가입 시 studentList.size = 0 성립X
			if (studentList.get(i).id.equals(st.id)) { // 2번 가입 시 studentList.size = 1
				                                       // studentList.get(0).id 와 st.id 비교
				check = i; // 같으면 check의 값변경 -> 중복 아이디
				break;
			}
		}
		return check; // check = -1
	}
	
	
	void print_student() {
		for (int i = 0; i < studentList.size() ;i++) {
			studentList.get(i).print_data();
		}
	}	
	
	
	String out_data() {
		String data = ""; // 
		int count = studentList.size(); // studentList의 데이터 개수를 반환
		if (count == 0){ 
			return data;
		}
		data += count; // ex) 3
		data += "\n"; 
		for (int i = 0; i < count; i++) { // i=0; i<3; i++ -> i=0,1,2일때만 성립
			data += studentList.get(i).id; // studentList.get(0).id
			data += ",";
			data += studentList.get(i).pw; // studentList.get(0).pw
			if (count - 1 != i) { // count = 1 일때 0 != 0 성립X
				                  // id,pw 간의 줄 점프
				data += "\n";
			}
		}
		return data; // data 반환
	}
	
	
	void sort_data() { // 직접 구현해보세요
		for(int i=0; i<studentList.size(); i++) { // 5번 가입 -> studentList.size = 5 / i = 0,1,2,3,4
			for(int j=0; j<studentList.size(); j++) { // j = 0,1,2,3,4
				//1:aa 2:cc 3:dd 4:ee 5:bb
				if(studentList.get(i).id.compareTo(studentList.get(j).id) > 0) { 
					StudentVO temp = new StudentVO(); // 클래스 생성 * arrayList 생성 시 오류남
					temp = studentList.get(i); // temp에 크기가 큰 값 대입
					studentList.set(i, studentList.get(j)); // i 자리에 작은 값 대입
					studentList.set(j, temp); // j 자리에 temp(크기가 큰 값) 대입
					temp = null; // temp 값 삭제
				}
			}
		}
	}
	
	
	void load_student(ArrayList<StudentVO> temp ) {
		studentList = temp;
	}	
	
	
	int get_size() {
		return studentList.size();
	}
	
}

public class ClassArrayEx23_정답 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		StudentManager manager = new StudentManager();
		
		while (true) {
			
			System.out.println("1.가입 2.탈퇴 3.정렬 4.출력 5.저장 6.로드 7.종료");
			int sel = scan.nextInt();
			
			if (sel == 1) { // 가입 check_id, add_student 메서드 사용
				
				StudentVO temp = new StudentVO(); // 클래스 생성
				System.out.println("[가입] id 를 입력하세요 >>> ");
				temp.id = scan.next();	//temp.id에 위의 아이디를 저장
				int check =  manager.check_id(temp); 
				
				if (check == -1) {
					System.out.println("[가입] pw 를 입력하세요 >>> ");
					temp.pw = scan.next();
					manager.add_student(temp);	
					System.out.println(temp.id + "님 가입을 환영합니다."); // (1) studentList의 크기 [1] / (2) 크기 [2]
				}
				else {
					System.out.println("중복아이디 입니다.");
				}	
				
			}
			else if (sel == 2) { // 탈퇴 print_student, check_id, remove_student 메서드 사용
				
				manager.print_student();
				
				StudentVO temp = new StudentVO(); // 클래스 생성
				
				System.out.println("[탈퇴] id 를 입력하세요 >>> ");
				temp.id = scan.next();	
				
				int check = manager.check_id(temp); 
				if (check == -1) {
					System.out.println("없는 아이디입니다.");
				}
				else {
					StudentVO del_st = manager.remove_student(check);
					System.out.println(del_st.id + "님 탈퇴 되었습니다.");
				}
				
			}
			else if (sel == 3) { //정렬
				
				manager.sort_data();
				manager.print_student();
				
			}
			else if (sel == 4) { // 출력
				
				manager.print_student();
				
			}
			else if (sel == 5) { // 저장

				String fileName = "student_manager_studentList.txt";
				FileWriter fw = null;
				
                if (manager.get_size() == 0) return; // 가입하지 않았을 경우
				
                try {
                	fw = new FileWriter(fileName); // 파일 생성 객체
					String data = manager.out_data(); // out_data -> data 반환
					                                  // String data에 data 반환된 값 대입
					
					if (!data.equals("")) { // data가 ""와 다를경우 성립
						fw.write(data);
						System.out.println(data);
					}
					
				} catch (Exception e) {
					e.printStackTrace();
				}
                finally {
                	try {fw.close();} catch (IOException e) {e.printStackTrace();}	
                }
			}
			else if (sel == 6) { // 로드
				
				File file = new File("student_manager_studentList.txt"); // 파일 객체 생성
				FileReader fr = null; // 파일 읽어오기
				BufferedReader br = null; // 텍스트 읽어오기
				
				try {
					
					
					if (file.exists()) {
						
						fr = new FileReader(file);
						br = new BufferedReader(fr);
						
						ArrayList<StudentVO> studentList = new ArrayList<StudentVO>(); // arrayList 생성
						
						String line = br.readLine(); // 1줄 불러오기
						int count = Integer.parseInt(line); // 1번째줄 정수로 변경 
						                                    // count = studentList.Size
						
						for (int i = 0; i < count; i++) {
							StudentVO temp = new StudentVO(); // temp 클래스 생성
							line = br.readLine();
							String value[] = line.split(","); // ,로 나눈 후 String 배열에 대입
							temp.id = value[0];
							temp.pw = value[1];
							studentList.add(temp); // arrayList에 temp temp의 값 추가
						}
						manager.load_student(studentList); // 새로 만든 210번째 줄 studentList의 값을 기존 studentList에 값 대입
						
					}
					manager.print_student(); // 출력 
					
				}
				catch (Exception e) {e.printStackTrace();}
				finally {
					try {br.close();} catch (IOException e) {e.printStackTrace();}
					try {fr.close();} catch (IOException e) {e.printStackTrace();}
				}
									
			}
			else if (sel == 7) { 
				System.out.println("종료");
				break;
			}
		}
		
		scan.close();

	}

}
