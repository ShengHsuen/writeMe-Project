package com.mett.writeMe.services;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfWriter;
import com.mett.writeMe.ejb.Writting;

/**
 * @author Mildred Guerra
 *	Generate PDF 
 */
public class GeneratePDFService {
	   /**
	    * Constructor
	    */
    public GeneratePDFService(){
       
    }
    public void generatepdf(Writting w){
    	Document document =new Document();
    	try {
			FileOutputStream fichero=new  FileOutputStream(w.getName()+".pdf");
			PdfWriter writer= PdfWriter.getInstance(document, fichero);
			document.open();
			Image portda = Image.getInstance(w.getImage());
			document.add(portda);
			PdfContentByte cd= writer.getDirectContent();
			BaseFont bf= BaseFont.createFont(BaseFont.COURIER_BOLD, BaseFont.CP1252,BaseFont.NOT_EMBEDDED);
			cd.setFontAndSize(bf, 12);
			cd.beginText();
			cd.setTextMatrix(50,590);
			cd.showText(w.getContent());
			cd.endText();
			document.close();
    	} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (DocumentException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} 	
    }
    public void ITextHelloWorld(Writting w) {
        try {
            OutputStream file = new FileOutputStream(new File(w.getName()+".pdf"));

            Document document = new Document();
            PdfWriter.getInstance(document, file);
            Image portda = Image.getInstance(w.getImage());
            document.open();
            document.addTitle(w.getName());
            document.add(new Paragraph(w.getName()));
			document.add(portda);
			document.add(new Paragraph("Sipnosis"));
			document.add(new Paragraph(w.getDescription()));
            document.add(new Paragraph(w.getContent()));
            document.add(new Paragraph(new Date().toString()));

            document.close();
            file.close();

        } catch (Exception e) {

            e.printStackTrace();
        }
             
    }
}
