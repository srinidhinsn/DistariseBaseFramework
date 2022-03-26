function onClickSubmitForm (id, action, redirectUrl){
    setDefaults(id, action, redirectUrl);
    document.getElementById(id).submit();
}

function saveRoleWidgetAccess(id, action, redirectUrl, clientId, roleName, widgetId, selectedAction, enabled){
    document.getElementById(id)["selectedClientId"].value = clientId;
    document.getElementById(id)["selectedRoleName"].value = roleName;
    document.getElementById(id)["selectedWidgetId"].value = widgetId;
    document.getElementById(id)["selectedAction"].value = selectedAction;
    document.getElementById(id)["selectedEnabled"].value = enabled;
    onClickSubmitForm(id, action, redirectUrl);
}

function viewCustomer(id, action, redirectUrl, customerId){
    document.getElementById(id)["customerId"].value = customerId;
    onClickSubmitForm(id, action, redirectUrl);
}

function onLoadRetrieveData (id, action, redirectUrl){
    setDefaults(id, action, redirectUrl);
    document.getElementById(id).submit();
}

function setDefaults(id, action, redirectUrl){
    document.getElementById(id)["action"].value= action;
    document.getElementById(id).action = redirectUrl;
}

function fillForm(id, column1, column2, column3, column4, column5, column6, column7, column8, column9, column10, column11,
                  column12, column13, column14, column15, column16, column17, column18, column19, column20) {
    if (document.getElementById(id)['column1'] && column1 != 'null') {
        document.getElementById(id)['column1'].value= column1;
        document.getElementById(id)['column1'].checked= 'true' === column1.toLowerCase();
    }
    if (document.getElementById(id)['column2'] && column2 != 'null') {
        document.getElementById(id)['column2'].value= column2;
        document.getElementById(id)['column2'].checked= 'true' === column2.toLowerCase();
    }
    if (document.getElementById(id)['column3'] && column3 != 'null') {
        document.getElementById(id)['column3'].value= column3;
        document.getElementById(id)['column3'].checked= 'true' === column3.toLowerCase();
    }
    if (document.getElementById(id)['column4'] && column4 != 'null') {
        document.getElementById(id)['column4'].value= column4;
        document.getElementById(id)['column4'].checked= 'true' === column4.toLowerCase();
    }
    if (document.getElementById(id)['column5'] && column5 != 'null') {
        document.getElementById(id)['column5'].value= column5;
        document.getElementById(id)['column5'].checked= 'true' === column5.toLowerCase();
    }
    if (document.getElementById(id)['column6'] && column6 != 'null') {
        document.getElementById(id)['column6'].value= column6;
        document.getElementById(id)['column6'].checked= 'true' === column6.toLowerCase();
    }
    if (document.getElementById(id)['column7'] && column7 != 'null') {
        document.getElementById(id)['column7'].value= column7;
        document.getElementById(id)['column7'].checked= 'true' === column7.toLowerCase();
    }

    if (document.getElementById(id)['column8'] && column8 != 'null') {
        document.getElementById(id)['column8'].value= column8;
        document.getElementById(id)['column8'].checked= 'true' === column8.toLowerCase();
    }
    if (document.getElementById(id)['column9'] && column9 != 'null') {
        document.getElementById(id)['column9'].value= column9;
        document.getElementById(id)['column9'].checked= 'true' === column9.toLowerCase();
    }
    if (document.getElementById(id)['column10'] && column10 != 'null') {
        document.getElementById(id)['column10'].value= column10;
        document.getElementById(id)['column10'].checked= 'true' === column10.toLowerCase();
    }
    if (document.getElementById(id)['column11'] && column11 != 'null') {
        document.getElementById(id)['column11'].value= column11;
        document.getElementById(id)['column11'].checked= 'true' === column11.toLowerCase();
    }
    if (document.getElementById(id)['column12'] && column12 != 'null') {
        document.getElementById(id)['column12'].value= column12;
        document.getElementById(id)['column12'].checked= 'true' === column12.toLowerCase();
    }
    if (document.getElementById(id)['column13'] && column13 != 'null') {
        document.getElementById(id)['column13'].value= column13;
        document.getElementById(id)['column13'].checked= 'true' === column13.toLowerCase();
    }
    if (document.getElementById(id)['column14'] && column14 != 'null') {
        document.getElementById(id)['column14'].value= column14;
        document.getElementById(id)['column14'].checked= 'true' === column14.toLowerCase();
    }
    if (document.getElementById(id)['column15'] && column15 != 'null') {
        document.getElementById(id)['column15'].value= column15;
        document.getElementById(id)['column15'].checked= 'true' === column15.toLowerCase();
    }
    if (document.getElementById(id)['column16'] && column16 != 'null') {
        document.getElementById(id)['column16'].value= column16;
        document.getElementById(id)['column16'].checked= 'true' === column16.toLowerCase();
    }
    if (document.getElementById(id)['column17'] && column17 != 'null') {
        document.getElementById(id)['column17'].value= column17;
        document.getElementById(id)['column17'].checked= 'true' === column17.toLowerCase();
    }
    if (document.getElementById(id)['column18'] && column18 != 'null') {
        document.getElementById(id)['column18'].value= column18;
        document.getElementById(id)['column18'].checked= 'true' === column18.toLowerCase();
    }
    if (document.getElementById(id)['column19'] && column19 != 'null') {
        document.getElementById(id)['column19'].value= column19;
        document.getElementById(id)['column19'].checked= 'true' === column19.toLowerCase();
    }
    if (document.getElementById(id)['column20'] && column20 != 'null') {
        document.getElementById(id)['column20'].value= column20;
        document.getElementById(id)['column20'].checked= 'true' === column20.toLowerCase();
    }
}