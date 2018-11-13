package TASK1;

import static org.junit.Assert.assertTrue;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.junit.Test;


/**
 * Unit test for simple App.
 */
public class AppTest 
{

    @Test
    public void test() {
        PropertyConfigurator.configure("F:\\IntelliJ IDEA\\project\\TASK1\\src\\main\\resource\\log4j.properties");
        Logger logger = Logger.getLogger(AppTest.class);
        logger.debug("this is debug");
    }
}
