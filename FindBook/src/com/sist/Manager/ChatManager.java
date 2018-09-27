package com.sist.Manager;

import java.util.*;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import com.sist.dao.BookVO;

public class ChatManager {

	public ArrayList<ChatVO> ChatData() {
		ArrayList<ChatVO> list = new ArrayList<ChatVO>();

		try {
			Document doc = Jsoup.connect("https://ridibooks.com/bestsellers/general").get();// 데이터를 읽어 와라

			Elements title = doc.select("h3.book_metadata a.title_link span.title_text");
			Elements author = doc.select("p.book_metadata a.js_author_detail_link");
			Elements poster = doc.select("div.book_thumbnail div.thumbnail_image img.thumbnail");
			Elements titleNo = doc.select("div.book_thumbnail_wrapper");

			for (int i = 0; i < 30; i++) {
				ChatVO cate = new ChatVO();
				cate.setCateNo(i + 1);
				cate.setTitle(title.get(i).text());
				cate.setAuthor(author.get(i).text());
				cate.setPoster("https:" + poster.get(i).attr("data-src"));
				cate.setTitleNo(titleNo.get(i).attr("data-book_id_for_tracking"));

				list.add(cate);
			}
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			// 에러 출력
		}
		return list;
	}

	public ArrayList<BookVO> getCategoryBook(String cate) {
		DetailManager m = new DetailManager();
		ArrayList<BookVO> list = m.bookInfoData();
		ArrayList<BookVO> temp = new ArrayList<BookVO>();
		for (BookVO vo : list) {
			if (vo.getCate().equals(cate)) {
				temp.add(vo);
			}
		}
		return temp;
	}

	public static void main(String[] args) {
		ChatManager Cm = new ChatManager();
		// Cm.ChatData();
		ArrayList<BookVO> list = Cm.getCategoryBook("영미소설");
		for (BookVO vo : list) {
			System.out.println(vo.getTitle());
		}

	}
}
