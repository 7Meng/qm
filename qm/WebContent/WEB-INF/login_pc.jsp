<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!doctype html>
<html>
<!-- saved from url=(0014)about:internet -->
<head>
<meta charset="utf-8">
<title>éæª¬-ç»é</title>
<link rel="stylesheet" href="login_pc.css">
</head>

<body style="background-image:url(background.jpg); background-size:cover;  font-family:'Microsoft Yahei';">

<div class="container" style="padding-bottom: 150px;">
            <img style=" position:absolute; left:170px; top:60px; height:60px;" src="logo2.png" />
            <img style=" position:absolute; left:75px; top:160px; height:80px;"  src="write.png">
            
            <section>				
                <div id="container_demo" >
                    <a class="hiddenanchor" id="tologin"></a>
                    <a class="hiddenanchor" id="toregister"></a>
                    
                    <div style=" padding:0px; position:absolute; right:100px; top:100px; width:420px;"  id="wrapper">
                        <div style=" padding:0px;" id="login" class="animate form">
                            <form   action="mysuperscript.php" autocomplete="on"> 
                            	<div class="switch">
                                	<div class="switch1" ><a href="#tologin" style="  font-size:16px; line-height:49px; text-decoration:none; color:#000; padding:14px; border-bottom:3px solid rgb(61, 157, 179);">ç»é</a></div>
                                    <div class="switch2" ><a href="#toregister" style=" font-size:16px; line-height:49px; text-decoration:none; color:#999 ">10ç§æ³¨å</a></div>
                                    
                                </div>							
                                
                                
                                <p style="text-align:center;"> 
                                    <!--label for="username" class="uname" data-icon="u" >  </label-->
                                    <input style="width:70%; font-size:14px;" id="username" name="username" required type="text" placeholder="æµç§° / é®ç®±"/>
                                </p>
                                <p style="text-align:center;"> 
                                    <!--label for="password" class="youpasswd" data-icon="p">  </label-->
                                    <input style="width:70%; font-size:14px; " id="password" name="password" required type="password" placeholder="å¯ç " /> 
                                </p>
                                <input style="margin-left:35px;" type="checkbox" name="loginkeeping" id="loginkeeping" value="loginkeeping" checked="checked" /> 
									<label for="loginkeeping">ä¸æ¬¡èªå¨ç»é</label>
                                    <a href="#" style="text-decoration: none;   position: absolute; right: 35px;" >å¿è®°å¯ç ï¼</a>
                                <p style=" position:relative; right:20px;" class="login button"> 
                                    <input type="submit" value="ç»é" /> 
								</p>
                                
                            </form>
                        </div>

                        <div style=" padding:0px;"  id="register" class="animate form">
                            <form  action="RegisterServlet" autocomplete="on" method="post"> 
                            	<div class="switch">
                                	<div id="fuck" class="switch1" ><a href="#tologin" style=" font-size:16px; line-height:49px; text-decoration:none; color:#999">ç»é</a></div>
                                    <div id="switch2" class="switch2" ><a href="#toregister" style=" font-size:16px; line-height:49px; text-decoration:none; color:#000 ; padding:14px; border-bottom:3px solid rgb(61, 157, 179); ">10ç§æ³¨å</a></div>
                                    
                                </div>	
                                
                                 
                                <p style="text-align:center;"> 
                                    
                                    <input style="width:70%; font-size:14px;"  id="usernamesignup" name="usernamesignup" required type="text" placeholder="è¾å¥æµç§°(æ æ³æ´æ¹/å»ºè®®ä¸ºæ±å­)" />
                                </p>
                                
                                <p style="text-align:center;"> 
                                    
                                    <input style="width:70%; font-size:14px; " id="passwordsignup" name="passwordsignup" required type="password" placeholder="è¾å¥å¯ç (ä¸å°äº6ä½)"/>
                                </p>
                                <p style="text-align:center;"> 
                                    
                                    <input style="width:70%; font-size:14px; " id="passwordsignup_confirm" name="passwordsignup_confirm" required type="password" placeholder="åæ¬¡è¾å¥å¯ç "/>
                                </p>
                                <input style="  margin-left:35px;margin-bottom:20px;" type="radio" name="sex" id="female" value="female" /><label for="female">å¥³ç</label>
								<input style="margin-left:20px;" type="radio" name="sex" value="male" id="male" /><label for="male">ç·ç</label>
                                <span style=" line-height:12px; font-size:12px; color:#999; margin-left:5px">æ§å«ç¡®å®åæ æ³æ´æ¹</span>
                                <br />
                                
                                
                                <input style="margin-left:35px;" type="checkbox" name="loginkeeping" id="agree" value="loginkeeping" checked="checked" /> 
									<label for="loginkeeping">åæ <a href="#" style="text-decoration:none;">ãéæª¬ç¨æ·åè®®ã</a></label>
                                <p style=" position:relative; right:20px;" class="signin button"> 
									<input type="submit" value="æ³¨å"/> 
								</p>
                                
                            </form>
                        </div>
						
                    </div>
                </div>  
            </section>
</div>
<div class="footer" style=" line-height: 22px; font-size: 14px; text-align: center; position: absolute; bottom: 10px; width:100%">
<a href="#">å³äºæä»¬</a>
<a href="#">å å¥æä»¬</a>
<a href="#">å¯»æ±åä½</a>
<p>Copyright Â© 2014 7Meng.All Rights Reserved.</p>
<p>ä¸æª¬å·¥ä½å®¤ çæææ æ¹ç½æ[2014]0001-070å·</p>
</div>
        						
        
        
</body>
</html>
    