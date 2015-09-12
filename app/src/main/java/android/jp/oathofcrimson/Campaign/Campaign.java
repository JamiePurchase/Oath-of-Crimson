package android.jp.oathofcrimson.Campaign;

public class Campaign
{
    private String campaignRef;
    private Party campaignParty;
    // NOTE: items, quests, achievements

    public Campaign()
    {
        this.campaignRef = "";
        this.campaignParty = new Party(this);
    }
}