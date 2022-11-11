import java.util.Date;
import java.util.List;

import DAOs_implementation.CategoriaDAOimpl;
import DAOs_implementation.EmprendimientoDAOimpl;
import DAOs_implementation.PosteoDAOimpl;
import DAOs_implementation.RedSocialDAOimpl;
import DAOs_implementation.UsuarioDAOimpl;
import model.Categoria;
import model.Donacion;
import model.DonacionManguito;
import model.DonacionPlan;
import model.Emprendimiento;
import model.Plan;
import model.Posteo;
import model.RedSocial;
import model.Usuario;

public class Main {

	public static void main(String[] args) {
		
		//DAOs
		UsuarioDAOimpl usuarioDAO = new UsuarioDAOimpl();
		EmprendimientoDAOimpl emprendimientoDAO = new EmprendimientoDAOimpl();
		CategoriaDAOimpl categoriaDAO = new CategoriaDAOimpl();
		PosteoDAOimpl posteoDAO = new PosteoDAOimpl();
		RedSocialDAOimpl redSocialDAO = new RedSocialDAOimpl();
		
		//Usuarios
		System.out.println("Comienza armado usuarios");
		Usuario usuario0 = new Usuario("nico","nico@gmail.com","123456",true);
		Usuario usuario1 = new Usuario("pedroJm","pedrito@gmail.com","123456",false);
        Usuario usuario2 = new Usuario("juan569","juan@gmail.com","2222",false);
        Usuario usuario3 = new Usuario("sabri890","sabri@gmail.com","3333",false);
        Usuario usuario4 = new Usuario("agus5667","agustin@gmail.com","4444",false);
        Usuario usuario5 = new Usuario("sara123","sara@gmail.com","5555",false);
        Usuario usuario6 = new Usuario("pollo569","pepe@gmail.com","6666",false);
        System.out.println("Fin armado usuarios");

        
        //Categorias
        Categoria cate1 = new Categoria("delicatessen","comidas y bebidas de otro nivel","c://imagenes/categoria1.jpg");
        Categoria cate2 = new Categoria("ONG","espacio destinado a organizaciones sin fines de lucro","c://imagenes/categoria2.jpg");
        Categoria cate3 = new Categoria("Salud","todo lo relacionado con la salud","c://imagenes/categoria3.jpg");
        Categoria cate4 = new Categoria("Nutricion","comer sano es vida","c://imagenes/categoria4.jpg");
        Categoria cate5 = new Categoria("Mascotas","compañéros de vida","c://imagenes/categoria5.jpg");
        System.out.println("Fin armado categorias");

        
        //Emprendimientos
        Emprendimiento empre1 = new Emprendimiento("la historia sin fin, viajando por el mundo");
        Emprendimiento empre2 = new Emprendimiento("huellitas, refugio de animales");
        Emprendimiento empre3 = new Emprendimiento("Pepe, el huron albino");
        Emprendimiento empre4 = new Emprendimiento("Vida sanda, comida saludable");
        System.out.println("Fin armado emprendimientos sin valores");
        
 
        //Posteos
        Posteo posteo1 = new Posteo("Amsterdam","capital de los Países Bajos.","/foto1.jpg"); 
        Posteo posteo2 = new Posteo("Mar del Plata","mar y lobos marinos","/foto2.jpg");
        Posteo posteo3 = new Posteo("Teo","la vida de un pekines","/foto3.jpg");
        Posteo posteo4 = new Posteo("Chinchulin","el gato que vivio","/foto4.jpg");
        Posteo posteo5 = new Posteo("La vida con un pepe","como es convivir con un huron","/foto5.jpg");
        Posteo posteo6 = new Posteo("Pan de masa madre","el nuevo mundo de la masa madre","/foto6.jpg");
        System.out.println("Fin armado posteos");
        
        
        //Planes
        Plan plan1 = new Plan(empre1,500);
        Plan plan2 = new Plan(empre2,250);
        Plan plan3 = new Plan(empre2,100);
        Plan plan4 = new Plan(empre4,1000);
        plan4.setDestallesBeneficio("Acceso a las recetas exclusivas");
        System.out.println("Fin armado de planes");
      
        
        //Donaciones
        Donacion donacion1 = new DonacionManguito(100,"segui asi",new Date(),"efectivo",usuario5,50);
        Donacion donacion2 = new DonacionManguito(200,"suerte",new Date(),"efectivo",usuario6,150);
        Donacion donacion3 = new DonacionManguito(100,"buen viaje",new Date(),"tarjeta de credito",usuario6,80);
        Donacion donacion4 = new DonacionManguito(300,"muy rico",new Date(),"tarjeta de credito",usuario6,40);
        Donacion donacion5 = new DonacionManguito(100,"segui asi",new Date(),"efectivo",usuario5,10);
        
        Donacion donacion6 = new DonacionPlan(100,"segui asi",new Date(),"efectivo",usuario5,plan1);
        Donacion donacion7 = new DonacionPlan(100,"segui asi",new Date(),"efectivo",usuario6,plan2);
        Donacion donacion8 = new DonacionPlan(100,"segui asi",new Date(),"efectivo",usuario6,plan2);
        Donacion donacion9 = new DonacionPlan(100,"segui asi",new Date(),"efectivo",usuario6,plan4);
        System.out.println("Fin armado de donaciones");
        
        //Redes sociales
        RedSocial redSocial1 = new RedSocial ("Facebook", "https://facebook.com.ar/huellitas");
        RedSocial redSocial2 = new RedSocial ("Instagram", "https://facebook.com.ar/huellitas");
        RedSocial redSocial3 = new RedSocial ("Twitter", "https://facebook.com.ar/huellitas");
        RedSocial redSocial4 = new RedSocial ("Instagram", "https://facebook.com.ar/viajandoAndo");
        RedSocial redSocial5 = new RedSocial ("Facebook", "https://facebook.com.ar/viajandoAndo");
        RedSocial redSocial6 = new RedSocial ("Instagram", "https://facebook.com.ar/vidaSana");
        RedSocial redSocial7 = new RedSocial ("Instagram", "https://facebook.com.ar/el_huron_pepe");
        System.out.println("Fin armado de redes sociales");
       
        
        //Armado de emprendimiento 1
        empre1.agregarCategoria(cate1);
        empre1.agregarCategoria(cate2);
        empre1.nuevoPosteo(posteo1);
        empre1.nuevoPosteo(posteo2);
        empre1.nuevoPlan(plan1);
        empre1.agregarRedSocial(redSocial4);
        empre1.agregarRedSocial(redSocial5);
        empre1.agregarDonacion(donacion1);
        empre1.agregarDonacion(donacion2);
        empre1.agregarDonacion(donacion3);
        empre1.agregarDonacion(donacion6);
        usuario1.registrarEmprendimiento(empre1);
        
        //Armado de emprendimiento 2
        empre2.agregarCategoria(cate5);
        empre2.agregarCategoria(cate2);
        empre2.nuevoPosteo(posteo3);
        empre2.nuevoPosteo(posteo4);
        empre2.nuevoPlan(plan2);
        empre2.nuevoPlan(plan3);
        empre2.agregarRedSocial(redSocial1);
        empre2.agregarRedSocial(redSocial2);
        empre2.agregarRedSocial(redSocial3);
        empre2.agregarDonacion(donacion7);
        empre2.agregarDonacion(donacion8);
        usuario2.registrarEmprendimiento(empre2);
        
        //Armado de emprendimiento 3
        empre3.agregarCategoria(cate5);
        empre3.nuevoPosteo(posteo5);
        empre3.agregarRedSocial(redSocial7);
        empre3.agregarDonacion(donacion5);
        usuario3.registrarEmprendimiento(empre3);
        
        //Armado de emprendimiento 4
        empre4.agregarCategoria(cate1);
        empre4.agregarCategoria(cate3);
        empre4.agregarCategoria(cate4);
        empre4.nuevoPosteo(posteo6);
        empre4.nuevoPlan(plan4);
        empre4.agregarRedSocial(redSocial6);
        empre4.agregarDonacion(donacion4);
        empre4.agregarDonacion(donacion9);
        usuario4.registrarEmprendimiento(empre4);

        
        //persistencia de categorias
        categoriaDAO.persistir(cate1);
        categoriaDAO.persistir(cate2);
        categoriaDAO.persistir(cate3);
        categoriaDAO.persistir(cate4);
        categoriaDAO.persistir(cate5);
        System.out.println("Persistencia de categorias terminada");
        
        //persistencia de redes sociales
        redSocialDAO.persistir(redSocial1);
        redSocialDAO.persistir(redSocial2);
        redSocialDAO.persistir(redSocial3);
        redSocialDAO.persistir(redSocial4);
        redSocialDAO.persistir(redSocial5);
        redSocialDAO.persistir(redSocial6);
        redSocialDAO.persistir(redSocial7);
        System.out.println("Persistencia de redes sociales terminada");

        //persistencia de posteos
        posteoDAO.persistir(posteo1);
        posteoDAO.persistir(posteo2);
        posteoDAO.persistir(posteo3);
        posteoDAO.persistir(posteo4);
        posteoDAO.persistir(posteo5);
        posteoDAO.persistir(posteo6);
        System.out.println("Persistencia de posteos terminada");
        
        
        //persistencia de los usuarios
        usuarioDAO.persistir(usuario0);
        usuarioDAO.persistir(usuario1);
        usuarioDAO.persistir(usuario2);
        usuarioDAO.persistir(usuario3);
        usuarioDAO.persistir(usuario4);
        usuarioDAO.persistir(usuario5);
        usuarioDAO.persistir(usuario6);
        System.out.println("Persistencia de Usuarios terminada");
       
        /*
        //persistencia de donaciones
        donacionDAO.persistir(donacion1);
        donacionDAO.persistir(donacion2);
        donacionDAO.persistir(donacion3);
        donacionDAO.persistir(donacion4);
        donacionDAO.persistir(donacion5);
        donacionDAO.persistir(donacion6);
        donacionDAO.persistir(donacion7);
        donacionDAO.persistir(donacion8);
        donacionDAO.persistir(donacion9);
        System.out.println("Persistencia de donaciones terminada");
		
        
        //persistencia de emprendimientos
        System.out.println("Arranca Persistencia de emprendimientos");
        emprendimientoDAO.persistir(empre1);
        emprendimientoDAO.persistir(empre2);
        emprendimientoDAO.persistir(empre3);
        emprendimientoDAO.persistir(empre4);
        System.out.println("Persistencia de emprendimientos terminada");
        
        
        //persistencia de planes
        planDAO.persistir(plan1);
        planDAO.persistir(plan2);
        planDAO.persistir(plan3);
        planDAO.persistir(plan4);
        System.out.println("Persistencia de planes terminada");
        */
        
		System.out.println("FIN DE PERSISTENCIA");
		
		//Pruebas DAOs
		usuario1 = usuarioDAO.getUsuario("sabri890");
		System.out.println(usuario1.getEmail());
                
		usuario1 = usuarioDAO.recuperar(3);
		System.out.println(usuario1.getEmail());
		
		usuario1.setEmail("nuevoemail@gmail.com");
		System.out.println("se cambio el email del usuario " + usuario1.getNombre());
		usuarioDAO.actualizar(usuario1);
		
		usuarioDAO.borrarUsuarioPorNombre("nico");
		System.out.println("usuario borrado");

		empre1 = usuarioDAO.getUsuario("juan569").getEmprendimiento();
		System.out.println(empre1.getNombre());
		System.out.println("Las categorias de emprendimiento son");
        List<Categoria>categorias = empre1.getCategorias();
        for (Categoria cate : categorias) {
        	System.out.println(cate.getNombre());
        }
        categorias.remove(1);
      	empre1.seListaCategorias(categorias);
      	emprendimientoDAO.actualizar(empre1);
      	System.out.println("Categoria borrada del emprendimiento");
      	
      	empre1 = usuarioDAO.getUsuario("juan569").getEmprendimiento();
		System.out.println(empre1.getNombre());
		System.out.println("Las categorias de emprendimiento son");
		categorias = empre1.getCategorias();
        for (Categoria cate : categorias) {
        	System.out.println(cate.getNombre());
        }
        
        List<RedSocial>redes = redSocialDAO.getRedesEmprendimiento("huellitas, refugio de animales");
        for (RedSocial red : redes){
        	System.out.println(red.getNombre() + red.getUrl());
        }

	}

}
