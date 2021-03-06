package OnMyOwnProjectMain;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Statement;

import Core.ProblemInfo;
import OnMyOwnProjectGui.FirstProjectAddRemoveScreen;
import OnMyOwnProjectGui.LoginGui;
import OnMyOwnProjectGui.OnMyOwnProjectGui;

public class OnMyOwnProjectMain {


	public static void main(String[] args) 
	{
		//start gui here
		
		//LoginGui logIn = new LoginGui();
		//checkIfDBExists();
		//checkIfTableExists("Students");
		//checkIfTableExists("Schools");
	
		if(ProblemInfo.logInSuccessful) //TODO stubbed to always be true for now
		{
			FirstProjectAddRemoveScreen GUI = new FirstProjectAddRemoveScreen();
		}
		else
		{
			System.out.println("Could not log into the server");
		}

		


		System.gc();

	}

	public static void checkIfDBExists()
	{
		Connection createDBconnection = null;
		try 
		{
			createDBconnection = DriverManager
					.getConnection("jdbc:mysql://localhost:3306/","root", "test!"); //root! at sru test! at home
			//.getConnection("jdbc:mysql://localhost:3306/","root", "root!"); //root! at sru test! at home
		} 
		catch (SQLException e) 
		{
			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();
			return;
		}

		if (createDBconnection != null) 
		{
			
			java.sql.Statement stmt = null;
			boolean databaseThereFlag = false;
			ResultSet resultSet = null;
			try {
				resultSet = createDBconnection.getMetaData().getCatalogs();
				while(resultSet.next())
				{
					String databaseName = resultSet.getString(1);
					if(databaseName.equals("placestudentseducation"))
					{
						databaseThereFlag = true;
			
						break; //check to see if the tables exist here also? 
					}
				}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			finally
			{
				try {
					resultSet.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}



			try 
			{
				if(!databaseThereFlag)
				{
					stmt = createDBconnection.createStatement();
					String sqlCreateDatabase = "CREATE DATABASE placeStudentsEducation";

					stmt.executeUpdate(sqlCreateDatabase);
					System.out.println("Created database...");
				}
				else
				{
					System.out.println("Database exists");
				}

			} 
			catch (SQLException e) 
			{
				e.printStackTrace();
			}


		}
		else 	
		{

			System.out.println("Failed to make connection!");
		}


		if(createDBconnection != null)
		{
			try {
				createDBconnection.close();
			} catch (SQLException e) {

				e.printStackTrace();
			}
		}



	}
	public static void checkIfTableExists(String tableName)
	{
		Connection createTableConnection = null;
		try 
		{
			createTableConnection = DriverManager
			.getConnection("jdbc:mysql://localhost:3306/placeStudentsEducation","root", "test!"); //root! at sru test! at home
			//.getConnection("jdbc:mysql://localhost:3306/placeStudentsEducation","root", "root!"); //root! at sru test! at home
		} 
		catch (SQLException e) 
		{
			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();
			return;
		}

		if (createTableConnection != null) 
		{
			
			java.sql.Statement stmt = null;
			try 
			{
				DatabaseMetaData dbMeta = createTableConnection.getMetaData();
				ResultSet tables = dbMeta.getTables(null, null, tableName, null);
				if(tables.next())
				{
					System.out.println(tableName + " table exists");
				}
				else
				{
					
					if(tableName.equals("Students"))
					{
						stmt = createTableConnection.createStatement();
						String sqlCreateStudentTable = "CREATE TABLE STUDENTS "+
												"(name VARCHAR(52) not NULL, "+
												" firstRegion VARCHAR(255), "+
												" secondRegion VARCHAR(255), "+
												" thirdRegion VARCHAR(255), "+
												" fourthRegion VARCHAR(255),"+
												" fifthRegion VARCHAR(255),"+
												" sixthRegion VARCHAR(255),"+
												" firstWildCard VARCHAR(255),"+
												" secondWildCard VARCHAR(255),"+
												" thirdWildCard VARCHAR(255),"+
												" PRIMARY KEY ( name ))";
						stmt.executeUpdate(sqlCreateStudentTable);
						System.out.println("Created Students Table in database");
					}
					else if(tableName.equals("Schools"))
					{
						stmt = createTableConnection.createStatement();
						String sqlCreateSchoolTable = "CREATE TABLE SCHOOLS "+
								" (schoolName VARCHAR(52) not NULL, "+
								" numStudentsRecieving INTEGER not NULL, "+
								" regionOfSchool VARCHAR(52) not NULL" +
							    " PRIMARY KEY ( schoolName ))";
						stmt.executeUpdate(sqlCreateSchoolTable);
						System.out.println("Created Schools table in database");
					}
					else
					{
						System.out.println("Issue with creating tables");
					}
				}
				tables.close();
				
			
				

			} 
			catch (SQLException e) 
			{
				e.printStackTrace();
			}


		}
		else 	
		{

			System.out.println("Failed to make connection!");
		}


		if(createTableConnection != null)
		{
			try {
				createTableConnection.close();
			} catch (SQLException e) {

				e.printStackTrace();
			}
		}		


	}
}
