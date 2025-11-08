package edu.algonquin.cst8411.utils;

/**
 * A tiny, reusable math utility library used for CST8411 Assignment 1.
 *
 * <p>Exposed functions:
 * <ul>
 *   <li>{@link #mod(int, int)} - safe modulo with negative support</li>
 *   <li>{@link #pow(double, int)} - fast exponentiation (exponent is integer)</li>
 *   <li>{@link #sqrt(double)} - square root via Newton's method</li>
 *   <li>{@link #percent(double, double)} - percentage (part/whole * 100)</li>
 * </ul>
 *
 * <p>Design goals: simple, deterministic, input validation, clear exceptions.
 *
 * @author R.
 * @since 1.0.0
 */
public final class MathUtils {

    // FR: Constructeur privé pour empêcher l'instanciation de la classe utilitaire.
    private MathUtils() {}

    /**
     * Computes a "safe" modulo that is always in the range [0, |b|).
     *
     * <p>Unlike Java's remainder operator, this implementation normalizes
     * negative results to a positive representative modulo |b|.
     *
     * @param a dividend
     * @param b divisor (must not be zero)
     * @return a mod b in [0, |b|)
     * @throws IllegalArgumentException if b == 0
     */
    public static int mod(int a, int b) {
        // FR: Validation des entrées
        if (b == 0) {
            throw new IllegalArgumentException("b must not be zero");
        }
        int r = a % b;
        // FR: Si le reste est négatif, on le remet dans l'intervalle positif.
        if (r < 0) {
            r += Math.abs(b);
        }
        return r;
    }

    /**
     * Computes base^exp using fast exponentiation (exponentiation by squaring).
     *
     * <p>Time complexity: O(log |exp|). Supports negative exponents by returning 1/result.
     *
     * @param base the base
     * @param exp  integer exponent (can be negative, zero, or positive)
     * @return base^exp
     */
    public static double pow(double base, int exp) {
        // FR: Cas trivial
        if (exp == 0) return 1.0;

        // FR: On gère l'exposant négatif en inversant à la fin.
        boolean negative = exp < 0;
        long e = Math.abs((long) exp);

        double result = 1.0;
        double cur = base;

        // FR: Exponentiation rapide par dichotomie (exponentiation by squaring).
        while (e > 0) {
            if ((e & 1L) == 1L) {
                result *= cur;
            }
            cur *= cur;
            e >>= 1;
        }
        return negative ? 1.0 / result : result;
    }

    /**
     * Computes the square root of a non-negative number using Newton's method.
     *
     * @param x non-negative input
     * @return sqrt(x)
     * @throws IllegalArgumentException if x &lt; 0
     */
    public static double sqrt(double x) {
        // FR: Protection contre les entrées négatives
        if (x < 0) throw new IllegalArgumentException("x must be >= 0");
        // FR: Cas rapide pour 0
        if (x == 0.0) return 0.0;

        // FR: Méthode de Newton: r_{n+1} = (r_n + x / r_n) / 2
        double r = x;      // FR: estimation initiale
        double prev;
        int guard = 0;     // FR: garde-fou contre boucle infinie

        do {
            prev = r;
            r = 0.5 * (r + x / r);
            guard++;
            // FR: On limite le nombre d'itérations pour la sécurité.
            if (guard > 200) break;
        } while (Math.abs(r - prev) > 1e-12);

        return r;
    }

    /**
     * Returns the percentage value (part / whole * 100).
     *
     * @param part  numerator
     * @param whole denominator (must not be zero)
     * @return percentage in double
     * @throws IllegalArgumentException if whole == 0
     */
    public static double percent(double part, double whole) {
        // FR: Vérifie la division par zéro
        if (whole == 0.0) throw new IllegalArgumentException("whole must not be zero");
        return (part / whole) * 100.0;
    }
}
