package services;

import common.model.ExamResult;

import java.util.List;

public class ExamresultServices implements BaseService<ExamResult> {

	@Override
	public ExamResult select(int id) {
		return ExamResult.dao.findById(id);
	}

	@Override
	public List<ExamResult> selectList() {
		return ExamResult.dao.find("select * from exam_result order by date DESC");
	}

	public List<ExamResult> selectOwn(String userAccount) {
		return ExamResult.dao
				.find("select * from exam_result WHERE user_account = ? order by date DESC",
						userAccount);
	}

	@Override
	public Boolean save(ExamResult entity) {
		if (null == entity.getExamId()) {
			return entity.save();
		}
		return entity.update();
	}

	@Override
	public Boolean remove(int id) {
		ExamResult examResult = select(id);
		return examResult.dao.deleteById(id);
	}

}
