package tzc.blog.controller;


import tzc.blog.dao.CategoryDao;
import tzc.blog.dao.PostDao;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "AdminPostController", value = "/admin/Post")
public class AdminPostController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/jsp,charset=utf-8");

        request.getRequestDispatcher("/admin_post.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/jsp,charset=utf-8");

        String category = request.getParameter("category");
        String title = request.getParameter("title");
        String postcontext = request.getParameter("postcontext");

        if(category.equals("") || title.equals("") || postcontext.equals("") ){
            request.setAttribute("error1","还有数据未输入");
            doGet(request, response);
        }
        else {
            CategoryDao ca = new CategoryDao();
            int categoryid = ca.exists2(category);
            PostDao pa = new PostDao();
            if(categoryid != -1){
                pa.addPost(title,postcontext,categoryid);
            }
            else {
                request.setAttribute("error1","没有这个分类");
                doGet(request, response);
            }
        }
        doGet(request, response);
    }
}
