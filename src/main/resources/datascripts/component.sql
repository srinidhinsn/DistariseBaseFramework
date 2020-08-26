INSERT INTO component(id, clientid, editable, redirecturl, keyoraction, label, sortorder, type, visible, widgetid, multilevel)
	VALUES ('username', 'distarise', true, null, null, 'Username', 1, 'textbox', true, 'login', false);

INSERT INTO component(id, clientid, editable, redirecturl, keyoraction, label, sortorder, type, visible, widgetid, multilevel)
	VALUES ('password', 'distarise', true, null, null, 'Password', 2, 'password', true, 'login', false);

INSERT INTO component(id, clientid, editable, redirecturl, keyoraction, label, sortorder, type, visible, widgetid. multilevel)
	VALUES ('loginsubmit', 'distarise', true, '/distarise/base/home', 'com.distarise.base.action.LoginAction', 'Login', 3, 'submitbutton', true, 'login', false);

INSERT INTO component(id, clientid, editable, redirecturl, keyoraction, label, sortorder, type, visible, widgetid, multilevel)
	VALUES ('greetings', 'distarise', true, null, null, 'Welcome', 1, 'textarea', true, 'welcome', false);

INSERT INTO component(id, clientid, editable, redirecturl, keyoraction, label, sortorder, type, visible, widgetid, multilevel)
	VALUES ('introduction', 'distarise', true, null, null, 'Introduction', 2, 'textarea', true, 'welcome', false);

INSERT INTO component(id, clientid, editable, redirecturl, keyoraction, label, sortorder, type, visible, widgetid, multilevel)
	VALUES ('quality', 'distarise', true, null, null, 'Quality Deliverables', 2, 'textarea', true, 'qaassurance', false);

INSERT INTO component(id, clientid, editable, redirecturl, keyoraction, label, sortorder, type, visible, widgetid, multilevel)
	VALUES ('textboxsample', 'distarise', true, null, null, 'Text Box (textbox)', 1, 'textbox', true, 'samples', false);


INSERT INTO component(id, clientid, editable, redirecturl, keyoraction, label, sortorder, type, visible, widgetid, multilevel)
	VALUES ('textareasample', 'distarise', true, null, null, 'Text Area (textarea)', 2, 'textarea', true, 'samples', true);


INSERT INTO component(id, clientid, editable, redirecturl, keyoraction, label, sortorder, type, visible, widgetid, multilevel)
	VALUES ('passwordsample', 'distarise', true, null, null, 'Password (password)', 3, 'password', true, 'samples', false);

INSERT INTO component(id, clientid, editable, redirecturl, keyoraction, label, sortorder, type, visible, widgetid, multilevel)
	VALUES ('checkboxsample', 'distarise', true, null, null, 'Checkbox (checkbox)', 4, 'checkbox', true, 'samples', true);

INSERT INTO component(id, clientid, editable, redirecturl, keyoraction, label, sortorder, type, visible, widgetid, multilevel)
	VALUES ('submitsample', 'distarise', true, '/distarise/base/home', 'com.distarise.base.action.LoginAction', 'Submit', 5, 'submitbutton', true, 'samples', false);
