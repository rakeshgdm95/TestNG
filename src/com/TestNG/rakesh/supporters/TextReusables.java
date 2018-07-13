package com.TestNG.rakesh.supporters;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;

public class TextReusables {
 private String filepath;
 private File file;
 private FileWriter fw;
 private BufferedWriter bw;
 private FileReader fr;
 private BufferedReader br;
public TextReusables(String filepath) throws IOException,FileNotFoundException,EncryptedDocumentException{
	 this.filepath=filepath;
	 File file=new File(filepath);
	 boolean status=file.createNewFile();
	 if(status ) {
		 System.out.println("File is created newly.......");
	 }
	 else {
		 System.out.println("Return existing file!.....");
	 }
 
  fw=new FileWriter(file);
  bw=new BufferedWriter(fw);
  fr=new FileReader(file);
  br=new BufferedReader(fr);
}
public void writeIntData(int data) throws IOException {
	bw.write(data);
	bw.flush();
}
public void writeSrtData(String data) throws IOException {
	bw.write(data);
	bw.flush();
}
public String readOneLine() throws IOException {
	String data=br.readLine();
	return data;
	
}
public List getTotalData() throws IOException {
	List filedata=new ArrayList();
	while(br.ready());
	{
		String data=br.readLine();
		filedata.add(data);
	}
	return filedata;
	
}
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
}
