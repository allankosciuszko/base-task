package pageobjects.modules.settings.leads

import geb.Module


class StatusItem extends Module {
    static base = {$(".named-object-lead")}
    static content = {
        form(required: false, wait: true) {module StatusForm}
        editButton(wait: true) {$(".btn.edit", 0)}
    }
}
