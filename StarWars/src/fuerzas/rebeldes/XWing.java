package fuerzas.rebeldes;

/**
 * XWing
 */
public class XWing {

	private String fabricante = "Incom Corporation";
	private int costo_nuevo = 149999;
	private char armamento_canon = '1';
	private char armamento_misil = '1';
	private int max_aceleracion = 3700;
	private int autonomia = 100;

	private boolean rol_Space_starfighter;
	private boolean rol_Escort;

	private String id;

	/**
	 * @return the fabricante
	 */
	public String getFabricante() {
		return fabricante;
	}

	/**
	 * @param fabricante the fabricante to set
	 */
	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}

	/**
	 * @return the costo_nuevo
	 */
	public int getCosto_nuevo() {
		return costo_nuevo;
	}

	/**
	 * @param costo_nuevo the costo_nuevo to set
	 */
	public void setCosto_nuevo(int costo_nuevo) {
		this.costo_nuevo = costo_nuevo;
	}

	/**
	 * @return the armamento_canon
	 */
	public char getArmamento_canon() {
		return armamento_canon;
	}

	/**
	 * @param armamento_canon the armamento_canon to set
	 */
	public void setArmamento_canon(char armamento_canon) {
		this.armamento_canon = armamento_canon;
	}

	/**
	 * @return the armamento_misil
	 */
	public char getArmamento_misil() {
		return armamento_misil;
	}

	/**
	 * @param armamento_misil the armamento_misil to set
	 */
	public void setArmamento_misil(char armamento_misil) {
		this.armamento_misil = armamento_misil;
	}

	/**
	 * @return the max_aceleracion
	 */
	public int getMax_aceleracion() {
		return max_aceleracion;
	}

	/**
	 * @param max_aceleracion the max_aceleracion to set
	 */
	public void setMax_aceleracion(int max_aceleracion) {
		this.max_aceleracion = max_aceleracion;
	}

	/**
	 * @return the autonomia
	 */
	public int getAutonomia() {
		return autonomia;
	}

	/**
	 * @param autonomia the autonomia to set
	 */
	public void setAutonomia(int autonomia) {
		this.autonomia = autonomia;
	}

	/**
	 * @return the rol_Space_starfighter
	 */
	public boolean isRol_Space_starfighter() {
		return rol_Space_starfighter;
	}

	/**
	 * @param rol_Space_starfighter the rol_Space_starfighter to set
	 */
	public void setRol_Space_starfighter(boolean rol_Space_starfighter) {
		this.rol_Space_starfighter = rol_Space_starfighter;
	}

	/**
	 * @return the rol_Escort
	 */
	public boolean isRol_Escort() {
		return rol_Escort;
	}

	/**
	 * @param rol_Escort the rol_Escort to set
	 */
	public void setRol_Escort(boolean rol_Escort) {
		this.rol_Escort = rol_Escort;
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	private int misiles = 6;
	private int disparos = 0;
	private int velocidad = 0;
	private boolean en_vuelo = false;

	public void acelearar(int aceleracion) {
		if (aceleracion>max_aceleracion) {
			aceleracion = max_aceleracion;
		}
		velocidad += aceleracion;
		if ((velocidad==0) & (!en_vuelo)) {
			System.out.println("*** INFO para el piloto: No puede despegar !!! "+velocidad);
		}
		if (velocidad<=0 & en_vuelo) {
			System.out.println(this.id + " *** LO SIENTO PERO TE ACABAS DE ESTRELLAR *** Le debes "+
			costo_nuevo+" Créditos a las fuerzas rebeldes");
		}
		if (velocidad>=10 & velocidad<=99) {
			System.out.println("*** INFO para el piloto: despegando !!! " +velocidad);
			en_vuelo=true;
		}
		if (velocidad>0 & velocidad<10) {
			System.out.println("*** INFO para el piloto: aterrizando !!! "+velocidad);
			en_vuelo=false;
		}
	}
	public void disparar_canon(boolean rafaga) {
		if (rafaga) {
			for (int i = 0; i < 20; i++) {
				System.out.println("RAFAGA laser shot!!!");
				disparos++;
			}
		} else {
			System.out.println("laser shot !!!");
			disparos++;
		}
		System.out.println(" *** INFO para el piloto: van "+ disparos + " disparos");
	}

	public boolean disparar_misil() {
		if (misiles>0) {
			System.out.println("...: L A N Z A N D O   M I S I L   # : "+misiles);
			misiles--;
			return true;
		} else {
			System.out.println("*** WARNING: NO HAY MISILES ***");
			return false;
		}
	}
}