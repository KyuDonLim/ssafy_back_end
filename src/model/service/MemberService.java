package model.service;

import dto.MemberDto;
import model.dao.MemberDao;

public class MemberService {
	private static MemberDao dao = MemberDao.getInstance();
	private static MemberService instance = new MemberService();
	
	private MemberService() {}
	public static MemberService getInstance() {
		return instance;
	}
	public MemberDto getUserInfo(String id) throws Exception{
		return dao.getUserInfo(id);
	}
	
	public MemberDto login(String id, String pw) throws Exception{
		return dao.login(id,pw);
	}
	public int register(MemberDto m) throws Exception{
	return dao.register(m);
	}
	
	
	public int modify(MemberDto m) throws Exception{
		return dao.modify(m);
		}
}
