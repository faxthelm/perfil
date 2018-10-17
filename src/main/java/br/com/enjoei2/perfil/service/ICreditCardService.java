package br.com.enjoei2.perfil.service;

import br.com.enjoei2.perfil.model.CreditCard;

public interface ICreditCardService {

	
	public void registerCreditCard(CreditCard creditCard);
	
	public void removeCreditCard(String creditCardId);
	
	public void updateCreditCard(CreditCard creditCard);
	
}
