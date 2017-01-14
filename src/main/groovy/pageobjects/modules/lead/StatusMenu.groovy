package pageobjects.modules.lead

import geb.Module


class StatusMenu extends Module {

    static base = {$(".status", 0)}

    static content = {
        status {$(".lead-status")}
        dropdownMenu {$(".dropdown-menu")}
    }
}
