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
VALUES ('distarise', 'config', 'addclient', 'com.distarise.base.action.SaveClientDetailsAction', true);

INSERT INTO rolewidgetaction(clientid, rolename, widgetid, action, visible)
VALUES ('distarise', 'config', 'addclient', 'com.distarise.base.action.DeleteClientAction', true);


INSERT INTO rolewidgetaction(clientid, rolename, widgetid, action, visible)
VALUES ('distarise', 'config', 'addclient', 'com.distarise.base.action.LoadClientListAction', true);


INSERT INTO rolewidgetaction(clientid, rolename, widgetid, action, visible)
VALUES ('distarise', 'config', 'addnavigation', '', true);

INSERT INTO rolewidgetaction(clientid, rolename, widgetid, action, visible)
VALUES ('distarise', 'config', 'addnavigation', 'com.distarise.base.action.LoadNavigationsAction', true);

INSERT INTO rolewidgetaction(clientid, rolename, widgetid, action, visible)
VALUES ('distarise', 'config', 'savenavigation', '', true);

INSERT INTO rolewidgetaction(clientid, rolename, widgetid, action, visible)
VALUES ('distarise', 'config', 'savenavigation', 'com.distarise.base.action.SaveNavigationAction', true);

INSERT INTO rolewidgetaction(clientid, rolename, widgetid, action, visible)
VALUES ('distarise', 'config', 'addnavigationitem', '', true);

INSERT INTO rolewidgetaction(clientid, rolename, widgetid, action, visible)
VALUES ('distarise', 'config', 'addnavigationitem', 'com.distarise.base.action.LoadNavigationItemsAction', true);

INSERT INTO rolewidgetaction(clientid, rolename, widgetid, action, visible)
VALUES ('distarise', 'config', 'savenavigationitem', '', true);

INSERT INTO rolewidgetaction(clientid, rolename, widgetid, action, visible)
VALUES ('distarise', 'config', 'savenavigationitem', 'com.distarise.base.action.SaveNavigationItemAction', true);

INSERT INTO rolewidgetaction(clientid, rolename, widgetid, action, visible)
VALUES ('distarise', 'config', 'savenavigationitem', 'com.distarise.base.action.LogoutAction', true);

INSERT INTO rolewidgetaction(clientid, rolename, widgetid, action, visible)
VALUES ('distarise', 'config', 'addwidget', '', true);

INSERT INTO rolewidgetaction(clientid, rolename, widgetid, action, visible)
VALUES ('distarise', 'config', 'addwidget', 'com.distarise.base.action.LoadNavigationItemsAction', true);

INSERT INTO rolewidgetaction(clientid, rolename, widgetid, action, visible)
VALUES ('distarise', 'config', 'savewidget', '', true);

INSERT INTO rolewidgetaction(clientid, rolename, widgetid, action, visible)
VALUES ('distarise', 'config', 'savewidget', 'com.distarise.base.action.SaveWidgetAction', true);

INSERT INTO rolewidgetaction(clientid, rolename, widgetid, action, visible)
VALUES ('distarise', 'config', 'addcomponent', '', true);

INSERT INTO rolewidgetaction(clientid, rolename, widgetid, action, visible)
VALUES ('distarise', 'config', 'addcomponent', 'com.distarise.base.action.LoadNavigationItemsAction', true);

INSERT INTO rolewidgetaction(clientid, rolename, widgetid, action, visible)
VALUES ('distarise', 'config', 'savecomponent', '', true);

INSERT INTO rolewidgetaction(clientid, rolename, widgetid, action, visible)
VALUES ('distarise', 'config', 'savecomponent', 'com.distarise.base.action.SaveComponentAction', true);

INSERT INTO rolewidgetaction(clientid, rolename, widgetid, action, visible)
VALUES ('distarise', 'config', 'addcomponentitem', '', true);

INSERT INTO rolewidgetaction(clientid, rolename, widgetid, action, visible)
VALUES ('distarise', 'config', 'addcomponentitem', 'com.distarise.base.action.LoadNavigationItemsAction', true);

INSERT INTO rolewidgetaction(clientid, rolename, widgetid, action, visible)
VALUES ('distarise', 'config', 'savecomponentitem', '', true);

INSERT INTO rolewidgetaction(clientid, rolename, widgetid, action, visible)
VALUES ('distarise', 'config', 'savecomponentitem', 'com.distarise.base.action.SaveComponentItemAction', true);

INSERT INTO rolewidgetaction(clientid, rolename, widgetid, action, visible)
VALUES ('distarise', 'config', 'addrole', '', true);

INSERT INTO rolewidgetaction(clientid, rolename, widgetid, action, visible)
VALUES ('distarise', 'config', 'addrole', 'com.distarise.base.action.LoadRoleListAction', true);

INSERT INTO rolewidgetaction(clientid, rolename, widgetid, action, visible)
VALUES ('distarise', 'config', 'addrole', 'com.distarise.base.action.SaveRoleAction', true);

INSERT INTO rolewidgetaction(clientid, rolename, widgetid, action, visible)
VALUES ('distarise', 'config', 'addroleaccess', '', true);

INSERT INTO rolewidgetaction(clientid, rolename, widgetid, action, visible)
VALUES ('distarise', 'config', 'addroleaccess', 'com.distarise.base.action.LoadRoleAccessListAction', true);

INSERT INTO rolewidgetaction(clientid, rolename, widgetid, action, visible)
VALUES ('distarise', 'config', 'addroleaccess', 'com.distarise.base.action.SaveRoleAccessAction', true);

INSERT INTO rolewidgetaction(clientid, rolename, widgetid, action, visible)
VALUES ('distarise', 'config', 'adduser', '', true);

INSERT INTO rolewidgetaction(clientid, rolename, widgetid, action, visible)
VALUES ('distarise', 'config', 'adduser', 'com.distarise.base.action.LoadUserDetailsAction', true);

INSERT INTO rolewidgetaction(clientid, rolename, widgetid, action, visible)
VALUES ('distarise', 'config', 'saveuser', '', true);

INSERT INTO rolewidgetaction(clientid, rolename, widgetid, action, visible)
VALUES ('distarise', 'config', 'saveuser', 'com.distarise.base.action.SaveUserDetailsAction', true);


-- dista bank scripts

INSERT INTO rolewidgetaction(clientid, rolename, widgetid, action, visible, enabled)
VALUES ('distabank', 'guest', 'login', '', true, true);

INSERT INTO rolewidgetaction(clientid, rolename, widgetid, action, visible, enabled)
VALUES ('distabank', 'guest', 'login', 'com.distarise.base.action.LoginAction', true, true);

INSERT INTO rolewidgetaction(clientid, rolename, widgetid, action, visible, enabled)
VALUES ('distabank', 'manager', 'addcustomer', '', true, true);

INSERT INTO rolewidgetaction(clientid, rolename, widgetid, action, visible, enabled)
VALUES ('distabank', 'manager', 'addcustomer', 'com.distarise.distabank.customer.action.SaveCustomerAction', true, true);

INSERT INTO rolewidgetaction(clientid, rolename, widgetid, action, visible, enabled)
VALUES ('distabank', 'manager', 'customer', '', true, true);

INSERT INTO rolewidgetaction(clientid, rolename, widgetid, action, visible, enabled)
VALUES ('distabank', 'manager', 'customer', 'com.distarise.distabank.customer.action.LoadCustomerAction', true, true);

INSERT INTO rolewidgetaction(clientid, rolename, widgetid, action, visible, enabled)
VALUES ('distabank', 'manager', 'customer', 'com.distarise.distabank.customer.action.SaveCustomerAction', true, true);

INSERT INTO rolewidgetaction(clientid, rolename, widgetid, action, visible, enabled)
VALUES ('distabank', 'manager', 'searchresult', '', true, true);

INSERT INTO rolewidgetaction(clientid, rolename, widgetid, action, visible, enabled)
VALUES ('distabank', 'manager', 'searchresult', 'com.distarise.distabank.customer.action.SearchAction', true, true);

INSERT INTO rolewidgetaction(clientid, rolename, widgetid, action, visible, enabled)
VALUES ('distabank', 'manager', 'searchresult', 'com.distarise.distabank.customer.action.LoadCustomerAction', true, true);

INSERT INTO rolewidgetaction(clientid, rolename, widgetid, action, visible, enabled)
VALUES ('distabank', 'manager', 'profile', '', true, true);

INSERT INTO rolewidgetaction(clientid, rolename, widgetid, action, visible, enabled)
VALUES ('distabank', 'manager', 'profile', 'com.distarise.base.action.LogoutAction', true, true);

INSERT INTO rolewidgetaction(clientid, rolename, widgetid, action, visible, enabled)
VALUES ('distabank', 'manager', 'fdconfig', '', true, true);

INSERT INTO rolewidgetaction(clientid, rolename, widgetid, action, visible, enabled)
VALUES ('distabank', 'manager', 'fdconfig', 'com.distarise.distabank.deposit.action.LoadFdConfigAction', true, true);

INSERT INTO rolewidgetaction(clientid, rolename, widgetid, action, visible, enabled)
VALUES ('distabank', 'manager', 'fdconfig', 'com.distarise.distabank.deposit.action.SaveFdConfigAction', true, true);

INSERT INTO rolewidgetaction(clientid, rolename, widgetid, action, visible, enabled)
VALUES ('distabank', 'manager', 'fd', '', true, true);

INSERT INTO rolewidgetaction(clientid, rolename, widgetid, action, visible, enabled)
VALUES ('distabank', 'manager', 'fd', 'com.distarise.distabank.deposit.action.LoadFdAction', true, true);

INSERT INTO rolewidgetaction(clientid, rolename, widgetid, action, visible, enabled)
VALUES ('distabank', 'manager', 'fd', 'com.distarise.distabank.deposit.action.SaveFdAction', true, true);
