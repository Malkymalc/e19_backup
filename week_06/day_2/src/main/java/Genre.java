public enum Genre {
    // 1. The list of enum constants - and any properties they will have (in parens) - must come before any declaration of
    // their *private* properties or *public* methods.

    THRILLER("Thriller"),
    CHILLER("Chiller"),
    DRAMA("Drama"),
    ROMANCE("Romance"),
    CLASSIC("Classic"),
    POETRY("Poetry"),
    CHILDRENS("Children's"),
    NONFICTION("Non-fiction"),
    REFERENCE("Reference");

    // 2. Declare any properties that *each* enum will have.
    //  - Properties must be private.
    private final String description;

    // 3. Define Constructor for the enum constants listed above
    // - This will set their properties based on the args in their (parens).
    // - Constructor must be private.
    private Genre(String description) {
        this.description = description;
    }

    // 4. Write any *public* methods for getting the properties of each enum constant, etc.
    // - Make these methods public if you wish properties etc. to be available.
    public String getDescription() {
        return this.description;
    }
}
