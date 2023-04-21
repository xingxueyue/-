package tzc.blog.controller;

import tzc.blog.bean.Post;
import tzc.blog.dao.PostDao;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "AdminPostMangerController", value = "/admin/PostManger")
public class AdminPostMangerController extends HttpServlet {
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

        String title = request.getParameter("title");
        if(null!=title && title.equals("")){
            request.setAttribute("error","文章名称不能为空");
            doGet(request, response);
        }
        else{
            PostDao pd = new PostDao();
            List<Post> posts = pd.gettitle(title);
            if(posts!=null && !posts.isEmpty()){
                request.setAttribute("posts",posts);
                request.getRequestDispatcher("/admin_post_manger.jsp").forward(request,response);
            }
            else{
                request.setAttribute("error","没有找到相似的文章");
                doGet(request, response);
            }
        }
    }
}
