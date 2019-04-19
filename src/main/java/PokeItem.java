public abstract class PokeItem {
    protected String name;
    protected boolean disposable;

    public String getName() {
        return this.name;
    }

    public boolean isDisposable() {
        return this.disposable;
    }
}