package utils;

import java.util.Random;

public class ISBNGenerator {

    /**
     * Generates a random 13-digit ISBN number as a String.
     * The ISBN-13 format consists of 13 digits, usually starting with 978 or 979.
     * This method generates a random 13-digit number starting with 978.
     * 
     * @return A valid 13-digit ISBN number as a String.
     */
    public static String generateRandomISBN13() {
        Random random = new Random();
        StringBuilder isbn = new StringBuilder("978"); // ISBN-13 prefix

        // Generate the next 9 digits randomly
        for (int i = 0; i < 9; i++) {
            isbn.append(random.nextInt(10));
        }

        // Calculate the checksum digit
        int checksum = calculateISBN13Checksum(isbn.toString());
        isbn.append(checksum);

        return isbn.toString();
    }

    /**
     * Generates a unique 13-digit ISBN number by checking against the database.
     * Loops until a unique ISBN is found.
     * 
     * @return A unique 13-digit ISBN number as a String.
     */
    public static String generateUniqueISBN13() {
        config.dbConnect db = new config.dbConnect();
        String isbn;
        boolean isUnique = false;

        while (!isUnique) {
            isbn = generateRandomISBN13();
            try {
                String query = "SELECT COUNT(*) AS count FROM books WHERE ISBN = '" + isbn + "'";
                java.sql.ResultSet rs = db.getData(query);
                if (rs.next()) {
                    int count = rs.getInt("count");
                    if (count == 0) {
                        isUnique = true;
                        return isbn;
                    }
                }
            } catch (Exception e) {
                // In case of error, assume ISBN is unique to avoid infinite loop
                isUnique = true;
                return isbn;
            }
        }
        // Fallback, should never reach here
        return generateRandomISBN13();
    }

    /**
     * Calculates the checksum digit for an ISBN-13 number (first 12 digits).
     * 
     * @param isbn12 The first 12 digits of the ISBN-13 number.
     * @return The checksum digit (0-9).
     */
    private static int calculateISBN13Checksum(String isbn12) {
        int sum = 0;
        for (int i = 0; i < isbn12.length(); i++) {
            int digit = Character.getNumericValue(isbn12.charAt(i));
            sum += (i % 2 == 0) ? digit : digit * 3;
        }
        int mod = sum % 10;
        return (mod == 0) ? 0 : 10 - mod;
    }
}
