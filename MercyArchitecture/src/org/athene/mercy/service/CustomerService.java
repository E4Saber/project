package org.athene.mercy.service;

import java.util.List;
import java.util.Map;

import org.athene.mercy.annotation.Service;
import org.athene.mercy.annotation.Transaction;
import org.athene.mercy.bean.FileParam;
import org.athene.mercy.helper.UploadHelper;
import org.athene.mercy.model.Customer;
import org.athene.mercy.util.QueryUtil;

/**
 * 
 * @author 850030121
 * �ṩ�ͻ����ݷ���
 */

@Service
public class CustomerService {

	/**
	 * ��ȡ�ͻ��б�
	 * @return
	 */
	public List<Customer> getCustomerList() {
		String sql = "SELECT * FROM customer";
		return QueryUtil.queryEntityList(Customer.class, sql);
	}
	
	/**
	 * ��ȡ�ͻ�
	 * @param id
	 * @return
	 */
	public Customer getCustomer(long id) {
		String sql = "SELECT * FROM customer";
		return QueryUtil.queryEntity(Customer.class, sql, id);
	}
	
	/**
	 * �����ͻ�
	 * @param fieldMap
	 * @return
	 */
	@Transaction
	public boolean createCustomer(Map<String, Object> fieldMap, FileParam fileParam) {
		boolean result = QueryUtil.insertEntity(Customer.class, fieldMap);
		if(result) {
			UploadHelper.uploadFile("/upload/", fileParam);
		}
		return result;
	}
	
	/**
	 * ���¿ͻ�
	 * @param id
	 * @param fieldMap
	 * @return
	 */
	public boolean updateCustomer(long id, Map<String, Object> fieldMap) {
		return QueryUtil.updateEntity(Customer.class, id, fieldMap);
	}
	
	/**
	 * ɾ���ͻ�
	 * @param id
	 * @return
	 */
	public boolean deleteCustomer(long id) {
		return QueryUtil.deleteEntity(Customer.class, id);
	}
}
