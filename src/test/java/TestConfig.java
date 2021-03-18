import org.aeonbits.owner.Config;

@Config.Sources("classpath:${cfg}.properties")
public interface TestConfig extends Config {

    @Key("browser")
    @DefaultValue("chrome")
    String browser();

    @Key("browserVersion")
    @DefaultValue("89")
    String browserVersion();

    @Key("isRemote")
    @DefaultValue("false")
    boolean isRemote();

    @Key("selenoidUrl")
    @DefaultValue("localhost")
    String selenoidUrl();


    @Key("startMaximized")
    @DefaultValue("false")
    boolean startMaximized();


}
