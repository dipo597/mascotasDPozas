package mascota;

import java.time.LocalDate;

public class Mamifero extends Mascota{

	//propiedades
	private String chip;
	
	/**
	 * Constructor de la clase Mamifero. Llama al constructor de la clase padre y valida el valor del chip antes de crear el objeto.
	 * @param nombre (String)
	 * @param especie (String)
	 * @param fechaNacimiento (LocalDate)
	 * @param chip (String)
	 */
	public Mamifero(String nombre, String especie, LocalDate fechaNacimiento, String chip){
		super(nombre, especie, fechaNacimiento);
		if (!chip.matches("^\\d{15}$")) throw new IllegalArgumentException();
		this.chip=chip;
	}
	
	//métodos
	@Override
	public String toString(){
		String str=super.toString();
		
		str+="\n\tMamífero ("+this.getChip()+").\n";
		
		return str;
	}
	
	@Override
	public LocalDate calcularProximaRevision(){
		LocalDate prox;
		
		if (this.calcularEdad()<18){
			prox=super.fechaUltimaRevision().plusMonths(3);
		}
		else{
			prox=super.fechaUltimaRevision().plusMonths(6);
		}
		
		return prox;
	}
	
	//getters & setters
	public String getChip() {
		return chip;
	}

	public void setChip(String chip) {
		this.chip = chip;
	}
	
}
