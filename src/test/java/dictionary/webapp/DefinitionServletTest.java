package dictionary.webapp;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.PrintWriter;
import java.io.StringWriter;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class DefinitionServletTest {

    HttpServletRequest request = Mockito.mock(HttpServletRequest.class);
    HttpServletResponse response = Mockito.mock(HttpServletResponse.class);

    DefinitionServlet servlet = new DefinitionServlet();

    StringWriter stringWriter = new StringWriter();
    PrintWriter writer = new PrintWriter(stringWriter);

    @Test
    public void doGet_realWord() throws Exception {
        // given
        stringWriter.flush();
        when(request.getParameter("word")).thenReturn("word");
        when(response.getWriter()).thenReturn(writer);

        // when
        servlet.doGet(request, response);

        // then
        verify(request, atLeast(1)).getParameter("word");
        verify(response, atLeast(1)).getWriter();
        assertEquals(
                "\"to express in words (speech sounds that " 
                        + "communicate meaning) [v -ED, -ING, -S]\"\n",
                stringWriter.toString());
    }

    @Test
    public void doGet_notRealWord() throws Exception {
        // given
        stringWriter.flush();
        when(request.getParameter("word")).thenReturn("wor");
        when(response.getWriter()).thenReturn(writer);

        // when
        servlet.doGet(request, response);

        // then
        verify(request, atLeast(1)).getParameter("word");
        verify(response, atLeast(1)).getWriter();
        assertEquals("\"Not a word\"\n", stringWriter.toString());
    }

}