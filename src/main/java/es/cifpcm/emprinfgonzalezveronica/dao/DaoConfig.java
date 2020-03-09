package es.cifpcm.emprinfgonzalezveronica.dao;

public class DaoConfig {
	 private String driverClassName;
	    private String databaseUrl;
	    private String databaseUser;
	    private String databasePassword;

	    public DaoConfig() {
	    }

	    public DaoConfig(String driverClassName, String databaseUrl, String databaseUser, String databasePassword) {
	        this.driverClassName = driverClassName;
	        this.databaseUrl = databaseUrl;
	        this.databaseUser = databaseUser;
	        this.databasePassword = databasePassword;
	    }

	    public DaoConfig(DaoConfig dfc) {
			// TODO Auto-generated constructor stub
		}

		public String getDriverClassName() {
	        return driverClassName;
	    }

	    public void setDriverClassName(String driverClassName) {
	        this.driverClassName = driverClassName;
	    }

	    public String getDatabaseUrl() {
	        return databaseUrl;
	    }

	    public void setDatabaseUrl(String databaseUrl) {
	        this.databaseUrl = databaseUrl;
	    }

	    public String getDatabaseUser() {
	        return databaseUser;
	    }

	    public void setDatabaseUser(String databaseUser) {
	        this.databaseUser = databaseUser;
	    }

	    public String getDatabasePassword() {
	        return databasePassword;
	    }

	    public void setDatabasePassword(String databasePassword) {
	        this.databasePassword = databasePassword;
	    }

}