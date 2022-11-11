package DAO;

import DAOs_implementation.CategoriaDAOimpl;
import DAOs_implementation.DonacionDAOimpl;
import DAOs_implementation.EmprendimientoDAOimpl;
import DAOs_implementation.PlanDAOimpl;
import DAOs_implementation.PosteoDAOimpl;
import DAOs_implementation.RedSocialDAOimpl;
import DAOs_implementation.UsuarioDAOimpl;
import DAOs_intefaces.CategoriaDAO;
import DAOs_intefaces.DonacionDAO;
import DAOs_intefaces.EmprendimientoDAO;
import DAOs_intefaces.PlanDAO;
import DAOs_intefaces.PosteoDAO;
import DAOs_intefaces.RedSocialDAO;
import DAOs_intefaces.UsuarioDAO;

public class DaoFactory {
	
	public static UsuarioDAO getUsuarioDAO() {
		return new UsuarioDAOimpl();
		}
	
	public static RedSocialDAO getRedSocialDAO() {
		return new RedSocialDAOimpl();
	}
	
	public static PosteoDAO getPosteoDAO() {
		return new PosteoDAOimpl();
	}
	
	public static PlanDAO getPlanDAO() {
		return new PlanDAOimpl();
	}
	
	public static EmprendimientoDAO getEmprendimientoDAO() {
		return new EmprendimientoDAOimpl();
	}
	
	public static DonacionDAO getDonacionDAO() {
		return new DonacionDAOimpl();
	}
	
	public static CategoriaDAO getCategoriaDAO() {
		return new CategoriaDAOimpl();
	}
}
