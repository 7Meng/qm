<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>青檬-登陆</title>
<link rel="stylesheet" href="css/login_pc.css">
<script type="text/javascript" src="js/index.js"></script>
<script type="text/javascript" src="js/login_pc.js"></script>
</head>

<body style="background-image:url(image/background.jpg); background-size:cover;  font-family:'Microsoft Yahei';">

<div class="container" style="padding-bottom: 150px;">
            <img style=" position:absolute; left:170px; top:60px; height:60px;" src="image/logo2.png" />
            <img style=" position:absolute; left:75px; top:160px; height:80px;"  src="image/write.png">
            
            <section>				
                <div id="container_demo" >
                    <a class="hiddenanchor" id="tologin"></a>
                    <a class="hiddenanchor" id="toregister"></a>
                    
                    <div style=" padding:0px; position:absolute; right:100px; top:100px; width:420px;"  id="wrapper">
                        <div style=" padding:0px;" id="login" class="animate form">
                            <form   action="loginServlet" autocomplete="on" method="post"> 
                            	<div class="switch">
                                	<div class="switch1" ><a href="#tologin" style="  font-size:16px; line-height:49px; text-decoration:none; color:#000; padding:14px; border-bottom:3px solid rgb(61, 157, 179);">登陆</a></div>
                                    <div class="switch2" ><a href="#toregister" style=" font-size:16px; line-height:49px; text-decoration:none; color:#999 ">10秒注册</a></div>
                                    
                                </div>							
                                
                                
                                <p style="text-align:center;"> 
                                    <!--label for="username" class="uname" data-icon="u" >  </label-->
                                    <input style="width:70%; font-size:14px;" id="username" name="username" required type="text" placeholder="昵称 / 邮箱"/>
                                </p>
                                <p style="text-align:center;"> 
                                    <!--label for="password" class="youpasswd" data-icon="p">  </label-->
                                    <input style="width:70%; font-size:14px; " id="password" name="password" required type="password" placeholder="密码" /> 
                                </p>
                                <input style="margin-left:35px;" type="checkbox" name="loginkeeping" id="loginkeeping" value="loginkeeping" checked="checked" /> 
									<label for="loginkeeping">下次自动登陆</label>
                                    <a href="#" style="text-decoration: none;   position: absolute; right: 35px;" >忘记密码？</a>
                                <p style=" position:relative; right:20px;" class="login button"> 
                                    <input type="submit" onclick="login()" value="登陆" /> 
								</p>
                                
                            </form>
                        </div>

                        <div style=" padding:0px;"  id="register" class="animate form">
                            <form  action="RegisterServlet" autocomplete="on" method="post"> 
                            	<div class="switch">
                                	<div id="fuck" class="switch1" ><a href="#tologin" style=" font-size:16px; line-height:49px; text-decoration:none; color:#999">登陆</a></div>
                                    <div id="switch2" class="switch2" ><a href="#toregister" style=" font-size:16px; line-height:49px; text-decoration:none; color:#000 ; padding:14px; border-bottom:3px solid rgb(61, 157, 179); ">10秒注册</a></div>
                                    
                                </div>	
                                
                                 
                                <p style="text-align:center;"> 
                                    
                                    <input style="width:70%; font-size:14px;" onchange="validateusername()" id="usernamesignup" name="usernamesignup" required type="text" placeholder="输入昵称(无法更改/建议为汉字)" />&nbsp;<span id="showerror"></span>
                                    
                                </p>
                                
                                <p style="text-align:center;"> 
                                    
                                    <input style="width:70%; font-size:14px; " id="passwordsignup" name="passwordsignup" required type="password" placeholder="输入密码(不少于6位)"/>
                                </p>
                                <p style="text-align:center;"> 
                                    
                                    <input style="width:70%; font-size:14px; " id="passwordsignup_confirm" name="passwordsignup_confirm" required type="password" placeholder="再次输入密码"/>
                                </p>
                                <input style="  margin-left:35px;margin-bottom:20px;" type="radio" name="sex" id="female" value="female" /><label for="female">女生</label>
								<input style="margin-left:20px;" type="radio" name="sex" value="male" id="male" /><label for="male">男生</label>
                                <span style=" line-height:12px; font-size:12px; color:#999; margin-left:5px">性别确定后无法更改</span>
                                <br />
                                
                                
                                <input style="margin-left:35px;" type="checkbox" name="loginkeeping" id="agree" value="loginkeeping" checked="checked" /> 
									<label for="loginkeeping">同意 <a href="#" style="text-decoration:none;">《青檬用户协议》</a></label>
                                <p style=" position:relative; right:20px;" class="signin button"> 
									<input type="submit" value="注册"/> 
								</p>
                                
                            </form>
                        </div>
						
                    </div>
                </div>  
            </section>
</div>
<div class="footer" style=" line-height: 22px; font-size: 14px; text-align: center; position: absolute; bottom: 10px; width:100%">
<a href="#">关于我们</a>
<a href="#">加入我们</a>
<a href="#">寻求合作</a>
<p>Copyright © 2014 7Meng.All Rights Reserved.</p>
<p>七檬工作室 版权所有 湘网文[2014]0001-070号</p>
</div>
        						
        
        
</body>
</html>