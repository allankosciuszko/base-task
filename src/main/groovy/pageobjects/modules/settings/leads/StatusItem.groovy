package pageobjects.modules.settings.leads

import geb.Browser
import geb.Module


class StatusItem extends Module {
    static base = {$(".named-object-lead")}
    static content = {
        form(required: false, wait: true) {module StatusForm}
        editButton(wait: true) {$(".btn.edit", 0)}
        updateName { statusName -> Browser.drive(){
            editButton.click()
            form.name.firstElement().clear()
            form.name << statusName
            form.saveButton.click()
        }}
    }
}
