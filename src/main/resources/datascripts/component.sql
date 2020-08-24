INSERT INTO component(id, clientid, editable, redirecturl, keyoraction, label, sortorder, type, visible, widgetid)
	VALUES ('username', 'distarise', true, null, null, 'Username', 1, 'textbox', true, 'login');

INSERT INTO component(id, clientid, editable, redirecturl, keyoraction, label, sortorder, type, visible, widgetid)
	VALUES ('password', 'distarise', true, null, null, 'Password', 2, 'password', true, 'login');

INSERT INTO component(id, clientid, editable, redirecturl, keyoraction, label, sortorder, type, visible, widgetid)
	VALUES ('loginsubmit', 'distarise', true, '/distarise/base/home', 'com.distarise.base.action.LoginAction', 'Login', 3, 'submitbutton', true, 'login');

INSERT INTO component(id, clientid, editable, redirecturl, keyoraction, label, sortorder, type, visible, widgetid)
	VALUES ('greetings', 'distarise', true, null, null, 'Welcome', 1, 'textarea', true, 'welcome');

INSERT INTO component(id, clientid, editable, redirecturl, keyoraction, label, sortorder, type, visible, widgetid)
	VALUES ('introduction', 'distarise', true, null, null, 'Introduction', 2, 'textarea', true, 'welcome');

INSERT INTO component(id, clientid, editable, redirecturl, keyoraction, label, sortorder, type, visible, widgetid)
	VALUES ('quality', 'distarise', true, null, null, 'Quality Deliverables', 2, 'textarea', true, 'qaassurance');
