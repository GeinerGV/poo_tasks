package edu.usil.test;

import java.util.Scanner;

import edu.usil.bean.Alumno;

public class Test01 {

	Alumno[] alumnos;
	
	public static void main(String[] args) {
		Test01 t01 = new Test01();
		t01.ejemplo1();
		t01.listar();
	}
	
	public void ejemplo1() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Cuantos alumnos vas a ingresar ?");
		int n = sc.nextInt();
		sc.nextLine();
		
		alumnos = new Alumno[n];
		
		for (int i=0; i<n; i++) {
			System.out.println("Ingrese el código");
			String codigo = sc.nextLine();
			System.out.println("Ingrese el nombre");
			String nombre = sc.nextLine();
			System.out.println("Ingrese el apellido");
			String apellido = sc.nextLine();
			System.out.println("Ingrese el ciclo");
			int ciclo = sc.nextInt();
			
			sc.close();

			Alumno a = new Alumno(codigo, nombre, apellido, ciclo);
			alumnos[i] = a;
		}
	}
	
	public void listar() {
		for (int i=0; i<alumnos.length; i++) {
			System.out.println(alumnos[i]);
		}
	}
}
