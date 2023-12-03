package Model;

public enum CurrentProfileState{
    NO_PROFILE("No Profile"), PROFILE1("Profile1"), PROFILE2("Profile2");
    private String text;

    private CurrentProfileState(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }

    public String getText() {
        return text;
    }
}
