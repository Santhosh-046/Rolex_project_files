/*PROGRAMMER:SANTHOSH
 * DATE:30/11/2023
 * PRAGRAM NAME:FILE HANDLING.....
 * DESCRIPTION:THIS PROGRAM IS USED TO CREATE ,RENAME ,DELETE,WRITE ,READ THE FILE........
*/
package com.File_handling.pack;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
public class File_Handling {
	static String location="C:\\Users\\santh\\Desktop";
	static Scanner A=new Scanner(System.in);
	public static void main(String[] args) throws IOException {
			while(true){
			menu1();
		System.out.println("ENTER YOUR CHOICE:");
	int choice=A.nextInt();
	switch(choice)
	{
	case 1:System.out.println("CREATE A NEW FOLDER\n");
	new_folder();
	break;
	case 2:System.out.println("CREATE A SUB FOLDER\n");
    new_sub_folder();
	break;
	case 3:System.out.println("CREATE A NEW FILE:\n");
	new_file();
	break;
	case 4:System.out.println("WRITE IN FILE\n");
	write();
	break;
	case 5:System.out.println("READ IN FILE\n");
	read();
	break;
	case 6:System.out.println("RENNAME THE FILE NAME");
	rename();
	break;
	case 7:System.out.println("LIST OF FILES IN THE FOLDER");
	listoffiles();
	break;
	case 8:System.out.println("DELETE FILE\n");
	delete_file();
	break;
	case 9:System.out.println("DELETE SUB FOLDER\n");
	delete_sub_folder();
	break;
	case 10:System.out.println("DELETE FOLDER\n");
	delete_folder();
	break;
	case 11:System.out.println("PROGRAM STOPPED......\n");
	System.exit(choice);
	break;
	}
	}
}
	public static void menu1()
	{
		System.out.println("\n\n->->->->->->->->->->->->->->->->->");
		System.out.println("/>/>/>/>/>/>/>:FILE HANDLING : />/>/>/>/>/>/>/");
		System.out.println("->->->->->->->->->->->->->->->->->->->");
		System.out.println("< SELECT OPTION 1. TO  CREATE FOLDER >");
		System.out.println("< SELECT OPTION 2. TO    SUB FOLDER  >");
		System.out.println("< SELECT OPTION 3. TO   CREATE FILE  >");
		System.out.println("< SELECT OPTION 4. TO  WRITE IN FILE >");
		System.out.println("< SELECT OPTION 5. TO  READ IN FILE  >");
		System.out.println("< SELECT OPTION 6. TO RENAME FILE NAME");
		System.out.println("< SELECT OPTION 7. TO LIST OF FILE IN FOLDER");
		System.out.println("< SELECT OPTION 8. TO   DELETE FILE  >");
		System.out.println("< SELECT OPTION 9. TO DELETE SUB FOLDER >");
		System.out.println("< SELECT OPTION 10. TO  DELETE FOLDER >");
		System.out.println("< SELECT OPTION 11. TO   STOP PROGRAM  ");
		System.out.println("<-<-<-<-<-<-<-<-<-<-<-<-<-<-<-<-<-<-<-");
		System.out.println("<-<-<-<-<-<-<-<-<-<-<-<-<-<-<-<-<-<-<-");		
	}
	public static void new_folder()
	{
		System.out.println("ENTER THE FLODER NAME :");
		String folder_name=A.next();
		File f=new File(location+"\\"+folder_name);
		boolean p=f.exists();
		if(p==false)
		{	
			f.mkdir();
		System.out.println("FOLDER CREATED SUCCESSFULLY...\n");
		System.out.println("FOLDER NAME:"+folder_name);
		System.out.println("LOCATION OF THE FOLDER:"+location+"\\"+folder_name);
		}
		else
		{
			System.out.println("FOLDER ALREADY EXISTS.....");
			System.out.println("CREATE A NEW FOLDER.....");
		}
		
	}
	public static  void new_sub_folder()
	{
		System.out.println("ENTER THE EXISTING FOLDER NAME:");
		String folder_name=A.next();
		System.out.println("ENTER NAME OF THE NEW SUB_FOLDER:");
		String sub_folder_name=A.next();
		File f=new File(location+"\\"+folder_name+"\\"+sub_folder_name);
		boolean p=f.exists();
		if(p==false)
		{
			f.mkdirs();
			System.out.println("SUB_FOLDER IS CREATED SUCCESSFULLY....\n");
			System.out.println("FOLDER NAME:"+folder_name);
			System.out.println("SUB_FOLDER NAME:"+sub_folder_name);
			System.out.println("LOCATION OF THE SUB_FOLDER:"+location+"\\"+folder_name+"\\"+sub_folder_name);
		}
		else
		{
			System.out.println("SUB_FOLDER ALREADY EXISTS....");
			System.out.println("CREATE A NEW SUB_FOLDER.....");
}
		}
		public static  void new_file() throws IOException
	{
		System.out.println("ENTER THE EXISTING FOLDER NAME:");
		String folder_name=A.next();
		System.out.println("ENTER THE EXISTING SUB_FOLDER NAME:");
		String sub_folder_name=A.next();
		System.out.println("ENTER NAME OF THE NEW FILE WITH FILE EXTENTION MUST...");
		String file=A.next();
		File f=new File(location+"\\"+folder_name+"\\"+sub_folder_name+"\\"+file);
		boolean p=f.exists();
		if(p==false)
		{
			f.createNewFile();
			System.out.println("FILE CREATED SUCCESSFULLY....");
			System.out.println("FOLDER NAME:"+folder_name);
			System.out.println("SUB_FOLDER NAME:"+sub_folder_name);
			System.out.println("FILE NAME IS :"+f.getName());
			System.out.println("LOCATION OF THE FILE:"+location+"\\"+folder_name+"\\"+sub_folder_name+"\\"+file);
		}
		else
		{
			System.out.println("FILE ALREADY EXISTS....");
			System.out.println("CREATE A NEW FILE....");
		}
	}
	public static  void write() throws IOException
	{  
		System.out.println("ENTER THE EXISTING FOLDER NAME:");
		String folder_name=A.next();
		System.out.println("ENTER THE EXISTING SUB_FOLDER NAME:");
		String sub_folder_name=A.next();
		System.out.println("ENTER NAME OF EXISTING FILE WITH EXTENTION  MUST...");
		String file=A.next();
		File f=new File(location+"\\"+folder_name+"\\"+sub_folder_name+"\\"+file);
		FileWriter fw=new FileWriter(f,true);
		BufferedWriter bw=new BufferedWriter(fw);
		System.out.println("WRITE TEXT TO STORE IN THIS FILE:");
		String a=A.next();
	    bw.write(a);
		bw.flush();
		bw.close();
		System.out.println(" WRITING COMPLETED......");
		System.out.println("YOUR TEXT WILL BE IN THIS LOCATION:"+location+"\\"+folder_name+"\\"+sub_folder_name+"\\"+file);
		System.out.println("FILE NAME:"+file);
	}
	public static  void read() throws IOException
	{
		System.out.println("ENTER THE EXISTING FOLDER NAME:");
		String folder_name=A.next();
		System.out.println("ENTER NAME OF EXISTING  SUB_FOLDER:");
		String sub_folder_name=A.next();
		System.out.println("ENTER NAME OF EXISTING FILE WITH EXTENTION  MUST...");
		String file=A.next();
		File f=new File(location+"\\"+folder_name+"\\"+sub_folder_name+"\\"+file);
		FileReader fr=new FileReader(f);
		BufferedReader br=new BufferedReader(fr);
		String line=br.readLine();
		while (line!=null)
		{
			System.out.println(line);
			line=br.readLine();
		}
	}
	public static void rename()
	{
		System.out.println("ENTER THE EXISTING FOLDER NAME:");
		String folder_name=A.next();
		System.out.println("ENTER NAME OF EXISTING  SUB_FOLDER:");
		String sub_folder_name=A.next();
		System.out.println("ENTER NAME OF EXISTING FILE WITH EXTENTION  MUST...");
		String file=A.next();
		File f=new File(location+"\\"+folder_name+"\\"+sub_folder_name+"\\"+file);
		System.out.println("ENTER THE NEW NAME OF THE FILE:");
		String new_name=A.next();
		File f1=new File(location+"\\"+folder_name+"\\"+sub_folder_name+"\\"+new_name);
		f.renameTo(f1);
		System.out.println("FILE RENAMED SUCCESSFULLY....\n NOW THE FILE NAME IS:"+f1.getName());
		}
	public static void listoffiles()
	{
		int count=0;
		System.out.println("ENTER THE FOLDER NAME TO LIST THE FILES:");
		String folder_name=A.next();
		System.out.println("ENTER NAME OF EXISTING  SUB_FOLDER:");
		String sub_folder_name=A.next();
		File f=new File(location+"\\"+folder_name+"\\"+sub_folder_name);
		String[] listoffiles=f.list();
		for(int i=0;i<listoffiles.length;i++) {
			System.out.println("FILE-"+i+" "+listoffiles[i]);
		   count++;
		}
		System.out.println("TOTAL NUMBER OF FILES = "+count);
	}
	public static  void delete_file() throws IOException
	{
		System.out.println("ENTER THE EXISTING FOLDER NAME:");
		String folder_name=A.next();
		System.out.println("ENTER NAME OF EXISTING  SUB_FOLDER:");
		String sub_folder_name=A.next();
		System.out.println("ENTER NAME OF EXISTING FILE WITH EXTENTION  MUST...");
		String file=A.next();
		File f=new File(location+"\\"+folder_name+"\\"+sub_folder_name+"\\"+file);
		f.delete();
		if (f.exists()==false) {
		System.out.println("FILE DELETED SUCCESSFULLY.....");}
		else { System.out.println("FILE NOT DELETED");
		}
		}
	public static  void delete_sub_folder()
	{
		System.out.println("ENTER THE EXISTING FOLDER NAME:");
		String folder_name=A.next();
		System.out.println("ENTER NAME OF EXISTING  SUB_FOLDER:");
		String sub_folder_name=A.next();
		File f=new File(location+"\\"+folder_name+"\\"+sub_folder_name);
		f.delete();
		boolean p=f.exists();
		if (p==false) {
		System.out.println("SUB_FOLDER DELETED SUCCESSFULLY.....");}
		else { System.out.println("SUB_FOLDER NOT DELETED");
		System.out.println("THIS SUB_FOLDER CONTAINS FILES...");
				}
	}
	public static  void delete_folder()
	{
		System.out.println("ENTER THE EXISTING FOLDER NAME:");
		String folder_name=A.next();
		File f=new File(location+"\\"+folder_name);
		f.delete();
		f.delete();
		if (f.exists()==false) {
		System.out.println("FILE DELETED SUCCESSFULLY.....");}
		else { System.out.println("FILE NOT DELETED");
		System.out.println("THIS FOLDER CONTAINS SUB_FOLDER AND FILES");
		}
	}
}