package tzc.blog.controller;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.List;

import tzc.blog.bean.Category;
import tzc.blog.dao.CategoryDao;

/**
 * Servlet implementation class AdminCategoryController
 */
public class AdminCategoryController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminCategoryController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/jsp,charset=utf-8");
		CategoryDao categoryDao =new CategoryDao(); 
		List<Category> categories = categoryDao.getAll();
		
		request.setAttribute("categories", categories);
		
		request.getRequestDispatcher("/admin_category.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/jsp,charset=utf-8");
		String title  = request.getParameter("title");
		if(title==null || "".equals(title)) {
		
			request.setAttribute("error", "分类名称不能为空");
			doGet(request, response);
			return;
		}
		
		CategoryDao categoryDao = new CategoryDao();
		
        boolean isExists = categoryDao.exists(title);
		
		if(isExists)
		{
			request.setAttribute("error", "分类名称不能重复");
			doGet(request, response);
			return;
		}
		categoryDao.addCategory(title);

		
		doGet(request, response);
	}

}
