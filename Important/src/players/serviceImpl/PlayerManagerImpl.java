package players.serviceImpl;


import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import dao.BaseDao;
import forms.PlayerForm;
import players.beans.Player;
import players.beans.Users;
import players.service.PlayerManager;

/**
 * 
 * @author Administrator
 * ҵ���߼��Ľӿ�ʵ����
 */
public class PlayerManagerImpl implements PlayerManager {
	
	private BaseDao baseDao;
	
	
	/**
	 * 注册  用户
	 */
	public void regPlayer(PlayerForm playerForm) throws  IllegalAccessException, Exception {
		// TODO Auto-generated method stub
		
		Player player = new Player();
		BeanUtils.copyProperties(player, playerForm);
		System.out.println(player);
		baseDao.saveObject(player);
	}


	public void setBaseDao(BaseDao baseDao) {
		this.baseDao = baseDao;
	}


	public List<Users> findByName() {
		// TODO Auto-generated method stub
		System.out.println("managerImpl");
		return baseDao.findByName();
	
		
	}

}
