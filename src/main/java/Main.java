import java.util.Date;


import DAOs_implementation.CategoriaDAOimpl;
import DAOs_implementation.DonacionDAOimpl;
import DAOs_implementation.EmprendimientoDAOimpl;
import DAOs_implementation.PlanDAOimpl;
import DAOs_implementation.PosteoDAOimpl;
import DAOs_implementation.RedSocialDAOimpl;
import DAOs_implementation.UsuarioDAOimpl;
import model.Categoria;
import model.Donacion;
import model.Emprendimiento;
import model.Plan;
import model.Posteo;
import model.RedSocial;
import model.Usuario;

public class Main {

	public static void main(String[] args) {
		/*
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("myPersistence");
        EntityManager em = emf.createEntityManager();
        EntityTransaction etx = em.getTransaction();
		*/
		UsuarioDAOimpl usuarioDAO = new UsuarioDAOimpl();
		EmprendimientoDAOimpl emprendimientoDAO = new EmprendimientoDAOimpl();
		CategoriaDAOimpl categoriaDAO = new CategoriaDAOimpl();
		DonacionDAOimpl donacionDAO = new DonacionDAOimpl(); 
		PlanDAOimpl planDAO = new PlanDAOimpl();
		PosteoDAOimpl posteoDAO = new PosteoDAOimpl();
		RedSocialDAOimpl redSocialDAO = new RedSocialDAOimpl();
		
		
        Usuario usuario = new Usuario("pedroJm","pedrito@gmail.com","123456",true);
        Usuario usuario2 = new Usuario("juan569","juan@gmail.com","654321",false);
        
        Emprendimiento empre1 = new Emprendimiento("la historia sin fin");
        empre1.setUsuario(usuario);
        Emprendimiento empre2 = new Emprendimiento("huellitas, refugio de animales");
        empre2.setUsuario(usuario2);
        
        Categoria cate = new Categoria("delicatessen","comidas y bebidas de otro nivel","c://imagenes/categoria1.jpg");
        empre1.agregarCategoria(cate);
        Categoria cate2 = new Categoria("ONG","espacio destinado a organizaciones sin fines de lucro","c://imagenes/categoria2.jpg");
        empre2.agregarCategoria(cate2);
        
        Donacion donacion = new Donacion(25,100,"",new Date(),"efectivo",null,usuario,empre1);
       //que pasa aca con el emprendimiento
        
        Plan plan = new Plan(empre1,500.24);
        empre1.nuevoPlan(plan);
        //idem donacion
        
        Posteo posteo = new Posteo("Posteo 1","este es mi primer posteo","/foto.jpg",empre2);
        Posteo posteo2 = new Posteo("Posteo 2","este es mi segundo posteo","/foto2.jpg",empre2);
        empre2.nuevoPosteo(posteo);
        empre2.nuevoPosteo(posteo2);
        
        RedSocial redSocial = new RedSocial ("Fabook", "https://facebook.com.ar/huellitas");
        empre2.agregarRedSocial(redSocial);
        
        System.out.println("LINEA 1");
        usuarioDAO.persistir(usuario);
        usuarioDAO.persistir(usuario2);
       
        System.out.println("LINEA 3");
        categoriaDAO.persistir(cate);
        categoriaDAO.persistir(cate2);
        System.out.println("LINEA 4");
        donacionDAO.persistir(donacion);
        System.out.println("LINEA 4");
        //planDAO.persistir(plan);
        System.out.println("LINEA 5");
        redSocialDAO.persistir(redSocial);
        
        System.out.println("LINEA 2");
        emprendimientoDAO.persistir(empre1);
        
        /*
        empre1 = emprendimientoDAO.getEmprendimiento("huellitas, refugio de animales");
        List<Posteo> posteos = empre1.getPosteos();
        System.out.println("Titulo " + posteos.get(0).getTitulo());
        System.out.println("Titulo " + posteos.get(1).getTitulo());
        */
        
      
        
        


        
        
        
        
        /*
        etx.begin();
        em.persist(usuario);
        em.persist(empre1);
        em.persist(cate);
        em.persist(donacion);
        em.persist(plan);
        em.persist(posteo);
        em.persist(redsocial);
        etx.commit();
        */
	}

}
