

//初始化ajax，用post方法发送给服务端
function initAjax(url,argument)
{
	var httpRequest;
	
	if(window.XMLHttpRequest)
		{
		httpRequest=new XMLHttpRequest();
		}
	else if(window.ActiveXObject)
		{
		httpRequest=new ActiveXObject("Microsoft.XMLHttp");
		}
	if(null!=httpRequest)
		{
		httpRequest.onreadystatechange=function()
		{
			returnResponse(httpRequest);
		}
		}
	httpRequest.open("POST",url,true);
	/**
	*如果用post请求向服务器发送数据
	  需要
	*/
	httpRequest.send(argument);
}


