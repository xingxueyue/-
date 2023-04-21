package tzc.blog.controller;

import tzc.blog.dao.PostDao;
import tzc.blog.dao.ReplyDao;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "AdminAddReplyController", value = "/admin/AddReply")
public class AdminAddReplyController extends HttpServlet {
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

        String username = request.getParameter("username");
        String postname = request.getParameter("postname");
        String replycontent = request.getParameter("replycontent");

        if("".equals(username)||"".equals(postname)||"".equals(replycontent)){
            request.setAttribute("error2","还有空未输入");
            doGet(request, response);
        }
        else{
            PostDao pd = new PostDao();
            int postid = pd.exists(postname);
            if(postid == -1){
                request.setAttribute("error2","未查到该文章");
                doGet(request, response);
            }
            else {
                ReplyDao rd = new ReplyDao();
                rd.addReply(username,replycontent,postid);
                doGet(request, response);
            }
        }
    }
}
