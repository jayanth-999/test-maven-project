package com.maven;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

class HelloServletTest {
	
	@InjectMocks
	private HelloServlet helloServlet;
	
	@Mock
	private HttpServletRequest req;
	
	@Mock
	private HttpServletResponse resp;

	private StringWriter respWriter;
	
	@BeforeEach
	public void setUp() throws Exception {
		MockitoAnnotations.openMocks(this);
		respWriter = new StringWriter();
		when(resp.getWriter())
			.thenReturn(new PrintWriter(respWriter));
	}
	
	@Test
	void testDoGet() throws Exception {
		helloServlet.doGet(req, resp);
		verify(resp).setContentType("text/plain");
		
		String expectedMessage = "This is the message to be displayed on home page.";
		assertEquals(expectedMessage, respWriter.toString());
	
	}
	
	@Test
    void testDoGetWithException() throws Exception {
        when(resp.getWriter()).thenThrow(new IOException("Test Exception"));
        Exception exception = assertThrows(ServletException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                helloServlet.doGet(req, resp);
            }
        });
        assertEquals("Test Exception", exception.getCause().getMessage());
    }

}
