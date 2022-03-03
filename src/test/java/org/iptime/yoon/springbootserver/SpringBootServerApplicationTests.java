package org.iptime.yoon.springbootserver;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(
    properties = {"property.value=propertyTest", "value=test"},
    classes = {SpringBootServerApplication.class},
    webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT
)
@ActiveProfiles("dev")
class SpringBootServerApplicationTests {

    @Value("${value}")
    private String value;

    @Value("${property.value}")
    private String propertyValue;

    @Test
    void contextLoads() {
        assertThat(value).isEqualTo("test");
        assertThat(propertyValue).isEqualTo("propertyTest");
    }
}
