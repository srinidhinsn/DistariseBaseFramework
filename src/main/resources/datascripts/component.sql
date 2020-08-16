INSERT INTO component(id, clientid, editable, redirecturl, keyoraction, label, sortorder, type, visible, widgetid)
	VALUES ('username', 'distarise', true, null, null, 'Username', 1, 'textbox', true, 'login');

INSERT INTO component(id, clientid, editable, redirecturl, keyoraction, label, sortorder, type, visible, widgetid)
	VALUES ('password', 'distarise', true, null, null, 'Password', 2, 'password', true, 'login');

INSERT INTO component(id, clientid, editable, redirecturl, keyoraction, label, sortorder, type, visible, widgetid)
	VALUES ('loginsubmit', 'distarise', true, '/distarise/user/login', 'com.distarise.base.action.LoginAction', 'Login', 3, 'submitbutton', true, 'login');