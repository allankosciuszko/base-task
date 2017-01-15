package pageobjects.modules.common

import geb.Module


class Tabs extends Module {
    static base = {$(".nav.nav-tabs")}

    static content = {
        tab {name -> $("li", text: contains(name))}
    }
}
