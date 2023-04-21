package tzc.blog.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tzc.blog.bean.Category;
import tzc.blog.dao.CategoryDao;

/**
 * Servlet implementation class AdminCategoryEditController
 */
public class AdminCategoryEditController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminCategoryEditController() {
        super();
       
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/jsp,charset=utf-8");
		String idString = request.getParameter("id");
		int id = Integer.parseInt(idString);
		
		CategoryDao categoryDao = new CategoryDao();
		
		Category  category   = categoryDao.get(id);
		request.setAttribute("category", category);
		
		request.getRequestDispatcher("/admin_category_edit.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/jsp,charset=utf-8");
		String action = request.getParameter("action");
		String title = request.getParameter("title");
		int id = Integer.parseInt(request.getParameter("id"));
		CategoryDao categoryDao = new CategoryDao();

        if("edit".equals(action)) {
		if(title==null || "".equals(title)) {
			request.setAttribute("error", "分类名称不能为空");
			doGet(request, response);
			return;
		}
		
        boolean isExists = categoryDao.exists(title);
		
		if(isExists)
		{
			request.setAttribute("error", "分类名称不能重复");
			doGet(request, response);
			return;
		}
		
		categoryDao.edit(id,title);
		
        }else if ("delete".equals(action)){
        	categoryDao.delete(id);
        } else {
			categoryDao.edit(id,title);
		}
		response.sendRedirect(request.getContextPath() + "/admin/Category");
		
	}

}
