package pageobjects.modules.settings.leads

import geb.Module

class StatusForm extends Module {
    static base = { $(".item.form") }

    static content = {
        name { $("input[type='text']") }
        saveButton { $(".btn.save") }
        cancelButton { $("a.cancel") }
    }
}
