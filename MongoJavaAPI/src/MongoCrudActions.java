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
   
   public void insertRecords(String dept_no){
	   
        initConnection();
        
        //select the dept_no from department table
        BasicDBObject whereQuery = new BasicDBObject();
    	whereQuery.put("dept_no", dept_no);
    	DBCursor cursor = dColl.find(whereQuery);
    	while(cursor.hasNext()) {
    	    DBObject dept=cursor.next();
    	    Object id=dept.get("_id");
    	    BasicDBObject newRow = new BasicDBObject("dept_no",id).append("manager_no", "01").append("manager_name", "chris");
    	      
    	    mColl.insert(newRow);
    	    System.out.println(newRow);
    	    
    	}
   }

    public void readRecords(String mName){
    		   
    	 initConnection();
    	        
    	 //select the dept_no from manager table
    	 BasicDBObject mQuery = new BasicDBObject();
    	 mQuery.put("manager_name",mName);
    	 DBCursor cur1 = mColl.find(mQuery);
    	 while(cur1.hasNext()) {
    	     DBObject mRow=cur1.next();
    	     Object id=mRow.get("dept_no");
    	    	    
    	     //now select the dept_name from dept table using var id/dept_no of manager table
    	     BasicDBObject dQuery = new BasicDBObject();
    	     dQuery.put("_id", id);
    	     DBCursor cur2 = dColl.find(dQuery);
    	     while (cur2.hasNext()){
    	    	 DBObject dRow = cur2.next();
    	    	 String dName = (String) dRow.get("dept_name");
    	    	 System.out.println(dName);
    	     }
    	 }
    }
    	
}
