package services;

import common.model.UserInformation;

import java.util.List;

public class UserInformationServices implements BaseService<UserInformation> {

	@Override
	public UserInformation select(int id) {
		return UserInformation.dao.findById(id);
	}

	@Override
	public List<UserInformation> selectList() {
		return UserInformation.dao.find("SELECT * FROM UserInformation");
	}

	@Override
	public Boolean save(UserInformation entity) {
		if (null == entity.getUserId()) {
			return entity.save();
		} else {
			return entity.update();
		}
	}

	@Override
	public Boolean remove(int id) {
		return UserInformation.dao.deleteById(id);
	}

	public List<UserInformation> find(String userAccount, String userPassword) {
		return UserInformation.dao
				.find("select * from user_information where user_account=? and user_password=?",
						userAccount, userPassword);
	}
}
