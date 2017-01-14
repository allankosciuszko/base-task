package configs

import com.typesafe.config.ConfigFactory


trait SpecConfig {
    def config = ConfigFactory.load("accounts.conf")

    def userEmail = config.getString("test-user.email")
    def userPassword = config.getString("test-user.password")
    def userToken = config.getString("test-user.token")
}