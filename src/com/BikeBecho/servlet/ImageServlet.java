package com.BikeBecho.Servlet;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.BikeBecho.Dao.BikeDaoImpl;
import com.BikeBecho.pojo.Bike;


@WebServlet("/ImageServlet")
public class ImageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public ImageServlet() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		BikeDaoImpl bDao=new BikeDaoImpl();
		int imageNum=1;
		int id=Integer.parseInt(request.getParameter("bikeId"));
		imageNum=Integer.parseInt(request.getParameter("imageNum"));
        
		Bike b=bDao.getBikeByid(id);
		InputStream is;
		if(imageNum==1)
		{
			 is=b.getImg1();
		}
		else if(imageNum==2)
		{
			 is=b.getImg2();
		}
		else if(imageNum==3)
		{
			 is=b.getImg3();
		}
		else
		{
			 is=b.getImg1();

		}
		response.setContentType("/*image");
		OutputStream os=response.getOutputStream();
		int read=is.read();
		while(read!=-1)
		{
			os.write(read);
			read=is.read();
		}
	os.flush();
	os.close();
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
