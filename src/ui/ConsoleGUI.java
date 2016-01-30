package ui;

import main.DSA;
import main.Session;
import utils.Pair;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class ConsoleGUI {

	public static void main(String[] args) {

		System.out.println("Please select option:");
		System.out.println("  1. Sign message");
		System.out.println("  2. Verify message");

		String alg = null;
		try {
			alg = (new BufferedReader(new InputStreamReader(System.in))).readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}

		if (alg == null) {
			alg = "1";
		}
		if (alg.equals("1")) {
			startSession();
		} else if (alg.equals("2")) {
			verifyMessage();
		} else {
			System.exit(1);
		}

	}

	private static void startSession() {
		Session session = Session.getInstance(true);

		Pair<BigInteger, BigInteger> privateKeys = session.getPrivateKey();

		System.out.println("");
		System.out.println("Private key x: " + privateKeys.getFirst());
		System.out.println("Private key y: " + privateKeys.getSecond());
		System.out.println("");

		System.out.println("Please introduce message to sign:");
		String text = null;
		while (text == null) {
			try {
				text = (new BufferedReader(new InputStreamReader(System.in)))
						.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		Pair<BigInteger, BigInteger> signature = DSA.sign(true, text, session.getGlobalKeyG(), session.getGlobalKeyP(),
				session.getGlobalKeyQ(), privateKeys.getFirst());
		System.out.println("Signature (r,s): (" + signature.getFirst() + ", "
				+ signature.getSecond() + ")");
		System.out.println("");
		System.out.println("Do you want to verify a message?");
		System.out.println("  1. Yes");
		System.out.println("  2. No");
		String alg = null;
		try {
			alg = (new BufferedReader(new InputStreamReader(System.in)))
					.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}

		if (alg != null && alg.equals("1")) {
			verifyMessage();
		} else {
			System.out.println("Bye!");
			System.exit(1);
		}

	}

	public static BigInteger getElement() {
		BigInteger big = null;
		while (big == null) {
			try {
				BufferedReader br = new BufferedReader(new InputStreamReader(
						System.in));
				String str = br.readLine();
				if (str.isEmpty()) {
					throw new RuntimeException("Please don't enter an empty number");
				}
				big = new BigInteger(str, 10);

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return big;
	}

	private static void verifyMessage() {
		System.out.println("Please introduce message to verify: ");
		String text = null;
		while (text == null) {
			try {
				text = (new BufferedReader(new InputStreamReader(System.in)))
						.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		System.out.println("Please introduce the first element of the signature (r):");
		BigInteger r = getElement();

		System.out.println("Please introduce the second element of the signature (s):");
		BigInteger s = getElement();

		System.out.println("Please introduce the public key (p):");
		BigInteger p = getElement();

		System.out.println("Please introduce the public key (q):");
		BigInteger q = getElement();

		System.out.println("Please introduce the public key (g):");
		BigInteger g = getElement();

		System.out.println("Please introduce the private key (y):");
		BigInteger y = getElement();

		System.out.println("");
		Boolean res = DSA.verify(true, text, r, s, g, p, q, y);
		
		System.out.println("=== VERIFICATION STATUS ===");
		if (res) {
			System.out.println("Approved!!");
		} else {
			System.out.println("Failed! (Hope is not my fault)");
		}
	}
}
