function validateusername()
{
	var username=document.getElementById("usernamesignup").value;
	var url="/qm/validateusernameServlet";
	var argument="username="+username;
	initAjax(url,argument);
}

function returnResponse(httpRequest)
{
	if(httpRequest.readyState==4&&httpRequest.status==200)
		{
			var txt=httpRequest.responseText;
			if(txt=="yes")
				{
				document.getElementById("showerror").innerHTML="";
				}
			else if(type="no")
				{
			document.getElementById("showerror").innerHTML="已存在";
			document.getElementById("usernamesignup").focus();
				}
		}
}