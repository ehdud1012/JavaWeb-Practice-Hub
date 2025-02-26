function joinCheck(){
	var idField = document.joinForm.id;
	var pwField = document.joinForm.pw;
	var pwchkField = document.joinForm.pwcheck;
	var ageField = document.joinForm.age;
	var photoField = document.joinForm.photo;
	
	if (isEmpty(idField) || lessThan(idField, 4) || containsHS(idField)){
		alert("ID 똑바로");
		idField.value="";
		idField.focus();
		return false;
	}
	
	if (isEmpty(pwField) || lessThan(pwField, 4) || notEqual(pwField, pwchkField)
		|| notContains(pwField, 1234567890) ||  notContains(pwField, "qwertyuiopasdfghjklzxcvbnm")){
			alert("PW 똑바로");
			pwField.value="";
			pwchkField.value="";
			pwField.focus();
			return false;
	}
	if (isEmpty(ageField) || isNotNum(ageField)) {
		alert("나이 ?");
		ageField.value="";
		ageField.focus();
		return false;
	}
	
	if (isEmpty(photoField) || 
		(isNotType(photoField, "png") && isNotType(photoField, "gif") && isNotType(photoField, "jpg"))) {
		alert("프사 ?");
		return false;
	}
	return true;
}