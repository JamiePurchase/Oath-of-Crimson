package android.jp.oathofcrimson.Campaign.Accomplishment;

public class Accomplishment
{
    private String title;
    private String description;
    private boolean secret;
    private boolean unlock;

    public Accomplishment(String title, String description, boolean secret)
    {
        this.title = title;
        this.description = description;
        this.secret = secret;
        this.unlock = false;
    }

    public void unlock()
    {
        this.unlock = true;
    }
}