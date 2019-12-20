package uk.co.piratescode.utildev.databaseutils;

import org.sqlite.SQLiteConfig;
import uk.co.piratescode.utildev.Main;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.*;

public class SqliteDatabase {

    /*
    * @Name   SqlitedbUtil
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
    public static String databasename = "";
    private static SqliteDatabase instance;


    //===============================================================================================================

    /*
     * Setters
     *   Set the values of the variables above
     *
     *   @author Bradd Evans
     *
     */

    public static void setDatabasename(String name){
        databasename = name;
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
    public static SqliteDatabase getInstance() {
        return instance;
    }

    public static String getDatabasename() {
        if (databasename.equals("")) {
            //log database name not set
        } else {

        }

        return databasename;
    }





    /*
    * Functions
    *   main used functions after getters and setters are set
    *
    *   @author Bradd Evans
    *
    */

    // connect
    public static Connection getconnection() {
        Connection connection = null;
        SQLiteConfig sc = new SQLiteConfig();
        sc.setEncoding(SQLiteConfig.Encoding.UTF_8);
        Path currentRelativePath = Paths.get("");
        String s = currentRelativePath.toAbsolutePath().toString();
        try {
            connection = DriverManager.getConnection("jdbc:sqlite:" + getDatabasename() + ".db", sc.toProperties());
            Statement maintable = connection.createStatement();
            maintable.execute("CREATE TABLE IF NOT EXISTS citys (id integer AUTO_INCREMENT PRIMARY KEY, name string, desc string, temp integer)");
            Main.getLog().info(": Opened database file: " + s + "/" + getDatabasename() + ".db");
        } catch (SQLException ex) {
            Main.getLog().info("Failed to create the database connection.");
            Main.getLog().info(ex.toString());
        }
        return connection;
    }



    //===============================================================================================================

    /*
     * Unused stuff
     *   @author Bradd Evans
     *
     *  old code from an initial job assessment
     */

    /*
    public static void addToDb(int id, String city, String desc, int temp) {
        try {
            Statement ps = getconnection().createStatement();
            ps.setQueryTimeout(30);
            ps.executeUpdate("insert into citys values(" + id + ",'" + city + "', '" + desc + "', '" + temp + "')");
        }catch(SQLException e){
            LoggerTab.Logger(Level.SEVERE, e.toString());
        }
    }

    public static void UpdateTempToDb(String city, int temp) {
        try {
            Statement ps = getconnection().createStatement();
            ps.setQueryTimeout(30);
            ps.executeUpdate("UPDATE citys SET temp= " + temp +" WHERE name = " + city);
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    public static int numberOfRows() {
        int count = 0;
        try {
            PreparedStatement ps = getconnection().prepareStatement("SELECT COUNT(*) FROM cities");
            ps.setQueryTimeout(30);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                count = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }

    public static ResultSet CitysFromId(int ID) {
        ResultSet rs = null;
        try {
            PreparedStatement ps = getconnection().prepareStatement("SELECT * FROM citys WHERE id = " + ID);
            ps.setQueryTimeout(30);
            rs = ps.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }

    public static ResultSet descFromId(int ID) {
        ResultSet rs = null;
        try {
            PreparedStatement ps = getconnection().prepareStatement("SELECT desc FROM citys WHERE id = " + ID);
            ps.setQueryTimeout(30);
            rs = ps.executeQuery();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }
    */
}