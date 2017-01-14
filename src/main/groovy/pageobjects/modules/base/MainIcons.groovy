package pageobjects.modules.base

import geb.Module

class MainIcons extends Module {

    static base = { $(".topbar .pull-left", 0) }

    static content = {
        dashboard(required: true, wait: true) { $("a[href='/sales']") }
        leads(required: true, wait: true) { $("a[href='/leads']") }
        contacts(required: true, wait: true) { $("a[href='/crm']") }
        salesPipeline(required: true, wait: true) { $("a[href='/sales/deals']") }
        calendar(required: true, wait: true) { $("a[href='/appointments']") }
        tasks(required: true, wait: true) { $("a[id='nav-communication-center']") }
        communcationCenter(required: true, wait: true) { $("a[href='/email']") }
        reports(required: true, wait: true) { $("a[href='/reports']") }
    }
}
