package daoImpl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import players.beans.Player;
import players.beans.Users;

import dao.BaseDao;

/**
 * 
 * @author Administrator
 * BaseDao  ������ʵ��
 */
public class PlayerDao extends HibernateDaoSupport implements BaseDao {
	
	

	public void saveObject(Object obj) {
		// TODO Auto-generated method stub
		getHibernateTemplate().save(obj);
	}

	@SuppressWarnings("unchecked")
	public List<Users> findByName(){
		List<Users> list = getHibernateTemplate().executeFind(new HibernateCallback() {
			
			public Object doInHibernate(Session session) throws HibernateException,
					SQLException {
				// TODO Auto-generated method stub
				System.out.println("zhixngchaxun");
				String hql = "from Users ";
				System.out.println(session.createQuery(hql));
				List<Users> list = session.createQuery(hql).list();
				System.out.println(list);
				for(Users p:list){
					System.out.println(p);
				}
				return null;
			}
		});
		return list;
	}

}
