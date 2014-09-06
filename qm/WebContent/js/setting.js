// JavaScript Document
var collegesArray = [
	'哲史院',
	'商学院',
	'公共管理学院',
	'旅游管理学院',
	'法学院',
	'知识产权学院',
	'马克思主义学院',
	'文学与新闻学院',
	'外国语学院',
	'数学与计算科学学院',
	'材料与光电物理学院',
	'化学学院',
	'化工学院',
	'机械工程学院',
	'信息工程学院',
	'土木工程与力学学院',
	'大学英语教学部',
	'体育教学部',
	'艺术学院',
	'国际交流学院',
	'兴湘学院',
	'能源工程学院',
	'职业技术学院'
];

function showCollege(collegeId, defaultValue) {
	var college = document.getElementById(collegeId);

	college.length = 0;
	college.options.add(new Option());
	for (var i = 0; i < collegesArray.length; i++) {
		var option = new Option();
		option.text = collegesArray[i];
		option.value = collegesArray[i];
		if (collegesArray[i] == defaultValue) {
			option.setAttribute('selected', 'selected');
		}
		college.options.add(option);
	}
}