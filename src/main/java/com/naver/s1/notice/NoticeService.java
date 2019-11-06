package com.naver.s1.notice;

import java.util.List;

public class NoticeService {
	private NoticeDAO noticeDAO;
	
	public NoticeService() {
		this.noticeDAO = new NoticeDAO();
	}
	
	public List<NoticeDTO> noticeList() throws Exception {
		List<NoticeDTO> ar = noticeDAO.noticeList();
		return ar;
	}
	
	public NoticeDTO noticeSelect(int num) throws Exception {
		NoticeDTO noticeDTO = noticeDAO.noticeSelect(num);
		return noticeDTO;
	}
	
	public int noticeWrite(NoticeDTO noticeDTO) throws Exception {
		int result = noticeDAO.noticeWrite(noticeDTO);
		return result;
	}
}
