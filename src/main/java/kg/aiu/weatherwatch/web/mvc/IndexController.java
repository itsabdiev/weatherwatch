package kg.aiu.weatherwatch.web.mvc;


import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class IndexController {


    @GetMapping
    @ResponseBody
    public String getIndex() {
        return "<html lang=\"en\">\n" +
                "<head>\n" +
                "<meta charset=\"UTF-8\">\n" +
                "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
                "<title>Weather Watch</title>\n" +
                "<style>\n" +
                "  @import url('https://fonts.googleapis.com/css2?family=JetBrains+Mono:ital,wght@0,100..800;1,100..800&display=swap');\n" +
                "\n" +
                "  body {\n" +
                "    font-family: \"JetBrains Mono\", monospace;\n" +
                "    height: 100%;\n" +
                "    font-weight: 600;\n "+
                "    margin: 0;\n" +
                "    display: flex;\n" +
                "    justify-content: center;\n" +
                "    align-items: center;\n" +
                "    background-color: #f0f0f0; \n" +
                "  }\n" +
                "\n" +
                "  .title {\n" +
                "    font-size: 3em;\n" +
                "    text-align: center;\n" +
                "    border: 2px solid #333;\n" +
                "    padding: 20px;\n" +
                "    max-width: 80%;\n" +
                "    background: linear-gradient(45deg, #FFC107, #FF5722); \n" +
                "    -webkit-background-clip: text;\n" +
                "    -webkit-text-fill-color: transparent;\n" +
                "  }\n" +
                "</style>\n" +
                "</head>\n" +
                "<body>\n" +
                "\n" +
                "<div class=\"title\">Weather Watch</div>\n" +
                "\n" +
                "</body>\n" +
                "</html>";
    }
}
