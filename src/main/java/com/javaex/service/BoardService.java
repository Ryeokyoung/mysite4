package com.javaex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.BoardDao;
import com.javaex.vo.BoardVo;


@Service
public class BoardService {

	@Autowired
	private static BoardDao boardDao;
	// 생성자

	// GS

	// 일반
	public List<BoardVo> boardList() {

		return boardDao.boardList();
	}

	public BoardVo readBoard(int no) {

		return boardDao.readBoard(no);
	}

	public int delete(int no) {

		return boardDao.delete(no);

	}

	public int write(BoardVo boardVo) {

		return boardDao.write(boardVo);
	}

	public int hitcount(int no) {

		return boardDao.hitcount(no);
	}

	public static int modify(BoardVo boardVo) {

		return boardDao.modify(boardVo);
	}

	public static List<BoardVo> search(String key) {

		return boardDao.search(key);
	}

}

