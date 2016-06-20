package dao.hibernate;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import po.Shipping;
import po.ShippingCompany;
import utils.HibernateUtil;
import utils.StringUtil;

public class ShippingCompanyDao extends HibernateDao {

	public List<ShippingCompany> search(ShippingCompany shippingCompany) {
		
		if (shippingCompany == null) {
			return findAll(ShippingCompany.class);
		}
		try{
			startOperation();
			Criteria cr = session.createCriteria(ShippingCompany.class, "shippingCompany");
			
			if (shippingCompany.getId() != 0) {
				cr.add(Restrictions.eq("id", shippingCompany.getId()));
			}
			
			if (!StringUtil.isEmpty(String.valueOf(shippingCompany.getName()))) {
				cr.add(Restrictions.like("shippingCompany.name", "%" + shippingCompany.getName() + "%"));
			}
			
			return cr.list();
		}catch(Exception e) {
			handleException(e);
			return null;
		}finally{
			HibernateUtil.close(session);
		}
		
	}

}
