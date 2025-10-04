package tools.internal;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggingManager {
    private static final Logger log = LogManager.getLogger(LoggingManager.class);

    private LoggingManager() {}

    public static void info(String msg) {
        log.info(msg);
        ReportManager.logStep(msg);
    }

    public static void debug(String msg) {
        log.debug(msg);
        // optional: ReportManager.logStep(msg);
    }

    public static void warn(String msg) {
        log.warn(msg);
        ReportManager.attachText("WARN", msg);
    }

    public static void error(String msg, Throwable t) {
        log.error(msg, t);
        ReportManager.attachText("ERROR", msg + (t == null ? "" : ("\n" + t.toString())));
    }
}
