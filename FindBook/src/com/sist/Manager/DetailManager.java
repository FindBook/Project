package com.sist.Manager;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.*;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.sist.dao.BookVO;

public class DetailManager {

	// 영화정보 얻기
	// this:클래스 자신 (모든 클래스가 가지고 있다)
	// this는 사용하는 위치 ==> 멤버메소드(인스턴스)안에서 사용이 가능

	public ArrayList<BookVO> bookInfoData() {
		ArrayList<BookVO> list = new ArrayList<BookVO>();

		ArrayList<String> url = new ArrayList<String>();
		ArrayList<String> revurl = new ArrayList<String>();
		String[] catelink = { "https://ridibooks.com/category/books/100", "https://ridibooks.com/category/books/800",
				"https://ridibooks.com/category/books/500" };

		int num = 0;
		for (int k = 0; k < catelink.length; k++) {

			for (int i = 1; i <= 200; i++) // 출력하고싶은 페이지만큼
			{
				try {
					Document doc = Jsoup.connect(catelink[k] + "?page=" + i).get();
					Elements elem = doc.select("div.book_metadata_wrapper h3.meta_title a");

					for (int j = 0; j < elem.size(); j++) {
						String strLink = elem.get(j).attr("href"); // /v2/Detail?id=2244000003
						String reviewLink = strLink.substring(strLink.indexOf('=') + 1); // 2244000003
						url.add(num, "https://ridibooks.com" + strLink); // https://ridibooks.com/v2/Detail?id=2244000003
						revurl.add("https://ridibooks.com/books/load-reviews?book_id=" + reviewLink
								+ "&offset=0&order=latest&buyer_only=false"); // 리뷰긁는링크
						// System.out.println(strLink);
						// System.out.println(reviewLink);
						// System.out.println(url);
						num++;
						if (num > 200)
							break;
					}

				} catch (Exception e) {

					System.out.println("detailLinkData():" + e.getMessage());
				}
			}
		}

		int i = 0;
		for (String u : url) {
			try {
				// System.out.println(u);
				Document doc = Jsoup.connect(u).get();
				Element cate = doc.select("div.header_info_wrap p.info_category_wrap a").get(1);
				Element title = doc.selectFirst("div.info_title_wrap h3.info_title_wrap");
				Element auth = doc.selectFirst("div.info_metadata_wrap p.metadata_writer a");
				Element pub = doc.selectFirst("p.publisher_info a");
				Element date = doc.select("div.Header_Metadata_Block ul.Header_Metadata_List li.published_date_info")
						.last();
				Element desc = doc.selectFirst("div#introduce_book p.introduce_paragraph");
				Element index = doc.selectFirst("div#book_table p.introduce_paragraph");
				Element poster = doc.selectFirst("div.thumbnail_image img.thumbnail");
				Element rate = doc.selectFirst("p.star_rate span.StarRate_Score");

				// System.out.println(i);
				String reviews = "";
				try {
					Document doc2 = Jsoup.connect(revurl.get(i)).get();
					for (int j = 0; j < 10; j++) {
						Elements review = doc2.select("div.list_right p.review_content");
						reviews += "√ " + review.get(j).text() + "<br>";
					}
				} catch (Exception e) {
				}

				i++;
				System.out.println(title.text());
				System.out.println(auth.text());
				System.out.println(pub.text());
				System.out.println(date.text());
				System.out.println(desc.html());
				System.out.println(index.html());
				System.out.println(poster.attr("data-original-cover"));
				System.out.println(rate.text());
				System.out.println(reviews);
				System.out.println("=============");

				BookVO book = new BookVO();
				book.setCate(cate.text());
				book.setTitle(title.text());
				book.setAuth(auth.text());
				book.setPub(pub.text());
				book.setDate(date.text());
				book.setDesc(desc.html());
				book.setIndex(index.html());
				book.setPoster(poster.attr("data-original-cover"));
				book.setRate(rate.text());
				book.setReview(reviews);

				list.add(book);

			} catch (Exception ex) {
				// System.out.println("bookInfoData():"+ex.getMessage());
			}
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

		DetailManager m = new DetailManager();
		ArrayList<BookVO> list = m.bookInfoData(); // 메소드바꾸기
		// ArrayList<DetailVO> list=m.getCategoryBook("영미소설");
		for (BookVO vo : list) {
			System.out.println(vo.getTitle());
		}

		try {
			File f = new File("c:\\data\\booklist.txt");
			if (f.exists())
				f.delete();
			FileWriter fw = new FileWriter("c:\\data\\booklist.txt", true);
			// true가없으면 다 덮어써서 맨 마지막 데이터만 나옴(append)
			// 내용갱신할땐 true주면안됨
			for (BookVO vo : list) {
				String str = vo.getTitle() + "|" + vo.getCate() + "|" + vo.getPoster() + "|" + vo.getAuth() + "|"
						+ vo.getPub() + "|" + vo.getDate() + "|" + vo.getDesc() + "|" + vo.getIndex() + "|"
						+ vo.getRate() + "|" + vo.getReview() + "\r\n";
				fw.write(str);
			}
			fw.close();
			System.out.println("SAVE End..");
		} catch (Exception e) {
		}

	}
}