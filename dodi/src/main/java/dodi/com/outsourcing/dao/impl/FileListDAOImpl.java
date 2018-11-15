package dodi.com.outsourcing.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import dodi.com.outsourcing.dao.FileListDAO;
import dodi.com.outsourcing.vo.FileList;

@Repository
public class FileListDAOImpl implements FileListDAO {
	@Autowired
	private SqlSession ss;

	@Override
	public List<FileList> selectFileList(FileList fl) {
		return ss.selectList("SQL.FILELIST.selectFileList",fl);
	}

	@Override
	public FileList selectFile(FileList fl) {
		return ss.selectOne("SQL.FILELIST.selectFile",fl);
	}

	@Override
	public int updateFile(List<FileList> fl) {
		return ss.update("SQL.FILELIST.updateFileList",fl);
	}

	@Override
	public int insertFile(List<FileList> fl) {
		return ss.insert("SQL.FILELIST.insertFileList",fl);
	}

	@Override
	public int deleteFile(List<FileList> fl) {
		return ss.delete("SQL.FILELIST.deleteFileList",fl);
	}

}
