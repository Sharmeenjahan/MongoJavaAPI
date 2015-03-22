/**Inserts into and reads data from mongodb database.
 * 
 * @ Sharmeen Jahan 
 * 
 */
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

public class TestMongoDB{
	
	MongoClient mongoClient;
	DB db;
	DBCollection coll;
	
	//Initialize the connection and get the database from mongodb instance.
   public void initConnection(){
      try{   
    	  // To connect to mongodb server
         mongoClient = new MongoClient( "localhost" , 27017 );
         // Now use to your databases
         db = mongoClient.getDB( "test" );
         //System.out.println("Connect to database successfully");
        
         coll = db.getCollection("mycol");
         //System.out.println("Collection mycol selected successfully");
         
      }
      catch (Exception e)
      {
    	  System.out.println(e.getMessage());
      }
   }
  
  //Insert documents into the database
  //@param number of documents we wish to insert.
   
   public void InsertRecords(int totalRecords){
	   
	   //store the start time in millisecond.
        long begin=System.currentTimeMillis();
        initConnection();
        
        //adding multiple documents using the loop.
        for (int i=0; i < totalRecords; i++) {
        	
           coll.insert(new BasicDBObject("i", i).append("name", Integer.toString(i)));
           
        }
        //store the end time in millisecond.
        long end=System.currentTimeMillis();
        //print the time difference.
        System.out.println(Thread.currentThread().getName() + ":"+ Long.toString(end-begin) + " miliseconds");
	   }
   
   //to print records. still in progress...
   public void ReadRecords(){
	   DBCursor cursor1=null;
	   
	   try{
        	//using a cursor to get all the docs
        	cursor1 = coll.find();
                
        	while(cursor1.hasNext()) {
               
                }
        }
        catch(Exception e)
        {
        	System.out.println(e.getMessage());
        }
        
        finally {
                    cursor1.close();
        }
}
   
   //remove all the data from database.
   public void Clean(){
	   
	   	initConnection();
    	coll.remove(new BasicDBObject());
	   
   }
}
