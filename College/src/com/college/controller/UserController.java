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
import javax.ws.rs.core.Response.Status;

import org.apache.log4j.Logger;
import org.hibernate.Session;

import com.college.util.HibernateUtil;
import com.college.entity.User;
import com.google.gson.Gson;

@WebServlet(urlPatterns = { "/addUser" })
public class UserController extends HttpServlet {

	private final static Logger logger = Logger.getLogger(UserController.class);
	private static final long serialVersionUID = 1L;
	private Session sessionOne;
	private Gson gson;
	

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		logger.info("Servlet request recevied");
		BufferedReader br=null;
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
		User user = gson.fromJson(json, User.class);

//4. begin the transaction
		sessionOne.beginTransaction();

//5. save the user data
		Integer id=(Integer) sessionOne.save(user);

//6.Commit the transaction
		sessionOne.getTransaction().commit();
		
// 7.prepare the response
		
				/*
				 * Response okdas = Response .status(Response.Status.OK)
				 * .entity("Room created with ID:"+id) .build();
				 */
				 
				 response=new com.college.util.Response(Status.OK,"User created with ID:"+id,null);
				
				output=gson.toJson(response);
				
				 
				 out = resp.getOutputStream(); 
				 out.print(output);
				 out.flush();


		logger.info("User saved/updated:" + user);
		}catch (Exception e) {
			sessionOne.getTransaction().rollback();
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
			
		}

		// 7.prepare the response
		/*
		 * String output=null; ServletOutputStream out =null; resp.getOutputStream();
		 * Gson gson = new Gson(); try{
		 * resp.setContentType("application/json;charset=UTF-8");
		 * 
		 * User user=new User(); resp.setContentType("");
		 * user.setFirstName(req.getParameter("FirstName"));
		 * user.setLastName(req.getParameter("LastName"));;
		 * user.setPassword(req.getParameter("passWord"));
		 * user.setEmilId(req.getParameter("emailId")); req.getParameter("FirstName");
		 * req.getParameter("FirstName"); req.getParameter("FirstName");
		 * 
		 * output=gson.toJson(user);
		 * 
		 * out = resp.getOutputStream(); }catch (Exception e) { output=gson.toJson(e);
		 * }finally{ out.print(output); out.close(); }
		 */
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

	@Override
	public void destroy() {
		if (sessionOne != null)
			sessionOne.close();
		logger.info("Session destroyed:" + sessionOne);

	}

	@Override
	public void init() throws ServletException {

		sessionOne = HibernateUtil.getSessionFactory().openSession();
		 gson= new Gson();
		logger.info("Session created:" + sessionOne);
	}

}
