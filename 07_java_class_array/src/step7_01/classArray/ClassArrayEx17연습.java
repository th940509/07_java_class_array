package step7_01.classArray;
/*
 * 접근제어자: public, private + getter/setter
 * public -> 보안 설정
 * */

class ModifierTest_1 {
	private int asdf; // 밑의 get옆에 첫글자 대문자 사용 ex) zxcv일경우 getZxcv로 사용
	public int b;
	
	//private변수를 클래스 외부로 꺼내주는 메서드 getter
	int getAsdf() {
		return this.asdf;
	}
	
	//private변수를 클래스 외부에서 수정하는 메서드 setter
	void setAsdf(int a) {
		this.asdf = a;
	}
}
public class ClassArrayEx17연습 {

	public static void main(String[] args) {
		ModifierTest_1 obj = new ModifierTest_1();
		
//		private 변수는 클래스 외부에서 접근 불가
//		obj.a = 1000;
//		System.out.println(obj.a);
		
		obj.b = 2000;
		System.out.println(obj.b);
		
		obj.setAsdf(55555); //setter를 이용하여 private 변수에 값 대입
		System.out.println(obj.getAsdf()); //getter 이용하여 private 변수의 값 꺼내오기
	}

}
