INSERT INTO component(id, clientid, editable, redirecturl, keyoraction, label, sortorder, type, visible, widgetid, multilevel, value)
	VALUES ('aboutus1', 'ecommerce', false, null, null, '', 1, 'text', true, 'aboutus', false, null);

INSERT INTO component(id, clientid, editable, redirecturl, keyoraction, label, sortorder, type, visible, widgetid, multilevel, value)
	VALUES ('aboutus2', 'ecommerce', true, null, null, '', 2, 'text', true, 'aboutus', false, null);

INSERT INTO component(id, clientid, editable, redirecturl, keyoraction, label, sortorder, type, visible, widgetid, multilevel, value)
	VALUES ('product', 'ecommerce', true, null, null, 'Dispenser', 3, 'custom', true, 'products', false, null);

INSERT INTO component(id, clientid, editable, redirecturl, keyoraction, label, sortorder, type, visible, widgetid, multilevel)
	VALUES ('listproduct', 'ecommerce', true, null, 'com.distarise.ecommerce.action.DisplayProductListAction', '', 1, 'autoaction', true, 'productlist', false);

INSERT INTO component(id, clientid, editable, redirecturl, keyoraction, label, sortorder, type, visible, widgetid, multilevel)
	VALUES ('productdetails', 'ecommerce', true, null, null, '', 0, 'custom', true, 'productdetails', false);

INSERT INTO component(id, clientid, editable, redirecturl, keyoraction, label, sortorder, type, visible, widgetid, multilevel, value)
	VALUES ('shipping', 'ecommerce', true, null, null, 'Shipping options', 1, 'radiobutton', true, 'productdetails', true, '0');


INSERT INTO component(id, clientid, editable, redirecturl, keyoraction, label, sortorder, type, visible, widgetid, multilevel)
	VALUES ('discount', 'ecommerce', true, null, null, 'Discount rates :', 2, 'text', true, 'productdetails', false);

INSERT INTO component(id, clientid, editable, redirecturl, keyoraction, label, sortorder, type, visible, widgetid, multilevel, value)
	VALUES ('discount1', 'ecommerce', true, null, null, '', 3, 'text', true, 'productdetails', false, '10-19 units, Rs200/- off per unit');

INSERT INTO component(id, clientid, editable, redirecturl, keyoraction, label, sortorder, type, visible, widgetid, multilevel, value)
	VALUES ('discount2', 'ecommerce', true, null, null, '', 4, 'text', true, 'productdetails', false, '20-49 units, Rs300/- off per unit');

INSERT INTO component(id, clientid, editable, redirecturl, keyoraction, label, sortorder, type, visible, widgetid, multilevel, value)
	VALUES ('discount3', 'ecommerce', true, null, null, '', 5, 'text', true, 'productdetails', false, '50+ units, Rs400/- off per unit');


INSERT INTO component(id, clientid, editable, redirecturl, keyoraction, label, sortorder, type, visible, widgetid, multilevel)
	VALUES ('cart', 'ecommerce', true, null, null, '', 0, 'custom', true, 'cart', false);

INSERT INTO component(id, clientid, editable, redirecturl, keyoraction, label, sortorder, type, visible, widgetid, multilevel)
	VALUES ('title', 'ecommerce', true, null, null, 'Title', 1, 'dropdown', true, 'cart', false);

INSERT INTO component(id, clientid, editable, redirecturl, keyoraction, label, sortorder, type, visible, widgetid, multilevel)
	VALUES ('firstname', 'ecommerce', true, null, null, 'Firstname', 2, 'textbox', true, 'cart', false);

INSERT INTO component(id, clientid, editable, redirecturl, keyoraction, label, sortorder, type, visible, widgetid, multilevel)
	VALUES ('lastname', 'ecommerce', true, null, null, 'Lastname', 3, 'textbox', true, 'cart', false);

INSERT INTO component(id, clientid, editable, redirecturl, keyoraction, label, sortorder, type, visible, widgetid, multilevel)
	VALUES ('houseno', 'ecommerce', true, null, null, 'House no', 4, 'textbox', true, 'cart', false);

INSERT INTO component(id, clientid, editable, redirecturl, keyoraction, label, sortorder, type, visible, widgetid, multilevel)
	VALUES ('addressline1', 'ecommerce', true, null, null, 'Address line 1', 5, 'textbox', true, 'cart', false);

INSERT INTO component(id, clientid, editable, redirecturl, keyoraction, label, sortorder, type, visible, widgetid, multilevel)
	VALUES ('addressline2', 'ecommerce', true, null, null, 'Address line 2', 6, 'textbox', true, 'cart', false);

INSERT INTO component(id, clientid, editable, redirecturl, keyoraction, label, sortorder, type, visible, widgetid, multilevel, value)
	VALUES ('country', 'ecommerce', true, null, null, 'Country', 7, 'dropdown', true, 'cart', false, 'India');

INSERT INTO component(id, clientid, editable, redirecturl, keyoraction, label, sortorder, type, visible, widgetid, multilevel, value)
	VALUES ('state', 'ecommerce', true, null, null, 'State', 8, 'dropdown', true, 'cart', false, 'Karnataka');

INSERT INTO component(id, clientid, editable, redirecturl, keyoraction, label, sortorder, type, visible, widgetid, multilevel, value)
	VALUES ('city', 'ecommerce', true, null, null, 'City', 9, 'dropdown', true, 'cart', false, 'Mysore');

INSERT INTO component(id, clientid, editable, redirecturl, keyoraction, label, sortorder, type, visible, widgetid, multilevel, value)
	VALUES ('pincode', 'ecommerce', true, null, null, 'Pincode', 10, 'textbox', true, 'cart', false, 'Mysore');

INSERT INTO component(id, clientid, editable, redirecturl, keyoraction, label, sortorder, type, visible, widgetid, multilevel, value)
	VALUES ('emailinfo', 'ecommerce', true, null, null, '', 11, 'text', true, 'cart', false, 'Order & Payment confirmation will be sent to your email id');

INSERT INTO component(id, clientid, editable, redirecturl, keyoraction, label, sortorder, type, visible, widgetid, multilevel)
	VALUES ('email', 'ecommerce', true, null, null, 'Email', 11, 'textbox', true, 'cart', false);

INSERT INTO component(id, clientid, editable, redirecturl, keyoraction, label, sortorder, type, visible, widgetid, multilevel, value)
	VALUES ('otpinfo', 'ecommerce', true, null, null, '', 12, 'text', true, 'cart', false, 'OTP will be sent to the number for verification');

INSERT INTO component(id, clientid, editable, redirecturl, keyoraction, label, sortorder, type, visible, widgetid, multilevel, value)
	VALUES ('phone1', 'ecommerce', true, null, null, 'Phone : +91', 13, 'phone', true, 'cart', false, '');

INSERT INTO component(id, clientid, editable, redirecturl, keyoraction, label, sortorder, type, visible, widgetid, multilevel, value)
	VALUES ('authenticate', 'ecommerce', true, '/ecommerce/shopping/payment', 'sendOtp', 'Send OTP', 14, 'button', true, 'cart', false, '');





INSERT INTO component(id, clientid, editable, redirecturl, keyoraction, label, sortorder, type, visible, widgetid, multilevel, value)
	VALUES ('payment', 'ecommerce', true, null , null, 'Payment', 0, 'custom', true, 'payment', false, null);

INSERT INTO component(id, clientid, editable, redirecturl, keyoraction, label, sortorder, type, visible, widgetid, multilevel)
	VALUES ('customerId', 'ecommerce', true, null, null, 'customerId', 1, 'hidden', true, 'payment', false);

INSERT INTO component(id, clientid, editable, redirecturl, keyoraction, label, sortorder, type, visible, widgetid, multilevel)
	VALUES ('firstname', 'ecommerce', true, null, null, 'Firstname', 1, 'text', true, 'payment', false);

INSERT INTO component(id, clientid, editable, redirecturl, keyoraction, label, sortorder, type, visible, widgetid, multilevel)
	VALUES ('lastname', 'ecommerce', true, null, null, 'Lastname', 2, 'text', true, 'payment', false);

INSERT INTO component(id, clientid, editable, redirecturl, keyoraction, label, sortorder, type, visible, widgetid, multilevel)
	VALUES ('houseno', 'ecommerce', true, null, null, 'House no', 3, 'text', true, 'payment', false);

INSERT INTO component(id, clientid, editable, redirecturl, keyoraction, label, sortorder, type, visible, widgetid, multilevel)
	VALUES ('addressline1', 'ecommerce', true, null, null, 'Address line 1', 4, 'text', true, 'payment', false);

INSERT INTO component(id, clientid, editable, redirecturl, keyoraction, label, sortorder, type, visible, widgetid, multilevel)
	VALUES ('addressline2', 'ecommerce', true, null, null, 'Address line 2', 5, 'text', true, 'payment', false);

INSERT INTO component(id, clientid, editable, redirecturl, keyoraction, label, sortorder, type, visible, widgetid, multilevel, value)
	VALUES ('country', 'ecommerce', true, null, null, 'Country', 6, 'text', true, 'payment', false, 'India');

INSERT INTO component(id, clientid, editable, redirecturl, keyoraction, label, sortorder, type, visible, widgetid, multilevel, value)
	VALUES ('state', 'ecommerce', true, null, null, 'State', 7, 'text', true, 'payment', false, 'Karnataka');

INSERT INTO component(id, clientid, editable, redirecturl, keyoraction, label, sortorder, type, visible, widgetid, multilevel, value)
	VALUES ('city', 'ecommerce', true, null, null, 'City', 8, 'text', true, 'payment', false, 'Mysore');

INSERT INTO component(id, clientid, editable, redirecturl, keyoraction, label, sortorder, type, visible, widgetid, multilevel, value)
	VALUES ('pincode', 'ecommerce', true, null, null, 'Pincode', 9, 'text', true, 'payment', false, '');

INSERT INTO component(id, clientid, editable, redirecturl, keyoraction, label, sortorder, type, visible, widgetid, multilevel, value)
	VALUES ('email', 'ecommerce', true, null, null, 'Email', 10, 'text', true, 'payment', false, '');

INSERT INTO component(id, clientid, editable, redirecturl, keyoraction, label, sortorder, type, visible, widgetid, multilevel, value)
	VALUES ('phone1', 'ecommerce', true, null, null, 'Phone', 11, 'text', true, 'payment', false, '');

INSERT INTO component(id, clientid, editable, redirecturl, keyoraction, label, sortorder, type, visible, widgetid, multilevel, value)
	VALUES ('otp', 'ecommerce', true, null, null, 'OTP', 12, 'textbox', true, 'payment', false, '');

INSERT INTO component(id, clientid, editable, redirecturl, keyoraction, label, sortorder, type, visible, widgetid, multilevel, value)
	VALUES ('submitotp', 'ecommerce', true, '/ecommerce/shopping/payment', 'verifyOtp', 'Submit', 14, 'button', true, 'payment', false, '');

INSERT INTO component(id, clientid, editable, redirecturl, keyoraction, label, sortorder, type, visible, widgetid, multilevel, value)
	VALUES ('paymentresponse', 'ecommerce', true, null , null, 'Payment Response', 11, 'message', true, 'paymentresponse', false, null);



