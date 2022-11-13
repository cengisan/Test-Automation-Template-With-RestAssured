package enums;

public enum DatabaseEnum {
     HOST("host"),
     USER("user"),
     PASSWORD("password"),
     CLASSNAME("org.postgresql.Driver"),
     FILEPATH("database.properties");

     private final String dbInfos;

     DatabaseEnum (String dbInfos) {
          this.dbInfos = dbInfos;
     }

     public String getDbInfo(){
          return dbInfos;
     }
}
