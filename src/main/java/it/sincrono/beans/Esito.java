package it.sincrono.beans;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Esito {

	private Integer code = 0;
	private String target = null;
	private String[] args = null;

}