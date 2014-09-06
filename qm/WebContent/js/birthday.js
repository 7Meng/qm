// JavaScript Document

/*�������*/
function years(objId, Cyear, defaultValue, rangLength) {
    var selObj = document.getElementById(objId);
    var newOpt; // OPTION����
    
    selObj.options.length = 0;
    // selObj.options.add(new Options("",""));
    // ѭ�����OPIONԪ�ص����select������
    selObj.options.add(new Option());
    for (var i = 0; i < rangLength; i++) {
    	newOpt = window.document.createElement("OPTION"); // �½�һ��OPTION����
        newOpt.text = Cyear - i; // ����OPTION���������
        newOpt.value = Cyear - i; // ����OPTION�����ֵ
        if (Cyear - i == defaultValue) { // defauleValue Ϊ0������Ĭ��ѡ��
        	newOpt.setAttribute('selected', 'selected');
        }
        selObj.options.add(newOpt); // ��ӵ�Ŀ�������
    }
}

function months(objId, defaultValue){
    var month = document.getElementById(objId);
    month.length = 0; 
    month.options.add(new Option());
    for (var i = 1; i < 13; i++) {  // defauleValue Ϊ0������Ĭ��ѡ��
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
    //�������»�ȡ���� 
    day.options.add(new Option());
    var max = (new Date(vYear,vMonth, 0)).getDate();  
    for (var i=1; i <= max; i++) { // defauleValue Ϊ0������Ĭ��ѡ��
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
	//�������»�ȡ����  
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