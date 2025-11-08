package edu.algonquin.cst8411.utils;

/**
 * Tiny console demo for CST8411 Assignment 1 library.
 * <p>This class is NOT part of the reusable API; it just prints example outputs.</p>
 */
public class Demo {

    /**
     * Entry point used only to quickly showcase the library functions.
     * @param args ignored
     */
    public static void main(String[] args) {
        // FR: Démo basique pour vérifier le comportement des méthodes utilitaires.
        System.out.println("mod(-5, 3) = " + MathUtils.mod(-5, 3));
        System.out.println("pow(2, -3) = " + MathUtils.pow(2.0, -3));
        System.out.println("sqrt(144) = " + MathUtils.sqrt(144.0));
        System.out.println("percent(3, 8) = " + MathUtils.percent(3, 8));
    }
}
