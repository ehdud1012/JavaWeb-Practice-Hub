// css : 사칙연산이라는 주제로 할게 많은것
// js : 사칙연산 유효성 검사 : 함수 1개
// 		=> 프로젝트 당 1개로 묶기

function calcCheck() {
	var xField = document.calcForm.x;
	var yField = document.calcForm.y;
	if (isEmpty(xField) || isNotNum(xField) || isEmpty(yField) || isNotNum(yField)) {
		alert("??");
		xField.value = "";
		yField.value = "";
		xField.focus();
		return false;
	}
	return true;
}

function martCheck(){
	var martInput = document.martForm.martInput;
	if(isEmpty(martInput)){
		alert("??");
		return false;
	}
	return true;
}