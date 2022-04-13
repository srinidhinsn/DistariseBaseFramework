INSERT INTO component(id, clientid, editable, redirecturl, keyoraction, label, sortorder, type, visible, widgetid, multilevel)
	VALUES ('username', 'distarise', true, null, null, 'Username', 1, 'textbox', true, 'login', false);

INSERT INTO component(id, clientid, editable, redirecturl, keyoraction, label, sortorder, type, visible, widgetid, multilevel)
	VALUES ('password', 'distarise', true, null, null, 'Password', 2, 'password', true, 'login', false);

INSERT INTO component(id, clientid, editable, redirecturl, keyoraction, label, sortorder, type, visible, widgetid, multilevel)
	VALUES ('loginsubmit', 'distarise', true, '/nsn/distarise/base/home', 'com.distarise.base.action.LoginAction', 'Login', 3, 'submitbutton', true, 'login', false);

INSERT INTO component(id, clientid, editable, redirecturl, keyoraction, label, sortorder, type, visible, widgetid, multilevel, value)
	VALUES ('greetings', 'distarise', true, null, null, 'Welcome', 1, 'textarea', true, 'welcome', false, 'Welcome to the configuration');

INSERT INTO component(id, clientid, editable, redirecturl, keyoraction, label, sortorder, type, visible, widgetid, multilevel, value)
	VALUES ('introduction', 'distarise', true, null, null, 'Introduction', 2, 'textarea', true, 'welcome', false, 'This is web framework');

INSERT INTO component(id, clientid, editable, redirecturl, keyoraction, label, sortorder, type, visible, widgetid, multilevel, value)
	VALUES ('quality', 'distarise', true, null, null, 'Quality Deliverables', 2, 'textarea', true, 'qaassurance', false, 'Quality assurance is our goal');

INSERT INTO component(id, clientid, editable, redirecturl, keyoraction, label, sortorder, type, visible, widgetid, multilevel)
	VALUES ('textboxsample', 'distarise', true, null, null, 'Text Box (textbox)', 1, 'textbox', true, 'samples', false);


INSERT INTO component(id, clientid, editable, redirecturl, keyoraction, label, sortorder, type, visible, widgetid, multilevel, value)
	VALUES ('textareasample', 'distarise', true, null, null, 'Text Area (textarea)', 2, 'textarea', true, 'samples', false,'');


INSERT INTO component(id, clientid, editable, redirecturl, keyoraction, label, sortorder, type, visible, widgetid, multilevel)
	VALUES ('passwordsample', 'distarise', true, null, null, 'Password (password)', 3, 'password', true, 'samples', false);

INSERT INTO component(id, clientid, editable, redirecturl, keyoraction, label, sortorder, type, visible, widgetid, multilevel)
	VALUES ('checkboxsample', 'distarise', true, null, null, 'Checkbox (checkbox)', 4, 'checkbox', true, 'samples', false);

INSERT INTO component(id, clientid, editable, redirecturl, keyoraction, label, sortorder, type, visible, widgetid, multilevel)
	VALUES ('radiosample', 'distarise', true, null, null, 'Radio (radiobutton)', 5, 'radiobutton', true, 'samples', false);

INSERT INTO component(id, clientid, editable, redirecturl, keyoraction, label, sortorder, type, visible, widgetid, multilevel)
	VALUES ('dropdownsample', 'distarise', true, null, null, 'Dropdown (dropdown)', 6, 'dropdown', true, 'samples', false);

INSERT INTO component(id, clientid, editable, redirecturl, keyoraction, label, sortorder, type, visible, widgetid, multilevel)
	VALUES ('submitsample', 'distarise', true, '/nsn/distarise/base/home', 'com.distarise.base.action.DemoAction', 'Submit', 7, 'submitbutton', true, 'samples', false);


INSERT INTO component(id, clientid, editable, redirecturl, keyoraction, label, sortorder, type, visible, widgetid, multilevel)
	VALUES ('itemno', 'distarise', true, null, null, 'Invoice Number', 1, 'textbox', true, 'invoice', false);


INSERT INTO component(id, clientid, editable, redirecturl, keyoraction, label, sortorder, type, visible, widgetid, multilevel)
	VALUES ('quantity', 'distarise', true, null, null, 'Quantity', 2, 'textbox', true, 'invoice', false);


INSERT INTO component(id, clientid, editable, redirecturl, keyoraction, label, sortorder, type, visible, widgetid, multilevel)
	VALUES ('submitinvoice', 'distarise', true, '/nsn/distarise/base/invoice', 'com.distarise.base.action.DemoAction', 'Add', 3, 'submitbutton', true, 'invoice', false);


INSERT INTO component(id, clientid, editable, redirecturl, keyoraction, label, sortorder, type, visible, widgetid, multilevel)
	VALUES ('editinvoice', 'distarise', true, '/nsn/distarise/base/invoice', 'com.distarise.base.action.EditAction', 'Edit', 3, 'submitbutton', true, 'invoice', false);


INSERT INTO component(id, clientid, editable, redirecturl, keyoraction, label, sortorder, type, visible, widgetid, multilevel)
	VALUES ('loadAccountDetails', 'distarise', true, '/nsn/distarise/base/account', 'com.distarise.base.action.LoadProfileAction', 'Load account details', 0, 'autoaction', true, 'account', false);


INSERT INTO component(id, clientid, editable, redirecturl, keyoraction, label, sortorder, type, visible, widgetid, multilevel)
	VALUES ('firstname', 'distarise', true, null, null, 'Firstname', 1, 'text', true, 'account', false);


INSERT INTO component(id, clientid, editable, redirecturl, keyoraction, label, sortorder, type, visible, widgetid, multilevel)
	VALUES ('lastname', 'distarise', true, null, null, 'Lastname', 2, 'text', true, 'account', false);


INSERT INTO component(id, clientid, editable, redirecturl, keyoraction, label, sortorder, type, visible, widgetid, multilevel)
	VALUES ('role', 'distarise', true, null, null, 'Role', 3, 'text', true, 'account', false);


INSERT INTO component(id, clientid, editable, redirecturl, keyoraction, label, sortorder, type, visible, widgetid, multilevel)
	VALUES ('logout', 'distarise', true, '/nsn/distarise/base/login', 'com.distarise.base.action.LogoutAction', 'Logout', 4, 'submitbutton', true, 'account', false);

--Client add page

INSERT INTO component(id, clientid, editable, redirecturl, keyoraction, label, sortorder, type, visible, widgetid, multilevel)
    VALUES ('loadclientlist', 'distarise', true, '', 'com.distarise.base.action.LoadClientListAction', '', 0, 'autoaction', true, 'addclient', false);

INSERT INTO component(id, clientid, editable, redirecturl, keyoraction, label, sortorder, type, visible, widgetid, multilevel)
    VALUES ('clientlist', 'distarise', true, '/nsn/distarise/base/addclient', '', 'Clients', 1, 'configdropdown', true, 'addclient', true);

INSERT INTO component(id, clientid, editable, redirecturl, keyoraction, label, sortorder, type, visible, widgetid, multilevel)
    VALUES ('clientname', 'distarise', true, null, null, 'id', 2, 'textbox', true, 'addclient', false);

INSERT INTO component(id, clientid, editable, redirecturl, keyoraction, label, sortorder, type, visible, widgetid, multilevel)
    VALUES ('clientheader', 'distarise', true, null, null, 'Header', 3, 'textbox', true, 'addclient', false);

INSERT INTO component(id, clientid, editable, redirecturl, keyoraction, label, sortorder, type, visible, widgetid, multilevel)
    VALUES ('clientfooter', 'distarise', true, null, null, 'Footer', 4, 'textbox', true, 'addclient', false);

INSERT INTO component(id, clientid, editable, redirecturl, keyoraction, label, sortorder, type, visible, widgetid, multilevel)
    VALUES ('clientlogo', 'distarise', true, null, null, 'Logo file name', 5, 'textbox', true, 'addclient', false);

INSERT INTO component(id, clientid, editable, redirecturl, keyoraction, label, sortorder, type, visible, widgetid, multilevel, value)
    VALUES ('staticfolder', 'distarise', true, null, null, 'Static folder name', 6, 'textbox', true, 'addclient', false, 'distarise');

INSERT INTO component(id, clientid, editable, redirecturl, keyoraction, label, sortorder, type, visible, widgetid, multilevel)
    VALUES ('clientadd', 'distarise', true, '/nsn/distarise/base/addnavigation', 'com.distarise.base.action.SaveClientDetailsAction', 'Save', 7, 'submitbutton', true, 'addclient', false);

INSERT INTO component(id, clientid, editable, redirecturl, keyoraction, label, sortorder, type, visible, widgetid, multilevel)
    VALUES ('clientdelete', 'distarise', true, '/nsn/distarise/base/addnavigation', 'com.distarise.base.action.DeleteClientAction', 'Delete', 8, 'submitbutton', true, 'addclient', false);

--Navigation page

INSERT INTO component(id, clientid, editable, redirecturl, keyoraction, label, sortorder, type, visible, widgetid, multilevel)
    VALUES ('loadnavigationgrid', 'distarise', true, '', 'com.distarise.base.action.LoadNavigationsAction', '', 0, 'autoaction', true, 'addnavigation', false);

INSERT INTO component(id, clientid, editable, redirecturl, keyoraction, label, sortorder, type, visible, widgetid, multilevel)
    VALUES ('clientid', 'distarise', true, '', '', 'Client Id : ', 2, 'text', true, 'addnavigation', false);

INSERT INTO component(id, clientid, editable, redirecturl, keyoraction, label, sortorder, type, visible, widgetid, multilevel)
    VALUES ('navigationgrid', 'distarise', true, '', '', 'Landing pages', 3, 'gridform', true, 'addnavigation', true);

INSERT INTO component(id, clientid, editable, redirecturl, keyoraction, label, sortorder, type, visible, widgetid, multilevel)
    VALUES ('column1', 'distarise', true, '', '', 'Client Id : ', 2, 'hidden', false, 'savenavigation', false);

INSERT INTO component(id, clientid, editable, redirecturl, keyoraction, label, sortorder, type, visible, widgetid, multilevel)
    VALUES ('column2', 'distarise', true, '', '', 'Id', 3, 'textbox', true, 'savenavigation', false);

INSERT INTO component(id, clientid, editable, redirecturl, keyoraction, label, sortorder, type, visible, widgetid, multilevel)
    VALUES ('column3', 'distarise', true, '', '', 'Module', 4, 'textbox', true, 'savenavigation', false);

INSERT INTO component(id, clientid, editable, redirecturl, keyoraction, label, sortorder, type, visible, widgetid, multilevel)
    VALUES ('column4', 'distarise', true, '', '', 'Page description', 5, 'textbox', true, 'savenavigation', false);

INSERT INTO component(id, clientid, editable, redirecturl, keyoraction, label, sortorder, type, visible, widgetid, multilevel)
    VALUES ('column5', 'distarise', true, '', '', 'Page name', 6, 'textbox', true, 'savenavigation', false);

INSERT INTO component(id, clientid, editable, redirecturl, keyoraction, label, sortorder, type, visible, widgetid, multilevel)
    VALUES ('column6', 'distarise', true, '', '', 'Page title', 7, 'textbox', true, 'savenavigation', false);

INSERT INTO component(id, clientid, editable, redirecturl, keyoraction, label, sortorder, type, visible, widgetid, multilevel)
    VALUES ('column7', 'distarise', true, '', '', 'Redirect page name', 8, 'textbox', true, 'savenavigation', false);

INSERT INTO component(id, clientid, editable, redirecturl, keyoraction, label, sortorder, type, visible, widgetid, multilevel)
    VALUES ('column8', 'distarise', true, '', '', 'Role', 9, 'textbox', true, 'savenavigation', false);

INSERT INTO component(id, clientid, editable, redirecturl, keyoraction, label, sortorder, type, visible, widgetid, multilevel)
    VALUES ('navigationsave', 'distarise', true, '/nsn/distarise/base/addnavigation', 'com.distarise.base.action.SaveNavigationAction', 'Save', 10, 'submitbutton', true, 'savenavigation', false);


--Navigation item add page

INSERT INTO component(id, clientid, editable, redirecturl, keyoraction, label, sortorder, type, visible, widgetid, multilevel)
    VALUES ('loadlandingpages', 'distarise', true, '', 'com.distarise.base.action.LoadNavigationItemsAction', 'Client Id', 4, 'autoaction', true, 'addnavigationitem', false);

INSERT INTO component(id, clientid, editable, redirecturl, keyoraction, label, sortorder, type, visible, widgetid, multilevel)
    VALUES ('clientid', 'distarise', true, '', '', 'Client Id', 4, 'text', true, 'addnavigationitem', false);

INSERT INTO component(id, clientid, editable, redirecturl, keyoraction, label, sortorder, type, visible, widgetid, multilevel)
    VALUES ('landingpage', 'distarise', true, '/nsn/distarise/base/addnavigationitem', '', 'Landing page id', 5, 'configdropdown', true, 'addnavigationitem', true);

INSERT INTO component(id, clientid, editable, redirecturl, keyoraction, label, sortorder, type, visible, widgetid, multilevel)
    VALUES ('navigationitemgrid', 'distarise', true, '', '', 'Navigation items', 6, 'gridform', true, 'addnavigationitem', true);

INSERT INTO component(id, clientid, editable, redirecturl, keyoraction, label, sortorder, type, visible, widgetid, multilevel)
    VALUES ('column2', 'distarise', true, '', '', 'Navigation Id', 6, 'textbox', true, 'savenavigationitem', false);

INSERT INTO component(id, clientid, editable, redirecturl, keyoraction, label, sortorder, type, visible, widgetid, multilevel)
    VALUES ('column3', 'distarise', true, '', '', 'Navigation Name', 7, 'textbox', true, 'savenavigationitem', false);

INSERT INTO component(id, clientid, editable, redirecturl, keyoraction, label, sortorder, type, visible, widgetid, multilevel)
VALUES ('column4', 'distarise', true, '', '', 'Sort Order', 8, 'textbox', true, 'savenavigationitem', false);

INSERT INTO component(id, clientid, editable, redirecturl, keyoraction, label, sortorder, type, visible, widgetid, multilevel)
VALUES ('column5', 'distarise', true, '', '', 'URL', 9, 'textbox', true, 'savenavigationitem', false);

INSERT INTO component(id, clientid, editable, redirecturl, keyoraction, label, sortorder, type, visible, widgetid, multilevel)
VALUES ('column6', 'distarise', true, '', '', 'Layout id', 10, 'textbox', true, 'savenavigationitem', false);

INSERT INTO component(id, clientid, editable, redirecturl, keyoraction, label, sortorder, type, visible, widgetid, multilevel)
VALUES ('column7', 'distarise', true, '', '', 'Navigation item id', 11, 'textbox', true, 'savenavigationitem', false);

INSERT INTO component(id, clientid, editable, redirecturl, keyoraction, label, sortorder, type, visible, widgetid, multilevel)
VALUES ('column8', 'distarise', true, '', '', 'Client id', 12, 'hidden', false, 'savenavigationitem', false);

INSERT INTO component(id, clientid, editable, redirecturl, keyoraction, label, sortorder, type, visible, widgetid, multilevel)
VALUES ('column9', 'distarise', true, '', '', 'Ui Nav id', 12, 'hidden', false, 'savenavigationitem', false);

INSERT INTO component(id, clientid, editable, redirecturl, keyoraction, label, sortorder, type, visible, widgetid, multilevel)
VALUES ('savenavigationitem', 'distarise', true, '/nsn/distarise/base/addnavigationitem', 'com.distarise.base.action.SaveNavigationItemAction', 'Save', 13, 'submitbutton', true, 'savenavigationitem', false);

INSERT INTO component(id, clientid, editable, redirecturl, keyoraction, label, sortorder, type, visible, widgetid, multilevel)
VALUES ('logout', 'distarise', true, '/nsn/distarise/base/login', 'com.distarise.base.action.LogoutAction', 'Logout', 14, 'submitbutton', true, 'savenavigationitem', false);

--Widget add page

INSERT INTO component(id, clientid, editable, redirecturl, keyoraction, label, sortorder, type, visible, widgetid, multilevel)
VALUES ('loadlandingpages', 'distarise', true, '', 'com.distarise.base.action.LoadNavigationItemsAction', 'Client Id', 4, 'autoaction', true, 'addwidget', false);

INSERT INTO component(id, clientid, editable, redirecturl, keyoraction, label, sortorder, type, visible, widgetid, multilevel)
VALUES ('clientid', 'distarise', true, '', '', 'Client Id', 5, 'text', true, 'addwidget', false);

INSERT INTO component(id, clientid, editable, redirecturl, keyoraction, label, sortorder, type, visible, widgetid, multilevel)
VALUES ('landingpage', 'distarise', true, '/nsn/distarise/base/addwidget', '', 'Landing page id', 6, 'configdropdown', true, 'addwidget', true);

INSERT INTO component(id, clientid, editable, redirecturl, keyoraction, label, sortorder, type, visible, widgetid, multilevel)
VALUES ('navigationitemlist', 'distarise', true, '/nsn/distarise/base/addwidget', '', 'Navigation Items', 7, 'configdropdown', true, 'addwidget', true);

INSERT INTO component(id, clientid, editable, redirecturl, keyoraction, label, sortorder, type, visible, widgetid, multilevel)
VALUES ('widgetsgrid', 'distarise', true, '', '', 'Widgets List', 8, 'gridform', true, 'addwidget', true);

INSERT INTO component(id, clientid, editable, redirecturl, keyoraction, label, sortorder, type, visible, widgetid, multilevel)
VALUES ('column1', 'distarise', true, '', '', 'Id', 3, 'textbox', true, 'savewidget', false);

INSERT INTO component(id, clientid, editable, redirecturl, keyoraction, label, sortorder, type, visible, widgetid, multilevel)
VALUES ('column2', 'distarise', true, '', '', 'Title', 4, 'textbox', true, 'savewidget', false);

INSERT INTO component(id, clientid, editable, redirecturl, keyoraction, label, sortorder, type, visible, widgetid, multilevel)
VALUES ('column3', 'distarise', true, '', '', 'Sort order', 5, 'textbox', true, 'savewidget', false);

INSERT INTO component(id, clientid, editable, redirecturl, keyoraction, label, sortorder, type, visible, widgetid, multilevel)
VALUES ('column4', 'distarise', true, '', '', 'Redirect URL', 6, 'textbox', true, 'savewidget', false);

INSERT INTO component(id, clientid, editable, redirecturl, keyoraction, label, sortorder, type, visible, widgetid, multilevel)
VALUES ('column5', 'distarise', true, '', '', 'Navigation item id', 7, 'textbox', true, 'savewidget', false);

INSERT INTO component(id, clientid, editable, redirecturl, keyoraction, label, sortorder, type, visible, widgetid, multilevel)
VALUES ('column6', 'distarise', true, '', '', 'Nested widget id', 8, 'textbox', true, 'savewidget', false);

INSERT INTO component(id, clientid, editable, redirecturl, keyoraction, label, sortorder, type, visible, widgetid, multilevel)
VALUES ('column7', 'distarise', true, '', '', 'Layout id', 9, 'textbox', true, 'savewidget', false);

INSERT INTO component(id, clientid, editable, redirecturl, keyoraction, label, sortorder, type, visible, widgetid, multilevel)
VALUES ('column8', 'distarise', true, '', '', 'Css class', 10, 'textbox', true, 'savewidget', false);

INSERT INTO component(id, clientid, editable, redirecturl, keyoraction, label, sortorder, type, visible, widgetid, multilevel)
VALUES ('column9', 'distarise', true, '', '', 'client id', 10, 'hidden', false, 'savewidget', false);

INSERT INTO component(id, clientid, editable, redirecturl, keyoraction, label, sortorder, type, visible, widgetid, multilevel)
VALUES ('column10', 'distarise', true, '', '', 'ui nav id', 10, 'hidden', false, 'savewidget', false);

INSERT INTO component(id, clientid, editable, redirecturl, keyoraction, label, sortorder, type, visible, widgetid, multilevel)
VALUES ('column11', 'distarise', true, '', '', 'ui nav item', 10, 'hidden', false, 'savewidget', false);

INSERT INTO component(id, clientid, editable, redirecturl, keyoraction, label, sortorder, type, visible, widgetid, multilevel)
VALUES ('savewidget', 'distarise', true, '/nsn/distarise/base/addwidget', 'com.distarise.base.action.SaveWidgetAction', 'Save', 11, 'submitbutton', true, 'savewidget', false);

--Component add page

INSERT INTO component(id, clientid, editable, redirecturl, keyoraction, label, sortorder, type, visible, widgetid, multilevel)
VALUES ('loadlandingpages', 'distarise', true, '', 'com.distarise.base.action.LoadNavigationItemsAction', 'Client Id', 4, 'autoaction', true, 'addcomponent', false);

INSERT INTO component(id, clientid, editable, redirecturl, keyoraction, label, sortorder, type, visible, widgetid, multilevel)
VALUES ('clientid', 'distarise', true, '', '', 'Client Id', 4, 'text', true, 'addcomponent', false);

INSERT INTO component(id, clientid, editable, redirecturl, keyoraction, label, sortorder, type, visible, widgetid, multilevel)
VALUES ('landingpage', 'distarise', true, '/nsn/distarise/base/addcomponent', '', 'Landing page id', 5, 'configdropdown', true, 'addcomponent', true);

INSERT INTO component(id, clientid, editable, redirecturl, keyoraction, label, sortorder, type, visible, widgetid, multilevel)
VALUES ('navigationitemlist', 'distarise', true, '/nsn/distarise/base/addcomponent', '', 'Navigation Items', 6, 'configdropdown', true, 'addcomponent', true);

INSERT INTO component(id, clientid, editable, redirecturl, keyoraction, label, sortorder, type, visible, widgetid, multilevel)
VALUES ('widgetlist', 'distarise', true, '/nsn/distarise/base/addcomponent', '', 'Widgets', 7, 'configdropdown', true, 'addcomponent', true);

INSERT INTO component(id, clientid, editable, redirecturl, keyoraction, label, sortorder, type, visible, widgetid, multilevel)
VALUES ('componentgrid', 'distarise', true, '', '', 'Widgets List', 8, 'gridform', true, 'addcomponent', true);

INSERT INTO component(id, clientid, editable, redirecturl, keyoraction, label, sortorder, type, visible, widgetid, multilevel)
VALUES ('column1', 'distarise', true, '', '', 'Id', 4, 'textbox', true, 'savecomponent', false);

INSERT INTO component(id, clientid, editable, redirecturl, keyoraction, label, sortorder, type, visible, widgetid, multilevel)
VALUES ('column2', 'distarise', true, '', '', 'Editable', 5, 'checkbox', true, 'savecomponent', false);

INSERT INTO component(id, clientid, editable, redirecturl, keyoraction, label, sortorder, type, visible, widgetid, multilevel)
VALUES ('column3', 'distarise', true, '', '', 'Label', 6, 'textbox', true, 'savecomponent', false);

INSERT INTO component(id, clientid, editable, redirecturl, keyoraction, label, sortorder, type, visible, widgetid, multilevel)
VALUES ('column4', 'distarise', true, '', '', 'Value', 6, 'textarea', true, 'savecomponent', false);

INSERT INTO component(id, clientid, editable, redirecturl, keyoraction, label, sortorder, type, visible, widgetid, multilevel)
VALUES ('column5', 'distarise', true, '', '', 'Key Or Action', 7, 'textbox', true, 'savecomponent', false);

INSERT INTO component(id, clientid, editable, redirecturl, keyoraction, label, sortorder, type, visible, widgetid, multilevel)
VALUES ('column6', 'distarise', true, '', '', 'Redirect URL', 8, 'textbox', true, 'savecomponent', false);

INSERT INTO component(id, clientid, editable, redirecturl, keyoraction, label, sortorder, type, visible, widgetid, multilevel)
VALUES ('column7', 'distarise', true, '', '', 'Sort order', 9, 'textbox', true, 'savecomponent', false);

INSERT INTO component(id, clientid, editable, redirecturl, keyoraction, label, sortorder, type, visible, widgetid, multilevel)
VALUES ('column8', 'distarise', true, '', '', 'Type', 10, 'textbox', true, 'savecomponent', false);

INSERT INTO component(id, clientid, editable, redirecturl, keyoraction, label, sortorder, type, visible, widgetid, multilevel)
VALUES ('column9', 'distarise', true, '', '', 'Visibility', 11, 'checkbox', true, 'savecomponent', false);

INSERT INTO component(id, clientid, editable, redirecturl, keyoraction, label, sortorder, type, visible, widgetid, multilevel)
VALUES ('column10', 'distarise', true, '', '', 'Multi-level', 12, 'checkbox', true, 'savecomponent', false);

INSERT INTO component(id, clientid, editable, redirecturl, keyoraction, label, sortorder, type, visible, widgetid, multilevel)
VALUES ('column11', 'distarise', true, '', '', 'Widget id', 13, 'textbox', true, 'savecomponent', false);

INSERT INTO component(id, clientid, editable, redirecturl, keyoraction, label, sortorder, type, visible, widgetid, multilevel)
VALUES ('column12', 'distarise', true, '', '', 'client id', 13, 'hidden', false, 'savecomponent', false);

INSERT INTO component(id, clientid, editable, redirecturl, keyoraction, label, sortorder, type, visible, widgetid, multilevel)
VALUES ('column13', 'distarise', true, '', '', 'ui nav id', 13, 'hidden', false, 'savecomponent', false);

INSERT INTO component(id, clientid, editable, redirecturl, keyoraction, label, sortorder, type, visible, widgetid, multilevel)
VALUES ('column14', 'distarise', true, '', '', 'ui nav item id', 13, 'hidden', false, 'savecomponent', false);

INSERT INTO component(id, clientid, editable, redirecturl, keyoraction, label, sortorder, type, visible, widgetid, multilevel)
VALUES ('savecomponent', 'distarise', true, '/nsn/distarise/base/addcomponent', 'com.distarise.base.action.SaveComponentAction', 'Save', 14, 'submitbutton', true, 'savecomponent', false);

INSERT INTO component(id, clientid, editable, redirecturl, keyoraction, label, sortorder, type, visible, widgetid, multilevel)
VALUES ('loadlandingpages', 'distarise', true, '', 'com.distarise.base.action.LoadNavigationItemsAction', 'Client Id', 4, 'autoaction', true, 'addcomponentitem', false);

INSERT INTO component(id, clientid, editable, redirecturl, keyoraction, label, sortorder, type, visible, widgetid, multilevel)
VALUES ('clientid', 'distarise', true, '', '', 'Client Id', 2, 'text', true, 'addcomponentitem', false);

INSERT INTO component(id, clientid, editable, redirecturl, keyoraction, label, sortorder, type, visible, widgetid, multilevel)
VALUES ('landingpage', 'distarise', true, '/nsn/distarise/base/addcomponentitem', '', 'Landing page id', 3, 'configdropdown', true, 'addcomponentitem', true);

INSERT INTO component(id, clientid, editable, redirecturl, keyoraction, label, sortorder, type, visible, widgetid, multilevel)
VALUES ('navigationitemlist', 'distarise', true, '/nsn/distarise/base/addcomponentitem', '', 'Navigation Items', 4, 'configdropdown', true, 'addcomponentitem', true);

INSERT INTO component(id, clientid, editable, redirecturl, keyoraction, label, sortorder, type, visible, widgetid, multilevel)
VALUES ('widgetlist', 'distarise', true, '/nsn/distarise/base/addcomponentitem', '', 'Widgets', 5, 'configdropdown', true, 'addcomponentitem', true);

INSERT INTO component(id, clientid, editable, redirecturl, keyoraction, label, sortorder, type, visible, widgetid, multilevel)
VALUES ('componentlist', 'distarise', true, '/nsn/distarise/base/addcomponentitem', '', 'Multilevel Components', 6, 'configdropdown', true, 'addcomponentitem', true);

INSERT INTO component(id, clientid, editable, redirecturl, keyoraction, label, sortorder, type, visible, widgetid, multilevel)
VALUES ('componentitemgrid', 'distarise', true, '', '', 'Multilevel Components', 7, 'gridform', true, 'addcomponentitem', true);

INSERT INTO component(id, clientid, editable, redirecturl, keyoraction, label, sortorder, type, visible, widgetid, multilevel)
VALUES ('column2', 'distarise', true, '', '', 'clientid', 5, 'hidden', false, 'savecomponentitem', false);

INSERT INTO component(id, clientid, editable, redirecturl, keyoraction, label, sortorder, type, visible, widgetid, multilevel)
VALUES ('column3', 'distarise', true, '', '', 'componentid', 5, 'hidden', false, 'savecomponentitem', false);

INSERT INTO component(id, clientid, editable, redirecturl, keyoraction, label, sortorder, type, visible, widgetid, multilevel)
VALUES ('column4', 'distarise', true, '', '', 'Id', 5, 'textbox', true, 'savecomponentitem', false);

INSERT INTO component(id, clientid, editable, redirecturl, keyoraction, label, sortorder, type, visible, widgetid, multilevel)
VALUES ('column5', 'distarise', true, '', '', 'Editable', 6, 'checkbox', true, 'savecomponentitem', false);

INSERT INTO component(id, clientid, editable, redirecturl, keyoraction, label, sortorder, type, visible, widgetid, multilevel)
VALUES ('column6', 'distarise', true, '', '', 'Label', 5, 'textbox', true, 'savecomponentitem', false);

INSERT INTO component(id, clientid, editable, redirecturl, keyoraction, label, sortorder, type, visible, widgetid, multilevel)
VALUES ('column7', 'distarise', true, '', '', 'Sort order', 6, 'textbox', true, 'savecomponentitem', false);

INSERT INTO component(id, clientid, editable, redirecturl, keyoraction, label, sortorder, type, visible, widgetid, multilevel)
VALUES ('column8', 'distarise', true, '', '', 'Value', 7, 'textbox', true, 'savecomponentitem', false);

INSERT INTO component(id, clientid, editable, redirecturl, keyoraction, label, sortorder, type, visible, widgetid, multilevel)
VALUES ('column9', 'distarise', true, '', '', 'Visibility', 8, 'checkbox', true, 'savecomponentitem', false);

INSERT INTO component(id, clientid, editable, redirecturl, keyoraction, label, sortorder, type, visible, widgetid, multilevel)
VALUES ('savecomponentitem', 'distarise', true, '/nsn/distarise/base/addcomponentitem', 'com.distarise.base.action.SaveComponentItemAction', 'Save', 8, 'submitbutton', true, 'savecomponentitem', false);

INSERT INTO component(id, clientid, editable, redirecturl, keyoraction, label, sortorder, type, visible, widgetid, multilevel)
VALUES ('loadrolelist', 'distarise', true, '/nsn/distarise/userrole/addrole', 'com.distarise.base.action.LoadRoleListAction', 'Role list', 2, 'autoaction', true, 'addrole', true);

INSERT INTO component(id, clientid, editable, redirecturl, keyoraction, label, sortorder, type, visible, widgetid, multilevel)
VALUES ('clientlist', 'distarise', true, '', '', 'Client Id', 1, 'configdropdown', true, 'addrole', true);

INSERT INTO component(id, clientid, editable, redirecturl, keyoraction, label, sortorder, type, visible, widgetid, multilevel)
VALUES ('rolelist', 'distarise', true, '', '', 'Roles', 2, 'configdropdown', true, 'addrole', true);

INSERT INTO component(id, clientid, editable, redirecturl, keyoraction, label, sortorder, type, visible, widgetid, multilevel)
VALUES ('rolename', 'distarise', true, '', '', 'Role name', 3, 'textbox', true, 'addrole', false);

INSERT INTO component(id, clientid, editable, redirecturl, keyoraction, label, sortorder, type, visible, widgetid, multilevel)
VALUES ('roledescription', 'distarise', true, '', '', 'Role Description', 4, 'textbox', true, 'addrole', false);

INSERT INTO component(id, clientid, editable, redirecturl, keyoraction, label, sortorder, type, visible, widgetid, multilevel, value)
VALUES ('uinav', 'distarise', true, '', '', 'Landing page details', 5, 'text', true, 'addrole', false, '');

INSERT INTO component(id, clientid, editable, redirecturl, keyoraction, label, sortorder, type, visible, widgetid, multilevel, value)
VALUES ('uinavid', 'distarise', false, '', '', 'Loading page', 6, 'textbox', true, 'addrole', false, 'adminlogin');

INSERT INTO component(id, clientid, editable, redirecturl, keyoraction, label, sortorder, type, visible, widgetid, multilevel, value)
VALUES ('module', 'distarise', false, '', '', 'Module', 7, 'textbox', true, 'addrole', false, 'customer');

INSERT INTO component(id, clientid, editable, redirecturl, keyoraction, label, sortorder, type, visible, widgetid, multilevel, value)
VALUES ('redirectpage', 'distarise', false, '', '', 'Landing page', 8, 'textbox', true, 'addrole', false, 'addcustomer');

INSERT INTO component(id, clientid, editable, redirecturl, keyoraction, label, sortorder, type, visible, widgetid, multilevel)
VALUES ('saverole', 'distarise', true, '/nsn/distarise/userrole/addrole', 'com.distarise.base.action.SaveRoleAction', 'Save', 9, 'submitbutton', true, 'addrole', false);

INSERT INTO component(id, clientid, editable, redirecturl, keyoraction, label, sortorder, type, visible, widgetid, multilevel)
VALUES ('loadrolelist', 'distarise', true, '/nsn/distarise/userrole/addroleaccess', 'com.distarise.base.action.LoadRoleAccessListAction', 'Role list', 2, 'autoaction', true, 'addroleaccess', false);

INSERT INTO component(id, clientid, editable, redirecturl, keyoraction, label, sortorder, type, visible, widgetid, multilevel)
VALUES ('clientlist', 'distarise', true, '', '', 'Client Id', 1, 'configdropdown', true, 'addroleaccess', true);

INSERT INTO component(id, clientid, editable, redirecturl, keyoraction, label, sortorder, type, visible, widgetid, multilevel)
VALUES ('rolelist', 'distarise', true, '', '', 'Roles', 2, 'configdropdown', true, 'addroleaccess', true);

INSERT INTO component(id, clientid, editable, redirecturl, keyoraction, label, sortorder, type, visible, widgetid, multilevel)
VALUES ('roleaccessgrid', 'distarise', true, '', 'com.distarise.base.action.SaveRoleAccessAction', 'Role Access list', 3, 'roleaccessform', true, 'addroleaccess', true);

INSERT INTO component(id, clientid, editable, redirecturl, keyoraction, label, sortorder, type, visible, widgetid, multilevel)
VALUES ('loaduserdetailsgrid', 'distarise', true, '', 'com.distarise.base.action.LoadUserDetailsAction', 'loaduserdetails', 2, 'autoaction', true, 'adduser', false);

INSERT INTO component(id, clientid, editable, redirecturl, keyoraction, label, sortorder, type, visible, widgetid, multilevel)
VALUES ('clientlist', 'distarise', true, '', '', 'Client id : ', 2, 'configdropdown', true, 'adduser', true);

INSERT INTO component(id, clientid, editable, redirecturl, keyoraction, label, sortorder, type, visible, widgetid, multilevel)
VALUES ('userdetailsgrid', 'distarise', true, '', '', 'User Details', 3, 'gridform', true, 'adduser', true);

INSERT INTO component(id, clientid, editable, redirecturl, keyoraction, label, sortorder, type, visible, widgetid, multilevel)
VALUES ('column1', 'distarise', true, '', '', 'Title', 1, 'dropdown', true, 'saveuser', true);

INSERT INTO component(id, clientid, editable, redirecturl, keyoraction, label, sortorder, type, visible, widgetid, multilevel)
VALUES ('column2', 'distarise', true, '', '', 'Username', 2, 'textbox', true, 'saveuser', false);

INSERT INTO component(id, clientid, editable, redirecturl, keyoraction, label, sortorder, type, visible, widgetid, multilevel)
VALUES ('column3', 'distarise', true, '', '', 'First name', 3, 'textbox', true, 'saveuser', false);

INSERT INTO component(id, clientid, editable, redirecturl, keyoraction, label, sortorder, type, visible, widgetid, multilevel)
VALUES ('column4', 'distarise', true, '', '', 'Last name', 4, 'textbox', true, 'saveuser', false);

INSERT INTO component(id, clientid, editable, redirecturl, keyoraction, label, sortorder, type, visible, widgetid, multilevel)
VALUES ('column5', 'distarise', true, '', '', 'Password', 5, 'password', false, 'saveuser', false);

INSERT INTO component(id, clientid, editable, redirecturl, keyoraction, label, sortorder, type, visible, widgetid, multilevel)
VALUES ('column6', 'distarise', true, '', '', 'Role', 6, 'dropdown', true, 'saveuser', false);

INSERT INTO component(id, clientid, editable, redirecturl, keyoraction, label, sortorder, type, visible, widgetid, multilevel)
VALUES ('saveuserdetails', 'distarise', true, '/nsn/distarise/userrole/adduser', 'com.distarise.base.action.SaveUserDetailsAction', 'Save', 7, 'submitbutton', true, 'saveuser', false);


-- Dista bank project scripts


INSERT INTO component(id, clientid, editable, redirecturl, keyoraction, label, sortorder, type, visible, widgetid, multilevel)
VALUES ('username', 'distabank', true, '', '', 'Username', 1, 'textbox', true, 'login', false);

INSERT INTO component(id, clientid, editable, redirecturl, keyoraction, label, sortorder, type, visible, widgetid, multilevel)
VALUES ('password', 'distabank', true, '', '', 'Password', 2, 'password', true, 'login', false);

INSERT INTO component(id, clientid, editable, redirecturl, keyoraction, label, sortorder, type, visible, widgetid, multilevel)
VALUES ('login', 'distabank', true, '/nsn/distabank/bank/addcustomer', 'com.distarise.base.action.LoginAction', 'Login', 3, 'submitbutton', true, 'login', false);

-- distabank customer page

INSERT INTO component(id, clientid, editable, redirecturl, keyoraction, label, sortorder, type, visible, widgetid, multilevel)
VALUES ('firstname', 'distabank', true, '', '', 'First Name', 5, 'textbox', true, 'addcustomer', false);

INSERT INTO component(id, clientid, editable, redirecturl, keyoraction, label, sortorder, type, visible, widgetid, multilevel)
VALUES ('lastname', 'distabank', true, '', '', 'Last Name', 6, 'textbox', true, 'addcustomer', false);

INSERT INTO component(id, clientid, editable, redirecturl, keyoraction, label, sortorder, type, visible, widgetid, multilevel)
VALUES ('dob', 'distabank', true, '', '', 'Date of birth', 7, 'datepicker', true, 'addcustomer', false);

INSERT INTO component(id, clientid, editable, redirecturl, keyoraction, label, sortorder, type, visible, widgetid, multilevel)
VALUES ('gender', 'distabank', true, '', '', 'Gender', 8, 'radiobutton', true, 'addcustomer', true);

INSERT INTO component(id, clientid, editable, redirecturl, keyoraction, label, sortorder, type, visible, widgetid, multilevel)
VALUES ('addressline1', 'distabank', true, '', '', 'Address Line1', 9, 'textbox', true, 'addcustomer', false);

INSERT INTO component(id, clientid, editable, redirecturl, keyoraction, label, sortorder, type, visible, widgetid, multilevel)
VALUES ('addressline2', 'distabank', true, '', '', 'Address Line2', 10, 'textbox', true, 'addcustomer', false);

INSERT INTO component(id, clientid, editable, redirecturl, keyoraction, label, sortorder, type, visible, widgetid, multilevel)
VALUES ('city', 'distabank', true, '', '', 'City', 11, 'textbox', true, 'addcustomer', false);

INSERT INTO component(id, clientid, editable, redirecturl, keyoraction, label, sortorder, type, visible, widgetid, multilevel)
VALUES ('state', 'distabank', true, '', '', 'State', 12, 'textbox', true, 'addcustomer', false);

INSERT INTO component(id, clientid, editable, redirecturl, keyoraction, label, sortorder, type, visible, widgetid, multilevel)
VALUES ('country', 'distabank', true, '', '', 'Country', 13, 'textbox', true, 'addcustomer', false);

INSERT INTO component(id, clientid, editable, redirecturl, keyoraction, label, sortorder, type, visible, widgetid, multilevel)
VALUES ('pincode', 'distabank', true, '', '', 'Pin code', 14, 'textbox', true, 'addcustomer', false);

INSERT INTO component(id, clientid, editable, redirecturl, keyoraction, label, sortorder, type, visible, widgetid, multilevel)
VALUES ('phone', 'distabank', true, '', '', 'Mobile', 15, 'textbox', true, 'addcustomer', false);

INSERT INTO component(id, clientid, editable, redirecturl, keyoraction, label, sortorder, type, visible, widgetid, multilevel)
VALUES ('savecustomer', 'distabank', true, '', 'com.distarise.distabank.customer.action.SaveCustomerAction', 'Save', 20, 'submitbutton', true, 'addcustomer', false);


-- distabank view customer


INSERT INTO component(id, clientid, editable, redirecturl, keyoraction, label, sortorder, type, visible, widgetid, multilevel)
VALUES ('loadcustomer', 'distabank', false, '', 'com.distarise.distabank.customer.action.LoadCustomerAction', 'Customer Id', 1, 'autoaction', true, 'customer', false);

INSERT INTO component(id, clientid, editable, redirecturl, keyoraction, label, sortorder, type, visible, widgetid, multilevel)
VALUES ('customerid', 'distabank', false, '', '', 'Customer Id', 4, 'textbox', true, 'customer', false);

INSERT INTO component(id, clientid, editable, redirecturl, keyoraction, label, sortorder, type, visible, widgetid, multilevel)
VALUES ('firstname', 'distabank', true, '', '', 'First Name', 5, 'textbox', true, 'customer', false);

INSERT INTO component(id, clientid, editable, redirecturl, keyoraction, label, sortorder, type, visible, widgetid, multilevel)
VALUES ('lastname', 'distabank', true, '', '', 'Last Name', 6, 'textbox', true, 'customer', false);

INSERT INTO component(id, clientid, editable, redirecturl, keyoraction, label, sortorder, type, visible, widgetid, multilevel)
VALUES ('dob', 'distabank', true, '', '', 'Date of birth', 7, 'datepicker', true, 'customer', false);

INSERT INTO component(id, clientid, editable, redirecturl, keyoraction, label, sortorder, type, visible, widgetid, multilevel)
VALUES ('gender', 'distabank', true, '', '', 'Gender', 8, 'radiobutton', true, 'customer', true);

INSERT INTO component(id, clientid, editable, redirecturl, keyoraction, label, sortorder, type, visible, widgetid, multilevel)
VALUES ('addressline1', 'distabank', true, '', '', 'Address Line1', 9, 'textbox', true, 'customer', false);

INSERT INTO component(id, clientid, editable, redirecturl, keyoraction, label, sortorder, type, visible, widgetid, multilevel)
VALUES ('addressline2', 'distabank', true, '', '', 'Address Line2', 10, 'textbox', true, 'customer', false);

INSERT INTO component(id, clientid, editable, redirecturl, keyoraction, label, sortorder, type, visible, widgetid, multilevel)
VALUES ('city', 'distabank', true, '', '', 'City', 11, 'textbox', true, 'customer', false);

INSERT INTO component(id, clientid, editable, redirecturl, keyoraction, label, sortorder, type, visible, widgetid, multilevel)
VALUES ('state', 'distabank', true, '', '', 'State', 12, 'textbox', true, 'customer', false);

INSERT INTO component(id, clientid, editable, redirecturl, keyoraction, label, sortorder, type, visible, widgetid, multilevel)
VALUES ('country', 'distabank', true, '', '', 'Country', 13, 'textbox', true, 'customer', false);

INSERT INTO component(id, clientid, editable, redirecturl, keyoraction, label, sortorder, type, visible, widgetid, multilevel)
VALUES ('pincode', 'distabank', true, '', '', 'Pin code', 14, 'textbox', true, 'customer', false);

INSERT INTO component(id, clientid, editable, redirecturl, keyoraction, label, sortorder, type, visible, widgetid, multilevel)
VALUES ('phone', 'distabank', true, '', '', 'Mobile', 15, 'number', true, 'customer', false);

INSERT INTO component(id, clientid, editable, redirecturl, keyoraction, label, sortorder, type, visible, widgetid, multilevel, value)
VALUES ('active', 'distabank', true, '', '', 'Active', 16, 'checkbox', true, 'customer', false, true);

INSERT INTO component(id, clientid, editable, redirecturl, keyoraction, label, sortorder, type, visible, widgetid, multilevel)
VALUES ('savecustomer', 'distabank', true, '', 'com.distarise.distabank.customer.action.SaveCustomerAction', 'Save', 20, 'submitbutton', true, 'customer', false);

-- distabank Profile page

INSERT INTO component(id, clientid, editable, redirecturl, keyoraction, label, sortorder, type, visible, widgetid, multilevel)
VALUES ('logout', 'distabank', true, '', 'com.distarise.base.action.LogoutAction', 'Logout', 1, 'submitbutton', true, 'profile', false);

-- distabank Management FD config page

INSERT INTO component(id, clientid, editable, redirecturl, keyoraction, label, sortorder, type, visible, widgetid, multilevel)
VALUES ('loadfdconfig', 'distabank', true, '', 'com.distarise.distabank.deposit.action.LoadFdConfigAction', 'loadfdconfig', 1, 'autoaction', false, 'fdconfig', false);

INSERT INTO component(id, clientid, editable, redirecturl, keyoraction, label, sortorder, type, visible, widgetid, multilevel)
VALUES ('fdconfigid', 'distabank', true, '', '', 'id', 3, 'hidden', false, 'fdconfig', false);

INSERT INTO component(id, clientid, editable, redirecturl, keyoraction, label, sortorder, type, visible, widgetid, multilevel)
VALUES ('validfrom', 'distabank', true, '/nsn/distabank/management/fdconfig', 'com.distarise.distabank.deposit.action.LoadFdConfigAction', 'Valid from', 3, 'configdropdown', true, 'fdconfig', true);

INSERT INTO component(id, clientid, editable, redirecturl, keyoraction, label, sortorder, type, visible, widgetid, multilevel)
VALUES ('roi', 'distabank', true, '', '', 'FD interest rate', 4, 'number', true, 'fdconfig', false);

INSERT INTO component(id, clientid, editable, redirecturl, keyoraction, label, sortorder, type, visible, widgetid, multilevel)
VALUES ('calcmethod', 'distabank', true, '', '', 'Calculation method', 5, 'dropdown', true, 'fdconfig', true);

INSERT INTO component(id, clientid, editable, redirecturl, keyoraction, label, sortorder, type, visible, widgetid, multilevel)
VALUES ('calcfrequency', 'distabank', true, '', '', 'Calculation frequency', 6, 'dropdown', true, 'fdconfig', true);

INSERT INTO component(id, clientid, editable, redirecturl, keyoraction, label, sortorder, type, visible, widgetid, multilevel)
VALUES ('minduration', 'distabank', true, '', '', 'Minimum duration (months)', 7, 'number', true, 'fdconfig', false);

INSERT INTO component(id, clientid, editable, redirecturl, keyoraction, label, sortorder, type, visible, widgetid, multilevel)
VALUES ('effectivedate', 'distabank', true, '', '', 'Effective from', 8, 'datepicker', true, 'fdconfig', false);

INSERT INTO component(id, clientid, editable, redirecturl, keyoraction, label, sortorder, type, visible, widgetid, multilevel)
VALUES ('deviation', 'distabank', true, '', '', 'Maturity value deviation', 9, 'number', true, 'fdconfig', false);

INSERT INTO component(id, clientid, editable, redirecturl, keyoraction, label, sortorder, type, visible, widgetid, multilevel)
VALUES ('savefbconfig', 'distabank', true, '', 'com.distarise.distabank.deposit.action.SaveFdConfigAction', 'Save', 10, 'submitbutton', true, 'fdconfig', false);


-- dista bank fd page

INSERT INTO component(id, clientid, editable, redirecturl, keyoraction, label, sortorder, type, visible, widgetid, multilevel)
VALUES ('loadfd', 'distabank', false, '', 'com.distarise.distabank.deposit.action.LoadFdAction', 'Customer Id', 3, 'autoaction', false, 'fd', false);

INSERT INTO component(id, clientid, editable, redirecturl, keyoraction, label, sortorder, type, visible, widgetid, multilevel)
VALUES ('fdlist', 'distabank', false, '', '', 'Fixed deposits', 3, 'configdropdown', true, 'fd', true);

INSERT INTO component(id, clientid, editable, redirecturl, keyoraction, label, sortorder, type, visible, widgetid, multilevel)
VALUES ('customerid', 'distabank', false, '', '', 'Customer Id', 4, 'textbox', true, 'fd', false);

INSERT INTO component(id, clientid, editable, redirecturl, keyoraction, label, sortorder, type, visible, widgetid, multilevel)
VALUES ('accountno', 'distabank', false, '', '', 'FD account no', 5, 'textbox', true, 'fd', false);

INSERT INTO component(id, clientid, editable, redirecturl, keyoraction, label, sortorder, type, visible, widgetid, multilevel)
VALUES ('customername', 'distabank', true, '', '', 'Customer name', 6, 'textbox', true, 'fd', false);

INSERT INTO component(id, clientid, editable, redirecturl, keyoraction, label, sortorder, type, visible, widgetid, multilevel)
VALUES ('startdate', 'distabank', true, '', '', 'Start date', 7, 'datepicker', true, 'fd', false);

INSERT INTO component(id, clientid, editable, redirecturl, keyoraction, label, sortorder, type, visible, widgetid, multilevel)
VALUES ('maturitydate', 'distabank', true, '', '', 'Maturity date', 8, 'datepicker', true, 'fd', false);

INSERT INTO component(id, clientid, editable, redirecturl, keyoraction, label, sortorder, type, visible, widgetid, multilevel)
VALUES ('roi', 'distabank', true, '', '', 'Rate of interest', 9, 'number', true, 'fd', false);

INSERT INTO component(id, clientid, editable, redirecturl, keyoraction, label, sortorder, type, visible, widgetid, multilevel)
VALUES ('calcmethod', 'distabank', false, '', '', 'Calculation method', 10, 'textbox', true, 'fd', true);

INSERT INTO component(id, clientid, editable, redirecturl, keyoraction, label, sortorder, type, visible, widgetid, multilevel)
VALUES ('calcfrequency', 'distabank', false, '', '', 'Calculation Frequency', 11, 'textbox', true, 'fd', true);

INSERT INTO component(id, clientid, editable, redirecturl, keyoraction, label, sortorder, type, visible, widgetid, multilevel)
VALUES ('amount', 'distabank', true, '', '', 'Amount', 12, 'number', true, 'fd', true);

INSERT INTO component(id, clientid, editable, redirecturl, keyoraction, label, sortorder, type, visible, widgetid, multilevel)
VALUES ('maturityvalue', 'distabank', false, '', '', 'Maturity value', 13, 'number', true, 'fd', true);

INSERT INTO component(id, clientid, editable, redirecturl, keyoraction, label, sortorder, type, visible, widgetid, multilevel)
VALUES ('referencecode', 'distabank', true, '', '', 'Reference Code', 14, 'textbox', true, 'fd', true);

INSERT INTO component(id, clientid, editable, redirecturl, keyoraction, label, sortorder, type, visible, widgetid, multilevel, value)
VALUES ('notes', 'distabank', false, '', '', 'Note', 15, 'text', true, 'fd', true, 'Changes to roi goes for approval');

INSERT INTO component(id, clientid, editable, redirecturl, keyoraction, label, sortorder, type, visible, widgetid, multilevel)
VALUES ('calculatefd', 'distabank', true, '', 'javascript:calcMaturityValue(''fd'')', 'Calculate', 19, 'button', true, 'fd', false);

INSERT INTO component(id, clientid, editable, redirecturl, keyoraction, label, sortorder, type, visible, widgetid, multilevel)
VALUES ('savefd', 'distabank', true, '', 'com.distarise.distabank.deposit.action.SaveFdAction', 'Save', 20, 'submitbutton', true, 'fd', false);

-- distabank search result

INSERT INTO component(id, clientid, editable, redirecturl, keyoraction, label, sortorder, type, visible, widgetid, multilevel)
VALUES ('customergrid', 'distabank', true, '', 'com.distarise.distabank.customer.action.LoadCustomerAction', 'Customer search', 1, 'customergrid', true, 'searchresult', true);
