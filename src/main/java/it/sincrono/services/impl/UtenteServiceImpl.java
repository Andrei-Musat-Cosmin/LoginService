package it.sincrono.services.impl;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import it.sincrono.entity.Anagrafica;
import it.sincrono.entity.Ruolo;
import it.sincrono.entity.Utente;
import it.sincrono.repositories.AnagraficaRepository;
import it.sincrono.repositories.OperazioniRepository;
import it.sincrono.repositories.RuoloRepository;
import it.sincrono.repositories.UtenteRepository;
import it.sincrono.services.UtenteService;
import it.sincrono.services.costants.ServiceMessages;
import it.sincrono.services.exceptions.ServiceException;

@Service
public class UtenteServiceImpl implements UtenteService {
	private static final Logger LOGGER = LogManager.getLogger(UtenteServiceImpl.class);

	@Autowired
	private UtenteRepository utenteReposiroty;

	@Autowired
	private AnagraficaRepository anagraficaRepository;

	@Autowired
	private RuoloRepository ruoloRepository;

	@Autowired
	private OperazioniRepository operazioniRepository;

	public Boolean isUtenteAuthorized(String percorso, String auth, JSONObject body, String token)
			throws ServiceException {
		Boolean risultato = true;
		ObjectMapper objectMapper = new ObjectMapper();

		try {
			LOGGER.info("Richiesta del servizio: '" + percorso + "'" + " da parte di utente con token: " + auth + ".");
			JsonNode jsonNode = null;
			if (body != null) {
				jsonNode = objectMapper.readTree(body.toString());
			}
			
			LOGGER.info("Utente jsonNode: "+jsonNode);

			Utente utente = operazioniRepository.findOperazioneById(percorso,
					utenteReposiroty.findByTokenPassword(auth).get().getId());

			Anagrafica anagrafica = anagraficaRepository.findByIdUtente(utente.getId());

			LOGGER.info("Utente: " + utente.getUsername() + ", e' autorizzato.");
			Ruolo ruolo = ruoloRepository.findRuoloByUtenteId(utente.getId());
			switch (ruolo.getId()) {
			case 1:
				LOGGER.info(utente.getUsername() + " con ruolo " + ruolo.getNome());
				switch (percorso) {
				case "delete":
					LOGGER.log(Level.INFO, "Gestione per l'operazione " + percorso);
					if (risultato) {
						if (utente.getId() == jsonNode.get("anagraficaDto").get("anagrafica").get("utente").get("id")
								.asInt())
							throw new ServiceException(ServiceMessages.NON_AUTORIZZATO);
					}
					break;
				case "update-rapportino":
					LOGGER.log(Level.INFO, "Gestione per l'operazione " + percorso);
					if (risultato) {
						if (!anagrafica.getCodiceFiscale()
								.equals(jsonNode.get("rapportinoDto").get("anagrafica").get("codiceFiscale").asText()))
							throw new ServiceException(ServiceMessages.NON_AUTORIZZATO);
					}
					break;
				case "add-document-image":
					LOGGER.log(Level.INFO, "Gestione per l'operazione " + percorso);
					if (risultato) {
						if (!anagrafica.getCodiceFiscale().equals(jsonNode.get("codiceFiscale").asText()))
							throw new ServiceException(ServiceMessages.NON_AUTORIZZATO);
					}
					break;
				case "modifica-utente":
					LOGGER.log(Level.INFO, "Gestione per l'operazione " + percorso);
					if (risultato) {
						if (utente.getId() != jsonNode.get("id").asInt())
							throw new ServiceException(ServiceMessages.NON_AUTORIZZATO);
					}
					break;
				default:
					LOGGER.log(Level.INFO, "Nessuna limitazione");
				}
				break;
			case 2:
				LOGGER.info(utente.getUsername() + " con ruolo " + ruolo.getNome());
				switch (percorso) {
				default:

				}
				break;
			case 3:
				LOGGER.info(utente.getUsername() + " con ruolo " + ruolo.getNome());
				switch (percorso) {
				case "invia-rapportino":
					LOGGER.log(Level.INFO, "Gestione per l'operazione " + percorso);
					if (risultato) {
						if (!anagrafica.getCodiceFiscale()
								.equals(jsonNode.get("rapportino").get("codiceFiscale").asText()))
							throw new ServiceException(ServiceMessages.NON_AUTORIZZATO);
					}
					break;
				case "dettaglio-token":
					LOGGER.log(Level.INFO, "Gestione per l'operazione " + percorso);
					if (risultato) {
						if (!utente.getTokenPassword().equals(token))
							throw new ServiceException(ServiceMessages.NON_AUTORIZZATO);
					}
					break;

				case "update-rapportino":
					LOGGER.log(Level.INFO, "Gestione per l'operazione " + percorso);
					if (risultato) {
						if (!anagrafica.getCodiceFiscale()
								.equals(jsonNode.get("rapportinoDto").get("anagrafica").get("codiceFiscale").asText()))
							throw new ServiceException(ServiceMessages.NON_AUTORIZZATO);
					}
					break;
				case "get-rapportino":
					LOGGER.log(Level.INFO, "Gestione per l'operazione " + percorso);
					if (risultato) {
						if (!anagrafica.getCodiceFiscale()
								.equals(jsonNode.get("rapportinoDto").get("anagrafica").get("codiceFiscale").asText()))
							throw new ServiceException(ServiceMessages.NON_AUTORIZZATO);
					}
					break;

				case "add-document-image":
					LOGGER.log(Level.INFO, "Gestione per l'operazione " + percorso);
					if (risultato) {
						if (!anagrafica.getCodiceFiscale().equals(jsonNode.get("codiceFiscale").asText()))
							throw new ServiceException(ServiceMessages.NON_AUTORIZZATO);
					}
					break;

				case "modifica-utente":
					LOGGER.log(Level.INFO, "Gestione per l'operazione " + percorso);
					if (risultato) {
						if (utente.getId() != jsonNode.get("id").asInt())
							throw new ServiceException(ServiceMessages.NON_AUTORIZZATO);
					}
					break;
				default:
					LOGGER.log(Level.INFO, "Nessuna limitazione");
				}
				break;
			default:
				throw new ServiceException(ServiceMessages.NON_AUTORIZZATO);
			}

		} catch (ServiceException e) {
			//LOGGER.log(Level.ERROR, "errore no value present log 125: "+e.getMessage());
			LOGGER.log(Level.ERROR, e.getMessage());
			throw new ServiceException(ServiceMessages.NON_AUTORIZZATO);
		} catch (Exception e) {
			//LOGGER.log(Level.ERROR, "errore no value present log 125: "+e.getMessage());
			LOGGER.log(Level.ERROR, e.getMessage());
			throw new ServiceException(ServiceMessages.ERRORE_GENERICO);
		}
		return risultato;
	}

}
