package com.pluralsight;

public class NameFormatter {

    // Prevent instantiation
    private NameFormatter() {
    }

    // 1. First & Last
    public static String format(String firstName, String lastName) {
        return lastName + ", " + firstName;
    }

    // 2. Full Breakdown
    public static String format(String prefix,
                                String firstName,
                                String middleName,
                                String lastName,
                                String suffix) {

        StringBuilder result = new StringBuilder();

        // Last Name always first
        result.append(lastName).append(", ");

        // Prefix (if exists)
        if (prefix != null && !prefix.isEmpty()) {
            result.append(prefix).append(" ");
        }

        // First Name
        result.append(firstName);

        // Middle Name (optional)
        if (middleName != null && !middleName.isEmpty()) {
            result.append(" ").append(middleName);
        }

        // Suffix (optional)
        if (suffix != null && !suffix.isEmpty()) {
            result.append(", ").append(suffix);
        }

        return result.toString();
    }

    // 3. Parse full string
    public static String format(String fullName) {

        String suffix = "";
        String namePart = fullName;

        // Split suffix if present
        if (fullName.contains(",")) {
            String[] parts = fullName.split(",");
            namePart = parts[0].trim();
            suffix = parts[1].trim();
        }

        String[] nameParts = namePart.split(" ");

        String prefix = "";
        String firstName = "";
        String middleName = "";
        String lastName = "";

        if (nameParts.length == 2) {
            firstName = nameParts[0];
            lastName = nameParts[1];
        }
        else if (nameParts.length == 3) {
            // could be prefixed or middle name
            if (nameParts[0].endsWith(".")) {
                prefix = nameParts[0];
                firstName = nameParts[1];
                lastName = nameParts[2];
            } else {
                firstName = nameParts[0];
                middleName = nameParts[1];
                lastName = nameParts[2];
            }
        }
        else if (nameParts.length == 4) {
            prefix = nameParts[0];
            firstName = nameParts[1];
            middleName = nameParts[2];
            lastName = nameParts[3];
        }

        return format(prefix, firstName, middleName, lastName, suffix);
    }
}

