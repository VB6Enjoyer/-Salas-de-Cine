package salaDeCine;

public class App {

	public static void main(String[] args) {
		SalaDeCine sala = new SalaDeCine(5, 10);
		System.out.println(sala.hayEspacioPara(11));
		System.out.println(sala.hayEspacioPara(10));
		System.out.println(sala.hayEspacioPara(9));
	}

}
