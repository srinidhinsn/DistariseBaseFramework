INSERT INTO component(id, clientid, editable, redirecturl, keyoraction, label, sortorder, type, visible, widgetid, multilevel, value)
	VALUES ('aboutus1', 'amruthhani', false, null, null, '', 1, 'text', true, 'aboutus', false, 'Amruth Hani has AC and DC dispensers with single and dual colors');

INSERT INTO component(id, clientid, editable, redirecturl, keyoraction, label, sortorder, type, visible, widgetid, multilevel, value)
	VALUES ('aboutus2', 'amruthhani', true, null, null, '', 2, 'text', true, 'aboutus', false, 'Second line of description goes here....');

INSERT INTO component(id, clientid, editable, redirecturl, keyoraction, label, sortorder, type, visible, widgetid, multilevel, value)
	VALUES ('product1', 'amruthhani', true, null, null, 'Dispenser', 3, 'text', true, 'products', false, 'Amruth Hani has AC and DC dispensers with single and dual colors');

INSERT INTO component(id, clientid, editable, redirecturl, keyoraction, label, sortorder, type, visible, widgetid, multilevel, value)
	VALUES ('product2', 'amruthhani', true, null, null, 'Dispenser', 4, 'text', true, 'products', false, 'AM2.png');

INSERT INTO component(id, clientid, editable, redirecturl, keyoraction, label, sortorder, type, visible, widgetid, multilevel)
	VALUES ('listproduct', 'amruthhani', true, null, 'com.distarise.base.action.amruthhani.DisplayProductListAction', '', 1, 'autoaction', true, 'productlist', false);

INSERT INTO component(id, clientid, editable, redirecturl, keyoraction, label, sortorder, type, visible, widgetid, multilevel)
	VALUES ('productdetails', 'amruthhani', true, null, null, '', 1, 'custom', true, 'productdetails', false);

INSERT INTO component(id, clientid, editable, redirecturl, keyoraction, label, sortorder, type, visible, widgetid, multilevel)
	VALUES ('shipping', 'amruthhani', true, null, null, 'Shipping options', 2, 'radiobutton', true, 'productdetails', true);

INSERT INTO component(id, clientid, editable, redirecturl, keyoraction, label, sortorder, type, visible, widgetid, multilevel, value)
	VALUES ('discount1', 'amruthhani', true, null, null, 'Discount rates', 3, 'text', true, 'productdetails', false, '10-19 units, Rs200/- off per unit');

INSERT INTO component(id, clientid, editable, redirecturl, keyoraction, label, sortorder, type, visible, widgetid, multilevel, value)
	VALUES ('discount2', 'amruthhani', true, null, null, '', 4, 'text', true, 'productdetails', false, '20-49 units, Rs300/- off per unit');

INSERT INTO component(id, clientid, editable, redirecturl, keyoraction, label, sortorder, type, visible, widgetid, multilevel, value)
	VALUES ('discount3', 'amruthhani', true, null, null, '', 5, 'text', true, 'productdetails', false, '50+ units, Rs400/- off per unit');


INSERT INTO component(id, clientid, editable, redirecturl, keyoraction, label, sortorder, type, visible, widgetid, multilevel)
	VALUES ('cart', 'amruthhani', true, null, null, '', 1, 'custom', true, 'cart', false);

