
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.conditions.Text;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;


import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class SimpleTests extends TestBase{

    @Test
    @DisplayName("A positive test")
    @Tag("positive")
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
    @DisplayName("A negative test")
    @Tag("negative")
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
