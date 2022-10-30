package singleton;

public class SingletonMain {

    public static void main(String[]arg){
        /*MongoDBClient mongoDBClient = MongoDBClient.getClient();
        System.out.println(mongoDBClient.getData());
        MongoDBClient mongoDBClient2 = MongoDBClient.getClient();
        System.out.println(mongoDBClient2.getData());
        MongoDBClient mongoDBClient3 = MongoDBClient.getClient();
        System.out.println(mongoDBClient3.getData());*/

        //PostgresClient Connection using Singleton
        PostgresDBClient postgresDBClient = PostgresDBClient.getClient();
        postgresDBClient.getData();
        PostgresDBClient postgresDBClient2 = PostgresDBClient.getClient();
        postgresDBClient2.getData();
        PostgresDBClient postgresDBClient3 = PostgresDBClient.getClient();
        postgresDBClient3.getData();
    }
}
