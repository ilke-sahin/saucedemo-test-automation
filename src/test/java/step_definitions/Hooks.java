package step_definitions;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import utilities.DriverManager;



    public class Hooks {


        @Before
        public void setUp() {

        }


        @After
        public void tearDown() {
            DriverManager.quitDriver();
        }
    }