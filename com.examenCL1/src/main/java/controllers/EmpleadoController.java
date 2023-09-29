package controllers;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import models.Empleado;

public class EmpleadoController {
	
	//Crear Empleado - C
		public String createEmpleado(String apellido, String nombre, int edad, String sexo, String salario) {
			
			SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Empleado.class).buildSessionFactory();
			
			Session session = sessionFactory.openSession();
			
			try {
				
				Empleado empleado = new Empleado(apellido,nombre,edad,sexo,salario);
				
				session.beginTransaction();
				session.save(empleado);
				session.getTransaction().commit();
				
				sessionFactory.close();
				
				return "Empleado creado Satisfactoriamente";
				
			}catch(Exception e) {
				e.printStackTrace();
			}
			
			return "Error al registrar Empleado";
			
		}
		
	//Lectura de Empleado - R
		public String getEmpleado(int idEmpleado) {
			
			SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Empleado.class).buildSessionFactory();
			
			Session session = sessionFactory.openSession();
			
			try {
				session.beginTransaction();
				Empleado empleado = session.get(Empleado.class, idEmpleado);
				session.getTransaction().commit();
				sessionFactory.close();
				
				return empleado.toString();
				
			}catch(Exception e) {
				
				e.printStackTrace();
				
			}
			
			return "El empleado no existe";
		}
	//Actualizar Empleado - U
		public String updateEmpleado(int idEmpleado, String nombre) {
			
			SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Empleado.class).buildSessionFactory();
			
			Session session = sessionFactory.openSession();
			
			try {
				session.beginTransaction();
				Empleado empleado = session.get(Empleado.class, idEmpleado);
				empleado.setNombre(nombre);
				session.update(empleado);
				session.getTransaction().commit();
				
				sessionFactory.close();
				
				return "Empleado actualizado Satisfactoriamente";
				
			}catch(Exception e) {
				
				e.printStackTrace();
				
			}
			
			return "Error al actualizar el Empleado";
		}
	//Eliminar Empleado - D
		public String deleteEmpleado(int idEmpleado){
			
			SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Empleado.class).buildSessionFactory();
				
			Session session = sessionFactory.openSession();
			
			try {
							
				session.beginTransaction();
				Empleado empleado = session.get(Empleado.class, idEmpleado);
				session.delete(empleado);
				session.getTransaction().commit();
				
				sessionFactory.close();
				
				return "Empleado eliminado Satisfactoriamente";
				
			}catch(Exception e) {
				e.printStackTrace();
			}
			
			return "Error al eliminar el empleado";
		}
}
