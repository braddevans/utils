package uk.co.piratescode.utildev.databaseutils;

public class MysqlDatabase {

/*
    * @Name   MysqlUtil
    * @Author bradd evans
    *
    * use a basic logger import if you like with this in your main class:
    private static final Logger log = Logger.getLogger( Main.class.getName() );

    public static Logger getLog() {
        return log;
    }
    *
    * or use the logging util ~
    */

    //===============================================================================================================

    /*
     * Variables
     *   Variables Setup for this class and can be used in other classes if needed through the getters and setters
     *
     *   @author Bradd Evans
     *
     */

    //set this in the main class before anything else in this class
    public static String something = "";
    private static MysqlDatabase instance;


    //===============================================================================================================

    /*
     * Setters
     *   Set the values of the variables above
     *
     *   @author Bradd Evans
     *
     */

    public static void setSomething(String what){
        something = what;
    }

    //===============================================================================================================

    /*
     * Getters
     *   Get the values from the Variables that are set in the setters
     *      by default the values are blank
     *
     *   @author Bradd Evans
     *
     */

    // instantiate the class so it can reference private functions from other class's with SqliteDatabase().getInstance(). [insert function here]
    public static MysqlDatabase getInstance() {
        return instance;
    }

    //===============================================================================================================

    /*
     * Functions
     *   main used functions after getters and setters are set
     *
     *   @author Bradd Evans
     *
     */

    //code here


    //===============================================================================================================

    /*
     * Unused stuff
     *   @author Bradd Evans
     * some old code from past projects
     */

}
