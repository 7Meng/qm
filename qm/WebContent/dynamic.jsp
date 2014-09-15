<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="com.xtu.qm.pojo.*" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
AccountInfo account = (AccountInfo) session.getAttribute("AccountInfo");
UserInfo user = account.getUserinfo();
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
                  <li class="active float-left"><a href="#"><span class="icon-comments-o"></span>&nbsp;动态</a></li>
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
                      <li><a href="#">头像</a></li>
                      <li><a href="#">签名 生活照</a></li>
                      <li><a href="#">个人信息</a></li>
                      <li><a href="#">隐私设置</a></li>
                      <li><a href="#">其他设置</a></li>
                      <li><a href="#">实名认证</a></li>
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
                              <textarea rows="4" class="input" placeholder="大笔一挥，留下您的精彩动态..."></textarea>
                              <button class="button   bg-green padding-big-left padding-big-right float-right margin-top text-big"><span class="icon-paper-plane-o"></span>&nbsp;发表</button>
                                  <div class="button-group  margin-top">
                                    <button type="button" class="button button-small border-blue icon-smile-o text-blue text-default"> 表情</button>
                                    <button type="button" class="button button-small border-green icon-image (alias) text-green text-default"> 图片</button>
                                    	  
                                    <button type="button" class="button button-small border-yellow icon-file-image-o text-yellow text-default"> 趣味图</button> 
                                    <button type="button" class="button button-small border-red icon-film text-red text-default"> 视频</button>
                                    <button type="button" class="button button-small border-blue icon-user text-blue text-default"> 艾特</button>
                                    <button type="button" class="button button-small border-green icon-edit (alias) text-green text-default"> 高级动态</button>
                                  </div>
                        </div>
                        <!--今日头条--> 
                        <div class="layout_left bg-white padding radius border border-sub margin-top relactive  " >		
                        	<!--头条字样--> 
                            <button class=" button-small float-right button bg-red">今日头条</button>
                        	<img class="img-border radius float-left point" width="60" src="u=4179546593,3631561214&fm=58.jpg" />
                            <a class="margin-left text-big" style="top:0px;" href="#">Jay超级粉丝</a>
                            <br />
                            <label class="height-big margin-left text-small text-main">11:20</label><label class="text-small margin-left text-main">阅读(272)</label>
                            <!--内容部分-->
                            <div class="dynamic_content bg-white padding radius border " >
                            	<label>1.动态文字部分最多显示140个字，这是字数限制。2.不显示空格和回车。3.图片三个框限制大小（当图片为2张或3张时，每张长宽最大为150px）（若3张图片都是正方形，正好填满所有的空间）</label><br />
                            	<div class="border point form-inline"  >
                                	<img class="dynamic_img_small" src="head.jpg">	
                                </div>
                            	<div class="border point form-inline margin-small-left margin-small-right margin-small-top" >		
                                	<img class="dynamic_img_small" src="b24343c5a0f65dc4af2b03e74577d0030e9cce71185fc-gArxKw_fw320.jpg">
                                </div>
                            	<div class="borde pointr form-inline" >		
                                	<img class="dynamic_img_small" src="lifephoto.jpg">
                                </div>
                            </div> 
                            <!--操作部分-->
                            <div class="button-group margin-top dynamic_btn_group">
                                    <a class="text-blue point margin-big-right"><span class="icon-thumbs-o-up margin-small-right"></span>赞3(7)</a>
                                    <a class="text-green point margin-big-right"><span class="icon-pencil-square-o margin-small-right"></span>评论(4)</a>
                                    <a class="text-yellow point margin-big-right"><span class="icon-file-image-o margin-small-right"></span>关注Ta</a>
                                    <a onMouseOver="document.getElementById('yincang1').style.display = 'block'" onMouseOut="document.getElementById('yincang1').style.display = 'none'" class="text-red point margin-big-right"><span class="icon-ellipsis-v margin-small-right"></span>其他<span class="arrow"></span></a>
                                    <div id="yincang1"  onMouseOver="document.getElementById('yincang1').style.display = 'block'" onMouseOut="document.getElementById('yincang1').style.display = 'none'" style=" display:none; background-color:#FFF; border:1px solid #CCC; z-index:200; position:absolute; right:10px; text-align:center; width:100px;">
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
                        </div> 
                        <!--单一图片 高度-->
                        <div class="layout_left bg-white padding radius border border-sub margin-top relactive " >		
                        	<!--头条字样--> 
                            <button class=" button-small float-right button bg-red hidden ">今日头条</button>
                        	<img class="img-border radius float-left point" width="60" src="u=4179546593,3631561214&fm=58.jpg" />
                            <a class="margin-left text-big" style="top:0px;" href="#">Jay超级粉丝</a>
                            <br />
                            <label class="height-big margin-left text-small text-main">11:20</label><label class="text-small margin-left text-main">阅读(272)</label>
                            <!--内容部分-->
                            <div class="dynamic_content bg-white padding radius border " >
                            	<label>4.单一图片最高高度为220px</label><br />
                            	<div class="border point form-inline margin-small-top"  >
                                	<img class="dynamic_img_big" src="b24343c5a0f65dc4af2b03e74577d0030e9cce71185fc-gArxKw_fw320.jpg">	
                                </div> 
                            </div>
                            <!--操作部分-->
                            <div class="button-group margin-top dynamic_btn_group">
                                    <a class="text-blue point margin-big-right"><span class="icon-thumbs-o-up margin-small-right"></span>赞3(7)</a>
                                    <a class="text-green point margin-big-right"><span class="icon-pencil-square-o margin-small-right"></span>评论(4)</a>
                                    <a class="text-yellow point margin-big-right"><span class="icon-file-image-o margin-small-right"></span>关注Ta</a>
                                    <a onMouseOver="document.getElementById('yincang2').style.display = 'block'" onMouseOut="document.getElementById('yincang2').style.display = 'none'" class="text-red point margin-big-right"><span class="icon-ellipsis-v margin-small-right"></span>其他<span class="arrow"></span></a>
                                    <div id="yincang2"  onMouseOver="document.getElementById('yincang2').style.display = 'block'" onMouseOut="document.getElementById('yincang2').style.display = 'none'" style=" display:none; background-color:#FFF; border:1px solid #CCC; z-index:200; position:absolute; right:10px; text-align:center; width:100px;">
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
                        </div> 
                        <!--单一图片 宽度-->
                        <div class="layout_left bg-white padding radius border border-sub margin-top relactive " >		
                        	<!--头条字样--> 
                            <button class=" button-small float-right button bg-red hidden ">今日头条</button>
                        	<img class="img-border radius float-left point" width="60" src="u=4179546593,3631561214&fm=58.jpg" />
                            <a class="margin-left text-big" style="top:0px;" href="#">Jay超级粉丝</a>
                            <br />
                            <label class="height-big margin-left text-small text-main">11:20</label><label class="text-small margin-left text-main">阅读(272)</label>
                            <!--内容部分-->
                            <div class="dynamic_content bg-white padding radius border " >
                            	<label>5.单一图片最高宽度为父框架的330px</label><br />
                            	<div class="border point form-inline margin-small-top"  >
                                	<img class="dynamic_img_big" src="background.jpg">	
                                </div> 
                            </div>
                            <!--操作部分-->
                            <div class="button-group margin-top dynamic_btn_group">
                                    <a class="text-blue point margin-big-right"><span class="icon-thumbs-o-up margin-small-right"></span>赞3(7)</a>
                                    <a class="text-green point margin-big-right"><span class="icon-pencil-square-o margin-small-right"></span>评论(4)</a>
                                    <a class="text-yellow point margin-big-right"><span class="icon-file-image-o margin-small-right"></span>关注Ta</a>
                                    <a onMouseOver="document.getElementById('yincang3').style.display = 'block'" onMouseOut="document.getElementById('yincang3').style.display = 'none'" class="text-red point margin-big-right"><span class="icon-ellipsis-v margin-small-right"></span>其他<span class="arrow"></span></a>
                                    <div id="yincang3"  onMouseOver="document.getElementById('yincang3').style.display = 'block'" onMouseOut="document.getElementById('yincang3').style.display = 'none'" style=" display:none; background-color:#FFF; border:1px solid #CCC; z-index:200; position:absolute; right:10px; text-align:center; width:100px;">
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
                        </div> 
                        <!--单一图片 宽度-->
                        <div class="layout_left bg-white padding radius border border-sub margin-top relactive " >		
                        	<!--头条字样--> 
                            <button class=" button-small float-right button bg-red hidden ">今日头条</button>
                        	<img class="img-border radius float-left point" width="60" src="u=4179546593,3631561214&fm=58.jpg" />
                            <a class="margin-left text-big" style="top:0px;" href="#">Jay超级粉丝</a>
                            <br />
                            <label class="height-big margin-left text-small text-main">11:20</label><label class="text-small margin-left text-main">阅读(272)</label>
                            <!--内容部分-->
                            <div class="dynamic_content bg-white padding radius border " >
                            	<label>6.如果已是关注的人，则隐藏关注按钮。7.自己赞的次数在前面，括号里是总的赞次数。8.评论不显示自己评论了多少次</label><br />
                            	<div class="border point form-inline margin-small-top"  >
                                	<img class="dynamic_img_big" src="b24343c5a0f65dc4af2b03e74577d0030e9cce71185fc-gArxKw_fw320.jpg">	
                                </div> 
                            </div>
                            <!--操作部分-->
                            <div class="button-group margin-top dynamic_btn_group">
                                    <a class="text-blue point margin-big-right"><span class="icon-thumbs-o-up margin-small-right"></span>赞3(7)</a>
                                    <a class="text-green point margin-big-right"><span class="icon-pencil-square-o margin-small-right"></span>评论(4)</a>
                                    <a class="text-yellow point margin-big-right"><span class="icon-file-image-o margin-small-right"></span>关注Ta</a>
                                    <a onMouseOver="document.getElementById('yincang4').style.display = 'block'" onMouseOut="document.getElementById('yincang4').style.display = 'none'" class="text-red point margin-big-right"><span class="icon-ellipsis-v margin-small-right"></span>其他<span class="arrow"></span></a>
                                    <div id="yincang4"  onMouseOver="document.getElementById('yincang4').style.display = 'block'" onMouseOut="document.getElementById('yincang4').style.display = 'none'" style=" display:none; background-color:#FFF; border:1px solid #CCC; z-index:200; position:absolute; right:10px; text-align:center; width:100px;">
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
                        </div> 
                        <!--视频、动态图和高级动态-->
                        <div class="layout_left bg-white padding radius border border-sub margin-top relactive " >		
                        	<!--头条字样--> 
                            <button class=" button-small float-right button bg-red hidden ">今日头条</button>
                        	<img class="img-border radius float-left point" width="60" src="u=4179546593,3631561214&fm=58.jpg" />
                            <a class="margin-left text-big" style="top:0px;" href="#">Jay超级粉丝</a>
                            <br />
                            <label class="height-big margin-left text-small text-main">11:20</label><label class="text-small margin-left text-main">阅读(272)</label>
                            <!--内容部分-->
                            <div class="dynamic_content bg-white padding radius border " >
                            	<label>9.视频、动态图、高级动态都占一个格子，至多有一个视频，至多有一个高级动态，至多有三个动态图。</label><br />
                            	<div class="border form-inline"  >
                                	<img class="dynamic_img_small" src="videos.png">	
                                </div>
                            	<div class="border form-inline margin-small-left margin-small-right margin-small-top" >		
                                	<img class="dynamic_img_small" src="20140831054308926_easyicon_net_1067.png">
                                </div>
                            	<div class="border form-inline" >		
                                	<img class="dynamic_img_small" src="aaa.png">
                                </div>
                            </div>
                            <!--操作部分-->
                            <div class="button-group margin-top dynamic_btn_group">
                                    <a class="text-blue point margin-big-right"><span class="icon-thumbs-o-up margin-small-right"></span>赞3(7)</a>
                                    <a class="text-green point margin-big-right"><span class="icon-pencil-square-o margin-small-right"></span>评论(4)</a>
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
                        </div> 
                        <!--查看详情示例-->
                        <div class="layout_left bg-white padding radius border border-sub margin-top relactive " >		
                            <!--头条字样--> 
                            <button class=" button-small float-right button bg-red hidden ">今日头条</button>
                            <img class="img-border radius float-left point" width="60" src="u=4179546593,3631561214&fm=58.jpg" />
                            <a class="margin-left text-big" style="top:0px;" href="#">Jay超级粉丝</a>
                            <br />
                            <label class="height-big margin-left text-small text-main">11:20</label><label class="text-small margin-left text-main">阅读(272)</label>
                            <!--内容部分-->
                            <div id="example" class="dynamic_content bg-white padding radius border " >
                                <label>10.点击本条动态里的图标查看。（本div里的id名为临时设置的）</label><br />
                                <div class="border form-inline point"  >
                                    <img onClick="show_vedio()" class="dynamic_img_small" src="videos.png">	
                                </div>
                                <div onClick="show_gif()" class="border point form-inline margin-small-left margin-small-right margin-small-top" >		
                                    <img class="dynamic_img_small" src="20140831054308926_easyicon_net_1067.png">
                                </div>
                                <div onClick="show_super()" class="border point form-inline" >		
                                    <img class="dynamic_img_small" src="aaa.png">
                                </div>
                            </div>
                            <!--内容的详情部分 视频-->
                            <div id="example_vedio" class="dynamic_content border bg-white padding radius" style="display:none">
                                <label>10.点击本 图标查看。（本div里的id名为临时设置的）</label><br />		
                                <a class="text-sub point" onClick="show_maincontent()" ><span class="icon-arrow-up margin-small-right margin-left"></span>收起</a>
                                <embed class="margin-small-top border" src="http://player.youku.com/player.php/sid/XNzY0OTE2MzQ4/v.swf" allowFullScreen="true" quality="high" width="484" height="400" align="middle" allowScriptAccess="always" type="application/x-shockwave-flash"></embed>
                            </div>
                            <!--内容的详情部分 动图-->
                            <div id="example_gif" class="dynamic_content border bg-white padding radius" style="display:none">
                                <label>10.点击本条动态里的图标查看。（本div里的id名为临时设置的）</label><br />		
                                <a class="text-sub point" onClick="show_maincontent()" ><span class="icon-arrow-up margin-small-right margin-left"></span>收起</a>
                                <div class="border padding"><img onClick="show_maincontent()"  class="point dynamic_img_maincontent" src="b24343c5a0f65dc4af2b03e74577d0030e9cce71185fc-gArxKw_fw320.jpg" />
                                </div>
                            </div>
                            <!--内容的详情部分 高级动态-->
                            <div id="example_super" class="dynamic_content border bg-white padding radius" style="display:none">
                                <label>10.点击本条动态里的图标查看。（本div里的id名为临时设置的）</label><br />		
                                <a class="text-sub point" onClick="show_maincontent()" ><span class="icon-arrow-up margin-small-right margin-left"></span>收起</a>
                                <div class="border padding dynamic_div_super"  ><h1 class="text-center">今日新闻</h1><p>据新华社最新新闻，美国纽约遭遇大规模恐怖袭击，目前伤亡情况不详啊呀呀呀呀.</p><img width="464px" src="background.jpg"/></div>
                            </div>
                            <!--操作部分-->
                            <div class="button-group margin-top dynamic_btn_group">
                                    <a class="text-blue point margin-big-right"><span class="icon-thumbs-o-up margin-small-right"></span>赞3(7)</a>
                                    <a onClick="show_comment()" class="text-green point margin-big-right"><span class="icon-pencil-square-o margin-small-right"></span>评论(4)</a>
                                    <a class="text-yellow point margin-big-right"><span class="icon-file-image-o margin-small-right"></span>关注Ta</a>
                                    <a onMouseOver="document.getElementById('yincang6').style.display = 'block'" onMouseOut="document.getElementById('yincang6').style.display = 'none'" class="text-red point margin-big-right"><span class="icon-ellipsis-v margin-small-right"></span>其他<span class="arrow"></span></a>
                                    <div id="yincang6"  onMouseOver="document.getElementById('yincang6').style.display = 'block'" onMouseOut="document.getElementById('yincang6').style.display = 'none'" style=" display:none; background-color:#FFF; border:1px solid #CCC; z-index:200; position:absolute; right:10px; text-align:center; width:100px;">
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
                            <div id="example_comment" class="divComment dynamic_content margin-top border" style="display:none">
                                <!--快速评论栏-->
                                <div class="form-group margin-small-left margin-top margin-right">
                                    <div class="field">
                                      <div class="input-group"><span class="addbtn"></span><input type="text" class="input input-small" name="keywords" size="50" placeholder="写下评论，给楼主动力吧！" /><span class="addbtn"><button type="button" class="button button-small" style="height:28px;">评论</button></span></div>
                                    </div>
                               </div>
                               <!--评论列表-->
                               <div class="margin-left">
                               	 	<label onClick="show_pinglunliebiao()" class="margin-big-left point">评论</label><label onClick="show_dianzanliebiao()" class="margin-big-left text-main point">点赞榜</label><br>
                                      	<!--评论列表-->
                                        <div id="pinglun_list">
                                            <!--第1条评论-->
                                            <div class="margin-top">
                                                <table width="100%" border="0">
                                                    <tbody><tr>
                                                        <td valign="top" width="40px"><img class="margin-right" src="u=2107292801,3797874346&amp;fm=58.jpg" style="width:40px; cursor:pointer;"></td>
                                                        <td valign="top">
                                                            <a style="cursor:pointer;color:#F37021">范冰冰</a>:
                                                            <label>哈哈哈哈……你今天的经历太有趣了，我和我的室友都笑死了……</label>					<br>
                                                            <label class="text-main text-small" style=" vertical-align:middle;  line-height:18px;">5分钟前</label>
                                                            <img src="评论-ok.png" style="width:18px;  cursor:pointer; position:absolute; margin-left:10px; margin-top:3px;">			
                                                            <!--楼中楼 1-->
                                                            <div class="margin-small-top">
                                                                <table width="100%" border="0">
                                                                <tbody><tr><td width="40px"><img class="margin-right" src="a82bb38de98345d64a797f2bb84ee753f36489cf22ba7-YX9oG9_fw320.jpg" style="width:40px;cursor:pointer;"></td>
                                                                <td valign="top">
                                                                    <a style="cursor:pointer;color:#F37021">周杰伦</a>回复<a style="cursor:pointer;color:#F37021">范冰冰</a>:
                                                                    <label>笑你妹哦</label>	
                                                                    <br>
                                                                    <label class="text-main text-small" style=" vertical-align:middle;  line-height:18px;">5分钟前</label>
                                                                    <img src="评论-ok.png" style="width:18px;  cursor:pointer; position:absolute; margin-left:10px; margin-top:3px;">			
                                                                </td></tr></tbody></table>
                                                            </div>
                                                            <!--楼中楼 2-->
                                                            <div class="margin-small-top">
                                                                <table width="100%" border="0">
                                                                <tbody><tr><td width="40px"><img class="margin-right" src="IMG_20140720_125930.jpg" style="cursor:pointer;width:40px;"></td>
                                                                <td valign="top">
                                                                    <a style="cursor:pointer;color:#F37021">一号粉丝</a>回复<a style="cursor:pointer;color:#F37021">周杰伦</a>:
                                                                    <label>你谁啊！什么意思啊？啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊</label>	
                                                                    <br>
                                                                    <label class="text-main text-small" style=" vertical-align:middle;  line-height:18px;">5分钟前</label>
                                                                    <img src="评论-ok.png" style="width:18px;  cursor:pointer; position:absolute; margin-left:10px; margin-top:3px;">			
                                                                </td></tr></tbody></table>
                                                            </div>
                                                            
                                                        </td>
                                                    </tr>
                                                </tbody></table>
                                            </div>
                                            <!--第2条评论-->
                                            <div class="margin-top">
                                                <table width="100%" border="0">
                                                    <tbody><tr>
                                                        <td valign="top" width="40px"><img class="margin-right" src="u=2107292801,3797874346&amp;fm=58.jpg" style="width:40px; cursor:pointer;"></td>
                                                        <td valign="top">
                                                            <a style="cursor:pointer;color:#F37021">范冰冰</a>:
                                                            <label>哈哈哈哈……你今天的经历太有趣了，我和我的室友都笑死了……</label>					<br>
                                                            <label class="text-main text-small" style=" vertical-align:middle;  line-height:18px;">5分钟前</label>
                                                            <img src="评论-ok.png" style="width:18px;  cursor:pointer; position:absolute; margin-left:10px; margin-top:3px;">			
                                                            <!--楼中楼 1-->
                                                            <div class="margin-small-top">
                                                                <table width="100%" border="0">
                                                                <tbody><tr><td width="40px"><img class="margin-right" src="a82bb38de98345d64a797f2bb84ee753f36489cf22ba7-YX9oG9_fw320.jpg" style="width:40px;cursor:pointer;"></td>
                                                                <td valign="top">
                                                                    <a style="cursor:pointer;color:#F37021">周杰伦</a>回复<a style="cursor:pointer;color:#F37021">范冰冰</a>:
                                                                    <label>笑你妹哦</label>	
                                                                    <br>
                                                                    <label class="text-main text-small" style=" vertical-align:middle;  line-height:18px;">5分钟前</label>
                                                                    <img src="评论-ok.png" style="width:18px;  cursor:pointer; position:absolute; margin-left:10px; margin-top:3px;">			
                                                                </td></tr></tbody></table>
                                                            </div>
                                                            <!--楼中楼 2-->
                                                            <div class="margin-small-top">
                                                                <table width="100%" border="0">
                                                                <tbody><tr><td width="40px"><img class="margin-right" src="IMG_20140720_125930.jpg" style="cursor:pointer;width:40px;"></td>
                                                                <td valign="top">
                                                                    <a style="cursor:pointer;color:#F37021">一号粉丝</a>回复<a style="cursor:pointer;color:#F37021">周杰伦</a>:
                                                                    <label>你谁啊！什么意思啊？啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊</label>	
                                                                    <br>
                                                                    <label class="text-main text-small" style=" vertical-align:middle;  line-height:18px;">5分钟前</label>
                                                                    <img src="评论-ok.png" style="width:18px;  cursor:pointer; position:absolute; margin-left:10px; margin-top:3px;">			
                                                                </td></tr></tbody></table>
                                                            </div>
                                                            
                                                        </td>
                                                    </tr>
                                                </tbody></table>
                                            </div>
                                        </div>
                                        <!--点赞列表-->
                                        <div id="dianzan_list" style="display:none">
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
                    
                    
                    
                    
                    
                    
                </div><!--main-width-->
            </div><!--main-color-->
             
            
            
            
            
            
            
            
    

	</div><!--！所有-->
<script> /*example里的切换js*/
	var comment_value = 1 ;
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
	function show_comment () {
		if(comment_value == 1)
		{ 
			comment_value = 0;
			document.getElementById('example_comment').style.display ='block';}
		else
		{ 
			comment_value = 1;
			document.getElementById('example_comment').style.display = 'none';}
	}
	function show_dianzanliebiao () {
			document.getElementById('dianzan_list').style.display ='block';
			document.getElementById('pinglun_list').style.display ='none';
	}
	function show_pinglunliebiao () {
			document.getElementById('dianzan_list').style.display ='none';
			document.getElementById('pinglun_list').style.display ='block';
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

