function onClickSubmitForm (id, action){
    document.getElementById(id).action = action;
    document.getElementById(id).submit();
}