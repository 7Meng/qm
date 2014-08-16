
//校验用户昵称是否已经存在
function validateusername()
{
	var username=document.getElementById("usernamesignup").value;
	var url="/qm/validateusernameServlet";
	var argument="username="+username;
	initAjax(url,argument);
}

//登陆
function login()
{
	var username=document.getElementById("username").value;
	var password=document.getElementById("password").value;
	var url="/qm/LoginServlet";
	var arguments="username="+username+"&password="+password;
	initAjax(url,arguments);
}

//ajax对后台回显过来的数据的回显函数处理
function returnResponse(httpRequest)
{
	if(httpRequest.readyState==4&&httpRequest.status==200)
		{
			var txt=httpRequest.responseText;
			//返回如果是yes，代表注册用户昵称可用
			if(txt=="yes")
				{
				document.getElementById("showerror").innerHTML="";
				}
			//返回如果是no,代表用户昵称已存在
			else if(txt=="no")
				{
			document.getElementById("showerror").innerHTML="已存在";
			document.getElementById("usernamesignup").focus();
				}
			//返回如果是email，代表邮箱或者密码不正确
			else if(txt=="email")
				{
				
				
				}
			//返回如果是username，代表用户昵称或者密码不正确
			else if(txt=="username")
				{
				
				}
		}
}