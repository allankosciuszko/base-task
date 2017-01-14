package pageobjects.pages

import geb.Page

class LeadsPage extends Page {
    static atCheckWaiting = true
    static at = {
        $(".views-selection-header h1").text().contains("Leads")
    }

    static content = {
        leadsViewButton {$(".segment a[href*='specs.leads']", 0)}
        smartViewButton {$(".segment a[href*='specs.leads/smart_lists']", 0)}
        newLeadButton {$("a[id='leads-new']", 0)}
    }
}
