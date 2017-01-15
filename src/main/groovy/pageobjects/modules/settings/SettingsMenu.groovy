package pageobjects.modules.settings

import geb.Module


class SettingsMenu extends Module{

    static base = {$(".settings-menu")}

    static content = {
        item {name -> $("li", text: contains(name))}
    }
}
