
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<%@ page import= "java.util.*,tzc.blog.bean.*"  %>
<%String base= request.getContextPath() + "/"; %>
<!DOCTYPE html>
<html>

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title>博客管理后台 | Dashboard v.2</title>

    <link href="<%=base %>css/bootstrap.min.css" rel="stylesheet">
    <link href="<%=base %>font-awesome/css/font-awesome.css" rel="stylesheet">

    <link href="<%=base %>css/animate.css" rel="stylesheet">
    <link href="<%=base %>css/style.css" rel="stylesheet">

</head>

<body>
<div id="wrapper">
    <nav class="navbar-default navbar-static-side" role="navigation">
        <div class="sidebar-collapse">
            <ul class="nav metismenu" id="side-menu">
                <li class="nav-header">
                    <div class="dropdown profile-element"> <span>
                            <img height ="48px" width="48px" alt="image" class="img-circle" src="<%=base %>img/hs.jpg" />
                             </span>
                        <a data-toggle="dropdown" class="dropdown-toggle" href="dashboard_2.html#">
                            <span class="clear"> <span class="block m-t-xs"> <strong class="font-bold">刘文韬</strong>
                             </span> </span> </a>

                    </div>
                    <div class="logo-element">
                        IN+
                    </div>
                <li>
                    <a href="<%=base%>/admin/Home"><i class="fa fa-diamond"></i> <span class="nav-label">首页</span></a>
                </li>
                <li>
                    <a href="<%=base%>/admin/Category"><i class="fa fa-pie-chart"></i> <span class="nav-label">分类管理</span>  </a>
                </li>
                <li>
                    <a href="<%=base%>/admin/Post"><i class="fa fa-flask"></i> <span class="nav-label">文章管理</span></a>
                </li>

            </ul>

        </div>
    </nav>

    <div id="page-wrapper" class="gray-bg">
        <div class="row border-bottom">
            <nav class="navbar navbar-static-top white-bg" role="navigation" style="margin-bottom: 0">
                <div class="navbar-header">
                    <a class="navbar-minimalize minimalize-styl-2 btn btn-primary " href="dashboard_2.html#"><i class="fa fa-bars"></i> </a>

                </div>
                <ul class="nav navbar-top-links navbar-right">
                    <li>
                        <span class="m-r-sm text-muted welcome-message">欢迎登陆博客管理后台</span>
                    </li>


                    <li>
                        <a href="<%=base %>Login">
                            <i class="fa fa-sign-out"></i> Log out
                        </a>
                    </li>

                </ul>

            </nav>
        </div>
        <div class="wrapper wrapper-content">
            <div class="row">
                <div class="col-lg-12">
                    <div class="wrapper wrapper-content animated fadeInRight">
                        <form action ="<%=base %>admin/Post" method ="post">
                            <div class="ibox-content m-b-sm border-bottom">
                                <div class="text-center p-lg">

                                    <div class="form-group">

                                        <div class="col-sm-10">
                                            <div class="row">
                                                <div>
                                                    <div class="col-md-4"><input name="category" type="text" placeholder="分类名称" class="form-control"></div>
                                                    <div class="col-md-3"><button title="Create new cluster" class="btn btn-primary btn-sm"><i class="fa fa-edit"></i> <span class="bold">增加文章</span></button></div>
                                                    <%String error1 = (String) request.getAttribute("error1");
                                                        if (error1!=null && !"".equals(error1)){%>
                                                    <div style="color:red" class="col-md-3"><%=error1 %></div>
                                                    <%}%>

                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div>
                                    <div class="col-md-4"><input name="title" type="text" placeholder="文章标题名" class="form-control"></div>
                                    <div class="col-md-2"><a href="<%=base %>/admin/PostManger"><span>文章列表</span> </a></div>
                                    <textarea style="width: 100%; height: 200px;margin-top: 20px" placeholder="请文章输入内容" name="postcontext"></textarea>
                                </div>
                            </div>
                        </form>


                        <form action ="<%=base %>admin/AddReply" method ="post">
                            <div class="ibox-content m-b-sm border-bottom">
                                <div class="text-center p-lg">

                                    <div class="form-group">

                                        <div class="col-sm-10">
                                            <div class="row">
                                                <div>
                                                    <div class="col-md-4"><input name="username" type="text" placeholder="评论者名" class="form-control"></div>

                                                    <div class="col-md-3"><button title="Create new cluster" class="btn btn-primary btn-sm"><i class="fa fa-edit"></i> <span class="bold">增加评论</span></button></div>
                                                    <% String error2 = (String) request.getAttribute("error2");
                                                        if (error2!=null && !"".equals(error2)){%>
                                                    <div style="color:red" class="col-md-3"><%=error2 %></div>
                                                    <%}%>

                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div>
                                    <div class="col-md-4">
                                        <input name="postname" type="text" placeholder="哪篇文章的评论" class="form-control">
                                    </div>

                                    <textarea style="width: 100%; height: 200px;margin-top: 20px" placeholder="请输入评论内容" name="replycontent"></textarea>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>

            </div>
        </div>
        <div class="footer">
            <div class="pull-right">
                <%=new java.util.Date() %>
            </div>
            <div>
                <strong>Copyright</strong> TZC &copy; 2022-6-1
            </div>
        </div>
    </div>

</div>

<!-- Mainly scripts -->
<script src="<%=base %>js/jquery-2.1.1.js"></script>
<script src="<%=base %>js/bootstrap.min.js"></script>
<script src="<%=base %>js/plugins/metisMenu/jquery.metisMenu.js"></script>
<script src="<%=base %>js/plugins/slimscroll/jquery.slimscroll.min.js"></script>

<!-- Flot -->
<script src="<%=base %>js/plugins/flot/jquery.flot.js"></script>
<script src="<%=base %>js/plugins/flot/jquery.flot.tooltip.min.js"></script>
<script src="<%=base %>js/plugins/flot/jquery.flot.spline.js"></script>
<script src="<%=base %>js/plugins/flot/jquery.flot.resize.js"></script>
<script src="<%=base %>js/plugins/flot/jquery.flot.pie.js"></script>
<script src="<%=base %>js/plugins/flot/jquery.flot.symbol.js"></script>
<script src="<%=base %>js/plugins/flot/jquery.flot.time.js"></script>

<!-- Peity -->
<script src="<%=base %>js/plugins/peity/jquery.peity.min.js"></script>
<script src="<%=base %>js/demo/peity-demo.js"></script>

<!-- Custom and plugin javascript -->
<script src="<%=base %>js/inspinia.js"></script>
<script src="<%=base %>js/plugins/pace/pace.min.js"></script>

<!-- jQuery UI -->
<script src="<%=base %>js/plugins/jquery-ui/jquery-ui.min.js"></script>

<!-- Jvectormap -->
<script src="<%=base %>js/plugins/jvectormap/jquery-jvectormap-2.0.2.min.js"></script>
<script src="<%=base %>js/plugins/jvectormap/jquery-jvectormap-world-mill-en.js"></script>

<!-- EayPIE -->
<script src="<%=base %>js/plugins/easypiechart/jquery.easypiechart.js"></script>

<!-- Sparkline -->
<script src="<%=base %>js/plugins/sparkline/jquery.sparkline.min.js"></script>

<!-- Sparkline demo data  -->
<script src="<%=base %>js/demo/sparkline-demo.js"></script>


</body>
</html>
    