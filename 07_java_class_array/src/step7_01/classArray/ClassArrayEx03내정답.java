package step7_01.classArray;
//*분석 2021/04/16 17:35 ~ 18:06
//      2021/04/19 13:57 ~ 13:59

class Client_1{
	
	String name;
	int score;
	
	void setData (String name, int score) {  
		this.name = name ; 		// 멤버변수에 파라메타로 넘어온 데이터를 대입
		this.score = score;		// 멤버변수에 파라메타로 넘어온 데이터를 대입
	}
	
	void printData() {
		System.out.println(this.name  + " : " + this.score);
	}
	
}

public class ClassArrayEx03내정답 {

	public static void main(String[] args) {
		
		Client_1[] clients = new Client_1[3];
		
		for (int i = 0; i < clients.length; i++) {
			clients[i] = new Client_1();
		}
		
		clients[0].setData("김철수",100); 
		clients[1].setData("이만수",20);
		clients[2].setData("박영희",70);
		
		for (int i = 0 ; i < clients.length; i++) { 
			clients[i].printData();
		}

	}

}

//분석결과
//김철수: 100
//이만수: 20
//박영희: 70
