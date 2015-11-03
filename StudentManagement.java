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
				update();
				break;
			case 3:
				delete();
				break;
			case 4:
				view();
				break;
			case 5:
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
	public static void update() throws FileNotFoundException, IOException, ClassNotFoundException{
		Scanner sc2 = new Scanner(System.in);
		int updateId;
		int newphoneNum;
		System.out.println("<학생 정보 수정>");
		System.out.println("학생 전화번호만 수정이 가능합니다.");
		System.out.print("수정할 학생 학번 입력: ");
		updateId = sc2.nextInt();
 
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("data.txt"));
		studentCount = ois.readInt();
		for(int i=0; i<=studentCount; i++){
			try{
				student[i] = (Student)ois.readObject();
				if(updateId == student[i].id){
					System.out.println("\n"+student[i].name+"("+student[i].id+")"+"의 전화번호를 수정합니다.");
					System.out.print("새 전화번호 입력: ");
					newphoneNum = sc2.nextInt();
					student[i].phoneNum = newphoneNum;
					save();
					System.out.println("수정되었습니다");
				}
			}catch(EOFException e){};
		}
 
	}
}