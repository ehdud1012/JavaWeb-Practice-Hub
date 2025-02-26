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
	var msg = prompt("탈퇴하려면 탈퇴라고 입력하세요");
	if (msg == "탈퇴") {
		location.href = "MemberDelateController";
	}
}

function goNoticeDelete(no){
	var msg = prompt("삭제하려면 삭제라고 입력하세요");
	if (msg == "삭제") {
		location.href = "NotionDelateController?no=" + no;
	}
}