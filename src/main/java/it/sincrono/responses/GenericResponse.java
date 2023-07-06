package it.sincrono.responses;

import it.sincrono.beans.Esito;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GenericResponse {

	private Esito esito = new Esito();

	//private Object oggetto;
}