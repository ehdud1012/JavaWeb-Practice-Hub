function numCheck() {
	var input = document.unit.input;
	if (isEmpty(input) || isNotNum(input)) {
		alert("??");
		return false;
	}
	return true;
}