package retrofit;


public class Config {
    public static String google = "http://www.google.com/search?q=";
	public static String search = "Egpyt";
	public static String charset = "UTF-8";
	public static String optmizationSearch = null ; 
	public static String userAgent = "ESlam FAmhy";
	
	
	public static void setOptmizationSearch (String txt) {
		optmizationSearch = txt;
	}
	
	public static void clearOptmizationSearch () {
		optmizationSearch = null;
	}

}
