
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.conditions.Text;
import org.junit.jupiter.api.Test;


import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class SimpleTests extends TestBase{

    @Test
    void successTest() {
        step("Open google.com", () -> {
            open("https://google.com");
        });

        step("search for 'selenide'", () -> {
            $(byName("q")).setValue("Selenide").pressEnter();
        });
        step("Check that selenide is displayed in the search results'", () -> {
            $("#rcnt").shouldHave(Condition.text("selenide.org"));
        });




    }
    @Test
    void negativeTest() {
        step("Open google.com", () -> {
            open("https://google.com");
        });

        step("search for 'selenide'", () -> {
            $(byName("q")).setValue("Selenide").pressEnter();
        });
        step("Check that weather.com is displayed in the search results'", () -> {
            $("#rcnt").shouldHave(Condition.text("weather.com"));
        });
    }
}
