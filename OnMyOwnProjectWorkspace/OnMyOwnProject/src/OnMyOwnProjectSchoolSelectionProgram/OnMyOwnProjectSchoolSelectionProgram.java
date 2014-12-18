package OnMyOwnProjectSchoolSelectionProgram;

import java.io.*;
import java.util.*;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import Core.ProblemInfo;

public class OnMyOwnProjectSchoolSelectionProgram 
{
	
	public OnMyOwnProjectSchoolSelectionProgram() throws IOException
	{
		
		ProblemInfo.inputPath = ProblemInfo.workingDirectory + "\\data\\input\\";
		//read in schools
		try {
			FileInputStream fileSchool = new FileInputStream(new File(ProblemInfo.inputPath + "Schools.xls"));
			HSSFWorkbook schoolWorkbook = new HSSFWorkbook(fileSchool);
			HSSFSheet schoolSheet = schoolWorkbook.getSheetAt(0);
			ProblemInfo.numSchools = schoolSheet.getPhysicalNumberOfRows() -1;
			Cell cell = null;
		
			int rowCountSchools = 1;
			int colCounter = 0;
			String schoolName;
			String tempString;
			int numStudentsPerSchool;
			List<School> schools = new ArrayList<School>();
		
			for(int numSchools = ProblemInfo.numSchools;numSchools>0;numSchools--)
			{
				cell = schoolSheet.getRow(rowCountSchools).getCell(colCounter++);
				schoolName = cell.toString();
				cell = schoolSheet.getRow(rowCountSchools).getCell(colCounter);
				tempString = cell.toString();
				tempString = tempString.substring(0,tempString.length()-2);
				numStudentsPerSchool = Integer.parseInt(tempString);
				rowCountSchools++;
				colCounter=0;
				schools.add(new School(schoolName,numStudentsPerSchool));
				
				
			}
		fileSchool.close();
			
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
		
		//read in students
		try
		{
			FileInputStream fileStudent = new FileInputStream(new File(ProblemInfo.inputPath + "Students.xls"));
			HSSFWorkbook studentWorkbook = new HSSFWorkbook(fileStudent);
			HSSFSheet studentSheet = studentWorkbook.getSheetAt(0);
			ProblemInfo.numStudents = studentSheet.getPhysicalNumberOfRows() -1;
			Cell cell = null;
			int rowCounter = 1;
			int colCounter = 0;
			String nameOfStudent;
			String firstChoice;
			String secondChoice;
			String thirdChoice;
			List<Student> students = new ArrayList<Student>();
			for(int i=ProblemInfo.numStudents; i >0; i--)
			{
				cell = studentSheet.getRow(rowCounter).getCell(colCounter++);
				nameOfStudent = cell.toString();
				cell = studentSheet.getRow(rowCounter).getCell(colCounter++);
				firstChoice = cell.toString();
				cell = studentSheet.getRow(rowCounter).getCell(colCounter++);
				secondChoice = cell.toString();
				cell = studentSheet.getRow(rowCounter).getCell(colCounter++);
				thirdChoice = cell.toString();
				
				students.add(new Student(nameOfStudent,firstChoice,secondChoice,thirdChoice));
				rowCounter++;
				colCounter=0;
				
			}
			
			
			
		}
		catch(FileNotFoundException e){
			e.printStackTrace();
		}
		
		
	}
}
