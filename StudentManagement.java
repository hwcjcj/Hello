import java.io.*;
import java.util.*;

class Student implements Serializable {
	public int id;
	public String name;
	public String department;
	public String phoneNum;
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
				update();
				break;
			case 3:
				delete();
				break;
			case 4:
				view();
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
		System.out.print("��ȭ��ȣ(-���� �Է����ּ���):");
		student[studentCount].phoneNum = sc1.next(); 
		studentCount++;
		save();
		System.out.println("���Ͽ� ����Ǿ����ϴ�");
	}
	
	public static void update() throws FileNotFoundException, IOException, ClassNotFoundException{
		Scanner sc2 = new Scanner(System.in);
		int updateId;
		String newphoneNum;
		System.out.println("<�л� ���� ����>");
		System.out.println("�л� ��ȭ��ȣ�� ������ �����մϴ�.");
		System.out.print("������ �л� �й� �Է�: ");
		updateId = sc2.nextInt();
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("data.txt"));
		studentCount = ois.readInt();
		for(int i=0; i<=studentCount; i++){
			try{
				student[i] = (Student)ois.readObject();
				if(updateId == student[i].id){
					System.out.println("\n"+student[i].name+"("+student[i].id+")"+"�� ��ȭ��ȣ�� �����մϴ�.");
					System.out.print("�� ��ȭ��ȣ �Է�(-���� �Է����ּ���): ");
					newphoneNum = sc2.next();
					student[i].phoneNum = newphoneNum;
					save();
					System.out.println("�����Ǿ����ϴ�");
				}
			}catch(EOFException e){};
		}
	}
	
	public static void delete() throws FileNotFoundException, IOException, ClassNotFoundException{
		Scanner sc3 = new Scanner(System.in);
		System.out.println("<�л� ����>");
		System.out.print("������ �л��� �й� �Է�: ");
		int deleteId = sc3.nextInt();
		ObjectInputStream ois1 = new ObjectInputStream(new FileInputStream("data.txt"));
		studentCount= ois1.readInt();
		try{
			for(int i=0; i<studentCount; i++){
				if (deleteId == student[i].id) {
					for (int j=i+1; j<studentCount; j++) {
						student[j-1] = student[j]; 
					}
					studentCount--;  // �Ѱ� ����Ƿ� ����
					save();
					System.out.println("�����Ͽ����ϴ�. ");   
				}
			}
		}catch(EOFException e){};
	}
	
	public static void view() throws IOException, ClassNotFoundException {
		System.out.println("�й�\t�̸�\t�Ҽ�\t��ȭ��ȣ");
		ObjectInputStream ois1 = new ObjectInputStream(new FileInputStream("data.txt"));
		studentCount= ois1.readInt();
		for(int j = 0; j<studentCount; j++){
			student[j] = (Student)ois1.readObject();
			System.out.println(student[j].id +"\t"+student[j].name+"\t"+student[j].department+"\t"+student[j].phoneNum);
		}
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
