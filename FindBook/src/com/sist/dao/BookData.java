package com.sist.dao;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.*;
import java.sql.*;

public class BookData {
	public static int totalpage;
	public static ArrayList<BookVO> mList = new ArrayList<BookVO>();
	static {
		try {
			FileInputStream fr = new FileInputStream("c:\\javaDev\\booklist.txt");
			BufferedReader br = new BufferedReader(new InputStreamReader(fr));
			while (true) {
				String str = br.readLine();
				// 1|쇼생크
				// 탈출|드라마|https://movie-phinf.pstatic.net/20160119_278/14531650465287bcuk_JPEG/movie_image.jpg?type=m77_110_2|팀
				// 로빈스(앤디 듀프레인), 모건 프리먼(엘리스 보이드 레드 레딩)|2016 .02.24 재개봉, 1995 .01.28 개봉|15세
				// 관람가|프랭크 다라본트
				try {
					StringTokenizer st = new StringTokenizer(str, "|");
					BookVO vo = new BookVO();
					vo.setTitle(st.nextToken());
					vo.setCate(st.nextToken());
					vo.setPoster(st.nextToken());
					vo.setAuth(st.nextToken());
					vo.setPub(st.nextToken());
					vo.setDate(st.nextToken());
					vo.setDesc(st.nextToken());
					vo.setIndex(st.nextToken());
					vo.setRate(st.nextToken());
					vo.setReview(st.nextToken());
					// vo.setreview
					mList.add(vo);
				} catch (Exception ex) {
				}

				if (str == null)
					break;

			}
			totalpage = (int) (Math.ceil(mList.size() / 10.0));
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}

	public static void main(String[] arg) {

	}

	public static ArrayList<BookVO> movieAllData(int page) {
		ArrayList<BookVO> list = new ArrayList<BookVO>();
		int j = 0;// 10
		int rowSize = 10;
		int start = (page * rowSize) - rowSize;
		/*
		 * 1page 0~9 => 2page 10~19 3page 20~29
		 */
		int end = page * rowSize;
		// 403 ==> 40 => 41 ==> 400 ==> 403
		int t = (int) (Math.ceil(mList.size() / 10.0));
		if (page == t) {
			end = mList.size() - 1;
		}
		for (int i = start; i < end; i++) {
			BookVO vo = mList.get(i);
			list.add(vo);
		}
		return list;
	}

	public static ArrayList<BookVO> movieGenreData(String cate, int page) {
		ArrayList<BookVO> list = new ArrayList<BookVO>();

		ArrayList<BookVO> temp = new ArrayList<BookVO>();
		for (BookVO vo : mList) {
			if (vo.getCate().contains(cate)) {
				temp.add(vo);
			}
		}
		totalpage = (int) (Math.ceil(temp.size() / 10.0));
		int j = 0;// 10
		int rowSize = 10;
		int start = (page * rowSize) - rowSize;
		/*
		 * 1page 0~9 => 2page 10~19 3page 20~29
		 */
		int end = page * rowSize;
		// 403 ==> 40 => 41 ==> 400 ==> 403
		int t = (int) (Math.ceil(temp.size() / 10.0));
		if (page == t) {
			end = temp.size() - 1;
		}
		for (int i = start; i < end; i++) {
			BookVO vo = temp.get(i);
			list.add(vo);
		}
		return list;
	}

	/*
	 * A a=new A(); A b=a;
	 */
	public static BookVO movieDetail(String title) {
		BookVO mData = new BookVO();
		for (BookVO vo : mList) {
			if (vo.getTitle().equals(title)) {
				mData = vo;
				break;
			}
		}
		return mData;
	}

	public static ArrayList<BookVO> movieRecommand(String find) {
		ArrayList<BookVO> list = new ArrayList<BookVO>();
		try {
			String data = "";// NaverManager.movieRecommand(find);
			String[] datas = data.split("\n");
			Pattern[] p = new Pattern[mList.size()];
			for (int i = 0; i < p.length; i++) {
				p[i] = Pattern.compile(mList.get(i).getTitle());
			}
			Matcher[] m = new Matcher[mList.size()];
			int[] count = new int[mList.size()];
			for (String s : datas) {

				for (int i = 0; i < m.length; i++) {
					m[i] = p[i].matcher(s);
					if (m[i].find()) {
						count[i]++;
					}
				}
			}

			for (int i = 0; i < mList.size(); i++) {
				if (count[i] > 1 && mList.get(i).getTitle().length() > 1) {
					System.out.println(mList.get(i).getTitle() + " " + count[i]);
					BookVO vo = movieDetail(mList.get(i).getTitle());
					list.add(vo);
				}
			}

		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
		return list;
	}

	// 전체 데이터 찾기
	public static ArrayList<BookVO> bookFindData(String title) {
		ArrayList<BookVO> list = new ArrayList<BookVO>();
		for (BookVO vo : mList) {
			if (vo.getTitle().contains(title)) {
				list.add(vo);
			}
		}
		return list;
	}
	//
}
