function onClickSubmitForm (id, action, redirectUrl, productId){
    document.getElementById('action').value= action;
    document.getElementById(id).action = redirectUrl;
    document.getElementById('productId').value = productId;
    document.getElementById(id).submit();
}
