function goJoin() {
	location.href = "JoinController";
}
function goLogout() {
	var really = confirm("really ?");
	if(really){
		location.href = "Logincontroller";
	}
}
function goMemberInfo() {
	location.href = "MemberInfoController";
}

function goNoticeGet(no) {
	location.href = "NoticeContentController?no=" + no;
}

function bye(){
	var msg = prompt("Ż���Ϸ��� Ż���� �Է��ϼ���");
	if (msg == "Ż��") {
		location.href = "MemberDelateController";
	}
}

function goNoticeDelete(no){
	var msg = prompt("�����Ϸ��� ������� �Է��ϼ���");
	if (msg == "����") {
		location.href = "NotionDelateController?no=" + no;
	}
}