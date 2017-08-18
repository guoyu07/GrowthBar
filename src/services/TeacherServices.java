/**
 * <p>Project: 网络管理委员会招新网站, NetUnion Recruit WebSite </p> <p>File: TeacherServices.java</p>
 * <p>Description: </p> <p>Copyright: Copyright (c) 2017</p>
 *
 * @author 张健顺
 * @email: 1224522500@qq.com
 * @date 2017年3月21日
 */
package services;

import java.util.List;

import common.model.Teacher;

/**
 *
 */
public class TeacherServices implements BaseService<Teacher> {

	@Override
	public Teacher select(int id) {
		return Teacher.dao.findById(id);
	}

	@Override
	public List<Teacher> selectList() {
		return Teacher.dao.find("SELECT * FROM teacher");
	}

	@Override
	public Boolean save(Teacher entity) {
		if (null == entity.getTeacherId()) {
			return entity.save();
		} else {
			return entity.update();
		}
	}

	@Override
	public Boolean remove(int id) {
		return Teacher.dao.deleteById(id);
	}

}
