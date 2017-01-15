package pageobjects.pages.settngs

import pageobjects.modules.settings.SettingsMenu
import pageobjects.pages.BaseLoggedPage


class SettingsPage extends BaseLoggedPage {

    static at = {
        $(".title-bar-inner  h1").text() == "Settings"
    }

    static content = {
        settingsMenu {module SettingsMenu}
    }
}
