<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.xtu.qm.pojo.*" %>
<%@ page import="java.util.regex.*" %>
<%
// 标签列表
String[] INTERESTS = {
"听歌",
"看电影",
"玩电脑",
"阅读",
"旅游",
"舞蹈",
"绘画",
"吉他",
"女人",
"男人"};
List<String> interestList = new ArrayList<String>();

String[] TYPES = {
"娇小",
"御姐",
"高瘦",
"壮汉",
"文艺青年",
"理科生",
"工科生",
"感性",
"理性",
"型男",
"IT男"
};

AccountInfo account = (AccountInfo)session.getAttribute("AccountInfo");
UserInfo user = account.getUserinfo();
PersonalSpace zone = user.getPersonalspace();
StuInformation stuInfo = user.getStuInfo();

Calendar cal = null;
if (user.getBirthday() != null) {
	cal = Calendar.getInstance();
	cal.setTime(user.getBirthday());
}

String address = user.getHomeAddress();
String province = null, city = null;
if (address != null) {
	String[] group = address.split("&&");
	if (group.length == 2) {
		province = group[0];
		city = group[1];
	} 
	if (group.length == 1) {
		province = group[0];
	}
}

Set<String>	interestsSet = new HashSet<String>();
if (user.getInterests() != null) {
	interestsSet.addAll( Arrays.asList( user.getInterests().split("&&") ) );
}

Set<String> typesSet = new HashSet<String>(); 
if (user.getType() != null) {
	typesSet.addAll( Arrays.asList( user.getType().split("&&") ) );
}

Pattern decimal = Pattern.compile("\\d+"); 
int entranceYear = -1;
if (stuInfo.getEntranceYear() != null) {
	Matcher match = decimal.matcher(stuInfo.getEntranceYear());
	if (match.find()) {
		entranceYear = Integer.parseInt(match.group());
	}
}
%>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>拼图初始模板</title>
<link rel="stylesheet" type="text/css" href="css/pintuer.css" />
<link rel="stylesheet" type="text/css" href="css/NewIndex.css" />
</head>

<body>
	<div class="container radius-none" >
     	 	<!--导航栏-->
            <div id="nav_fixed">
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
                  <li class="nav-more" ><a class="text-default" href="#"><img src="<%= user.getUserLogo().getSmallimageUrl() %>" width="30"> <%= account.getUsername() %></a></li>
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
                              <li class="active"><a class="text-sub" href="#">头像设置</a></li>
                              <li><a href="#">签名&nbsp;生活照</a></li>
                              <li><a href="#">个人信息</a></li>
                              <li><a href="#">隐私设置</a></li>
                              <li><a href="#">其他设置</a></li>
                              <li><a href="#">实名认证</a></li> 
                            </ul>
                    </div>
                    <!--左边布局--> 
						<!--头像设置-->
                        <div id="setHead" class="panel border-sub layout_left bg-white " style="margin-top:100px;"> 
                              <div class="panel-head  border-sub bg-sub "><strong >头像设置</strong>
                              		
                              </div>
                              <div class="panel-body">面板内容
                              <br />
                              <button class="button   bg-green padding-left padding-right"><span class="icon-check"></span>&nbsp;确认修改</button>
                              </div>
                        </div>
                        <!--签名 生活照-->
                        <div id="setSignature" class="panel border-sub layout_left bg-white " style="margin-top:100px;">                    
                        	  <div class="panel-head  border-sub bg-sub bg-inverse"><strong>签名&nbsp;生活照</strong></div>
                              <div class="panel-body ">
                              		<form action="UploadLifePhotoServlet" method="post" enctype="multipart/form-data">
                              		<input type="hidden" name="action" value="SignaturePicture"/>
                                      <label class="label">签名</label><textarea name="signature" rows="5" class="input" placeholder="大笔一挥，留下您的签名。(少于140字)"><%=
                                    		  user.getSignature() != null ? user.getSignature(): ""
                                      %></textarea>
                                      <br />
                                      <label class="label">生活照</label>
                                      		<img class="lifeImage radius img-border " src="<%= user.getUserimage() != null? user.getUserimage().getBigimageUrl(): null %>" />
                                            <a class="button button-small input-file bg-green margin-left" href="javascript:void(0);">
                                            	+ 浏览文件
                                            <input size="100" type="file" name="logo" />
                                       		</a><br /><br />
                                            <button class="button  bg-green padding-left padding-right"><span class="icon-check"></span>&nbsp;确认修改</button>
                                      		
                                    </form>
                              </div>
                        </div>     
                        <!--个人信息-->
                        <div id="setHead" class="panel border-sub layout_left bg-white " style="margin-top:100px;"> 
                              <div class="panel-head  border-sub bg-sub "><strong >个人信息</strong></div>
                              <div class="panel-body">
                              <form style="display:inline;" action="SettingServlet" method=post>
                              		<input type="hidden" name="action" value="PersonalInfo" />
                              		<label class="label">生日：</label>
                                            <select class="input" size="1" name="calendar" id="calendar" style="width:100px; display:inline" onFocus="" onChange="">
                                                <option>公历</option>
                                                <option>农历</option>
                                            </select>&nbsp;
                                            <select class="input" size="1" name="year" id="year" style="width:100px; display:inline" onfocus="years('year',new Date().getFullYear(),<%= cal != null? cal.get(Calendar.YEAR): 0 %>, 150)" onchange="change_days('year', 'month', 'date')">
                                            	<option selected="selected"><%= cal != null? cal.get(Calendar.YEAR): "" %></option>
                                            </select>&nbsp;
                                            <select class="input" size="1" name="month" id="month" style="width:100px; display:inline" onfocus="months('month',<%= cal != null? cal.get(Calendar.MONTH) + 1: 0 %>)" onchange="change_date()" onchange="change_days('year', 'month', 'date')">
                                            	<option selected="selected"><%= cal != null? cal.get(Calendar.MONTH) + 1: "" %></option>
                                            </select>&nbsp;
                                            <select class="input" size="1" name="date" id="date" style="width:100px; display:inline" onfocus="days('year', 'month', 'date', <%= cal != null? cal.get(Calendar.DATE): 0 %>)">
                                            	<option selected="selected"><%= cal != null? cal.get(Calendar.DATE): "" %></option>
                                            </select>
                                    <br /><br> 
                                    <label class="label">家乡：</label>
                                        <select class="input" size="1" id="province" name="province" style="width:100px; display:inline" onfocus="showProvinces('province', '<%= province != null? province: null %>')" onchange="changeCity('city')">
                                        	<option selected="selected"><%= province != null? province: "" %></option>
                                        </select>
                                        <select class="input" size="1" id="city" name="city" style="width:100px;margin-left:5px;; display:inline " onfocus="showCities('province', 'city', '<%=city != null? city: null %>')">
                                        	<option selected="selected"><%=city != null? city: "" %></option>
                                        </select>
                                    <br /><br />
                                    <label class="label">学院：</label>
                                    <select class="input" size="1" id="college" name="college" style="width:150px; display:inline" onfocus="showCollege('college', '<%= stuInfo.getDepartment() != null? stuInfo.getDepartment(): null %>')">
                						<option><%= stuInfo.getDepartment() != null? stuInfo.getDepartment(): "" %></option>
                                    </select><br /> <br>
                                    <label class="label">入学：</label>
                                    <select class="input" size="1" name="grade" id="grade" style="width:100px" onfocus="years('grade',new Date().getFullYear(),<%= entranceYear != -1 ? entranceYear: 0 %>, new Date().getFullYear() - 1958 + 1)">
                                        <option><%= entranceYear != -1 ? entranceYear: "" %></option>
                                    </select><br />
                                    <label class="label">兴趣：</label>
                                    	<div class="button-group border-main  checkbox ">
                                    	<% 
                                    	 	for (String interest: INTERESTS) {
                                    	%>
                                          <label class="button <%= interestsSet.contains(interest)? "active": "" %>">
                                          	<input name="interests" value="<%= interest %>" type="checkbox" <%= interestsSet.contains(interest)? "checked=\"checked\"": "" %>/><%= interest %>
                                          </label>
                                        <% 
                                        	}
                                         %>
                                        </div><br /><br />
                                    <label class="label">标签：</label>                                 		
                                    	<div class="button-group border-main  checkbox ">
                                    	<% // 
                                    		for (String type: TYPES) {
                                    	 %>
                                          <label class="button <%= typesSet.contains(type)? "active": "" %>">
                                          	<input name="types" value="<%= type %>" type="checkbox" <%= typesSet.contains(type) ? "checked=\"checked\"" : "" %>"/><%= type %>
                                          </label>
                                        <%
                                        	}
                                         %>
                                        </div><br /><br />
                                  <button class="button   bg-green padding-left padding-right"><span class="icon-check"></span>&nbsp;确认修改</button>
                                  </form>
                              </div>
                        </div>     
                        <!--隐私设置-->
                        <div id="setHead" class="panel border-sub layout_left bg-white " style="margin-top:100px;"> 
                              <div class="panel-head  border-sub bg-sub "><strong >隐私设置</strong>
                              		
                              </div>
                              <div class="panel-body">面板内容
                              <br />
                              <button class="button   bg-green padding-left padding-right"><span class="icon-check"></span>&nbsp;确认修改</button>
                              </div>
                        </div>     
                        <!--其他设置-->
                        <div id="setHead" class="panel border-sub layout_left bg-white " style="margin-top:100px;"> 
                              <div class="panel-head  border-sub bg-sub "><strong >其他设置</strong>
                              		
                              </div>
                              <div class="panel-body">面板内容
                              <br />
                              <button class="button   bg-green padding-left padding-right"><span class="icon-check"></span>&nbsp;确认修改</button>
                              </div>
                        </div>     
                        <!--实名认证-->
                        <div id="setHead" class="panel border-sub layout_left bg-white " style="margin-top:100px;"> 
                              <div class="panel-head  border-sub bg-sub "><strong >实名认证</strong>
                              		
                              </div>
                              <div class="panel-body">面板内容
                              <br />
                              <button class="button   bg-green padding-left padding-right"><span class="icon-check"></span>&nbsp;确认修改</button>
                              </div>
                        </div>
                    
                    
                    
                    
                    
                    
                </div><!--main-width-->
            </div><!--main-color-->
             
            
            
            
            
            
            
            
    

	</div><!--！所有-->

<script src="js/jquery-1.11.0.min.js" type="text/javascript"></script>
<script src="js/pintuer.js" type="text/javascript"></script>
<script src="js/birthday.js" type="text/javascript" ></script>
<script src="js/hometown.js" type="text/javascript" ></script>
<script src="js/setting.js" type="text/javascript" charset="utf-8"></script>
</body>
</html>
