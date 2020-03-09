package es.cifpcm.emprinfgonzalezveronica.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DaoFactory {
private final Logger logger = LoggerFactory.getLogger(DaoFactory.class);
    
    private static DaoFactory instance;
    
    protected final DaoConfig dfc;

    // Se ejecuta una sola vez
    protected DaoFactory(DaoConfig dfc) {
        this.dfc = new DaoConfig(dfc);
        try {
            Class.forName(dfc.getDriverClassName());
            logger.debug("Cargado driver de base de datos {}", dfc.getDriverClassName());
        } catch (ClassNotFoundException ex) {
            logger.error("Error cargando driver", ex);
        }
    }

    /**
     *
     * @return
     */
    public Connection getConnection() {
        try {
            return DriverManager.getConnection(dfc.getDatabaseUrl(),
                    dfc.getDatabaseUser(), dfc.getDatabasePassword());
        } catch (SQLException ex) {
            logger.error("getConnection", ex);
            return null;
        }
    }

    /**
     *
     * @param conn
     */
    public void closeConnection(Connection conn) {
        
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException ex) {
                logger.error("closeConnection", ex);
            }
        }
        
    }

    /**
     *
     * @return
     */
    public FacturaDao getFacturaDao() {
        return new ImpFacDao(this);
    }

    /**
     * Se llama la primera vez para crear la fábrica de objetos.
     * 
     * @param dfc
     * @return
     */
    public static synchronized DaoFactory createInstance(DaoConfig dfc) {

        // El método es synchronized, no pueden entrar dos hilos a la vez
        // Se asegura que sólo se crea una instancia de la DaoFactory
        if (instance == null) {
            instance = new DaoFactory(dfc);
        }
        return instance;        
    }
    
    /**
     *  Devuelve la fábrica creada
     * 
     * @return
     */
    public static DaoFactory getInstance() {
        return instance;
    }
}