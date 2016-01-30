package main;

import utils.Pair;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Random;

public class Session {

	private static Session session;
	private static boolean debug;
	public  BigInteger globalKeyP;
	public BigInteger globalKeyQ;
	public BigInteger globalKeyG;
	private static int L = 512;

	public static Session getInstance(boolean debugMode) {
		if (session == null)
			session = new Session(debugMode);

		return session;

	}

	private Session(boolean b) {
		debug = b;
		debugMode("=== CREATION OF GLOBAL KEYS ===", true);

		// ==Q==
		debugMode("Creating global key Q .......... ", false);

		globalKeyQ = new BigInteger(160, 20, new SecureRandom());
		debugMode("[OK]", true);

		// ==P==
		debugMode("Creating global key P (be patient).......... ", false);

		BigInteger tempP;
		BigInteger tempP2;
		SecureRandom rand = new SecureRandom();
		do {
			tempP = new BigInteger(L, 20, rand);
			tempP2 = tempP.subtract(BigInteger.ONE);
			tempP = tempP.subtract(tempP2.remainder(globalKeyQ));
		} while (!tempP.isProbablePrime(20) || tempP.bitLength() != L);

		BigInteger p = tempP;

		globalKeyP = p;
		debugMode("[OK]", true);

		// ==G==
		debugMode("Creating global key G .......... ", false);
		BigInteger p1 = globalKeyP.subtract(BigInteger.ONE);
		BigInteger exp = p1.divide(globalKeyQ);

		BigInteger tempg;
		Random random = new Random();
		do {
			tempg = new BigInteger(p1.bitLength(), random);
		} while (tempg.compareTo(p1) != -1
				&& tempg.compareTo(BigInteger.ONE) != 1);
		globalKeyG = tempg.modPow(exp, p);
		debugMode("[OK]", true);
		debugMode("", true);
		debugMode("Q: " + globalKeyQ, true);
		debugMode("P: " + globalKeyP, true);
		debugMode("G: " + globalKeyG, true);
	}

	public BigInteger getGlobalKeyP() {
		return globalKeyP;
	}

	public BigInteger getGlobalKeyQ() {
		return globalKeyQ;
	}

	public BigInteger getGlobalKeyG() {
		return globalKeyG;
	}

	private void debugMode(String s, boolean ln) {
		if (debug) {
			if (ln) {
				System.out.println(s);
			} else {
				System.out.print(s);
			}
		}
	}

	public Pair<BigInteger, BigInteger> getPrivateKey() {

		debugMode("=== CREATION OF PRIVATE KEY ===", true);
		// Private key
		debugMode("Creating private key X .......... ", false);
		BigInteger privK = new BigInteger(getGlobalKeyQ().bitLength(), new SecureRandom());
		while (privK.compareTo(globalKeyQ) != -1) {
			privK = new BigInteger(getGlobalKeyQ().bitLength(), new SecureRandom());
		}
		debugMode("[OK]", true);
		debugMode("Creating private key Y .......... ", false);
		// Public key:
		BigInteger pubK = getGlobalKeyG().modPow(privK, getGlobalKeyP());

		Pair<BigInteger, BigInteger> result = new Pair<BigInteger, BigInteger>(
				privK, pubK);
		debugMode("[OK]", true);

		return result;
	}

}
