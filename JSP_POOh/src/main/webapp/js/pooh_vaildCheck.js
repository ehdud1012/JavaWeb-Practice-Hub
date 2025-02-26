function joinCheck() {
	var idField = document.joinForm.join_id;
	var pwField = document.joinForm.join_pw;
	var pwckField = document.joinForm.join_pw_ck;
	var photoField = document.joinForm.join_photo;
	
	if (isEmpty(idField) || constainsHS(idField)){
		alert("ID ?");
		idField.value = "";
		idField.focus();
		return false;
	}

	if (isEmpty(pwField) || notEqual(pwField, pwckField)
			|| notContains(pwField, "1234567890") 
		||  notContains(pwField, "qwertyuiopasdfghjklzxcvbnm")){
			alert("PW ?");
			pwField.value="";
			pwckField.value="";
			pwField.focus();
			return false;
	}
	
	if (isEmpty(photoField) || 
			(isNotType(photoField, "png") && isNotType(photoField, "gif") && isNotType(photoField, "jpg"))) {
			alert("photo ?");
			photoField.value="";
			return false;
	}
	return true;
}


function loginCheck(){
	var idField = document.loginForm.id;
	var pwField = document.loginForm.pw;
	
	if (isEmpty(idField) || isEmpty(pwField)){
			alert("?");
			idField.value = "";
			pwField.value = "";
			idField.focus();
			return false;
		}
	
	
	return true;
}

function updateCheck() {
	var pwField = document.updateForm.pw;
	var pwckField = document.updateForm.pwchk;
	var photoField = document.updateForm.photo;

	if (isEmpty(pwField) || notEqual(pwField, pwckField) || notContains(pwField, "1234567890") || notContains(pwField, "qwertyuiopasdfghjklzxcvbnm")) {
			alert("pw?");
			pwField.value = "";
			pwckField.value = "";
			pwField.focus();
			return false;
		}
	
	if(isEmpty(photoField)) { // 프사 선택 안함
		return true; // 정상
	}
	
	// 뭔가 선택을 함 -> 근데 파일종류 안맞음
	if (isNotType(photoField, "png") && isNotType(photoField, "gif") && isNotType(photoField, "jpg")) {
			alert("photo ?");
			photoField.value="";
			return false;
	}
	
	return true;
}
function noticeUpdateCheck() {
	var titleField = document.noticeForm.title;
	var txtField = document.noticeForm.txt;

	if (isEmpty(titleField) || isEmpty(txtField)) {
			alert("?");
			return false;
		}
	
	return true;
}
function noticeCommentCheck() {
	var txtField = document.commentForm.comment;
	if (isEmpty(txtField)) {
			alert("?");
			return false;
	}
	return true;
}



