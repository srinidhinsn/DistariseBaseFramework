INSERT INTO component(id, clientid, editable, redirecturl, keyoraction, label, sortorder, type, visible, widgetid, multilevel, value)
	VALUES ('aboutus1', 'amruthhani', false, null, null, '', 1, 'text', true, 'aboutus', false, null);

INSERT INTO component(id, clientid, editable, redirecturl, keyoraction, label, sortorder, type, visible, widgetid, multilevel, value)
	VALUES ('aboutus2', 'amruthhani', true, null, null, '', 2, 'text', true, 'aboutus', false, null);

INSERT INTO component(id, clientid, editable, redirecturl, keyoraction, label, sortorder, type, visible, widgetid, multilevel, value)
	VALUES ('product', 'amruthhani', true, null, null, 'Dispenser', 3, 'custom', true, 'products', false, null);

INSERT INTO component(id, clientid, editable, redirecturl, keyoraction, label, sortorder, type, visible, widgetid, multilevel)
	VALUES ('listproduct', 'amruthhani', true, null, 'com.distarise.base.action.amruthhani.DisplayProductListAction', '', 1, 'autoaction', true, 'productlist', false);

INSERT INTO component(id, clientid, editable, redirecturl, keyoraction, label, sortorder, type, visible, widgetid, multilevel)
	VALUES ('productdetails', 'amruthhani', true, null, null, '', 0, 'custom', true, 'productdetails', false);

INSERT INTO component(id, clientid, editable, redirecturl, keyoraction, label, sortorder, type, visible, widgetid, multilevel, value)
	VALUES ('shipping', 'amruthhani', true, null, null, 'Shipping options', 1, 'radiobutton', true, 'productdetails', true, '0');


INSERT INTO component(id, clientid, editable, redirecturl, keyoraction, label, sortorder, type, visible, widgetid, multilevel)
	VALUES ('discount', 'amruthhani', true, null, null, 'Discount rates :', 2, 'text', true, 'productdetails', false);

INSERT INTO component(id, clientid, editable, redirecturl, keyoraction, label, sortorder, type, visible, widgetid, multilevel, value)
	VALUES ('discount1', 'amruthhani', true, null, null, '', 3, 'text', true, 'productdetails', false, '10-19 units, Rs200/- off per unit');

INSERT INTO component(id, clientid, editable, redirecturl, keyoraction, label, sortorder, type, visible, widgetid, multilevel, value)
	VALUES ('discount2', 'amruthhani', true, null, null, '', 4, 'text', true, 'productdetails', false, '20-49 units, Rs300/- off per unit');

INSERT INTO component(id, clientid, editable, redirecturl, keyoraction, label, sortorder, type, visible, widgetid, multilevel, value)
	VALUES ('discount3', 'amruthhani', true, null, null, '', 5, 'text', true, 'productdetails', false, '50+ units, Rs400/- off per unit');


INSERT INTO component(id, clientid, editable, redirecturl, keyoraction, label, sortorder, type, visible, widgetid, multilevel)
	VALUES ('cart', 'amruthhani', true, null, null, '', 0, 'custom', true, 'cart', false);

INSERT INTO component(id, clientid, editable, redirecturl, keyoraction, label, sortorder, type, visible, widgetid, multilevel)
	VALUES ('title', 'amruthhani', true, null, null, 'Title', 1, 'dropdown', true, 'cart', false);

INSERT INTO component(id, clientid, editable, redirecturl, keyoraction, label, sortorder, type, visible, widgetid, multilevel)
	VALUES ('firstname', 'amruthhani', true, null, null, 'Firstname', 2, 'textbox', true, 'cart', false);

INSERT INTO component(id, clientid, editable, redirecturl, keyoraction, label, sortorder, type, visible, widgetid, multilevel)
	VALUES ('lastname', 'amruthhani', true, null, null, 'Lastname', 3, 'textbox', true, 'cart', false);

INSERT INTO component(id, clientid, editable, redirecturl, keyoraction, label, sortorder, type, visible, widgetid, multilevel)
	VALUES ('houseno', 'amruthhani', true, null, null, 'House no', 4, 'textbox', true, 'cart', false);

INSERT INTO component(id, clientid, editable, redirecturl, keyoraction, label, sortorder, type, visible, widgetid, multilevel)
	VALUES ('addressline1', 'amruthhani', true, null, null, 'Address line 1', 5, 'textbox', true, 'cart', false);

INSERT INTO component(id, clientid, editable, redirecturl, keyoraction, label, sortorder, type, visible, widgetid, multilevel)
	VALUES ('addressline2', 'amruthhani', true, null, null, 'Address line 2', 6, 'textbox', true, 'cart', false);

INSERT INTO component(id, clientid, editable, redirecturl, keyoraction, label, sortorder, type, visible, widgetid, multilevel, value)
	VALUES ('country', 'amruthhani', true, null, null, 'Country', 7, 'dropdown', true, 'cart', false, 'India');

INSERT INTO component(id, clientid, editable, redirecturl, keyoraction, label, sortorder, type, visible, widgetid, multilevel, value)
	VALUES ('state', 'amruthhani', true, null, null, 'State', 8, 'dropdown', true, 'cart', false, 'Karnataka');

INSERT INTO component(id, clientid, editable, redirecturl, keyoraction, label, sortorder, type, visible, widgetid, multilevel, value)
	VALUES ('city', 'amruthhani', true, null, null, 'City', 9, 'dropdown', true, 'cart', false, 'Mysore');

INSERT INTO component(id, clientid, editable, redirecturl, keyoraction, label, sortorder, type, visible, widgetid, multilevel, value)
	VALUES ('pincode', 'amruthhani', true, null, null, 'Pincode', 10, 'textbox', true, 'cart', false, 'Mysore');

INSERT INTO component(id, clientid, editable, redirecturl, keyoraction, label, sortorder, type, visible, widgetid, multilevel, value)
	VALUES ('emailinfo', 'amruthhani', true, null, null, '', 11, 'text', true, 'cart', false, 'Order & Payment confirmation will be sent to your email id');

INSERT INTO component(id, clientid, editable, redirecturl, keyoraction, label, sortorder, type, visible, widgetid, multilevel)
	VALUES ('email', 'amruthhani', true, null, null, 'Email', 11, 'textbox', true, 'cart', false);

INSERT INTO component(id, clientid, editable, redirecturl, keyoraction, label, sortorder, type, visible, widgetid, multilevel, value)
	VALUES ('otpinfo', 'amruthhani', true, null, null, '', 12, 'text', true, 'cart', false, 'OTP will be sent to the number for verification');

INSERT INTO component(id, clientid, editable, redirecturl, keyoraction, label, sortorder, type, visible, widgetid, multilevel, value)
	VALUES ('phone1', 'amruthhani', true, null, null, 'Phone : +91', 13, 'phone', true, 'cart', false, '');

INSERT INTO component(id, clientid, editable, redirecturl, keyoraction, label, sortorder, type, visible, widgetid, multilevel, value)
	VALUES ('authenticate', 'amruthhani', true, '/amruthhani/shopping/payment', 'sendOtp', 'Send OTP', 14, 'button', true, 'cart', false, '');





INSERT INTO component(id, clientid, editable, redirecturl, keyoraction, label, sortorder, type, visible, widgetid, multilevel, value)
	VALUES ('payment', 'amruthhani', true, null , null, 'Payment', 0, 'custom', true, 'payment', false, null);

INSERT INTO component(id, clientid, editable, redirecturl, keyoraction, label, sortorder, type, visible, widgetid, multilevel)
	VALUES ('customerId', 'amruthhani', true, null, null, 'customerId', 1, 'hidden', true, 'payment', false);

INSERT INTO component(id, clientid, editable, redirecturl, keyoraction, label, sortorder, type, visible, widgetid, multilevel)
	VALUES ('firstname', 'amruthhani', true, null, null, 'Firstname', 1, 'text', true, 'payment', false);

INSERT INTO component(id, clientid, editable, redirecturl, keyoraction, label, sortorder, type, visible, widgetid, multilevel)
	VALUES ('lastname', 'amruthhani', true, null, null, 'Lastname', 2, 'text', true, 'payment', false);

INSERT INTO component(id, clientid, editable, redirecturl, keyoraction, label, sortorder, type, visible, widgetid, multilevel)
	VALUES ('houseno', 'amruthhani', true, null, null, 'House no', 3, 'text', true, 'payment', false);

INSERT INTO component(id, clientid, editable, redirecturl, keyoraction, label, sortorder, type, visible, widgetid, multilevel)
	VALUES ('addressline1', 'amruthhani', true, null, null, 'Address line 1', 4, 'text', true, 'payment', false);

INSERT INTO component(id, clientid, editable, redirecturl, keyoraction, label, sortorder, type, visible, widgetid, multilevel)
	VALUES ('addressline2', 'amruthhani', true, null, null, 'Address line 2', 5, 'text', true, 'payment', false);

INSERT INTO component(id, clientid, editable, redirecturl, keyoraction, label, sortorder, type, visible, widgetid, multilevel, value)
	VALUES ('country', 'amruthhani', true, null, null, 'Country', 6, 'text', true, 'payment', false, 'India');

INSERT INTO component(id, clientid, editable, redirecturl, keyoraction, label, sortorder, type, visible, widgetid, multilevel, value)
	VALUES ('state', 'amruthhani', true, null, null, 'State', 7, 'text', true, 'payment', false, 'Karnataka');

INSERT INTO component(id, clientid, editable, redirecturl, keyoraction, label, sortorder, type, visible, widgetid, multilevel, value)
	VALUES ('city', 'amruthhani', true, null, null, 'City', 8, 'text', true, 'payment', false, 'Mysore');

INSERT INTO component(id, clientid, editable, redirecturl, keyoraction, label, sortorder, type, visible, widgetid, multilevel, value)
	VALUES ('pincode', 'amruthhani', true, null, null, 'Pincode', 9, 'text', true, 'payment', false, '');

INSERT INTO component(id, clientid, editable, redirecturl, keyoraction, label, sortorder, type, visible, widgetid, multilevel, value)
	VALUES ('email', 'amruthhani', true, null, null, 'Email', 10, 'text', true, 'payment', false, '');

INSERT INTO component(id, clientid, editable, redirecturl, keyoraction, label, sortorder, type, visible, widgetid, multilevel, value)
	VALUES ('phone1', 'amruthhani', true, null, null, 'Phone', 11, 'text', true, 'payment', false, '');

INSERT INTO component(id, clientid, editable, redirecturl, keyoraction, label, sortorder, type, visible, widgetid, multilevel, value)
	VALUES ('otp', 'amruthhani', true, null, null, 'OTP', 12, 'textbox', true, 'payment', false, '');

INSERT INTO component(id, clientid, editable, redirecturl, keyoraction, label, sortorder, type, visible, widgetid, multilevel, value)
	VALUES ('submitotp', 'amruthhani', true, '/amruthhani/shopping/payment', 'verifyOtp', 'Submit', 14, 'button', true, 'payment', false, '');

INSERT INTO component(id, clientid, editable, redirecturl, keyoraction, label, sortorder, type, visible, widgetid, multilevel, value)
	VALUES ('paymentresponse', 'amruthhani', true, null , null, 'Payment Response', 11, 'message', true, 'paymentresponse', false, null);



