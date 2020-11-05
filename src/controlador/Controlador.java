package controlador;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Set;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JPanel;

import logica.Clasificador;
import logica.Grafo;
import logica.Persona;
import logica.Punto;
import visual.Grafico;
import datos.GestorJSON;
import datos.PersonasJSON;

public class Controlador {

	static Clasificador clasificador = new Clasificador();

	public static void agregarPersona(String nombre, int musica, int deporte, int espectaculo, int ciencia, int arte) {
		clasificador.cargarPersona(nombre, musica, deporte, espectaculo, ciencia, arte);
		GestorJSON.agregarPersonas(new Persona(nombre, musica, deporte, espectaculo, ciencia, arte));

	}

	public static void cargarDatosEnClasificador(String nombreDelArchivo) {
		PersonasJSON personas = PersonasJSON.leerJSON(nombreDelArchivo);
		ArrayList<Persona> paraCargar = personas.getPersonas();
		for (Persona p : paraCargar) {
			clasificador.agregarPersonas(p);
		}
	}

	public static void cargarBase() {
		cargarDatosEnClasificador("PersonasPretty.JSON");
	}

	public static void cargarActual() {
		cargarDatosEnClasificador("usuarios.JSON");
	}

	public static void guardarPersona() {
		GestorJSON.guardarPersonas();
	}

	public static ArrayList<Set<Persona>>  obtenerGrupos() {
		ArrayList<Set<Persona>> grupos = clasificador.agruparPersonas();
		return grupos;
	}

	public static void graficarGrupos(Graphics g) {
		Grafo nuevo = clasificador.dividirGrafo();
		Set<Persona> grupo1 = obtenerGrupos().get(0);
		int centroX;
		Font fuenteNombre = new Font("Sitka Banner", java.awt.Font.PLAIN, 30);
		ArrayList<Punto> puntos = new ArrayList<Punto>();
		Punto p;
		for (int i = 0; i < nuevo.tamanio(); i++) {
			if (grupo1.contains(nuevo.getNodo(i))) {
				centroX = 250;

			} else {
				centroX = 1000;
			}
			int numero1 = (int) ((Math.random() - 0.5) * 500) + centroX;
			int numero2 = (int) ((Math.random() - 0.5) * 500) + 350;
			p = new Punto(numero1, numero2);
			while (!puedeAgregar(puntos, p)) {
				numero1 = (int) ((Math.random() - 0.5) * 500) + centroX;
				numero2 = (int) ((Math.random() - 0.5) * 500) + 350;
				p = new Punto(numero1, numero2);

			}
			puntos.add(p);
			Grafico.agregarCirculo(numero1, numero2, g);
			g.setFont(fuenteNombre);
			g.setColor(Color.darkGray);
			g.drawString(nuevo.getNodo(i).getNombre(), numero1 - 10, numero2 - 10);
			g.drawString(clasificador.toString(), 100, 650);
			g.drawString("Estadisticas grupo 1:" + estadisticasGrupo1(), 200, 500);
			g.drawString("Estadisticas grupo 2:" + estadisticasGrupo2(), 200, 550);
			
			
		}

		for (int i = 0; i < nuevo.tamanio() - 1; i++) {
			for (int j = i + 1; j < nuevo.tamanio(); j++) {
				if (nuevo.existeArista(i, j)) {
					graficarArista(puntos.get(i), puntos.get(j), g);

				}
			}
		}
	}

	public static ArrayList<String> getDatosPersonas() {
		ArrayList<String> personasCargadas = PersonasJSON.leerJSON("usuarios.JSON").getPersonasString();
		ArrayList<String> personas = PersonasJSON.leerJSON("PersonasPretty.JSON").getPersonasString();
		for (String p : personasCargadas) {
			personas.add(p);
		}

		return personas;
	}

	public static DefaultListModel<String> recorrerDatosPersonas(ArrayList<String> datos) {
		DefaultListModel<String> listModel = new DefaultListModel<>();
		for (int i = 0; i < datos.size(); i++) {
			listModel.addElement(datos.get(i));
		}
		return listModel;

	}

	public static JList crearLista() {
		Font fuenteLista = new Font("Showcard Gothic", java.awt.Font.PLAIN, 20);
		JList list = new JList<>(recorrerDatosPersonas(getDatosPersonas()));
		list.setBounds(0, 0, 328, 521);

		list.setFont(fuenteLista);

		return list;
	}

	public static void agregarLista(JPanel panel) {
		JList list = crearLista();
		panel.removeAll();
		panel.add(list);

	}

	public static boolean choca(Punto p, Punto p2) {
		return p.intersecan(p2);
	}

	public static boolean puedeAgregar(ArrayList<Punto> puntos, Punto punto) {
		if (puntos.size() == 0) {
			return true;
		}

		for (Punto p : puntos) {
			if (choca(punto, p)) {
				return false;
			}
		}
		return true;
	}

	public static void graficarArista(Punto p1, Punto p2, Graphics g) {

		Grafico.agregarLinea(p1.getX() + 20, p1.getY() + 20, p2.getX() + 20, p2.getY() + 20, g);
	}
	
	public static double estadisticasGrupo1() {
		ArrayList <Set<Persona>> grupo = obtenerGrupos();
		Set<Persona> grupo1 = grupo.get(0);
		Set<Persona> grupo2 = grupo.get(1);
 		return promedioDeSimilaridad(grupo1);
 	
 		
	}
	
	public static double estadisticasGrupo2() {
		ArrayList <Set<Persona>> grupo = obtenerGrupos();
		Set<Persona> grupo1 = grupo.get(0);
		Set<Persona> grupo2 = grupo.get(1);
 		return promedioDeSimilaridad(grupo2);
 		
	}
	
	public static double promedioDeSimilaridad (Set <Persona> grup) {
		double prom = 0; 
		for (Persona p : grup) {
			for (Persona otro : grup) {
				prom = prom + p.indiceDeSimilaridad(otro);
			}
		}
		return (prom / grup.size())/2;
	}
		
		
	}

