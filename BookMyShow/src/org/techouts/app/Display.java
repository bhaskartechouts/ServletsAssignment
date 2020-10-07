package org.techouts.app;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * Servlet implementation class Display
 */
@WebServlet("/Display")
public class Display extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Display() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		HttpSession session = request.getSession();
		String name = (String) session.getAttribute("name");
		String number = (String) session.getAttribute("number");
		String number1 = (String) session.getAttribute("number1");
		String ticket = (String) session.getAttribute("ticket");
		String nTicket = (String) session.getAttribute("nTicket");
		int total = (int) session.getAttribute("total");
		String store = name+","+number+","+number1+","+ticket+","+nTicket+","+total;
		HttpSession httpSession = request.getSession();
		 FileOutputStream out = new FileOutputStream(
		         new File("D:/text/BookMyShow.xls"));
		XSSFWorkbook workbook = new XSSFWorkbook();
	      
	      XSSFSheet spreadsheet = workbook.createSheet();

	      XSSFRow row;
	      int rowid = 0;
	      String[] store1 = store.split(",");
	      int i = store1.length-1;
	      int j = 0;
	      for (int k = 0 ; k <=1 ; k++) {
	         row = spreadsheet.createRow(rowid++);
	         Object [] objectArr = null;
	         if(j <= i){
	         objectArr = store1;
	         j++;
	         }
	         int cellid = 0;
	         if(k==0){
        		 String[] s1 = {"Name","Show Name","Show Time","Ticket Category","Number Of Tickets","Total Amount"};
        		 for(int l = 0;l < s1.length;l++){
        			 Cell cell = row.createCell(cellid++);
     	            cell.setCellValue((String)s1[l]);
     	            if(l==s1.length-1){
     	            	break;
     	            }
        		 }
        	 }
	         else {
	         for (Object obj : objectArr){
	            Cell cell = row.createCell(cellid++);
	            cell.setCellValue((String)obj);
	        	 }
	         }
	      }
	     
	      
	      workbook.write(out);
	      out.close();
		PrintWriter printWriter = response.getWriter();
		printWriter.println("Customer Name : " +name+", Movie Name : "+number+", Time Slot : "+number1+", Ticket Category :"+ticket+", Number of tickets : "+nTicket+", Total Amount :"+total);
	}

}
