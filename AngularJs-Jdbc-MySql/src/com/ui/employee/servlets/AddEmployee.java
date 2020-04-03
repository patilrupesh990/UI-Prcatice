package com.ui.employee.servlets;

import java.io.BufferedReader;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.JSONObject;

import com.ui.employee.dao.EmployeeDAO;
import com.ui.employee.model.Employee;

@WebServlet("/addEmployeeServlet")
public class AddEmployee extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException {
        handleRequest(req, resp);
    }
 
    public void handleRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException {
 
        String str = null;  
        StringBuffer sb = null;
        JSONObject jObj = null;
        BufferedReader br = null;
        Employee employee=new Employee();
        try {
            br = req.getReader();
            sb = new StringBuffer();
 
            while ((str = br.readLine()) != null) {
                sb.append(str);
            }
            jObj = new JSONObject(sb.toString());
            employee.setEmpName(jObj.getString("empName"));
            employee.setEmpEmail(jObj.getString("empEmail"));
            employee.setEmpGender(jObj.getString("empGender"));
            EmployeeDAO.addEmployee(employee);
            /**** Preparing The Output Response ****/
            resp.setContentType("text/html");
            resp.setCharacterEncoding("UTF-8");
            resp.getWriter().write("Welcome " + employee.getEmpName() + " !!");
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

}
