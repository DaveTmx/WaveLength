import java.util.Scanner;

public class partnerCompatibility {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 1. Input Collection
        System.out.println("--- Zodiac Compatibility Checker ---");
        
        System.out.println("Enter Your name:");
        String yourName = scanner.nextLine();
        
        System.out.println("Enter Your Zodiac sign (e.g., Aries):");
        String yourSign = scanner.nextLine().trim(); // Use trim() to clean up spacing
        
        System.out.println("Enter Partner's name:");
        String partnerName = scanner.nextLine();
        
        System.out.println("Enter Partner's Zodiac sign (e.g., Taurus):");
        String partnerSign = scanner.nextLine().trim();
        
        // Close the scanner
        scanner.close();

        // 2. Compatibility Logic
        int compatibilityPercentage = calculateCompatibility(yourSign, partnerSign);

        // 3. Display Results
        System.out.println("\n------------------------------------");
        System.out.println("✨ Compatibility Report for " + yourName + " and " + partnerName + " ✨");
        System.out.println("------------------------------------");
        System.out.println(yourSign + " (" + yourName + ") vs. " + partnerSign + " (" + partnerName + ")");
        System.out.println("Your compatibility score is: " + compatibilityPercentage + "%");
        
        System.out.print("Analysis: ");
        if (compatibilityPercentage >= 80) {
            System.out.println("*An incredibly harmonious match! The stars align!*");
        } else if (compatibilityPercentage >= 65) {
            System.out.println("*A great foundation! Strong potential for a lasting bond.*");
        } else if (compatibilityPercentage >= 45) {
            System.out.println("*A decent connection. Requires communication and effort.*");
        } else {
            System.out.println("*Challenging pairing. Focus on what you have in common!*");
        }
        System.out.println("------------------------------------");
    }

    /*
     * Determines the Zodiac element for a given sign.
     * @param sign The Zodiac sign as a String.
     * @return The element (e.g., "FIRE", "EARTH") or "UNKNOWN".
     */
    public static String getElement(String sign) {
        // Convert to uppercase for case-insensitive comparison
        String upperSign = sign.toUpperCase(); 

        switch (upperSign) {
            // FIRE Signs
            case "ARIES":
            case "LEO":
            case "SAGITTARIUS":
                return "FIRE";
            
            // EARTH Signs
            case "TAURUS":
            case "VIRGO":
            case "CAPRICORN":
                return "EARTH";
            
            // AIR Signs
            case "GEMINI":
            case "LIBRA":
            case "AQUARIUS":
                return "AIR";
            
            // WATER Signs
            case "CANCER":
            case "SCORPIO":
            case "PISCES":
                return "WATER";
                
            default:
                return "UNKNOWN";
        }
    }

   // Inside the PartnerCompatibility class, replace the previous method:

/**
 * Checks if two signs match a specific pair, regardless of order.
 */
public static boolean isPair(String sign1, String sign2, String target1, String target2) {
    // Convert to lowercase and compare
    return (sign1.equalsIgnoreCase(target1) && sign2.equalsIgnoreCase(target2)) ||
           (sign1.equalsIgnoreCase(target2) && sign2.equalsIgnoreCase(target1));
}

/*
 * Calculates a compatibility percentage based on specific sign rules, 
 * then falls back to elemental rules.
 */
public static int calculateCompatibility(String sign1, String sign2) {
    // 1. High-Compatibility Exceptions (The "Power Couples")
    // These pairs are historically noted for high compatibility, often transcending elemental rules.
    if (isPair(sign1, sign2, "Gemini", "Libra") || // Air/Air
        isPair(sign1, sign2, "Scorpio", "Cancer") || // Water/Water
        isPair(sign1, sign2, "Taurus", "Virgo") || // Earth/Earth
        isPair(sign1, sign2, "Aries", "Sagittarius")) { // Fire/Fire
        return 95; // Extremely high score
    }

    // 2. Challenging-Compatibility Exceptions (The "Red Flags")
    // These pairs often represent major clashes or tension.
    if (isPair(sign1, sign2, "Aries", "Cancer") || // Fire/Water
        isPair(sign1, sign2, "Taurus", "Aquarius") || // Earth/Air
        isPair(sign1, sign2, "Leo", "Scorpio") || // Fire/Water
        isPair(sign1, sign2, "Virgo", "Gemini")) { // Earth/Air
        return 25; // Very low score
    }
    
    // 3. Fallback to Elemental Logic (as previously defined)
    
    String element1 = getElement(sign1);
    String element2 = getElement(sign2);
    
    // Handle invalid input
    if (element1.equals("UNKNOWN") || element2.equals("UNKNOWN")) {
        System.err.println("Error: One or both signs were not recognized.");
        return 0;
    }

    // Elemental Rules (The scores are slightly adjusted to leave room for the exceptions above)
    if (element1.equals(element2)) {
        // Same element (e.g., Fire/Fire) - High compatibility
        return 80;
    } else if ((element1.equals("FIRE") && element2.equals("AIR")) || (element1.equals("AIR") && element2.equals("FIRE"))) {
        // Fire and Air - Great compatibility
        return 75;
    } else if ((element1.equals("EARTH") && element2.equals("WATER")) || (element1.equals("WATER") && element2.equals("EARTH"))) {
        // Earth and Water - Great compatibility
        return 70;
    } else if ((element1.equals("FIRE") && element2.equals("EARTH")) || (element1.equals("EARTH") && element2.equals("FIRE"))) {
        // Fire and Earth - Neutral
        return 50;
    } else if ((element1.equals("WATER") && element2.equals("AIR")) || (element1.equals("AIR") && element2.equals("WATER"))) {
        // Water and Air - Neutral
        return 40;
    }
    
    // Default/Opposite element pairings (e.g., Fire/Water which aren't already exceptions)
    return 35;
}
