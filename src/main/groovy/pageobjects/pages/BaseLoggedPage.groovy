package pageobjects.pages

import geb.Page
import pageobjects.modules.base.MainIcons


class BaseLoggedPage extends Page {
    static atCheckWaiting = true
    static at = {
        title.contains("Base CRM")
        getJs().exec("return document.readyState") == "complete"
    }
    static content = {
        mainIcons(required: true, wait: true) { module MainIcons}
    }
}
