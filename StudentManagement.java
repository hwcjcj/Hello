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
				System.out.println("\n-----��   ��-----");
				System.out.println("1. �л� �߰�");
				System.out.println("2. �л� ���� ����");
				System.out.println("3. �л� ����");
				System.out.println("4. �л� ���� ���");
				System.out.println("5. ����");
				System.out.print("�޴� ��ȣ�� �Է��ϼ���(1~5): ");
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
				System.out.println("����");
				break;
			}
		}while(menu!=5);
	}
	public static void add() throws IOException{
		Scanner sc1 = new Scanner(System.in);
		System.out.println("<�л� �߰�>");
		student[studentCount] = new Student();
		System.out.print("�й�:");
		student[studentCount].id = sc1.nextInt();
		System.out.print("�̸�:");
		student[studentCount].name = sc1.next();
		System.out.print("�Ҽ�:");
		student[studentCount].department = sc1.next();
		System.out.print("��ȭ��ȣ:");
		student[studentCount].phoneNum = sc1.nextInt(); 
		studentCount++;
 
		save();
		System.out.println("���Ͽ� ����Ǿ����ϴ�");
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