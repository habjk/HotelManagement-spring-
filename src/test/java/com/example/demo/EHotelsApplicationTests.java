package com.example.demo;

import static org.hamcrest.CoreMatchers.containsString;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestBuilders.formLogin;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestBuilders.logout;
import static org.springframework.security.test.web.servlet.response.SecurityMockMvcResultMatchers.unauthenticated;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import com.KKHHH.eHotels.controllers.MainController;



@RunWith(SpringRunner.class)
@SpringBootTest(classes = MainController.class)
@AutoConfigureMockMvc
public class EHotelsApplicationTests {

    @Autowired
    private WebApplicationContext context;

    @Autowired
    private MockMvc mvc;

    @Test
    public void loginAvailableForAll() throws Exception {
        mvc
                .perform(get("/login"))
                .andExpect(status().isOk());
    }



    @Test
    public void adminCanLog() throws Exception {
        mvc
                .perform(formLogin().user("habib@gmailcom").password("12345678"))
                .andExpect(status().isFound())
                .andExpect(redirectedUrl("/index"));
             //  .andExpect(authenticated().withUsername(AppSecurityAdmin.ADMIN_USERNAME));

        mvc
                .perform(logout())
                .andExpect(status().isFound())
                .andExpect(redirectedUrl("/"));
    }

    @Test
    public void invalidLoginDenied() throws Exception {
        String loginErrorUrl = "/login?error";
        mvc
                .perform(formLogin().password("invalid"))
                .andExpect(status().isFound())
                .andExpect(redirectedUrl(loginErrorUrl))
                .andExpect(unauthenticated());

        mvc
                .perform(get(loginErrorUrl))
                .andExpect(content().string(containsString("Invalid credentials")));
    }


}


