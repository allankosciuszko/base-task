package pageobjects.pages

import geb.Page


class LoginPage extends Page {
    static atCheckWaiting = true
    static at = {
           getJs().exec("return document.readyState") == "complete"
           title == "Login to Base"
    }
    static content = {
        email(required: true, wait: true) {$("input[id='user_email']")}
        password(required: true, wait: true) {$("input[id='user_password']")}
        loginButton(required: true, wait: true) {$(".btn.btn-large.btn-primary")}
    }

}
