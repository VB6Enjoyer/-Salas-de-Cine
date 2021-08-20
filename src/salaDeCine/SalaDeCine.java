package salaDeCine;

public class SalaDeCine {

	private boolean butacas[][];
	
	//Constructor
	public SalaDeCine(int filas, int asientos) {
		if(filas < 1 || asientos < 1)
			throw new IllegalArgumentException("Debe ingresar un número de filas y asientos mayor a 0.");
		
		this.butacas = new boolean[filas][asientos];
	}
	
	//Ocupar un asiento que no esté ocupado.
	public void ocupar(int fila, int asiento) {
		if(fila < 0 || asiento < 0)
			throw new IllegalArgumentException("Debe ingresar un número de filas y asientos igual o mayor a 0.");
		
		if(this.isOcupado(fila, asiento))
			throw new Error("Este asiento ya está ocupado.");
		
		this.butacas[fila][asiento] = true;
	}
	
	//Desocupar un asiento que esté ocupado.
	public void desocupar(int fila, int asiento) {
		if(fila < 0 || asiento < 0)
			throw new IllegalArgumentException("Debe ingresar un número de filas y asientos igual o mayor a 0.");
		
		if(!this.isOcupado(fila, asiento))
			throw new Error("Este asiento ya está desocupado.");
		
		this.butacas[fila][asiento] = false;
	}
	
	//Revisa si un asiento está ocupado.
	public boolean isOcupado(int fila, int asiento){
		if(fila < 0 || asiento < 0)
			throw new IllegalArgumentException("Debe ingresar un número de filas y asientos igual o mayor a 0.");
		
		return this.butacas[fila][asiento];
	}
	
	//Recorre el array entero y cuenta todos los asientos ocupados.
	public int cuantasOcupadas() {
		int ocupadas = 0;
		
		for(int i = 0; i < butacas.length; i++) {
			for(int j = 0 ; j < butacas[i].length; j++) { //Acá recorro la segunda matriz del array.
				if(this.isOcupado(i, j)) ocupadas++;
			}
		}
		
		return ocupadas;
	}
	
	//Revisa si la cantidad de personas ingresadas es mayor a la cantidad de asientos o no.
	public boolean hayEspacioPara(int cantidadDePersonas) {
		if(cantidadDePersonas < 1)
			throw new IllegalArgumentException("Debe ingresar un número de personas mayor a 0.");
		
		return cantidadDePersonas <= this.butacas[0].length;
	}
	
}
