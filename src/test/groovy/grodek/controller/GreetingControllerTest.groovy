package grodek.controller

import grodek.Application
import org.springframework.boot.test.IntegrationTest
import org.springframework.boot.test.SpringApplicationContextLoader
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.web.WebAppConfiguration
import spock.lang.Specification

@ContextConfiguration(loader = SpringApplicationContextLoader, classes = Application)
@WebAppConfiguration
@IntegrationTest
class GreetingControllerTest extends Specification {

    def "should return increasing number of greetings"() {

        expect:
        "http://localhost:8080/greeting?name=$name".toURL().text == response

        where:
        name      | response
        "Mariusz" | '{"id":1,"content":"Hello, Mariusz!"}'
        ""        | '{"id":2,"content":"Hello, World!"}'
    }
}