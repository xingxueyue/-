package tzc.blog.dao;

import tzc.bilog.utils.DBUtils;
import tzc.blog.bean.Reply;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ReplyDao {

    public void addReply(String username,String content,int mobile){
        Connection conn = DBUtils.getConnection();

        try{
            PreparedStatement stat = conn.prepareStatement("insert into reply(username,content,mobile,create_at) value (?,?,?,?)");
            stat.setString(1,username);
            stat.setString(2,content);
            stat.setInt(3,mobile);
            stat.setTimestamp(4,new Timestamp(new Date().getTime()));
            stat.execute();
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            DBUtils.closeQuietly(conn);
        }
    }


    public List<Reply> getpostidReply(int postid) {
        Connection conn = DBUtils.getConnection();

        List<Reply> replies = new ArrayList<Reply>();
        try {
            PreparedStatement stat = conn.prepareStatement("select * from reply where mobile=?");
            stat.setInt(1, postid);
            ResultSet rs = stat.executeQuery();
            while (rs.next()) {
                Reply reply = new Reply();
                reply.setId(rs.getInt("id"));
                reply.setContent(rs.getString("content"));
                reply.setUsername(rs.getString("username"));
                reply.setMobile(rs.getInt("mobile"));
                reply.setCreat_at(new Date(rs.getTimestamp("create_at").getTime()));
                replies.add(reply);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtils.closeQuietly(conn);
        }
        return replies;
    }


    public void delete(int postid){
        Connection conn =  DBUtils.getConnection();

        try {
            PreparedStatement stat = conn.prepareStatement("delete from reply where mobile=? ");
            stat.setInt(1,postid);
            stat.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }finally
        {
            DBUtils.closeQuietly(conn);

        }
    }
}
