package pageobjects.pages.settngs

import geb.Page
import pageobjects.modules.common.Tabs
import pageobjects.modules.settings.leads.StatusItem


class LeadsSettingsPage extends SettingsPage {

    static at = {
        title == "Customize Leads | Base CRM"
    }
    static content = {
        tabs { module Tabs }
        statusList(required: false) { $("#lead-status").moduleList(StatusItem) }
    }
}
