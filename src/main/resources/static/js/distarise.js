function onClickSubmitForm (id, action, redirectUrl){
    setDefaults(id, action, redirectUrl);
    document.getElementById(id).submit();
}

function onLoadRetrieveData (id, action, redirectUrl){
    setDefaults(id, action, redirectUrl);
    document.getElementById(id).submit();
}

function setDefaults(id, action, redirectUrl){
    document.getElementById(id)["action"].value= action;
    document.getElementById(id).action = redirectUrl;
}

function fillForm(id, module, pagedescription, pagename, pagetitle, redirectpagename, rolename) {
    document.getElementById('id').value= id;
    document.getElementById('module').value= module;
    document.getElementById('pagedescription').value= pagedescription;
    document.getElementById('pagename').value= pagename;
    document.getElementById('pagetitle').value= pagetitle;
    document.getElementById('redirectpagename').value= redirectpagename;
    document.getElementById('rolename').value= rolename;
}