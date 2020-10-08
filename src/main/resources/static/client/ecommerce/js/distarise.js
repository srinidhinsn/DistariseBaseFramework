function onClickSubmitForm (id, action, redirectUrl){
    setDefaults(id, action, redirectUrl);
    document.getElementById(id).submit();
}

function onLoadRetrieveData (id, action, redirectUrl){
    setDefaults(id, action, redirectUrl);
    document.getElementById(id).submit();
}

function setDefaults(id, action, redirectUrl){
    document.getElementById('action').value= action;
    document.getElementById(id).action = redirectUrl;
}