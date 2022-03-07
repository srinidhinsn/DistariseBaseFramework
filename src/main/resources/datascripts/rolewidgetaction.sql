INSERT INTO rolewidgetaction(clientid, rolename, widgetid, action, visible)
	VALUES ('distarise', 'guest', 'login', '', true);

INSERT INTO rolewidgetaction(clientid, rolename, widgetid, action, visible)
	VALUES ('distarise', 'guest', 'login', 'com.distarise.base.action.LoginAction', true);

INSERT INTO rolewidgetaction(clientid, rolename, widgetid, action, visible)
	VALUES ('distarise', 'admin', 'welcome', '', true);

INSERT INTO rolewidgetaction(clientid, rolename, widgetid, action, visible)
	VALUES ('distarise', 'admin', 'qaassurance', '', true);

INSERT INTO rolewidgetaction(clientid, rolename, widgetid, action, visible)
	VALUES ('distarise', 'admin', 'samples', '', true);


INSERT INTO rolewidgetaction(clientid, rolename, widgetid, action, visible)
	VALUES ('distarise', 'admin', 'samples', 'com.distarise.base.action.DemoAction', true);

INSERT INTO rolewidgetaction(clientid, rolename, widgetid, action, visible)
	VALUES ('distarise', 'admin', 'invoice', '', true);


INSERT INTO rolewidgetaction(clientid, rolename, widgetid, action, visible)
	VALUES ('distarise', 'admin', 'invoice', 'com.distarise.base.action.DemoAction', true);


INSERT INTO rolewidgetaction(clientid, rolename, widgetid, action, visible)
	VALUES ('distarise', 'admin', 'invoice', 'com.distarise.base.action.EditAction', true);

INSERT INTO rolewidgetaction(clientid, rolename, widgetid, action, visible)
	VALUES ('distarise', 'dm', 'welcome', '', true);

INSERT INTO rolewidgetaction(clientid, rolename, widgetid, action, visible)
	VALUES ('distarise', 'dm', 'qaassurance', '', true);

INSERT INTO rolewidgetaction(clientid, rolename, widgetid, action, visible)
	VALUES ('distarise', 'dm', 'samples', '', true);

INSERT INTO rolewidgetaction(clientid, rolename, widgetid, action, visible)
	VALUES ('distarise', 'dm', 'invoice', '', false);

INSERT INTO rolewidgetaction(clientid, rolename, widgetid, action, visible)
	VALUES ('distarise', 'dm', 'invoice', 'com.distarise.base.action.EditAction', true);


INSERT INTO rolewidgetaction(clientid, rolename, widgetid, action, visible)
	VALUES ('distarise', 'dm', 'account', '', true);

INSERT INTO rolewidgetaction(clientid, rolename, widgetid, action, visible)
	VALUES ('distarise', 'dm', 'account', 'com.distarise.base.action.LoadProfileAction', true);

INSERT INTO rolewidgetaction(clientid, rolename, widgetid, action, visible)
	VALUES ('distarise', 'dm', 'account', 'com.distarise.base.action.LogoutAction', true);


INSERT INTO rolewidgetaction(clientid, rolename, widgetid, action, visible)
	VALUES ('distarise', 'admin', 'account', '', true);

INSERT INTO rolewidgetaction(clientid, rolename, widgetid, action, visible)
	VALUES ('distarise', 'admin', 'account', 'com.distarise.base.action.LoadProfileAction', true);

INSERT INTO rolewidgetaction(clientid, rolename, widgetid, action, visible)
	VALUES ('distarise', 'admin', 'account', 'com.distarise.base.action.LogoutAction', true);

-- Config screens

INSERT INTO rolewidgetaction(clientid, rolename, widgetid, action, visible)
VALUES ('distarise', 'config', 'addclient', '', true);

INSERT INTO rolewidgetaction(clientid, rolename, widgetid, action, visible)
VALUES ('distarise', 'config', 'addclient', 'com.distarise.base.action.AddClientAction', true);


INSERT INTO rolewidgetaction(clientid, rolename, widgetid, action, visible)
VALUES ('distarise', 'config', 'addclient', 'com.distarise.base.action.LoadClientListAction', true);

INSERT INTO rolewidgetaction(clientid, rolename, widgetid, action, visible)
VALUES ('distarise', 'config', 'addlandingpage', 'com.distarise.base.action.LoadNavigationsAction', true);

INSERT INTO rolewidgetaction(clientid, rolename, widgetid, action, visible)
VALUES ('distarise', 'config', 'addnavigation', 'com.distarise.base.action.LogoutAction', true);

