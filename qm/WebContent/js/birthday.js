// JavaScript Document

/*加载年份*/
function years(objId, Cyear, defaultValue, rangLength) {
    var selObj = document.getElementById(objId);
    var newOpt; // OPTION对象
    
    selObj.options.length = 0;
    // selObj.options.add(new Options("",""));
    // 循环添加OPION元素到年份select对象中
    selObj.options.add(new Option());
    for (var i = 0; i < rangLength; i++) {
    	newOpt = window.document.createElement("OPTION"); // 新建一个OPTION对象
        newOpt.text = Cyear - i; // 设置OPTION对象的内容
        newOpt.value = Cyear - i; // 设置OPTION对象的值
        if (Cyear - i == defaultValue) { // defauleValue 为0则不设置默认选项
        	newOpt.setAttribute('selected', 'selected');
        }
        selObj.options.add(newOpt); // 添加到目标对象中
    }
}

function months(objId, defaultValue){
    var month = document.getElementById(objId);
    month.length = 0; 
    month.options.add(new Option());
    for (var i = 1; i < 13; i++) {  // defauleValue 为0则不设置默认选项
    	var option = new Option(i, i);
    	if (i == defaultValue) {
    		option.setAttribute('selected', 'selected');
    	}
        month.options.add(option);  
    }
}

function days(yearId, monthId, dayId, defaultValue){  
    var year  = document.getElementById(yearId);  
    var month = document.getElementById(monthId);  
    var day   = document.getElementById(dayId); 
    
    var vYear  = parseInt(year.value);  
    var vMonth = parseInt(month.value);  
    
    day.length=0;    
    //根据年月获取天数 
    day.options.add(new Option());
    var max = (new Date(vYear,vMonth, 0)).getDate();  
    for (var i=1; i <= max; i++) { // defauleValue 为0则不设置默认选项
    	var option = new Option(i, i);
    	if (defaultValue == i) { 
    		option.setAttribute('selected', 'selected');
    	}
        day.options.add(option);  
    }  
}

function change_days(yearId, monthId, dayId) {
	var year  = document.getElementById(yearId);
	var month = document.getElementById(monthId);
	var day = document.getElementById(dayId);
	
	var vYear  = parseInt(year.value);  
    var vMonth = parseInt(month.value); 
    var vDay = parseInt(day.value);
	
    if (isNaN(vYear) || isNaN(vMonth) || isNaN(vDay)) {
    	return;
    }
    
    var option;
	//根据年月获取天数  
    var max = (new Date(vYear,vMonth, 0)).getDate();
    
	if (vDay > max) { // 
		day.lenght = 0;
		option = window.document.createElement("OPTION");
		option.value = 1;
		option.text = 1;
		option.setAttribute('selected', 'selected');
		day.options.add(option);
	} else {
		day.length = 0;
		option = window.document.createElement("OPTION");
		option.value = vDay;
		option.text = vDay;
		option.setAttribute('selected', 'selected');
		day.options.add(option);
	}
}