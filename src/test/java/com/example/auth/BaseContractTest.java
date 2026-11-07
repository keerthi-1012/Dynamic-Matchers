package com.example.auth;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.context.WebApplicationContext;
@SpringBootTest
@AutoConfigureMockMvc
public abstract class BaseContractTest {
 @Autowired private WebApplicationContext context;
 @BeforeEach void setup(){ RestAssuredMockMvc.webAppContextSetup(context); }
}
