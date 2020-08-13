INSERT INTO component(id, clientid, editable, keyoraction, label, sortorder, type, visible, widgetid)
	VALUES ('username', 'distarise', true, null, 'Username', 1, 'textbox', true, 'login');

INSERT INTO component(id, clientid, editable, keyoraction, label, sortorder, type, visible, widgetid)
	VALUES ('password', 'distarise', true, null, 'Password', 2, 'password', true, 'login');

INSERT INTO component(id, clientid, editable, keyoraction, label, sortorder, type, visible, widgetid)
	VALUES ('loginsubmit', 'distarise', true, null, 'Submit', 3, 'button', true, 'login');