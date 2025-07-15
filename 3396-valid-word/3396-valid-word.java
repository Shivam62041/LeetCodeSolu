class Solution 
{
    public boolean isValid(String word) 
    {

        // Step 1: Check length
        if (word.length() < 3)
        {
            return false;
        } 

        // Step 2: Initialize flags
        boolean hasVowel = false;
        boolean hasConsonant = false;

        // Step 3: Loop through each character
        for (int i = 0; i < word.length(); i++) 
        {
            char c = word.charAt(i);

            // Step 3.1: Check if character is not a letter or digit
            if (!Character.isLetterOrDigit(c))
            {
                return false;
            } 

            // Step 3.2: Check if it's a letter
            if (Character.isLetter(c)) 
            {
                char lower = (char)(c | 32); // Bitwise lowercase (faster than toLowerCase)

                // Step 3.2.1: Check if it's a vowel
                if (lower == 'a' || lower == 'e' || lower == 'i' || lower == 'o' || lower == 'u') 
                {
                    hasVowel = true;
                } 
                else 
                {
                    // Step 3.2.2: Otherwise it's a consonant
                    hasConsonant = true;
                }

                // Optional: Early exit
                if (hasVowel && hasConsonant)
                {
                    continue;
                } 
            }
        }

        // Step 4: Return true only if both vowel and consonant exist
        return hasVowel && hasConsonant;
    }
}