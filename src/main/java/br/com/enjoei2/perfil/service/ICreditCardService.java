package br.com.enjoei2.perfil.service;

import br.com.enjoei2.perfil.model.CreditCard;

public interface ICreditCardService {

	
	void registerCreditCard(CreditCard creditCard);
	
	void removeCreditCard(String creditCardId);
	
	void updateCreditCard(CreditCard creditCard);
	
}
