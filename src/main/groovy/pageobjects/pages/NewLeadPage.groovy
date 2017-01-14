package pageobjects.pages

import geb.Page


class NewLeadPage extends BaseLoggedPage {
    static at = {
        $("h1").text() == "New lead"
    }

    static content = {
        firstName { $("input[id='lead-first-name']") }
        lastName { $("input[id='lead-last-name']") }
        leadTitle { $("input[id='lead-title']") }
        email { $("input[id='lead-email']") }
        saveButton { $(".save.btn", 0) }
        cancelButton { $(".cancel.btn", 0) }
    }
}
