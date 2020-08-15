INSERT INTO component(id, clientid, editable, keyoraction, label, sortorder, type, visible, widgetid)
	VALUES ('username', 'distarise', true, null, 'Username', 1, 'textbox', true, 'login');

INSERT INTO component(id, clientid, editable, keyoraction, label, sortorder, type, visible, widgetid)
	VALUES ('password', 'distarise', true, null, 'Password', 2, 'password', true, 'login');

INSERT INTO component(id, clientid, editable, keyoraction, label, sortorder, type, visible, widgetid)
	VALUES ('loginsubmit', 'distarise', true, '/distarise/user/login', 'Login', 3, 'submitbutton', true, 'login');