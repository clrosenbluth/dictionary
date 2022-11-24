package dictionary.webapp;

import com.google.gson.Gson;
import dictionary.Dictionary;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DefinitionServlet extends HttpServlet {
    private final Dictionary dictionary;
    private final Gson gson = new Gson();

    public DefinitionServlet() {
        dictionary = new Dictionary();
    }

    @Override
    public void doGet(HttpServletRequest request,
                      HttpServletResponse response) throws IOException {

        String word = request.getParameter("word");

        String definition = dictionary.isWord(word)
                ? dictionary.getDefinition(word)
                : "Not a word";

        response.setContentType("text/json");
        response.getWriter().println(gson.toJson((definition)));
    }
}
