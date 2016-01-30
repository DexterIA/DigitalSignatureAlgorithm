package main;


import utils.Pair;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.SecureRandom;

public class DSA {

    public static Pair<BigInteger, BigInteger> sign(String message, BigInteger publcG, BigInteger publicP,
                                                    BigInteger publicQ, BigInteger privateX) {
        debugMode("=== CREATING SIGNATURE ===", true);

        // K
        debugMode("Creating auxiliar variable K .......... ", false);
        BigInteger k = new BigInteger(publicQ.bitLength(), new SecureRandom());
        while (k.compareTo(publicQ) != -1 && k.compareTo(BigInteger.ZERO) != 1) {
            k = new BigInteger(publicQ.bitLength(), new SecureRandom());
        }
        debugMode("[OK]", true);

        // R
        debugMode("Creating R .......... ", false);
        BigInteger r = publcG.modPow(k, publicP).mod(publicQ);
        debugMode("[OK]", true);

        // S
        debugMode("Creating S .......... ", false);
        MessageDigest md;
        BigInteger s = BigInteger.ONE;
        try {
            md = MessageDigest.getInstance("SHA-1");
            md.update(message.getBytes());
            BigInteger hash = new BigInteger(md.digest());
            s = (k.modInverse(publicQ).multiply(hash.add(privateX.multiply(r)))).mod(publicQ);
        } catch (Exception e) {
            e.printStackTrace();
        }
        debugMode("[OK]", true);
        return new Pair<BigInteger, BigInteger>(r, s);
    }

    public static Boolean verify(String message, BigInteger r, BigInteger s, BigInteger publcG, BigInteger publicP,
                                 BigInteger publicQ, BigInteger privateY) {
        debugMode("=== VERIFYING SIGNATURE ===", true);
        MessageDigest md;
        BigInteger v = BigInteger.ZERO;
        try {
            md = MessageDigest.getInstance("SHA-1");
            md.update(message.getBytes());
            BigInteger messagehash = new BigInteger(md.digest());
            debugMode("Creating W .......... ", false);
            BigInteger w = s.modInverse(publicQ);
            debugMode("[OK]", true);
            debugMode("Creating U1 .......... ", false);
            BigInteger u1 = messagehash.multiply(w).mod(publicQ);
            debugMode("[OK]", true);
            debugMode("Creating U2 .......... ", false);
            BigInteger u2 = r.multiply(w).mod(publicQ);
            debugMode("[OK]", true);
            debugMode("Creating V .......... ", false);
            v = ((publcG.modPow(u1, publicP).multiply(privateY.modPow(u2,
                    publicP))).mod(publicP)).mod(publicQ);
            debugMode("[OK]", true);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        return v.compareTo(r) == 0;
    }

    private static void debugMode(String s, boolean ln) {
        if (ln) {
            System.out.println(s);
        } else {
            System.out.print(s);
        }
    }

}
