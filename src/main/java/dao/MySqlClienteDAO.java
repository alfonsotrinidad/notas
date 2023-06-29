package dao;

import java.util.List;

import entidad.Cliente;
import interfaces.InterfaceClienteDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import capa_datos.MysqlBDConexion;


public class MySqlClienteDAO implements InterfaceClienteDAO{

	@Override
	public int RegistrarCliente(Cliente clie) {
		int salida = -1;
		Connection conn= null;
		PreparedStatement pstm = null;
		try {
			
			conn = MysqlBDConexion.getConexion();
			String sql ="insert into cliente values(null,?,?,?)";
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, clie.getNombre());
			pstm.setString(2, clie.getApellido());
			pstm.setInt(3, clie.getEdad());
			//retorna el numero de insertados
			//1 --> Inserto un registro
			//0 --> No registro nada
			salida = pstm.executeUpdate();
	
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			try {
				if(pstm!= null) pstm.close();
				if(conn!= null) conn.close();
			} catch (Exception e2) {
			}
		}
		return salida;
		
	}

	@Override
	public List<Cliente> ListadoClientes() {
		
		List<Cliente> data = new ArrayList<Cliente>();
		
		
		Connection conn= null;
		PreparedStatement pstm = null;
		ResultSet rs = null;//registros
		try {
			conn = MysqlBDConexion.getConexion();//ok
			String sql ="select * from cliente";
			pstm = conn.prepareStatement(sql);
			rs = pstm.executeQuery();
			
			
			
			
			Cliente objclie = null;
			
			
			while(rs.next()){
				
				objclie = new Cliente();
	
				
				objclie.setId_cliente(rs.getInt("id_cliente"));
				objclie.setNombre(rs.getString("nombres"));
				objclie.setApellido(rs.getString("apellidos"));
				objclie.setEdad(rs.getInt("edad"));
				data.add(objclie);
			}

			
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			try {
				if(rs!= null) rs.close();
				if(pstm!= null) pstm.close();
				if(conn!= null) conn.close();
			} catch (Exception e2) {
			}
		}
		return data;

	}

	
}


