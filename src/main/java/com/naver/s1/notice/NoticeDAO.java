package com.naver.s1.notice;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.naver.util.DBConnector;

@Scope("prototype")
@Repository
public class NoticeDAO {
	
	public List<NoticeDTO> noticeList() throws Exception {
		Connection con = DBConnector.getConnect();
		ArrayList<NoticeDTO> ar = new ArrayList<NoticeDTO>();
		NoticeDTO noticeDTO = null;
		
		String sql = "select * from notice order by num desc";
		PreparedStatement st = con.prepareStatement(sql);
		ResultSet rs = st.executeQuery();
		
		while(rs.next()) {
			noticeDTO = new NoticeDTO();
			noticeDTO.setNum(rs.getInt(1));
			noticeDTO.setTitle(rs.getString(2));
			noticeDTO.setWriter(rs.getString(3));
			noticeDTO.setContents(rs.getString(4));
			noticeDTO.setReg_date(rs.getDate(5));
			noticeDTO.setHit(rs.getInt(6));
			
			ar.add(noticeDTO);
		}
		
		rs.close();
		st.close();
		con.close();
		
		return ar;
	}
	
	public NoticeDTO noticeSelect(int num) throws Exception {
		Connection con = DBConnector.getConnect();
		NoticeDTO noticeDTO = null;
		
		String sql = "select * from notice where num=?";
		PreparedStatement st = con.prepareStatement(sql);
		st.setInt(1, num);
		
		ResultSet rs = st.executeQuery();
		
		if(rs.next()) {
			noticeDTO = new NoticeDTO();
			noticeDTO.setNum(rs.getInt(1));
			noticeDTO.setTitle(rs.getString(2));
			noticeDTO.setWriter(rs.getString(3));
			noticeDTO.setContents(rs.getString(4));
			noticeDTO.setReg_date(rs.getDate(5));
			noticeDTO.setHit(rs.getInt(6));
		}
		
		rs.close();
		st.close();
		con.close();
		
		return noticeDTO;
	}
	
	public int noticeWrite(NoticeDTO noticeDTO) throws Exception {
		int result = 0;
	
		Connection con = DBConnector.getConnect();
		String sql = "insert into notice values (board_seq.nextval, ?, ?, ?, sysdate, 0)";
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, noticeDTO.getTitle());
		st.setString(2, noticeDTO.getWriter());
		st.setString(3, noticeDTO.getContents());
		
		result = st.executeUpdate();
		
		st.close();
		con.close();
		
		return result;
	}
	

}
