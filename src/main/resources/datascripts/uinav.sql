INSERT INTO uinav(id, clientid, cssclass, module, pagedescription, pagename, pagetitle, redirectpagename, rolename)
	VALUES ('distariselogin', 'distarise', 'commoncss', 'user', 'Base module page', 'login', 'Login', 'home', null);


INSERT INTO uinav(id, clientid, cssclass, module, pagedescription, pagename, pagetitle, redirectpagename, rolename)
	VALUES ('distariseguestlogin', 'distarise', 'commoncss', 'base', 'Base module page', 'login', 'Login', 'home', 'guest');

INSERT INTO uinav(id, clientid, cssclass, module, pagedescription, pagename, pagetitle, redirectpagename, rolename)
        VALUES ('distariseuserlogin', 'distarise', 'commoncss', 'userrole', 'Base module page', 'login', 'Login', 'addrole', 'guest');

INSERT INTO uinav(id, clientid, cssclass, module, pagedescription, pagename, pagetitle, redirectpagename, rolename)
	VALUES ('distariseadminlogin', 'distarise', 'commoncss', 'base', 'Base module page', 'login', 'Login', 'home', 'admin');


INSERT INTO uinav(id, clientid, cssclass, module, pagedescription, pagename, pagetitle, redirectpagename, rolename)
	VALUES ('distarisedmlogin', 'distarise', 'commoncss', 'base', 'Base module page', 'login', 'Login', 'home', 'dm');

INSERT INTO uinav(id, clientid, cssclass, module, pagedescription, pagename, pagetitle, redirectpagename, rolename)
VALUES ('distariseconfiglogin', 'distarise', 'commoncss', 'base', 'Base module page', 'login', 'Login', 'addclient', 'config');

INSERT INTO uinav(id, clientid, cssclass, module, pagedescription, pagename, pagetitle, redirectpagename, rolename)
VALUES ('distariseuserrolelogin', 'distarise', 'commoncss', 'userrole', 'Base module page', 'login', 'Login', 'addrole', 'config');


-- distabank scripts


INSERT INTO uinav(id, clientid, cssclass, module, pagedescription, pagename, pagetitle, redirectpagename, rolename)
VALUES ('distabanklogin', 'distabank', 'commoncss', 'bank', 'Base module page', 'login', 'Login', 'addcustomer', 'guest');

INSERT INTO uinav(id, clientid, cssclass, module, pagedescription, pagename, pagetitle, redirectpagename, rolename)
VALUES ('distabankmanagerlogin', 'distabank', 'commoncss', 'bank', 'Base module page', 'login', 'Login', 'addcustomer', 'manager');
