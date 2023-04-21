package tzc.blog.controller;

import tzc.blog.bean.Post;
import tzc.blog.dao.PostDao;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "AdminRePostEditController", value = "/admin/RePostEdit")
public class AdminRePostEditController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/jsp,charset=utf-8");

        PostDao pd = new PostDao();
        List<Post> posts = pd.getAll();
        request.setAttribute("posts",posts);

        request.getRequestDispatcher("/admin_post_manger.jsp").forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/jsp,charset=utf-8");

        int id = Integer.parseInt(request.getParameter("id"));
        String title = request.getParameter("title");
        String context = request.getParameter("postcontext");
        PostDao pd = new PostDao();

        if("".equals(title)|| "".equals(context)){
            Post post = pd.getidPost(id);
            request.setAttribute("post",post);
            request.setAttribute("error","还有数据没输入");
            request.getRequestDispatcher("/admin_post_edit.jsp").forward(request,response);
        }
        else{
            pd.edit(id,title,context);
            doGet(request, response);
        }

    }
}
