/** @author Sharmeen Jahan 
 * 
 * Test the CRUD actions of mongodb in java API */
import com.mongodb.MongoClient;
import com.mongodb.MongoException;
import com.mongodb.WriteConcern;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.DBCursor;
import com.mongodb.ServerAddress;
import java.util.Arrays;


public class MongoJavaAPI{
   public static void main( String args[] )
   {
	    //First clean the database.
	   	//TestMongoDB db=new TestMongoDB();
	   	//db.InitConnection();
	   	
	   	MongoCrudActions mon= new MongoCrudActions();
	   	
	   	//Insert a record in manager table if the dept is valid in department table
	   	mon.insertRecords("d001");
	   	
	   	//Read the dept_name from department table using the manager name from the manager table
	   	mon.readRecords("chris");
	   	
   }
	   	
}
