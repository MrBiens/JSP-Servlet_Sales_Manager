package test;

import java.util.ArrayList;

import DAO.TacGiaDAO;
import model.TacGia;

public class testTacGiaDAO {
	public static void main(String[] args) {
		TacGiaDAO tgd = new TacGiaDAO();
		ArrayList<TacGia> kq = tgd.selectAll();
		for (TacGia tacGia : kq) {
			System.out.println(tacGia.toString());
		}
		
	}
}
