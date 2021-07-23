package com.api.login.controller;

import static org.assertj.core.api.Assertions.assertThat;

import com.api.login.dto.LoginResponseDto;
import com.api.login.dto.UserDto;
import com.api.login.service.UserService;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;



@RunWith(SpringRunner.class)

@WebMvcTest(value=LogInController.class)
class TestLogInController extends TestCase {
	@Autowired
	private MockMvc mockMvc;
	@MockBean
	private UserService userService;

	@Test
	public void testLogInController() throws Exception {

		UserDto appln = new UserDto();
		LoginResponseDto log = new LoginResponseDto();
		appln.setCustomerId(1L);
		appln.setPassword("abc");
		Mockito.when(userService.getlogInUserDetails(Mockito.any())).thenReturn(log);
		String uri = "/login";
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(uri).accept(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		String expectedJson = this.mapToJson(appln);
		String outputInJson = result.getResponse().getContentAsString();
		assertThat(outputInJson).isEqualTo(expectedJson);

	}

	private String mapToJson(Object object) throws JsonProcessingException{
		// TODO Auto-generated method stub
		ObjectMapper mapper = new ObjectMapper();
		return mapper.writeValueAsString(object);
	}


}
