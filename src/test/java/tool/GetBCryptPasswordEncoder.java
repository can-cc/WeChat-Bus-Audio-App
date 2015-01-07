package tool;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class GetBCryptPasswordEncoder {

	public static void main(String[] args) {
		BCryptPasswordEncoder bp = new BCryptPasswordEncoder();
		String becode = "wang";
		System.out.println(bp.encode(becode));
	}
}
