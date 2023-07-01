package mybatis;

import org.apache.ibatis.session.SqlSession;

public class DAO {
	private static SqlSession ss;
	
	private synchronized static SqlSession getSession() {
		if (ss == null) {
			ss = DBService.getFactory().openSession();
		}
		ss.commit();
		return ss;
	}
	
//	public static List<VO> getList() {
//		List<VO> list = null;
//		
//		list = getSession().selectList("user");
//		return list;
//	}
//	
//	 select, 결과 한 개, 파라미터 있음(String)
		public static VO getOne(String custid) {
			VO vo = getSession().selectOne("userOne", custid);
			return vo;
		}

		// insert, delete, update 결과 int, 파라미터 무조건 있음
		// 반드시 commit을 해야함
		public static int getInsert(VO vo) {
			int result = getSession().insert("userIns", vo);
			ss.commit();
			return result;
		}

		public static int getDelete(String vo) {
			int result = getSession().delete("userDel", vo);
			ss.commit();
			return result;
		}

//		public static int getUpdate(VO vo) {
//			int result = getSession().update("custUp", vo);
//			ss.commit();
//			return result;
//		}
}
