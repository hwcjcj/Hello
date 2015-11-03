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
				add();
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
				save();
				System.out.println("종료");
				break;
			}
		}while(menu!=5);
	}
	public static void add() throws IOException{
		Scanner sc1 = new Scanner(System.in);
		System.out.println("<학생 추가>");
		student[studentCount] = new Student();
		System.out.print("학번:");
		student[studentCount].id = sc1.nextInt();
		System.out.print("이름:");
		student[studentCount].name = sc1.next();
		System.out.print("소속:");
		student[studentCount].department = sc1.next();
		System.out.print("전화번호:");
		student[studentCount].phoneNum = sc1.nextInt(); 
		studentCount++;
 
		save();
		System.out.println("파일에 저장되었습니다");
	}
 
	public static void save() throws IOException {
 
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("data.txt"));
		oos.writeInt(studentCount);
		for(int j = 0; j < studentCount; j++) {
			oos.writeObject(student[j]);
		}
		oos.close();
	}
	
}