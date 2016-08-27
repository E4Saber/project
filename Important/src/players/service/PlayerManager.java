package players.service;


import java.util.List;

import org.hibernate.HibernateException;

import players.beans.Users;
import forms.PlayerForm;

/**
 * ҵ���߼��Ľӿ�
 * @author Administrator
 *
 */

public interface PlayerManager {

	public void regPlayer(PlayerForm playerForm) throws HibernateException, IllegalAccessException, Exception;
	public List<Users> findByName();
}
