package tzc.blog.controller;

import tzc.blog.bean.Post;
import tzc.blog.bean.Reply;
import tzc.blog.dao.PostDao;
import tzc.blog.dao.ReplyDao;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "AdminReplyController", value = "/admin/Reply")
public class AdminReplyController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/jsp,charset=utf-8");

        int postid = Integer.parseInt(request.getParameter("id"));
        PostDao pd = new PostDao();
        pd.addview_count(postid);
        Post post = pd.getidPost(postid);
        request.setAttribute("post",post);

        ReplyDao rd = new ReplyDao();
        List<Reply> replies = rd.getpostidReply(postid);
        request.setAttribute("replies",replies);

        request.getRequestDispatcher("/admin_reply.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/jsp,charset=utf-8");

        doGet(request, response);
    }
}
