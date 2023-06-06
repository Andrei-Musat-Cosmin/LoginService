package it.sincrono.services.impl;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import it.sincrono.repositories.AnagraficaRepository;
import it.sincrono.repositories.UtenteRepository;
import it.sincrono.repositories.entities.Anagrafica;
import it.sincrono.repositories.entities.Utente;
import it.sincrono.service.LoginService;
import it.sincrono.services.constants.ServiceMessages;
import it.sincrono.services.exceptions.ServiceException;
import it.sincrono.services.holders.EmailHolder;
import it.sincrono.services.utils.TokenGenerator;

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	private EmailHolder emailHolder;

	@Autowired
	private AnagraficaRepository anagraficaRepository;

	@Autowired
	private UtenteRepository utenteRepository;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	

	@Override
	public void ripristinaPassword(Anagrafica anagrafica) throws ServiceException {

		try {
			
			System.err.println(anagraficaRepository.findByEmail(anagrafica.getMailAziendale()));
			
			Anagrafica currentAnagrafica = anagraficaRepository.findByEmail(anagrafica.getMailAziendale());
			
			System.err.println(currentAnagrafica);

			if(currentAnagrafica != null) {

				String token = TokenGenerator.nextToken();

				Utente utente = utenteRepository.findById(currentAnagrafica.getUtente().getId()).get();
				
				System.err.println(utente);

				utente.setTokenPassword(token);
				
				utenteRepository.saveAndFlush(utente);

				emailHolder.sendMail(currentAnagrafica, token);

			} else {
				throw new NoSuchElementException();
			}

		} catch (NoSuchElementException ne) {
			throw new ServiceException(ServiceMessages.RECORD_NON_TROVATO);
		} catch (DataIntegrityViolationException de) {
			throw new ServiceException(ServiceMessages.ERRORE_INTEGRITA_DATI);
		} catch (Exception e) {
			throw new ServiceException(ServiceMessages.ERRORE_GENERICO);
		}
	}

	@Override
	public void ripristinaPassword(String token, Anagrafica anagrafica) throws ServiceException {

		try {
			Utente utenteCorrente = utenteRepository.findByToken(token);
			
			utenteCorrente.setPassword(passwordEncoder.encode(anagrafica.getUtente().getPassword()));
			
			utenteCorrente.setTokenPassword(null);
			
			System.err.println("La password è: " + anagrafica.getUtente());
			
			if(utenteCorrente != null) {
				utenteRepository.saveAndFlush(utenteCorrente);	
			} else {
				throw new NoSuchElementException();
			}

		} catch (NoSuchElementException ne) {
			throw new ServiceException(ServiceMessages.RECORD_NON_TROVATO);
		} catch (DataIntegrityViolationException de) {
			throw new ServiceException(ServiceMessages.ERRORE_INTEGRITA_DATI);
		} catch (Exception e) {
			throw new ServiceException(ServiceMessages.ERRORE_GENERICO);
		}
	}

	@Override
	public void primoAccesso(String token, Anagrafica anagrafica) throws ServiceException {

		try {
			Utente utenteCorrente = utenteRepository.findByToken(token);

			if(utenteCorrente != null) {
				utenteRepository.saveAndFlush(anagrafica.getUtente());
			} else {
				throw new NoSuchElementException();
			}

		} catch (NoSuchElementException ne) {
			throw new ServiceException(ServiceMessages.RECORD_NON_TROVATO);
		} catch (DataIntegrityViolationException de) {
			throw new ServiceException(ServiceMessages.ERRORE_INTEGRITA_DATI);
		} catch (Exception e) {
			throw new ServiceException(ServiceMessages.ERRORE_GENERICO);
		}
	}
}