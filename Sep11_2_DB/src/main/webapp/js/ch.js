function productRegCheck(){
	var nameField = document.regForm.name;
	var priceField = document.regForm.price;
	
	if (isEmpty(nameField)) {
		return false;
	}
	if (isEmpty(priceField) || isNotNum(priceField)) {
		return false;
	}
		return true;
}