package dictionary.webapp;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.PrintWriter;

import static org.mockito.Mockito.*;

class DefinitionServletTest {

    HttpServletRequest request = Mockito.mock(HttpServletRequest.class);
    HttpServletResponse response = Mockito.mock(HttpServletResponse.class);

    DefinitionServlet servlet = new DefinitionServlet();

    @Test
    public void doGet_realWord() throws Exception {
        // given
        PrintWriter writer = Mockito.mock(PrintWriter.class);
        when(request.getParameter("word")).thenReturn("word");
        when(response.getWriter()).thenReturn(writer);

        // when
        servlet.doGet(request, response);

        // then
        verify(request).getParameter("word");
        verify(response).getWriter();
        verify(writer).println("\"to express in words (speech sounds that "
                + "communicate meaning) [v -ED, -ING, -S]\"");
    }

    @Test
    public void doGet_notRealWord() throws Exception {
        // given
        PrintWriter writer = Mockito.mock(PrintWriter.class);
        when(request.getParameter("word")).thenReturn("wor");
        when(response.getWriter()).thenReturn(writer);

        // when
        servlet.doGet(request, response);

        // then
        verify(request).getParameter("word");
        verify(response).getWriter();
        verify(writer).println("\"Not a word\"");
    }

}