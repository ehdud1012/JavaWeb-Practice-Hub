function numCheck() {
	var xField = document.calculater.xx;
	var yField = document.calculater.yy;
	if (isEmpty(xField) || isNotNum(xField)
		|| isEmpty(yField) || isNotNum(yField)) {
		alert("??");
		return false;
	}
	return true;
}