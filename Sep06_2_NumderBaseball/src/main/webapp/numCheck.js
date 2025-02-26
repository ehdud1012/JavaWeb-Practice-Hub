function numCheck() {
	var input = document.nb.userNum;
	if (isEmpty(input) || isNotNum(input) || lessThan(input,3) 
		|| input.value[0] == input.value[1] 
		|| input.value[1] == input.value[2] 
		|| input.value[0] == input.value[2]) {
			
		alert("??");
		return false;
	}
	return true;
}