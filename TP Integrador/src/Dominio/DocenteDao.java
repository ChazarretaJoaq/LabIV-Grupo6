package Dominio;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;


public class DocenteDao {
	private static String host = "jdbc:mysql://localhost:3306/";
	private static String user = "root";
	private static String pass =  "";
	private static String dbName = "";
	
	
	public DocenteDao(){
		
	}
	
	public int agregarDocente(Docente docente){
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();						
		}
		String query="INSERT INTO docentes(dni,nombre,apellido,fechanacimiento,direccion,localidad,nacionalidad,email,telefono)VALUES('"+docente.getDni()+"','"+docente.getNombre()+"','"+docente.getApellido()+"','"+docente.getFechanacimiento()+"','"+docente.getDireccion()+"','"+docente.getLocalidad()+"','"+docente.getNacionalidad()+"','"+docente.getEmail()+"','"+docente.getTelefono()+"')";
		Connection cn = null;
		int filas =0;
		try {
			cn = DriverManager.getConnection(host+dbName,user,pass);
			Statement st =cn.createStatement();
			filas = st.executeUpdate(query);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return filas;
		}
		
		
	}
	
	
