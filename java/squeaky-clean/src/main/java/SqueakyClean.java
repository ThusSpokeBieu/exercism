class SqueakyClean {
    public static String clean(String identifier) {
        return kebabToCamel(identifier
            .replaceAll(" ", "_")
            .replaceAll("4", "a")
            .replaceAll("3", "e")
            .replaceAll("0", "o")
            .replaceAll("1", "l")
            .replaceAll("7", "t"))
            .replaceAll("[^a-zA-Z||_]", "");
    }

    private static String kebabToCamel(String kebabCase) {
        String[] words = kebabCase.split("-");
        StringBuilder camelCase = new StringBuilder(words[0]);

        for (int i = 1; i < words.length; i++) {
            String word = words[i];
            camelCase.append(word.substring(0, 1).toUpperCase()).append(word.substring(1));
        }

        return camelCase.toString();
    }

}
