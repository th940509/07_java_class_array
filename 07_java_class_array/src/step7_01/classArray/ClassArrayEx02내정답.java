package step7_01.classArray;
//2021/04/16 17:12 ~ 17:21
//2021/04/19 13:55 ~ 13:57
class Card_1{
	
	int num;
	String shape;
	
}

public class ClassArrayEx02내정답 {

	public static void main(String[] args) {
		
		 Card_1[] arr = new Card_1[10]; // 클래스 배열 생성
		 
		 
		 
		 // for문 활용
		 for (int i = 0; i < 10;  i++) {
			 arr[i] = new Card_1();
			 arr[i].num = (i + 1); //arr[i]의 num
			 arr[i].shape = "클로버";
		 }

		 for (int i = 0; i < arr.length; i++) {
			System.out.println("num : " + arr[i].num); //1,2,3,4,5,6,7,8,9,10
			System.out.println("shape : " + arr[i].shape); // 클로버
			System.out.println();
		}
		 
	}

}
 