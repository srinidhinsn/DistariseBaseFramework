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

function fillForm(id, column1, column2, column3, column4, column5, column6, column7, column8, column9, column10, column11,
                  column12, column13, column14, column15, column16, column17, column18, column19, column20) {
    if (document.getElementById(id)['column1']) {
        document.getElementById(id)['column1'].value= column1;
    }
    if (document.getElementById(id)['column2']) {
        document.getElementById(id)['column2'].value= column2;
    }
    if (document.getElementById(id)['column3']) {
        document.getElementById(id)['column3'].value= column3;
    }
    if (document.getElementById(id)['column4']) {
        document.getElementById(id)['column4'].value= column4;
    }
    if (document.getElementById(id)['column5']) {
        document.getElementById(id)['column5'].value= column5;
    }
    if (document.getElementById(id)['column6']) {
        document.getElementById(id)['column6'].value= column6;
    }
    if (document.getElementById(id)['column7']) {
        document.getElementById(id)['column7'].value= column7;
    }

    if (document.getElementById(id)['column8']) {
        document.getElementById(id)['column8'].value= column8;
    }
    if (document.getElementById(id)['column9']) {
        document.getElementById(id)['column9'].value= column9;
    }
    if (document.getElementById(id)['column10']) {
        document.getElementById(id)['column10'].value= column10;
    }
    if (document.getElementById(id)['column11']) {
        document.getElementById(id)['column11'].value= column11;
    }
    if (document.getElementById(id)['column12']) {
        document.getElementById(id)['column12'].value= column12;
    }
    if (document.getElementById(id)['column13']) {
        document.getElementById(id)['column13'].value= column13;
    }
    if (document.getElementById(id)['column14']) {
        document.getElementById(id)['column14'].value= column14;
    }
    if (document.getElementById(id)['column15']) {
        document.getElementById(id)['column15'].value= column15;
    }
    if (document.getElementById(id)['column16']) {
        document.getElementById(id)['column16'].value= column16;
    }
    if (document.getElementById(id)['column17']) {
        document.getElementById(id)['column17'].value= column17;
    }
    if (document.getElementById(id)['column18']) {
        document.getElementById(id)['column18'].value= column18;
    }
    if (document.getElementById(id)['column19']) {
        document.getElementById(id)['column19'].value= column19;
    }
    if (document.getElementById(id)['column20']) {
        document.getElementById(id)['column20'].value= column20;
    }
}