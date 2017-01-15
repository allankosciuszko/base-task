package pageobjects.modules.base

import geb.Module


class TopRightDropdown extends Module {

    static base = {$(".topbar-settings-dropdown.dropdown-menu", 0)}

    static content = {
        item { name -> $("li",  text: contains(name))}
    }
}
