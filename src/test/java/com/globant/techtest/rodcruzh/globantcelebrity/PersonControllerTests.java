package com.globant.techtest.rodcruzh.globantcelebrity;

import com.globant.techtest.rodcruzh.ctrl.PersonCtrl;
import com.globant.techtest.rodcruzh.entity.Person;
import com.globant.techtest.rodcruzh.svc.PersonSvc;
import com.globant.techtest.rodcruzh.util.enumeration.SourcePerson;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Optional;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.hamcrest.core.Is.is;

@RunWith(SpringRunner.class)
@WebMvcTest(PersonCtrl.class)
public class PersonControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PersonSvc personSvc;

    @Test
    public void test01() throws Exception {
        given(personSvc.findCelebrity(SourcePerson.DB)).willReturn(Optional.of(new Person(5L)));

        mockMvc.perform(get("/db").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].id", is(5L)));
    }

}
