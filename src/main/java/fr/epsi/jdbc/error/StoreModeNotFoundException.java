package fr.epsi.jdbc.error;

public class StoreModeNotFoundException extends Exception {

    private String mode;

    public StoreModeNotFoundException(String mode) {
        this.mode = mode;
    }

    @Override
    public String getMessage() {
        return String.format( "Le store mode paramétré (%s) n'est pas implémentée !", mode);
    }
}
