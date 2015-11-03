import java.io.*;
import java.util.*;
 
class Student implements Serializable {
	public int id;
	public String name;
	public String department;
	public int phoneNum;
}
 
public class StudentManagement {
	static Student[] student = new Student[300];
	static int studentCount = 0;
	public static void main(String[] args) throws IOException, ClassNotFoundException{
		Scanner sc = new Scanner(System.in);
		int menu=0;
		do{
			do{
				System.out.println("\n-----메   뉴-----");
				System.out.println("1. 학생 추가");
				System.out.println("2. 학생 정보 수정");
				System.out.println("3. 학생 삭제");
				System.out.println("4. 학생 정보 목록");
				System.out.println("5. 종료");
				System.out.print("메뉴 번호를 입력하세요(1~5): ");
				menu = sc.nextInt();
			}while(menu<1 || menu>5);
			switch(menu){
			case 1: 
				//add();
				break;
			case 2:
				//update();
				break;
			case 3:
				//delete();
				break;
			case 4:
				//view();
				break;
			case 5:
				//save();
				System.out.println("종료");
				break;
			}
		}while(menu!=5);
	}
	
}