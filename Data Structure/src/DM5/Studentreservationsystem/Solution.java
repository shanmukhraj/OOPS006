package DM5.Studentreservationsystem;
import java.util.*;
import java.io.*;
class Student implements Comparable<Student>{
	String name;
	String dob;
	int sub1;
	int sub2;
	int sub3;
	int marks;
	String category;
	boolean flag;
	Student(String name, String dob, int sub1, int sub2, int sub3, int marks, String category){
		//your code goes here.
		this.name = name;
        this.dob = dob;
        this.sub1 = sub1;
        this.sub2 = sub2;
        this.sub3 = sub3;
        this.marks = marks;
        this.category = category;
	}
	public int compareTo(Student stu) {
     	//your code goes here.
		if (this.marks != stu.marks)
            return stu.marks - this.marks;
        else if (this.sub3 != stu.sub3)
            return stu.sub3 - this.sub3;
        else if (this.sub2 != stu.sub2)
            return stu.sub2 - this.sub2;
        else {
            String[] s1 = this.dob.split("-"), s2 = stu.dob.split("-");
            if (Integer.parseInt(s2[2]) != Integer.parseInt(s1[2]))
                return Integer.parseInt(s2[2]) - Integer.parseInt(s1[2]);
            else if(Integer.parseInt(s2[1]) != Integer.parseInt(s1[1]))
                return Integer.parseInt(s2[1]) - Integer.parseInt(s1[1]);
            else
                return Integer.parseInt(s2[0]) - Integer.parseInt(s1[0]);
        }
    
    }
    
}

class Selection{
	Student[] list;
	int vacancies;
	int open;
	int bcReserved;
	int scReserved;
	int stReserved;
	Selection(int no_of_Students, int no_of_positions,int open, int bcReserved, int scReserved, int stReserved) {
		list = new Student[no_of_Students];
		vacancies = no_of_positions;
		this.open = open;
		this.bcReserved = bcReserved;
		this.scReserved = scReserved;
		this.stReserved = stReserved;
	}

	public Student[] getSelectedList(){
		//your code goes here.
		int bcCount = 0, stCount = 0, scCount = 0;
        for (int index = 0; index < list.length; index++){
            if (list[index].category.toLowerCase().equals("bc"))
                bcCount++;
            else if (list[index].category.toLowerCase().equals("sc"))
                scCount++;
            else if (list[index].category.toLowerCase().equals("st"))
                stCount++;
        }
        Arrays.sort(list);

        // select list based on reservation criteria.
        Student selected[] = new Student[vacancies];
        int selected_index = 0,copy = open;
        for (int index = 0; index<copy; index++,--open,--vacancies) {
            selected[selected_index++] = list[index];
            if (list[index].category.toLowerCase().equals("bc"))
                bcCount--;
            else if (list[index].category.toLowerCase().equals("sc"))
                scCount--;
            else if (list[index].category.toLowerCase().equals("st"))
                stCount--;
        }
        // checking the possibility of other open seats.
        open = 0;
        if (bcReserved > bcCount)
            open += (bcReserved - bcCount);
        if (scReserved > scCount)
            open += (scReserved-scCount);
        if (stReserved > stCount)
            open += (stReserved-stCount);
        for (int index = copy; index<list.length && vacancies > 0; index++){
            if (list[index].category.toLowerCase().equals("bc") && bcReserved > 0) {
                    selected[selected_index++] = list[index];
                    vacancies--;
                    bcReserved--;
                    bcCount--;
            }
            else if(list[index].category.toLowerCase().equals("sc") && scReserved > 0){
                selected[selected_index++] = list[index];
                vacancies--;
                scReserved--;
                scCount--;
            }
            else if(list[index].category.toLowerCase().equals("st") && stReserved > 0){
                selected[selected_index++] = list[index];
                vacancies--;
                stReserved--;
                stCount--;
            }
            else{
                if(open > 0){ //checking for any open possibilities
                        selected[selected_index++] = list[index];
                        open--;
                        vacancies--;
                }
            }
        }
        return selected;
    }
}

public class Solution {
	public static void main(String[] args) throws Exception {
		int no_of_testcases = 6;
		int i = 0;
		while(i < no_of_testcases){
			String inputFile = "C:\\Users\\HP\\OOPS006\\Data Structure\\src\\DM5\\Studentreservationsystem\\testcases\\input00"+i+".txt";
			String outputFile = "C:\\Users\\HP\\OOPS006\\Data Structure\\src\\DM5\\Studentreservationsystem\\testcases\\output00"+i+".txt";
			ReadInput(inputFile,outputFile);
			i++;
		}	
	}
	public static void ReadInput(String inputFile, String outputFile) throws Exception{
		Scanner sc = new Scanner(new File(inputFile));
		int no_of_Students = Integer.parseInt(sc.nextLine());
		int no_of_positions = Integer.parseInt(sc.nextLine());
		int open = Integer.parseInt(sc.nextLine());
		int BC_count = Integer.parseInt(sc.nextLine());
		int SC_count = Integer.parseInt(sc.nextLine());
		int ST_count = Integer.parseInt(sc.nextLine());

		Selection sel_obj = new Selection(no_of_Students, no_of_positions, open, BC_count,SC_count,ST_count);
		for(int i = 0; i < no_of_Students; i++){
			String[] Student_info = sc.nextLine().split(",");
			Student stu_obj = new Student(Student_info[0],Student_info[1], Integer.parseInt(Student_info[2]),Integer.parseInt(Student_info[3]),Integer.parseInt(Student_info[4]),Integer.parseInt(Student_info[5]), Student_info[6]);
			sel_obj.list[i] = stu_obj;
		}
		Student[] finallist = sel_obj.getSelectedList();
		checkOutput(finallist, no_of_positions,outputFile);

	}
	public static void checkOutput(Student[] arr, int no_of_positions, String outputFile) throws Exception{
		Scanner sc = new Scanner(new File(outputFile));
		for(int i = 0; i < no_of_positions; i++){
			if(!sc.nextLine().equals(arr[i].name)){
				System.out.println("Your output is not matching with output in file "+ outputFile);
				return;
			}
		}
		System.out.println("your output with file "+ outputFile+" Matched. This Test case passed");

	}

}