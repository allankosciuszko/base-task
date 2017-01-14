package pageobjects.pages

import geb.Page

class DashboardPage extends BaseLoggedPage {
    static atCheckWaiting = true

    static url = "/sales"

    static at = {
        $("h1").text().contains("Dashboard")
    }

    static content = {
    }
}

