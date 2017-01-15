package specs.leads

import com.getbase.Client
import com.getbase.Configuration
import com.getbase.models.Lead
import com.getbase.services.LeadsService
import configs.SpecConfig
import pageobjects.modules.settings.leads.StatusItem
import pageobjects.pages.DashboardPage
import pageobjects.pages.Homepage
import pageobjects.pages.LeadPage
import pageobjects.pages.LeadsPage
import pageobjects.pages.LoginPage
import geb.spock.GebReportingSpec
import pageobjects.pages.NewLeadPage
import pageobjects.pages.settngs.LeadsSettingsPage
import pageobjects.pages.settngs.SettingsPage
import spock.lang.Shared
import spock.lang.Stepwise

@Stepwise
class StatusUpdateSpec extends GebReportingSpec implements SpecConfig {

    @Shared Client apiClient = new Client(new Configuration.Builder()
            .accessToken(userToken)
            .verbose()
            .build());

    @Shared getCurrentDefaultStateName = {
        def newLead = new Lead()
        newLead.setLastName("foo")
        Lead lead = apiClient.leads().create(newLead)
        def status = lead.status
        apiClient.leads().delete(lead.id)
        status
    }
    @Shared defaultStateName = getCurrentDefaultStateName()

    def setupSpec() {
        apiClient.leads().list(new LeadsService.SearchCriteria())
                .each { lead -> apiClient.leads().delete(lead.id) }
    }

    @Shared newLeadURL
    @Shared newStatusName = "status_${UUID.randomUUID().toString().subSequence(0,10).replaceAll("-", "")}"


    def "User log in to account"() {
        when:
        to Homepage
        and:
        loginLink.click()
        then:
        at LoginPage

        when:
        email << userEmail
        password << userPassword
        loginButton.click()
        then:
        at DashboardPage
    }

    def "User can create new Lead"() {
        when:
        at DashboardPage
        mainIcons.leads.click()
        then:
        at LeadsPage
        when:
        newLeadButton.click()
        then:
        at NewLeadPage
        firstName << "John"
        lastName << "Smith"
        leadTitle << "test lead"
        email << "testbase@gmail.com"
        saveButton.click()

        then: at LeadPage

    }

    def "the status of new created lead is set to default status"() {
        given:
        newLeadURL =  currentUrl
        when:
        at LeadPage
        then: leadTitle.text().contains("test lead")
        and: statusMenu.status.text() == defaultStateName

    }

    def "user can change the status name in settings"() {
        when: at LeadPage
        and: userAvatar.click()
        then: topRightDropdown.displayed

        when: topRightDropdown.item("Settings").click()
        then: at SettingsPage

        when: settingsMenu.item("Leads").click()
        then: at LeadsSettingsPage
        tabs.tab("Lead Statuses").click()
        def defaultStatus = statusList[0] as StatusItem
        then: defaultStatus.updateName(newStatusName)
    }

    def "the changed name should be reflected on the lead"() {
        when: go newLeadURL
        then: at LeadPage
        statusMenu.status.text() == newStatusName
    }

}
