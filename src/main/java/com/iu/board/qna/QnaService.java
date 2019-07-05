package com.iu.board.qna;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.iu.board.BoardDTO;
import com.iu.board.BoardService;
import com.iu.file.FileDAO;
import com.iu.file.FileDTO;
import com.iu.util.FileSaver;
import com.iu.util.PageMaker;

@Service
public class QnaService implements BoardService {

	@Inject
	private QnaDAO qnaDAO;
	@Inject
	private FileDAO fileDAO;
	@Inject
	private FileSaver fileSaver;
	
	@Override
	public int setWrite(BoardDTO boardDTO, List<MultipartFile> multipartFiles, HttpSession session) throws Exception {
		// qna insert
		int result = qnaDAO.setWrite(boardDTO);
		String realPath = session.getServletContext().getRealPath("/resources/qna");
		//files insert
		
		//num=boardDTO.getNum();
		//oname = multipartFiles.getOriginalName();
		//fname =fileSaver.saveFile(realpath, multipartFile); 에서 리턴되는 것.
		ArrayList<FileDTO> files = new ArrayList<FileDTO>();
		for(MultipartFile f : multipartFiles) {
			if(f.getOriginalFilename().length()>0) {
				FileDTO fileDTO = new FileDTO();
				fileDTO.setNum(boardDTO.getNum());
				fileDTO.setOname(f.getOriginalFilename());
				fileDTO.setFname(fileSaver.saveFile(realPath, f));
				files.add(fileDTO);
			}
		}
		result=fileDAO.setWrite(files);
		return result;
	}

	@Override
	public List<BoardDTO> getList(PageMaker pageMaker) throws Exception {
		//1.startRow lastRow
		pageMaker.makeRow();
		List<BoardDTO> ar=qnaDAO.getList(pageMaker);
		//2.paging
		int totalCount=qnaDAO.getTotalCount(pageMaker);
		pageMaker.makePage(totalCount);
		return ar;
	}

	@Override
	public BoardDTO getSelect(int num) throws Exception {
		return qnaDAO.getSelect(num);
	}

	@Override
	public int setUpdate(BoardDTO boardDTO) throws Exception {
		return 0;
	}

	@Override
	public int setDelete(int num) throws Exception {
		return qnaDAO.setDelete(num);
	}

	//reply
	public int setReply(QnaDTO qnaDTO) throws Exception{
		int result = qnaDAO.setReplyUpdate(qnaDTO);
		result = qnaDAO.setReply(qnaDTO);
		return result;
	}
}
