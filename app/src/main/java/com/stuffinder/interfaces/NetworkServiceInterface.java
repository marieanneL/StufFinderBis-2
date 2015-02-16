package com.stuffinder.interfaces;

import java.util.List;

import com.stuffinder.data.Account;
import com.stuffinder.data.Profile;
import com.stuffinder.data.Tag;
import com.stuffinder.exceptions.AccountNotFoundException;
import com.stuffinder.exceptions.IllegalFieldException;
import com.stuffinder.exceptions.NetworkServiceException;
import com.stuffinder.exceptions.NotAuthenticatedException;
import com.stuffinder.exceptions.TagAlreadyUsedException;
import com.stuffinder.exceptions.TagNotFoundException;

/**
 * This interface makes the link between the network service (in this case, this is the client web service) and the engine of the application.
 * It defines all the needed methods to use this service.
 * @author Nicolas Thierce
 *
 */
public interface NetworkServiceInterface
{
	
	/**
	 * Initialize this service to rend it available for network communications.
	 * @throws NetworkServiceException
	 */
	public void initNetworkService() throws NetworkServiceException;
	
	
	/**
	 * @param newAccount
	 * @throws IllegalFieldException
	 * @throws NetworkServiceException if there is a network failure.
	 */
	public void createAccount(Account newAccount, String newPassword) throws IllegalFieldException, NetworkServiceException;

	/**
	 * 
	 * @param pseudo
	 * @param password
	 * @return
	 * @throws IllegalFieldException
	 * @throws NetworkServiceException
	 */
	public Account authenticate(String pseudo, String password) throws AccountNotFoundException, NetworkServiceException;
	
	public void logOut();
	
	/**
	 * to get the current accohnt of the session.
	 * @return the current account if the authentication is done, null otherwise.
	 */
	public Account getCurrentAccount() throws NotAuthenticatedException;

	
	/**
	 * Modify the e-mail of the current account.
	 * @param mailAddress the new e-mail.
	 * @return the account modified (maybe the same object).
	 */
	public void modifyEMailAddress(String emailAddress) throws NotAuthenticatedException, IllegalFieldException, NetworkServiceException;
	
	/**
	 * modify the password of the current account.
	 * @param newPassword
	 */
	public void modifyPassword(String newPassword) throws NotAuthenticatedException, IllegalFieldException, NetworkServiceException;
	
	/**
	 * Add a tag to the current account. 
	 * @param tag
	 */
	public void addTag(Tag tag) throws NotAuthenticatedException, IllegalFieldException, TagAlreadyUsedException, NetworkServiceException;
	

	public void modifyObjectName(Tag tag, String newObjectName) throws NotAuthenticatedException, IllegalFieldException, TagNotFoundException, NetworkServiceException;

	public void modifyObjectImage(Tag tag, String newImageFileName) throws NotAuthenticatedException, IllegalFieldException, TagNotFoundException, NetworkServiceException;
	
	/**
	 * 
	 * @param tag
	 */
	public void removeTag(Tag tag) throws NotAuthenticatedException, IllegalFieldException, TagNotFoundException, NetworkServiceException;
	
	
	/**
	 * 
	 * @param profileName
	 * @return
	 */
	public Profile createProfile(String profileName) throws NotAuthenticatedException;
	
	
	/**
	 * @param profile
	 * @param tag
	 * @return
	 */
	public Profile addTagToProfile(Profile profile, Tag tag) throws NotAuthenticatedException;
	
	/**
	 * @param profile
	 * @param tag
	 * @return
	 */
	public Profile removeTagFromProfile(Profile profile, Tag tag) throws NotAuthenticatedException;
	
	/**
	 * @param profile
	 * @return
	 */
	public Profile removeAllFromProfile(Profile profile) throws NotAuthenticatedException;
	
	/**
	 * @param profile
	 * @param tagList
	 * @return
	 */
	public Profile replaceTagListOfProfile(Profile profile, List<Tag> tagList) throws NotAuthenticatedException;
	
	/**
	 * @param profil
	 * @param tagList
	 * @return
	 */
	public Profile replaceTagListOfProfile(Profile profile, Tag[] tagList) throws NotAuthenticatedException;
	
	/**
	 * @param profilName
	 * @return
	 */
	public Profile getProfile(String profileName) throws NotAuthenticatedException;
}