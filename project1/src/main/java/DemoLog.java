import org.apache.log4j.xml.DOMConfigurator;

import java.util.logging.LogManager;
import java.util.logging.Logger;

public class DemoLog {

    static Logger logger = Logger.getLogger(String.valueOf(DemoLog.class));

    public static void main(String[ ] args) {
        try {

            factorial(9);
            factorial(-3);
        } catch (IllegalArgumentException e) {
            // вывод сообщения уровня ERROR
            logger.config("aaa");

        }
    }
    public static int factorial(int n) {
        if (n < 0) {
            throw new IllegalArgumentException(
                    "argument " + n +" less than zero");
        }
        // вывод сообщения уровня DEBUG
        logger.warning("Argument n is " + n);
        int result = 1;
        for (int i = n; i >= 1; i--) {
            result *= i;
        }
        // вывод сообщения уровня INFO
        logger.info("Result is " + result);
        return result;
    }
}
