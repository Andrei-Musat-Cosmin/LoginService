package it.sincrono.requests;

import it.sincrono.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class RegisterRequest extends GenericRequest {

	private String username;

	private String password;

	private Role ruolo;

}
