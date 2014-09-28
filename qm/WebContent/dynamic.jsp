<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="com.xtu.qm.pojo.*" %>
<%@ page import="com.xtu.qm.utils.*" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
AccountInfo account = (AccountInfo) session.getAttribute("AccountInfo");
UserInfo user = account.getUserinfo();
int offset = 0;

List<NewsInformation> list = (ArrayList<NewsInformation>) request.getAttribute("DynamicSet");
if (list == null) {
	list = new ArrayList<NewsInformation>();
}
%>

<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>动态页面</title>
<link rel="stylesheet" type="text/css" href="css/pintuer.css" />
<link rel="stylesheet" type="text/css" href="css/NewIndex.css" />
</head>

<body>
	<div class="container radius-none" >
     	 	<!--导航栏-->
            <div id="nav_fixed" style="height:40px">
        	<button class="button icon-navicon margin-small-bottom" data-target="#nav-bg1"></button>
			<div class="bg-sub bg-inverse  nav-navicon text-big " id="nav-bg1">
			  <ul class="nav nav-inline nav-menu  clearfix ">
                  <li class="nav-head text-large float-left">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;青檬&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</li>
                  <li class="active float-left"><a href="DynamicShowServlet"><span class="icon-comments-o"></span>&nbsp;动态</a></li>
                  <li class="float-left"><a href="#"><span class="icon-group (alias)"></span>&nbsp;一起</a></li>
                  <li class="float-left"><a href="#"><span class="icon-search"></span>&nbsp;发现</a></li>
                  <li class="float-left"><a href="#"><span class="icon-list-ul"></span>&nbsp;应用<span class="arrow"></span></a>
                    <ul class="drop-menu">
                      <li><a href="#"><span class="icon-envelope-o"></span>&nbsp;桃花信</a></li>
                      <li><a href="#"><span class="icon-rmb (alias)"></span>&nbsp;&nbsp;跳蚤市场</a></li>
                      <li><a href="#"><span class="icon-dribbble"></span>&nbsp;校园活动</a></li> 
                      <li><a href="#"><span class="icon-compass"></span>&nbsp;失物招领</a></li>
                      <li><a href="#"><span class="icon-bullhorn"></span>&nbsp;重要资讯</a></li>
                      <li><a href="#"><span class="icon-file-text-o"></span>&nbsp;成绩查询</a></li> 
                    </ul>
                  </li> 
                  <a id="nav_space"></a>
                  <li class="nav-more"><a href="#"><span class="icon-trophy"></span></a>
                  	<ul class="drop-menu"><li><a href="#">获取高级功能，<br />点亮荣誉勋章。<br />仅需10秒，<br />免费开通会员！</a></li></ul>
                  </li>
                  <li class="nav-more"><a href="#"><span class="icon-gear (alias)"></span></a>
                  	<ul class="drop-menu text-default">
                      <li><a href="setting.jsp">个人设置</a></li>
                      <li><a href="#">我的二维码</a></li>
                      <li><a href="#">关于我们</a></li>
                      <li><a href="#">退出登录</a></li>
                    </ul>
                  </li>
                  <li class="nav-more" ><a class="text-default" href="#"><img src="<%=user.getUserLogo().getSmallimageUrl() %>" width="30"> <%= account.getUsername() %></a></li>
			  </ul>
		    </div> 
            </div>
            <!--背景封面图-->
            <div id="header_bg" ></div>
            <!--40px空白--> 
             		<br/><br/><br/> 
            <!--消息提醒-->
            <div class="button bg-sub badge-corner float-right margin-large-right ">新消息<span class="badge bg-red">8</span></div>
            			 
            <!--颜色-->
            <div class="main_color">
            	<!--宽度-->
            	<div class="main_width">
                	<!--右边布局-->
                    <div class="layout_right border bg-white padding" style="margin-top:100px;">
                    	<button class="button icon-navicon" data-target="#nav-tabs1"></button> 
                            <ul class="nav nav-tabs nav-navicon" id="nav-tabs1">
                              <li class="active"><a class="text-sub" href="#">校园广场</a></li> 
                              <li><a href="#">已关注</a></li>
                              <li><a href="#">热门</a></li> 
                            </ul>
                    </div>
                    <!--左边布局--> 
						<!--发表栏-->
                        <div id="publish" class="layout_left bg-white padding radius border border-sub" style="margin-top:100px;"> 
                        	<form method="post" action="PublishServlet">
                              <textarea name="dynamicMsg" rows="4" class="input" placeholder="大笔一挥，留下您的精彩动态..."></textarea>
                              <button class="button bg-green padding-big-left padding-big-right float-right margin-top text-big"><span class="icon-paper-plane-o"></span>&nbsp;发表</button>
                            </form>
                                  <div class="button-group  margin-top">
                                    <button type="button" class="button button-small border-blue icon-smile-o text-blue text-default"> 表情</button>
                                    <button type="button" class="button button-small border-green icon-image (alias) text-green text-default"> 图片</button>
                                    	  
                                    <button type="button" class="button button-small border-yellow icon-file-image-o text-yellow text-default"> 趣味图</button> 
                                    <button type="button" class="button button-small border-red icon-film text-red text-default"> 视频</button>
                                    <button type="button" class="button button-small border-blue icon-user text-blue text-default"> 艾特</button>
                                    <button type="button" class="button button-small border-green icon-edit (alias) text-green text-default"> 高级动态</button>
                                  </div>
                        </div>
                        <% for (NewsInformation dynamic: list) {
                        	offset++;
                        	
                        	AccountInfo dynamicAccount = dynamic.getAuthor();
                        	UserInfo dynamicUser = dynamicAccount.getUserinfo();
                        	
                        	// 计算时间
                        	String date = ToStringUtil.dateToString(dynamic.getReleasetime());
                        	// 详情页<div> ID 号码
                        	String detail = "detail" + dynamic.getId();
                        	// 输入评论框ID
                        	String commentInput = "commentInput" + dynamic.getId(); 
                        	// 评论列表
                        	List<NewsInformation> commentList = dynamic.getResponse();
                        %>
                        <!--动态-->
                        <div class="layout_left bg-white padding radius border border-sub margin-top relactive " >		
                        	<!--头条字样--> 
                            <button class=" button-small float-right button bg-red hidden ">今日头条</button>
                        	<img class="img-border radius float-left point" width="60" src="<%=dynamicUser.getUserLogo().getSmallimageUrl() %>" />
                            <a class="margin-left text-big" style="top:0px;" href="#"><%=dynamicAccount.getUsername() %></a>
                            <br />
                            <label class="height-big margin-left text-small text-main">
                            	<%=date %>
                            </label>
                            <label class="text-small margin-left text-main">阅读(<%=dynamic.getReadnumber() %>)</label>
                            <!--内容部分-->
                            <div class="dynamic_content bg-white padding radius border " >
                            	<label><%=dynamic.getContent() %></label><br />
                            	<%
                            		// 如果动态包含图片
                            		List<UserImage> images = dynamic.getUserimage();
                            		if (images != null && images.size() != 0) {
                            	%>
                            	<div class="border form-inline"  >
                                	<img class="dynamic_img_small" src="videos.png">	
                                </div>
                            	<div class="border form-inline margin-small-left margin-small-right margin-small-top" >		
                                	<img class="dynamic_img_small" src="20140831054308926_easyicon_net_1067.png">
                                </div>
                            	<div class="border form-inline" >		
                                	<img class="dynamic_img_small" src="aaa.png">
                                </div>
                                <%
                            		}
                                %>
                            </div>
                            <!--操作部分-->
                            <div class="button-group margin-top dynamic_btn_group">
                                    <a class="text-blue point margin-big-right"><span class="icon-thumbs-o-up margin-small-right"></span>赞3(7)</a>
                                    <a onClick="show_comment('<%=detail %>')" class="text-green point margin-big-right"><span class="icon-pencil-square-o margin-small-right"></span>评论(<%=commentList.size()%>)</a>
                                    <a class="text-yellow point margin-big-right"><span class="icon-file-image-o margin-small-right"></span>关注Ta</a>
                                    <a onMouseOver="document.getElementById('yincang5').style.display = 'block'" onMouseOut="document.getElementById('yincang5').style.display = 'none'" class="text-red point margin-big-right"><span class="icon-ellipsis-v margin-small-right"></span>其他<span class="arrow"></span></a>
                                    <div id="yincang5"  onMouseOver="document.getElementById('yincang5').style.display = 'block'" onMouseOut="document.getElementById('yincang5').style.display = 'none'" style=" display:none; background-color:#FFF; border:1px solid #CCC; z-index:200; position:absolute; right:10px; text-align:center; width:100px;">
                                        <ul style="list-style-type:none; margin-left:-30px; padding-right:10px; " >
                                          <li>分享</li>
                                          <li>喜欢Ta</li>
                                          <li>备注</li>
                                          <li>关注Ta</li>
                                          <li>屏蔽Ta</li>
                                          <li>举报</li>
                                        </ul>
                                   </div>
                            </div>
                            <div style="height:30px;"></div>
                            <!--评论详情页-->
                            <div id="<%=detail %>" class="divComment dynamic_content margin-top border" style="display:none">
                                <!--快速评论栏-->
                                <div class="form-group margin-small-left margin-top margin-right">
                                    <div class="field">
                                    <!-- 应该是异步更新的，这里暂时是form形式 -->
                                    	<form action="PostCommentServlet" method="post">
                                      		<div class="input-group">
                                      			<input type="hidden" name="commentId" value="<%=dynamic.getId() %>">
                                      			<input type="hidden" name="actionType" value="postDynamicComment">
                                      			<span class="addbtn"></span><input id="<%=commentInput %>" type="text" class="input input-small" name="commentContent" size="50" placeholder="写下评论，给楼主动力吧！" /><span class="addbtn"><button type="submit" class="button button-small" style="height:28px;">评论</button></span></div>
                                      	</form>
                                    </div>
                               </div>
                               <!--评论列表-->
                               <div class="margin-left">
                               	 	<label onClick="show_pinglunliebiao('<%="commentList" + dynamic.getId() %>', '<%="zanList" + dynamic.getId() %>')" class="margin-big-left text-blue point">评论</label>
                               	 	<label onClick="show_dianzanliebiao('<%="commentList" + dynamic.getId() %>', '<%="zanList" + dynamic.getId() %>')" class="margin-big-left text-main point">点赞榜</label><br>
                                      	<!--评论列表-->
                                        <div id="<%="commentList" + dynamic.getId() %>">
                                        	<%
                               					for (NewsInformation comment: commentList) {
                               						AccountInfo commentAccount = comment.getAuthor();
                               						// 计算时间
                               						String commentDate = ToStringUtil.dateToString(comment.getReleasetime());
                               				%>
                                            <!-- 一条评论 -->
                                            <div id="<%="comment" + dynamic.getId() %>" class="margin-top">
                                                <table width="100%" border="0">
                                                    <tbody><tr>
                                                        <td valign="top" width="40px"><img class="margin-right" src="<%=account.getUserinfo().getUserLogo().getSmallimageUrl() %>" style="width:40px; cursor:pointer;"></td>
                                                        <td valign="top">
                                                            <a style="cursor:pointer;color:#F37021"><%=commentAccount.getUsername() %></a>:
                                                            <label><%=comment.getContent() %></label>					<br>
                                                            <label class="text-main text-small" style=" vertical-align:middle;  line-height:18px;"><%=commentDate %></label>
                                                            <img onclick="" src="image/comment.png" style="width:18px;  cursor:pointer; position:absolute; margin-left:10px; margin-top:3px;">			                                                            
                                                        </td>
                                                    </tr>
                                                </tbody></table>
                                            </div>
                                            <%
                               					}
                                            %>
                                        </div>
                                        <!--点赞列表-->
                                        <div id="<%="zanList" + dynamic.getId() %>" style="display:none">
                                        	<div class="margin-top margin-bottom">
                                                <table width="100%" border="0">
                                                    <tbody>
                                                    <tr>
                                                        <td valign="top" width="40px"><img class="margin-right" src="u=2107292801,3797874346&amp;fm=58.jpg" style="width:40px; cursor:pointer;"></td>
                                                        <td >
                                                            <a style="cursor:pointer;color:#F37021">范冰冰</a>:
                                                            <label>给了12个赞</label>					
                                                            <img src="评论-ok.png" style="width:18px;  cursor:pointer; position:absolute; margin-left:10px; margin-top:3px;">			
                                                        </td>
                                                    </tr>
                                                </tbody></table>
                                            </div>
                                        	<div class="margin-top margin-bottom">
                                                <table width="100%" border="0">
                                                    <tbody>
                                                    <tr>
                                                        <td valign="top" width="40px"><img class="margin-right" src="u=2107292801,3797874346&amp;fm=58.jpg" style="width:40px; cursor:pointer;"></td>
                                                        <td >
                                                            <a style="cursor:pointer;color:#F37021">刘亦菲</a>:
                                                            <label>给了7个赞</label>					
                                                            <img src="评论-ok.png" style="width:18px;  cursor:pointer; position:absolute; margin-left:10px; margin-top:3px;">			
                                                        </td>
                                                    </tr>
                                                </tbody></table>
                                            </div>
                                        	<div class="margin-top margin-bottom">
                                                <table width="100%" border="0">
                                                    <tbody>
                                                    <tr>
                                                        <td valign="top" width="40px"><img class="margin-right" src="u=2107292801,3797874346&amp;fm=58.jpg" style="width:40px; cursor:pointer;"></td>
                                                        <td >
                                                            <a style="cursor:pointer;color:#F37021">周杰伦</a>:
                                                            <label style="font-size:14px;">给了5个赞</label>					
                                                            <img src="评论-ok.png" style="width:18px;  cursor:pointer; position:absolute; margin-left:10px; margin-top:3px;">			
                                                        </td>
                                                    </tr>
                                                </tbody></table>
                                            </div>
                                        </div>
                               </div>
                            </div>
                        </div> 
                        <% } %>    
                        <!-- 空白div 用于异步更新  -->
                        <div id="empty"></div>      
                </div><!--main-width-->
            </div><!--main-color-->
	</div><!--！所有-->
	
<script> /*example里的切换js*/
	var dianzanbang_value = 1;
	function show_vedio () {
		document.getElementById('example_vedio').style.display = 'block';
		document.getElementById('example').style.display = 'none';
	}
	function show_gif () {
		document.getElementById('example_gif').style.display = 'block';
		document.getElementById('example').style.display = 'none';
	}
	function show_super () {
		document.getElementById('example_super').style.display = 'block';
		document.getElementById('example').style.display = 'none';
	}
	function show_maincontent () {
		document.getElementById('example_vedio').style.display = 'none';
		document.getElementById('example').style.display = 'block';
		document.getElementById('example_gif').style.display = 'none';
		document.getElementById('example_super').style.display = 'none';
	}
	
	function show_comment (commentId) {
		if (document.getElementById(commentId).style.display == 'block')
			document.getElementById(commentId).style.display ='none';
		else 
			document.getElementById(commentId).style.display ='block';
	}
	
	function show_dianzanliebiao (commentListId, zanListId) {
			document.getElementById(zanListId).style.display ='block';
			document.getElementById(commentListId).style.display ='none';
	}
	
	function show_pinglunliebiao (commentListId, zanListId) {
			document.getElementById(zanListId).style.display ='none';
			document.getElementById(commentListId).style.display ='block';
	}
	
	function changeDetails(){   /*显示更多菜单*/
		if(document.getElementById('details').style.display=='none')
			document.getElementById('details').style.display='block';
		else
			document.getElementById('details').style.display='none';
	}
</script>
 
<script src="js/jquery-1.11.0.min.js" type="text/javascript"></script>
<script src="js/pintuer.js" type="text/javascript"></script>
<script src="js/jquery.qqFace.js" type="text/javascript"></script>
</body>
</html>

