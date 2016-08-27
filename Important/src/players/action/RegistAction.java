package players.action;

import java.util.List;

import org.hibernate.HibernateException;

import players.beans.Player;
import players.beans.Users;
import players.service.PlayerManager;
import com.opensymphony.xwork2.ActionSupport;
import forms.PlayerForm;

/**
 * 
 * @author Administrator
 *  registaciton   ����ע���action
 */
public class RegistAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1234892094191753709L;

	//bean   �Լ� �߼�����ӿ�
	private PlayerForm playerForm;
	private PlayerManager playerManager;
	
	/**
	 * 
	 * @return
	 * getPlayer()   不是getPlayerForm()?????????
	 */
	public PlayerForm getPlayer() {
		return playerForm;
	}
	public void setPlayer(PlayerForm playerForm) {
		this.playerForm = playerForm;
	}
	
	//**********************
	
	
	public PlayerManager getPlayerManager() {
		return playerManager;
	}
	public void setPlayerManager(PlayerManager playerManager) {
		this.playerManager = playerManager;
	}
	
	public String execute(){
		try {
			System.out.println("registAction:"+playerForm);
			playerManager.regPlayer(playerForm);
			return SUCCESS;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ERROR;
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ERROR;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ERROR;
		}
		
	}
	public String find(){
		List<Users> list = playerManager.findByName();
		for(Users p : list){
			System.out.println(p);
		}
		return null;
	}
	
}
