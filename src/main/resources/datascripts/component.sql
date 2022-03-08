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
    VALUES ('clientlist', 'distarise', true, '/nsn/distarise/base/addclient', '', 'Clients', 1, 'configdropdown.html', true, 'addclient', true);

INSERT INTO component(id, clientid, editable, redirecturl, keyoraction, label, sortorder, type, visible, widgetid, multilevel)
    VALUES ('clientname', 'distarise', true, null, null, 'Client name', 2, 'textbox', true, 'addclient', false);

INSERT INTO component(id, clientid, editable, redirecturl, keyoraction, label, sortorder, type, visible, widgetid, multilevel)
    VALUES ('clientheader', 'distarise', true, null, null, 'Header', 3, 'textbox', true, 'addclient', false);

INSERT INTO component(id, clientid, editable, redirecturl, keyoraction, label, sortorder, type, visible, widgetid, multilevel)
    VALUES ('clientfooter', 'distarise', true, null, null, 'Footer', 4, 'textbox', true, 'addclient', false);

INSERT INTO component(id, clientid, editable, redirecturl, keyoraction, label, sortorder, type, visible, widgetid, multilevel)
    VALUES ('clientlogo', 'distarise', true, null, null, 'Logo file name', 5, 'textbox', true, 'addclient', false);

INSERT INTO component(id, clientid, editable, redirecturl, keyoraction, label, sortorder, type, visible, widgetid, multilevel)
    VALUES ('clientadd', 'distarise', true, '/nsn/distarise/base/addnavigation', 'com.distarise.base.action.AddClientAction', 'Save and Continue', 6, 'submitbutton', true, 'addclient', false);

--Landing page

INSERT INTO component(id, clientid, editable, redirecturl, keyoraction, label, sortorder, type, visible, widgetid, multilevel)
    VALUES ('loadnavigationgrid', 'distarise', true, '', 'com.distarise.base.action.LoadNavigationsAction', '', 0, 'autoaction', true, 'addlandingpage', false);

INSERT INTO component(id, clientid, editable, redirecturl, keyoraction, label, sortorder, type, visible, widgetid, multilevel)
    VALUES ('clientid', 'distarise', true, '', '', 'Client Id : ', 2, 'text', true, 'addlandingpage', false);

INSERT INTO component(id, clientid, editable, redirecturl, keyoraction, label, sortorder, type, visible, widgetid, multilevel)
    VALUES ('navigationgrid', 'distarise', true, '', '', 'Landing pages', 3, 'gridform', true, 'addlandingpage', true);

INSERT INTO component(id, clientid, editable, redirecturl, keyoraction, label, sortorder, type, visible, widgetid, multilevel)
    VALUES ('id', 'distarise', true, '', '', 'Id', 3, 'textbox', true, 'savelandingpage', false);

INSERT INTO component(id, clientid, editable, redirecturl, keyoraction, label, sortorder, type, visible, widgetid, multilevel)
    VALUES ('module', 'distarise', true, '', '', 'Module', 4, 'textbox', true, 'savelandingpage', false);

INSERT INTO component(id, clientid, editable, redirecturl, keyoraction, label, sortorder, type, visible, widgetid, multilevel)
    VALUES ('pagedescription', 'distarise', true, '', '', 'Page description', 5, 'textbox', true, 'savelandingpage', false);

INSERT INTO component(id, clientid, editable, redirecturl, keyoraction, label, sortorder, type, visible, widgetid, multilevel)
    VALUES ('pagename', 'distarise', true, '', '', 'Page name', 6, 'textbox', true, 'savelandingpage', false);

INSERT INTO component(id, clientid, editable, redirecturl, keyoraction, label, sortorder, type, visible, widgetid, multilevel)
    VALUES ('pagetitle', 'distarise', true, '', '', 'Page title', 7, 'textbox', true, 'savelandingpage', false);

INSERT INTO component(id, clientid, editable, redirecturl, keyoraction, label, sortorder, type, visible, widgetid, multilevel)
    VALUES ('redirectpagename', 'distarise', true, '', '', 'Redirect page name', 8, 'textbox', true, 'savelandingpage', false);

INSERT INTO component(id, clientid, editable, redirecturl, keyoraction, label, sortorder, type, visible, widgetid, multilevel)
    VALUES ('rolename', 'distarise', true, '', '', 'Role', 9, 'textbox', true, 'savelandingpage', false);

INSERT INTO component(id, clientid, editable, redirecturl, keyoraction, label, sortorder, type, visible, widgetid, multilevel)
    VALUES ('navigationsave', 'distarise', true, '/nsn/distarise/base/addlandingpage', 'com.distarise.base.action.SaveLandingPageAction', 'Save', 10, 'submitbutton', true, 'savelandingpage', false);


--Navigation add page

INSERT INTO component(id, clientid, editable, redirecturl, keyoraction, label, sortorder, type, visible, widgetid, multilevel)
    VALUES ('loadlandingpages', 'distarise', true, '', 'com.distarise.base.action.LoadNavigationItemsAction', 'Client Id', 4, 'autoaction', true, 'addnavigation', false);

INSERT INTO component(id, clientid, editable, redirecturl, keyoraction, label, sortorder, type, visible, widgetid, multilevel)
    VALUES ('clientid', 'distarise', true, '', '', 'Client Id', 4, 'text', true, 'addnavigation', false);

INSERT INTO component(id, clientid, editable, redirecturl, keyoraction, label, sortorder, type, visible, widgetid, multilevel)
    VALUES ('landingpage', 'distarise', true, '/nsn/distarise/base/addnavigation', '', 'Landing page id', 5, 'configdropdown', true, 'addnavigation', true);

INSERT INTO component(id, clientid, editable, redirecturl, keyoraction, label, sortorder, type, visible, widgetid, multilevel)
    VALUES ('id', 'distarise', true, '', '', 'Navigation Id', 6, 'textbox', true, 'addnavigation', false);

INSERT INTO component(id, clientid, editable, redirecturl, keyoraction, label, sortorder, type, visible, widgetid, multilevel)
    VALUES ('navigationlabel', 'distarise', true, '', '', 'Navigation Name', 7, 'textbox', true, 'addnavigation', false);

INSERT INTO component(id, clientid, editable, redirecturl, keyoraction, label, sortorder, type, visible, widgetid, multilevel)
VALUES ('navigationsortorder', 'distarise', true, '', '', 'Sort Order', 8, 'textbox', true, 'addnavigation', false);

INSERT INTO component(id, clientid, editable, redirecturl, keyoraction, label, sortorder, type, visible, widgetid, multilevel)
VALUES ('navigationurl', 'distarise', true, '', '', 'URL', 9, 'textbox', true, 'addnavigation', false);

INSERT INTO component(id, clientid, editable, redirecturl, keyoraction, label, sortorder, type, visible, widgetid, multilevel)
VALUES ('layoutid', 'distarise', true, '', '', 'Layout id', 10, 'textbox', true, 'addnavigation', false);

INSERT INTO component(id, clientid, editable, redirecturl, keyoraction, label, sortorder, type, visible, widgetid, multilevel)
VALUES ('navitemid', 'distarise', true, '', '', 'Navigation item id', 11, 'textbox', true, 'addnavigation', false);

INSERT INTO component(id, clientid, editable, redirecturl, keyoraction, label, sortorder, type, visible, widgetid, multilevel)
VALUES ('logout', 'distarise', true, '/nsn/distarise/base/login', 'com.distarise.base.action.LogoutAction', 'Logout', 4, 'submitbutton', true, 'addnavigation', false);

