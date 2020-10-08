function onClickSubmitForm (id, action, redirectUrl, productId){
    document.getElementById('action').value= action;
    document.getElementById(id).action = redirectUrl;
    if (productId){document.getElementById('productId').value = productId;}
    document.getElementById(id).submit();
}
function sendOtp(){
    document.getElementById('action').value= 'com.distarise.base.action.ecommerce.ConfirmOrderAction';
    document.getElementById('cart').action = '/ecommerce/shopping/payment';
    var apiKey = document.getElementById('smsApiKey').value;
    var phone = document.getElementById('phone1').value;
    var url = "https://2factor.in/API/V1/"+apiKey+"/SMS/"+phone+"/AUTOGEN";

    var data = null;

    var xhr = new XMLHttpRequest();
    xhr.withCredentials = false;

    xhr.addEventListener("readystatechange", function () {
        if (this.readyState === this.DONE) {
            console.log(this.responseText);
            var sessionId = this.response.substring(this.response.lastIndexOf("\":\"")+3,this.response.length-2);
            document.getElementById('otpSessionId').value= sessionId;
            //document.getElementById('cart').submit();
            return true;
        }
    });

    xhr.open("GET", url);
    xhr.setRequestHeader("content-type", "application/x-www-form-urlencoded");

    xhr.send(data);
}

function verifyOtp(){
    document.getElementById('action').value= 'com.distarise.base.action.ecommerce.ConfirmOrderAction';
    document.getElementById('payment').action = '/ecommerce/shopping/payment';
    var data = null;

    var xhr = new XMLHttpRequest();
    xhr.withCredentials = false;
    var apiKey = document.getElementById('smsApiKey').value;
    var otp = document.getElementById('otp').value;
    var otpSessionId = document.getElementById('otpSessionId').value;

    var url = "http://2factor.in/API/V1/"+apiKey+"/SMS/VERIFY/"+otpSessionId+"/"+otp+"";
    xhr.addEventListener("readystatechange", function () {
        if (this.readyState === this.DONE) {
            var status = this.response.substring(this.response.lastIndexOf("\":\"")+3,this.response.length-2);
            console.log(this.responseText);
            if (status !== 'OTP Matched'){
                alert('OTP do not match. Please try again.');
            } else {
                document.getElementById('otpMatched').value = 'true';
                //document.getElementById('payment').submit();
            }
        }
    });

    xhr.open("GET", url);
    xhr.setRequestHeader("content-type", "application/x-www-form-urlencoded");

    xhr.send(data);
}

function paymentResponseHandler(response){
    if (response.razorpay_payment_id && response.razorpay_order_id && response.razorpay_signature){
        document.getElementById('success').innerHTML="Payment done successfully";
        document.getElementById('sendMail').value = "true";
        document.getElementById('razorOrderId').value = response.razorpay_order_id ;
        document.getElementById('razorPaymentId').value = response.razorpay_payment_id;
        document.getElementById('razorSignature').value = response.razorpay_signature;
        document.getElementById('action').value= 'com.distarise.base.action.ecommerce.ConfirmOrderAction';
        document.getElementById('payment').action = '/ecommerce/shopping/payment';
        document.getElementById('payment').submit();
    } else {
        document.getElementById('failure').innerHTML="Payment failure. Please try later";
    }

}