package com.fdmgroup.ranking;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.extractor.WordExtractor;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;

public class ResumeFileReader {
	
	private static ResumeFileReader fr = null;
	
	private ResumeFileReader(){
	}
	
	public static ResumeFileReader getInstance(){
		if (fr == null)
			fr = new ResumeFileReader();
		
		return fr;
	}
	
	public String readDoc(String fileName){
		String text = null;
		HWPFDocument doc = null;
		try {
			doc = new HWPFDocument(new FileInputStream(fileName));
			WordExtractor we = new WordExtractor(doc);
			text = we.getText();
				   
			we.close();
	    } catch (IOException e) {
	    	e.printStackTrace();
	    }
		
		return text;
	}
	
	public String readDocx(String fileName){
		String text = null;
		XWPFDocument docx = null;
		try {
			docx = new XWPFDocument(new FileInputStream(fileName));
			XWPFWordExtractor we = new XWPFWordExtractor(docx);
			text = we.getText();
	      
			we.close();
	    } catch (IOException e) {
	    	e.printStackTrace();
	    }
		
		return text;
	}
	
	public String readPDF(String fileName){
		String text = null;
		PDFTextStripper pdfStripper = null;
        PDDocument pdDoc = null;
        try {
            pdDoc = PDDocument.load(new File(fileName));
            pdfStripper = new PDFTextStripper();
            /*pdfStripper.setStartPage(1);
            pdfStripper.setEndPage(5);*/
            text = pdfStripper.getText(pdDoc);
        } catch (IOException e) {
            e.printStackTrace();
        } 
        
        return text;
	}
	
	public String readTXT(String fileName){
		StringBuilder text = new StringBuilder("");
        try {
        	BufferedReader br = new BufferedReader(new FileReader(fileName));
        	String line = br.readLine();
        	while(line != null){
        		text.append(line);
        		line = br.readLine();
        	}
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
        
        return text.toString();
	}
}