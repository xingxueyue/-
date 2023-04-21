package tzc.blog.controller;

import tzc.blog.bean.Post;
import tzc.blog.dao.PostDao;
import tzc.blog.dao.ReplyDao;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "AdminPostEditController", value = "/admin/PostEdit")
public class AdminPostEditController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/jsp,charset=utf-8");
        int id = Integer.parseInt(request.getParameter("id"));
        PostDao pd = new PostDao();
        Post post = pd.getidPost(id);
        request.setAttribute("post",post);
        request.getRequestDispatcher("/admin_post_edit.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/jsp,charset=utf-8");

        String action = request.getParameter("action");
        int id = Integer.parseInt(request.getParameter("id"));
        if("edit".equals(action)){
            doGet(request, response);
        }
        else if("delete".equals(action)) {
            PostDao pd = new PostDao();
            pd.delete(id);
            ReplyDao rd = new ReplyDao();
            rd.delete(id);
            List<Post> posts = pd.getAll();
            request.setAttribute("posts",posts);
            request.getRequestDispatcher("/admin_post_manger.jsp").forward(request,response);
        }
        doGet(request, response);
    }
}
