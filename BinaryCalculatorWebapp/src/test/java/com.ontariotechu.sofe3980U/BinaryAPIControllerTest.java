package com.ontariotechu.sofe3980U;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

import org.junit.runner.RunWith;

import org.junit.*;
import org.junit.runner.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.test.context.*;
import org.springframework.boot.test.mock.mockito.*;
import org.springframework.test.context.junit4.*;

import static org.hamcrest.Matchers.containsString;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.BDDMockito.*;

@RunWith(SpringRunner.class)
@WebMvcTest(BinaryAPIController.class)
public class BinaryAPIControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void add() throws Exception {
        this.mvc.perform(get("/add").param("operand1", "111").param("operand2", "1010"))// .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string("10001"));
    }

    @Test
    public void add2() throws Exception {
        this.mvc.perform(get("/add_json").param("operand1", "111").param("operand2", "1010"))// .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.operand1").value(111))
                .andExpect(MockMvcResultMatchers.jsonPath("$.operand2").value(1010))
                .andExpect(MockMvcResultMatchers.jsonPath("$.result").value(10001))
                .andExpect(MockMvcResultMatchers.jsonPath("$.operator").value("add"));
    }

    /*
     * 3 EXTENDED TEST CASES:
     * - Test case with all parameters are missing with add()
     * - Test case with all parameters are missing with add_json()
     * - Test case with zero input with add_json()
     */
    @Test
    public void testMissingAllParametersAdd() throws Exception {
        this.mvc.perform(get("/add"))
                .andExpect(status().isOk())
                .andExpect(content().string("0"));
    }

    @Test
    public void testMissingAllParametersAddJson() throws Exception {
        this.mvc.perform(get("/add_json"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.operand1").value(0))
                .andExpect(MockMvcResultMatchers.jsonPath("$.operand2").value(0))
                .andExpect(MockMvcResultMatchers.jsonPath("$.result").value(0))
                .andExpect(MockMvcResultMatchers.jsonPath("$.operator").value("add"));
    }

    @Test
    public void testZeroInputAddJson() throws Exception {
        this.mvc.perform(get("/add_json").param("operand1", "0").param("operand2", "0"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.operand1").value(0))
                .andExpect(MockMvcResultMatchers.jsonPath("$.operand2").value(0))
                .andExpect(MockMvcResultMatchers.jsonPath("$.result").value(0))
                .andExpect(MockMvcResultMatchers.jsonPath("$.operator").value("add"));
    }

    /*
     * TEST CASE for operator |
     */
    @Test
    public void testOr() throws Exception {
        this.mvc.perform(get("/or").param("operand1", "111").param("operand2", "1010"))// .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string("1111"));
    }

    @Test
    public void testOrJson() throws Exception {
        this.mvc.perform(get("/or_json").param("operand1", "111").param("operand2", "1010"))// .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.operand1").value(111))
                .andExpect(MockMvcResultMatchers.jsonPath("$.operand2").value(1010))
                .andExpect(MockMvcResultMatchers.jsonPath("$.result").value(1111))
                .andExpect(MockMvcResultMatchers.jsonPath("$.operator").value("or"));
    }

    @Test
    public void testMissingAllParametersOr() throws Exception {
        this.mvc.perform(get("/or"))
                .andExpect(status().isOk())
                .andExpect(content().string("0"));
    }

    @Test
    public void testMissingAllParametersOrJson() throws Exception {
        this.mvc.perform(get("/or_json"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.operand1").value(0))
                .andExpect(MockMvcResultMatchers.jsonPath("$.operand2").value(0))
                .andExpect(MockMvcResultMatchers.jsonPath("$.result").value(0))
                .andExpect(MockMvcResultMatchers.jsonPath("$.operator").value("or"));
    }

    @Test
    public void testZeroInputOrJson() throws Exception {
        this.mvc.perform(get("/or_json").param("operand1", "0").param("operand2", "0"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.operand1").value(0))
                .andExpect(MockMvcResultMatchers.jsonPath("$.operand2").value(0))
                .andExpect(MockMvcResultMatchers.jsonPath("$.result").value(0))
                .andExpect(MockMvcResultMatchers.jsonPath("$.operator").value("or"));
    }

    /*
     * TEST CASES for operator &
     */
    @Test
    public void testAnd() throws Exception {
        this.mvc.perform(get("/and").param("operand1", "111").param("operand2", "1010"))// .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string("10"));
    }

    @Test
    public void testAndJson() throws Exception {
        this.mvc.perform(get("/and_json").param("operand1", "111").param("operand2", "1010"))// .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.operand1").value(111))
                .andExpect(MockMvcResultMatchers.jsonPath("$.operand2").value(1010))
                .andExpect(MockMvcResultMatchers.jsonPath("$.result").value(10))
                .andExpect(MockMvcResultMatchers.jsonPath("$.operator").value("and"));
    }

    @Test
    public void testMissingAllParametersAnd() throws Exception {
        this.mvc.perform(get("/and"))
                .andExpect(status().isOk())
                .andExpect(content().string("0"));
    }

    @Test
    public void testMissingAllParametersAndJson() throws Exception {
        this.mvc.perform(get("/and_json"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.operand1").value(0))
                .andExpect(MockMvcResultMatchers.jsonPath("$.operand2").value(0))
                .andExpect(MockMvcResultMatchers.jsonPath("$.result").value(0))
                .andExpect(MockMvcResultMatchers.jsonPath("$.operator").value("and"));
    }

    @Test
    public void testZeroInputAndJson() throws Exception {
        this.mvc.perform(get("/and_json").param("operand1", "0").param("operand2", "0"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.operand1").value(0))
                .andExpect(MockMvcResultMatchers.jsonPath("$.operand2").value(0))
                .andExpect(MockMvcResultMatchers.jsonPath("$.result").value(0))
                .andExpect(MockMvcResultMatchers.jsonPath("$.operator").value("and"));
    }

    /*
     * TEST CASES for operator *
     */
    @Test
    public void testMultiply() throws Exception {
        this.mvc.perform(get("/multiply").param("operand1", "111").param("operand2", "1010"))// .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string("1000110"));
    }

    @Test
    public void testMultiplyJson() throws Exception {
        this.mvc.perform(get("/multiply_json").param("operand1", "111").param("operand2", "1010"))// .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.operand1").value(111))
                .andExpect(MockMvcResultMatchers.jsonPath("$.operand2").value(1010))
                .andExpect(MockMvcResultMatchers.jsonPath("$.result").value(1000110))
                .andExpect(MockMvcResultMatchers.jsonPath("$.operator").value("multiply"));
    }

    @Test
    public void testMissingAllParametersMultiply() throws Exception {
        this.mvc.perform(get("/multiply"))
                .andExpect(status().isOk())
                .andExpect(content().string("0"));
    }

    @Test
    public void testMissingAllParametersMultiplyJson() throws Exception {
        this.mvc.perform(get("/multiply_json"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.operand1").value(0))
                .andExpect(MockMvcResultMatchers.jsonPath("$.operand2").value(0))
                .andExpect(MockMvcResultMatchers.jsonPath("$.result").value(0))
                .andExpect(MockMvcResultMatchers.jsonPath("$.operator").value("multiply"));
    }

    @Test
    public void testZeroInputMultiplyJson() throws Exception {
        this.mvc.perform(get("/multiply_json").param("operand1", "0").param("operand2", "0"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.operand1").value(0))
                .andExpect(MockMvcResultMatchers.jsonPath("$.operand2").value(0))
                .andExpect(MockMvcResultMatchers.jsonPath("$.result").value(0))
                .andExpect(MockMvcResultMatchers.jsonPath("$.operator").value("multiply"));
    }
}