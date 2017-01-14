package pageobjects.pages

import geb.Page

class Homepage extends Page {

    static url = "/"

    static at = {
        title == "CRM Software for Sales Acceleration | Base CRM"
    }

    static content = {
        loginLink(required: true, wait: true) {$("a[href*='login']")}
    }
}

