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
//	   	//db.InitConnection();
	   	
	   	MongoCrudActions mon= new MongoCrudActions();
	   	
	   	//Insert a record in manager table if the dept is valid in department table
	   	mon.InsertRecords("d001");
	   	
	   	//Read the dept_name from department table using the manager name from the manager table
	   	mon.readRecords("chris");
	   	
	   	
//	   	db.Clean();
//	   	//take the start time to get the total time it takes to complete all threads.
//	   	long begin=System.currentTimeMillis();
//	   	
//	   	int totalThreads=10;
//	   	//creating an array of threads.
//	   	Thread[] threads= new Thread[totalThreads];
//	   	
//		for (int i = 0; i < totalThreads; i++) {
//			//creating each thread with a thread number.
//			Thread t=new Thread("Thread #" + Integer.toString(i)){
//				//inserting 1000 documents in each thread.
//				public void run(){
//					TestMongoDB mon=new TestMongoDB();
//					//mon.InitConnection();
//					mon.InsertRecords(100);
//					//System.out.println(" miliseconds.");
//				}
//			};
//			t.start();
//			threads[i]=t;
//		}
//		
//		//Get the total time it needs to complete the operation of all threads.
//		for(int i=0 ; i<totalThreads;i++)
//		{
//			try
//			{
//			//wait for the thread to be completed.We need that to get the total time of the whole operation.	
//			threads[i].join();
//			}
//			catch(InterruptedException e)
//			{
//			}
//			
//		}
//		//getting the end time of the operation.
//   		long end=System.currentTimeMillis();
//   		//print the time difference of the total insertion.
//   		System.out.println();
//   		System.out.println("Total:" + Long.toString(end-begin) + " miliseconds.");
 }
	   	
}
