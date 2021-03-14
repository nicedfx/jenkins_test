
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.conditions.Text;
import org.junit.jupiter.api.Test;


import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SimpleTests extends TestBase{

    @Test
    void successTest() {
        open("https://google.com");
        $(byName("q")).setValue("Selenide").pressEnter();
        $("#rcnt").shouldHave(Condition.text("selenide.org"));

    }
    @Test
    void negativeTest() {

    }
}
