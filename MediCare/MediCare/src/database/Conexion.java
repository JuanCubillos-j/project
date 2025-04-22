/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package database; // Paquete donde se encuentra la clase de conexión a base de datos

// Importaciones necesarias para manejar conexiones de base de datos y mostrar mensajes
// Clase necesaria para establecer y manejar conexiones con bases de datos
import java.sql.Connection;
// Clase que proporciona métodos para establecer conexiones con bases de datos a través de DriverManager
import java.sql.DriverManager;
// Clase para manejar excepciones específicas de SQL que pueden ocurrir durante operaciones de base de datos
import java.sql.SQLException;
// Clase de Swing para mostrar cuadros de diálogo emergentes con mensajes al usuario
import javax.swing.JOptionPane;


 

public class Conexion {
    
    public static void main(String[] args) {
        try {
            // Obtener la instancia de conexión usando el método Singleton
            Conexion conexionDB = Conexion.getInstancia();
            
            // Establecer la conexión
            Connection connection = conexionDB.conectar();
            
            // Verificar si la conexión fue exitosa
            if (connection != null) {
                System.out.println("Conexion establecida correctamente a la base de datos.");
                
                // Realizar cualquier operación adicional si se requiere
                
                // Cerrar la conexión
                conexionDB.desconectar();
                System.out.println("Conexion cerrada.");
            }
        } catch (Exception e) {
            // Manejo de cualquier excepción que pueda ocurrir
            System.err.println("Error en la conexion: " + e.getMessage());
            e.printStackTrace();
        }
    }

    
    // Constantes para configurar la conexión a la base de datos MySQL
    private final String DRIVER = "com.mysql.jdbc.Driver"; // Driver JDBC para MySQL
    private final String URL = "jdbc:mysql://localhost:3306/"; // URL base de conexión
    private final String DB = "medicare"; // Nombre de la base de datos
    private final String USER = "root"; // Usuario de la base de datos
    private final String PASSWORD = ""; // Contraseña de la base de datos
    
    // Objeto de conexión que se utilizará para establecer la conexión con la base de datos
    public Connection cadena;
    
    // Instancia única de la clase (patrón Singleton)
    public static Conexion instancia;
    
    // Constructor privado para evitar la creación de múltiples instancias
    private Conexion() {
        this.cadena = null; // Inicializa la conexión como nula
    }
    
    // Método para establecer la conexión con la base de datos
    public Connection conectar() {
        try {
            // Cargar el driver de MySQL
            Class.forName(DRIVER);
            
            // Establecer la conexión usando los parámetros definidos
            this.cadena = DriverManager.getConnection(URL + DB, USER, PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            // Mostrar mensaje de error si hay problemas al conectar
            JOptionPane.showMessageDialog(null, e.getMessage());
            
            // Salir del programa en caso de error de conexión
            System.exit(0);
        }
        // Devolver el objeto de conexión
        return this.cadena;
    }
    
    // Método para cerrar la conexión con la base de datos
    public void desconectar() {
        try {
            // Cerrar la conexión activa
            this.cadena.close();
        } catch (SQLException e) {
            // Mostrar mensaje de error si hay problemas al desconectar
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
    // Método para obtener la instancia única de la clase (patrón Singleton)
    public synchronized static Conexion getInstancia() {
        // Si no existe una instancia, crear una nueva
        if (instancia == null) {
            instancia = new Conexion();
        }
        // Devolver la instancia única
        return instancia;
    }
}
