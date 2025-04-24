package utils;

//IMPORTAR LOS PAQUETES NECESARIOS PARA LA CONEXION A LA BASE DE DATOS
//====================================================================
import java.sql.Connection;
import java.sql.DriverManager;

public class SqlDBConn
{
	//METODO PARA INVOCAR EL USO DE LA LIBRERIA
	//=========================================
	static
	{
		try
		{Class.forName("com.mysql.jdbc.Driver");}
		catch (Exception e)
		{
			System.out.println("Errror"+e);
		}
	}

	//METODO PARA CREAR LA CONEXION A LA BASE DE DATOS
	//================================================
	public static Connection getConnection(String db)
	{
		Connection connection=null;
		try {
			
			connection=
			DriverManager.getConnection("jdbc:mysql://localhost:3306/"+db,"root","");
			//DriverManager.getConnection("jdbc:mysql://localhost:3306/"+db,"root","root");
			
		}catch (Exception e)
		{
			System.out.println("");
		}
		return connection;
	}
	/*public static void main(String arg[]) {
		SqlDBConn cnx =new SqlDBConn();
		if (cnx.equals(1)){
			System.out.print(true);
		}else {
			System.out.print(false);
		}
		
	}*/
}