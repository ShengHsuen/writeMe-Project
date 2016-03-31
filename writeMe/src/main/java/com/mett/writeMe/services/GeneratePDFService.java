package com.mett.writeMe.services;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.StringReader;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.html.simpleparser.HTMLWorker;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfWriter;
import com.mett.writeMe.ejb.Writting;
import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
/**
 * @author Mildred Guerra
 *	Generate PDF 
 */
public class GeneratePDFService {
	private static String PDF_PATH = "resources/pdfWrittings/";
	private static String HOST_PATH = "http://localhost:8080";
	@Autowired
	private ServletContext servletContext;
	   /**
	    * Constructor
	    */
    public GeneratePDFService(){
       
    }
    public void pdf(Writting w){
    	String contenido = w.getContent();
        OutputStream file;
		try {
		file = new FileOutputStream(new File(w.getName()+".pdf"));
		Image portda = Image.getInstance(w.getImage());
        Document document = new Document();
        PdfWriter.getInstance(document, file);
        document.open();
		document.add(portda);
//		  document.addAuthor("Real Gagnon");
//	      document.addCreator("Real's HowTo");
        document.addTitle(w.getName());
        document.add(new Paragraph(w.getName()));
        document.add(new Paragraph("Sipnosis"));
		document.add(new Paragraph(w.getDescription()));
        HTMLWorker htmlWorker = new HTMLWorker(document);
        htmlWorker.parse(new StringReader(contenido));
        document.close();
        file.close();
     //  String databaseFileName = HOST_PATH  + "/" + "writeMe/" + w.getName()+ ".pdf";
      // System.out.println("direccion "+ databaseFileName);
		} catch (DocumentException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

    }
    

}
