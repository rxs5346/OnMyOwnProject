package OnMyOwnProjectGui;

import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import com.mysql.jdbc.PreparedStatement;

import Core.ProblemInfo;
import OnMyOwnProjectSchoolSelectionProgram.OnMyOwnProjectSchoolSelectionProgram;



public class FirstProjectAddRemoveScreen
{
	boolean alreadyDisplayAddStudent = false;
	boolean alreadyDisplayRemoveStudent = false;
	boolean alreadyDisplayAddSchool = false;
	boolean alreadyDisplayRemoveSchool = false;

	public FirstProjectAddRemoveScreen()
	{
		//TODO bug where some buttons clear gui and some dont
		final JFrame theFrame = new JFrame();
		GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment()
				.getDefaultScreenDevice();
		int widthOfScreen = gd.getDisplayMode().getWidth();
		int heightOfScreen = gd.getDisplayMode().getHeight();
		theFrame.setTitle("First Project Screen");
		theFrame.setSize(widthOfScreen - 50, heightOfScreen - 50);
		theFrame.setLocation(550, 400);

		// final JPanel panel = new JPanel(new GridLayout(7,2)); //TODO THIS CAN
		// GO AWAY AFTER WORKING
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
		final JPanel radioButtonPanel = new JPanel(new GridLayout(1, 4));
		final JPanel addStudentPanel = new JPanel(new GridLayout(12, 2));
		final JPanel removeStudentPanel = new JPanel(new GridLayout(3, 2));

		final JPanel addSchoolPanel = new JPanel(new GridLayout(3, 2));
		final JPanel removeSchoolPanel = new JPanel(new GridLayout(3, 2));

		// TODO fix the formatting of the gui, the two new radio buttons messed
		// with the formatting
		JRadioButton addStudentRadioButton = new JRadioButton("Add Student");
		JRadioButton removeStudentRadioButton = new JRadioButton(
				"Remove Student");
		JRadioButton addSchoolRadioButton = new JRadioButton("Add School");
		JRadioButton removeSchoolRadioButton = new JRadioButton("Remove School");
		final JButton firstProgramButton = new JButton(
				"Run School Selecting Program");
		radioButtonPanel.add(addStudentRadioButton);
		radioButtonPanel.add(removeStudentRadioButton);
		radioButtonPanel.add(addSchoolRadioButton);
		radioButtonPanel.add(removeSchoolRadioButton);
		radioButtonPanel.add(firstProgramButton);
		
		ButtonGroup groupButton = new ButtonGroup();
		groupButton.add(addStudentRadioButton);
		groupButton.add(removeStudentRadioButton);
		groupButton.add(addSchoolRadioButton);
		groupButton.add(removeSchoolRadioButton);
		mainPanel.add(radioButtonPanel);
		theFrame.getContentPane().add(mainPanel);
		
		// add student stuff
		final JLabel studentNameLabel = new JLabel("Student Name");
		final JTextField studentNameField = new JTextField(25);
		final JLabel studentFirstRegionLabel = new JLabel("First Region");
		final JTextField firstRegionField = new JTextField(50);
		final JLabel studentSecondRegionLabel = new JLabel("Second Region");
		final JTextField secondRegionField = new JTextField(50);
		final JLabel studentThirdRegionLabel = new JLabel("Third Region");
		final JTextField thirdRegionField = new JTextField(50);
		final JLabel studentFourthRegionLabel = new JLabel("Fourth Region");
		final JTextField fourthRegionField = new JTextField(50);
		final JLabel studentFifthRegionLabel = new JLabel("Fifth Region");
		final JTextField fifthRegionField = new JTextField(50);
		final JLabel studentSixthRegionLabel = new JLabel("Sixth Region");
		final JTextField sixthRegionField = new JTextField(50);
		final JLabel studentFirstWildCardLabel = new JLabel("First Wild Card");
		final JTextField firstWildCardField = new JTextField(50);
		final JLabel studentSecondWildCardLabel = new JLabel("Second Wild Card");
		final JTextField secondWildCardField = new JTextField(50);
		final JLabel studentThirdWildCardLabel = new JLabel("Third Wild Card");
		final JTextField thirdWildCardField = new JTextField(50);
		final JButton addStudent = new JButton("Add Student");
		final JLabel space1 = new JLabel("");
		final JLabel space2 = new JLabel("");
		final JLabel space3 = new JLabel("");
		final JLabel space4 = new JLabel("");
		final JLabel space5 = new JLabel("");
		final JLabel space6 = new JLabel("");
		final JLabel space7 = new JLabel("");
		final JLabel space8 = new JLabel("");
		final JLabel space9 = new JLabel("");
		final JLabel space10 = new JLabel("");
		final JLabel space11 = new JLabel("");
		final JLabel space12 = new JLabel("");

		addStudentPanel.add(studentNameLabel);
		addStudentPanel.add(studentNameField);

		addStudentPanel.add(studentFirstRegionLabel);
		addStudentPanel.add(firstRegionField);

		addStudentPanel.add(studentSecondRegionLabel);
		addStudentPanel.add(secondRegionField);

		addStudentPanel.add(studentThirdRegionLabel);
		addStudentPanel.add(thirdRegionField);

		addStudentPanel.add(studentFourthRegionLabel);
		addStudentPanel.add(fourthRegionField);

		addStudentPanel.add(studentFifthRegionLabel);
		addStudentPanel.add(fifthRegionField);

		addStudentPanel.add(studentSixthRegionLabel);
		addStudentPanel.add(sixthRegionField);

		addStudentPanel.add(studentFirstWildCardLabel);
		addStudentPanel.add(firstWildCardField);

		addStudentPanel.add(studentSecondWildCardLabel);
		addStudentPanel.add(secondWildCardField);

		addStudentPanel.add(studentThirdWildCardLabel);
		addStudentPanel.add(thirdWildCardField);

		addStudentPanel.add(space9);
		addStudentPanel.add(addStudent);


		theFrame.pack();
		theFrame.setVisible(true);
		// remove student stuff
		final JLabel studentNameLabelRemove = new JLabel("Student Name to remove");
		final JTextField studentNameFieldToRemove = new JTextField(25);
		// studentNameFieldToRemove.setBackground(Color.BLUE);
		final JButton removeStudent = new JButton("Remove Student");

		removeStudentPanel.add(space7);
		removeStudentPanel.add(space8);
		removeStudentPanel.add(studentNameLabelRemove);
		removeStudentPanel.add(studentNameFieldToRemove);

		removeStudentPanel.add(space10);
		removeStudentPanel.add(removeStudent);

		// add school stuff
		final JLabel schoolToAddLabel = new JLabel("School to Add");
		final JTextField schoolNameFieldToAdd = new JTextField(45);
		final JLabel numberOfPlacementsLabel = new JLabel(
				"Number of placements offered");
		final JTextField numberOfPlacementsField = new JTextField(5);
		final JLabel addSchoolRegionLabel = new JLabel("Region");
		final JTextField addSchoolRegionTextField = new JTextField(45);
		final JButton addSchool = new JButton("Add School");

		addSchoolPanel.add(space3);
		addSchoolPanel.add(space4);
		addSchoolPanel.add(space5);
		addSchoolPanel.add(space6);
		addSchoolPanel.add(schoolToAddLabel);
		addSchoolPanel.add(schoolNameFieldToAdd);

		addSchoolPanel.add(numberOfPlacementsLabel);
		addSchoolPanel.add(numberOfPlacementsField);

		addSchoolPanel.add(addSchoolRegionLabel);
		addSchoolPanel.add(addSchoolRegionTextField);

		addSchoolPanel.add(space11);
		addSchoolPanel.add(addSchool);

		// remove school stuff
		final JLabel schoolToRemoveLabel = new JLabel("School to Remove");
		final JTextField schoolNameFieldToRemove = new JTextField(45);
		final JButton removeSchoolButton = new JButton("Remove School");
		//panel for buttons
		removeSchoolPanel.add(space1);
		removeSchoolPanel.add(space2);
		removeSchoolPanel.add(schoolToRemoveLabel);
		removeSchoolPanel.add(schoolNameFieldToRemove);

		removeSchoolPanel.add(space12);
		removeSchoolPanel.add(removeSchoolButton);

		addSchoolRadioButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				if (alreadyDisplayRemoveStudent)
				{

					theFrame.getContentPane().remove(removeStudentPanel);

					alreadyDisplayRemoveStudent = false;
				}
				else if (alreadyDisplayAddStudent)
				{

					theFrame.getContentPane().remove(addStudentPanel);

					alreadyDisplayAddStudent = false;
				}
				else if (alreadyDisplayRemoveSchool)
				{

					theFrame.getContentPane().remove(removeSchoolPanel);
					alreadyDisplayRemoveSchool = false;
				}

				theFrame.getContentPane().add(addSchoolPanel);
				// set the add school stuff

				addSchool.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						String schoolToAdd = schoolNameFieldToAdd.getText();
						schoolToAdd = replaceSpace(schoolToAdd);
						int numSchoolPlacements = Integer
								.parseInt(numberOfPlacementsField.getText());
						String region = addSchoolRegionTextField.getText();
						region = replaceSpace(region);
						boolean addSchoolFlag = addSchoolToDatabase(
								schoolToAdd, numSchoolPlacements, region);
						if (addSchoolFlag)
						{
							System.out.println("School added");

						}
						else
						{
							System.out.println("Could not add school");
						}
					}
				});

				theFrame.pack();
				theFrame.setVisible(true);
				alreadyDisplayAddSchool = true;
			}
		});
		removeSchoolRadioButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				if (alreadyDisplayRemoveStudent)
				{

					theFrame.getContentPane().remove(removeStudentPanel);

					alreadyDisplayRemoveStudent = false;
				}
				else if (alreadyDisplayAddStudent)
				{
					theFrame.getContentPane().remove(addStudentPanel);

					alreadyDisplayAddStudent = false;
				}
				else if (alreadyDisplayAddSchool)
				{
					theFrame.getContentPane().remove(addSchoolPanel);

					alreadyDisplayAddSchool = false;
				}

				theFrame.getContentPane().add(removeSchoolPanel);

				removeSchoolButton.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						String schoolToRemove = schoolNameFieldToRemove
								.getText();
						schoolToRemove = replaceSpace(schoolToRemove);
						boolean addSchoolFlag = removeSchoolFromDatabase(schoolToRemove);
						if (addSchoolFlag)
						{
							System.out.println("School removed");

						}
						else
						{
							System.out.println("Could not remove school");
						}
					}
				});

				//theFrame.pack();
				theFrame.setVisible(true);
				alreadyDisplayRemoveSchool = true;
			}
		});
		addStudentRadioButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				if (alreadyDisplayRemoveStudent)
				{
					theFrame.getContentPane().remove(removeStudentPanel);

					alreadyDisplayRemoveStudent = false;
				}
				else if (alreadyDisplayRemoveSchool)
				{
					theFrame.getContentPane().remove(removeSchoolPanel);

					alreadyDisplayRemoveSchool = false;
				}
				else if (alreadyDisplayAddSchool)
				{
					theFrame.getContentPane().remove(addSchoolPanel);

					alreadyDisplayAddSchool = false;
				}
				theFrame.getContentPane().add(addStudentPanel);

				addStudent.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						String studentName = studentNameField.getText();
						String firstRegion = firstRegionField.getText();
						String secondRegion = secondRegionField.getText();
						String thirdRegion = thirdRegionField.getText();
						String fourthRegion = fourthRegionField.getText();
						String fifthRegion = fifthRegionField.getText();
						String sixthRegion = sixthRegionField.getText();
						String firstWildCard = firstWildCardField.getText();
						String secondWildCard = secondWildCardField.getText();
						String thirdWildCard = thirdWildCardField.getText();

						studentName = replaceSpace(studentName);
						firstRegion = replaceSpace(firstRegion);
						secondRegion = replaceSpace(secondRegion);
						thirdRegion = replaceSpace(thirdRegion);
						fourthRegion = replaceSpace(fourthRegion);
						fifthRegion = replaceSpace(fifthRegion);
						sixthRegion = replaceSpace(sixthRegion);
						firstWildCard = replaceSpace(firstWildCard);
						secondWildCard = replaceSpace(secondWildCard);
						thirdWildCard = replaceSpace(thirdWildCard);

						// addStudentToFile(studentName,firstChoice,secondChoice,thirdChoice);
						// TODO
						boolean addedStudentFlag = addStudentToDatabase(
								studentName, firstRegion, secondRegion,
								thirdRegion, fourthRegion, fifthRegion,
								sixthRegion, firstWildCard, secondWildCard,
								thirdWildCard);
						
						if(addedStudentFlag)
						{
							System.out.println("Added Student");
						}
						else
						{
							System.out.println("Student could not be added to the database");
						}
						studentNameField.setText("");
						firstRegionField.setText("");
						secondRegionField.setText("");
						thirdRegionField.setText("");
						fourthRegionField.setText("");
						fifthRegionField.setText("");
						sixthRegionField.setText("");
						firstWildCardField.setText("");
						secondWildCardField.setText("");
						thirdWildCardField.setText("");
					}
				});

				// panel.add(firstProgramButton);
				// theFrame.getContentPane().add(panel);
				theFrame.pack();
				theFrame.setVisible(true);
				alreadyDisplayAddStudent = true;

			}
		});
		removeStudentRadioButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				if (alreadyDisplayAddStudent)
				{
					theFrame.getContentPane().remove(addStudentPanel);

					alreadyDisplayAddStudent = false;

				}
				else if (alreadyDisplayAddSchool)
				{
					theFrame.getContentPane().remove(addSchoolPanel);
					alreadyDisplayAddSchool = false;
				}
				else if (alreadyDisplayRemoveSchool)
				{
					theFrame.getContentPane().remove(removeSchoolPanel);

					alreadyDisplayRemoveSchool = false;
				}
				theFrame.getContentPane().add(removeStudentPanel);

				alreadyDisplayRemoveStudent = true;

				removeStudent.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						String studentName = studentNameFieldToRemove.getText();
						studentName = replaceSpace(studentName);
						boolean removeFromDB = removeStudentFromDB(studentName);
						if (removeFromDB)
						{
							System.out.println("Student Removed from database");
						}
						else
						{
							System.out.println("Student did not exist in the database");
						}

						studentNameFieldToRemove.setText("");
					}
				});
				theFrame.pack();
				theFrame.setVisible(true);
			}
		});

		theFrame.pack();
		theFrame.setVisible(true);

		firstProgramButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{

				OnMyOwnProjectSchoolSelectionProgram firstProgram = new OnMyOwnProjectSchoolSelectionProgram();

			}
		});

		theFrame.addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent e)
			{
				System.exit(0);
			}
		});
	}

	public void addStudentToFile(String name, String firstChoice,
			String secondChoice, String thirdChoice)
	{
		File studentFile = new File(ProblemInfo.inputPath + "Students.xls");

		if (studentFile.exists())
		{
			try
			{
				FileInputStream fileIn = new FileInputStream(new File(
						ProblemInfo.inputPath + "Students.xls"));
				HSSFWorkbook workbook = new HSSFWorkbook(fileIn);
				HSSFSheet sheet = workbook.getSheetAt(0);
				int rowNum = sheet.getLastRowNum();
				Row row = sheet.createRow(++rowNum);
				Cell cell = row.createCell(0);
				cell.setCellValue(name);
				cell = row.createCell(1);
				cell.setCellValue(firstChoice);
				cell = row.createCell(2);
				cell.setCellValue(secondChoice);
				cell = row.createCell(3);
				cell.setCellValue(thirdChoice);

				try
				{
					FileOutputStream addStudent = new FileOutputStream(
							new File(ProblemInfo.inputPath + "Students.xls"));
					workbook.write(addStudent);
					addStudent.close();

				}
				catch (FileNotFoundException e)
				{
					e.printStackTrace();
				}
				catch (IOException e)
				{
					e.printStackTrace();
				}
			}

			catch (FileNotFoundException e)
			{
				e.printStackTrace();
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
		}
		else
		{
			// create file, because it does not exist in the file location
		}

	}

	public boolean removeStudentFromDB(String name)
	{
		Connection removeStudentConnection = null;
		boolean removeFlag = false;
		try
		{
			removeStudentConnection = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/placeStudentsEducation",
					"root", "test!"); // root! at sru test! at home
			// .getConnection("jdbc:mysql://localhost:3306/placeStudentsEducation","root",
			// "root!"); //root! at sru test! at home
		}
		catch (SQLException e)
		{
			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();

		}

		if (removeStudentConnection != null)
		{

			try
			{

				String sqlRemove = " DELETE FROM STUDENTS WHERE name =?";

				// prepared statements used to prevent sql injection
				java.sql.PreparedStatement preparedRemoveStatement = removeStudentConnection
						.prepareStatement(sqlRemove);
				preparedRemoveStatement.setString(1, name);
				int testIfDeleted = preparedRemoveStatement.executeUpdate();
				if (testIfDeleted == 1)
				{
					removeFlag = true;
				}
				else
				{
					removeFlag = false;
				}
			}
			catch (SQLException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		if (removeStudentConnection != null)
		{
			try
			{
				removeStudentConnection.close();
			}
			catch (SQLException e)
			{

				e.printStackTrace();
			}
		}
		return removeFlag;
	}

	public boolean removeStudentFromFile(String name)
	{
		File studentFile = new File(ProblemInfo.inputPath + "Students.xls");

		if (studentFile.exists())
		{
			try
			{
				FileInputStream fileIn = new FileInputStream(new File(
						ProblemInfo.inputPath + "Students.xls"));
				HSSFWorkbook workbook = new HSSFWorkbook(fileIn);
				HSSFSheet sheet = workbook.getSheetAt(0);
				int rowNumIn = 0;

				for (Row row : sheet)
				{
					for (Cell cell : row)
					{

						if (cell.toString().equals(name))
						{
							rowNumIn = row.getRowNum();
							break;
						}

					}
				}
				Row rowToRemove = sheet.getRow(rowNumIn);
				sheet.removeRow(rowToRemove);

				// shift still isnt working correctly.... especially if it is
				// the last row
				sheet.shiftRows(rowNumIn + 1, sheet.getLastRowNum(), -1);

				try
				{
					FileOutputStream addStudent = new FileOutputStream(
							new File(ProblemInfo.inputPath + "Students.xls"));
					workbook.write(addStudent);
					addStudent.close();

				}
				catch (FileNotFoundException e)
				{
					e.printStackTrace();
				}
				catch (IOException e)
				{
					e.printStackTrace();
				}
			}

			catch (FileNotFoundException e)
			{
				e.printStackTrace();
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
		}
		else
		{
			// create file, because it does not exist in the file location
		}

		return true;
	}

	public String replaceSpace(String stringToReplace)
	{
		String replacedString = stringToReplace.replace(" ", "_");
		return replacedString;
	}

	public boolean addStudentToDatabase(String name, String firstRegion,
			String secondRegion, String thirdRegion, String fourthRegion,
			String fifthRegion, String sixthRegion, String firstWildCard,
			String secondWildCard, String thirdWildCard)
	{
		// TODO return if it is successful or not
		Connection addStudentConnection = null;
		boolean addedStudentFlag = false;
		try
		{
			addStudentConnection = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/placeStudentsEducation",
					"root", "test!"); // root! at sru test! at home
			// .getConnection("jdbc:mysql://localhost:3306/placeStudentsEducation","root",
			// "root!"); //root! at sru test! at home
		}
		catch (SQLException e)
		{
			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();
			
		}

		if (addStudentConnection != null)
		{

			try
			{

				String sqlAdd = " INSERT INTO STUDENTS(name,firstRegion,secondRegion,thirdRegion,fourthRegion,fifthRegion,sixthRegion,firstWildCard,secondWildCard,thirdWildCard)"
						+ "VALUES(?,?,?,?,?,?,?,?,?,?)";

				// prepared statements used to prevent sql injection
				java.sql.PreparedStatement preparedAddStatement = addStudentConnection
						.prepareStatement(sqlAdd);
				preparedAddStatement.setString(1, name);
				preparedAddStatement.setString(2, firstRegion);
				preparedAddStatement.setString(3, secondRegion);
				preparedAddStatement.setString(4, thirdRegion);
				preparedAddStatement.setString(5, fourthRegion);
				preparedAddStatement.setString(6, fifthRegion);
				preparedAddStatement.setString(7, sixthRegion);
				preparedAddStatement.setString(8, firstWildCard);
				preparedAddStatement.setString(9, secondWildCard);
				preparedAddStatement.setString(10, thirdWildCard);
				int testIfComplete = preparedAddStatement.executeUpdate();
				
				if(testIfComplete == 1)
				{
					addedStudentFlag = true;
				}
				else
				{
					addedStudentFlag = false;
				}
			
			}
			catch (SQLException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		if (addStudentConnection != null)
		{
			try
			{
				addStudentConnection.close();
			}
			catch (SQLException e)
			{

				e.printStackTrace();
			}
		}
		return addedStudentFlag;
	}

	public boolean addSchoolToDatabase(String schoolName, int numStudents,
			String region)
	{
		Connection addSchoolConnection = null;
		boolean addSchoolFlag = false;
		try
		{
			addSchoolConnection = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/placeStudentsEducation",
					"root", "test!"); // root! at sru test! at home
			// .getConnection("jdbc:mysql://localhost:3306/placeStudentsEducation","root",
			// "root!"); //root! at sru test! at home
		}
		catch (SQLException e)
		{
			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();

		}

		if (addSchoolConnection != null)
		{

			try
			{

				String sqlAddSchool = " INSERT INTO SCHOOLS(schoolName,numStudentsRecieving,regionOfSchool)"
						+ "VALUES(?,?,?)";

				// prepared statements used to prevent sql injection
				java.sql.PreparedStatement preparedAddSchoolStatement = addSchoolConnection
						.prepareStatement(sqlAddSchool);
				preparedAddSchoolStatement.setString(1, schoolName);
				preparedAddSchoolStatement.setInt(2, numStudents);
				preparedAddSchoolStatement.setString(3, region);
				int testIfAdded = preparedAddSchoolStatement.executeUpdate();
				if (testIfAdded == 1)
				{
					addSchoolFlag = true;
				}
				else
				{
					addSchoolFlag = false;
				}
			}
			catch (SQLException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		if (addSchoolConnection != null)
		{
			try
			{
				addSchoolConnection.close();
			}
			catch (SQLException e)
			{

				e.printStackTrace();
			}
		}
		return addSchoolFlag;

	}

	public boolean removeSchoolFromDatabase(String schoolName)
	{
		boolean removeSchoolFlag = false;
		Connection removeSchoolConnection = null;
		try
		{
			removeSchoolConnection = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/placeStudentsEducation",
					"root", "test!"); // root! at sru test! at home
			// .getConnection("jdbc:mysql://localhost:3306/placeStudentsEducation","root",
			// "root!"); //root! at sru test! at home
		}
		catch (SQLException e)
		{
			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();

		}

		if (removeSchoolConnection != null)
		{

			try
			{

				String sqlRemoveSchool = " DELETE FROM SCHOOLS WHERE schoolName =?";

				// prepared statements used to prevent sql injection
				java.sql.PreparedStatement preparedRemoveSchoolStatement = removeSchoolConnection
						.prepareStatement(sqlRemoveSchool);
				preparedRemoveSchoolStatement.setString(1, schoolName);
				int testIfDeleted = preparedRemoveSchoolStatement
						.executeUpdate();
				if (testIfDeleted == 1)
				{
					removeSchoolFlag = true;
				}
				else
				{
					removeSchoolFlag = false;
				}
			}
			catch (SQLException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		if (removeSchoolConnection != null)
		{
			try
			{
				removeSchoolConnection.close();
			}
			catch (SQLException e)
			{

				e.printStackTrace();
			}
		}

		return removeSchoolFlag;
	}

}
