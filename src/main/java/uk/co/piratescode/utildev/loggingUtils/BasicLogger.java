package uk.co.piratescode.utildev.loggingUtils;

import java.util.logging.Logger;

public class BasicLogger {

    private static final Logger log = Logger.getLogger( BasicLogger.class.getName() );

    public static Logger getLog() {
        return log;
    }
}
