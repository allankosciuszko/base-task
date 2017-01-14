package pageobjects.pages

import pageobjects.modules.lead.StatusMenu


class LeadPage extends BaseLoggedPage {
    static atCheckWaiting = true
    static at = {
        $("h1 > a", 0).text() == "Leads"
    }
    static content = {
        statusMenu { module StatusMenu }
        leadTitle { $(".object-subtitle", 0) }
    }

}
