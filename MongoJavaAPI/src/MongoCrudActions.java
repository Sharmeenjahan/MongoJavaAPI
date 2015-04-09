import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;


public class MongoCrudActions {
	
	MongoClient mongoClient;
	DB db;
	DBCollection dColl, mColl;	//collection variable to get the tables from database.
	
	//Initialize the connection and get the database from mongodb instance.
   public void initConnection(){
      try{   
    	  // To connect to mongodb server
         mongoClient = new MongoClient( "localhost" , 27017 );
         
         // Now use your databases
         db = mongoClient.getDB( "dbtest" );
        
        
         dColl = db.getCollection("departments");
         
         mColl = db.getCollection("dept_manager");
      }
      catch (Exception e)
      {
    	  System.out.println(e.getMessage());
      }
   }
  
  //Insert documents into the database
  //@param number of documents we wish to insert.
   
   public void InsertRecords(){
	   
        initConnection();
        BasicDBObject newRow = new BasicDBObject("dept_no","d001").append("manager_no", "01").append("manager_name", "chris");
       
        
        BasicDBObject whereQuery = new BasicDBObject();
    	whereQuery.put("dept_no", "d001");
    	DBCursor cursor = dColl.find(whereQuery);
    	while(cursor.hasNext()) {
    	    System.out.println(cursor.next());
    	    mColl.insert(newRow);
    	    
    	    //mColl.insert(new BasicDBObject("dept_no","d001").append("manager_no", "01").append("manager_name", "chris"));
    	}

    	
    	
    	
        //for (DBObject doc : cur) {
          //  String oId = (String) doc.get("_id");
            //System.out.println(dId);

            //String dName = (String) doc.get("dept_name");
            
            //System.out.println(dName);
            
            
            //if(oId != null)
        
          // mColl.insert(new BasicDBObject("dept_no","d001").append("manager_no", "01").append("manager_name", "chris"));
        //}   
   }
        
   

}
