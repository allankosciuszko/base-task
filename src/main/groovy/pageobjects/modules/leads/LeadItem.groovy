package pageobjects.modules.leads

import geb.Browser
import geb.Module


class LeadItem extends Module {
    static base = {$(".object-list-item")}

    static content = {
        nameName {$(".lead-name")}
        editIcon {}
        select {-> Browser.drive() {

        }}
    }
}
