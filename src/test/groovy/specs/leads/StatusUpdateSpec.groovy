package specs.leads

import com.getbase.Client
import com.getbase.Configuration
import com.getbase.models.Lead
import com.getbase.services.LeadsService
import configs.SpecConfig
import pageobjects.pages.DashboardPage
import pageobjects.pages.Homepage
import pageobjects.pages.LeadPage
import pageobjects.pages.LeadsPage
import pageobjects.pages.LoginPage
import geb.spock.GebReportingSpec
import pageobjects.pages.NewLeadPage
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
        then:
        at LeadPage
        leadTitle.text().contains("test lead")
        statusMenu.status.text() == defaultStateName


    }

    def "the status of new created lead is set to New"() {

    }

    def "user can change the status name"() {

    }

    def "the changed name should be be reflected on the lead"() {

    }


}
