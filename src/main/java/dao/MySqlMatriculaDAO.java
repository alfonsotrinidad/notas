package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import capa_datos.MysqlBDConexion;
import entidad.Matricula;
import entidad.Profesor;
import interfaces.InterfaceMatriculaDAO;

public class MySqlMatriculaDAO implements InterfaceMatriculaDAO{

	@Override
	public List<Matricula> ListadoMatriculas() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Matricula> GetMatriculaPorIdProfesor(String codProfesor) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Matricula> GetMatriculaPorIdAlumno(String codAlumno) {
		// TODO Auto-generated method stub
		return null;
	}




}
