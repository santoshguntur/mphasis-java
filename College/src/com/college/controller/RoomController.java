package com.college.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.apache.log4j.Logger;
import org.hibernate.Session;

import com.college.entity.Room;
import com.college.util.HibernateUtil;
import com.google.gson.Gson;

@WebServlet(urlPatterns = { "/addRoom" })
public class RoomController extends HttpServlet {

	private final static Logger logger = Logger.getLogger(RoomController.class);
	private static final long serialVersionUID = 1L;
	private Session session;
	private Gson gson;
	 

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		logger.info("addRoom Servlet request recevied");
		BufferedReader br=null;
		resp.setContentType("application/json;charset=UTF-8");
		 String output=null; ServletOutputStream out =null;
		 com.college.util.Response response=null;
		try {
// 1. get received JSON data from request
		 br = new BufferedReader(new InputStreamReader(req.getInputStream()));
		String json = "";
		if (br != null) {
			json = br.readLine();
			System.out.println(json);
		}

// 2. initiate jackson mapper
		 gson = new Gson();

// 3. Convert received JSON to User
		Room room = gson.fromJson(json, Room.class);

//4. begin the trasaction
		session.beginTransaction();

//5. save the user data
		Integer id=(Integer)session.save(room);

//6.Commit the trasaction
		session.getTransaction().commit();
		
// 7.prepare the response
		
		/*
		 * Response okdas = Response .status(Response.Status.OK)
		 * .entity("Room created with ID:"+id) .build();
		 */
		 
		 response=new com.college.util.Response(Status.OK,"Room created.Room id is:"+id,null);
		
		output=gson.toJson(response);
		
		 
		 out = resp.getOutputStream(); 
		 out.print(output);
		 out.flush();

		logger.info("Room saved:" + room);
		}catch (Exception e) {
			session.getTransaction().rollback();
			e.printStackTrace();
			logger.error("Error while creating the user:", e);
			/*
			 * Response okdas=Response .status(Response.Status.INTERNAL_SERVER_ERROR)
			 * .entity(e.getMessage()) .build();
			 */
			 response=new com.college.util.Response(Status.OK,e.getMessage(),e);

     		output=gson.toJson(response);
			out.print(output);
			out.flush();
		}
		finally {
			
			
			if(br!=null) {
				br.close();
			}
			if (session != null)
				session.close();
			if(out!=null) {
				out.close();
			}
			
		}
		 
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

	/*
	 * @Override public void destroy() { if (session != null) session.close();
	 * logger.info("Session destroyed:" + session);
	 * 
	 * }
	 */

	@Override
	public void init() throws ServletException {

		session = HibernateUtil.getSessionFactory().openSession();
		 gson= new Gson();
		logger.info("Session created:" + session);
	}

}
