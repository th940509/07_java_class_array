package step7_01.classArray;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
//import java.io.IOException;
import java.util.Scanner;

class StudentEx{
	
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



class Manager {
	
	StudentEx[] list = null;
	int stdCnt = 0;
	
	void add_StudentEx(StudentEx st) {  // temp를 대입하기 위해서 temp의 변수 동일해야 함.
		//167번줄 StudentEx temp = new StudentEx(); -> temp의 변수 StudentEx
		
		if (stdCnt == 0) {
			list = new StudentEx[1];
		}
		else if (stdCnt > 0) {
			StudentEx[] temp = list;
			list = new StudentEx[stdCnt + 1];
			for (int i = 0; i < stdCnt; i++) {
				list[i] = temp[i];
			}
			temp = null;
		}
		list[stdCnt] = st;
		stdCnt++;
		
	}
	
	
	
	StudentEx remove_StudentEx (int index) {
		
		StudentEx del_st = list[index];
		if (stdCnt == 1) {
			list = null;
		}
		else if (stdCnt > 1) {
			StudentEx [] temp = list;
			list = new StudentEx[stdCnt -1];
			for (int i = 0; i < index; i++) {
				list[i] = temp[i];
			}
			for (int i = index; i < stdCnt -1; i++) {
				list[i] = temp[i + 1];
			}
			temp = null;
		}
		stdCnt--;
		
		return del_st;
		
	}
	
	
	
	int check_id(StudentEx st) {
		
		int check = -1;
		for (int i = 0; i < stdCnt; i++) {
			if (list[i].id.equals(st.id)) {
				check = i;
				break;
			}
		}
		return check;
		
	}
	
	
	
	void print_StudentEx() {
		
		for (int i = 0; i < stdCnt ;i++) {
			list[i].print_data();
		}
		
	}	
	
	
	
	String out_data() {
		
		String data = "";
		if (stdCnt == 0){
			return data;
		}
		data += stdCnt;
		data += "\n";
		for (int i = 0; i < stdCnt; i++) {
			data += list[i].id;
			data += ",";
			data += list[i].pw;
			if (stdCnt - 1 != i) {
				data += "\n";
			}
		}
		return data;
		
	}
	
	
	
	void sort_data() {
		
		for (int i = 0; i < stdCnt; i++) {
			for (int n = 0; n < stdCnt ; n++) {
				if (list[i].id.compareTo(list[n].id) > 0) {
					StudentEx temp = list[i];
					list[i] = list[n];
					list[n] = temp;
				}
			}
		}
		
	}
	
	
	
	void load_StudentEx (StudentEx [] temp , int count) {
		
		this.stdCnt = count;
		this.list = temp;
		
	}
	
}


public class ClassArrayEx13_정답예시 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		Manager manager = new Manager();
		
		
		while (true) {
			
			System.out.println("1.가입 2.탈퇴 3.정렬 4.출력 5.저장 6.로드 7.종료");
			int sel = scan.nextInt();
			
			if (sel == 1) { // 가입
				
				StudentEx temp = new StudentEx(); // StudentEx 객체 대입
				System.out.println("[가입] id 를 입력하세요 >>> "); //asdf
				temp.id = scan.next();	// temp.id = asdf	
				int check =  manager.check_id(temp); // check = -1
				
				if(check == -1) {
					System.out.println("[가입] pw 를 입력하세요 >>> "); // zxcv
					temp.pw = scan.next(); // temp.pw = zxcv
					manager.add_StudentEx(temp); // list = new StudentEx[1] / list[0] = temp / stdCnt = 0+1 = 1
					System.out.println(temp.id + "님 가입을 환영합니다.");
				}
				else {
					System.out.println("중복아이디 입니다.");
				}	
				
			}
			else if (sel == 2) { // 탈퇴
				
				manager.print_StudentEx();  // stdCnt == 1 이므로, i=0만 가능. list[0].print_data(); - >
				                            // 이름: asdf / 비밀번호: zxcv 출력
				StudentEx temp = new StudentEx(); // StudentEx 객체 대입
				System.out.println("[탈퇴] id 를 입력하세요 >>> "); // asdf
				temp.id = scan.next();	// temp.id = asdf
				int check = manager.check_id(temp); // list[0].id.equals(temp.id) -> 성립하면 check = 0 이되고, check의 값 반환(0)
				
				if (check == -1) {
					System.out.println("없는 아이디입니다.");
				}
				else {
					StudentEx del_st = manager.remove_StudentEx(check); // check = 0 일때, Student del_st = list[0]을 대입
					                                                    // stdCnt = 1 이기 때문에 list = null
					                                                    // stdCnt = 1-1 = 0, list = null -> del_st의 값 반환
					                                                    // list = null 이나 del_st의 값은 존재함.
					System.out.println(del_st.id + "님 탈퇴 되었습니다."); 
				}
				
			}
			else if (sel == 3) { // 정렬
				
				manager.sort_data(); // 탈퇴를 하지 않았을 경우 stdCnt = 1. i=0 일때만 성립.
				                     // if(list[0].id.compareTo(list[0].id > 0) -> 문자열 비교
				                     // stdCnt = 1 일때는 위의 if문 성립X
				manager.print_StudentEx(); // stdCnt = 1, i=0일때만 성립.
				                           // list[0].print_data();
				                           // System.out.println("이름 : " + id + " 비밀번호 : " + pw) 출력
				
			}
			else if (sel == 4) { // 출력
				
				manager.print_StudentEx();  // stdCnt = 1, i=0일때만 성립.
                                            // list[0].print_data();
                                            // System.out.println("이름 : " + id + " 비밀번호 : " + pw) 출력
				
			}
			else if (sel == 5) { // 저장
				
                if (manager.stdCnt == 0) continue; // stdCnt = 0 일 경우 continue
				
                try {
                	
					FileWriter fw = new FileWriter("StudentEx_manager.txt"); // 파일 입력
					String data = manager.out_data(); // out_data에서 id, pw 정보를 data에 저장
					if (!data.equals("")) { // ?
						fw.write(data); // write메서드로 문자열 데이터 입력 
						System.out.println(data);
					}
					fw.close();	
					
				} catch (Exception e) {e.printStackTrace();} 
                //finally {
    			//try {fw.close();} catch (IOException e) {e.printStackTrace();} // [중요] 파일 객체 종료
    		    //}  사용x?
                
			}
			else if(sel == 6) { // 로드
				
				try {
					
					File file = new File("StudentEx_manager.txt"); // 파일 객체 생성
					
					if (file.exists()) { // 파일이 존재하면
						
						FileReader fr = new FileReader(file); // FileReader fr = null / fr = new FileReader(file) 붙여서 사용
						BufferedReader br = new BufferedReader(fr);
						
						String line = br.readLine(); // 한줄 불러오기
						int count = Integer.parseInt(line); // count에 Line을 숫자로 바꿔 대입 (1째줄: stdCnt = 1)
						StudentEx [] temp = new StudentEx[count]; // count(stdCnt) = 1 숫자 만큼의 temp 배열 생성
						
						for (int i = 0; i < count; i++) { // count=1, i=0일때 성립
							temp[i] = new StudentEx(); // temp[0] = StudentEx객체 대입
							line = br.readLine(); // 그 다음줄 불러오기 (list[i].id, list[i].pw) => asdf,zxcv
							String value[] = line.split(","); //  , 기준으로 나누기
							temp[i].id = value[0]; // asdf
							temp[i].pw = value[1]; // zxcv
						}
						
						fr.close(); // 왜 여기서...닫나요...........
						br.close();
						
						manager.load_StudentEx(temp , count); // stdCnt = 1 , list에 temp배열 대입 (asdf/zxcv)
						
					}
					
					manager.print_StudentEx(); // stdCnt=1, i=0일때 성립
					                           // list[0].print_data();
					                           // System.out.println("이름 : " + id + " 비밀번호 : " + pw);
				}
				catch (Exception e) {e.printStackTrace();}
									
			}
			else if (sel == 7) { // 종료
				System.out.println("종료");
				break;
			}
			
		}

		scan.close();
		
	}

}
