import com.testautomation.utils.LogUtils;
import com.testautomation.utils.WebDriverUtils;
import io.cucumber.junit.Cucumber;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
public class TestRunner{

    @BeforeClass
    public static void beforeClass(){
        LogUtils.initLogger();
    }

    @AfterClass
    public static void afterClass() throws Exception {
        WebDriverUtils.killDrivers();
    }

}