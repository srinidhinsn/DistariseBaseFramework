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
	VALUES ('checkboxsample', 'distarise', true, null, null, 'Checkbox (checkbox)', 4, 'checkbox', true, 'samples', true);

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

INSERT INTO component(id, clientid, editable, redirecturl, keyoraction, label, sortorder, type, visible, widgetid, multilevel)
    VALUES ('clientadd', 'distarise', true, '/nsn/distarise/base/addnavigation', 'com.distarise.base.action.SaveClientDetailsAction', 'Save', 6, 'submitbutton', true, 'addclient', false);

INSERT INTO component(id, clientid, editable, redirecturl, keyoraction, label, sortorder, type, visible, widgetid, multilevel)
    VALUES ('clientdelete', 'distarise', true, '/nsn/distarise/base/addnavigation', 'com.distarise.base.action.DeleteClientAction', 'Delete', 7, 'submitbutton', true, 'addclient', false);

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
VALUES ('column2', 'distarise', true, '', '', 'Id', 4, 'textbox', true, 'savewidget', false);

INSERT INTO component(id, clientid, editable, redirecturl, keyoraction, label, sortorder, type, visible, widgetid, multilevel)
VALUES ('column3', 'distarise', true, '', '', 'Title', 5, 'textbox', true, 'savewidget', false);

INSERT INTO component(id, clientid, editable, redirecturl, keyoraction, label, sortorder, type, visible, widgetid, multilevel)
VALUES ('column4', 'distarise', true, '', '', 'Sort order', 6, 'textbox', true, 'savewidget', false);

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
VALUES ('column2', 'distarise', true, '', '', 'Editable', 5, 'checkbox', true, 'savecomponent', true);

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
VALUES ('column9', 'distarise', true, '', '', 'Visibility', 11, 'checkbox', true, 'savecomponent', true);

INSERT INTO component(id, clientid, editable, redirecturl, keyoraction, label, sortorder, type, visible, widgetid, multilevel)
VALUES ('column10', 'distarise', true, '', '', 'Multi-level', 12, 'checkbox', true, 'savecomponent', true);

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
